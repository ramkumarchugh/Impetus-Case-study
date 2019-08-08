import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-template',
  templateUrl: './user-template.component.html',
  styleUrls: ['./user-template.component.css']
})
export class UserTemplateComponent implements OnInit {
 getName: any;

  constructor() { }

  ngOnInit() {
    this.getName=localStorage.getItem('name');
  }
 
}
