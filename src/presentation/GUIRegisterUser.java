package presentation;


import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

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
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIRegisterUser extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTUser;
	private JTable tUser;
	private JScrollPane spTUser;
	private ArrayList<User> arrayLUser;
	private Object dataTable[][];
//label , button, textfield
	private JButton bExit;
	private JButton bRegister;
	private JLabel tTitule;
	private JLabel lName;
	private JTextField tName;
	private JLabel lContrasena;
	private JLabel lTypeUser;
	private JTextField tContrasena;
	private JLabel lState;
//comboBox
	private JComboBox comboBoxState;
	private JComboBox comboBoxTypeUser;

//fondo de la GUI
	private JLabel li;
	
	public GUIRegisterUser() {
		getContentPane().setBackground(new Color(255, 255, 255));
		
		setDTMTUser(dataTable,getColumnsNames());
		setUser(dtmTUser);
		setSPTUser(tUser);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBRegister());
		getContentPane().add(getTTitule());
		getContentPane().add(getLName());
		getContentPane().add(getTName());
		getContentPane().add(getLContrasena());
		getContentPane().add(getLTypeUser());
		getContentPane().add(getTContrasena());
		getContentPane().add(getComboBoxState());
		getContentPane().add(getComboBoxTypeUser());
		getContentPane().add(getLState());
		getContentPane().add(getImagen());
		setSize(728,452);
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
public void fillTable(ArrayList <User> list) {
		
		for(User user : list) {
			dtmTUser.addRow(new Object[] {user.getUserName(), user.getPassword(), user.getTypeUser(), user.getState()});
		}
		setUser(dtmTUser);
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
	public void setArrayListUser(ArrayList<User> arrayLUser){
		this.arrayLUser= arrayLUser;
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
			scrollPane.setBounds(54, 190, 507, 183);
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
			bExit.setBounds(608, 379, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBRegister() {
		if (bRegister == null) {
			bRegister = new JButton("Registrar");
			bRegister.setBounds(468, 168, 94, 23);
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
			lName.setForeground(new Color(153, 153, 153));
			lName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lName.setBackground(new Color(255, 255, 255));
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
			lContrasena.setForeground(new Color(153, 153, 153));
			lContrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
			lContrasena.setBounds(118, 60, 80, 14);
		}
		return lContrasena;
	}
//------------------------------------------------------------------------------------
	public JLabel getLTypeUser() {
		if (lTypeUser == null) {
			lTypeUser = new JLabel("Tipo de Usuario");
			lTypeUser.setForeground(new Color(153, 153, 153));
			lTypeUser.setFont(new Font("Tahoma", Font.BOLD, 11));
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
	public JComboBox getComboBoxState() {
		if (comboBoxState == null) {
			comboBoxState = new JComboBox();
			comboBoxState.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Activo", "Inactivo"}));
			comboBoxState.setBounds(342, 84, 87, 22);
		}
		return comboBoxState;
	}
	public JComboBox getComboBoxTypeUser() {
		if (comboBoxTypeUser == null) {
			comboBoxTypeUser = new JComboBox();
			comboBoxTypeUser.setModel(new DefaultComboBoxModel(new String[] {"Opciones","Administrador", "Colaborador"}));
			comboBoxTypeUser.setBounds(222, 84, 110, 22);
		}
		return comboBoxTypeUser;
	}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tName.setText("");
		tContrasena.setText("");
		this.comboBoxTypeUser.setSelectedIndex(0);
		this.comboBoxState.setSelectedIndex(0);
		
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
	public JLabel getLState() {
		if (lState == null) {
			lState = new JLabel("Estado");
			lState.setForeground(new Color(153, 153, 153));
			lState.setFont(new Font("Tahoma", Font.BOLD, 11));
			lState.setBounds(343, 60, 55, 14);
		}
		return lState;
	}
}
