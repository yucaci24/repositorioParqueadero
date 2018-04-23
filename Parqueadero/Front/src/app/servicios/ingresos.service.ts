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

    addVehiculo(vehiculo: Vehiculo){
        let json = JSON.stringify(vehiculo);
        let headers = new Headers({'Content-Type': 'application/json'});
        var response = this.http.post(this.url + 'ingresos', json, { headers: headers});
        console.log(response);
        return response.map(x => x.json());
    }
}