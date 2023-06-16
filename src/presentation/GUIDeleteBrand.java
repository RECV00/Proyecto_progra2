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

import domain.Brand;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIDeleteBrand extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	
	private DefaultTableModel dtmTBrand;
	private JTable tBrand;
	
	private JScrollPane spTBrand;
	
	private ArrayList<Brand> arrayLBrand;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bDelete;
	private JLabel tTitule;
	private JTextField tNameDelete;
	private JLabel lNameDelete;

	public GUIDeleteBrand() {
		
		setDTMTBrand(dataTable,getColumnsNames());
		setBrand(dtmTBrand);
		setSPTBrand(tBrand);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBDelete());
		getContentPane().add(getTTitule());
		getContentPane().add(getTNameDelete());
		getContentPane().add(getLNameDelete());
		setSize(688,368);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
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
			scrollPane.setBounds(10, 130, 507, 183);
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
			bExit.setBounds(527, 290, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bDelete.setBounds(388, 109, 129, 23);
		}
		return bDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Eliminar Marcas");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(199, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameDelete() {
		if (tNameDelete == null) {
			tNameDelete = new JTextField();
			tNameDelete.setBounds(27, 82, 145, 20);
			tNameDelete.setColumns(10);
		}
		return tNameDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNameDelete() {
		if (lNameDelete == null) {
			lNameDelete = new JLabel("Ingrese el Nombre  Eliminar");
			lNameDelete.setBounds(27, 57, 176, 14);
		}
		return lNameDelete;
	}
}
