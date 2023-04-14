import java.util.Scanner;

public class calculadora {
	double num1,num2;
	public static void main(String[] args)  {
		boolean band=true;
		while (band) {
			System.out.println("MENÚ");
			System.out.println("Ingrese el numero segun la operacion que desee realizar");
			System.out.println("1.Sumar 2.Restar 3.Multiplicar 4. Dividir 5.Limpiar 6.Salir");
			Scanner opcion=new Scanner(System.in);
			String ope= opcion.nextLine();
			int op= Integer.parseInt(ope); 
			if (op==5) {
				System.out.println("Pantalla limpia");
			}
			else{
				if (op==6) {
					System.out.println("Exit");
					break;
				}
				else {
					System.out.println("Ingrese dato a");
					Scanner data= new Scanner(System.in);
					String nume1=data.nextLine();
					System.out.println("Ingrese dato b");
					Scanner nume=new Scanner(System.in);
					String nume2=nume.nextLine();
					double num1=Double.parseDouble(nume1);
					double num2=Double.parseDouble(nume2);
					switch (op){
					case 1:
						double opSuma=sumando(num1,num2);
						System.out.println(opSuma);
						break;
					case 2:
						double opResta=restar(num1,num2);
						System.out.println(opResta);
						break;
					case 3:
						double opProd=multiplicar(num1,num2);
						System.out.println(opProd);
						break;
					case 4:
						if (num2!=0){
							double opDivi=dividir(num1,num2);
							System.out.println(opDivi);
							break;}
					case 6:
						System.out.println("calculadora limpia");
						break;
					default:
						break;
				}
				}
					}}}
		public static double sumando(double unNumero,double otroNumero) {
			double suma=unNumero+otroNumero;
				return suma;
		}
		public static double restar(double unNumero,double otroNumero) {
			double resta=unNumero-otroNumero;
			return resta;
		}
		public static double multiplicar(double unNumero,double otroNumero) {
			double prod=unNumero*otroNumero;
			return prod;
		}
		public static double dividir (double unNumero,double otroNumero) {
			double divi=unNumero/otroNumero;
			return divi;
		}
		
	}
		
			
