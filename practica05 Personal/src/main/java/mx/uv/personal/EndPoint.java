package mx.uv.personal;

import java.util.Optional;

import com.github.cliftonlabs.json_simple.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.personal.CreatePersonalResponse;
import https.t4is_uv_mx.personal.DeletePersonalRequest;
import https.t4is_uv_mx.personal.DeletePersonalResponse;
import https.t4is_uv_mx.personal.ReadPersonalOneRequest;
import https.t4is_uv_mx.personal.ReadPersonalOneResponse;
import https.t4is_uv_mx.personal.ReadPersonalResponse;
import https.t4is_uv_mx.personal.UpdatePersonalRequest;
import https.t4is_uv_mx.personal.UpdatePersonalResponse;
import https.t4is_uv_mx.personal.CreatePersonalRequest;

@Endpoint
public class EndPoint {
    //ArrayList <Personal> personales = new ArrayList<Personal>();
    
    
    @Autowired
    private PersonalServer personalServer;
    
    @PayloadRoot(localPart="CreatePersonalRequest",namespace="https://t4is.uv.mx/personal")
    
    @ResponsePayload 
    public CreatePersonalResponse Crear (@RequestPayload CreatePersonalRequest peticion){
        CreatePersonalResponse response=new CreatePersonalResponse();

        response.setRespuesta("Registrado: "+ peticion.getNombre() + ", " + peticion.getCargo()+", "+ peticion.getExperiencia()+", "+ peticion.getSalario());

        Personal persona = new Personal();
        persona.setNombre(peticion.getNombre());
        persona.setCargo(peticion.getCargo());
        persona.setExperiencia(peticion.getExperiencia());
        persona.setSalario(peticion.getSalario());
        personalServer.save(persona);

        return response;
    }

    @PayloadRoot (localPart = "UpdatePersonalRequest",namespace = "https://t4is.uv.mx/personal")

    @ResponsePayload 
    public UpdatePersonalResponse Modificar (@RequestPayload UpdatePersonalRequest peticion){
        UpdatePersonalResponse response = new UpdatePersonalResponse();
        Optional<Personal> data = personalServer.findById(peticion.getId());
        Personal recuperado=data.get();
        
        recuperado.setNombre(peticion.getNombreNew());
        recuperado.setCargo(peticion.getCargoNew());
        recuperado.setExperiencia(peticion.getExperienciaNew());
        recuperado.setSalario(peticion.getSalarioNew());
        personalServer.save(recuperado);

        response.setRespuesta("Modificado");
        return response;
    }

    @PayloadRoot(localPart = "ReadPersonalOneRequest",namespace = "https://t4is.uv.mx/personal" )

    @ResponsePayload
    public ReadPersonalOneResponse RecuperarUno(@RequestPayload ReadPersonalOneRequest peticion){
        ReadPersonalOneResponse response=new ReadPersonalOneResponse();
        Optional<Personal> data =personalServer.findById(peticion.getId());
        Personal recuperado=data.get();

        response.setRespuesta("Recuperado: "+ recuperado.getNombre() + ", " + recuperado.getCargo()+", "+ recuperado.getExperiencia()+", "+ recuperado.getSalario());
        return response;
    }

    @PayloadRoot(localPart = "ReadPersonalRequest",namespace = "https://t4is.uv.mx/personal" )

    @ResponsePayload
    public ReadPersonalResponse RecuperarTodos(){
        ReadPersonalResponse response=new ReadPersonalResponse();
        Iterable<Personal> personales =personalServer.findAll();
        JsonObject personaJson= new JsonObject();
    
        for (Personal x : personales){
            JsonObject datosJson = new JsonObject();
            datosJson.put("nombre", x.getNombre());
            datosJson.put("cargo", x.getCargo());
            datosJson.put("experiencia", x.getExperiencia());
            datosJson.put("salario", x.getSalario());

            personaJson.put(x.getId().toString(), datosJson);
        }
        response.setRespuesta(personaJson.toString());
        return response;
    }

    @PayloadRoot(localPart = "DeletePersonalRequest", namespace="https://t4is.uv.mx/personal")

    @ResponsePayload
    public DeletePersonalResponse Borrar(@RequestPayload DeletePersonalRequest peticion){
        DeletePersonalResponse response = new DeletePersonalResponse();
        personalServer.deleteById(peticion.getId());

        response.setRespuesta("Registro eliminado");
        return response;
    }

    
}
