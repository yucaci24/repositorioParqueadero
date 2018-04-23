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
    public titulo: String;
    public vehiculo: Vehiculo;
    public vehiculos: Vehiculo[];

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private consultasService: ConsultasService
    ){
        this.titulo='Consultar Vehiculo';
        this.vehiculo = new Vehiculo( '', 0, true, 0, null, 0);
    }

    ngOnInit(){       
        console.log('se ha cargado el componente consultar.component.ts')
    }

    onSubmit(){
        this.consultasService.getVehiculo(this.vehiculo.placa).subscribe(
            result => {
                console.log(result);
                this.vehiculos=[result];
            }, 
            error => {
                console.log(<any>error);
            }
        )
        
    }
}