package emsi.dev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import emsi.dev.config.DatabaseConfig;
import emsi.dev.util.BCryptUtil;

// Test de connexion avec BD
public class TestConnection {
	
	public static void main(String[] args) {
		Connection conn = DatabaseConfig.getConnection();
		
		if (conn != null) {
			try {
				String sql = "SELECT login, mot_de_passe FROM utilisateurs WHERE login=?";
				
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, "admin"); // Mettre son propre login
				
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					String hashed = rs.getString("mot_de_passe"); 
					boolean ok = BCryptUtil.check("admin", hashed); // Mettre son propre mdp
					System.out.println("Test login admin : " + (ok ? "REUSSI!" : "ECHOUÉ."));
				}
			} catch (SQLException e) {
                e.printStackTrace();
            }
		}
	}

}
