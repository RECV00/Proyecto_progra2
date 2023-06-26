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
import javax.swing.JComboBox;

import java.util.ArrayList;
import java.awt.Color;

public class GUIUpdatePlane extends JFrame {
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
	private JButton bUpdate;
	private JLabel tTitule;
	private JLabel lAvionUpdatePlane;
	private JTextField tAvionUpdatePlane;
	private JLabel lAirplaneUpdatePalne;
	private JLabel lModelUpdatePlane;
	private JTextField tYearUpdatePlane;
	private JLabel lYearUpdatePlane;
//comboBox de la lista seleccionable de aerolineas y modelos
	private JComboBox<String> comboBoxAirline;
	private DefaultComboBoxModel<String> comboBoxModelo; // Se utiliza para almacenar y administrar los elementos de un JComboBox que son de tipo String.
	private JComboBox<String> comboBoxModel;
	ArrayList<Airline>arrayLA;
	ArrayList<Model>arrayLM;
//fondo de la GUI
	private JLabel li;
	
	public GUIUpdatePlane(ArrayList<Airline>arrayLA,ArrayList<Model>arrayLM) {//muestra la lista al inicializar
		//llena y muestra la lista al inicializar
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
		getContentPane().add(getBUpdate());
		getContentPane().add(getTTitule());
		getContentPane().add(getLAvionUpdatePlane());
		getContentPane().add(getTAvionUpdatePlane());
		getContentPane().add(getLAirplaneUpdatePalne());
		getContentPane().add(getLModelUpdatePlane());
		getContentPane().add(getTYearUpdatePlane());
		getContentPane().add(getLYearUpdatePlane());
		getContentPane().add(getComboBoxAirline());
		getContentPane().add(getComboBoxModel());
		getContentPane().add(getImagen() );
		setSize(715,504);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(-13, -127, 878, 706);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIRegisterUser.class.getResource("/media/logo7.png")));
		getContentPane().add(li);
		}
		return li;
	}
//llena y crea la tabla
public void fillTable(ArrayList <Plane> list) {
		
		for(Plane pl : list) {
			dtmTPlane.addRow(new Object[] {pl.getPlate(),pl.getAirline(),pl.getModel(),pl.getYear()});
		}
		setPlane(dtmTPlane);
	}
public ArrayList<Plane>getArrayListPlane(){
	return arrayLPlane;
}
public void setArrayListPlane(ArrayList<Plane> arrayLPlane){
	this.arrayLPlane = arrayLPlane;
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
		String columnsNames[] = {"Avión", "Aerolínea", "Modelo", "Año"};
		return columnsNames;
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
			scrollPane.setBounds(46, 230, 521, 183);
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
			bExit.setBounds(595, 431, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBUpdate() {
		if (bUpdate == null) {
			bUpdate = new JButton("Actualizar");
			bUpdate.setBounds(451, 209, 116, 23);
		}
		return bUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Actualizar Avión");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JLabel getLAvionUpdatePlane() {
		if (lAvionUpdatePlane == null) {
			lAvionUpdatePlane = new JLabel("Avión");
			lAvionUpdatePlane.setForeground(new Color(128, 128, 128));
			lAvionUpdatePlane.setFont(new Font("Tahoma", Font.BOLD, 11));
			lAvionUpdatePlane.setBounds(27, 60, 49, 14);
		}
		return lAvionUpdatePlane;
	}
//------------------------------------------------------------------------------------
	public JTextField getTAvionUpdatePlane() {
		if (tAvionUpdatePlane == null) {
			tAvionUpdatePlane = new JTextField();
			tAvionUpdatePlane.setBounds(27, 89, 96, 20);
			tAvionUpdatePlane.setColumns(10);
		}
		return tAvionUpdatePlane;
	}
//------------------------------------------------------------------------------------
	public JLabel getLAirplaneUpdatePalne() {
		if (lAirplaneUpdatePalne == null) {
			lAirplaneUpdatePalne = new JLabel("Aerolínea");
			lAirplaneUpdatePalne.setForeground(new Color(128, 128, 128));
			lAirplaneUpdatePalne.setFont(new Font("Tahoma", Font.BOLD, 11));
			lAirplaneUpdatePalne.setBounds(27, 120, 80, 14);
		}
		return lAirplaneUpdatePalne;
	}
//------------------------------------------------------------------------------------
	public JLabel getLModelUpdatePlane() {
		if (lModelUpdatePlane == null) {
			lModelUpdatePlane = new JLabel("Modelo");
			lModelUpdatePlane.setForeground(new Color(128, 128, 128));
			lModelUpdatePlane.setFont(new Font("Tahoma", Font.BOLD, 11));
			lModelUpdatePlane.setBounds(160, 60, 96, 14);
		}
		return lModelUpdatePlane;
	}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tAvionUpdatePlane.setText("");
		comboBoxModel.setToolTipText("");
		comboBoxAirline.setToolTipText("");
		tYearUpdatePlane.setText("");
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
	public JTextField getTYearUpdatePlane() {
		if (tYearUpdatePlane == null) {
			tYearUpdatePlane = new JTextField();
			tYearUpdatePlane.setBounds(160, 150, 96, 20);
			tYearUpdatePlane.setColumns(10);
		}
		return tYearUpdatePlane;
	}
	public JLabel getLYearUpdatePlane() {
		if (lYearUpdatePlane == null) {
			lYearUpdatePlane = new JLabel("Año");
			lYearUpdatePlane.setForeground(new Color(128, 128, 128));
			lYearUpdatePlane.setFont(new Font("Tahoma", Font.BOLD, 11));
			lYearUpdatePlane.setBounds(160, 120, 49, 14);
		}
		return lYearUpdatePlane;
	}

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
	public void setArrayListAirline(ArrayList<Airline> arrayLA){
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
//llena y crea el comboBox de la lista de modelos
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
