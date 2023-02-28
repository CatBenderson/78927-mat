using System;
using WSDL.mensajes;

namespace WSDL.operaciones{
    
    public class Operaciones: Mensajes{
        String [] saludados = new String[100];
        String x="No hallado";
        int aux=0;
        string Mensajes.Saludar(string nombre){
            string msj="Hola " + nombre;
            saludados[aux]=nombre;
            aux++;
            return msj;

        }
        
        string Mensajes.Mostrar(int id){
            x=saludados[id];
            return x;
        }
    }
}