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

		setDTMTVuelos(dataTable,getColumnsNames());
		setVuelos(dtmTVuelos);
		setSPTVuelos(tVuelos);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Sistema de Aereolineas");
		contentPane.add(getScrollPane());
		contentPane.add(getLVuelos());
		contentPane.add(getComboBox());
		contentPane.add(getBConsultV());
		contentPane.add(getBExit());
		setSize(4500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
	//LLenado de la tabla
	public void fillTable(ArrayList <Flight> list) {
			
			for(Flight f : list) {
				dtmTVuelos.addRow(new Object[] {f.getNumFlight(), f.getDepartureCity(),f.getDepartureDateTime(),
						f.getArrivalCity(),f.getArrivalDateTime(),f.getFlight(),f.getSeat(),f.getAmount(f.getSeat())});
			}
			setVuelos(dtmTVuelos);
		}
	public ArrayList<Flight>getArrayListFlight(){
		return arrayLF;
	}
	public void setArrayListFlight(ArrayList<Flight> arrayLFlight){
		this.arrayLF = arrayLFlight;
	}
	//------------------------------------------------------------------------------------
	public void setDTMTVuelos(Object data[][],String[] columnsNames) {
		dtmTVuelos = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTFlight() {
		return dtmTVuelos;
	}
	//------------------------------------------------------------------------------------
		public void setVuelos(DefaultTableModel dtmTVuelos) {
			tVuelos = new JTable(dtmTVuelos);
			//No poder editar los valores de la tabla
			tVuelos.setEnabled(false);
			//no poder mover las columnas
			tVuelos.getTableHeader().setReorderingAllowed(false);
			//no poder reducir el tamanio de las columnas
			tVuelos.getTableHeader().setResizingAllowed(false);

		}
		
	public void setSPTVuelos(JTable tVuelos) {
		spTVuelos = new JScrollPane(tVuelos);
		spTVuelos.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTVuelos() {
		return this.spTVuelos;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] ={"Numero de Vuelo","Aerolínea", "Avión","Ciudad (Hora/Fecha) Salida", 
				"Cuidad (Hora/Fecha) Arribo","Asientos: Ejecutiva Vendidos","Asientos: Ejecutiva Dispobles",
				"Asientos: Turista Vendidos","Asientos: Turista Dispobles","Asientos: Economica Vendidos",
				"Asientos: Economica Dispobles","Tiquete Ejecutivo","Tiquete Turista","Tiquete Economico",
				"Monto por Vuelo"};
		return columnsNames;
	}
	
	//------------------------------------------------------------------------------------	
		public JTextPane getTAMostrarDato() {
			if (tAMostrarDato == null) {
				tAMostrarDato = new JTextPane();
				tAMostrarDato.setEditable(false);
			}
			return tAMostrarDato;
		}
	//------------------------------------------------------------------------------------
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 189, 1263, 183);
			scrollPane.setViewportView(getTAMostrarDato());
			tVuelos=new JTable(dtmTVuelos);
			tVuelos.setEnabled(false);
			tVuelos.getTableHeader().setReorderingAllowed(false);
			tVuelos.getTableHeader().setResizingAllowed(false);	
			spTVuelos = new JScrollPane(tVuelos);
			scrollPane.setColumnHeaderView(spTVuelos);
		}
		return scrollPane;
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
			bExit.setBounds(275, 89, 89, 23);
		}
		return bExit;
	}
}
