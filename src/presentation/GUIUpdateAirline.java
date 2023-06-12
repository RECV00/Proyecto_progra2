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

import domain.Airline;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIUpdateAirline extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	
	private DefaultTableModel dtmTAirline;
	private JTable tAirline;
	
	private JScrollPane spTAirline;
	
	private ArrayList<Airline> arrayLAirline;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bUpdate;
	private JLabel tTitule;
	private JTextField tNameAeroUpdate;
	private JLabel lUpdateName;

	public GUIUpdateAirline() {
		
		setDTMTAirline(dataTable,getColumnsNames());
		setAirline(dtmTAirline);
		setSPTAirline(tAirline);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBUpdate());
		getContentPane().add(getTTitule());
		getContentPane().add(getTNameAeroUpdate());
		getContentPane().add(getLUpdateName());
		setSize(688,368);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
//------------------------------------------------------------------------------------
	public void setDTMTAirline(Object data[][],String[] columnsNames) {
		dtmTAirline = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTAirline() {
		return dtmTAirline;
	}
//------------------------------------------------------------------------------------
	public void setAirline(DefaultTableModel dtmTAirline) {
		tAirline = new JTable(dtmTAirline);
		//No poder editar los valores de la tabla
		tAirline.setEnabled(false);
		//no poder mover las columnas
		tAirline.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tAirline.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTAirline() {
		return this.tAirline;
	}
	
	public void setSPTAirline(JTable tAirline) {
		spTAirline = new JScrollPane(tAirline);
		spTAirline.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTAirline() {
		return this.spTAirline;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"Nombre", "País"};
		return columnsNames;
	}
//------------------------------------------------------------------------------------		
	public ArrayList<Airline>getArrayListAirline(){
		return arrayLAirline;
	}
//------------------------------------------------------------------------------------
	public void print(JTable tAirline) {
		try {
			if(!tAirline.print()) {
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
			tAirline=new JTable(dtmTAirline);
			tAirline.setEnabled(false);
			tAirline.getTableHeader().setReorderingAllowed(false);
			tAirline.getTableHeader().setResizingAllowed(false);	
			spTAirline = new JScrollPane(tAirline);
			scrollPane.setColumnHeaderView(spTAirline);
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
	public JButton getBUpdate() {
		if (bUpdate == null) {
			bUpdate = new JButton("Actualizar");
			bUpdate.setBounds(370, 107, 147, 23);
		}
		return bUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Actualizar Aerolineas");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameAeroUpdate() {
		if (tNameAeroUpdate == null) {
			tNameAeroUpdate = new JTextField();
			tNameAeroUpdate.setBounds(27, 74, 147, 20);
			tNameAeroUpdate.setColumns(10);
		}
		return tNameAeroUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getLUpdateName() {
		if (lUpdateName == null) {
			lUpdateName = new JLabel("Ingrese la Aerolinea a Actualizar");
			lUpdateName.setBounds(27, 52, 230, 23);
		}
		return lUpdateName;
	}
}
