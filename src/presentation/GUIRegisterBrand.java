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

import domain.Brand;

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

public class GUIRegisterBrand extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTBrand;
	private JTable tBrand;
	private JScrollPane spTBrand;
	private ArrayList<Brand> arrayLBrand;
	private Object dataTable[][];
//label,button,textfield
	private JButton bExit;
	private JButton bRegister;
	private JLabel tTitule;
	private JLabel lNameRegisterBrand;
	private JTextField tNameRegisterBrand;
//fondo de la GUI
	private JLabel li;
	
	public GUIRegisterBrand() {
		
		setDTMTBrand(dataTable,getColumnsNames());
		setBrand(dtmTBrand);
		setSPTBrand(tBrand);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBRegister());
		getContentPane().add(getTTitule());
		getContentPane().add(getLNameRegisterBrand());
		getContentPane().add(getTNameRegisterBrand());
		getContentPane().add(getImagen());
		setSize(729,408);
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
	
//------------------------------------------------------------------------------------
	public void setDTMTBrand(Object data[][],String[] columnsNames) {
		dtmTBrand = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTBrand() {
		return dtmTBrand;
	}
//------------------------------------------------------------------------------------
	public void setBrand(DefaultTableModel dtmTBrand) {
		tBrand = new JTable(dtmTBrand);
		//No poder editar los valores de la tabla
		tBrand.setEnabled(false);
		//no poder mover las columnas
		tBrand.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tBrand.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTBrand() {
		return this.tBrand;
	}
	
	public void setSPTBrand(JTable tBrand) {
		spTBrand = new JScrollPane(tBrand);
		spTBrand.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTBrand() {
		return this.spTBrand;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"Nombres de las Marcas"};
		return columnsNames;
	}
//------------------------------------------------------------------------------------		
	public ArrayList<Brand>getArrayListBrand(){
		return arrayLBrand;
	}
//------------------------------------------------------------------------------------
	public void print(JTable tBrand) {
		try {
			if(!tBrand.print()) {
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
			scrollPane.setBounds(44, 154, 507, 183);
			scrollPane.setViewportView(getTAMostrarDato());
			tBrand=new JTable(dtmTBrand);
			tBrand.setEnabled(false);
			tBrand.getTableHeader().setReorderingAllowed(false);
			tBrand.getTableHeader().setResizingAllowed(false);	
			spTBrand = new JScrollPane(tBrand);
			scrollPane.setColumnHeaderView(spTBrand);
		}
		return scrollPane;
	}
//------------------------------------------------------------------------------------
	public JButton getBExit() {
		if (bExit == null) {
			bExit = new JButton("Salir");
			bExit.setBounds(609, 335, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBRegister() {
		if (bRegister == null) {
			bRegister = new JButton("Registrar");
			bRegister.setBounds(411, 132, 140, 23);
		}
		return bRegister;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Registrar Marca");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNameRegisterBrand() {
		if (lNameRegisterBrand == null) {
			lNameRegisterBrand = new JLabel("Nombre de la Marca");
			lNameRegisterBrand.setForeground(new Color(128, 128, 128));
			lNameRegisterBrand.setFont(new Font("Tahoma", Font.BOLD, 11));
			lNameRegisterBrand.setBounds(33, 61, 140, 14);
		}
		return lNameRegisterBrand;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameRegisterBrand() {
		if (tNameRegisterBrand == null) {
			tNameRegisterBrand = new JTextField();
			tNameRegisterBrand.setBounds(33, 87, 140, 20);
			tNameRegisterBrand.setColumns(10);
		}
		return tNameRegisterBrand;
	}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tNameRegisterBrand.setText("");
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
}

