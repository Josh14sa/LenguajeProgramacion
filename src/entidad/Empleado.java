package entidad;

public class Empleado {
	private int id_empleado; 
	private String dni; 
	private String apePaterno; 
	private String apeMaterno; 
	private String nombres; 
	private String sexo;
	private String fechaNac; 
	private String celular;
	private String correo; 
	private String usuario; 
	private String clave; 
	private int rol;
	
	
	public Empleado() {
		
	}


	public Empleado(int id_empleado, String dni, String apePaterno, String apeMaterno, String nombres, String sexo,
			String fechaNac, String celular, String correo, String usuario, String clave, int rol) {
		
		this.id_empleado = id_empleado;
		this.dni = dni;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.nombres = nombres;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.celular = celular;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
		this.rol = rol;
	}


	public Empleado(String dni, String apePaterno, String apeMaterno, String nombres, String sexo, String fechaNac,
			String celular, String correo, String usuario, String clave, int rol) {
			
		this.dni = dni;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.nombres = nombres;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.celular = celular;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
		this.rol = rol;
	}
	
	


	public int getId_empleado() {
		return id_empleado;
	}


	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getApePaterno() {
		return apePaterno;
	}


	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}


	public String getApeMaterno() {
		return apeMaterno;
	}


	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public int getRol() {
		return rol;
	}


	public void setRol(int rol) {
		this.rol = rol;
	}
	
	
}
