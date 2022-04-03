import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateLivreComponent } from './create-livre/create-livre.component';
import { EmpruntesComponent } from './empruntes/empruntes.component';
import { EtudiantsComponent } from './etudiants/etudiants.component';
import { HomeComponent } from './home/home.component';
import { LivresComponent } from './livres/livres.component';
import { ProfesseursComponent } from './professeurs/professeurs.component';

const routes: Routes = [{
  path: 'livres',
  component: LivresComponent
},
{
  path: "home",
  component: HomeComponent
},
{
  path: "etudiants",
  component: EtudiantsComponent
},
{
  path: "enseignants",
  component: ProfesseursComponent
},
{
  path: "empruntes",
  component: EmpruntesComponent
},
{
  path: "createLivre",
  component: CreateLivreComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
