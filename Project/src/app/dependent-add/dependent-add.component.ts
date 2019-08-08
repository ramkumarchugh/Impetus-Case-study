import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';

@Component({
  selector: 'app-dependent-add',
  templateUrl: './dependent-add.component.html',
  styleUrls: ['./dependent-add.component.css']
})
export class DependentAddComponent implements OnInit {
  appForm: FormGroup;




  constructor(private fb: FormBuilder) {

    this.appForm = this.fb.group({

      applicantname: ['', Validators.required],

      dependents: this.fb.array([])

    })

  }


  ngOnInit() {

  }

  onSubmit() {

    alert(JSON.stringify(this.appForm.value));

  }

  addDependent() {

    let control = <FormArray>this.appForm.controls.dependents;

    control.push(

      this.fb.group({

        name: ['', Validators.required],

        age: ['', Validators.required]

      })

    );

  }




  deleteDependent(index) {

    let control = <FormArray>this.appForm.controls.dependents;

    control.removeAt(index);

  }




}

