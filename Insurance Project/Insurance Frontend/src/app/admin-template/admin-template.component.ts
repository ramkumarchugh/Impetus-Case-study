import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-admin-template',
  templateUrl: './admin-template.component.html',
  styleUrls: ['./admin-template.component.css']
})
export class AdminTemplateComponent implements OnInit {
  users: string[];
  policies = [
    { "id": 1, "name": "Life Insurance" },
    { "id": 2, "name": "Dental Insurance" },
    { "id": 3, "name": "Dental and Vision Insurance" }

  ]
  getName: string;
  constructor(private router: Router,private userService: UserService) { }

  ngOnInit() {

    this.userService.getUsers().subscribe(response => this.handleSuccessfulResponse(response))
    this.getName=localStorage.getItem('name');
  }

  handleSuccessfulResponse(response) {

    this.users = response;

  }
}










