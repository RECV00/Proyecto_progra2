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

import domain.User;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIRegisterAirline extends JFrame {

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
	private JButton bRegister;
	private JLabel tTitule;
	private JLabel lNameAeroline;
	private JTextField tNameAerolinea;
	private JLabel lContry;
	private JTextField tContry;

	public GUIRegisterAirline() {
		
		setDTMTUser(dataTable,getColumnsNames());
		setUser(dtmTUser);
		setSPTUser(tUser);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBRegister());
		getContentPane().add(getTTitule());
		getContentPane().add(getLNameAeroline());
		getContentPane().add(getTNameAerolinea());
		getContentPane().add(getLContry());
		getContentPane().add(getTContry());
		setSize(688,368);
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
		String columnsNames[] = {"Nombre", "País"};
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
			scrollPane.setBounds(10, 130, 507, 183);
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
			bExit.setBounds(527, 290, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBRegister() {
		if (bRegister == null) {
			bRegister = new JButton("Registrar");
			bRegister.setBounds(347, 84, 94, 23);
		}
		return bRegister;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Registrar Aerolinea");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNameAeroline() {
		if (lNameAeroline == null) {
			lNameAeroline = new JLabel("Nombre de la Aerolinea");
			lNameAeroline.setBounds(20, 60, 127, 14);
		}
		return lNameAeroline;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameAerolinea() {
		if (tNameAerolinea == null) {
			tNameAerolinea = new JTextField();
			tNameAerolinea.setBounds(10, 85, 137, 20);
			tNameAerolinea.setColumns(10);
		}
		return tNameAerolinea;
	}
//------------------------------------------------------------------------------------
	public JLabel getLContry() {
		if (lContry == null) {
			lContry = new JLabel("País");
			lContry.setBounds(209, 60, 80, 14);
		}
		return lContry;
	}
//------------------------------------------------------------------------------------
	public JTextField getTContry() {
		if (tContry == null) {
			tContry = new JTextField();
			tContry.setBounds(209, 85, 96, 20);
			tContry.setColumns(10);
		}
		return tContry;
	}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tNameAerolinea.setText("");
		tContry.setText("");
		tTypeUser.setText("");
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
}
