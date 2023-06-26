package presentation;


import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Ticket;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GUIRegisterTicket extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTTicket;
	private JTable tTicket;
	private JScrollPane spTTicket;
	private ArrayList<Ticket> arrayLTicket;
	private Object dataTable[][];
//label,button,textfield
	private JButton bExit;
	private JButton bRegister;
	private JLabel tTitule;
	private JLabel lNumTicket;
	private JTextField tNumTicket;
	private JLabel lPassportTicket;
	private JLabel lNumFlightTicket;
	private JTextField tPassportTicket;
	private JTextField tNumFlightTicket;
//fondo de la GUI
	private JLabel li;
	
	public GUIRegisterTicket() {
		
		setDTMTTicket(dataTable,getColumnsNames());
		setTicket(dtmTTicket);
		setSPTTicket(tTicket);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBRegister());
		getContentPane().add(getTTitule());
		getContentPane().add(getLNumTicket());
		getContentPane().add(getTNumTicket());
		getContentPane().add(getLPassportTicket());
		getContentPane().add(getLNumFlightTicket());
		getContentPane().add(getTPassportTicket());
		getContentPane().add(getTNumFlightTicket());
		getContentPane().add(getImagen());
		setSize(724,465);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	//fondo
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(-13, -127, 874, 633);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIRegisterUser.class.getResource("/media/logo7.png")));
		getContentPane().add(li);
		}
		return li;
	}
//llena y crea la tabla
//------------------------------------------------------------------------------------
	public void setDTMTTicket(Object data[][],String[] columnsNames) {
		dtmTTicket = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTTicket() {
		return dtmTTicket;
	}
//------------------------------------------------------------------------------------
	public void setTicket(DefaultTableModel dtmTTicket) {
		tTicket = new JTable(dtmTTicket);
		//No poder editar los valores de la tabla
		tTicket.setEnabled(false);
		//no poder mover las columnas
		tTicket.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tTicket.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTTicket() {
		return this.tTicket;
	}
	
	public void setSPTTicket(JTable tTicket) {
		spTTicket = new JScrollPane(tTicket);
		spTTicket.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTTicket() {
		return this.spTTicket;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"Número de Tiquete", "Pasaporte", "Número de Vuelo"};
		return columnsNames;
	}
//------------------------------------------------------------------------------------		
	public ArrayList<Ticket>getArrayListTicket(){
		return arrayLTicket;
	}
//------------------------------------------------------------------------------------
	public void print(JTable tTicket) {
		try {
			if(!tTicket.print()) {
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
			scrollPane.setBounds(52, 210, 516, 183);
			scrollPane.setViewportView(getTAMostrarDato());
			tTicket=new JTable(dtmTTicket);
			tTicket.setEnabled(false);
			tTicket.getTableHeader().setReorderingAllowed(false);
			tTicket.getTableHeader().setResizingAllowed(false);	
			spTTicket = new JScrollPane(tTicket);
			scrollPane.setColumnHeaderView(spTTicket);
		}
		return scrollPane;
	}
//------------------------------------------------------------------------------------
	public JButton getBExit() {
		if (bExit == null) {
			bExit = new JButton("Salir");
			bExit.setBounds(604, 392, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBRegister() {
		if (bRegister == null) {
			bRegister = new JButton("Registrar");
			bRegister.setBounds(417, 188, 151, 23);
		}
		return bRegister;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Registrar Tiquetes");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNumTicket() {
		if (lNumTicket == null) {
			lNumTicket = new JLabel("Número de Tiquete");
			lNumTicket.setForeground(new Color(128, 128, 128));
			lNumTicket.setFont(new Font("Tahoma", Font.BOLD, 11));
			lNumTicket.setBounds(26, 60, 116, 14);
		}
		return lNumTicket;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNumTicket() {
		if (tNumTicket == null) {
			tNumTicket = new JTextField();
			tNumTicket.setBounds(26, 82, 96, 20);
			tNumTicket.setColumns(10);
		}
		return tNumTicket;
	}
//------------------------------------------------------------------------------------
	public JLabel getLPassportTicket() {
		if (lPassportTicket == null) {
			lPassportTicket = new JLabel("Pasaporte");
			lPassportTicket.setForeground(new Color(128, 128, 128));
			lPassportTicket.setFont(new Font("Tahoma", Font.BOLD, 11));
			lPassportTicket.setBounds(26, 108, 80, 14);
		}
		return lPassportTicket;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNumFlightTicket() {
		if (lNumFlightTicket == null) {
			lNumFlightTicket = new JLabel("Número de Vuelo");
			lNumFlightTicket.setForeground(new Color(128, 128, 128));
			lNumFlightTicket.setFont(new Font("Tahoma", Font.BOLD, 11));
			lNumFlightTicket.setBounds(164, 60, 116, 14);
		}
		return lNumFlightTicket;
	}
//------------------------------------------------------------------------------------
	public JTextField getTPassportTicket() {
		if (tPassportTicket == null) {
			tPassportTicket = new JTextField();
			tPassportTicket.setBounds(26, 133, 96, 20);
			tPassportTicket.setColumns(10);
		}
		return tPassportTicket;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNumFlightTicket() {
		if (tNumFlightTicket == null) {
			tNumFlightTicket = new JTextField();
			tNumFlightTicket.setText("");
			tNumFlightTicket.setBounds(164, 82, 96, 20);
			tNumFlightTicket.setColumns(10);
		}
		return tNumFlightTicket;
	}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tNumTicket.setText("");
		tPassportTicket.setText("");
		tNumFlightTicket.setText("");
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
}