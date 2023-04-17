package programacionOO;

public class ItemCarrito {
	private Carrito num;
	private Producto prod;
	private int cant;
	private double subtotal;
	public ItemCarrito(Carrito numero,Producto prod,int cantidad) {
		this.num=numero;
		this.prod=prod;
		this.cant=cantidad;
		this.subtotal=this.cant*prod.muestra_precio();
	}
	public Carrito dameNum() {
		return num;
		}
	public Producto dameProd() {
		return prod;
		}
	public int dameCant() {
		return cant;
		}
	public double dameSub() {
		return subtotal;
	}
	public static void mostrarTitulo() {
		System.out.println("Cant\tPrecio\tSubtotal\tProducto");
	}
	public void mostrarItems() {
		System.out.println(cant+"\t"+prod.muestra_precio()+"\t"+prod.muestra_nombre()+"\t"+subtotal);
	
	}
	
}
	

