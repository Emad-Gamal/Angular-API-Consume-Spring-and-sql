import { Component, OnInit  } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  cats;
  cat;
  title;

  ngOnInit() {

    this.cats=[{
        "breeds": [],
        "categories": [
          {
          "id": 2,
          "name": "space"
          }
        ],
        "id": "4v",
        "url": "https://cdn2.thecatapi.com/images/4v.jpg"
      }];

    this.cats.push({
    "breeds": [],
    "categories": [
    {
    "id": 2,
    "name": "space"
    }
    ],
    "id": "4v",
    "url": "https://cdn2.thecatapi.com/images/4v.jpg"
    }
    ,
    {
    "breeds": [],
    "id": "20f",
    "url": "https://cdn2.thecatapi.com/images/20f.png"
    },
    {
    "id": "4bv",
    "url": "https://cdn2.thecatapi.com/images/4bv.gif"
  }
)

    this.cat = {
      "breeds": [],
      "categories": [
        {
        "id": 2,
        "name": "space"
        }
      ],
      "id": "4v",
      "url": "https://cdn2.thecatapi.com/images/4v.jpg"
    }

    this.title = 'cat-api-app';
  }


}
