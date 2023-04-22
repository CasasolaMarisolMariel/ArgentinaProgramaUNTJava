package programacionOO;

public class Carrito {
		private int numC;
		private Cliente cli;
		private double montoTotal;
	public Carrito(int num,Cliente cli) {
		this.numC=num;
		this.cli=cli;
		this.montoTotal=00.00;
	}
	public int dameNumC() {
		return numC;
	}
	public Cliente dameCliente() {
		return cli;
	}
	public double dameMonto(double total) {
		montoTotal= total;
		return montoTotal;
	}
	public void mostrarMontoTotal(double total) {
		montoTotal=total;
		System.out.println("El monto total del Carrito es : $" +montoTotal);
	}

}
