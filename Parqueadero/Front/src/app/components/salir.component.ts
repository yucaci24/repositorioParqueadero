import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
/**import { ConsultasService } from '../servicios/consultas.service';*/
import { Vehiculo } from '../models/Vehiculo';

@Component({
    selector: 'salir',
    templateUrl: '../views/salir.html',
    /**providers: [ConsultasService]*/
})

export class SalirComponent{
    public titulo: string;
    public vehiculo: Vehiculo;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        /**private consultasService: ConsultasService*/
    ){
        this.titulo='Salida De Vehiculos';
        
    }
}