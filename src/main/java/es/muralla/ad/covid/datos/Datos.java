package es.muralla.ad.covid.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import es.muralla.ad.covid.entities.CentroCerrado;
import es.muralla.ad.covid.entities.DatoCovid;

public class Datos {
	private static List<DatoCovid> lista = new ArrayList<>();

	public static void getDatesFromCsv(String ruta) throws IOException, ParseException {
		FileReader fileReader = new FileReader(ruta, StandardCharsets.UTF_8);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = bufferedReader.readLine();// Discrminamos asi la primera linea que es los nombres de la columnas
		String[] dato;
		while ((line = bufferedReader.readLine()) != null) {
			if (checkedCommas(line)) {
				dato = line.split(",");
				DatoCovid datoCovid = new DatoCovid(dato);
				lista.add(datoCovid);
			}
		}
		bufferedReader.close();

	}

	/*
	 * Este metodo es para discriminar las lineas que tengan comas de mas porque
	 * llevan coma en medio del nombre
	 */
	private static boolean checkedCommas(String line) {
		int nCommas = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ',') {
				nCommas++;
			}
		}
		if (nCommas == 7) {
			return true;
		}
		return false;
	}

	public static List<DatoCovid> getDatesOrderToCenter() {
		List<DatoCovid> listaOrdenada = new ArrayList<>(lista);
		Collections.sort(listaOrdenada, new Comparator<DatoCovid>() {
			@Override
			public int compare(final DatoCovid uno, final DatoCovid dos) {
				return uno.getNombreCentro().compareTo(dos.getNombreCentro());
			}
		});
		return listaOrdenada;
	}

	public static List<DatoCovid> getDatesForSpecificDay(int day) {
		return lista.stream().filter(x -> x.getFecha().getDayOfMonth() == day).toList();
	}

	public static List<DatoCovid> getDatesByCenter(String center) {
		return lista.stream().filter(x -> x.getNombreCentro().equals(center)).toList();
	}

	public static List<DatoCovid> getDatesByMunicipality(String municipality) {
		return lista.stream().filter(x -> x.getConcello().equals(municipality)).toList();
	}

	public static List<DatoCovid> getDatesByMunicipalityDayMonthYear(String municipality, LocalDate date) {
		return lista.stream().filter(x -> x.getConcello().equals(municipality)).filter(y -> y.getFecha().equals(date))
				.toList();
	}

	public static List<CentroCerrado> getClosedCenters() {
		List<CentroCerrado> listaN = new ArrayList<>();
		lista.stream().filter(x -> x.getCentroCerrado().equals("si"))
				.forEach(x -> listaN.add(new CentroCerrado(x.getFecha(), x.getPositivos(), x.getNombreCentro())));
		return listaN;
	}

}
