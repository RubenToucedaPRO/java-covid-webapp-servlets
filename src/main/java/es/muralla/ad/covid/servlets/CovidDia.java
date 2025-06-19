package es.muralla.ad.covid.servlets;

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

@WebServlet("/datoscoviddia")
public class CovidDia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String dayString;
	int day = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		dayString = request.getParameter("day");
		day = Integer.parseInt(dayString);

		List<DatoCovid> lista = new ArrayList<>();
		lista = es.muralla.ad.covid.datos.Datos.getDatesForSpecificDay(day);
		String titulo = "Datos covid del dia " + day;
		es.muralla.ad.covid.iu.Prints.print(pw, titulo, lista);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
