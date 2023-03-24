package mx.uv.practica04;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BorrarRequest;
import https.t4is_uv_mx.saludos.BorrarResponse;
import https.t4is_uv_mx.saludos.ModificarRequest;
import https.t4is_uv_mx.saludos.ModificarResponse;
import https.t4is_uv_mx.saludos.PedirResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;

@Endpoint
public class EndPoint {
    ArrayList<String> nombres = new ArrayList<String>();
    @Autowired
    private ISaludador iSaludador;
    int i=0;

    @PayloadRoot(localPart = "SaludarRequest", namespace="https://t4is.uv.mx/saludos")

    @ResponsePayload
    public SaludarResponse Saludar( @RequestPayload  SaludarRequest peticion) {
        SaludarResponse response= new SaludarResponse();
        nombres.add(peticion.getNombre());
        i++;
        response.setRespuesta("Hola "+peticion.getNombre());

        Saludador saludador =new Saludador();
        saludador.setNombre(peticion.getNombre());
        iSaludador.save(saludador);

        return response;
    }

    @PayloadRoot(localPart = "ModificarRequest", namespace="https://t4is.uv.mx/saludos")

    @ResponsePayload
    public ModificarResponse Modificar( @RequestPayload  ModificarRequest peticion) {
        int aux=0;
        ModificarResponse response= new ModificarResponse();
        for (int x = 0; x < nombres.size(); x++) {
            if (peticion.getNombreOld().equals(nombres.get(x))){
                nombres.set(x, peticion.getNombreNew());
                response.setRespuesta(peticion.getNombreOld()+" modificado por "+nombres.get(x));
                aux=1;
            }
        }
        if (aux==0){
            response.setRespuesta("Valor no encontrado");
            aux=0;
        }
        return response;
    }

    @PayloadRoot(localPart = "PedirRequest", namespace="https://t4is.uv.mx/saludos")

    @ResponsePayload
    public PedirResponse Pedir() {
        PedirResponse response= new PedirResponse();
        String todos="He saludado a: ";
        for (int x = 0; x < nombres.size(); x++) {
          if(nombres.get(x)!=null){
            todos=todos+ nombres.get(x) +", ";
          }
        }
        response.setRespuesta(todos);
        return response;
    }

    @PayloadRoot(localPart = "BorrarRequest", namespace="https://t4is.uv.mx/saludos")

    @ResponsePayload
    public BorrarResponse Borrar( @RequestPayload  BorrarRequest peticion) {
        BorrarResponse response= new BorrarResponse();
        int aux=0;
        for (int x = 0; x < nombres.size(); x++) {
            if (peticion.getNombre().equals(nombres.get(x))){
                nombres.remove(x);
                response.setRespuesta(peticion.getNombre()+" eliminado");
                aux=1;
            }
        }
        if (aux==0){
            response.setRespuesta("Valor no encontrado");
            aux=0;
        }
        return response;
    }
}
