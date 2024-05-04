package cl.bootcamp.clase_57.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.bootcamp.clase_57.entidad.Chofer;

public class ChoferDAOImpl extends DAO  implements ChoferDAO {
	
	public ChoferDAOImpl(){
		this.conectarDb();
	}
	

	@Override
	public int guardar(Chofer chofer) {
		String sql ="insert into chofer (chofer_nombre,chofer_apellidos)";
			    sql+=" values ('"+chofer.getNombre()+"','"+chofer.getApellidos()+"')";
		return this.ejecutarSql(sql);
	}

	@Override
	public int editar(Chofer chofer) {
		String sql ="update chofer set chofer_nombre='"+chofer.getNombre()+"', chofer_apellidos='"+chofer.getApellidos()+"' where chofer_id="+chofer.getId();
	    return this.ejecutarSql(sql);
	}

	@Override
	public int eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Chofer obtenerPorId(int id) {
		try {
			String sql="select chofer_nombre,chofer_apellidos from chofer where chofer_id="+id;
			ResultSet rsl= this.consultar(sql);
			Chofer chofer=null;
			while(rsl.next()) {
				
				chofer= new Chofer(rsl.getInt("chofer_id"),
						rsl.getString("chofer_nombre"),
						rsl.getString("chofer_apellidos"));
				
				/*
			chofer= new Chofer();
			chofer.setId(rsl.getInt("chofer_id"));
			chofer.setNombre(rsl.getString("chofer_nombre"));
			chofer.setApellidos(rsl.getString("chofer_apellidos"));
				 */
			}
			
			return chofer;
			
		}catch(SQLException e) {
			return null;
		}
	}

	@Override
	public List<Chofer> listado() {
		List<Chofer> listado= new ArrayList<>();
		try {
			String sql="select chofer_nombre,chofer_apellidos from chofer";
			ResultSet rsl= this.consultar(sql);
			while(rsl.next()) {
				
				Chofer chofer= new Chofer(rsl.getInt("chofer_id"),
						rsl.getString("chofer_nombre"),
						rsl.getString("chofer_apellidos"));
				
				listado.add(chofer);
			}
			return listado;
			
		}catch(SQLException e) {
			return null;
		}
	}

}
