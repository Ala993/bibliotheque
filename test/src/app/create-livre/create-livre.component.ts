import { Component, OnInit } from '@angular/core';
import { ILivre, Livre } from '../models/livre.model';
import { CategoriesService } from '../service/categories.service';

@Component({
  selector: 'app-create-livre',
  templateUrl: './create-livre.component.html',
  styleUrls: ['./create-livre.component.css']
})
export class CreateLivreComponent implements OnInit {
  categories:any[] = [];
  livre = new Livre();
  constructor(private categoryService: CategoriesService) { }

  ngOnInit(): void {
    this.categoryService.getAllCategories().subscribe(res => {
      //@ts-ignore
      this.categories = res;
      console.log(this.categories);
       
    })
  }

}
