import { Component, OnInit, OnDestroy } from '@angular/core';
import { PremiumService } from '../service/premium.service';
import { Premium } from '../model/premium';
import { ActivatedRoute, Router } from '@angular/router';
import { Options } from 'ng5-slider';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { ApplicationPolicy } from '../model/application-policy';
import { ApplicationPolicyService } from '../service/application-policy.service';
import { policies } from '../policy';
import { RestService } from '../service/rest.service';
import { AuthenticationService } from '../service/authentication.service';
import { User } from '../model/user';


export class Dependent {
  constructor(public dependentName: string, public age: number, public relation: string, public city: string, public state: string, public address: string, public user:User) {

  }
}
export class Application {

  public applicantname: string
  public sumAssured: number
  public noOfYears: number
  public age: number
  public dependents: Dependent[]
  public premium: number
  public salary: string;
  public noOfDependents: number;

  user: User;
    constructor(applicantname: string, sumAssured: number,  noOfYears: number,  age: number,  dependents: Dependent[],  premium: number,  salary: string,  noOfDependents: number) {
      this.applicantname=applicantname;
      this.sumAssured=sumAssured
  }

}
@Component({
  selector: 'application-add',
  templateUrl: './application-add.component.html',
  styleUrls: ['./application-add.component.css']
})
export class ApplicationAddComponent implements OnInit, OnDestroy {
  application: ApplicationPolicy;
  policyTypeId: string;
  policy: any;
  sub: any;
  dependents: any[] = [];
  premiumForm: FormGroup;
  noOfYears: number;

  maxDependent: number;
  maxYears: number;
  options: Options;
  applyEnable: boolean = false;

  premium: Premium;
  public premiumValue: string = "";
  getName: string;
  //noOfDependents: any;
  constructor(private route: ActivatedRoute, private router: Router, private applicationPolicyService: ApplicationPolicyService, private premiumService: PremiumService, private fb: FormBuilder, private restService: RestService, private authService: AuthenticationService) {
    // this.route.snapshot.paramMap.get("id");
    // this.application = new ApplicationPolicy();
    this.premium = new Premium();
  }

  ngOnInit() {
    
    this.sub = this.route.paramMap.subscribe(paramMap => {
      this.policyTypeId = paramMap.get('id');
      this.policy = policies[this.policyTypeId];
      this.fb.array([]);
    });
    this.options = {
      floor: this.policy['low'],
      ceil: this.policy['high']
    };
    // this.maxDependent = this.policy['maxDependents'];
    this.getName=localStorage.getItem('name');
    this.maxYears = this.policy['maxYears'] - 1;
    this.premiumForm = this.fb.group({
      sumAssured: [this.policy['low'], [Validators.required]],
      noOfDependents: [0, [Validators.required]],
      noOfYears: ['1', [Validators.required]],
      age: ['18', [Validators.required]],
      salary: ['5000', [Validators.required]],
      applicantname: ['', [Validators.required, Validators.minLength(3)]],
      dependents: this.fb.array([])
    });
    this.premiumForm.valueChanges.subscribe(val => {
       //this.applyEnable = true;
    })
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }


  onSubmit() {
    let application = <Application>this.premiumForm.value;
    console.info(JSON.stringify(application));
    this.applicationPolicyService.postPolicy(this.application).subscribe();
  }

  addDependent() {

    let control = <FormArray>this.premiumForm.controls.dependents;

    control.push(
      this.fb.group({
        dependentName: ['', Validators.required],
        age: ['', Validators.required],
        relation: ['', Validators.required],
        address: ['', Validators.required],
        state: ['', Validators.required],
        city: ['', Validators.required]
      })
    );

  }



  deleteDependent(index) {

    let control = <FormArray>this.premiumForm.controls.dependents;

    control.removeAt(index);

  }

  genArray(maxValue: number) {
    let dArray = [];
    for (let i = 0; i <= maxValue; i++) {
      dArray[i] = i;
    }
    return dArray;
  }

  calculatePremium() {
    // this.premium = JSON.stringify(this.premiumForm.value);
    this.applyEnable = true;
    //this.noOfDependents = this.premiumForm.get('i');
    
    let control = <FormArray>this.premiumForm.controls.dependents;
    console.log(control.length);
    this.premiumForm.controls.noOfDependents.setValue(control.length);
      this.restService.post('api/insurance/calculate_premium', this.premiumForm.value, null)
    this.premiumService.savePremium(this.premiumForm.value).subscribe(
      data => {
        // console.info("Success response is " + JSON.stringify(data));
        this.premiumValue = JSON.stringify(data);
        // console.info(this.premiumValue);
      },
      error => {
        // console.error("Success response is " + JSON.stringify(error));
      }
    );
  }


  onSubmitApplication() {
  
  }

  apply(){
    let application = <Application>this.premiumForm.value;
    application.user = this.authService.getUser();
    application.noOfDependents = application.dependents.length;

    let deps = application.dependents;
    deps.forEach(d=>{
      d.user = application.user;
      // console.error(JSON.stringify(d));
      this.restService.post<Dependent>("api/user/dependent", d, null).subscribe(data => {
        // console.info("dependent added: " + JSON.stringify(data));
      });
    });

    application.premium = parseInt(this.premiumValue);
    // console.info("Which we sent: " + JSON.stringify(application));
    this.restService.post<Application>("api/application/", application, null).subscribe(data => {
      // console.info("server application: " + JSON.stringify(data));
      this.router.navigate(['/insurance/user/application-view']);
    });
  }
}