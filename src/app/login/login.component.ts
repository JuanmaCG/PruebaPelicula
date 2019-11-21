import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Usuario } from '../usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario: string;
  password: string;
  usuarioLogeado: Usuario;

  usuarioBBDD: Usuario;

  constructor(private loginService: LoginService) {}

  validarLogin(){
    this.usuarioLogeado.usuario = this.usuario;
    this.usuarioLogeado.password = this.password;
    this.loginService.getUsuario(this.usuario).subscribe(data => {
      this.usuarioBBDD = data;
    });
    // this.loginService.crearUsuario(this.usuarioLogeado).subscribe();
  }

  ngOnInit() {
    this.usuarioLogeado = new Usuario();
    this.usuarioBBDD = new Usuario();
  }

}
