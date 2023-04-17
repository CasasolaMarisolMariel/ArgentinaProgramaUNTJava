package programacionOO;

public class Carrito {
		private int numC;
		private Cliente cli;
		private double montoTotal;
	public Carrito(int num,Cliente cliente) {
		numC=num;
		cli=cliente;
		montoTotal=0.0;
	}
	public int dameNumC() {
		return numC;
	}
	public Cliente dameCliente() {
		return cli;
	}
	public double dameMonto() {
		return montoTotal;
	}
	public void mostrarMontoTotal(double total) {
		montoTotal=total;
		System.out.println("El monto total del Carrito es : " +montoTotal);
	}

}
