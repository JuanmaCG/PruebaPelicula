import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { PeliculasComponent } from './peliculas/peliculas.component';


const routes: Routes = [
  {path: 'index', component: IndexComponent},
  {path: 'listado/:director', component: PeliculasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
