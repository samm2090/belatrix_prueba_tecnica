import {Component, OnInit} from '@angular/core';
import {Observable, Subject} from 'rxjs';
import {Router, ActivatedRoute} from '@angular/router';
import {ExchangeService} from '../exchange.service';

@Component({
  templateUrl: './money-exchange.component.html',
  styleUrls: ['./money-exchange.component.css']
})
export class MoneyExchangeComponent implements OnInit {

  amount: number;
  eur: number;
  formattedAmount: number;

  constructor(private exchangeService: ExchangeService) {}

  ngOnInit() {
  }

  calculateExchange() {
    if (this.amount.toString().indexOf('.') > -1) {
      if (this.amount.toString().split(".")[1].length > 4) {
        alert('El numero no debe tener mas de 4 decimales');
      } else {
        this.exchangeService.exchangeAmount(this.amount).subscribe(response => {
          this.eur = response;
        });
      }
    } else {
      this.exchangeService.exchangeAmount(this.amount).subscribe(response => {
        this.eur = response;
      });
    }
  }

}
