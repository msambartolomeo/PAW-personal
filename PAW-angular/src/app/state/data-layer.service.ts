import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from '../models/User';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class DataLayerService {

  user: User | undefined;
  // userBs = new BehaviorSubject<User>(undefined);
  price = new BehaviorSubject<number>(0);

  constructor(
    private api: ApiService
  ) {
    this.api.getPrices().subscribe((data) => {
      this.price.next(data);
    })
  }

  getPrices() {
    return this.price.asObservable();
  }

  getUser() {
    return this.user;
  }

  setUser(name: string) {
    this.user = new User(name);
  }
}
