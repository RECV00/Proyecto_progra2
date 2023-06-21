package presentation;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Brand;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

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
	private JButton bUpdate;
	private JLabel tTitule;
	private JTextField tNameBrandUpdate;
	private JLabel lUpdateBrand;

	public GUIUpdateBrand() {
		
		setDTMTBrand(dataTable,getColumnsNames());
		setBrand(dtmTBrand);
		setSPTBrand(tBrand);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBUpdate());
		getContentPane().add(getTTitule());
		getContentPane().add(getTNameBrandUpdate());
		getContentPane().add(getLUpdateBrand());
		setSize(688,368);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
public void fillTable(ArrayList <Brand> list) {
		
		for(Brand b : list) {
			dtmTBrand.addRow(new Object[] {b.getName()});
		}
		setBrand(dtmTBrand);
	}
public ArrayList<Brand>getArrayListBrand(){
	return arrayLBrand;
}
public void setArrayListBrand(ArrayList<Brand> arrayLBrand){
	this.arrayLBrand = arrayLBrand;
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
		String columnsNames[] = {"Nombres de las Marcas"};;
		return columnsNames;
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
	public JButton getBUpdate() {
		if (bUpdate == null) {
			bUpdate = new JButton("Actualizar");
			bUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bUpdate.setBounds(397, 112, 120, 23);
		}
		return bUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Actualizar Marcas");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameBrandUpdate() {
		if (tNameBrandUpdate == null) {
			tNameBrandUpdate = new JTextField();
			tNameBrandUpdate.setBounds(27, 74, 151, 20);
			tNameBrandUpdate.setColumns(10);
		}
		return tNameBrandUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getLUpdateBrand() {
		if (lUpdateBrand == null) {
			lUpdateBrand = new JLabel("Ingrese el Nombre a Actualizar");
			lUpdateBrand.setBounds(27, 52, 236, 23);
		}
		return lUpdateBrand;
	}
}

