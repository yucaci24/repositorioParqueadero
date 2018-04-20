import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { Vehiculo } from '../models/Vehiculo';
import { GLOBAL } from './global';
import 'rxjs/add/operator/map';

@Injectable()
export class IngresosService{
    public url;

    constructor (public http: Http){
        this.url= GLOBAL.url;
    }

   /** getVehiculos(){
        return this.http.get(this.url+'consultas/').map(res => res.json());
    }*/

    addVehiculo(vehiculo: Vehiculo){
        let json = JSON.stringify(vehiculo);
        let params = 'json=' +json;
        let headers = new Headers({'Content-Type': 'application/x-www-form-urlencoded'});

       return this.http.post(this.url+'ingresos', params,{headers: headers})
       .map(res => res.json());
    }
}