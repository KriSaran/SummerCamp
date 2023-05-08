import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CampDetailComponent } from './camp-detail/camp-detail.component';
import { CampListComponent } from './camp-list/camp-list.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';

const routes: Routes = [

  {path: 'camp-list', pathMatch: 'full', component: CampListComponent  },
  {path: 'camp-detail/:id', pathMatch: 'full', component: CampDetailComponent  },
  {path:'forgot-passoword',pathMatch:'full',component:ForgotPasswordComponent},
  {path: '', pathMatch: 'full', redirectTo: '/camp-list'  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
