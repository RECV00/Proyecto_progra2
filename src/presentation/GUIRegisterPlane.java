package presentation;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Airline;
import domain.Model;
import domain.Plane;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JComboBox;

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
	private JTextField tYearRegisterPlane;
	private JLabel lYearRegisterPlane;
	
	private JComboBox<String> comboBoxAirline;
    private DefaultComboBoxModel<String> comboBoxModelo; // Se utiliza para almacenar y administrar los elementos de un JComboBox que son de tipo String.
	private JComboBox<String> comboBoxModel;
	ArrayList<Airline>arrayLA;
	ArrayList<Model>arrayLM;
	
	public GUIRegisterPlane(ArrayList<Airline>arrayLA,ArrayList<Model>arrayLM) {
		
		llenarComboBoxModel(arrayLM,getComboBoxModel());
		llenarComboBoxAirline(arrayLA,getComboBoxAirline());

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
		getContentPane().add(getTYearRegisterPlane());
		getContentPane().add(getLYearRegisterPlane());
		getContentPane().add(getComboBoxAirline());
		getContentPane().add(getComboBoxModel());
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
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tAvionRegisterPlane.setText("");
		comboBoxModel.setToolTipText("");
		comboBoxAirline.setToolTipText("");
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
	//---------------------------------------------------------------------
	public JComboBox<String> getComboBoxAirline() {
		if (comboBoxAirline == null) {
			comboBoxAirline = new JComboBox<String>();
			comboBoxAirline.setBounds(27, 145, 96, 22);
			comboBoxAirline.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		}
		return comboBoxAirline;
	}
	public ArrayList<Airline>getArrayListAirline(){
		return arrayLA;
	}
	public void setArrayListPlane(ArrayList<Airline> arrayLA){
		this.arrayLA = arrayLA;
	}
	public void llenarComboBoxAirline(ArrayList<Airline>arrayLA,JComboBox<String> comboBox) {
		String[] nameA = new String[arrayLA.size()];
		for(int i=0; i<arrayLA.size(); i++) {
			nameA[i]=arrayLA.get(i).getName();
		}
		 // Crea un DefaultComboBoxModel con el array de aviones
		comboBoxModelo = new DefaultComboBoxModel<>(nameA);

        // Asigna el DefaultComboBoxModel al JComboBox
        comboBox.setModel(comboBoxModelo);
	}
	    public void setcomboBoxAvion1(JComboBox<String> comboBoxAirline) {
	        this.comboBoxAirline = comboBoxAirline;
	    }
	
	//------------------------------------------------------------------------
	public JComboBox<String> getComboBoxModel() {
		if (comboBoxModel == null) {
			comboBoxModel = new JComboBox<String>();
			comboBoxModel.setBounds(157, 88, 94, 22);
			comboBoxModel.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
			
		}
		return comboBoxModel;
	}
	
	public void llenarComboBoxModel(ArrayList<Model>arrayLM,JComboBox<String> comboBox) {
		String[] nameM = new String[arrayLM.size()];
		for(int i=0; i<arrayLM.size(); i++) {
			nameM[i]=arrayLM.get(i).getName();
		}
		 // Crea un DefaultComboBoxModel con el array de aviones
		comboBoxModelo = new DefaultComboBoxModel<>(nameM);

        // Asigna el DefaultComboBoxModel al JComboBox
        comboBox.setModel(comboBoxModelo);
	}
	    public void setcomboBoxModel(JComboBox<String> comboBoxModel) {
	        this.comboBoxModel = comboBoxModel;
	    }
	
}