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

import domain.Plane;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIUpdatePlane extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	
	private DefaultTableModel dtmTPlane;
	private JTable tPlane;
	
	private JScrollPane spTPlane;
	
	private ArrayList<Plane> arrayLPlane;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bUpdate;
	private JLabel tTitule;
	private JTextField tNamePlaneUpdate;
	private JLabel lUpdateAvionPlane;

	public GUIUpdatePlane() {
		
		setDTMTPlane(dataTable,getColumnsNames());
		setPlane(dtmTPlane);
		setSPTPlane(tPlane);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBUpdate());
		getContentPane().add(getTTitule());
		getContentPane().add(getTNamePlaneUpdate());
		getContentPane().add(getLUpdateAvionPlane());
		setSize(688,368);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
//------------------------------------------------------------------------------------
	public void setDTMTPlane(Object data[][],String[] columnsNames) {
		dtmTPlane = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTPlane() {
		return dtmTPlane;
	}
//------------------------------------------------------------------------------------
	public void setPlane(DefaultTableModel dtmTPlane) {
		tPlane = new JTable(dtmTPlane);
		//No poder editar los valores de la tabla
		tPlane.setEnabled(false);
		//no poder mover las columnas
		tPlane.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tPlane.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTPlane() {
		return this.tPlane;
	}
	
	public void setSPTPlane(JTable tPlane) {
		spTPlane = new JScrollPane(tPlane);
		spTPlane.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTPlane() {
		return this.spTPlane;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"Avión", "Aerolinea", "Modelo", "Año"};
		return columnsNames;
	}
//------------------------------------------------------------------------------------		
	public ArrayList<Plane>getArrayListPlane(){
		return arrayLPlane;
	}
//------------------------------------------------------------------------------------
	public void print(JTable tPlane) {
		try {
			if(!tPlane.print()) {
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
			tPlane=new JTable(dtmTPlane);
			tPlane.setEnabled(false);
			tPlane.getTableHeader().setReorderingAllowed(false);
			tPlane.getTableHeader().setResizingAllowed(false);	
			spTPlane = new JScrollPane(tPlane);
			scrollPane.setColumnHeaderView(spTPlane);
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
			bUpdate.setBounds(378, 108, 139, 23);
		}
		return bUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Actualizar Aviones");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNamePlaneUpdate() {
		if (tNamePlaneUpdate == null) {
			tNamePlaneUpdate = new JTextField();
			tNamePlaneUpdate.setBounds(27, 74, 132, 20);
			tNamePlaneUpdate.setColumns(10);
		}
		return tNamePlaneUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getLUpdateAvionPlane() {
		if (lUpdateAvionPlane == null) {
			lUpdateAvionPlane = new JLabel("Ingrese del Avión a Actualizar");
			lUpdateAvionPlane.setBounds(27, 52, 209, 23);
		}
		return lUpdateAvionPlane;
	}
}
