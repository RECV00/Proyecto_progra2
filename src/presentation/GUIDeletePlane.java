package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import domain.Plane;
import domain.User;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIDeletePlane extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTPlane;
	private JTable tPlane;
	private JScrollPane spTPlane;
	private ArrayList<Plane> arrayLPlane;
	private Object dataTable[][];
//label,textfield,button
	private JButton bExit;
	private JButton bDelete;
	private JLabel tTitule;
	private JTextField tPlaneDeletePlane;
	private JLabel lPlaneDeletePlane;
// fondo de la GUI
	private JLabel li;
	
	public GUIDeletePlane() {
		
		setDTMTPlane(dataTable,getColumnsNames());
		setPlane(dtmTPlane);
		setSPTPlane(tPlane);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBDelete());
		getContentPane().add(getTTitule());
		getContentPane().add(getTPlaneDeletePlane());
		getContentPane().add(getLPlaneDeletePlane());
		getContentPane().add(getImagen());
		setSize(721,439);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo de la GUI
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(-13, -127, 987, 569);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIRegisterUser.class.getResource("/media/logo7.png")));
		getContentPane().add(li);
		}
		return li;
	}
//LLenado de la tabla		
public void fillTable(ArrayList <Plane> list) {
		
		for(Plane plane : list) {
			dtmTPlane.addRow(new Object[] {plane.getPlate(),plane.getAirline(),plane.getModel(),plane.getYear()});
		}
		setPlane(dtmTPlane);
	}
	public void setArrayListPlane(ArrayList<Plane> arrayLPlane){
		this.arrayLPlane= arrayLPlane;
	}
	public ArrayList<Plane>getArrayListPlane(){
		return arrayLPlane;
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
			scrollPane.setBounds(47, 176, 507, 183);
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
			bExit.setBounds(601, 366, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.setBounds(162, 81, 94, 23);
		}
		return bDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Eliminar Avión");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(202, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTPlaneDeletePlane() {
		if (tPlaneDeletePlane == null) {
			tPlaneDeletePlane = new JTextField();
			tPlaneDeletePlane.setBounds(27, 82, 112, 20);
			tPlaneDeletePlane.setColumns(10);
		}
		return tPlaneDeletePlane;
	}
//------------------------------------------------------------------------------------
	public JLabel getLPlaneDeletePlane() {
		if (lPlaneDeletePlane == null) {
			lPlaneDeletePlane = new JLabel("Ingrese el Avión a Eliminar");
			lPlaneDeletePlane.setForeground(new Color(128, 128, 128));
			lPlaneDeletePlane.setFont(new Font("Tahoma", Font.BOLD, 11));
			lPlaneDeletePlane.setBounds(27, 57, 157, 14);
		}
		return lPlaneDeletePlane;
	}
}
