import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Pelicula } from './pelicula';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PeliculasService {
  
  url: string;

  constructor(private http: HttpClient) { 
    this.url = 'http://localhost:8080/filmografia';
  }

  public findAllByDirector(director: string): Observable<Pelicula[]> {
    return this.http.get<Pelicula[]>(`${this.url}/listadoPeliculas/${director}`);
  }
}
