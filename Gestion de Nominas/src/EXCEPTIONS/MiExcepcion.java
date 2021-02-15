package EXCEPTIONS;

public class MiExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	private int codigoEx;

	public MiExcepcion() {
		super();
	}

	public MiExcepcion(int codigo) {
		super();
		this.codigoEx = codigo;
	}

	@Override
	public String getMessage() {

		String msg = "";

		switch (this.codigoEx) {
		case 1:
			msg = "El Boss ha de cobrar mas de 8000€";
			break;
		case 2:
			msg = "El Manager ha de cobrar entre 3000€ y 5000€";
			break;
		case 3:
			msg = "El Senior ha de cobrar entre 2700€ y 4000€";
			break;
		case 4:
			msg = "El Mid ha de cobrar entre 1800€ y 2500€";
			break;
		case 5:
			msg = "El Junior ha de cobrar entre 900€ y 1600€";
			break;
		case 6:
			msg = "Para poder imprimir ha de rellenar los empleados";
			break;
		}

		return msg;

	}

}