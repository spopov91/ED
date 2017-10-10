import java.util.Scanner;

public class JAdivina {

	public static void main(String[] args) {
		
		int numero;
		int numIntro;
		int cont = 0;
		
		numero = (int) (Math.random() * 1000 + 1);
		
		
		
		do { 
		Scanner numIntroducido = new Scanner(System.in);
		System.out.println("Adivina el número:");
		numIntro = numIntroducido.nextInt();
		cont++;
		
		if(numero < numIntro) {
			System.out.println("Introduce un número menor!");
		} else if(numero > numIntro) {
			System.out.println("Introduce un número mayor!");
		  }		
			
		}while(numero != numIntro);
		System.out.println("Has acertado en " + cont + " intentos!");
		
		
		
	}

}
