import {User} from './user';
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Observable, of} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl = 'http://localhost:8080/moneyxchange-backend/authentication/validate';

  constructor(private http: HttpClient) {}

  validateUser(user: User) {
    const json = JSON.stringify({username: user.username, password: user.password});

    return this.http.post<any>(this.loginUrl, json, httpOptions).pipe(map(response => {
      return response;
    }));
  }

}
