import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fila',
  templateUrl: './fila.component.html',
  styleUrls: ['./fila.component.scss']
})
export class FilaComponent implements OnInit {

  @Input()
  counter = 15;

  // Cualquier parametro aca es inyectado
  constructor(private router: Router) { }

  ngOnInit(): void {

  }

  colarse() {
    this.counter--;
    if (this.counter === 0) {
      this.router.navigate(['menu']);
    }
  }

}
