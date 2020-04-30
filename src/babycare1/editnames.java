package babycare1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class editnames extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblName;
	private JButton btnAdd;
	private JTextField textName;
	private JLabel lblMeaning;
	private JLabel lblGender;
	private JTextField textMeaning;
	private JTextField textGender;
	private JButton btnDelete;
	private JButton btnReload;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editnames frame = new editnames();
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
    public void reload()
	{
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
	public editnames() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 57, 403, 236);
		contentPane.add(scrollPane);
		
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
		
		lblName = new JLabel("Enter Name");
		lblName.setBounds(10, 308, 74, 14);
		contentPane.add(lblName);
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App app = new App();
				app.frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(306, 414, 107, 23);
		contentPane.add(btnHome);
		
		btnAdd = new JButton("Add Name");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				String meaning = textMeaning.getText();
				String gender = textGender.getText();
				if(name.isEmpty() || meaning.isEmpty() || gender.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter all the fields.");
				}
				else
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/babynames","root","root");  
						PreparedStatement pst = con.prepareStatement("INSERT INTO babyname(name, meaning, sex) VALUES(?, ?, ?)"); 
						pst.setNString(1, name);
						pst.setNString(2, meaning);
						pst.setNString(3, gender);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Name Inserted Successfully.");
						textName.setText(null);
						textMeaning.setText(null);
						textGender.setText(null);
						reload();
					} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
			}
		});
		btnAdd.setBounds(306, 304, 107, 23);
		contentPane.add(btnAdd);
		
		textName = new JTextField();
		textName.setBounds(122, 305, 86, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		lblMeaning = new JLabel("Enter Meaning");
		lblMeaning.setBounds(10, 362, 74, 14);
		contentPane.add(lblMeaning);
		
		lblGender = new JLabel("Enter Gender");
		lblGender.setBounds(10, 423, 74, 14);
		contentPane.add(lblGender);
		
		textMeaning = new JTextField();
		textMeaning.setBounds(122, 359, 86, 20);
		contentPane.add(textMeaning);
		textMeaning.setColumns(10);
		
		textGender = new JTextField();
		textGender.setBounds(122, 420, 86, 20);
		contentPane.add(textGender);
		textGender.setColumns(10);
		
		btnDelete = new JButton("Delete Name");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				if(name.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter the name to be deleted.");
				}
				else
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/babynames","root","root");  
						PreparedStatement pst = con.prepareStatement("DELETE from babyname where name=?"); 
						pst.setNString(1, name);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Name Deleted Successfully");
						textName.setText(null);
						textMeaning.setText(null);
						textGender.setText(null);
						reload();
					} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
			}
		});
		btnDelete.setBounds(306, 358, 107, 23);
		contentPane.add(btnDelete);
		
	}

}
