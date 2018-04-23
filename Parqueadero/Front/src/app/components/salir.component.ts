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

    constructor(
        private _salidasService: SalidasService,
        private _route: ActivatedRoute,
        private _router: Router
    ){
        this.titulo='Ingresar Vehiculo';
        this.vehiculo = new Vehiculo( '', 0, false, 0);
    }

    ngOnInit(){       
        console.log('se ha cargado el componente salir.component.ts') 
    }

    /**onSubmit(){
        console.log(this.vehiculo);
        this._salidasService.patchVehiculo(this.vehiculo).subscribe( 
            response => {
                if (response.code == 200){
                    this._router.navigate(['/paginaPrincipal']);
                }else{
                    console.log(response);
                }
            },
            error => {
                console.log(<any>error);
            }
        )
    }*/
}