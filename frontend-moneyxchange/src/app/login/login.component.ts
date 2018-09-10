import {Component, OnInit} from '@angular/core';
import {User} from '../user';
import {Observable, Subject} from 'rxjs';
import {LoginService} from '../login.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = {username: '', password: ''};

  constructor(private loginService: LoginService, private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit() {
  }

  login() {
    this.loginService.validateUser(this.user).subscribe(response => {
      if (response) {
        this.router.navigate(['moneyExchange']);
      } else {
        alert('Credenciales invalidas');
      }
    });
  }

}
