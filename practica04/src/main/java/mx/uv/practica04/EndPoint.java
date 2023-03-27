package mx.uv.practica04;

import java.util.ArrayList;
import java.util.Optional;

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
import https.t4is_uv_mx.saludos.PedirUnoRequest;
import https.t4is_uv_mx.saludos.PedirUnoResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;

@Endpoint
public class EndPoint {
    ArrayList<String> nombres = new ArrayList<String>();
    Iterable<Saludador> saludadores;
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
        ModificarResponse response = new ModificarResponse();
        Optional<Saludador> x = iSaludador.findById(peticion.getId());
        Saludador y=x.get();
        y.setNombre(peticion.getNombreNew());
        iSaludador.save(y);
        response.setRespuesta("Modificado");
        return response;
    }

    @PayloadRoot(localPart = "PedirRequest", namespace="https://t4is.uv.mx/saludos")

    @ResponsePayload
    public PedirResponse Pedir() {
        PedirResponse response= new PedirResponse();
        String todos="";
        saludadores=iSaludador.findAll();
        for (Saludador x : saludadores) {
            todos= todos +x.getId() + ": " + x.getNombre() +", ";
        }
        response.setRespuesta(todos);
        return response;
    }

    @PayloadRoot(localPart = "BorrarRequest", namespace="https://t4is.uv.mx/saludos")

    @ResponsePayload
    public BorrarResponse Borrar( @RequestPayload  BorrarRequest peticion) {
        BorrarResponse response= new BorrarResponse();
        iSaludador.deleteById(peticion.getId());
        return response;
    }

    @PayloadRoot(localPart = "PedirUnoRequest", namespace="https://t4is.uv.mx/saludos")

    @ResponsePayload
    public PedirUnoResponse PedirUno(@RequestPayload  PedirUnoRequest peticion) {
        PedirUnoResponse response= new PedirUnoResponse();
        Optional<Saludador> x = iSaludador.findById(peticion.getId());
        Saludador y=x.get();
        response.setRespuesta(y.getNombre());
        return response;
    }
}
