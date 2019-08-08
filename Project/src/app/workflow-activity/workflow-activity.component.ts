import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-workflow-activity',
  templateUrl: './workflow-activity.component.html',
  styleUrls: ['./workflow-activity.component.css']
})
export class WorkflowActivityComponent implements OnInit {
  @Input()borderType:string;

  constructor() { }

  ngOnInit() {
    if(this.borderType==null){
      this.borderType = "border-success";
    }
  }
}
