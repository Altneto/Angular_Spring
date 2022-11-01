import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PopUpComponent } from '../pop-up/pop-up.component';
import { ClienteService } from '../services/cliente.service';
import { EmitterService } from "../services/emitter.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(
    private dialog : MatDialog,
    private clienteService: ClienteService) { }

  ngOnInit(): void {
  }

  openDialog() {
    this.dialog.open(PopUpComponent)
  }

  search(value: string) {
    let searchTerm = value;
    let page: number = 0;
    let size: number = 10;

    this.clienteService.search(searchTerm, page, size).subscribe(response => EmitterService.Emitter.emit(response.content));
  }
}
