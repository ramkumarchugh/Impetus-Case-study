import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Options } from 'ng5-slider';
import { policies } from '../policy';
import { PremiumService } from '../service/premium.service';
import { Premium } from '../model/premium';
import { RestService } from '../service/rest.service';

@Component({
  selector: 'app-generic-plan-details',
  templateUrl: './generic-plan-details.component.html',
  styleUrls: ['./generic-plan-details.component.css']
})
export class GenericPlanDetailsComponent implements OnInit {

  policyTypeId: string;
  sub: any;
  premiumForm: FormGroup;
  options: Options;
  maxDependent: number;
  maxYears: number;
  policy: any;
  premium: Premium;
  applyEnable: boolean = false;
  public premiumValue:string = "";
  constructor(private route: ActivatedRoute, private fb: FormBuilder, private router: Router, private premiumService: PremiumService,private restService:RestService) { 
    this.premium = new Premium();
    
  }

  ngOnInit() {
    this.sub = this.route.paramMap.subscribe(paramMap => {
      this.policyTypeId = paramMap.get('id');
      this.policy = policies[this.policyTypeId];
    });
    this.options = {
      floor: this.policy['low'],
      ceil: this.policy['high']
    };
    this.maxDependent = this.policy['maxDependents'];
    this.maxYears = this.policy['maxYears'] - 1;
    this.premiumForm = this.fb.group({
      sumAssured: [this.policy['low'], [Validators.required]],
      noOfDependents: ['0', [Validators.required]],
      noOfYears: ['1', [Validators.required]],
      age: ['18', [Validators.required]]
    });
    this.premiumForm.valueChanges.subscribe(val => {
      this.applyEnable = false;
    });
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }


  calculatePremium() {
    // this.premium = JSON.stringify(this.premiumForm.value);
    this.applyEnable = true;
    // console.info("Input=" + JSON.stringify(this.premiumForm.value));
    // this.premiumService.savePremium(this.premiumForm.value);
    this.restService.post('api/insurance/calculate_premium',this.premiumForm.value,null)
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

  genArray(maxValue: number) {
    let dArray = [];
    for (let i = 0; i <= maxValue; i++) {
      dArray[i] = i;
    }
    return dArray;
  }

  apply() {
    this.router.navigate(['/insurance/user/application-add/' + this.policyTypeId]);
  }
}
