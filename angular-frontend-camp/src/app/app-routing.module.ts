import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CampDetailComponent } from './camp-detail/camp-detail.component';
import { CampListComponent } from './camp-list/camp-list.component';

const routes: Routes = [

  {path: 'camp-list', pathMatch: 'full', component: CampListComponent  },
  {path: 'camp-detail', pathMatch: 'full', component: CampDetailComponent  },
  {path: '', pathMatch: 'full', redirectTo: '/camp-list'  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
