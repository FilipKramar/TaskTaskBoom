package com.atos.projektpraksa.task.service;

import com.atos.projektpraksa.enums.Priority;
import com.atos.projektpraksa.enums.Status;
import com.atos.projektpraksa.task.dto.*;
import com.atos.projektpraksa.task.model.Task;
import com.atos.projektpraksa.task.repository.TaskRepository;
import com.atos.projektpraksa.user.model.User;
import com.atos.projektpraksa.user.repository.UserRepository;
import com.atos.projektpraksa.userstory.model.Userstory;
import com.atos.projektpraksa.usertask.model.UserTask;
import com.atos.projektpraksa.usertask.repository.UserTaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserTaskRepository userTaskRepository;
    private final UserRepository userRepository;

    @Transactional
    public Task createANewTask(TaskCreationDTO taskCreationDTO) {
        Task task = new Task();

        if (taskCreationDTO.getUser_id() != null) {
            User user = userRepository.findById(taskCreationDTO.getUser_id())
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + taskCreationDTO.getUser_id()));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            task = Task.builder()
                    .description(taskCreationDTO.getDescription())
                    .priority(taskCreationDTO.getPriority())
                    .status(Status.NEW)
                    .complexity(0L)
                    .build();

            task = taskRepository.save(task);

            UserTask userTask = UserTask.builder()
                    .last_edit(timestamp)
                    .task(task)
                    .assignee(user)
                    .build();


            userTaskRepository.save(userTask);

            task.setAssignee(userTask);

            task = taskRepository.save(task);

            user.getTasks().add(userTask);

            userRepository.save(user);


        } else {
            task = Task.builder()
                    .description(taskCreationDTO.getDescription())
                    .priority(taskCreationDTO.getPriority())
                    .status(Status.NEW)
                    .complexity(0L)
                    .assignee(null)
                    .build();

            taskRepository.save(task);
        }

        return task;

    }

    public List<TaskListingDTO> getAllTasks() {


        List<Task> tasks=taskRepository.findAll();

        List<TaskListingDTO>listedTasks=new ArrayList<>();

        for(Task task:tasks){
            if(task.getAssignee()!=null){

            TaskListingDTO taskListingDTO= TaskListingDTO.builder()
                    .id(task.getId())
                    .description(task.getDescription())
                    .status(task.getStatus())
                    .username(task.getAssignee().getAssignee().getUsername())
                    .build();
            listedTasks.add(taskListingDTO);
        }else{
                TaskListingDTO taskListingDTO= TaskListingDTO.builder()
                        .id(task.getId())
                        .description(task.getDescription())
                        .status(task.getStatus())
                        .username(null)
                        .build();
                listedTasks.add(taskListingDTO);
            }

            }

        return listedTasks;

    }

    @Transactional
    public UserTask editTaskAssignee(TaskEditAssigneeDTO request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = userRepository.findById(request.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + request.getUserid()));

        Task task = taskRepository.findById(request.getTaskid())
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + request.getTaskid()));

        Optional<UserTask> userTaskOptional = userTaskRepository.findByTaskId(request.getTaskid());
        if (userTaskOptional.isPresent()) {
            UserTask existingUserTask = userTaskOptional.get();
            existingUserTask.setAssignee(user);
            existingUserTask.setLast_edit(timestamp);
            userTaskRepository.save(existingUserTask);
            user.getTasks().add(existingUserTask);
            userRepository.save(user);
            return existingUserTask;
        } else {
            UserTask userTask = UserTask.builder()
                    .task(task)
                    .assignee(user)
                    .last_edit(timestamp)
                    .build();

            userTaskRepository.save(userTask);
            user.getTasks().add(userTask);
            userRepository.save(user);
            return userTask;
        }
    }


    @Transactional
    public Task editTask(TaskEditDTO request) {

        Task task = taskRepository.findById(request.getTaskEditAssigneeDTO().getTaskid())
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + request.getTaskEditAssigneeDTO().getTaskid()));

        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setComplexity(request.getComplexity());
        task.setPriority(request.getPriority());

        editTaskAssignee(request.getTaskEditAssigneeDTO());
        return task;
    }

    public TaskGetDTO getTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));


        TaskGetDTO taskGetDTO=new TaskGetDTO();
 if(task.getAssignee()!=null){
     User user = userRepository.findById(task.getAssignee().getAssignee().getId())
             .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
        taskGetDTO = new TaskGetDTO();
        taskGetDTO.setTask_id(task.getId());
        taskGetDTO.setDescription(task.getDescription());
        taskGetDTO.setStatus(task.getStatus());
        taskGetDTO.setPriority(task.getPriority());
        taskGetDTO.setComplexity(task.getComplexity());
        taskGetDTO.setUser_id(user.getId());
        taskGetDTO.setUsername(user.getUsername());
 }
 else{
     taskGetDTO = new TaskGetDTO();
     taskGetDTO.setTask_id(task.getId());
     taskGetDTO.setDescription(task.getDescription());
     taskGetDTO.setStatus(task.getStatus());
     taskGetDTO.setPriority(task.getPriority());
     taskGetDTO.setComplexity(task.getComplexity());
     taskGetDTO.setUser_id(null);
     taskGetDTO.setUsername(null);

 }

        return taskGetDTO;
    }

    public Task test() {
        Task task = Task.builder()
                .description("Ovo je neki opis testni da vidimo jel radi")
                .complexity(0L)
                .status(Status.NEW)
                .priority(Priority.HIGH)
                .build();

        return task;
    }

    public List<Task> getTasks(List<Long> taskids) {

        List<Task> tasks=new ArrayList<>();

        for(Long taskid:taskids){
            Optional<Task> optionalTask=taskRepository.findById(taskid);
            if(optionalTask.isPresent()){

                tasks.add(optionalTask.get());
            }

        }
        return tasks;
    }

    public void bindTaskToUserstory(Userstory userstory,List<Long>taskids) {
        for(Long taskId:taskids){
            Optional<Task> optionalTask=taskRepository.findById(taskId);
            if(optionalTask.isPresent()){
                optionalTask.get().setUserstory(userstory);
                taskRepository.save(optionalTask.get());
            }
        }
    }
}
