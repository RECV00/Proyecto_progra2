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
import domain.Airline;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIDeleteAirline extends JFrame {

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
	private JButton bDelete;
	private JLabel tTitule;
	private JTextField tNameDeleteAero;
	private JLabel lNameDelete;

	public GUIDeleteAirline() {
		
		setDTMTAirline(dataTable,getColumnsNames());
		setAirline(dtmTAirline);
		setSPTAirline(tAirline);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBDelete());
		getContentPane().add(getTTitule());
		getContentPane().add(getTNameDeleteAero());
		getContentPane().add(getLNameDelete());
		setSize(688,368);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
public void fillTable(ArrayList <Airline> list) {
		
		for(Airline a : list) {
			dtmTAirline.addRow(new Object[] {a.getName(),a.getContry()});
		}
		setAirline(dtmTAirline);
	}
public void setArrayListAirline(ArrayList<Airline> arrayLAirline){
	this.arrayLAirline= arrayLAirline;
}
public ArrayList<Airline>getArrayListAirline(){
	return arrayLAirline;
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
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.setBounds(375, 108, 142, 23);
		}
		return bDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Eliminar Aerolinea");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameDeleteAero() {
		if (tNameDeleteAero == null) {
			tNameDeleteAero = new JTextField();
			tNameDeleteAero.setBounds(27, 82, 112, 20);
			tNameDeleteAero.setColumns(10);
		}
		return tNameDeleteAero;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNameDelete() {
		if (lNameDelete == null) {
			lNameDelete = new JLabel("Nombre de la Aerolinea");
			lNameDelete.setBounds(27, 57, 197, 14);
		}
		return lNameDelete;
	}
}

