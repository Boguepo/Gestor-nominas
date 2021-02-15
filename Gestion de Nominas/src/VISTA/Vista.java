package VISTA;

import javax.swing.JOptionPane;

import EXCEPTIONS.MiExcepcion;
import OBJ.Empleado;
import OBJ.Junior;
import OBJ.Mid;
import OBJ.Senior;

public class Vista {

	public int numEmp() {

		return Integer.parseInt(JOptionPane.showInputDialog("Cuantos empleados deseas introducir?"));
	}

	public void menuPrincipal(Empleado[] emp, boolean fin) {
		String op = JOptionPane.showInputDialog("Que deseas hacer?\n" + "1.- Añadir empleado\n" +"2.- Dar bonus\n"+ "3.- Salir y imprimir\n");
		try {
		switch (op) {
		case "1":
			crearEmp(emp);
			break;
		case "2":
			if(emp[0] == null) {throw new MiExcepcion(6);}
			else {
				darBonus(emp);
			}
			break;
		case "3":
			
			if(emp[0] == null) {throw new MiExcepcion(6);}
			else {
				verNominas(emp);
				fin = true;
			}
			
			break;
		}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
		}

	}

	private void darBonus(Empleado[] emp) {
		for (int i = 0; i < emp.length; i++) {
			emp[i].darBonus();
		}
		
		JOptionPane.showMessageDialog(null, "Bonus añadido");
		
	}

	private void verNominas(Empleado[] emp) {
		for (int i = 0; i < emp.length; i++) {
			switch(emp[i].getTipoEmp()) {
			case 'B':
				System.out.println("Empleado "+(i+1)+" -------- Boss ----- Sueldo Mensual: [b/n]" +emp[i].getSueloMes()[0]+"  /  "+emp[i].getSueloMes()[1]+" --------- Sueldo Anual: [b/n] "+emp[i].getSueloAno()[0]+"  /  "+emp[i].getSueloAno()[1] );
				break;
			case 'M':
				System.out.println("Empleado "+(i+1)+" -------- Manager ----- Sueldo Mensual: [b/n]" +emp[i].getSueloMes()[0]+"  /  "+emp[i].getSueloMes()[1]+" --------- Sueldo Anual: [b/n] "+emp[i].getSueloAno()[0]+"  /  "+emp[i].getSueloAno()[1] );
				break;
			case 'S':
				System.out.println("Empleado "+(i+1)+" -------- Senior ----- Sueldo Mensual: [b/n]" +emp[i].getSueloMes()[0]+"  /  "+emp[i].getSueloMes()[1]+" --------- Sueldo Anual: [b/n] "+emp[i].getSueloAno()[0]+"  /  "+emp[i].getSueloAno()[1] );
				break;
			case 'm':
				System.out.println("Empleado "+(i+1)+" -------- Mid ----- Sueldo Mensual: [b/n]" +emp[i].getSueloMes()[0]+"  /  "+emp[i].getSueloMes()[1]+" --------- Sueldo Anual: [b/n] "+emp[i].getSueloAno()[0]+"  /  "+emp[i].getSueloAno()[1] );
				break;
			case 'J':
				System.out.println("Empleado "+(i+1)+" -------- Junior ----- Sueldo Mensual: [b/n]" +emp[i].getSueloMes()[0]+"  /  "+emp[i].getSueloMes()[1]+" --------- Sueldo Anual: [b/n] "+emp[i].getSueloAno()[0]+"  /  "+emp[i].getSueloAno()[1] );
				break;
			case 'V':
				if(emp[i].isAyudaV()) {
					System.out.println("Empleado "+(i+1)+" -------- Voluntario ----- Ayuda: "+emp[i].getSueloMes()[0]);
				}
				System.out.println("Empleado "+(i+1)+" -------- Voluntario ----- No tiene ayuda");
				break;
			}
		}
	}

	private void crearEmp(Empleado[] emp) {
		for (int i = 0; i < emp.length; i++) {

			String op = JOptionPane.showInputDialog("Tipo de empleado:\n" + "1.- Boss\n" + "2.- Manager\n"
					+ "3.- Senior\n" + "4.- Mid\n" + "5.- Junior\n" + "6.- Voluntario");

			switch (op) {
			case "1":
				comprobarEmp(emp, i, 'B');
				break;
			case "2":
				comprobarEmp(emp, i, 'M');
				break;
			case "3":
				comprobarEmp(emp, i, 'S');
				break;
			case "4":
				comprobarEmp(emp, i, 'm');
				break;
			case "5":
				comprobarEmp(emp, i, 'J');
				break;
			case "6":
				comprobarEmp(emp, i, 'V');
				break;
			}
		}

	}

	private void comprobarEmp(Empleado[] emp, int i, char c) {
		boolean valido = false;
		while (valido == false) {
			try {
				String sueldo1 = pedirSueldo(c);
				int sueldo = Integer.parseInt(sueldo1);
				
				switch (c) {
				case 'B':
					
					if (sueldo <= 8000) {
						throw new MiExcepcion(1);
					} else {
						emp[i] = new Empleado('B', sueldo);
						valido = true;
						
					}

					break;
				case 'M':
					if (sueldo <= 3000 && sueldo >= 5000) {
						throw new MiExcepcion(2);
					} else {
						emp[i] = new Empleado('M', sueldo);
						valido = true;
					}
					break;
				case 'S':
					if (sueldo <= 2700 && sueldo >= 4000) {
						throw new MiExcepcion(3);
					} else {
						emp[i] = new Senior('S', sueldo);
						valido = true;
					}
					break;
				case 'm':
					if (sueldo <= 1800 && sueldo >= 2500) {
						throw new MiExcepcion(4);
					} else {
						emp[i] = new Mid('m', sueldo);
						valido = true;
					}
					break;
				case 'J':

					if (sueldo <= 900 && sueldo >= 1600) {
						throw new MiExcepcion(5);
					} else {
						emp[i] = new Junior('J', sueldo);
						valido = true;
					}
					break;
				case 'V':
					String letra = sueldo1.toLowerCase();
					if(letra.equals("s")) {
						emp[i] = new Empleado('v',300);
						valido = true;
					}else {
						emp[i] = new Empleado('V',0);
						valido = true;
					}
					break;
				}
				i++;
			} catch (MiExcepcion e) {
				JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
			}
		}
	}

	private String pedirSueldo(char c) {
		String sueldo = "";
		if(c == 'V') {
			sueldo = JOptionPane.showInputDialog("El voluntario recibe ayudas? [s/n]");
		}else {
			sueldo = JOptionPane.showInputDialog("Introduce sueldo bruto mensual:");
		}
		return sueldo;
	}

}
