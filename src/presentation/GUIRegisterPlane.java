package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIRegisterPlane extends JFrame {

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
	private JButton bRegister;
	private JLabel tTitule;
	private JLabel lAvionRegisterPlane;
	private JTextField tAvionRegisterPlane;
	private JLabel lAirplaneRegisterPalne;
	private JLabel lModelRegisterPlane;
	private JTextField tAirplaneRegisterPalne;
	private JTextField tModelRegisterPlane;
	private JTextField tYearRegisterPlane;
	private JLabel lYearRegisterPlane;

	public GUIRegisterPlane() {
		
		setDTMTPlane(dataTable,getColumnsNames());
		setPlane(dtmTPlane);
		setSPTPlane(tPlane);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBRegister());
		getContentPane().add(getTTitule());
		getContentPane().add(getLAvionRegisterPlane());
		getContentPane().add(getTAvionRegisterPlane());
		getContentPane().add(getLAirplaneRegisterPalne());
		getContentPane().add(getLModelRegisterPlane());
		getContentPane().add(getTAirplaneRegisterPalne());
		getContentPane().add(getTModelRegisterPlane());
		getContentPane().add(getTYearRegisterPlane());
		getContentPane().add(getLYearRegisterPlane());
		setSize(661,420);
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
			scrollPane.setBounds(10, 189, 507, 183);
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
			bExit.setBounds(527, 349, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBRegister() {
		if (bRegister == null) {
			bRegister = new JButton("Registrar");
			bRegister.setBounds(373, 166, 144, 23);
		}
		return bRegister;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Registrar Avión");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JLabel getLAvionRegisterPlane() {
		if (lAvionRegisterPlane == null) {
			lAvionRegisterPlane = new JLabel("Avión");
			lAvionRegisterPlane.setBounds(27, 60, 49, 14);
		}
		return lAvionRegisterPlane;
	}
//------------------------------------------------------------------------------------
	public JTextField getTAvionRegisterPlane() {
		if (tAvionRegisterPlane == null) {
			tAvionRegisterPlane = new JTextField();
			tAvionRegisterPlane.setBounds(27, 89, 96, 20);
			tAvionRegisterPlane.setColumns(10);
		}
		return tAvionRegisterPlane;
	}
//------------------------------------------------------------------------------------
	public JLabel getLAirplaneRegisterPalne() {
		if (lAirplaneRegisterPalne == null) {
			lAirplaneRegisterPalne = new JLabel("Aerolinea");
			lAirplaneRegisterPalne.setBounds(27, 120, 80, 14);
		}
		return lAirplaneRegisterPalne;
	}
//------------------------------------------------------------------------------------
	public JLabel getLModelRegisterPlane() {
		if (lModelRegisterPlane == null) {
			lModelRegisterPlane = new JLabel("Modelo");
			lModelRegisterPlane.setBounds(160, 60, 96, 14);
		}
		return lModelRegisterPlane;
	}
//------------------------------------------------------------------------------------
	public JTextField getTAirplaneRegisterPalne() {
		if (tAirplaneRegisterPalne == null) {
			tAirplaneRegisterPalne = new JTextField();
			tAirplaneRegisterPalne.setBounds(27, 150, 96, 20);
			tAirplaneRegisterPalne.setColumns(10);
		}
		return tAirplaneRegisterPalne;
	}
//------------------------------------------------------------------------------------
	public JTextField getTModelRegisterPlane() {
		if (tModelRegisterPlane == null) {
			tModelRegisterPlane = new JTextField();
			tModelRegisterPlane.setText("");
			tModelRegisterPlane.setBounds(160, 89, 96, 20);
			tModelRegisterPlane.setColumns(10);
		}
		return tModelRegisterPlane;
	}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tAvionRegisterPlane.setText("");
		tAirplaneRegisterPalne.setText("");
		tModelRegisterPlane.setText("");
		tYearRegisterPlane.setText("");
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
	public JTextField getTYearRegisterPlane() {
		if (tYearRegisterPlane == null) {
			tYearRegisterPlane = new JTextField();
			tYearRegisterPlane.setBounds(160, 150, 96, 20);
			tYearRegisterPlane.setColumns(10);
		}
		return tYearRegisterPlane;
	}
	public JLabel getLYearRegisterPlane() {
		if (lYearRegisterPlane == null) {
			lYearRegisterPlane = new JLabel("Año");
			lYearRegisterPlane.setBounds(160, 120, 49, 14);
		}
		return lYearRegisterPlane;
	}
}