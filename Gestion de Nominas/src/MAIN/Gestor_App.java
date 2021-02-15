package MAIN;

import OBJ.Empleado;
import VISTA.Vista;

public class Gestor_App {

	public static void main(String[] args) {
		Vista v =  new Vista();
		Empleado emp[] = new Empleado[v.numEmp()];
		boolean fin = false;
		
		while(fin == false) {
			v.menuPrincipal(emp,fin);
		}
		

	}

}
