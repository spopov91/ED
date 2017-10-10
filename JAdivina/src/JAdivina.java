import java.util.Scanner;

public class JAdivina {

	public static void main(String[] args) {
		
		int numero;
		int numIntro;
		
		
		numero = (int) (Math.random() * 1000 + 1);
		
		
		
		do { 
		Scanner numIntroducido = new Scanner(System.in);
		System.out.println("Adivina el número:");
		numIntro = numIntroducido.nextInt();
			
		if(numero < numIntro) {
			System.out.println("Introduce un número menor!");
		} else if(numero > numIntro) {
			System.out.println("Introduce un número mayor!");
		  }		
			
		}while(numero != numIntro);
		System.out.println("Has acertado");
		
		
		
	}

}
