package packInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packModelo.BarBestial;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class VentanaInicioJuego extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnJugar;
	private JButton btnSalir;
	private JLabel lblBarbestial;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblInsertaNombreDe;
	private JTextField textField;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel lblInsertaPassword;
	private JTextField textField_1;
	private JButton btnRegistrarse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicioJuego frame = new VentanaInicioJuego();
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
	public VentanaInicioJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getLblBarbestial(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.CENTER);

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getBtnJugar());
			panel.add(getBtnSalir());
			panel.add(getBtnRegistrarse());
			
		}
		return panel;
	}

	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("Jugar");
			btnJugar.addActionListener(new Controlador());
			btnJugar.setActionCommand("Jugar");

		}
		return btnJugar;
	}

	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new Controlador());
			btnSalir.setActionCommand("Salir");

		}
		return btnSalir;
	}

	private JLabel getLblBarbestial() {
		if (lblBarbestial == null) {
			lblBarbestial = new JLabel("BarBestial");
			lblBarbestial.setFont(new Font("Tahoma", Font.PLAIN, 37));
		}
		return lblBarbestial;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getPanel_2(), BorderLayout.NORTH);
			panel_1.add(getPanel_3(), BorderLayout.CENTER);
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_2.add(getLblInsertaNombreDe());
			panel_2.add(getTextField_1());
		}
		return panel_2;
	}
	private JLabel getLblInsertaNombreDe() {
		if (lblInsertaNombreDe == null) {
			lblInsertaNombreDe = new JLabel("Inserta nombre de Usuario");
		}
		return lblInsertaNombreDe;
	}
	private JTextField getTextField_1() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new BorderLayout(0, 0));
			panel_3.add(getPanel_4(), BorderLayout.NORTH);
			panel_3.add(getPanel_5(), BorderLayout.CENTER);
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(new BorderLayout(0, 0));
			panel_5.add(getPanel_6(), BorderLayout.NORTH);
		}
		return panel_5;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_6.add(getLblInsertaPassword());
			panel_6.add(getTextField_1_1());
		}
		return panel_6;
	}
	private JLabel getLblInsertaPassword() {
		if (lblInsertaPassword == null) {
			lblInsertaPassword = new JLabel("Inserta Password");
		}
		return lblInsertaPassword;
	}
	private JTextField getTextField_1_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JButton getBtnRegistrarse() {
		if (btnRegistrarse == null) {
			btnRegistrarse = new JButton("Registro");
			btnRegistrarse.addActionListener(new Controlador());
			btnRegistrarse.setActionCommand("Registro");

		}
		
		return btnRegistrarse;
	}


	private class Controlador extends WindowAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if (action.equals("Jugar")) {
				VentanaPartida frame2 = new VentanaPartida();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				Dimension frameSize = frame2.getSize(); //Tama�o del frame actual (ancho x alto)
				if (frameSize.height > screenSize.height) {
				frameSize.height = screenSize.height;
				}
				if (frameSize.width > screenSize.width) {
				frameSize.width = screenSize.width;
				}
				frame2.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
				frame2.setExtendedState(MAXIMIZED_BOTH);
				frame2.setVisible(true);
				dispose();
			} else if (action.equals("Salir")) {
				cerrar();
			}
			else if (action.equals("Registro")){
				VentanaRegistro frame3=new VentanaRegistro();
				frame3.setVisible(true);
				dispose();
			}

		}

		public void cerrar() {
			Object[] options = { "ACEPTAR", "CANCELAR" };
			int eleccion = JOptionPane.showOptionDialog(rootPane, "Quieres cerrar la aplicacion?", "Confirmar Cierre",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Aceptar");
			if (eleccion == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else {

			}

		}

	}
	}
