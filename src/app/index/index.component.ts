import { Component, OnInit } from '@angular/core';
import { PeliculasService } from '../peliculas.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  director: string;

  onSubmit(){
    this.router.navigate(['listado', this.director]);
  }
  constructor(private router: Router) { }

  ngOnInit() {
  }

}
