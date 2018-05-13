package packInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import packBD.GestorBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblRegistrarse;
	private JPanel panel_1;
	private JButton btnAceptar;
	private JButton btnSalir;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblInsertarNombreDe;
	private JTextField textField;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lblInsertarContrasea;
	private JPasswordField textField_1;
	private JPanel panel_12;
	private JPanel panel_13;
	private JLabel lblConfirmarContrasea;
	private JPasswordField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblRegistrarse());
		}
		return panel;
	}

	private JLabel getLblRegistrarse() {
		if (lblRegistrarse == null) {
			lblRegistrarse = new JLabel("Registrarse");
			lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 28));
		}
		return lblRegistrarse;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getBtnAceptar());
			panel_1.add(getBtnSalir());
		}
		return panel_1;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ControladorRegistro());
			btnAceptar.setActionCommand("Aceptar");
		}
		return btnAceptar;
	}

	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ControladorRegistro());
			btnSalir.setActionCommand("Salir");
		}
		return btnSalir;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getPanel_3(), BorderLayout.NORTH);
			panel_2.add(getPanel_4(), BorderLayout.CENTER);
		}
		return panel_2;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
		}
		return panel_3;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getPanel_5(), BorderLayout.NORTH);
			panel_4.add(getPanel_6(), BorderLayout.CENTER);
		}
		return panel_4;
	}

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
		}
		return panel_5;
	}

	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(new BorderLayout(0, 0));
			panel_6.add(getPanel_7(), BorderLayout.NORTH);
			panel_6.add(getPanel_8(), BorderLayout.CENTER);
		}
		return panel_6;
	}

	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_7.add(getLblInsertarNombreDe());
			panel_7.add(getTextField());
		}
		return panel_7;
	}

	private JLabel getLblInsertarNombreDe() {
		if (lblInsertarNombreDe == null) {
			lblInsertarNombreDe = new JLabel("Insertar nombre de usuario");
		}
		return lblInsertarNombreDe;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}

	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setLayout(new BorderLayout(0, 0));
			panel_8.add(getPanel_9(), BorderLayout.NORTH);
			panel_8.add(getPanel_10(), BorderLayout.CENTER);
		}
		return panel_8;
	}

	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return panel_9;
	}

	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setLayout(new BorderLayout(0, 0));
			panel_10.add(getPanel_11(), BorderLayout.NORTH);
			panel_10.add(getPanel_12(), BorderLayout.CENTER);
		}
		return panel_10;
	}

	private JPanel getPanel_11() {
		if (panel_11 == null) {
			panel_11 = new JPanel();
			panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_11.add(getLblInsertarContrasea());
			panel_11.add(getTextField_1());
		}
		return panel_11;
	}

	private JLabel getLblInsertarContrasea() {
		if (lblInsertarContrasea == null) {
			lblInsertarContrasea = new JLabel("Insertar password");
		}
		return lblInsertarContrasea;
	}

	private JPasswordField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JPasswordField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}

	private JPanel getPanel_12() {
		if (panel_12 == null) {
			panel_12 = new JPanel();
			panel_12.setLayout(new BorderLayout(0, 0));
			panel_12.add(getPanel_13(), BorderLayout.NORTH);
		}
		return panel_12;
	}

	private JPanel getPanel_13() {
		if (panel_13 == null) {
			panel_13 = new JPanel();
			panel_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_13.add(getLblConfirmarContrasea());
			panel_13.add(getTextField_2());
		}
		return panel_13;
	}

	private JLabel getLblConfirmarContrasea() {
		if (lblConfirmarContrasea == null) {
			lblConfirmarContrasea = new JLabel("Confirmar password");
		}
		return lblConfirmarContrasea;
	}

	private JPasswordField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JPasswordField();
			textField_2.setColumns(10);
		}
		return textField_2;
	}

	private class ControladorRegistro extends WindowAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if (action.equals("Aceptar")) { // llamar para hacer el registro y llevarlo a la ventana de incio de juego
				String contra = textField_1.getText();
				String contra2 = textField_2.getText();
				String usu = textField.getText();
				if (comprobarNoExiste(usu)) {
					if (this.comprobarPassIguales(contra, contra2)) {
						GestorBD.getGestorBD().anadirUsuario(usu, contra);
						VentanaInicioJuego frame = new VentanaInicioJuego();
						frame.setVisible(true);
						dispose();
					} else {
						JFrame frame = new JFrame("Error");
						JOptionPane.showMessageDialog(frame, "Las Passwords no coinciden");
					}
				} else {
					JFrame frame = new JFrame("Error");
					JOptionPane.showMessageDialog(frame, "El usuario ya existe");
				}

			} else if (action.equals("Salir")) {
				cerrar();
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

		public boolean comprobarPassIguales(String pass1, String pass2) {
			if (pass1.equals(pass2)) {
				return true;
			} else {
				return false;
			}
		}

		private boolean comprobarNoExiste(String pUsu) {
			return GestorBD.getGestorBD().comprobarNoExiste(pUsu);
		}

	}
}
