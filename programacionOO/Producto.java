package programacionOO;

public class Producto {
	private int codigo;
	private String nombre;
	private String desc;
	private double precio;
	private int stock;
	
	public Producto(int cod,String nom,String des,double prec,int stc) {
		codigo=cod;
		nombre=nom;
		desc=des;
		precio=prec;
		stock=stc;
		
	}
	public int muestra_cod() {
		return codigo;
	}
	public String muestra_nombre() {
		return nombre;
	}
	public String muestra_desc() {
		return desc;
	}
	public double muestra_precio() {
		return precio;
	}
	public int muestra_stock() {
		return stock;
	}
	
	
}
