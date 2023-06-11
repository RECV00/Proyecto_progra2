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

import domain.Passenger;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIConsultPassenger extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	
	private DefaultTableModel dtmTPassenger;
	private JTable tPassenger;
	
	private JScrollPane spTPassenger;
	
	private ArrayList<Passenger> arrayLPassenger;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bCheckHistory;
	private JLabel tTitule;
	private JTextField tConsultPasspotPassenger;
	private JLabel lPassportPassengerConsult;
	private JButton bSearch;

	public GUIConsultPassenger() {
		
		setDTMTPassenger(dataTable,getColumnsNames());
		setPassenger(dtmTPassenger);
		setSPTPassenger(tPassenger);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBCheckHistory());
		getContentPane().add(getTTitule());
		getContentPane().add(getTConsultPasspotPassenger());
		getContentPane().add(getLPassportPassengerConsult());
		getContentPane().add(getBSearch());
		setSize(688,368);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
//------------------------------------------------------------------------------------
	public void setDTMTPassenger(Object data[][],String[] columnsNames) {
		dtmTPassenger = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTPassenger() {
		return dtmTPassenger;
	}
//------------------------------------------------------------------------------------
	public void setPassenger(DefaultTableModel dtmTPassenger) {
		tPassenger = new JTable(dtmTPassenger);
		//No poder editar los valores de la tabla
		tPassenger.setEnabled(false);
		//no poder mover las columnas
		tPassenger.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tPassenger.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTPassenger() {
		return this.tPassenger;
	}
	
	public void setSPTPassenger(JTable tPassenger) {
		spTPassenger = new JScrollPane(tPassenger);
		spTPassenger.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTPassenger() {
		return this.spTPassenger;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"Pasaporte", "Nombre", "Apellido", "Cumpleaños","Correo","Celular"};
		return columnsNames;
	}
//------------------------------------------------------------------------------------		
	public ArrayList<Passenger>getArrayListPassenger(){
		return arrayLPassenger;
	}
//------------------------------------------------------------------------------------
	public void print(JTable tPassenger) {
		try {
			if(!tPassenger.print()) {
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
			scrollPane.setBounds(10, 130, 507, 183);
			scrollPane.setViewportView(getTAMostrarDato());
			tPassenger=new JTable(dtmTPassenger);
			tPassenger.setEnabled(false);
			tPassenger.getTableHeader().setReorderingAllowed(false);
			tPassenger.getTableHeader().setResizingAllowed(false);	
			spTPassenger = new JScrollPane(tPassenger);
			scrollPane.setColumnHeaderView(spTPassenger);
		}
		return scrollPane;
	}
//------------------------------------------------------------------------------------
	public JButton getBExit() {
		if (bExit == null) {
			bExit = new JButton("Salir");
			bExit.setBounds(527, 290, 94, 23);
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
			bCheckHistory.setBounds(376, 107, 141, 23);
		}
		return bCheckHistory;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Consultar Pasajeros");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(194, 11, 279, 29);
		}
		return tTitule;
	}
	public JTextField getTConsultPasspotPassenger() {
		if (tConsultPasspotPassenger == null) {
			tConsultPasspotPassenger = new JTextField();
			tConsultPasspotPassenger.setBounds(34, 79, 146, 29);
			tConsultPasspotPassenger.setColumns(10);
		}
		return tConsultPasspotPassenger;
	}
//------------------------------------------------------------------------------------
	public JLabel getLPassportPassengerConsult() {
		if (lPassportPassengerConsult == null) {
			lPassportPassengerConsult = new JLabel("Ingrese el Pasaporte del Pasajero");
			lPassportPassengerConsult.setBounds(34, 59, 194, 20);
		}
		return lPassportPassengerConsult;
	}
//------------------------------------------------------------------------------------
	public JButton getBSearch() {
		if (bSearch == null) {
			bSearch = new JButton("Buscar");
			bSearch.setBounds(190, 82, 89, 23);
		}
		return bSearch;
	}
}