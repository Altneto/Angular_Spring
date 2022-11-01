import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http'
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private userUrl: string;

  constructor(private http: HttpClient) {
    this.userUrl = 'http://localhost/clientes'
  }

  public search(searchTerm: string, page: number, size: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('searchTerm', `${searchTerm}` );
    params = params.append('page', `${page}` )
    params = params.append('size', `${size}` )
    return this.http.get(this.userUrl, {params: params});
  }

  public findByCode(codigo: number): Observable<any> {
    return this.http.get(`${this.userUrl}/${codigo}`)
  }

  public save(body: any): Observable<any> {
    return this.http.post(this.userUrl, body);
  }
}
