export class Cliente {
  codigo: number;
  nome: string;
  cnpj: string;
  endereco: string;

  constructor(
    codigo: number,
    nome: string,
    cnpj: string,
    endereco: string
  ) {
    this.codigo = codigo;
    this.nome = nome;
    this.cnpj = cnpj;
    this.endereco = endereco;
  }
}
