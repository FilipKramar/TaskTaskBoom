import { Component,Input} from '@angular/core';

@Component({
  selector: 'app-alltasks',
  templateUrl: './alltasks.component.html',
  styleUrls: ['./alltasks.component.scss']
})
export class AlltasksComponent { 
@Input() alltasks:any;

}
