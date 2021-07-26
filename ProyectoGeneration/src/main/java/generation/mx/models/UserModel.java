package generation.mx.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Con @Entity indicamos que va a interactuar con la bd (que es una entidad)
@Entity
//Con @Table le damos nombre a la tabla cuando se genere
@Table (name = "users")
public class UserModel {
	
//	Indicamos nuestro id y que nos generara un id para que se haga la asignacion
	@Id
//	Aqui hacemos que el valor sea generado directamente desde java y no desde la bd
	@GeneratedValue (strategy = GenerationType.IDENTITY)
//	Indicamos que el valor no puede ser nulo
	@Column (nullable = false)
	private long id;
	//En column van las configuraciones que se pueden hacer a la base de datos
	
/*	Con length indicamos de que tamaño sera, si se agrega un name se le agregara 
 *  ese nombre a la tabla
 * */
	@Column(nullable = false, length = 100, name = "name")
	private String name;
	
	@Column(nullable = false, length = 100)
	private String surname;
	
//	Con unique indicamos que sera un campo unico
	@Column(nullable = false, length = 100, unique = true)
	private String email;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
