import java.util.Arrays;
import java.util.Scanner;

public class EjerArrayFunBidimensional {
	
	static void inicializarArray(float[][] array)
	{
		//Inicializamos el Array
		for(int i=0; i<array.length; i++)
		{
			for(int j=0; j<array[i].length; j++)
			{
				array[i][j]=-2;
			}
		}
	}
	
	static void inicializarArrayString(String[] array)
	{
		//Inicializamos el array tipo String
		for(int i=0; i<array.length; i++)
		{
			array[i]="";
		}
	}
	
	static String introducirNombres(Scanner t, int i)
	{
		String nombre=" ";
		//Pedimos el nombre del alumno
		System.out.print("Introduzca el nombre del alumno número " + (i+1) + ": ");
		nombre=t.nextLine();
		
		return nombre;
	}
	
	static float introducirNotas(Scanner t, int i, int j, String array[])
	{
		float nota=0;
		//Pedimos al usuario las notas para introducirlas a la array
		System.out.print("Introduzca la nota [" + (j+1) + "] del alumno " + array[i] + ": ");
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
	
	static void mayorMenorArray(float[][] array)
	{
		//Calculamos cual es el mayor y cual es el menor
		float mayor = Integer.MIN_VALUE;
		float menor = Integer.MAX_VALUE;
		int posmayor=-1;
		int posmenor=-1;

		for(int i=0; i<array.length; i++)
		{
			for(int j=0; j<array[i].length; j++)
			{
				if(mayor<array[i][j])
				{
					mayor=array[i][j];
					posmayor=i+1;
				}
				if(menor>array[i][j])
				{
					menor=array[i][j];
					posmenor=i+1;
				}
			}
		}
		System.out.println("La nota Mínima es " + menor + " y corresponde con el alumno " + posmenor);
		System.out.println("La nota Máxima es " + mayor + " y correspodne con el alumno " + posmayor);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//Pruebas con Arrays de dos dimensiones cuyas columnas tienen tamaños diferentes
		
		//DECLARACIONES E INICIALIZACION
		
		//int narray[][]= {{1,2,3},{4,5}};
		
		int contador=1;
		int[][] narray;
		narray=new int[2][];
		
		for(int i=0; i<narray.length; i++)
		{
			narray[i]=new int[3-i];
			for(int j=0; j<narray[i].length; j++)
			{
				narray[i][j]=contador++;
		//		contador++;
			}
		}
		
		//VISUALIZACION
		
		System.out.println(narray[0][0] + ", " + narray[0][1] + ", " + narray[0][2]  + ";");
		System.out.println(narray[1][0] + ", " + narray[1][1] + ", " + narray[1][1]  + ";");
		System.out.println();

		for(int i=0; i<narray.length; i++)
		{
			System.out.print(Arrays.toString(narray[i]));
		}
		
		System.out.println("\n\n");
		
		for(int i=0; i<narray.length; i++)
		{
			System.out.println(i + ": " + Arrays.toString(narray[i]));
		}
		System.out.println("\n\n");
		
		for(int i=0; i<narray.length; i++)
		{
			System.out.print(i + ": ");
			for(int j=0; j<narray[i].length; j++)
			{
				System.out.print(narray[i][j] + "; ");
			}
			System.out.println();
		}
		System.out.println("\n\n");
		
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		//Declaramos las variables necesarias
				Scanner teclado=new Scanner(System.in);
				
				float[][] arrayNotas;
				String[] arrayNombres;
				int opcion=0, cantidad=0;
				
				//Preguntamos cuantas notas va a introducir el usuario
				System.out.print("¿Cuántos alumnos va a introducir en la matrix de notas?: ");
				cantidad=teclado.nextInt();
				teclado.nextLine();
				
				arrayNotas=new float[cantidad][3];
				arrayNombres=new String[cantidad];
				
				//Inicializamos el Array o Vector
				inicializarArray(arrayNotas);
				inicializarArrayString(arrayNombres);
				
				//Pedimos al usuario la cantidad de notas a introducir
				
				for(int i=0; i<arrayNombres.length; i++)
				{
					arrayNombres[i]=introducirNombres(teclado, i);
					for(int j=0; j<arrayNotas[i].length; j++)
					{
						arrayNotas[i][j]=introducirNotas(teclado, i, j, arrayNombres);
					}
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
						{
							System.out.print("Las notas pedidas del alumno " + arrayNombres[opcion-1] + " son: ");
							for(int i=0; i<arrayNotas[opcion-1].length; i++)
							{
								System.out.print("[" + arrayNotas[opcion-1][i] + "] ");
							}
							System.out.println();
						}
						else
						{
							//Calculamos cual es el mayor y cual es el menor
							mayorMenorArray(arrayNotas);
							
		 					System.out.println("ADIÓS");
						}
				}while(opcion!=-1);
	}
}
