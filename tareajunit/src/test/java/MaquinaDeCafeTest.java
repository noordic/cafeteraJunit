import org.junit.Test;

import org.junit.Assert;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MaquinaDeCafeTest {
	int inventario[]= new int[]{10, 10, 10, 10};  // [cafe, leche, chocolate, azucar] en unidades
	String receta1[]= new String[]{"Cafe", "300", "4", "0", "0", "2"};
	String receta2[]= new String[]{"Cafe con leche", "500", "2", "0", "4", "2"};
	String receta3[]= new String[]{"Cafe moca", "700", "2", "2", "2", "2"};



	//@Test
//	public void testMain() {

	//	MaquinaDeCafe.main(inventario, receta1, receta2, receta3);
//	}

	@Test
	public void testAgregarInventario() {
		boolean aux;
		MaquinaDeCafe maquina= new MaquinaDeCafe(inventario, receta1,receta2,receta3);
	    try {
	    	if (maquina.agregarInventario(inventario)=="1") {
	    		aux=true;
	    		
	    	} else {
	    		aux=false;
	    	}
	    	Assert.assertTrue(aux);
	        // do stuff
	    } catch (InputMismatchException e){
	    	System.out.println("Formato invalido, agrega numero valido de unidades a agregar. ");
	    }

	}



	@Test
	public void testVerificarInventario() {
		boolean aux;
		MaquinaDeCafe maquina= new MaquinaDeCafe(inventario, receta1,receta2,receta3);
		if (maquina.verificarInventario(inventario)=="1") {
			aux=true;
		} else {
			aux=false;
		}
		Assert.assertTrue(aux);
	}

	@Test
	public void testComprarBebida() {
		boolean aux;
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		MaquinaDeCafe maquina= new MaquinaDeCafe(inventario, receta1,receta2,receta3);
		// Comprar bebida function
		System.out.println("Ingrese dinero: ");
	    try {
	    	String dinero = scanner.nextLine();  // Read user input
	    	if (Integer.valueOf(dinero)>0) {
	    		System.out.println("Vuelto/devolución de dinero: "+ String.valueOf(maquina.comprarBebida(Integer.valueOf(dinero), inventario, receta1, receta2, receta3)));
	    		if ( maquina.comprarBebida(Integer.valueOf(dinero), inventario, receta1, receta2, receta3)==700  ) {
	    			aux=true;
	    		} else {
	    			aux=false;
	    		}
	    		Assert.assertTrue(aux); 
	    	} else{
	    		System.out.println("Cantidad de dinero debe ser mayor a 0.");
	    	}
	        // do stuff
	    } catch (NumberFormatException e){
	    	System.out.println("Ingresa una cantidad de dinero correcta.");
	}  
	}
}
