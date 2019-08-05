import java.util.Scanner;

public class EjerciciosArrays {
	
	public static void main(String[] args) {
		
		//Declaramos las variables necesarias
		Scanner teclado=new Scanner(System.in);
		
		float[] arrayNotas;
		int opcion=0, cantidad=0;
		
		//Preguntamos cuantas notas va a introducir el usuario
		System.out.print("�Cu�ntas notas va a introducir en el vector?: ");
		cantidad=teclado.nextInt();
		teclado.nextLine();
		
		arrayNotas=new float[cantidad];
		
		//Inicializamos el Array
		for(int i=0; i<arrayNotas.length; i++)
		{
			arrayNotas[i]=-2;
		}
		
		//Pedimos al usuario las notas para introducirlas a la array.
		for(int i=0; i<arrayNotas.length; i++)
		{
			System.out.println("Introduzca la nota del alumno n�mero " + (i+1) + ": ");
			arrayNotas[i]=teclado.nextFloat();
			teclado.nextLine();;
		}
		
		/*
		//Ordenamos el vector o array
		float temporal=0;
		for(int i=0; i<arrayNotas.length; i++)
		{
			for(int j=0; j<arrayNotas.length; j++)
			{
				if(arrayNotas[j]>arrayNotas[i])
				{
					temporal=arrayNotas[i];
					arrayNotas[i]=arrayNotas[j];
					arrayNotas[j]=temporal;
				}
			}
		}
		
		//Muestra las notas ordeandas como se ha realizado anteriormente
		for(int i=0; i<arrayNotas.length; i++)
		{
			System.out.println(arrayNotas[i]);
		}
		*/
		
		//Operamos con el usuario la opcion que desea visualizar
		do { 
			System.out.print("�Que nota desea visualizar? [1-" + arrayNotas.length + "] (-1 para salir): ");
			opcion=teclado.nextInt();
			teclado.nextLine();
			if(opcion!=-1 && (opcion<1 || opcion>arrayNotas.length))
				System.out.println("Error!, el dato introducido est� fuera del rango 1-" + arrayNotas.length + ".");
			else
				if(opcion!=-1)
					System.out.println("La nota pedida es la n�mero " + opcion + " cuyo valor es: " + arrayNotas[opcion-1]);
				else
				{
					//Calculamos cual es el mayor y cual es el menor
					float mayor = Integer.MIN_VALUE;
					float menor = Integer.MAX_VALUE;
					int posmayor=-1;
					int posmenor=-1;

					for(int i=0; i<arrayNotas.length; i++)
					{
						if(mayor<arrayNotas[i])
						{
							mayor=arrayNotas[i];
							posmayor=i+1;
						}
						if(menor>arrayNotas[i])
						{
							menor=arrayNotas[i];
							posmenor=i+1;
						}
					}
					System.out.println("La nota M�nima es " + menor + " y corresponde con el alumno " + posmenor);
					System.out.println("La nota M�xima es " + mayor + " y correspodne con el alumno " + posmayor);
 					System.out.println("ADI�S");
				}
		}while(opcion!=-1);
		
	}
}
