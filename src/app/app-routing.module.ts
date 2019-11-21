import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PeliculasComponent } from './peliculas/peliculas.component';
import { InfoComponent } from './info/info.component';
import { ConsultaDirectorComponent } from './consultaDirector/consultaDirector.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  {path: 'consulta', component: ConsultaDirectorComponent},
  {path: 'info', component: InfoComponent},
  {path: 'consulta/:director', component: PeliculasComponent},
  {path: 'login', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
