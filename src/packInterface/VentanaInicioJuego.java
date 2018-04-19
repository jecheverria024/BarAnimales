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

public class VentanaInicioJuego extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnJugar;
	private JButton btnSalir;
	private JLabel lblBarbestial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicioJuego frame = new VentanaInicioJuego();
				
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

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getBtnJugar());
			panel.add(getBtnSalir());
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

	private class Controlador extends WindowAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if (action.equals("Jugar")) {
				VentanaPartida frame2 = new VentanaPartida();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				Dimension frameSize = frame2.getSize(); //Tamaño del frame actual (ancho x alto)
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
