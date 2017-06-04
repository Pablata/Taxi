package taxi;

import container.Listas;
import models.Cliente;
import ventanas.*;
public class taxi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
		Cliente c1 = new Cliente(1, "", "", 20);

		Cliente c2 = new Cliente(1, "", "", 50);
		Cliente c3= new Cliente(1, "", "", 70);
		
		Listas.listaClientes.add(c1);
		Listas.listaClientes.add(c2);
		Listas.listaClientes.add(c3);

		
		Inicio t = new Inicio();
		t.run();
	}

}
