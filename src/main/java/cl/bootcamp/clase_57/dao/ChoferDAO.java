package cl.bootcamp.clase_57.dao;

import java.util.List;

import cl.bootcamp.clase_57.entidad.Chofer;

public interface ChoferDAO {
	
	int guardar(Chofer chofer);
	int editar(Chofer chofer);
	int eliminar(int id);
	Chofer obtenerPorId(int id);
	List<Chofer> listado(); 
}
