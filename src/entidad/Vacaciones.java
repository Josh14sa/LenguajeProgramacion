package entidad;

public class Vacaciones {
	//Atributos privados
	private int codigo;
	private String fechaInicio;
	private String fechaFin;
	private String area;
			
	//Constructores
	public Vacaciones() {
		
	}

	public Vacaciones(int codigo, String fechaInicio, String fechaFin, String area) {
		this.codigo = codigo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.area = area;
	}

	
	//Métodos de Acceso Get/Set
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
		

}
