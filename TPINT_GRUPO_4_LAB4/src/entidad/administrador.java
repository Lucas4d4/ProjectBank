package entidad;

public class administrador {
	private String mail;
	private String password;
	
	
	public administrador() {
		this.mail = null;
		this.password = null;
	}
	
	public administrador(String nombre, String password) {
		super();
		this.mail = nombre;
		this.password = password;
	}
	public String getNombre() {
		return mail;
	}
	public void setNombre(String nombre) {
		this.mail = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
