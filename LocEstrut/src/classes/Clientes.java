package classes;

import java.util.ArrayList;

public class Clientes {

	public static void main(String[] args) {
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente("marcos", "321", "222", "email", "18/08/1988", "Rua tal"/*, foto*/));
		clientes.add(new Cliente("maSDADos", "32341", "5442", "emailLLL", "18/08/1998", "Rua al"/*, foto*/));

	}

}
