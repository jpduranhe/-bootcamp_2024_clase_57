package cl.bootcamp.clase_57.service;

import cl.bootcamp.clase_57.dao.ChoferDAO;
import cl.bootcamp.clase_57.entidad.Chofer;

public class ChoferServiceImpl implements ChoferService{
	
	private ChoferDAO choferDao;
	
	
	public ChoferServiceImpl(ChoferDAO choferDao){	
		
		this.choferDao= choferDao;
		
	}

	@Override
	public boolean crearChofer(Chofer chofer) {
		if(chofer.getNombre().isBlank()) {
			return false;
		}
		int result= choferDao.guardar(chofer);
		return  result>0;
	}

}
