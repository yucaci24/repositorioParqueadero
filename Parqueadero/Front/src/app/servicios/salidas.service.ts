import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { Vehiculo } from '../models/Vehiculo';
import { GLOBAL } from './global';
import 'rxjs/add/operator/map';

@Injectable()
export class SalidasService {

    public url;
    public placa: String;
    public estado: JSON;
    

    constructor (public http: Http){
        this.url= GLOBAL.url;
    }

    patchVehiculo(placa ){
        let json = JSON.stringify(placa);
        let headers = new Headers({'Content-Type': 'application/json'});
        var response = this.http.patch(this.url+'salidas/'+ placa, json, { headers: headers});
        return response.map(x => x.json());
    }
}