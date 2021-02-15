package OBJ;

public class Empleado {
	
	private final double IRPF_BOSS = 0.32;
	private final double IRPF_MAN = 0.26;
	private final double IRPF_SEN = 0.24;
	private final double IRPF_MID = 0.15;
	private final double IRPF_JUN = 0.02;
	
	protected char tipoEmp;
	protected double sueloMes[] = new double[2];
	protected double sueloAno[] = new double[2];
	protected boolean ayudaV;

	
	public Empleado(char tipoEmp, double sueloMesBruto) {
		this.tipoEmp = tipoEmp;
		this.sueloMes[0] = sueloMesBruto;
		this.sueloAno[0] = sueloMesBruto*12;
		calcularSueldo();
	}


	private void calcularSueldo() {
		switch(this.tipoEmp) {
		case 'B':
			this.sueloMes[1] = this.sueloMes[0] -(this.sueloMes[0] * IRPF_BOSS) + (this.sueloMes[0] * 0.5);
			this.sueloAno[1] = this.sueloMes[1] * 12;
			break;
		case 'M':
			this.sueloMes[1] = this.sueloMes[0] -(this.sueloMes[0] * IRPF_MAN) + (this.sueloMes[0] * 0.1);
			this.sueloAno[1] = this.sueloMes[1] * 12;
			break;
		case 'S':
			this.sueloMes[1] = this.sueloMes[0] -(this.sueloMes[0] * IRPF_SEN);
			this.sueloAno[1] = this.sueloMes[1] * 12;
			break;
		case 'm':
			this.sueloMes[1] = this.sueloMes[0] -(this.sueloMes[0] * IRPF_MID);
			this.sueloAno[1] = this.sueloMes[1] * 12;
			break;
		case 'J':
			this.sueloMes[1] = this.sueloMes[0] -(this.sueloMes[0] * IRPF_JUN);
			this.sueloAno[1] = this.sueloMes[1] * 12;
			break;
		case 'V':
			this.sueloMes[1] = 0;
			this.sueloAno[1] = 0;
			this.ayudaV = false;
			break;
		case 'v':
			this.sueloMes[1] = this.sueloMes[0];
			this.sueloAno[1] = this.sueloAno[0];
			this.ayudaV = true;
			break;
		}
		
	}
	
	public void darBonus() {
		if(this.tipoEmp!='V' && this.tipoEmp != 'v') {
			this.sueloAno[1] += (this.sueloAno[1] * 0.1);
		}
	}

	

	/**
	 * @return the ayudaV
	 */
	public boolean isAyudaV() {
		return ayudaV;
	}


	/**
	 * @param ayudaV the ayudaV to set
	 */
	public void setAyudaV(boolean ayudaV) {
		this.ayudaV = ayudaV;
	}


	public char getTipoEmp() {
		return tipoEmp;
	}

	public void setTipoEmp(char tipoEmp) {
		this.tipoEmp = tipoEmp;
	}

	public double[] getSueloMes() {
		return sueloMes;
	}

	public void setSueloMes(double[] sueloMes) {
		this.sueloMes = sueloMes;
	}

	public double[] getSueloAno() {
		return sueloAno;
	}

	public void setSueloAno(double[] sueloAno) {
		this.sueloAno = sueloAno;
	}
	
	

}
