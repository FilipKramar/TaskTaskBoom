import { Component } from '@angular/core';

@Component({
  selector: 'app-taskboard',
  templateUrl: './taskboard.component.html',
  styleUrls: ['./taskboard.component.scss'],
})
export class TaskboardComponent {
  stories: any[] = [];
  tasks: string[] = [''];
  taskLists: string[][] = [[]];

  addStory() {
    const newStory = {
      status: 'Not done',
      id: `StoryID${this.stories.length + 1}`,
      subject: `User story description${this.stories.length + 1}`,
      assigned_to_id: `JohnDoe${this.stories.length + 1}`,
      complexity: `complx${this.stories.length + 1}`,
      tasks: [],
    };
    this.stories.push(newStory);
  }

  addTask(storyIndex: number) {
    const newTask = this.tasks[storyIndex];

    if (newTask.trim() !== '') {
      // Add the task to the tasks array of the corresponding story
      this.stories[storyIndex].tasks.push(newTask);
      this.tasks[storyIndex] = ''; // Clear the input field
    }
  }
}
