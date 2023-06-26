package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import domain.Airline;
import domain.User;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GUIRegisterAirline extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTAirline;
	private JTable tAirline;
	private JScrollPane spTAirline;
	private ArrayList<Airline>arrayLAirline;
	private Object dataTable[][];
//label,button,textfield
	private JButton bExit;
	private JButton bRegister;
	private JLabel tTitule;
	private JLabel lNameAeroline;
	private JTextField tNameAerolinea;
	private JLabel lContry;
	private JTextField tContry;
//fondo de la GUI
	private JLabel li;
	
	public GUIRegisterAirline() {
		
		setDTMTAirline(dataTable,getColumnsNames());
		setAirline(dtmTAirline);
		setSPTAirline(tAirline);
		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBRegister());
		getContentPane().add(getTTitule());
		getContentPane().add(getLNameAeroline());
		getContentPane().add(getTNameAerolinea());
		getContentPane().add(getLContry());
		getContentPane().add(getTContry());
		getContentPane().add(getImagen());
		setSize(722,414);
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
//llenando y creando la tabla
public void fillTable(ArrayList <Airline> list) {
		
		for(Airline air : list) {
			dtmTAirline.addRow(new Object[] {air.getName(), air.getContry()});
		}
		setAirline(dtmTAirline);
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
	public ArrayList<Airline>getArrayListAirline(){
		return arrayLAirline;
	}
	public void setArrayListAirline(ArrayList<Airline> arrayLAirline){
		this.arrayLAirline = arrayLAirline;
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
			scrollPane.setBounds(55, 155, 507, 183);
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
			bExit.setBounds(602, 341, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBRegister() {
		if (bRegister == null) {
			bRegister = new JButton("Registrar");
			bRegister.setBounds(452, 134, 110, 23);
		}
		return bRegister;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Registrar Aerolínea");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNameAeroline() {
		if (lNameAeroline == null) {
			lNameAeroline = new JLabel("Nombre de la Aerolínea");
			lNameAeroline.setFont(new Font("Tahoma", Font.BOLD, 11));
			lNameAeroline.setForeground(new Color(153, 153, 153));
			lNameAeroline.setBounds(20, 60, 179, 14);
		}
		return lNameAeroline;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameAerolinea() {
		if (tNameAerolinea == null) {
			tNameAerolinea = new JTextField();
			tNameAerolinea.setBounds(20, 85, 137, 20);
			tNameAerolinea.setColumns(10);
		}
		return tNameAerolinea;
	}
//------------------------------------------------------------------------------------
	public JLabel getLContry() {
		if (lContry == null) {
			lContry = new JLabel("País");
			lContry.setFont(new Font("Tahoma", Font.BOLD, 11));
			lContry.setForeground(new Color(153, 153, 153));
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
	
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
}
