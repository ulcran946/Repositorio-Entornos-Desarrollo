package com.iescomercio.prog1.logger1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Principal {

	static BufferedWriter bw;
	
	// funcion principal donde se inicia la aplicacion
	public static void main(String[] args) {
		try {
			LocalDate d = LocalDate.now();
			File f = new File(d.toString() + ".txt");
			FileWriter fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);
			bw.write("INFO - Línea leída: 12\n");
			long aux;

			do {
				aux = nModuloM();
				if (aux != -1) {
					System.out.println(aux);
				}
			} while (aux != -1);
			bw.write("INFO - Línea leída: 26\n");
			bw.flush();
		} catch (IOException e) {
			System.err.println("Error en la E/S");
		}
	}

	// funcion que solicita una línea al usuario con el patrón X % Y y devuelve el
	// resultado
	// de la operación X modulo Y. El usuario debera introducir -1 para finalizar
	public static long nModuloM() throws IOException{
		long n;
		int m;
		String str = "";
		str = pideLinea();
		n = Long.valueOf(str.substring(0, str.indexOf(' ')));
		bw.write("DEBUG - n: " + n + "\n");
		m = Integer.valueOf(str.substring(str.lastIndexOf(' ') + 1));
		bw.write("DEBUG - m: " + m + "\n");
		if (n != 0 && m != 0) {
			bw.write("INFO - resultado: " + n % m + "\n");
			return (n % m);
		} else {
			bw.write("WARN - Se devuelve -1\n");
			return -1;
		}
	}

	// pide linea de texto al usuario
	public static String pideLinea() throws IOException {
		Scanner sc = new Scanner(System.in);
		String str = "";
		System.out.print("Introduce una linea: ");
		str = sc.nextLine();
		bw.write("INFO - Línea leída: 57\n");
		return str;
	}

}
