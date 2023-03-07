import { Component } from '@angular/core';

import { User } from './../models/user';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {
  users: User[] = [
    { _id: "1", name: "Mateus", email: "mateus@email.com", password: "123"}
  ];
  displayedColumns = ['name', 'email'];

  constructor() {

  }

}
