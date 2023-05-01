import { Component,ViewEncapsulation } from '@angular/core';
import { Camp } from './camp';
import { CampService } from './camp.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation:ViewEncapsulation.None
})

export class AppComponent {
  title = 'Explore Camps';
  
  public camps : Camp[] = [];

 constructor(private campService: CampService){}

 public getCamp() {
  this.campService.getCamp(1);// 1 - dummy data
 }

}
