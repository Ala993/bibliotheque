export interface ILivre {
    id?: number;
    name?: string;
    author?: string;
    category?: string;
}

export class Livre {
  
   constructor(
    public id?: number,
    public name?: string,
    public author?: string,
    public category?: string,
 
   ){}
}