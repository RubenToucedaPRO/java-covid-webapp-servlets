package es.muralla.ad.covid.iu;

import java.io.PrintWriter;
import java.util.List;

import es.muralla.ad.covid.entities.DatoCovid;

public class Prints<T> {

	public static void printList(List<DatoCovid> lista) {
		int i = 0;
		if (lista.isEmpty()) {
			System.out.println("Sin datos");
		} else {
			for (DatoCovid datoCovid : lista) {
				System.out.println("* " + ++i + " -> " + datoCovid.toString() + " *");
			}
		}
	}

	public static <T> void print(PrintWriter pw, String titulo, List<T> lista) {

		pw.write("<!DOCTYPE html>");
		pw.write("<html lang='es'>");
		pw.write("<head>");
		pw.write("<meta charset='UTF-8'>");
		pw.write("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		pw.write("<title>" + titulo + "</title>");
		pw.write("<style>");
		pw.write("body { font-family: Arial, sans-serif; background-color: #f4f4f4; color: #333; }");
		pw.write("h1 { text-align: center; color: #007bff; }");
		pw.write(
				".container { max-width: 1500px; margin: 50px auto; background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
		pw.write("ol { padding-left: 20px; }");
		pw.write("li { margin: 10px 0; padding: 10px; background-color: #e9ecef; border-radius: 5px; }");
		pw.write("</style>");
		pw.write("</head>");
		pw.write("<body>");

		pw.write("<div class='container'>");
		pw.write("<h1>" + titulo + "</h1>");
		pw.write("<ol>");
		if (lista.isEmpty()) {
			pw.write("Sin datos");
		} else {
			for (T dt : lista) {
				pw.write("<li>" + dt.toString() + "</li>");
			}
		}
		pw.write("</ol>");
		pw.write("</div>");

		pw.write("</body>");
		pw.write("</html>");

		pw.flush();
		pw.close();

	}

}
