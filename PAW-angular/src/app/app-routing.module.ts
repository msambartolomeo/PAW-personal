import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FilaComponent } from './pages/fila/fila.component';
import { MenuComponent } from './pages/menu/menu.component';

const routes: Routes = [
  {path: "fila", component: FilaComponent},
  {path: "menu", component: MenuComponent},
  {path: "**", redirectTo: "/fila", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
