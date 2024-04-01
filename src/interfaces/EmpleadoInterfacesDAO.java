package interfaces;

import java.util.ArrayList;

import entidad.Empleado;

public interface EmpleadoInterfacesDAO {
	
	public int registrar (Empleado em);
	
	public int modificar (Empleado em);
	
	public Empleado buscar (String dni);
	
	public int eliminar (Empleado em);
	
	public ArrayList<Empleado>listado();
	
	public Empleado validarAcceso(String empleado, String clave);

}
