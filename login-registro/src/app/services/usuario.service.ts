import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Usuario } from '../usuario';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private URL="http://localhost:8080/api/usuarios";
  constructor(private http:HttpClient, private router:Router) { }

  getUsuario():Observable<Usuario[]>{
    return this.http.get<Usuario[]>(`${this.URL}`)
  }

  verificarUsuario(usuario:Usuario):Observable<Object>{
    return this.http.post(`${this.URL}/login`,usuario)
  }

  registrarUsuario(usuario:Usuario):Observable<Object>{
    return this.http.post(`${this.URL}/usuario`,usuario);
  }
}
