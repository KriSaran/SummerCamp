import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CampListComponent } from './camp-list/camp-list.component';
import { CreateCampComponent } from './create-camp/create-camp.component';
import { ViewMyFavoritesComponent } from './view-my-favorites/view-my-favorites.component';

const routes: Routes = [
  //javascript object
  {path:'camps', component: CampListComponent},
  {path:'create-camp', component: CreateCampComponent},
  {path:'', redirectTo:'camps', pathMatch:'full'},
  {path:'view-my-favorites', component: ViewMyFavoritesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
