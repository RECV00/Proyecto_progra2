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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIUpdateBrand extends JFrame {

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
	private JButton bUpdateBrand;
	private JLabel tTitule;
	private JLabel lNameUpdateMarca;
	private JTextField tNameMarcaUpdate;

	public GUIUpdateBrand() {
		
		setDTMTBrand(dataTable,getColumnsNames());
		setBrand(dtmTBrand);
		setSPTBrand(tBrand);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBUpdateBrand());
		getContentPane().add(getTTitule());
		getContentPane().add(getLNameUpdateMarca());
		getContentPane().add(getTNameMarcaUpdate());
		setSize(460,368);
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
		String columnsNames[] = {"Marca"};
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
			scrollPane.setBounds(83, 130, 213, 183);
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
			bExit.setBounds(319, 290, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBUpdateBrand() {
		if (bUpdateBrand == null) {
			bUpdateBrand = new JButton("Actualizar");
			bUpdateBrand.setBounds(319, 134, 94, 23);
		}
		return bUpdateBrand;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Actualizar Marca");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(100, 11, 279, 29);
		}
		return tTitule;
	}
	public JLabel getLNameUpdateMarca() {
		if (lNameUpdateMarca == null) {
			lNameUpdateMarca = new JLabel("Marca a Atualizar");
			lNameUpdateMarca.setBounds(51, 65, 146, 23);
		}
		return lNameUpdateMarca;
	}
	public JTextField getTNameMarcaUpdate() {
		if (tNameMarcaUpdate == null) {
			tNameMarcaUpdate = new JTextField();
			tNameMarcaUpdate.setBounds(51, 99, 126, 20);
			tNameMarcaUpdate.setColumns(10);
		}
		return tNameMarcaUpdate;
	}
}
