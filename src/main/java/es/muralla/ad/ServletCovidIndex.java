package es.muralla.ad;

import java.io.IOException;
import java.text.ParseException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class ServletCovidIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("INICIO");
			String ruta = request.getServletContext().getRealPath("/centros_educativos.csv");
			es.muralla.ad.covid.datos.Datos.getDatesFromCsv(ruta);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		// Redirige a la p�gina JSP para mostrar los datos
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
