package babycare1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.*;  
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setSize(500, 360);
		textField = new JTextField();
		textField.setBounds(257, 121, 142, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/babynames","root","root"); 
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from users"); 
					String u1 = textField.getText();
					String u2 = passwordField.getText();
					int logincheck = 0;
					while(rs.next()) 
					{
						String u3 = rs.getString(2);
						String u4 = rs.getString(3);
						if(u1.equals(u3) && u4.equals(u2))
						{
							logincheck = 1;
							JOptionPane.showMessageDialog(null, "Correct login details");
							adminpanel admin = new adminpanel();
							admin.setVisible(true);
							dispose();
						}
						if(logincheck==0)
						{
							JOptionPane.showMessageDialog(null, "Incorrect login details");
							textField.setText(null);
							passwordField.setText(null);
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setBounds(257, 307, 142, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(82, 122, 110, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(82, 206, 110, 32);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(257, 203, 142, 35);
		contentPane.add(passwordField);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App app = new App();
				app.frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(70, 307, 122, 35);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel_2 = new JLabel("BabyCare Admin Login");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(109, 38, 296, 43);
		contentPane.add(lblNewLabel_2);
		ImageIcon MyImage = new ImageIcon(App.class.getResource("/babycare1/images/baby1.jpg"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(500, 460, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		JLabel lblbackimage = new JLabel("New label");
		lblbackimage.setIcon(new ImageIcon(newImg));
		lblbackimage.setBounds(0, 0, 484, 421);
		contentPane.add(lblbackimage);
		

	}
}
