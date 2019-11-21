import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Pelicula } from './pelicula';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PeliculasService {
  
  registroDirectores: string[] = [];
  url: string;

  constructor(private http: HttpClient) { 
    this.url = 'http://localhost:8080/filmografia';
  }

  public registrarBusqueda(director: string): string[]{
    this.registroDirectores.push(director);
    return this.registroDirectores;
  }

  public eliminarRegistro(): void{
    this.registroDirectores = [];
  }

  public findAllByDirector(director: string): Observable<Pelicula[]> {
    return this.http.get<Pelicula[]>(`${this.url}/listadoPeliculas/${director}`);
  }

}
