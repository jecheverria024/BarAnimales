package packInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packInterface.VentanaInicioJuego.Controlador;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaDeSalto extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JRadioButton rdbtnSaltarCarta;
	private JRadioButton rdbtnSaltarCartas;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDeSalto frame = new VentanaDeSalto();
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
	public VentanaDeSalto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getBtnAceptar());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(1, 0, 0, 0));
			panel_2.add(getRdbtnSaltarCarta());
			panel_2.add(getRdbtnSaltarCartas());
		}
		return panel_2;
	}
	private JRadioButton getRdbtnSaltarCarta() {
		if (rdbtnSaltarCarta == null) {
			rdbtnSaltarCarta = new JRadioButton("Saltar 1 carta");
			
		}
		return rdbtnSaltarCarta;
	}
	private JRadioButton getRdbtnSaltarCartas() {
		if (rdbtnSaltarCartas == null) {
			rdbtnSaltarCartas = new JRadioButton("Saltar 2 cartas");
			
		}
		return rdbtnSaltarCartas;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new Controlador());
			btnAceptar.setActionCommand("Aceptar");
		}
		return btnAceptar;
	}
	public class Controlador extends WindowAdapter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if(action.equals("Aceptar")){
				this.devolverValor();
				
			}
			
		}
		public int devolverValor(){
			if(rdbtnSaltarCarta.isSelected()){
				rdbtnSaltarCartas.setSelected(false);
				return 1;
			}else if(rdbtnSaltarCartas.isSelected()){
				rdbtnSaltarCarta.setSelected(false);
				return 2;
			}
		}
		
	}
}
