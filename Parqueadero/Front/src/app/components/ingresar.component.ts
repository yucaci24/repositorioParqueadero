import { Component } from '@angular/core'
import { Router, ActivatedRoute, Params} from '@angular/router';

import { ConsultasService} from '../servicios/consultas.service';
import { Vehiculo } from '../models/Vehiculo';

@Component({
    selector: 'ingresar',
    templateUrl: '../views/ingresar.html',
    providers:[ConsultasService]
})

export class IngresarComponent{
    public titulo: string;
    public vehiculo: Vehiculo;

    constructor(){
        this.titulo='Ingresar Vehiculo';
        this.vehiculo = new Vehiculo( '', 0, true, 0, null);
    }

    ngOnInit(){       
        console.log('se ha cargado el componente ingresar.component.ts') 
    }

    onSubmit(){
        console.log(this.vehiculo);
    }
}