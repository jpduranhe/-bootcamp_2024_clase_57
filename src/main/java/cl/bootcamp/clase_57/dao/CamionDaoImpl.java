package cl.bootcamp.clase_57.dao;

import cl.bootcamp.clase_57.entidad.Camion;

public class CamionDaoImpl extends DAO implements CamionDao {
	
	public CamionDaoImpl(){
		this.conectarDb();
	}

	@Override
	public int guardar(Camion camion) {
		
		String marca= camion.getMarca();
		String modelo= camion.getModelo();
		int idChofer= camion.getChoferId();
		
	
		String sql="insert into camion (camion_marca,camion_modelo,chofer_id)";
			   sql+=" values('"+marca+"','"+modelo+"',"+idChofer+")";
		int registrosAfectados= this.ejecutarSql(sql);
		return registrosAfectados;
	}

	
	
}
