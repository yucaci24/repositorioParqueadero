import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { Vehiculo } from '../models/Vehiculo';
import { GLOBAL } from './global';
import 'rxjs/add/operator/map';

@Injectable()
export class ConsultasService {
    public url;
    public placa: String;

    constructor (public http: Http){
        this.url= GLOBAL.url;
    }

    getVehiculo(placa){
        return this.http.get(this.url+'consultas/'+ placa).map(res => res.json());
       
    }
}