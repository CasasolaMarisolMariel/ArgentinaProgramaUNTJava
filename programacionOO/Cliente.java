package programacionOO;

public class Cliente {
	private int codigo;
	//codigo=cuil 
	private int dni;
	private String nombre;
	private String dire;
	private String apellido;
	public Cliente (int cod,int dni,String nombre,String dire,String ape) {
		this.codigo=cod;
		this.dni=dni;
		this.nombre=nombre;
		this.dire=dire;
		this.apellido=ape;
	}
	public int dameDni() {
		return dni;
	}
	public int dameCod() {
		return codigo;
	}
	public String dameNombre() {
		return nombre;
	}
	public String dameDire() {
		return dire;
	}
	public String dameApe() {
		return apellido;
	}
}
