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

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIConsultAirline extends JFrame {

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
	private JButton bCheckHistory;
	private JLabel tTitule;
	private JTextField tConsultAirline;
	private JLabel lConsultAerolinea;
	private JButton bSearch;
	private JLabel li;
	public GUIConsultAirline() {
		
		setDTMTAirline(dataTable,getColumnsNames());
		setAirline(dtmTAirline);
		setSPTAirline(tAirline);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBCheckHistory());
		getContentPane().add(getTTitule());
		getContentPane().add(getTConsultAirline());
		getContentPane().add(getLConsultAerolinea());
		getContentPane().add(getBSearch());
		getContentPane().add(getImagen());
		setSize(682,390);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo
		public JLabel getImagen() {
			if(li == null) {
			li = new JLabel();
			li.setBounds(-13, -127, 874, 528);
			ImageIcon imagen= new ImageIcon("media/java.jpg");
			Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
			li.setIcon(new ImageIcon(GUIRegisterUser.class.getResource("/media/logo7.png")));
			getContentPane().add(li);
			}
			return li;
		}
		
public void fillTable(ArrayList <Airline> list) {
		
		for(Airline air : list) {
			dtmTAirline.addRow(new Object[] {air.getName(), air.getContry()});
		}
		setAirline(dtmTAirline);
	}
public ArrayList<Airline>getArrayListAirline(){
	return arrayLAirline;
}
public void setArrayListAirline(ArrayList<Airline> arrayLAirline){
	this.arrayLAirline = arrayLAirline;
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
	public JButton getBCheckHistory() {
		if (bCheckHistory == null) {
			bCheckHistory = new JButton("Consultar Historial");
			bCheckHistory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bCheckHistory.setBounds(376, 107, 134, 23);
		}
		return bCheckHistory;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Consultar Aerolinea");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
	public JTextField getTConsultAirline() {
		if (tConsultAirline == null) {
			tConsultAirline = new JTextField();
			tConsultAirline.setBounds(34, 79, 146, 29);
			tConsultAirline.setColumns(10);
		}
		return tConsultAirline;
	}
//------------------------------------------------------------------------------------
	public JLabel getLConsultAerolinea() {
		if (lConsultAerolinea == null) {
			lConsultAerolinea = new JLabel("Ingrese el Nombre de la Aerolinea");
			lConsultAerolinea.setFont(new Font("Tahoma", Font.BOLD, 11));
			lConsultAerolinea.setForeground(Color.GRAY);
			lConsultAerolinea.setBounds(34, 59, 292, 20);
		}
		return lConsultAerolinea;
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