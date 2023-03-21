package mx.uv.practica03;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.ModificarRequest;
import https.t4is_uv_mx.saludos.ModificarResponse;
import https.t4is_uv_mx.saludos.PedirResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;

@Endpoint
public class EndPoint {
    String [] nombres = new String[100];
    int i=0;

    @PayloadRoot(localPart = "SaludarRequest", namespace="https://t4is.uv.mx/saludos")

    @ResponsePayload
    public SaludarResponse Saludar( @RequestPayload  SaludarRequest peticion) {
        SaludarResponse response= new SaludarResponse();
        nombres[i]=peticion.getNombre();
        i++;
        response.setRespuesta("Hola "+peticion.getNombre());
        return response;
    }

    @PayloadRoot(localPart = "ModificarRequest", namespace="https://t4is.uv.mx/saludos")

    @ResponsePayload
    public ModificarResponse Modificar( @RequestPayload  ModificarRequest peticion) {
        ModificarResponse response= new ModificarResponse();
        for (int x = 0; x < nombres.length; x++) {
            if (peticion.getNombreOld().equals(nombres[x])){
                nombres[x]=peticion.getNombreNew();
                response.setRespuesta(peticion.getNombreOld()+" modificado por "+nombres[x]);
            }else{
                response.setRespuesta("Valor no encontrado");
            }
        }
        return response;
    }

    @PayloadRoot(localPart = "PedirRequest", namespace="https://t4is.uv.mx/saludos")

    @ResponsePayload
    public PedirResponse Pedir() {
        PedirResponse response= new PedirResponse();
        String todos="He saludado a: ";
        for (int x = 0; x < nombres.length; x++) {
          if(nombres[x]!=null){
            todos=todos+ nombres[x] +", ";
          }
        }
        response.setRespuesta(todos);
        return response;
    }
}
