import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';
import { AgmCoreModule } from '@agm/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { MatDialogModule } from '@angular/material/dialog'
import { MatPaginatorModule } from '@angular/material/paginator'

import { env } from 'src/environments/env';
import { PopUpComponent } from './pop-up/pop-up.component';
import { HeaderComponent } from './header/header.component';
import { MapComponent } from './map/map.component';
import { ClientListComponent } from './client-list/client-list.component';

@NgModule({
  declarations: [
    AppComponent,
    PopUpComponent,
    HeaderComponent,
    MapComponent,
    ClientListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    MatDialogModule,
    MatPaginatorModule,
    AgmCoreModule.forRoot({
      apiKey: env.API_KEY,
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
