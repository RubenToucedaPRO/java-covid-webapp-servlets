package es.muralla.ad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import es.muralla.ad.covid.entities.DatoCovid;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/datoscovidcenter")
public class ServletCovidCentroEducativo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String center;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		center = request.getParameter("center");

		List<DatoCovid> lista = new ArrayList<>();
		lista = es.muralla.ad.covid.datos.Datos.getDatesByCenter(center);
		String titulo = "Datos covid del centro " + center;
		es.muralla.ad.covid.iu.Prints.print(pw, titulo, lista);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
