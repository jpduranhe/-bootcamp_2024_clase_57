package cl.bootcamp.clase_57;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import cl.bootcamp.clase_57.dao.*;
import cl.bootcamp.clase_57.entidad.Camion;
import cl.bootcamp.clase_57.service.*;

public class CrearCamion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String html="""
				<html>
					<body>
						<form action="#" method="post">
							<label>Marca</label>
							<input name="marca_camion" required/>
							<br/>
							<label>Modelo</label>
							<input name="modelo_camion" required/>
							<br/>
							<label>Chofer</label>
							<select name='chofer'>
								<option value='1'>Juan Perez<option>
							</select>
							<br/>
							<button type='submit'> Guardar</button>
						</form>
					</body>
				</html>
			""";
	response.getWriter().print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
			
		CamionDao camionDao= new CamionDaoImpl();
		CamionService camionService= new CamionServiceImpl(camionDao);
		
		String marca= request.getParameter("marca_camion");
		String modelo= request.getParameter("modelo_camion");
		String choferIdString= request.getParameter("chofer");
		int choferId= Integer.parseInt(choferIdString);
		
		Camion camion= new Camion();
		camion.setChoferId(choferId);
		camion.setMarca(marca);
		camion.setModelo(modelo);
		
		boolean resultado =camionService.crearCamion(camion);
		
		String resultGuardar= (resultado)?"Guardado Correctamente": "No Guardado"  ;
		String html="""
				<html>
					<body>
						Camion __resultado__
					</body>
				</html>
			""".replace("__resultado__", resultGuardar);
		response.getWriter().print(html);
	}

}
