package generation.mx.controllers;
/*
 * El controlador recibe las peticiones y da la resṕuesta, este se conecta al
 * servicio
 */
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import generation.mx.models.UserModel;
import generation.mx.services.UserService;

//Es un ResController porque va a responder a metodos mediante http
@RestController
/*Indicamos la ruta principal, al noespecificar una ruta se utiliza la que se 
 * declaro arriba en el controlador*/
@RequestMapping("/user")
public class UserController {
//	Nuestro contralador se debe de conectar al servicio
	@Autowired
	UserService userService;
	
	
//	Devolvemos la lista de todos los usuarios
//	Indicamos que se va a utilizar el metodo GET para el envio de la informacion
	@GetMapping 
	public ArrayList<UserModel> getUsers(){
//	El getUsers que se devuelve aqui es el que se creo en UserService.java
		return userService.getUsers();
	}
	
	@PostMapping
	/*
	 * Se recuperan todas las peticiones que se hagan mediante Post desde la url
	 * ../user
	 * El RequestModel recupera lo que viene en el body de la peticion post y lo
	 * guarda en una variable de tipo UserModel llamdad user
	 */
	public UserModel saveUser(@RequestBody UserModel user) {
		return userService.saveUser(user);
	}
	
	/*
	 * El optional se pone para que si se ingresa un id que no existe en la bd
	 * no se rompa el programa
	 */
	@GetMapping (path = "/{id}")
	public Optional<UserModel> getUserById(@PathVariable("id") Long id){
		return userService.getUserById(id);
	}
	
//	Interceptamos un metodo de delete
	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		boolean ok = userService.deleteUser(id);
		
//		ok toma el valor que se le da en UserService, ya sea true o false
		if(ok) {
			return "Se elimino el usuario";
		}else {
			return "No se pudo eliminar el usuario";
		}
	}
	
//	Definimos un nuevo metodo para realizar una busqueda mediante el nombre
	@GetMapping("/query")
	public ArrayList<UserModel> getUsersByName(@RequestParam(value = "name", defaultValue = "")String name){
		return userService.getUsersByName(name);
	}
}
