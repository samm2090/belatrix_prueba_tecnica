import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

export class ExchangeService {

  private exchangeUrl = 'http://localhost:8080/moneyxchange-backend/currencyExchange/exchangeCurrency';

  constructor(private http: HttpClient) {}

  exchangeAmount(amount: number) {

    const url = this.exchangeUrl + '?amount=' + amount + '&idCurrencyIn=1&idCurrencyOut=2';

    return this.http.get<any>(url).pipe(map(response => {
      return response;
    }));
  }
}
