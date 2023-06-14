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

public class GUIDeletePassenger extends JFrame {

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
	private JButton bDelete;
	private JLabel tTitule;
	private JTextField tPassportDelete;
	private JLabel lNameDelete;

	public GUIDeletePassenger() {
		
		setDTMTPassenger(dataTable,getColumnsNames());
		setPassenger(dtmTPassenger);
		setSPTPassenger(tPassenger);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBDelete());
		getContentPane().add(getTTitule());
		getContentPane().add(getTPassportDelete());
		getContentPane().add(getLNameDelete());
		setSize(658,368);
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
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.setBounds(413, 108, 104, 23);
		}
		return bDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Eliminar Pasajeros");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(205, 17, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTPassportDelete() {
		if (tPassportDelete == null) {
			tPassportDelete = new JTextField();
			tPassportDelete.setBounds(27, 82, 112, 20);
			tPassportDelete.setColumns(10);
		}
		return tPassportDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNameDelete() {
		if (lNameDelete == null) {
			lNameDelete = new JLabel("Ingrese el Pasajero a Eliminar");
			lNameDelete.setBounds(27, 57, 214, 14);
		}
		return lNameDelete;
	}
}