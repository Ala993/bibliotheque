import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LivreService } from '../service/livre.service';

@Component({
  selector: 'app-livres',
  templateUrl: './livres.component.html',
  styleUrls: ['./livres.component.css']
})
export class LivresComponent implements OnInit {

  livres: any[] = []
  constructor(
    private livreService: LivreService,
    private router: Router
  ) { }

  ngOnInit(): void {
this.livreService.getAllLivre().subscribe(res => {
  console.log(res);
  //@ts-ignore
  this.livres = res
})
  }
  goToCreatePage(){
    this.router.navigate(['/createLivre'])
  }
}
