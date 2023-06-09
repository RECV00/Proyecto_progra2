package presentation;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.User;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class GUIUser extends JFrame {

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
	private JButton bDelete;
	private JButton bUpdate;
	private JButton bConsult;
	private JLabel tTitule;

	public GUIUser() {
		
		setDTMTUser(dataTable,getColumnsNames());
		setUser(dtmTUser);
		setSPTUser(tUser);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBRegister());
		getContentPane().add(getBDelete());
		getContentPane().add(getBUpdate());
		getContentPane().add(getBConsult());
		getContentPane().add(getTTitule());
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
			scrollPane.setBounds(10, 81, 507, 232);
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
			bRegister.setBounds(527, 85, 94, 23);
		}
		return bRegister;
	}
//------------------------------------------------------------------------------------
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.setBounds(527, 119, 94, 23);
		}
		return bDelete;
	}
//------------------------------------------------------------------------------------
	public JButton getBUpdate() {
		if (bUpdate == null) {
			bUpdate = new JButton("Actualizar");
			bUpdate.setBounds(527, 153, 94, 23);
		}
		return bUpdate;
	}
//------------------------------------------------------------------------------------
	public JButton getBConsult() {
		if (bConsult == null) {
			bConsult = new JButton("Consultar");
			bConsult.setBounds(527, 187, 94, 23);
		}
		return bConsult;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Gestión de Usuarios");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(169, 26, 279, 29);
		}
		return tTitule;
	}
}
