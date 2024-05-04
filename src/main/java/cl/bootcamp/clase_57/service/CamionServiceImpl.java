package cl.bootcamp.clase_57.service;

import cl.bootcamp.clase_57.dao.CamionDao;
import cl.bootcamp.clase_57.entidad.Camion;

public class CamionServiceImpl implements CamionService {
	
	private CamionDao camionDao;
	
	public CamionServiceImpl(CamionDao camionDao) {
		this.camionDao=camionDao;
	}
	

	@Override
	public boolean crearCamion(Camion camion) {
		if(camion.getMarca().isBlank() || camion.getModelo().isBlank() || camion.getChoferId()==0) {
			return false;
		}
		
		int registrosAfectados = camionDao.guardar(camion);
		boolean resultadoProcesoGuardado= registrosAfectados > 0;
		return resultadoProcesoGuardado;
	}

}
