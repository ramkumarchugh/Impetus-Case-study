import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { policies } from '../policy';


@Component({
  selector: 'app-policy-table',
  templateUrl: './policy-table.component.html',
  styleUrls: ['./policy-table.component.css']
})
export class PolicyTableComponent implements OnInit, OnDestroy {

  policyId: string;
  policy: any;
  sub: any;
  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.route.paramMap.subscribe(paramMap => {
      this.policyId = paramMap.get('id');
      this.policy = policies[this.policyId];
    });
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

}