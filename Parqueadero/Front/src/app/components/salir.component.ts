import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
/**import { ConsultasService } from '../servicios/consultas.service';*/
import { Vehiculo } from '../models/Vehiculo';
import { SalidasService } from '../servicios/salidas.service';

@Component({
    selector: 'salir',
    templateUrl: '../views/salir.html',
    providers: [SalidasService]
})

export class SalirComponent{
    public titulo: string;
    public vehiculo: Vehiculo;
    public vehiculos: Vehiculo[];
    

    constructor(
        private salidasService: SalidasService,
        private route: ActivatedRoute,
        private router: Router
    ){
        this.titulo='Salida De Vehiculos';
        this.vehiculo = new Vehiculo( '', 0, false, 0, null, 0);
    }

    ngOnInit(){       
        console.log('se ha cargado el componente salir.component.ts') 
    }

    onSubmit(){
        this.salidasService.patchVehiculo(this.vehiculo.placa).subscribe(
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
