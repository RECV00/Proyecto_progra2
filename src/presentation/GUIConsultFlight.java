package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import data.FilesXML;
import data.Logic;
import domain.Airline;
import domain.Flight;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import presentation.GUIRegisterFlight;

public class GUIConsultFlight extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	
	private DefaultTableModel dtmTFlight;
	private JTable tFlight;
	
	private JScrollPane spTFlight;
	
	private ArrayList<Flight> arrayLFlight;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bCheckHistory;
	private JLabel tTitule;
	private JTextField tConsultNameVuelo;
	private JLabel lConsultNameVuelo;
	private JButton bSearch;

	
	private GUIRegisterFlight guiRF;
	
	
	public GUIConsultFlight() {
		//guiRF= new GUIRegisterFlight();
		
		setDTMTFlight(dataTable,getColumnsNames());
		setFlight(dtmTFlight);
		setSPTFlight(tFlight);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBCheckHistory());
		getContentPane().add(getTTitule());
		getContentPane().add(getTConsultNameVuelo());
		getContentPane().add(getLConsultNameVuelo());
		getContentPane().add(getBSearch());
		setSize(1000,440);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
public void fillTable(ArrayList <Flight> list) {
		
		for(Flight f : list) {
			dtmTFlight.addRow(new Object[] {f.getNumFlight(), f.getDepartureCity(),f.getDepartureDateTime(),
					f.getArrivalCity(),f.getArrivalDateTime(),f.getFlight(),f.getSeat(),f.getAmount(f.getSeat())});
		}
		setFlight(dtmTFlight);
	}
public ArrayList<Flight>getArrayListFlight(){
	return arrayLFlight;
}
public void setArrayListFlight(ArrayList<Flight> arrayLFlight){
	this.arrayLFlight = arrayLFlight;
}
//------------------------------------------------------------------------------------
	public void setDTMTFlight(Object data[][],String[] columnsNames) {
		dtmTFlight = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTFlight() {
		return dtmTFlight;
	}
//------------------------------------------------------------------------------------
	public void setFlight(DefaultTableModel dtmTFlight) {
		tFlight = new JTable(dtmTFlight);
		//No poder editar los valores de la tabla
		tFlight.setEnabled(false);
		//no poder mover las columnas
		tFlight.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tFlight.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTFlight() {
		return this.tFlight;
	}
	
	public void setSPTFlight(JTable tFlight) {
		spTFlight = new JScrollPane(tFlight);
		spTFlight.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTFlight() {
		return this.spTFlight;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"Numero de Vuelo", "Ciudad de Salida", "Salida: Hora/Fecha", "Cuidad de Arrribo","Arribo: Hora/Fecha","Avión","Asiento","Monto"};
		return columnsNames;
	}

//------------------------------------------------------------------------------------
	public void print(JTable tFlight) {
		try {
			if(!tFlight.print()) {
				System.err.println("Se cancelo la Impresión");
			}
		}catch(java.awt.print.PrinterException e) {
			System.err.format("Error de Impresión. %s%n", e.getMessage());
		}
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
			scrollPane.setBounds(10, 163, 875, 183);
			scrollPane.setViewportView(getTAMostrarDato());
			tFlight=new JTable(dtmTFlight);
			tFlight.setEnabled(false);
			tFlight.getTableHeader().setReorderingAllowed(false);
			tFlight.getTableHeader().setResizingAllowed(false);	
			spTFlight = new JScrollPane(tFlight);
			scrollPane.setColumnHeaderView(spTFlight);
		}
		return scrollPane;
	}
//------------------------------------------------------------------------------------
	public JButton getBExit() {
		if (bExit == null) {
			bExit = new JButton("Salir");
			bExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bExit.setBounds(895, 309, 72, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBCheckHistory() {
		if (bCheckHistory == null) {
			bCheckHistory = new JButton("Consultar Historial");
			bCheckHistory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bCheckHistory.setBounds(760, 143, 141, 23);
		}
		return bCheckHistory;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Consultar Vuelos");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(366, 11, 279, 29);
		}
		return tTitule;
	}
	public JTextField getTConsultNameVuelo() {
		if (tConsultNameVuelo == null) {
			tConsultNameVuelo = new JTextField();
			tConsultNameVuelo.setBounds(44, 95, 146, 29);
			tConsultNameVuelo.setColumns(10);
		}
		return tConsultNameVuelo;
	}
//------------------------------------------------------------------------------------
	public JLabel getLConsultNameVuelo() {
		if (lConsultNameVuelo == null) {
			lConsultNameVuelo = new JLabel("Ingrese el Nombre del Vuelo");
			lConsultNameVuelo.setBounds(44, 64, 185, 20);
		}
		return lConsultNameVuelo;
	}
//------------------------------------------------------------------------------------
	public JButton getBSearch() {
		if (bSearch == null) {
			bSearch = new JButton("Buscar");
			bSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bSearch.setBounds(269, 98, 89, 23);
		}
		return bSearch;
	}
}
