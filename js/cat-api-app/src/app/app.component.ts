import { Component, OnInit  } from '@angular/core';
import {  Cat } from './cat';
import { CatApiService } from './cat-api-service.service'


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [CatApiService]
})
export class AppComponent implements OnInit{

  cats:Cat[] = [];
  cat;
  title;
  page:number = 1;

  constructor(private catApiService: CatApiService) { }


  ngOnInit() {
    // To call api for initial image rendering
    this.getCats();
  }

  // To get image data from api
  getCats() {
    console.log(this.page);
    this.catApiService.getApiCats(this.page).subscribe((res) => this.onSuccess(res));
  }

  // When we got data on a success
  onSuccess(res) {
    console.log(res);
    if (res != undefined) {
      res.forEach(item => {
        this.cats.push(new Cat(item));
      });
    }
  }

  // When scroll down the screen
  onScroll()
  {
    console.log("Scrolled");
    this.page = this.page + 1;
    this.getCats();
  }
}
