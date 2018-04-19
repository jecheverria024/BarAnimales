package packInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class VentanaPedirPosicion extends JFrame {
	private JPanel contentPane;
	private ButtonGroup bg=new ButtonGroup();
	JRadioButton rdbtnRb;
	JRadioButton rdbtnRb_1;
	JRadioButton rdbtnRb_2;
	JRadioButton rdbtnRb_3;
	JRadioButton rdbtnRb_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPedirPosicion frame = new VentanaPedirPosicion(1);
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
	public VentanaPedirPosicion(int num) {
		setTitle("Bar Bestial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		rdbtnRb = new JRadioButton("RB0");
		panel.add(rdbtnRb, BorderLayout.NORTH);
		rdbtnRb.setVisible(false);
		
		rdbtnRb_1 = new JRadioButton("RB1");
		panel.add(rdbtnRb_1, BorderLayout.CENTER);
		rdbtnRb_1.setVisible(true);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		rdbtnRb_2 = new JRadioButton("RB2");
		panel_2.add(rdbtnRb_2, BorderLayout.NORTH);
		rdbtnRb_2.setVisible(true);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		rdbtnRb_3 = new JRadioButton("RB3");
		panel_3.add(rdbtnRb_3, BorderLayout.NORTH);
		rdbtnRb_3.setVisible(true);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		rdbtnRb_4 = new JRadioButton("RB4");
		panel_4.add(rdbtnRb_4, BorderLayout.NORTH);
		rdbtnRb_4.setVisible(true);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_4.add(btnAceptar, BorderLayout.SOUTH);
		mostrarPosiciones(num);
		
		btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (comprobarSelec()!=-1) {
            		
            	}
            }
        });
		bg.add(rdbtnRb);
		bg.add(rdbtnRb_1);
		bg.add(rdbtnRb_2);
		bg.add(rdbtnRb_3);
		bg.add(rdbtnRb_4);
		
		
		
	}
	
	public int comprobarSelec() {
		int pos = -1;
		if(rdbtnRb.isSelected()) {
			pos= 0;
		}
		if(rdbtnRb_1.isSelected()) {
			pos=1;
		}
		if(rdbtnRb_2.isSelected()) {
			pos= 2;
		}
		if(rdbtnRb_3.isSelected()) {
			pos= 3;
		}
		if(rdbtnRb_4.isSelected()) {
			pos= 4;
		}
		return pos;
	}
	
	private void mostrarPosiciones(int num) {
		System.out.println(num);
		if(num>=0) {
			rdbtnRb.setVisible(true);
			if(num>=1) {
				rdbtnRb_1.setVisible(true);
				if(num>=2) {
					rdbtnRb_2.setVisible(true);

					if(num>=3) {
						rdbtnRb_3.setVisible(true);

						if(num>=4) {
							rdbtnRb_4.setVisible(true);

						}
					}
				}
			}
		}
		
	}
}
