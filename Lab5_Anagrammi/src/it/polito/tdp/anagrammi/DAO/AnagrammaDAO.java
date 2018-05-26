package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AnagrammaDAO {


	
	
	public boolean isCorrect(String anagramma) 
	{
		
		final String sql = "SELECT nome FROM parola WHERE nome=?";
		String jdbcURL= "jdbc:mysql://localhost/dizionario?user=root&password=Martyannaraffa7";
		try {
			Connection conn= DriverManager.getConnection(jdbcURL);
			PreparedStatement st = conn.prepareStatement(sql);
			
		    st.setString(1, anagramma);
			
		    ResultSet rs = st.executeQuery();
		  if(rs.next()) {
			 
		return true;
			  
		  }
		  conn.close();
		
		return false;
	}
		 catch (SQLException e) {
				e.printStackTrace();
		 }
	return false;
	}
	
}
