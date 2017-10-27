package org.institutoserpis.ed;

import java.math.BigDecimal;
import java.util.Scanner;

public class Suma {

	public static void main(String[] args) {
		
		int res;
		int numUno;
		int numDos;
		Scanner num = new Scanner(System.in);
		System.out.println("Introduce dos números: ");
		numUno = num.nextInt();
		numDos = num.nextInt();
		res = numUno + numDos;
		System.out.println("El resultado de la suma es: " + res);
		
		
		BigDecimal resDos;
		BigDecimal numTres;
		BigDecimal numCuatro;
		Scanner numDosI = new Scanner(System.in);
		System.out.println("Introduce dos números: ");
		numTres = numDosI.nextBigDecimal();
		numCuatro = numDosI.nextBigDecimal();
		resDos = numTres.add(numCuatro);
		System.out.println("El resultado es: " + resDos);
		
	}
	
}
