package programacionOO;

public abstract class Descuento {
	private double valor;
	//monto fijo o porcentaje
	public double dameValorDesc() {
		return valor;
	}
	public void asignarValorDesc(double valor) {
		this.valor=valor;
	}
	public abstract double valorFinal(double valorInicial);
	
}
	
