import { Component, OnInit } from '@angular/core';
import { LivreService } from '../service/livre.service';

@Component({
  selector: 'app-first-componenet',
  templateUrl: './first-componenet.component.html',
  styleUrls: ['./first-componenet.component.css']
})
export class FirstComponenetComponent implements OnInit {
  livres: any[] = []
  constructor(
    private livreService: LivreService
  ) { }

  ngOnInit(): void {
this.livreService.getAllLivre().subscribe(res => {
  console.log(res);
  //@ts-ignore
  this.livres = res
})
  }

}
