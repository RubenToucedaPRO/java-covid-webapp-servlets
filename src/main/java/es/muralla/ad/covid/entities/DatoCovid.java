package es.muralla.ad.covid.entities;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatoCovid {
	// Fecha,area_sanitaria,concello,tipo_centro,nombre_centro,positivos,aulas_cerradas,centro_cerrado
	// 2021-06-11,Pontevedra,PONTEVEDRA,CEIP,Manuel Vidal Portela,1,0,no
	private LocalDate Fecha;
	private String AreaSanitaria;
	private String Concello;
	private String TipoCentro;
	private String NombreCentro;
	private int Positivos;
	private String AulasCerradas;
	private String CentroCerrado;

	public DatoCovid(String dato[]) throws ParseException {
		super();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Fecha = LocalDate.parse(dato[0], formatter);
		AreaSanitaria = dato[1];
		Concello = dato[2];
		TipoCentro = dato[3];
		NombreCentro = dato[4];
		if (dato[5].isEmpty()) {
			Positivos = 0;
		} else {
			Positivos = Integer.parseInt(dato[5]);
		}
		AulasCerradas = dato[6];
		CentroCerrado = dato[7];
	}

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}

	public String getAreaSanitaria() {
		return AreaSanitaria;
	}

	public void setAreaSanitaria(String areaSanitaria) {
		AreaSanitaria = areaSanitaria;
	}

	public String getConcello() {
		return Concello;
	}

	public void setConcello(String concello) {
		Concello = concello;
	}

	public String getTipoCentro() {
		return TipoCentro;
	}

	public void setTipoCentro(String tipoCentro) {
		TipoCentro = tipoCentro;
	}

	public String getNombreCentro() {
		return NombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		NombreCentro = nombreCentro;
	}

	public int getPositivos() {
		return Positivos;
	}

	public void setPositivos(int positivos) {
		Positivos = positivos;
	}

	public String getAulasCerradas() {
		return AulasCerradas;
	}

	public void setAulasCerradas(String aulasCerradas) {
		AulasCerradas = aulasCerradas;
	}

	public String getCentroCerrado() {
		return CentroCerrado;
	}

	public void setCentroCerrado(String centroCerrado) {
		CentroCerrado = centroCerrado;
	}

	@Override
	public String toString() {
		return "Fecha=" + Fecha + ", AreaSanitaria=" + AreaSanitaria + ", Concello=" + Concello + ", tipoCentro="
				+ TipoCentro + ", NombreCentro=" + NombreCentro + ", Positivos=" + Positivos + ", AulasCerradas="
				+ AulasCerradas + ", CentroCerrado=" + CentroCerrado;
	}

}
