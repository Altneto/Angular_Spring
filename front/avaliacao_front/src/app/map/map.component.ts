import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../services/cliente.service';
import { EmitterService } from '../services/emitter.service'

interface Endereco {
  latitude: string,
  longitude: string
}

interface Cliente {
  codigo: number,
  nome: string,
  cnpj: string,
  endereco: Endereco
}

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  cliente: Cliente = {
    codigo: 1,
    nome: '',
    cnpj: '',
    endereco: {
      latitude: '',
      longitude: ''
    }
  };

  codigo: number = 1

  lat: number = 51.678418;
  lng: number = 7.809007;

  constructor( private clientService: ClienteService ) { }

  ngOnInit(): void {
    EmitterService.Emitter.subscribe(codigo => {
      this.codigo = codigo[0];
      this.clientService.findByCode(this.codigo).subscribe(cliente => {
        console.log(cliente);
        this.cliente = cliente;
        this.lat = +this.cliente.endereco.latitude;
        this.lng = +this.cliente.endereco.longitude;
      });
    });
  }



  onMouseOver(infoWindow: any, gm: any) {

    gm.lastOpen = infoWindow;

    infoWindow.open();
  }

  onMouseOut(infoWindow: any, gm: any) {

    gm.lastOpen = infoWindow;

    infoWindow.close();
  }

}
