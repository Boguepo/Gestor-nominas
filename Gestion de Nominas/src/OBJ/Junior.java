package OBJ;

public class Junior extends Empleado{
	
	private static final double RED_DEF = 0.15;//reduccion de sueldo del 15%
	


	public Junior(char tipoEmp, double sueloMesBruto) {
		
		super(tipoEmp,sacarSueldo(sueloMesBruto));
	}
	
	private static double sacarSueldo(double sueldo) {
		
		return sueldo -(sueldo * RED_DEF);
	}
}
