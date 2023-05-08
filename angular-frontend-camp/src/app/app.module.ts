import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CampListComponent } from './camp-list/camp-list.component';
import { CreateCampComponent } from './create-camp/create-camp.component';
import { FormsModule } from '@angular/forms';
import { CampByCategoryComponent } from './camp-by-category/camp-by-category.component';

@NgModule({
  declarations: [
    AppComponent,
    CampListComponent,
    CampByCategoryComponent,
    CampListComponent,
    CreateCampComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
