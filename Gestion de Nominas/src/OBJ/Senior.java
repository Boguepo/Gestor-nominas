package OBJ;

public class Senior extends Empleado {
	
private static final double RED_DEF = 0.05;//reduccion de salario de 5%
	
	

	
	public Senior(char tipoEmp, int sueloMesBruto) {
		super(tipoEmp,sacarSueldo(sueloMesBruto));
	}

	private static double sacarSueldo(double sueldo) {
		
		return sueldo -(sueldo * RED_DEF);
	}
}
