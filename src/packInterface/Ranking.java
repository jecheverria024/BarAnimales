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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.GridLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;





public class Ranking extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	JPanel panel_1 = new JPanel();
	private JLabel lblRanking;
	private JLabel lblListadoPuntuacion;
	private JTable table;
	private JTextField[][] textField;
	

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
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		//this.cargarResultados();
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			this.setTitle("Ranking");
			panel.setBounds(0, 0, 524, 331);
			panel.setLayout(null);
			panel.add(getRanking());
			panel.add(getLblListadoPuntuacion());
			ButtonGroup group = new ButtonGroup();

			table = new JTable();
			table.setBounds(10, 249, 174, -163);
			panel.add(table);
			
			
			panel_1.setBounds(20, 83, 276, 237);
			panel.add(panel_1);
			panel_1.setLayout(new GridLayout(11, 3, 0, 0));
			
			JButton btnNewButton = new JButton("Volver a inicio");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				}
			});
			btnNewButton.setBounds(360, 297, 126, 23);
			panel.add(btnNewButton);
			
			textField = new JTextField[11][3];
			for (int x = 0; x < 11; x++) {
				for (int y = 0; y < 3; y++) {
					textField[x][y] = new JTextField();
					panel_1.add(textField[x][y]);
				}
			}
			Font fuente = new Font("Serief",Font.BOLD, 12);
			textField[0][0].setText("Posicion");
			textField[0][0].setFont(fuente);
			textField[0][1].setText("Nombre");
			textField[0][1].setFont(fuente);
			textField[0][2].setText("Puntuacion");
			textField[0][2].setFont(fuente);
		}
				
		return panel;
	}
	private void limpiarTextField() {
		for (int x = 1; x < textField.length; x++) {
			for (int y= 0; y< textField[1].length; y++) {
				textField[x][y].setText("");
			}
		}
	}
	private JLabel getRanking() {
		if (lblRanking == null) {
			lblRanking = new JLabel("Ranking");
			lblRanking.setBounds(10, 11, 83, 14);
			lblRanking.setForeground(Color.BLACK);
			lblRanking.setFont(new Font("Stencil", Font.PLAIN, 16));
		}
		return lblRanking;
	}

	private JLabel getLblListadoPuntuacion() {
		if (lblListadoPuntuacion == null) {
			lblListadoPuntuacion = new JLabel("Listado puntuacion  ");
			lblListadoPuntuacion.setBounds(23, 58, 126, 14);
		}
		return lblListadoPuntuacion;
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
}
