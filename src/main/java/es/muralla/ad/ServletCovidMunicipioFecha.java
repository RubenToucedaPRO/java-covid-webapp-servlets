package es.muralla.ad;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import es.muralla.ad.covid.entities.DatoCovid;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/datoscovidmun")
public class ServletCovidMunicipioFecha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		List<DatoCovid> lista = new ArrayList<>();
		String titulo;

		String municipality = request.getParameter("municipality");
		String dateString = request.getParameter("date");
		if (dateString.isEmpty()) {
			titulo = "<h1>Datos de covid de " + municipality + " </h1>";
			lista = es.muralla.ad.covid.datos.Datos.getDatesByMunicipality(municipality);
		} else {
			LocalDate date = LocalDate.parse(dateString);
			titulo = "<h1>Datos de covid de " + municipality + " en la fecha " + dateString + " </h1>";
			lista = es.muralla.ad.covid.datos.Datos.getDatesByMunicipalityDayMonthYear(municipality, date);
		}

		es.muralla.ad.covid.iu.Prints.print(pw, titulo, lista);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
