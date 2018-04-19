import { Component } from '@angular/core'

@Component({
    selector: 'paginaPrincipal',
    templateUrl: '../views/paginaPrincipal.html'
})

export class PaginaPrincipalComponent{
    public titulo: string;

    constructor(){
        this.titulo='Pagina Principal';
    }

    ngOnInit(){       
        console.log('se ha cargado el componente paginaPrincipal.component.ts')
    }
}