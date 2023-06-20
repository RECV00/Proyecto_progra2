package presentation;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.User;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIRegisterUser extends JFrame {

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
	private JLabel lName;
	private JTextField tName;
	private JLabel lContrasena;
	private JLabel lTypeUser;
	private JTextField tContrasena;
	private JTextField tTypeUser;
	
	private JComboBox comboBoxState;

	public GUIRegisterUser() {
		
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
		getContentPane().add(getLName());
		getContentPane().add(getTName());
		getContentPane().add(getLContrasena());
		getContentPane().add(getLTypeUser());
		getContentPane().add(getTContrasena());
		getContentPane().add(getTTypeUser());
		getContentPane().add(getComboBoxState());
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
		String columnsNames[] = {"Nombre", "Contrase\u00F1a", "Tipo de Usuario", "Estado"};
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
			bRegister.setBounds(527, 146, 94, 23);
		}
		return bRegister;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Registrar Usuarios");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JLabel getLName() {
		if (lName == null) {
			lName = new JLabel("Nombre");
			lName.setBounds(20, 60, 49, 14);
		}
		return lName;
	}
//------------------------------------------------------------------------------------
	public JTextField getTName() {
		if (tName == null) {
			tName = new JTextField();
			tName.setBounds(10, 85, 96, 20);
			tName.setColumns(10);
		}
		return tName;
	}
//------------------------------------------------------------------------------------
	public JLabel getLContrasena() {
		if (lContrasena == null) {
			lContrasena = new JLabel("Contraseña");
			lContrasena.setBounds(118, 60, 80, 14);
		}
		return lContrasena;
	}
//------------------------------------------------------------------------------------
	public JLabel getLTypeUser() {
		if (lTypeUser == null) {
			lTypeUser = new JLabel("Tipo de Usuario");
			lTypeUser.setBounds(222, 60, 116, 14);
		}
		return lTypeUser;
	}
//------------------------------------------------------------------------------------
	public JTextField getTContrasena() {
		if (tContrasena == null) {
			tContrasena = new JTextField();
			tContrasena.setBounds(114, 85, 96, 20);
			tContrasena.setColumns(10);
		}
		return tContrasena;
	}
//------------------------------------------------------------------------------------
	public JTextField getTTypeUser() {
		if (tTypeUser == null) {
			tTypeUser = new JTextField();
			tTypeUser.setText("");
			tTypeUser.setBounds(222, 85, 96, 20);
			tTypeUser.setColumns(10);
		}
		return tTypeUser;
	}
//------------------------------------------------------------------------------------
	public JComboBox getComboBoxState() {
		if (comboBoxState == null) {
			comboBoxState = new JComboBox();
			comboBoxState.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Activo", "Inactivo"}));
			comboBoxState.setBounds(342, 84, 87, 22);
		}
		return comboBoxState;
	}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tName.setText("");
		tContrasena.setText("");
		tTypeUser.setText("");
		comboBoxState.setToolTipText("");
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
}
