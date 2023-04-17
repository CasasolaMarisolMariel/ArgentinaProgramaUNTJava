package programacionOO;

public class Cliente {
	private int codigo;
	private int dni;
	private String nombre;
	private String dire;
	
	public Cliente (int cod,int dni,String nombre,String dire) {
		this.codigo=cod;
		this.dni=dni;
		this.nombre=nombre;
		this.dire=dire;
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
}
