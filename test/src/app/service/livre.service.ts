import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LivreService {

  constructor(private http: HttpClient) { }

  getAllLivre(){
    return this.http.get("http://localhost:8080/api/livres");
  }
}
