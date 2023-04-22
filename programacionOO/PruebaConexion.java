package programacionOO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class PruebaConexion {

	public static void main(String[] args) {
		ConexionBD conexion = new ConexionBD();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			String query="SELECT * FROM productos";
			rs=stm.executeQuery(query);
			System.out.println("id - Nombre - Descripcion - Precio - Stock");
			while (rs.next()) {
				int id= rs.getInt(1);
				String nombre=rs.getString(2);
				String desc=rs.getString(3);
				double prec=rs.getDouble(4);
				int stock=rs.getInt(5);
				System.out.println(id+" - "+nombre+" - "+desc+" - "+prec+" - "+stock);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
	}

}
