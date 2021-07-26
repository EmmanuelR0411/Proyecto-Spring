package generation.mx.services;
/*
 * Se encarga de crear todas las operaciones (consultas, borrar, guardar, etc..)
 */
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import generation.mx.models.UserModel;
import generation.mx.repositories.UserRepository;

//Indicamos que es un servicio
@Service
public class UserService {
	
/*	Creamos un objeto, autowired se encarga de crear el objeto con 
 * el constructor. userRepository sera quien haga toda la interaccion con la bd
 * */
	@Autowired
	UserRepository userRepository;
	
//	Creamos los metodos para que el repositorio tenga interaccio con la bd
/*	Mostramos todos los usuarios de la bd, indicamos que nos regrese una lista 
 * de UserModel*/
	public ArrayList<UserModel> getUsers() {
/*	findAll es un metodo que viene heredado de CrudRepository, con el ArrayList 
 *  hacemos el casteo de los datos ya que findAll no regresa como tal un 
 *  ArrayList de UserModel*/
		return (ArrayList<UserModel>) userRepository.findAll();
	}
	
/*	Creamos un metodo de tipo UsetrModel Guardamos un usuario, por eso no se 
	usa un array, recibira un UserModel que se llamara user*/
	public UserModel saveUser(UserModel user) {
		String name = user.getName();
		String surname = user.getSurname();
		String email = user.getEmail();
		//Creamos validaciones por si envian un campo vacio
		if (name != null && surname != null && email != null) {
//			Retorna lo que se haya guardado en userRepository.save
			return userRepository.save(user);
		}
		return user;

	}
	
//	Con el optional cahcamos cualquier error
	public Optional<UserModel> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
//	Para eliminar usuarios
	public boolean deleteUser (Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception error) {
			return false;
		}
	}
	
//	Para buscar usuarios por nombre
	public ArrayList<UserModel> getUsersByName(String name){
		return userRepository.findByName(name);
	}
}
