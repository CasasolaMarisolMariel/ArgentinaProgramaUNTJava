package programacionOO;

public class DescuentoFijo extends Descuento{
	public double valorFinal(double valorInicial) {
		//valorInicial monto del carro
		return valorInicial-this.dameValorDesc();
	}
}
