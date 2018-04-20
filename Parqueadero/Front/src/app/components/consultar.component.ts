import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConsultasService } from '../servicios/consultas.service';
import { Vehiculo } from '../models/Vehiculo';

@Component({
    selector: 'consultar',
    templateUrl: '../views/consultar.html',
    providers: [ConsultasService]
})

export class ConsultarComponent{
    public titulo: string;
    public vehiculo: Vehiculo;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private consultasService: ConsultasService
    ){
        this.titulo='Consultar Vehiculo';
        
    }

   /** ngOnInit(){       
        console.log('se ha cargado el componente consultar.component.ts')
        this.consultasService.getVehiculos().subscribe(
            result =>{
                console.log(result);    
            },
            error =>{
                console.log(<any>error);
            }
        )
    }*/
}