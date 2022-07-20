import java.util.InputMismatchException;
import java.util.Scanner;

public class MaquinaDeCafe {
	int inventario[];
	String receta1[];
	String receta2[];
	String receta3[];
	public MaquinaDeCafe(int[] inventario, String[] receta1, String[] receta2, String[] receta3) {
		super();
		this.inventario = inventario;
		this.receta1 = receta1;
		this.receta2 = receta2;
		this.receta3 = receta3;
	}

	

	public static void main(int inventario[], String receta1[], String receta2[], String receta3[]) {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		while (true) {
			System.out.println("Maquina de cafe");
			System.out.println("Opcion 1: Agregar inventario");
			System.out.println("Opcion 2: Verificar inventario");
			System.out.println("Opcion 3: Comprar bebida");
			if(scanner.nextLine().equals("1")) {
			    try {
			    	agregarInventario(inventario);
			        // do stuff
			    } catch (InputMismatchException e){
			    	System.out.println("Formato invalido, agrega numero valido de unidades a agregar. ");
			    }
			}
			if(scanner.nextLine().equals("end")) {
				break;	
			}
			if(scanner.nextLine().equals("2")) {
				// verificar inventario function
				verificarInventario(inventario);	
			}
			if(scanner.nextLine().equals("3")) {
				// Comprar bebida function
				System.out.println("Ingrese dinero: ");
			    try {
			    	String dinero = scanner.nextLine();  // Read user input
			    	if (Integer.valueOf(dinero)>0) {
			    		System.out.println("Vuelto/devolución de dinero: "+ String.valueOf(comprarBebida(Integer.valueOf(dinero), inventario, receta1, receta2, receta3)));
			    	} else{
			    		System.out.println("Cantidad de dinero debe ser mayor a 0.");
			    	}
			        // do stuff
			    } catch (NumberFormatException e){
			    	System.out.println("Ingresa una cantidad de dinero correcta.");
			    }

			} else {
				System.out.println("Opcion invalida, ingresa el numero de una opción valida.");
			}
		}

	}
	
	
	public static String agregarInventario(int inventario[]) {
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Unidades de Cafe a agregar: ");
		int cafe = scanner2.nextInt();  // Read user input
		System.out.println("Unidades de Leche a agregar: ");
		int leche = scanner2.nextInt();  // Read user input
		System.out.println("Unidades de Chocolate a agregar: ");
		int chocolate = scanner2.nextInt();  // Read user input
		System.out.println("Unidades de Azucar a agregar: ");
		int azucar = scanner2.nextInt();  // Read user input
		inventario[0]+=cafe;
		inventario[1]+=leche;
		inventario[2]+=chocolate;
		inventario[3]+=azucar;
		System.out.println("Unidades agregadas exitosamente");
		return "1";
	    // do stuff


		    //System.out.println("Formato invalido, agrega numero valido de unidades a agregar. ");
	}
			
		



	
	
	public static boolean verificarDisponibilidad(int inventario[], String receta[]) {
		if (inventario[0]>= Integer.parseInt(receta[2])  && inventario[1] >= Integer.parseInt(receta[3])  && inventario[2] >= Integer.parseInt(receta[4]) && inventario[3] >= Integer.parseInt(receta[5])) {
			return true;
			
		} else {
			return false;
		}
	}
	
	public static String verificarInventario(int inventario[]) {
		System.out.println("Unidades de Cafe: "+ String.valueOf(inventario[0]));
		System.out.println("Unidades de Leche: "+ String.valueOf(inventario[1]));
		System.out.println("Unidades de Chocolate: "+ String.valueOf(inventario[2]));
		System.out.println("Unidades de Azucar: "+ String.valueOf(inventario[3]));
		return "1";
	}
	
	
	public static int comprarBebida(int dinero,int inventario[], String receta1[], String receta2[], String receta3[]) {
		Scanner scanner3 = new Scanner(System.in);
		System.out.println("Opcion 1: Comprar Cafe");
		System.out.println("Opcion 2: Comprar Cafe con leche");
		System.out.println("Opcion 3: Comprar Cafe moca");
		String opcion = scanner3.nextLine();  // Read user input
		if(opcion.equals("1")) {
			// comprar cafe
			if (Integer.compare(dinero, Integer.parseInt(receta1[1]))==1 || Integer.compare(dinero, Integer.parseInt(receta1[1]))==0) {
				if(verificarDisponibilidad(inventario, receta1)==true) {
					System.out.println("Su bebida Cafe esta lista”");	
					inventario[0]-=Integer.parseInt(receta1[2]);
					inventario[1]-=Integer.parseInt(receta1[3]);
					inventario[2]-=Integer.parseInt(receta1[4]);
					inventario[3]-=Integer.parseInt(receta1[5]);
					return dinero-Integer.parseInt(receta1[1]);
				} else {
					System.out.println("No hay inventario para hacer la bebida, intente más tarde.");	
					return dinero;
				}
			} else {
				System.out.println("No tienes suficiente dinero, se hace devolución del dinero ingresado.");
				return dinero;
			}
		}
		if(opcion.equals("2")) {
			// comprar cafe con leche
			if (Integer.compare(dinero, Integer.parseInt(receta2[1]))==1 || Integer.compare(dinero, Integer.parseInt(receta1[1]))==0) {
				if(verificarDisponibilidad(inventario, receta2)==true) {
					System.out.println("Su bebida Cafe esta lista”");	
					inventario[0]-=Integer.parseInt(receta2[2]);
					inventario[1]-=Integer.parseInt(receta2[3]);
					inventario[2]-=Integer.parseInt(receta2[4]);
					inventario[3]-=Integer.parseInt(receta2[5]);
					return dinero-Integer.parseInt(receta2[1]);
				} else {
					System.out.println("No hay inventario para hacer la bebida, intente más tarde.");
					return dinero;
				}
			} else {
				System.out.println("No tienes suficiente dinero, se hace devolución del dinero ingresado.");
				return dinero;
			}
			
		}
		if(opcion.equals("3")) {
			// Comprar cafe moka
			if (Integer.compare(dinero, Integer.parseInt(receta3[1]))==1 || Integer.compare(dinero, Integer.parseInt(receta3[1]))==0) {
				if(verificarDisponibilidad(inventario, receta3)==true) {
					System.out.println("Su bebida Cafe esta lista”");	
					inventario[0]-=Integer.parseInt(receta3[2]);
					inventario[1]-=Integer.parseInt(receta3[3]);
					inventario[2]-=Integer.parseInt(receta3[4]);
					inventario[3]-=Integer.parseInt(receta3[5]);
					return dinero-Integer.parseInt(receta3[1]);
				} else {
					System.out.println("No hay inventario para hacer la bebida, intente más tarde.");
					return dinero;
				}
			} else {
				System.out.println("No tienes suficiente dinero, se hace devolución del dinero ingresado.");
				return dinero;
			}
		} else {
			System.out.println("Ingresa el numero de una opción valida.");
		}
		return -2;
	}


}
