import {Category } from './category'

export class Cat implements Cat{

  id: string;
  url: string;
  categories?:Category[];
  breeds?: string[];

  constructor(item: Cat) {
        if (item != undefined) {
            for (let key in item) {
                try { this[key] = item[key]; }
                catch (e) { }
            }
        }
    }

}
