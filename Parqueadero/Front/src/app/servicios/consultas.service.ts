import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { Vehiculo } from '../models/Vehiculo';
import { GLOBAL } from './global';
import 'rxjs/add/operator/map';

@Injectable()
export class ConsultasService {

    private apiUrl = 'http://localhost:8080/consultas';

    public url: string;

    constructor (public http: Http){
    }

    getVehiculos(){
        return this.http.get(this.url+'consultas/').map(res => res.json());
    }
}