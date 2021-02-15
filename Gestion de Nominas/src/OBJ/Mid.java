package OBJ;

public class Mid extends Empleado{
	
private static final double RED_DEF = 0.1;//reduccion de salario del 10%
	


	
	public Mid (char tipoEmp, int sueloMesBruto) {
		super(tipoEmp,sacarSueldo(sueloMesBruto));
	}

	
	private static double sacarSueldo(double sueldo) {
		
		return sueldo -(sueldo * RED_DEF);
	}
}
