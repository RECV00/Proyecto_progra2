package presentation;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Plane;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.util.ArrayList;

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
	private JLabel lAvionUpdatePlane;
	private JTextField tAvionUpdatePlane;
	private JLabel lAirplaneUpdatePalne;
	private JLabel lModelUpdatePlane;
	private JTextField tAirplaneUpdatePalne;
	private JTextField tModelUpdatePlane;
	private JTextField tYearUpdatePlane;
	private JLabel lYearUpdatePlane;

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
		getContentPane().add(getLAvionUpdatePlane());
		getContentPane().add(getTAvionUpdatePlane());
		getContentPane().add(getLAirplaneUpdatePalne());
		getContentPane().add(getLModelUpdatePlane());
		getContentPane().add(getTAirplaneUpdatePalne());
		getContentPane().add(getTModelUpdatePlane());
		getContentPane().add(getTYearUpdatePlane());
		getContentPane().add(getLYearUpdatePlane());
		setSize(661,420);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
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
		String columnsNames[] = {"Avión", "Aerolinea", "Modelo", "Año"};
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
	public JButton getBUpdate() {
		if (bUpdate == null) {
			bUpdate = new JButton("Actualizar");
			bUpdate.setBounds(373, 166, 144, 23);
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
			lAirplaneUpdatePalne = new JLabel("Aerolinea");
			lAirplaneUpdatePalne.setBounds(27, 120, 80, 14);
		}
		return lAirplaneUpdatePalne;
	}
//------------------------------------------------------------------------------------
	public JLabel getLModelUpdatePlane() {
		if (lModelUpdatePlane == null) {
			lModelUpdatePlane = new JLabel("Modelo");
			lModelUpdatePlane.setBounds(160, 60, 96, 14);
		}
		return lModelUpdatePlane;
	}
//------------------------------------------------------------------------------------
	public JTextField getTAirplaneUpdatePalne() {
		if (tAirplaneUpdatePalne == null) {
			tAirplaneUpdatePalne = new JTextField();
			tAirplaneUpdatePalne.setBounds(27, 150, 96, 20);
			tAirplaneUpdatePalne.setColumns(10);
		}
		return tAirplaneUpdatePalne;
	}
//------------------------------------------------------------------------------------
	public JTextField getTModelUpdatePlane() {
		if (tModelUpdatePlane == null) {
			tModelUpdatePlane = new JTextField();
			tModelUpdatePlane.setText("");
			tModelUpdatePlane.setBounds(160, 89, 96, 20);
			tModelUpdatePlane.setColumns(10);
		}
		return tModelUpdatePlane;
	}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tAvionUpdatePlane.setText("");
		tAirplaneUpdatePalne.setText("");
		tModelUpdatePlane.setText("");
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
			lYearUpdatePlane.setBounds(160, 120, 49, 14);
		}
		return lYearUpdatePlane;
	}
}