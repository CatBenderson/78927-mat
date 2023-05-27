package mx.uv.demoREST;

import java.util.ArrayList;
import java.util.List;

import mx.uv.demoREST.Persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class DemoRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestApplication.class, args);
	}

	private Persona personita;

	@RequestMapping("/")
	public String name(){
		return "Hola mundo";
	}

	@RequestMapping("/adios")
	public String adios(){
		return "Adios mundo";
	}

	@RequestMapping("/pregunta")
	public String pregunta(){
		return "¿Cómo estás?";
	}

	@RequestMapping("/productos")
	public List<String> productos(){
		List<String> p = new ArrayList<String>();
		p.add("palomitas");
		p.add("refrescos");
		p.add("bombones");

		return p;
	}

	@RequestMapping("/productos2")
    public List<Productos> productos2(){
        List<Productos> lista = new ArrayList<Productos>();
		Productos p=new Productos("palomitas",10);
		lista.add(p);
		Productos p1=new Productos("refrescos",12);
		lista.add(p1);
		Productos p2=new Productos("bombones",11);
		lista.add(p2);

		return lista;
    }

	@RequestMapping(value = "/saludar",method = RequestMethod.GET)
	public String saludarG() {
		return "Mensaje GET";
	}

	@RequestMapping(value = "/saludar/{nombre}",method = RequestMethod.GET)
	public String saludarPG(@PathVariable String nombre) {
		return "Hola" + nombre;
	}

	@RequestMapping(value = "/saludar",method = RequestMethod.POST)
	public String saludarP() {
		return "Hola";
	}

	@RequestMapping(value = "/saludarPOST",method = RequestMethod.POST)
	public String saludarP2(@RequestBody Persona persona) {
		personita=persona;
		return "Hola" + persona.nombre + " " + persona.apodo;
	}

	@RequestMapping("/obtener")
	public String obtener() {
		return personita.toString();
	}

}
