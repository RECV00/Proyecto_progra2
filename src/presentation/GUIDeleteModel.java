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

import domain.Model;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIDeleteModel extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	
	private DefaultTableModel dtmTModel;
	private JTable tModel;
	
	private JScrollPane spTModel;
	
	private ArrayList<Model> arrayLModel;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bDelete;
	private JLabel tTitule;
	private JTextField tNameDelete;
	private JLabel lNameDelete;

	public GUIDeleteModel() {
		
		setDTMTModel(dataTable,getColumnsNames());
		setModel(dtmTModel);
		setSPTModel(tModel);

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
	public void setDTMTModel(Object data[][],String[] columnsNames) {
		dtmTModel = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTModel() {
		return dtmTModel;
	}
//------------------------------------------------------------------------------------
	public void setModel(DefaultTableModel dtmTModel) {
		tModel = new JTable(dtmTModel);
		//No poder editar los valores de la tabla
		tModel.setEnabled(false);
		//no poder mover las columnas
		tModel.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tModel.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTModel() {
		return this.tModel;
	}
	
	public void setSPTModel(JTable tModel) {
		spTModel = new JScrollPane(tModel);
		spTModel.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTModel() {
		return this.spTModel;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"Nombre", "Contrase\u00F1a", "Tipo de Usuario", "Estado"};
		return columnsNames;
	}
//------------------------------------------------------------------------------------		
	public ArrayList<Model>getArrayListModel(){
		return arrayLModel;
	}
//------------------------------------------------------------------------------------
	public void print(JTable tModel) {
		try {
			if(!tModel.print()) {
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
			tModel=new JTable(dtmTModel);
			tModel.setEnabled(false);
			tModel.getTableHeader().setReorderingAllowed(false);
			tModel.getTableHeader().setResizingAllowed(false);	
			spTModel = new JScrollPane(tModel);
			scrollPane.setColumnHeaderView(spTModel);
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
			bDelete.setBounds(162, 81, 94, 23);
		}
		return bDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Eliminar Usuarios");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameDelete() {
		if (tNameDelete == null) {
			tNameDelete = new JTextField();
			tNameDelete.setBounds(27, 82, 112, 20);
			tNameDelete.setColumns(10);
		}
		return tNameDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNameDelete() {
		if (lNameDelete == null) {
			lNameDelete = new JLabel("Ingrese el Nombre  Eliminar");
			lNameDelete.setBounds(27, 57, 157, 14);
		}
		return lNameDelete;
	}
}

