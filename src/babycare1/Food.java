package babycare1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Food extends JFrame {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Food f = new Food();
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

   public Food(){  
		JFrame frame = new JFrame("Food");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    frame.setSize(560, 478);      
	    frame.setLocationRelativeTo(null);  
	    frame.setVisible(true);
      JPanel panel = new JPanel();
      LayoutManager layout = new FlowLayout();  
      panel.setLayout(layout);       

      JEditorPane jEditorPane = new JEditorPane();
      jEditorPane.setEditable(false);   
      URL url= Food.class.getResource("food.html");

      try {   
         jEditorPane.setPage(url);
      } catch (IOException e) { 
         jEditorPane.setContentType("text/html");
         jEditorPane.setText("<html>Page not found.</html>");
      }
      
      JButton btnHome = new JButton("Home");
      btnHome.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			App app = new App();
			app.frame.setVisible(true);
			frame.dispose();
		}
	});
      panel.add(btnHome);

      JScrollPane jScrollPane = new JScrollPane(jEditorPane);
      jScrollPane.setPreferredSize(new Dimension(540,400));      

      panel.add(jScrollPane);
      frame.getContentPane().add(panel, BorderLayout.CENTER);    
   }  
} 