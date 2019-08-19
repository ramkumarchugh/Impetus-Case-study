import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';

import { FormGroup, FormControl, FormArray, Validators, RequiredValidator } from '@angular/forms';

import { FormBuilder } from '@angular/forms';

import { ForbiddenNameValidator } from '../shared/user-name.validator';

import { PasswordValidator } from '../shared/password.validator';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
user:User;
registrationForm: FormGroup;

  constructor(private fb: FormBuilder,private route:ActivatedRoute, private router:Router,private _userService:UserService) {
    this.user=new User();
  }
   
  
  
  ngOnInit() {
  
  this.registrationForm = this.fb.group({
  
  name: ['', [Validators.required,
  Validators.minLength(3), ForbiddenNameValidator(/password/)]],
  
  password: ['',[Validators.required] ],
  
  confirmPassword: ['',[Validators.required]],
  
  email: ['',[Validators.required,
  Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')]],
  
  subscribe: [false],
  
  dob: ['',[Validators.required]],
  
  mobNo: ['',[Validators.required,
  Validators.minLength(10),Validators.maxLength(10),
  Validators.pattern('[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')]],
  
  city: ['',[Validators.required,
  Validators.pattern('[a-zA-Z]+') ]],
  
  state: ['', [Validators.required,
  Validators.pattern('[a-zA-Z]+')]],
  
  // postalCode: [''],
  
  address: ['', [Validators.required,
  Validators.minLength(5)]]
  
  
  }, { validator: PasswordValidator});
  
  
  
  
  this.registrationForm.get('subscribe').valueChanges
  
  .subscribe(checkedValue => {
  
  const email = this.registrationForm.get('email');
  
  if (checkedValue) {
  
  email.setValidators(Validators.required);
  
  } else {
  
  email.clearValidators();
  
  }
  
  email.updateValueAndValidity();
  
  });
  
  }
  
  
  
  
  get name() {
  
  return this.registrationForm.get('name');
  
  }
  
  
  
  
  get email() {
  
  return this.registrationForm.get('email');
  
  }
  
  get date() {
  
  return this.registrationForm.get('dob');
  
  }
  
  get contactNumber() {
  
  return this.registrationForm.get('mobNo');
  
  }
  
  get city() {
  
  return this.registrationForm.get('city');
  
  }
  
  get state() {
  
  return this.registrationForm.get('state');
  
  }
  
  // get postalCode() {
  
  // return this.registrationForm.get('postalCode');
  
  // }
  
  get address() {
  
  return this.registrationForm.get('address');
  
  }
  
  
  
  

  
  loadAPIData() {
  
  this.registrationForm.patchValue({
  
  name: 'Bruce',
  
  password: 'test',
  
  confirmPassword: 'test'
  
  });
  
  }
  
  
  
  
  onSubmit() {
    // this.router.navigate()
  
  // console.log(this.registrationForm.value);
//  alert("You have successfully registered, Please Login")
//  this.router.navigate(['insurance/login'])
  
  this._userService.save(this.registrationForm.value)
  
  
  .subscribe(
  
  response => {console.log('Success!',
  response)
  //alert("You have successfully registered, Please Login")
  this.router.navigate(['insurance/login'])
}
  ,
  
  error => {
  //   console.error('Error!',
  // error)
  // console.log('--------------------------------------',error.status);
 if(error.status === 500){
alert("userEmail already exists"); 
}
  }
  );
  
  }
  
  
  
  
  }
  