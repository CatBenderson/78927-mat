using System;
using WSDL.mensajes;

namespace WSDL.operaciones{
    
    public class Operaciones: Mensajes{
        string Mensajes.Saludar(string nombre){
            string msj="Hola" + nombre;
            return msj;
        }
        
        string Mensajes.Mostrar(int id){
            return "x";
        }
    }
}