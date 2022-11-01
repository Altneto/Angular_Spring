import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { ClienteService } from '../services/cliente.service';
import { ClienteVO } from '../models/clienteVO';

@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.css']
})
export class PopUpComponent implements OnInit {

  constructor(private dialogRef: MatDialogRef<PopUpComponent>, private clienteService: ClienteService) { }

  ngOnInit(): void {
  }

  async save(nome: string, cnpj: string, endereco: string): Promise<void> {
    let client = new ClienteVO(nome, cnpj, endereco);
    this.clienteService.save(client).subscribe(response => {
    });
  }

  closeDialog() {
    this.dialogRef.close();
  }
}
