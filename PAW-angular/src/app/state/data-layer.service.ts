import { Injectable } from '@angular/core';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class DataLayerService {

  user: User | undefined;

  constructor() { }

  getUser() {
    return this.user;
  }

  setUser(name: string) {
    this.user = new User(name);
  }
}
