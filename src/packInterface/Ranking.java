package packInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import packRanking.GestorRanking;

import java.awt.Color;
import java.awt.Font;


import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.FlowLayout;





public class Ranking extends JFrame {

	private JPanel contentPane;
	private JTextField[][] textField;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblRanking;
	private JButton btnSalir;
	private JPanel panel_2;
	private JButton btnVolverAlMen;


	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = new Ranking();
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
	public Ranking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);		
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
		cargarPanel(panel_2);
		//this.cargarResultados();
	}
	private void limpiarTextField() {
		for (int x = 1; x < textField.length; x++) {
			for (int y= 0; y< textField[1].length; y++) {
				textField[x][y].setText("");
			}
		}
	}
	private void cargarResultados() {
		try {
				limpiarTextField();
        		JSONArray json=GestorRanking.getGestorRanking().getRanking();						
					for (int y = 0; y < json.length(); y++) {								
						JSONObject objeto = json.getJSONObject(y);
						textField[y+1][0].setText(String.valueOf(y+1));
						textField[y+1][1].setText(objeto.getString("nombre"));
						textField[y+1][2].setText(String.valueOf(objeto.getInt("puntuacion")));
				}
				panel.updateUI();					
		} 
    	catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getLblRanking());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getBtnVolverAlMen());
			panel_1.add(getBtnSalir());
		}
		return panel_1;
	}

	private JLabel getLblRanking() {
		if (lblRanking == null) {
			lblRanking = new JLabel("Ranking");
			lblRanking.setFont(new Font("Tahoma", Font.PLAIN, 27));
		}
		return lblRanking;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new Controlador());
			btnSalir.setActionCommand("Salir");
		}
		return btnSalir;
	}

	private void cargarPanel(JPanel panel) {
		textField = new JTextField[11][3];
		for (int x = 0; x < 11; x++) {
			for (int y = 0; y < 3; y++) {
				textField[x][y] = new JTextField();
				panel.add(textField[x][y]);
			}
		}
	}
	
	private class Controlador extends WindowAdapter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String action= arg0.getActionCommand();
			if(action.equals("Salir")) {
				this.salir();
			}else if(action.equals("volver al menu")) {
				VentanaInicioJuego frame=new VentanaInicioJuego();
				frame.setVisible(true);
				dispose();
			}

		}
		
		public void salir() {
			Object[] options = { "ACEPTAR", "CANCELAR" };
			int eleccion = JOptionPane.showOptionDialog(rootPane, "Quieres cerrar la aplicacion?", "Confirmar Cierre",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Aceptar");
			if (eleccion == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else {

			}

		}
		}
		
	

	
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(11, 3, 0, 0));
		}
		return panel_2;
	}
	private JButton getBtnVolverAlMen() {
		if (btnVolverAlMen == null) {
			btnVolverAlMen = new JButton("volver al menu");
			btnVolverAlMen.addActionListener(new Controlador());
			btnVolverAlMen.setActionCommand("volver al menu");	
		}
		
		return btnVolverAlMen;
	}
}
