package programacionOO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner; 

public class Compras {
	public static void main(String[] args) {
	ConexionBD conexion_c = new ConexionBD();
	Connection cn_c = null;
	Statement stm = null;
	ResultSet rs = null;
	ResultSet rs2=null;
	try {
		cn_c = conexion_c.conectar();
		stm = cn_c.createStatement();
		System.out.println("---Seccion de ingreso de productos que desea comprar---" );
		System.out.print("nro de carro: ");
		Scanner numCar=new Scanner (System.in);
		String numc= numCar.nextLine();
		int numCarr= Integer.parseInt(numc);
		
		
		System.out.println("Cantidad de productos que desea ingresar: ");
		Scanner cant= new Scanner (System.in);
		String c=cant.nextLine();
		int cant_p= Integer.parseInt(c);
		double total=0;
		System.out.println("cant\tprecioUnitario\tproducto");
		for (int i=0;i<cant_p;i++) {
			System.out.print("Codigo del producto:");
			Scanner sc= new Scanner (System.in);
			String cod=sc.nextLine();
			System.out.print("Ingrese la cantidad: ");
			Scanner cp=new Scanner (System.in);
			String cant_pr=cp.nextLine();
			int cantidad=Integer.parseInt(cant_pr);
			String query="SELECT * FROM productos WHERE id="+cod;
			rs=stm.executeQuery(query);
			while (rs.next()) {
				int id= rs.getInt(1);
				String nombre=rs.getString(2);
				String desc=rs.getString(3);
				double prec=rs.getDouble(4);
				int stock=rs.getInt(5);
				stock=stock-cantidad;
				double prec_mod=prec*cantidad;
				total=total+prec_mod;
				System.out.println(cantidad +"\t"+prec+"\t"+nombre);
				//ItemCarrito itemC1= new ItemCarrito(1,nombre,cantidad);
				//MODIFICO EL STOCK Y PUEDO ACTUALIZARLO DESPUÉS EN LA BD
				//System.out.print("El nuevo stock es: " +stock);
			}}
			
			System.out.print("Ingrese el cuil del cliente: ");
			Scanner cl=new Scanner(System.in);
			String cliente= cl.nextLine();
			int client= Integer.parseInt(cliente);
			String consulta="SELECT * FROM clientes WHERE cuil="+client;
			rs2=stm.executeQuery(consulta);
			while (rs2.next()) {
				// sql cuil nombre apellido dni direccion
				int cuil=rs2.getInt(1);
				String nom=rs2.getString(2);
				String ap=rs2.getString(3);
				int dni=rs2.getInt(4);
				String dirC=rs2.getString(5);
				//cargo cliente del carro de compra 
				Cliente c1=new Cliente(cuil,dni,nom,dirC,ap);	
				Carrito carro=new Carrito (numCarr,c1);
				
				//cargar los datos de compra en tabla compras
				//BD id_carro,numCarro,cuilCliente,monto,fecha
				LocalDateTime fecha= LocalDateTime.now();
				//cuilCliente client
				//numCarr 
				double diner=0;
				//seccion descuentos
				Descuento d1=new DescuentoPorcentaje();
				d1.asignarValorDesc(20);
				Descuento tope=new DescuentoPorcT();
				tope.asignarValorDesc(50);
				if (d1.dameValorDesc()>=tope.dameValorDesc()) {
					System.out.println("No se aplica descuento,el tope es del: " +tope.dameValorDesc() +" %");
					carro.mostrarMontoTotal(total);
					diner= carro.dameMonto(total);
				}
				else {
					if (total>0) {
						System.out.println("Hay un descuento del : " +d1.dameValorDesc() +"%");
						carro.mostrarMontoTotal(total);	
						System.out.println("Se debe pagar: $" +d1.valorFinal(total));
						diner=d1.valorFinal(total);
					}
					else {
						if (total==0) {
							System.out.println("El monto es 0 no se aplica descuento");
						}
						else {
							System.out.println("No se aplican descuentos a montos menores a 0");
						}
					}}	
				//INSERTO EN LA BD LOS DATOS DE COMPRAS 	
				String qr= "insert into compras (numCarro,cuilCliente,monto,fecha) values ("+numCarr+","+client+","+diner+","+"'"+fecha+"');";
					stm.executeUpdate(qr);
					try{
						System.out.println("Se cargo el carrito con exito");
					} catch (Exception e) {
						System.out.println("Error");
					}
		}
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}}}