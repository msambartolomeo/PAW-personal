import { Component, OnInit } from '@angular/core';
import { DataLayerService } from 'src/app/state/data-layer.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  constructor(
    public dataLayer: DataLayerService  
  ) { }

  ngOnInit(): void {
  }

}
