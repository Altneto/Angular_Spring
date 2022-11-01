import { Component, OnInit } from '@angular/core';
import { EmitterService } from '../services/emitter.service';
import { ClienteService } from '../services/cliente.service';
import { PageEvent } from '@angular/material/paginator';

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
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  constructor(private clienteService: ClienteService) { }

  c = [{codigo: 1, nome: ''}];
  clientes = [];
  clis: string[] = [];
  filter: string = '';
  page: number = 0;
  size: number = 10;
  length: number = 50;

  ngOnInit(): void {
    this.search();

    EmitterService.Emitter.subscribe(clientes => {
      this.clientes = clientes
      this.clientes.forEach(cliente => {
        let cli: Cliente = cliente
        this.c.push({codigo: cli.codigo, nome: cli.nome})
      });
    });
  }

  onClick(codigo: number): void {
    let codigos: number[] = []
    codigos.push(codigo)
    EmitterService.Emitter.emit(codigos)
  }

  search() {
    this.clienteService.search(this.filter, this.page, this.size).subscribe(clientes => {
      this.clientes = clientes.content;
      this.clientes.forEach(cliente => {
        let cli: Cliente = cliente;
        this.c.push({codigo: cli.codigo, nome: cli.nome});
        this.size = clientes.size;
        this.length = clientes.totalElements;
      });
    });
  }

  pageEvent(event: PageEvent) {
    this.page = event.pageIndex;
    this.c.length = 0;
    this.search();
  }
}
