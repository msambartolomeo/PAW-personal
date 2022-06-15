import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataLayerService } from 'src/app/state/data-layer.service';

@Component({
  selector: 'app-fila',
  templateUrl: './fila.component.html',
  styleUrls: ['./fila.component.scss']
})
export class FilaComponent implements OnInit {

  @Input()
  counter = 1;

  // Cualquier parametro aca es inyectado
  constructor(
    private router: Router,
    public dataLayer: DataLayerService  
  ) { }

  ngOnInit(): void {
    this.dataLayer.setUser('mauro');
  }

  colarse() {
    this.counter--;
    if (this.counter === 0) {
      this.router.navigate(['menu']);
    }
  }

}
