package programacionOO;

public class Producto {
	private int codigo;
	private String nombre;
	private String desc;
	private double precio;
	private int stock;
	//MÉTODO CONSTRUCTOR
	public Producto(int cod,String nom,String des,double prec,int stc) {
		//Mismo nombre que la clase OBLIGATORIO
		codigo=cod;
		nombre=nom;
		desc=des;
		precio=prec;
		stock=stc;
		//para no usar el this.nombre por ej
		
	}
	//métodos getters para acceder a los
	//valores de los atributos
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
