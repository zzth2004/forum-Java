

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GiaoDien extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien frame = new GiaoDien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitle = new JLabel("Web Học Tập");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltitle.setBounds(125, 0, 137, 25);
		contentPane.add(lbltitle);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 67, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbltitle1 = new JLabel("Cùng nhau học tập những điều hay!!!!!");
		lbltitle1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltitle1.setBounds(87, 27, 263, 25);
		contentPane.add(lbltitle1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(424, 96, 2, 2);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(49, 251, 2, 2);
		contentPane.add(scrollPane_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(424, 96, 17, 48);
		contentPane.add(scrollBar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 70, 263, 183);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 31, 243, 70);
		panel_1.add(textPane);
		
		JButton btnAnswer = new JButton("Answer");
		btnAnswer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnswer.setBounds(168, 152, 85, 21);
		panel_1.add(btnAnswer);
		
		JTextArea textAns = new JTextArea();
		textAns.setBounds(10, 134, 148, 39);
		panel_1.add(textAns);
		
		JLabel lbAns = new JLabel("Answer Area:");
		lbAns.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbAns.setBounds(20, 111, 98, 13);
		panel_1.add(lbAns);
		
		JLabel lblques = new JLabel("Question Content");
		lblques.setHorizontalAlignment(SwingConstants.LEFT);
		lblques.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblques.setBounds(10, 10, 153, 13);
		panel_1.add(lblques);
		
		JButton btnQues = new JButton("Post Ques");
		btnQues.setBounds(168, 109, 85, 21);
		panel_1.add(btnQues);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(287, 70, 127, 183);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(104, 54, 2, 2);
		panel_2.add(scrollPane_2);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(110, 54, 17, 48);
		panel_2.add(scrollBar_1);
		
		JLabel lbltitle2 = new JLabel("ListQuestion");
		lbltitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltitle2.setBounds(10, 0, 96, 22);
		panel_2.add(lbltitle2);
		
		JList list = new JList();
		list.setBounds(20, 32, 86, 141);
		panel_2.add(list);
		
		JButton btnthoat = new JButton("Log out");
		btnthoat.setBounds(345, 10, 81, 32);
		contentPane.add(btnthoat);
		btnthoat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
