package babycare1;

import java.awt.EventQueue;
import java.lang.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;


import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Color;

public class App extends JFrame {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("BabyCare");
		frame.setBounds(100, 100, 450, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Baby Names");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				babynames baby = new babynames();
				frame.dispose();
				baby.setVisible(true);
			}
		});
		btnNewButton.setBounds(68, 117, 108, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tips");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tips tip = new tips();
				frame.dispose();
				tip.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(233, 117, 108, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Food");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Food f = new Food();
				frame.dispose();
				f.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(68, 194, 108, 28);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Product");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				products p = new products();
				frame.dispose();
				p.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(233, 194, 108, 28);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Admin");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login signin = new login();
				frame.dispose();
				signin.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(152, 282, 108, 28);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("BabyCare");
		lblNewLabel.setForeground(new Color(204, 51, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(157, 42, 122, 64);
		frame.getContentPane().add(lblNewLabel);
		ImageIcon MyImage = new ImageIcon(App.class.getResource("/babycare1/images/baby1.jpg"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(500, 360, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		JLabel lblbackimage = new JLabel("New label");
		lblbackimage.setIcon(new ImageIcon(newImg));
		lblbackimage.setBounds(-17, 0, 451, 372);
		frame.getContentPane().add(lblbackimage);
	}
}
