import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class JDBCConnection {
	static Connection conn;
	
	public static Connection JDBCConnection1() {
		final String url = "jdbc:mysql://localhost:3306/qlyforumjava";
		final String user = "root";
		final String password = "quangthuan30112004";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			if(conn!=null) {
				JOptionPane.showMessageDialog(null, "Connect successfully");
			}
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	public boolean userRegister (user e) throws SQLException {
		String sql = "INSERT INTO qlyforumjava.ta_acc_useraccount (I_ACC_id, T_ACC_username, T_ACC_pass,T_ACC_email, T_ACC_phone, T_ACC_name, D_ACC_birthday) "
                + "VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		boolean isRegistered = false;
		 try {
	            
	            ps.setInt(1, e.getId());
	            ps.setString(2, e.getUsername());
	            ps.setString(3, e.getPassword());
	            ps.setString(4, e.getEmail());
	            ps.setInt(5, e.getPhone());
	            ps.setString(6, e.getName());
	            ps.setString(7, e.getBirthday());
	            ps.executeUpdate();
	            isRegistered = true;
	        } catch (Exception e1) {
	            e1.printStackTrace();
	            return false;
	        } finally {
	            // Close statement and connection when finished
	            try {
	                ps.close();
	                conn.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
		return isRegistered;  
	        
		}
	public static boolean login (String  username, String password) {
		String sql = "SELECT * FROM qlyforumjava.ta_acc_useraccount WHERE T_ACC_username=? AND T_ACC_pass=?";
		
		try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            return resultSet.next();  
        } catch (Exception e1) {
            e1.printStackTrace();
        }   
		return false;
		
	}
	public ArrayList<user> getListkhachhang(){
        ArrayList<user> list = new ArrayList<>();
        String sql = "SELECT * FROM qlforumjava"; 
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user s = new user(rs.getInt("Id"), rs.getString("Username"), 
                rs.getString("Password"), rs.getString("Email"),
                		 rs.getInt("Phone"),
                		 rs.getString("Name"), rs.getString("Birthday"));

                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public boolean addQuestion (quesContent e) {
		String sql = "INSERT INTO qlyforumjava.ta_que_question (I_QUE_id, T_QUE_title, T_QUE_content,D_QUE_credate, I_ACC_id) "
                + "VALUES(?,?,?,?,?)";
		 try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, e.getId());
	            ps.setString(2, e.getTitle());
	            ps.setString(3, e.getContent());
	            ps.setString(4, e.getCredate());
	            ps.setInt(5, e.getUserId());
	            return ps.executeUpdate() > 0;   
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }   
	        return false;
		}
	public boolean addAnswer (ansContent e) {
		String sql = "INSERT INTO qlyforumjava.ta_ans_answer (I_ANS_id, T_ANS_content, D_ANS_credate,I_ACC_id, I_QUE_id) "
                + "VALUES(?,?,?,?,?)";
		 try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, e.getId());
	            ps.setString(2, e.getCredate());
	            ps.setString(3, e.getCredate());
	            ps.setInt(4, e.getUserId());
	            ps.setInt(5, e.getQuesId());
	            
	            return ps.executeUpdate() > 0;   
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }   
	        return false;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
