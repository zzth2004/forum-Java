import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class server extends JFrame implements ActionListener{
	private static final int PORT = 4444;
	static ServerSocket serverSocket; 
	ArrayList<user> kh = new ArrayList<user>();
	public void login() {
		try {
            // Khởi tạo kết nối JDBC
            Connection conn = JDBCConnection.JDBCConnection1();

            // Khởi động server socket
           

            while (true) {
            	
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String loginInfo = in.readLine();
                String[] loginParts = loginInfo.split(",");
                String username = loginParts[0];
                String password = loginParts[1];
                if(JDBCConnection.login(username,password)) {
                	JOptionPane.showMessageDialog(null, "Login successfully");
                	
                }
                
//                String sql = "SELECT * FROM lyforumjava.ta_acc_useraccount WHERE T_ACC_username=? AND T_ACC_pass=?";
//        		
//        		
//                PreparedStatement ps = conn.prepareStatement(sql);
//                ps.setString(1, username);
//                ps.setString(2, password);
//               
//                ResultSet rs = ps.executeQuery();
//
//                
//                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//                if (rs.next()) {
//                    out.println("Login successful");
//                } else {
//                    out.println("Login failed");
//                }
//
//                rs.close();
//                ps.close();
//                out.close();
//                in.close();
//                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public void register() throws HeadlessException, SQLException, ClassNotFoundException {
		try {
            // Khởi tạo kết nối JDBC
            Connection conn = JDBCConnection.JDBCConnection1();

            // Khởi động server socket
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            
            while (true) {
                
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress());
                
                
                while (true) {
                    // Chấp nhận kết nối từ Client
                    Socket socket = serverSocket.accept();
                    System.out.println("Client connected");

                    // Xử lý yêu cầu từ Client
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    String request = (String) in.readObject();
                    if (request.equals("addUser")) {
                    	int id = Integer.valueOf((String) in.readObject());
                    	String username = (String)in.readObject();
                    	String password = (String)in.readObject();
                    	String email = (String)in.readObject();
                    	int phone = Integer.valueOf((String)in.readObject());
                    	String name = (String)in.readObject();
                    	DateFormat gg = new SimpleDateFormat("yyyy-MM-dd");
                    	
                    	String birthday = gg.format(in.readObject());
                    	user clone = new user( id, username,  password,  email, phone, name,  birthday);
                    	JDBCConnection.userRegister(clone);
                    	out.writeObject("success");
                    	in.close();
                        out.close();
                        socket.close();
                        System.out.println("Client disconnected");
                    }
                }
                
//                System.out.println("Client connected from " + clientSocket.getInetAddress());
//
//                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                int id = Integer.valueOf(in.readLine());
//                String username = in.readLine();
//                String password = in.readLine();
//                String email = in.readLine();
//                int phone = Integer.valueOf(in.readLine());
//                String name = in.readLine();
////                String birthday = in.readLine();
//                DateFormat gg = new SimpleDateFormat("yyyy-MM-dd");
//    			//String ngayNhap = t5.getSelectedItem().toString();
//    			String birthday = gg.format(in.readLine());
//    			user clone = new user( id, username,  password,  email, phone, name,  birthday);
//    			if((new JDBCConnection().userRegister(clone))) {
//    				 // Gửi kết quả đăng ký cho client       
//    				kh.add(clone);
//    	            out.println("Regist successfully");
//    				} else {
//    	            out.println("Errol: Username has exits");
//    	        }
    					
    		}
				}catch (IOException e) {
			// TODO: handle exception
			
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException, HeadlessException, SQLException {
		serverSocket = new ServerSocket(PORT);
		server serset1 = new server();
        serset1.login();
        try {
			serset1.register();
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		
		
}
