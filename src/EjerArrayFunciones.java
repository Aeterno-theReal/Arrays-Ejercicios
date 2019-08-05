import java.util.Scanner;

public class EjerArrayFunciones {

	static void inicializarArray(float[] array)
	{
		//Inicializamos el Array
		for(int i=0; i<array.length; i++)
		{
			array[i]=-2;
		}
	}
	
	static float introducirNotas(Scanner t, int i)
	{
		float nota=0;
		//Pedimos al usuario las notas para introducirlas a la array
		System.out.println("Introduzca la nota del alumno número " + (i+1) + ": ");
		nota=t.nextFloat();
		t.nextLine();
		
		return nota;
	}
	
	static void ordenarArray(float[] array) //Para ordenar arrays
	{
		//Ordenamos el vector o array
		float temporal=0;
		for(int i=0; i<array.length; i++)
		{
			for(int j=0; j<array.length; j++)
			{
				if(array[j]>array[i])
				{
					temporal=array[i];
					array[i]=array[j];
					array[j]=temporal;
				}
			}
		}
		//Muestra las notas ordeandas como se ha realizado anteriormente
		for(int i=0; i<array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
	
	static void mayorMenorArray(float[] array)
	{
		//Calculamos cual es el mayor y cual es el menor
		float mayor = Integer.MIN_VALUE;
		float menor = Integer.MAX_VALUE;
		int posmayor=-1;
		int posmenor=-1;

		for(int i=0; i<array.length; i++)
		{
			if(mayor<array[i])
			{
				mayor=array[i];
				posmayor=i+1;
			}
			if(menor>array[i])
			{
				menor=array[i];
				posmenor=i+1;
			}
		}
		System.out.println("La nota Mínima es " + menor + " y corresponde con el alumno " + posmenor);
		System.out.println("La nota Máxima es " + mayor + " y correspodne con el alumno " + posmayor);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Declaramos las variables necesarias
				Scanner teclado=new Scanner(System.in);
				
				float[] arrayNotas;
				int opcion=0, cantidad=0;
				
				//Preguntamos cuantas notas va a introducir el usuario
				System.out.print("¿Cuántas notas va a introducir en el vector?: ");
				cantidad=teclado.nextInt();
				teclado.nextLine();
				
				arrayNotas=new float[cantidad];
				
				//Inicializamos el Array o Vector
				inicializarArray(arrayNotas);
				
				//Pedimos al usuario la cantidad de notas a introducir
				
				for(int i=0; i<arrayNotas.length; i++)
				{
					arrayNotas[i]=introducirNotas(teclado, i);
				}
				
				//Para ordenar el array si fuera necesario
				//ordenarArray(arrayNotas);
				
				//Operamos con el usuario la opcion que desea visualizar
				do { 
					System.out.print("¿Que nota desea visualizar? [1-" + arrayNotas.length + "] (-1 para salir): ");
					opcion=teclado.nextInt();
					teclado.nextLine();
					if(opcion!=-1 && (opcion<1 || opcion>arrayNotas.length))
						System.out.println("Error!, el dato introducido está fuera del rango 1-" + arrayNotas.length + ".");
					else
						if(opcion!=-1)
							System.out.println("La nota pedida es la número " + opcion + " cuyo valor es: " + arrayNotas[opcion-1]);
						else
						{
							//Calculamos cual es el mayor y cual es el menor
							mayorMenorArray(arrayNotas);
							
		 					System.out.println("ADIÓS");
						}
				}while(opcion!=-1);
				
	}

}
