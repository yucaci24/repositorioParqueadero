import { Component } from '@angular/core'
import { Router, ActivatedRoute, Params} from '@angular/router';
import { Vehiculo } from '../models/vehiculo';
import { IngresosService } from '../servicios/ingresos.service';

@Component({
    selector: 'ingresar',
    templateUrl: '../views/ingresar.html',
    providers:[IngresosService]
})

export class IngresarComponent{
    public titulo: string;
    public vehiculo: Vehiculo;
    public deshabilitarCilindraje : boolean = false;

    constructor(
        private ingresosService: IngresosService,
        private route: ActivatedRoute,
        private router: Router
    ){
        this.titulo='Ingresar Vehiculo';
        this.vehiculo = new Vehiculo( '', null, true, 0, null, 0);
    }
    
    ngOnInit(){       
        console.log('se ha cargado el componente ingresar.component.ts') 
    }

    mayus(e) {
        e.value = e.value.toUpperCase();
    }

    onSubmit(){
        console.log(this.vehiculo);
        this.ingresosService.addVehiculo(this.vehiculo).subscribe( 
            response => {
                
                    alert("Vehiculo Ingresado");
                    this.router.navigate(['/paginaPrincipal']);
                
            },
            error => {
                console.log(<any>error);
            }
        )
    }

    onChangeTypeVehicle(type:number){
        this.vehiculo.tipo = type;
        if( type === 1 ){
            this.deshabilitarCilindraje = true;
        }else{
            this.deshabilitarCilindraje = false;
        }
    }
}