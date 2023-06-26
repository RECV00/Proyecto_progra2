package presentation;


import java.awt.Font;
import java.awt.Image;

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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.awt.Color;

public class GUIRegisterPlane extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTPlane;
	private JTable tPlane;
	private JScrollPane spTPlane;
	private ArrayList<Plane> arrayLPlane;
	private Object dataTable[][];
//label,button,textfield
	private JButton bExit;
	private JButton bRegister;
	private JLabel tTitule;
	private JLabel lAvionRegisterPlane;
	private JTextField tAvionRegisterPlane;
	private JLabel lAirplaneRegisterPalne;
	private JLabel lModelRegisterPlane;
	private JTextField tYearRegisterPlane;
	private JLabel lYearRegisterPlane;
//comboBox de la lista seleccionable de aerolineas y modelos
	private JComboBox<String> comboBoxAirline;
    private DefaultComboBoxModel<String> comboBoxModelo; // Se utiliza para almacenar y administrar los elementos de un JComboBox que son de tipo String.
	private JComboBox<String> comboBoxModel;
	ArrayList<Airline>arrayLA;
	ArrayList<Model>arrayLM;
//fondo de la GUI
	private JLabel li;
	
	public GUIRegisterPlane(ArrayList<Airline>arrayLA,ArrayList<Model>arrayLM) {//muestra la lista al inicializar
		
		llenarComboBoxModel(arrayLM,getComboBoxModel());
		llenarComboBoxAirline(arrayLA,getComboBoxAirline());

		setDTMTPlane(dataTable,getColumnsNames());
		setPlane(dtmTPlane);
		setSPTPlane(tPlane);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
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
		getContentPane().add(getImagen());
		setSize(716,466);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(0, -127, 961, 633);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIRegisterUser.class.getResource("/media/logo7.png")));
		getContentPane().add(li);
		}
		return li;
	}
//llenando y creando la tabla

	
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
			scrollPane.setBounds(48, 212, 538, 183);
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
			bExit.setBounds(596, 393, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBRegister() {
		if (bRegister == null) {
			bRegister = new JButton("Registrar");
			bRegister.setBounds(457, 191, 129, 23);
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
			lAvionRegisterPlane.setForeground(new Color(128, 128, 128));
			lAvionRegisterPlane.setFont(new Font("Tahoma", Font.BOLD, 11));
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
			lAirplaneRegisterPalne = new JLabel("Aerolínea");
			lAirplaneRegisterPalne.setForeground(new Color(128, 128, 128));
			lAirplaneRegisterPalne.setFont(new Font("Tahoma", Font.BOLD, 11));
			lAirplaneRegisterPalne.setBounds(27, 120, 80, 14);
		}
		return lAirplaneRegisterPalne;
	}
//------------------------------------------------------------------------------------
	public JLabel getLModelRegisterPlane() {
		if (lModelRegisterPlane == null) {
			lModelRegisterPlane = new JLabel("Modelo");
			lModelRegisterPlane.setForeground(new Color(128, 128, 128));
			lModelRegisterPlane.setFont(new Font("Tahoma", Font.BOLD, 11));
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
			lYearRegisterPlane.setForeground(new Color(128, 128, 128));
			lYearRegisterPlane.setFont(new Font("Tahoma", Font.BOLD, 11));
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