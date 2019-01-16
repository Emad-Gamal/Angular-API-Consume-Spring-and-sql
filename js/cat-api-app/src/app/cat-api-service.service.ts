import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders  } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CatApiService {

  constructor(private http: HttpClient) { }

  getApiCats(page: number)
  {
    return this.http.get('https://api.thecatapi.com/v1/images/search?limit=24&order=Desc&page='+page);
  }
}
