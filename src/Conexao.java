import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
	
	//String url = "jdbc:sqlite:/Users/Roberto/Desktop/escol/JavaDB/javadb.db";
	String url = "jdbc:sqlite:/Users/Roberto/Documents/ECLIPSE PROYECTOS/BoraUsarSQLite/src/MiDB/javadb.db";
	Connection con;
	
	///******************************************************** Conex
	public Connection Conect() {
		try {
			con= DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conex foi");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("nao foi conex "+e);
		}
		return con;
	}
	
	///******************************************************** Insert
	public void Insert(String name) {
		String sql = "INSERT INTO TabelaT(nome) VALUES(?)";
		
		try(Connection conn = this.Conect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name); //numero de array da tabela
            pstmt.executeUpdate();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
		}
	}
	
	///******************************************************** Select
    public void Select(){
        String sql = "SELECT id, nome FROM TabelaT";
        
        try (Connection conn = this.Conect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("nome") );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

	///******************************************************** Fechar db
	public void Fechar() {
		try {
			con.close();
			System.out.println("fechou conex ");
		} catch (Exception e) {
			// TODO: handle exception
			
			Logger.getLogger(con.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}
}







