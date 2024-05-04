package cl.bootcamp.clase_57;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import cl.bootcamp.clase_57.dao.*;
import cl.bootcamp.clase_57.entidad.Chofer;
import cl.bootcamp.clase_57.service.ChoferService;
import cl.bootcamp.clase_57.service.ChoferServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class CrearChofer
 */
public class CrearChofer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String html="""
					<html>
						<body>
							<form action="#" method="post">
								<label>Nombre</label>
								<input name="nombre_chofer" required/>
								<br/>
								<label>Apellidos</label>
								<input name="apellido_chofer" required/>
								<br/>
								<button type='submit'> Guardar</button>
							</form>
						</body>
					</html>
				""";
		response.getWriter().print(html);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ChoferDAO choferDao= new ChoferDAOImpl();
		ChoferService  service= new ChoferServiceImpl(choferDao);
		
		String nombreParam=request.getParameter("nombre_chofer");
		String apellidoParam=request.getParameter("apellido_chofer");
		
		Chofer chofer= new Chofer();
		chofer.setNombre(nombreParam);
		chofer.setApellidos(apellidoParam);
		
		boolean resultado=service.crearChofer(chofer);
		
		String resultGuardar= (resultado)?"Guardado Correctamente": "No Guardado"  ;
		String html="""
				<html>
					<body>
						__resultado__
					</body>
				</html>
			""".replace("__resultado__", resultGuardar);
		response.getWriter().print(html);
	}

}
