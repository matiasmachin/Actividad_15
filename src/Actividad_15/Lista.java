package Actividad_15;



import com.itextpdf.text.*;


import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.util.*;
import java.io.*;
import java.io.ObjectInputStream.GetField;







public class Lista {
	public static final String SEPARATOR=";";
	   public static final String QUOTE="\"";


	
	static Scanner sc = new Scanner(System.in);

	static ArrayList<Persona> lista = new ArrayList();
	

	public static void main(String[] args) throws IOException, CsvException {
		boolean bandera=false;
		 FileReader archCSV = null;
		 CSVReader csvReader = null;
		
	
		
		while(bandera==false) {
			System.out.println("\n\n Ejercicio 15 Archivo PDF \n\n");
			System.out.println(" Menu Principal: \n\n\n");
			System.out.println("1.- Cargar Datos.");
			System.out.println("2.- Mostrar Todos Los Datos.");
			System.out.println("3.- Insertar un Nuevo Registro.");
			System.out.println("4.- Eliminar un Registro.");
			System.out.println("5.- Mostrar el Numero de Registros.");
			System.out.println("6.- Buscar Persona por D.N.I.");
			System.out.println("7.- Buscar Persona por Nombre.");
			System.out.println("8.- Ordenar los Registros.");
			System.out.println("9.- Guadar Registros en Archivo CSV.");
			System.out.println("10.- Crear archivo PDF.");
			System.out.println("11.- Salir del Menu.");
			System.out.print("Introduzca su opcion:   ");
			Scanner opcion=new Scanner(System.in);
			int opcc=opcion.nextInt();
			switch (opcc) {
			case 1:
				 System.out.println("\n Carga de Datos\n");
				 cargar();
				 break;
			case 2:
				System.out.println("\n Mostrar Todos los Datos\n");
				listar();
				pausa();
				break;
			case 3:
				System.out.println("\n Insertar un Nuevo Registro");
				insertar();
				break;
			case 4:
				System.out.println("\n Eliminar un Registro");
				eliminar();
				break;
			case 5:
				System.out.println("\n Mostrar el Numero de Registros");
				contar();
				break;
			case 6:
				System.out.println("\n Buscar Persona por D.N.I.");
				buscardni();
				break;	
			case 7:
				System.out.println("\n Buscar Persona por Nombre");
			    buscarnombre();
			  	break;	
			case 8:
				System.out.println("\n Ordenar Registros");
			    ordenar1();
			    listar();
				break;	
			case 9:
				System.out.println("\n Guardar Registros en Archivo CSV");
				crearArchivo();
				mostrarcsv();
		       break;	
			case 10:
				System.out.println("\n Crear Archivo PDF.");
			    guardarpdf();
				break;	
			case 11:
				System.out.println("\n Salir del sistema");
				System.out.println("\n Adios.....");
				bandera=true;
				break;
			default:
				System.out.println("\n Esta opcion no esta disponible");
				
			}
		}
		
	}

	public static void cargar()  {
		
		// atributo 
		Persona aux;
		int i=1;
		String nom="";
		String ape="";
		int dni2=0;
		int edad2=0;
		String calle2="";
		int nro2=0;
		int cp2=0;
		String prov="";
		  FileReader archCSV = null;
		    CSVReader csvReader = null;
		try {
		      archCSV = new FileReader("tabla1.csv");
		      CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
		      csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
		      String[] fila = null;
		      while((fila = csvReader.readNext()) != null) {
		    	  nom=fila[0];
		            ape=fila[1];
		            dni2=Integer.parseInt(fila[2]);;
		            edad2=Integer.parseInt(fila[3]);
		            calle2=fila[4];
		            nro2=Integer.parseInt(fila[5]);
		            cp2=Integer.parseInt(fila[6]);
		            prov=fila[7];
		            aux = new Persona(nom,ape,dni2,edad2,calle2,nro2,cp2,prov);
		            lista.add(aux);
		            System.out.println(Arrays.toString(fila));
		            }

		    }
		    catch(IOException e) {
		      System.out.println(e);
		    }
		    catch(Exception e) {
		      System.out.println(e);
		    }
		    finally {
		      try { 
		        archCSV.close();
		        csvReader.close();
		      }
		      catch(IOException e) {
		        System.out.println(e);
		      }
		    }
		  }
		
		

	
	
	
	

	private static String[] removeTrailingQuotes(String[] datos) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void listar() {
	int i=1;
	Iterator it = lista.iterator();
	while (it.hasNext()) {
		Object objeto=it.next();
		Persona producto=(Persona)objeto;
		System.out.println("El Registro Nro :" + i + "  Es el siguiente: " );
		System.out.println(producto);
		i++;
		}
	System.out.println("FIN DE LA LISTA"+"\n\n\n");
	
	}
	
	
public static void insertar() {
		
		// atributo 
		Persona aux;
		int xx=0;
		
		
		// Registros de prueba
		
		aux = new Persona("Matias","Machin Casanas",79060996,45,"Calle El Canal",3,38911,"Santa cruz de tenerife");
		lista.add(aux);                             // anadir registro a la lista
		xx=lista.size();
		System.out.println("\n Registro  Insertado");
		System.out.println("Nro de Registros: "+ lista.get(xx-1));
		
	}

public static void contar() {
	
	// atributo 
	Persona aux;
	
	// Registros de prueba
	
	System.out.println("Nro de Registros: "+ lista.size());
	                    // anadir registro a la lista
								
}

public static void eliminar() {
	
	int op=0;
	boolean bandera=false;
	
	Scanner teclado=new Scanner(System.in);
	Scanner tec=new Scanner(System.in);
			
	System.out.println("Indique el Nro del Registro que desea eliminar: ");
	op=teclado.nextInt();
		
	    if (op>=0 && op<=lista.size()) {
	       
		System.out.println("Nro de Registros: "+ lista.get(op-1));
		System.out.println(" Menu:");
		System.out.println("1.- Borrar registro:");
		System.out.println("2.- Salir:");
		int opc1=tec.nextInt();
		switch (opc1) {
		case 1:
			lista.remove(op-1);
			System.out.println( "El registro Nro: " + op + " ha sido eliminado");
			listar();
			contar();
			break;
		case 2:
			System.out.println( "El registro Nro: " + op + " NO ha sido eliminado");
			listar();
			break;
		          }
		
			
	    }	
		else 
		{
			System.out.println( "El registro Nro: " + op + " NO EXISTE");
		}

			
	}
	
public static void buscardni() {
	
	
	System.out.println("Introduce el D.N.I: a buscar: ");
	int dni3 = sc.nextInt();
	System.out.println("Lista de Registro con el D.N.I: "+ dni3);
	int j=0;
	int m=0;
	int tama=(lista.size());
	while( j!=tama) {
	if (dni3==lista.get(j).getDni()) {
				System.out.println(lista.get(j));
	          
	}
	j++;
	}

}

public static void buscarnombre() {
	
	
	System.out.println("Introduce el Nombre: a buscar: ");
	String nombre1 = sc.nextLine();
	System.out.println("Lista de Registro con el nombre de: "+ nombre1);
	int j=0;
	int m=0;
	int tama=(lista.size());
	while( j!=tama) {
	if (lista.get(j).getNombre().equalsIgnoreCase(nombre1)) {
				System.out.println(lista.get(j));
	          
	}
	j++;
	}
	}

public static void ordenar1() {
	Collections.sort(lista, new Comparator<Persona>() {
		public int  compare(Persona p1, Persona p2) {
			return new String (p1.getNombre()).compareTo(new String (p2.getNombre()));
		}
	});
}




	public static void crearArchivo() {
		final String NEXT_LINE = "\n";
		final String delim=",";
		try {
			FileWriter fw = new FileWriter("archivonuevo.csv");
            for (int a=0; a!=lista.size();a++) {
			fw.append(lista.get(a).getNombre()) .append(delim);
			fw.append(lista.get(a).getApellido()) .append(delim);
			int x1=(lista.get(a).getEdad());  // variable tipo entero (int)  temporal de campo edad 
			String xx1=Integer.toString(x1);	 // pasar de entero a String campo edad
			fw.append(xx1) .append(delim); // grabar valor de la variable en el campo edad.			
			int e=(lista.get(a).getEdad());
			String ed=Integer.toString(e);
			fw.append(ed) .append(delim);
			fw.append(lista.get(a).getCalle()) .append(delim);
			int f=(lista.get(a).getNro());
			String ef=Integer.toString(f);
			fw.append(ef) .append(delim);
			int g=(lista.get(a).getcodigop());
			String eg=Integer.toString(g);
			fw.append(eg) .append(delim);
			fw.append(lista.get(a).getProvincia()) .append(delim);
			fw.append(NEXT_LINE);
            }
			fw.flush();
			fw.close();
			System.out.println("Archivo Generado Correctamente");
			
		} catch (IOException e) {
			// Error al crear el archivo, por ejemplo, el archivo 
			// está actualmente abierto.
			e.printStackTrace();
		}
		
	}
	
public static void mostrarcsv() {
	File getCSVFiles = new File("archivonuevo.csv");
    Scanner sc = null;
	try {
		sc = new Scanner(getCSVFiles);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    sc.useDelimiter(",");
    while (sc.hasNext())
    {
        System.out.print(sc.next()+",");
    }
    sc.close();  
}


public static void guardarpdf() throws FileNotFoundException {
	try {
		String nom3="";
		String ape3="";
		String dni3="";
		String edad3="";
		String calle3="";
		String nro3="";
		String cp3="";
		String prov3="";
		String aux3="";
		ArrayList<String> listadopdf=new ArrayList<String>();
		//listadopdf.add(lista.get(0));
		listadopdf.add("Pedro, Brito Sanchez, 44444444, 30, C/ Los Pinos, 25, 38403, Las Palmas");
		listadopdf.add("Julio, Garcia Santos, 11111111, 23, C/ Los olivos, 3, 38493, Tenerife");
		listadopdf.add("Ana , Mendez Nuñez, 22222222, 22, C/ Los Pinos, 25, 38403, Tenerife");
		listadopdf.add("Maria , Sanchez Camacho, 33333333, 45, C/ Los Franceces, 23, 38505, Las Palmas");
		listadopdf.add("Julio, Brito Sanchez, 44444444, 30, C/ Los Pinos, 25, 38403, Las Palmas");
		Document documento= new Document();
		OutputStream outputStream= new FileOutputStream(new File("listadopdf.pdf"));
		PdfWriter.getInstance(documento, outputStream);
		documento.open();
		documento.add(new Paragraph("Listado:"));
		documento.add(Chunk.NEWLINE);
		for(String persona3: listadopdf) {
			documento.add(new Paragraph(persona3));
		}
		//Obtenemos la instancia de la imagen/logo.
        Image imagen = Image.getInstance("logo.png");
        //Alineamos la imagen al centro del documento.
        imagen.setAlignment(Image.ALIGN_CENTER);
        //Agregamos la imagen al documento.
        documento.add(imagen);
		documento.close();
		outputStream.close();
		System.out.println("documento creado correctamente");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	
		


		}
		
public static void pausa() {
	
	String seguir;
    Scanner teclado = new Scanner(System.in);
    System.out.println("Press Enter key to continue...");
    try
    {
        seguir = teclado.nextLine();
    }
    catch(Exception e)
    {}
	    
}




}
