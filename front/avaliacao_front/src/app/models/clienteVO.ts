export class ClienteVO {
  nome: string;
  cnpj: string;
  endereco: string;

  constructor(
    nome: string,
    cnpj: string,
    endereco: string
  ) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.endereco = endereco;
  }
}
