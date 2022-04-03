import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstComponenetComponent } from './first-componenet/first-componenet.component';

const routes: Routes = [{
  path: 'home',
  component: FirstComponenetComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
