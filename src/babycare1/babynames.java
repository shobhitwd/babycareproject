package babycare1;

import java.lang.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;  

public class babynames extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					babynames frame = new babynames();
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
	public babynames() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 460);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 464, 306);
		getContentPane().add(scrollPane);
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App app = new App();
				app.frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(172, 68, 122, 35);
		getContentPane().add(btnHome);
		table = new JTable();
		scrollPane.setViewportView(table);
		
				try {
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/babynames","root","root");  
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from babyname");  
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				JLabel lblNewLabel = new JLabel("BabyCare Baby Names");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
				lblNewLabel.setBounds(105, 11, 296, 46);
				getContentPane().add(lblNewLabel);
			} catch (Exception e1) {
					e1.printStackTrace();
				}
		}
	
	
}

