package generation.mx.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import generation.mx.models.UserModel;

@Repository
/*CrudRepository nos pide que tipo de modelo se va a utilizar (e donde creamos 
 * las tablas) y el tipo de dato que maneja el id, cuando heredamos del crud
 * obtenemos metodos predefinidos que vienen en ese crud
 * */
public interface UserRepository extends CrudRepository<UserModel, Long>{

	public abstract ArrayList<UserModel> findByName(String name);
}
