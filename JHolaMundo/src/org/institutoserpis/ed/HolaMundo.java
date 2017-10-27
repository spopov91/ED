package org.institutoserpis.ed;

import java.io.Console;
import java.io.Reader;
import java.util.Scanner;

public class HolaMundo {

	public static void main(String[] args) {
		Scanner n = new Scanner (System.in);
		System.out.println("Cómo te llamas?");
		String nombre = n.nextLine();
		System.out.println("Hello " + nombre);
		
		
	}

}
