import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-myopentasks',
  templateUrl: './myopentasks.component.html',
  styleUrls: ['./myopentasks.component.scss']
})
export class MyopentasksComponent {
@Input() mytasks:any;
}
