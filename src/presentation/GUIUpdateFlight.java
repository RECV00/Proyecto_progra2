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

import domain.User;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIUpdateFlight extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	
	private DefaultTableModel dtmTUser;
	private JTable tUser;
	
	private JScrollPane spTUser;
	
	private ArrayList<User> arrayLUser;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bUpdate;
	private JLabel tTitule;
	private JTextField tUpdateVuelo;
	private JLabel lUpdateVueloName;

	public GUIUpdateFlight() {
		
		setDTMTUser(dataTable,getColumnsNames());
		setUser(dtmTUser);
		setSPTUser(tUser);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBUpdate());
		getContentPane().add(getTTitule());
		getContentPane().add(getTUpdateVuelo());
		getContentPane().add(getLUpdateVueloName());
		setSize(1000,440);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
//------------------------------------------------------------------------------------
	public void setDTMTUser(Object data[][],String[] columnsNames) {
		dtmTUser = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTUser() {
		return dtmTUser;
	}
//------------------------------------------------------------------------------------
	public void setUser(DefaultTableModel dtmTUser) {
		tUser = new JTable(dtmTUser);
		//No poder editar los valores de la tabla
		tUser.setEnabled(false);
		//no poder mover las columnas
		tUser.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tUser.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTUser() {
		return this.tUser;
	}
	
	public void setSPTUser(JTable tUser) {
		spTUser = new JScrollPane(tUser);
		spTUser.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTUser() {
		return this.spTUser;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"Numero de Vuelo", "Ciudad de Salida", "Salida: Hora/Fecha", "Cuidad de Arrribo","Arribo: Hora/Fecha","Avión","Asiento","Monto"};
		return columnsNames;
	}
//------------------------------------------------------------------------------------		
	public ArrayList<User>getArrayListUser(){
		return arrayLUser;
	}
//------------------------------------------------------------------------------------
	public void print(JTable tUser) {
		try {
			if(!tUser.print()) {
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
			scrollPane.setBounds(10, 167, 873, 183);
			scrollPane.setViewportView(getTAMostrarDato());
			tUser=new JTable(dtmTUser);
			tUser.setEnabled(false);
			tUser.getTableHeader().setReorderingAllowed(false);
			tUser.getTableHeader().setResizingAllowed(false);	
			spTUser = new JScrollPane(tUser);
			scrollPane.setColumnHeaderView(spTUser);
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
			bExit.setBounds(892, 312, 84, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBUpdate() {
		if (bUpdate == null) {
			bUpdate = new JButton("Actualizar");
			bUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bUpdate.setBounds(755, 144, 128, 23);
		}
		return bUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Actualizar Vuelos");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(347, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTUpdateVuelo() {
		if (tUpdateVuelo == null) {
			tUpdateVuelo = new JTextField();
			tUpdateVuelo.setBounds(76, 112, 157, 20);
			tUpdateVuelo.setColumns(10);
		}
		return tUpdateVuelo;
	}
//------------------------------------------------------------------------------------
	public JLabel getLUpdateVueloName() {
		if (lUpdateVueloName == null) {
			lUpdateVueloName = new JLabel("Ingrese el Numero de Vuelo a Actualizar");
			lUpdateVueloName.setBounds(77, 78, 255, 23);
		}
		return lUpdateVueloName;
	}
}

