import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-openuserstories',
  templateUrl: './openuserstories.component.html',
  styleUrls: ['./openuserstories.component.scss']
})
export class OpenuserstoriesComponent {

  @Input() userstories:any;

}
