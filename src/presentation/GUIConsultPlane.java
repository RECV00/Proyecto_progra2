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

import domain.Airline;
import domain.Plane;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIConsultPlane extends JFrame {
	//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTPlane;
	private JTable tPlane;
	private JScrollPane spTPlane;
	private ArrayList<Plane> arrayLPlane;
	private Object dataTable[][];
	//JLabel y JTexfield 
	private JButton bExit;
	private JButton bCheckHistory;
	private JLabel tTitule;
	private JTextField tConsultPlane;
	private JLabel lConsultAvionPlane;
	private JButton bSearch;
// fondo GUI
	private JLabel li;
	
	public GUIConsultPlane() {
		
		setDTMTPlane(dataTable,getColumnsNames());
		setPlane(dtmTPlane);
		setSPTPlane(tPlane);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBCheckHistory());
		getContentPane().add(getTTitule());
		getContentPane().add(getTConsultPlane());
		getContentPane().add(getLConsultAvionPlane());
		getContentPane().add(getBSearch());
		getContentPane().add(getImagen());
		setSize(712,418);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo de la GUI
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(-13, -127, 987, 528);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIRegisterUser.class.getResource("/media/logo7.png")));
		getContentPane().add(li);
		}
		return li;
	}
//LLenado de la tabla
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
			scrollPane.setBounds(23, 161, 507, 183);
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
			bExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bExit.setBounds(592, 345, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBCheckHistory() {
		if (bCheckHistory == null) {
			bCheckHistory = new JButton("Consultar Historial");
			bCheckHistory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bCheckHistory.setBounds(397, 139, 133, 23);
		}
		return bCheckHistory;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Consultar Aviones");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(211, 11, 279, 29);
		}
		return tTitule;
	}
	public JTextField getTConsultPlane() {
		if (tConsultPlane == null) {
			tConsultPlane = new JTextField();
			tConsultPlane.setBounds(34, 79, 146, 29);
			tConsultPlane.setColumns(10);
		}
		return tConsultPlane;
	}
//------------------------------------------------------------------------------------
	public JLabel getLConsultAvionPlane() {
		if (lConsultAvionPlane == null) {
			lConsultAvionPlane = new JLabel("Ingrese el Nombre del Avión");
			lConsultAvionPlane.setForeground(new Color(128, 128, 128));
			lConsultAvionPlane.setFont(new Font("Tahoma", Font.BOLD, 11));
			lConsultAvionPlane.setBounds(34, 59, 202, 20);
		}
		return lConsultAvionPlane;
	}
//------------------------------------------------------------------------------------
	public JButton getBSearch() {
		if (bSearch == null) {
			bSearch = new JButton("Buscar");
			bSearch.setBounds(190, 82, 89, 23);
		}
		return bSearch;
	}
}