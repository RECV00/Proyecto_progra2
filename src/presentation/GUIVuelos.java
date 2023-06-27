package presentation;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import data.FilesXML;
import domain.Flight;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class GUIVuelos extends JFrame {

	private JPanel contentPane;
	//table
		private JScrollPane scrollPane;
		private JTextPane tAMostrarDato;
		private DefaultTableModel dtmTVuelos;
		private JTable tVuelos;
		private JScrollPane spTVuelos;
		private ArrayList<Flight> arrayLF;
		private Object dataTable[][];
	//label , button ,textfield
		private JLabel lVuelos;
		private JComboBox comboBoxVuelos;
		private JButton bConsultV;
		private JButton bExit;


	/**
	 * Create the frame.
	 */
	public GUIVuelos(ArrayList<Flight>arrayLF) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLVuelos());
		contentPane.add(getComboBox());
		contentPane.add(getBConsultV());
		contentPane.add(getBExit());
		setVisible(true);
	}

	public JLabel getLVuelos() {
		if (lVuelos == null) {
			lVuelos = new JLabel("Lista de Vuelos");
			lVuelos.setBounds(23, 22, 107, 14);
		}
		return lVuelos;
	}
	public JComboBox getComboBox() {
		if (comboBoxVuelos == null) {
			comboBoxVuelos = new JComboBox();
			comboBoxVuelos.setBounds(23, 47, 101, 22);
		}
		return comboBoxVuelos;
	}
	public JButton getBConsultV() {
		if (bConsultV == null) {
			bConsultV = new JButton("Consultar Vuelo");
			bConsultV.setBounds(23, 89, 123, 23);
		}
		return bConsultV;
	}
	

	public JButton getBExit() {
		if (bExit == null) {
			bExit = new JButton("Salir");
			bExit.setBounds(335, 227, 89, 23);
		}
		return bExit;
	}
}
