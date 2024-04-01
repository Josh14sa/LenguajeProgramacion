package interfaces;

import java.util.ArrayList;

import entidad.Rol;

public interface RolInterfacesDAO {
	
	public int registrar (Rol r);
	
	public int modificar (Rol r);
	
	public Rol buscar (int r);
	
	public int eliminar (Rol r);
	
	public ArrayList<Rol> listado();

}
