package packInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packModelo.BarBestial;
import packModelo.ColaEntrada;
import packModelo.Usuario.Jugador;
import packModelo.Usuario.Usuario;
import packObservable.IObserver;
import packObservable.ObservableAbstracto;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class VentanaPartida extends JFrame implements IObserver {

	private JPanel contentPane;
	private JPanel panel_1;
	private JLabel btnBaraja;
	private JPanel colaEntrada;
	private JLabel[] cola;
	private JLabel[] mano;
	private JPanel manoJugador;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaPartida(String pJugador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel_1(), BorderLayout.WEST);
		contentPane.add(getBtnBaraja(), BorderLayout.EAST);
		contentPane.add(getColaEntrada(), BorderLayout.CENTER);
		contentPane.add(getManoJugador(), BorderLayout.SOUTH);
		ColaEntrada.getColaEntrada().registrarObservador(this);
		BarBestial.getBarBestial().iniciarPartida(pJugador);
		BarBestial.getBarBestial().getJugador().registrarObservador(this);
		// this.actualizarCola(ColaEntrada.getColaEntrada().infoCartas());
		this.actualizarMano(BarBestial.getBarBestial().infoMano());

	}

	/*
	 * Se encarga de inicializar la cola, aun falta poner como colocar las fotos
	 * segun fuerza y eso
	 */
	private void actualizarCola(String info) {
		cola = new JLabel[5];
		cola[0] = new JLabel();
		cola[1] = new JLabel();
		cola[2] = new JLabel();
		cola[3] = new JLabel();
		cola[4] = new JLabel();
		System.out.println(info);
		String[] parts = info.split(" ");
		for (int i = 0; i < parts.length / 2; i++) {
			int fuerza = Integer.parseInt(parts[i * 2]);
			Color color = this.getColor(parts[i * 2 + 1]);
			cola[i].setIcon(this.getImagen(fuerza));
			cola[i].setBackground(color);
			cola[i].setOpaque(true);
		}
		colaEntrada.removeAll();
		colaEntrada.add(cola[0]);
		colaEntrada.add(cola[1]);
		colaEntrada.add(cola[2]);
		colaEntrada.add(cola[3]);
		colaEntrada.add(cola[4]);
	}

	public Color getColor(String c) {
		Color color = null;
		if (c.equals("AZUL")) {
			color = Color.blue;
		} else if (c.equals("AMARILLO")) {
			color = Color.yellow;
		} else if (c.equals("VERDE")) {
			color = Color.green;
		} else if (c.equals("ROJO")) {
			color = Color.red;
		}
		return color;
	}

	public ImageIcon getImagen(int pFuerza) {
		ImageIcon imagen;
		switch (pFuerza) {
		case 1:
			imagen = new ImageIcon(getClass().getResource("/packImagen/mofeta.PNG"));
			break;
		case 2:
			imagen = new ImageIcon(getClass().getResource("/packImagen/loro.PNG"));
			break;
		case 3:
			imagen = new ImageIcon(getClass().getResource("/packImagen/canguro.PNG"));
			break;
		case 4:
			imagen = new ImageIcon(getClass().getResource("/packImagen/mono.PNG"));
			break;
		case 5:
			imagen = new ImageIcon(getClass().getResource("/packImagen/camaleon.PNG"));
			break;
		case 6:
			imagen = new ImageIcon(getClass().getResource("/packImagen/foca.PNG"));
			break;
		case 7:
			imagen = new ImageIcon(getClass().getResource("/packImagen/cebra.PNG"));
			break;
		case 8:
			imagen = new ImageIcon(getClass().getResource("/packImagen/jirafa.PNG"));
			break;
		case 9:
			imagen = new ImageIcon(getClass().getResource("/packImagen/serpiente.PNG"));
			break;
		case 10:
			imagen = new ImageIcon(getClass().getResource("/packImagen/cocodrilo.PNG"));
			break;
		case 11:
			imagen = new ImageIcon(getClass().getResource("/packImagen/hipopotamo.PNG"));
			break;
		case 12:
			imagen = new ImageIcon(getClass().getResource("/packImagen/leon.PNG"));
			break;
		default:
			imagen = new ImageIcon(getClass().getResource("/packImagen/transparente.png"));
			break;
		}
		return imagen;
	}

	private void actualizarMano(String info) {
		mano = new JLabel[4];
		mano[0] = new JLabel();

		mano[0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (BarBestial.getBarBestial().jugar(0)) {
					System.exit(0);
				}
			}
		});

		mano[1] = new JLabel();
		mano[1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (BarBestial.getBarBestial().jugar(1)) {
					System.exit(0);

				}
			}
		});
		mano[2] = new JLabel();
		mano[2].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (BarBestial.getBarBestial().jugar(2)) {
					System.exit(0);
				}
			}
		});

		mano[3] = new JLabel();
		mano[3].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (BarBestial.getBarBestial().jugar(3)) {
					System.exit(0);
				}
			}
		});
		System.out.println(info);
		if (info != null) {
			String[] parts = info.split(" ");
			for (int i = 0; i < parts.length / 2; i++) {
				int fuerza = Integer.parseInt(parts[i * 2]);
				Color color = this.getColor(parts[i * 2 + 1]);
				mano[i].setIcon(this.getImagen(fuerza));
				mano[i].setBackground(color);
				mano[i].setOpaque(true);
			}
		}
		manoJugador.removeAll();
		manoJugador.add(mano[0]);
		manoJugador.add(mano[1]);
		manoJugador.add(mano[2]);
		manoJugador.add(mano[3]);
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
		}
		return panel_1;
	}

	private JLabel getBtnBaraja() {
		if (btnBaraja == null) {
			btnBaraja = new JLabel(new ImageIcon(getClass().getResource("/packImagen/mazo.jpg")));

		}
		return btnBaraja;
	}

	private JPanel getColaEntrada() {
		if (colaEntrada == null) {
			colaEntrada = new JPanel();
			colaEntrada.setLayout(new GridLayout(1, 5, 0, 0));
		}
		return colaEntrada;
	}

	private class ControladorListaDeCartas extends WindowAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if (action.equals("Baraja")) {// falta meter turnos y comprobar si el jugador tiene algun hueco libre en la
											// mano
			}
		}

	}

	@Override
	public void update(ObservableAbstracto pObservable, Object o) {
		if (pObservable instanceof ColaEntrada) {
			this.actualizarCola((String) o);
			this.colaEntrada.updateUI();
			this.colaEntrada.repaint();
		} else if (pObservable instanceof Usuario) {
			this.actualizarMano((String) o);
			this.manoJugador.updateUI();
			this.manoJugador.repaint();
			System.out.println("mano jugador");
		}
	}

	private JPanel getManoJugador() {
		if (manoJugador == null) {
			manoJugador = new JPanel();
			manoJugador.setLayout(new GridLayout(1, 4, 0, 0));
		}
		return manoJugador;
	}
}
