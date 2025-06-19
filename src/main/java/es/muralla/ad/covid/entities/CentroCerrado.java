package es.muralla.ad.covid.entities;

import java.time.LocalDate;

public class CentroCerrado {
	private LocalDate Fecha;
	private String NombreCentro;
	private int Positivos;

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
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

	public CentroCerrado(LocalDate fecha, int positivos, String nombreCentro) {
		super();
		Fecha = fecha;
		Positivos = positivos;
		NombreCentro = nombreCentro;
	}

	@Override
	public String toString() {
		return "Fecha=" + Fecha + ",\t Positivos=" + Positivos + ",\t NombreCentro=" + NombreCentro;
	}

}
