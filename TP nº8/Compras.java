package programacionOO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Compras {

	public static void main(String[] args) {
		LocalDate dia=LocalDate.now();
		System.out.println(dia);
		System.out.println("Lista de productos del Carrito: " );
		//OBJETOS PRODUCTO
		Producto p1=new Producto(100,"Dulce de leche","Repostero x500g",450.30,1000);
		Producto p2=new Producto(101,"Leche","En polvo x500grs.",200,1000);
		Producto p3=new Producto(102,"Pan","Casero x500grs",150,500);
		Producto p4=new Producto(103,"Cafe","Frasco x 500 grs",450.30,1000);
		Producto p5= new Producto (104,"Salchichas","OTTO x6 unidades", 205.15,300);
		Producto p6=new Producto(105,"Huevo","6 unidades",300,1000);
		Producto p7= new Producto(106,"Papel Higienico","4 unidades x80mts",600.00,1500);
		//OBJETOS CLIENTE
		Cliente c1=new Cliente(1,47588745,"Marta Juarez","Los ceibos 432");
		Cliente c2=new Cliente(2,47599547,"Roberto Rodriguez","Siempre viva 123");
		Cliente c3=new Cliente(35,24588777,"Martina Rodriguez","Villa primavera 547");
		Cliente c4=new Cliente(98,18478574,"Alicia Escalera","Los ceibos 123");
		
	//System.out.println("Codigo " +p1.muestra_cod()+" Nombre: "+p1.muestra_nombre()+" Precio: " +p1.muestra_precio());
	//System.out.println("Codigo " +p2.muestra_cod()+" Nombre: "+p2.muestra_nombre()+" Precio: " +p2.muestra_precio());
	//System.out.println("Codigo " +p3.muestra_cod()+" Nombre: "+p3.muestra_nombre()+" Precio: " +p3.muestra_precio());
	//System.out.println("Codigo " +p4.muestra_cod()+" Nombre: "+p4.muestra_nombre()+" Precio: " +p4.muestra_precio());
	//System.out.println("Codigo " +p5.muestra_cod()+" Nombre: "+p5.muestra_nombre()+" Precio: " +p5.muestra_precio());
	//System.out.println("Codigo " +p6.muestra_cod()+" Nombre: "+p6.muestra_nombre()+" Precio: " +p6.muestra_precio());
	//System.out.println("Codigo " +p7.muestra_cod()+" Nombre: "+p7.muestra_nombre()+" Precio: " +p7.muestra_precio());
		//carro
		Carrito carro=new Carrito(25,c1);
		
		//crear un vector con 3 elementos
		//ItemCarrito itemC[]=new ItemCarrito[3];
		//itemC[0]=new ItemCarrito(carro,p1,2);
		/*Numero de carrito, producto 1, recibo dos unidades*/
		//itemC[1]=new ItemCarrito(carro,p2,3);
		//itemC[2]=new ItemCarrito(carro,p3,2);
		//ItemCarrito.mostrarTitulo();
		//mostrarItems(itemC,carro,c1);
		
		ItemCarrito itemC1= new ItemCarrito(carro,p1,2);
		ItemCarrito itemC2= new ItemCarrito(carro,p2,5);
		ItemCarrito itemC3= new ItemCarrito(carro,p3,4);
		ItemCarrito itemC4= new ItemCarrito(carro,p4,2);
		ItemCarrito itemC5= new ItemCarrito(carro,p5,1);
		List<ItemCarrito> itemL;
		itemL=new ArrayList<ItemCarrito>();
		itemL.add(itemC1);
		itemL.add(itemC2);
		itemL.add(itemC3);
		itemL.add(itemC4);
		itemL.add(itemC5);
		mostrarItems(itemL,carro,c1);
	}
	public static void mostrarItems(List itemL,Carrito carro,Cliente c) {
		double total=0.0;
		Iterator<ItemCarrito> itL=itemL.iterator();
		//for (ItemCarrito lista:vec) {
			//lista.mostrarItems();
			//total=total+lista.dameSub();
		boolean mostrarTitulo=true;
		while (itL.hasNext()) {
			ItemCarrito datosI=itL.next();
			if (mostrarTitulo) {
				mostrarTitulo=false;
				datosI.mostrarTitulo();
			}
			datosI.mostrarItems();
			total=total+datosI.dameSub();
		}
		
		carro.mostrarMontoTotal(total);
		
		//carro.mostrarMontoTotal(total);
		//Descuento d1=new DescuentoFijo();
		//d1.asignarValorDesc(250);//monto fijo descuento
		//System.out.println("Hay un descuento fijo de : $ " +d1.dameValorDesc() );
		//System.out.println(d1.valorFinal(total));
		Descuento d1=new DescuentoPorcentaje();
		d1.asignarValorDesc(20);
		Descuento tope=new DescuentoPorcT();
		tope.asignarValorDesc(50);
		if (d1.dameValorDesc()>=tope.dameValorDesc()) {
			System.out.println("No se aplica descuento,el tope es del: " +tope.dameValorDesc() +" %");
			System.out.println("Debe abonar: $ " +total);
		}
		else {
			if (total>0) {
				System.out.println("Hay un descuento del : " +d1.dameValorDesc() +"%");
				System.out.println("Se debe pagar: " +d1.valorFinal(total));
			}
			else {
				if (total==0) {
					System.out.println("El monto es 0 no se aplica descuento");
				}
				else {
					System.out.println("No se aplican descuentos a montos menores a 0");
				}
			}
				
			
		}
	}
}
