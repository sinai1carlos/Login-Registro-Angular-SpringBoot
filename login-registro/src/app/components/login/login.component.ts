import { Component } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  usuario:Usuario = new Usuario();
  mensaje: string = ''; // Variable para almacenar el mensaje de éxito o error

  constructor(private usuarioServicio:UsuarioService){}

  ngOnInit(){
    //this.onSubmit();
  }
  logearUsuario(){
    this.usuarioServicio.verificarUsuario(this.usuario).subscribe((dato:any)=>{
      console.log(dato);
      if(dato.ok){
        this.mensaje=dato.message;
      }else{
        this.mensaje=dato.message;
      }
      
    })
  }
  onSubmit(){
    console.log(this.usuario);
    this.logearUsuario();
  }
}
