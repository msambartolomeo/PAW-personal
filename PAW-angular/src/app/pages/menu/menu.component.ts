import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/state/api.service';
import { DataLayerService } from 'src/app/state/data-layer.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  menu = [
    {name: 'jamon', price: '10'},
    {name: 'pollo', price: '20'},
    {name: 'pescado', price: '30'},
    {name: 'cerdo', price: '40'},
  ]

  constructor(
    public dataLayer: DataLayerService,
    public api: ApiService
  ) { }

  // esto se actualiza con desde la api
  price = 0;

  ngOnInit(): void {
    this.dataLayer.getPrices().subscribe((data) => {
        this.price = data;
        console.log(data);
      }
    )
  }

}
