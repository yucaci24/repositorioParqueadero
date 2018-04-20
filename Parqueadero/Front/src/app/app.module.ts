import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { routing, appRoutingProviders } from  './app.routing';

import { AppComponent } from './app.component';
import { IngresarComponent } from './components/ingresar.component';
import { ConsultarComponent } from './components/consultar.component';
import { PaginaPrincipalComponent } from './components/paginaPrincipal.component';
import { SalirComponent } from './components/salir.component';


@NgModule({
  declarations: [
    AppComponent,
    IngresarComponent,
    PaginaPrincipalComponent,
    ConsultarComponent,
    SalirComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [
    appRoutingProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
