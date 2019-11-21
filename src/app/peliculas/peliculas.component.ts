import { Component, OnInit } from '@angular/core';
import { PeliculasService } from '../peliculas.service';
import { Pelicula } from '../pelicula';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-peliculas',
  templateUrl: './peliculas.component.html',
  styleUrls: ['./peliculas.component.css']
})
export class PeliculasComponent implements OnInit {
  
  listadoPeliculas: Pelicula[];

  director: string;
  constructor(private peliculaService: PeliculasService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.director = this.route.snapshot.params['director'];
    this.peliculaService.findAllByDirector(this.director).subscribe(data => {
      this.listadoPeliculas = data;
    });
  }

}
