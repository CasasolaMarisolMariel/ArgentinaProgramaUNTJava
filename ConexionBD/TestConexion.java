package ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.String;

public class TestConexion {
	public static void main(String[] args) {
		ConexionBDsql conexion = new ConexionBDsql();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		ResultSet rs2=null;
		ResultSet rsx=null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			//inserté un empleado nuevo
			//String query1="insert into empleados values (idE,18544784,'Roberto','Rodriguez','aleman','Logistica')";
			//String query1="UPDATE empleados set \r\n"+ "nacionalidad='argentina' where dni=45215875;";
			String query1="DELETE from departamentos where idD=2";
			
			stm.executeUpdate(query1);
			//no hace falta ponerlo en rs
			String query="SELECT * FROM departamentos";
			rs=stm.executeQuery(query);
			//String query="SELECT * FROM empleados";
			//rs=stm.executeQuery(query);
			System.out.println("idD\tnombreD\t\t\tdescD\t\t\tpresupuesto");
			while (rs.next()) {
				int idD=rs.getInt(1);
				String nombD=rs.getString(2);
				String descD=rs.getString(3);
				int presD=rs.getInt(4);
				System.out.println(idD+"\t"+nombD+"\t\t"+descD+"\t"+presD);
			}
			String consulta3="select * from empleados where departamento='Logistica'";
			rs2=stm.executeQuery(consulta3);
			System.out.println("Seleccion empleados de Logistica");
			while(rs2.next()) {
				
				int idE=rs2.getInt(1);
				int dni=rs2.getInt(2);
				String nom=rs2.getString(3);
				String ap=rs2.getString(4);
				String nac=rs2.getString(5);
				String dep=rs2.getString(6);
				System.out.println(idE+" "+dni+" " +nom+" "+ap+"      "+nac+"          "+dep);
			}
			System.out.println("MUESTRA DE REGISTROS ORDENADO POR NACIONALIDAD");
			System.out.println("DE FORMA ASCENDENTE");
			String consultax="select * from empleados order by departamento ASC;";
			rsx=stm.executeQuery(consultax);
			while(rsx.next()) {
				int idE=rsx.getInt(1);
				int dni=rsx.getInt(2);
				String nom=rsx.getString(3);
				String ap=rsx.getString(4);
				String nac=rsx.getString(5);
				String dep=rsx.getString(6);
				System.out.println(idE+" "+dni+" " +nom+" "+ap+"      "+nac+"          "+dep);
			}
			//System.out.println("idE dni nombre    apellido   nacionalidad  departamento");
			//while (rs.next()) {
			//int idE=rs.getInt(1);
			//int dni=rs.getInt(2);
			//String nom=rs.getString(3);
			//String ap=rs.getString(4);
			//String nac=rs.getString(5);
			//String dep=rs.getString(6);
			//System.out.println(idE+" "+dni+" " +nom+" "+ap+"      "+nac+"          "+dep);
				
			//}
	
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		}
		
	}