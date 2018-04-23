import { Component } from '@angular/core'
import { Router, ActivatedRoute, Params} from '@angular/router';
import { Vehiculo } from '../models/Vehiculo';
import { IngresosService } from '../servicios/ingresos.service';

@Component({
    selector: 'ingresar',
    templateUrl: '../views/ingresar.html',
    providers:[IngresosService]
})

export class IngresarComponent{
    public titulo: string;
    public vehiculo: Vehiculo;

    constructor(
        private _ingresosService: IngresosService,
        private _route: ActivatedRoute,
        private _router: Router
    ){
        this.titulo='Ingresar Vehiculo';
        this.vehiculo = new Vehiculo( '', 0, true, 0);
    }

    ngOnInit(){       
        console.log('se ha cargado el componente ingresar.component.ts') 
    }

    onSubmit(){
        console.log(this.vehiculo);
        this._ingresosService.addVehiculo(this.vehiculo).subscribe( 
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
    }

    onclick(){
        
    }

}