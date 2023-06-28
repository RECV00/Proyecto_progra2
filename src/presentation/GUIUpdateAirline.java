package presentation;


import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Airline;
import domain.User;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GUIUpdateAirline extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTAirline;
	private JTable tAirline;
	private JScrollPane spTAirline;
	private ArrayList<Airline> arrayLAirline;
	private Object dataTable[][];
//label,button,textfield
	private JButton bExit;
	private JButton bUpdate;
	private JLabel tTitule;
	private JTextField tNameAeroUpdate;
	private JLabel lUpdateName;
	private JLabel lUpdateContry;
	private JTextField tUpdateContry;
	private JButton bSearch;
	private JLabel li;
	public GUIUpdateAirline() {
		
		setDTMTAirline(dataTable,getColumnsNames());
		setAirline(dtmTAirline);
		setSPTAirline(tAirline);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBUpdate());
		getContentPane().add(getTTitule());
		getContentPane().add(getTNameAeroUpdate());
		getContentPane().add(getLUpdateName());
		getContentPane().add(getLUpdateContry());
		getContentPane().add(getTUpdateContry());
		getContentPane().add(getBSearch());
		getContentPane().add(getImagen());
		setSize(723,450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(-13, -127, 874, 606);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIRegisterUser.class.getResource("/media/logo7.png")));
		getContentPane().add(li);
		}
		return li;
	}
//llena y crea la tabla
//llena y crea la tabla
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
			scrollPane.setBounds(59, 198, 507, 183);
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
			bExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bExit.setBounds(603, 377, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBUpdate() {
		if (bUpdate == null) {
			bUpdate = new JButton("Actualizar");
			bUpdate.setBounds(432, 176, 133, 23);
		}
		return bUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Actualizar Aerolíneas");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameAeroUpdate() {
		if (tNameAeroUpdate == null) {
			tNameAeroUpdate = new JTextField();
			tNameAeroUpdate.setBounds(27, 95, 147, 20);
			tNameAeroUpdate.setColumns(10);
		}
		return tNameAeroUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getLUpdateName() {
		if (lUpdateName == null) {
			lUpdateName = new JLabel("Ingrese la Aerolínea a Actualizar");
			lUpdateName.setForeground(new Color(128, 128, 128));
			lUpdateName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lUpdateName.setBounds(27, 61, 230, 23);
		}
		return lUpdateName;
	}
	public JLabel getLUpdateContry() {
		if (lUpdateContry == null) {
			lUpdateContry = new JLabel("Ingrese el país a Actualizar");
			lUpdateContry.setForeground(new Color(128, 128, 128));
			lUpdateContry.setFont(new Font("Tahoma", Font.BOLD, 11));
			lUpdateContry.setBounds(27, 126, 182, 14);
		}
		return lUpdateContry;
	}
	public JTextField getTUpdateContry() {
		if (tUpdateContry == null) {
			tUpdateContry = new JTextField();
			tUpdateContry.setBounds(27, 150, 147, 20);
			tUpdateContry.setColumns(10);
		}
		return tUpdateContry;
	}
	public JButton getBSearch() {
		if (bSearch == null) {
			bSearch = new JButton("Buscar");
			bSearch.setBounds(58, 176, 89, 23);
		}
		return bSearch;
	}
}
