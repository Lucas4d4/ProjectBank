package entidad;

public class Cliente {

	private String Dni;
	private String Cuil_c;
	private String Nombre;
	private String Apellido;
	private String Sexo;
	private String Nacionalidad;
	private String FechaNacimiento;
	private String Direccion;
	private String Localidad;
	private String Provincia;
	private String Mail;
	private String Telefono;
	private String Usuario;
	private String password;
	private boolean estado ;
	
	
	
	@Override
	public String toString() {
		return "Usuario: " + Nombre + " " + Apellido  ;
	}
	
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getCuil_c() {
		return Cuil_c;
	}
	public void setCuil_c(String cuil_c) {
		Cuil_c = cuil_c;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public String getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Cliente(String dni, String cuil_c, String nombre, String apellido, String sexo, String nacionalidad,
			String fechaNacimiento, String direccion, String localidad, String provincia, String mail, String telefono,
			String usuario, String password) {
		super();
		Dni = dni;
		Cuil_c = cuil_c;
		Nombre = nombre;
		Apellido = apellido;
		Sexo = sexo;
		Nacionalidad = nacionalidad;
		FechaNacimiento = fechaNacimiento;
		Direccion = direccion;
		Localidad = localidad;
		Provincia = provincia;
		Mail = mail;
		Telefono = telefono;
		Usuario = usuario;
		this.password = password;
	}
	public Cliente() {
		Dni = " ";
		Cuil_c = " ";
		Nombre = " ";
		Apellido = " ";
		Sexo = " ";
		Nacionalidad = " ";
		FechaNacimiento = " ";
		Direccion = " ";
		Localidad = " ";
		Provincia = " ";
		Mail = " ";
		Telefono = " ";
		Usuario = " ";
		this.password = " ";
			
	}
	
	
	
}
