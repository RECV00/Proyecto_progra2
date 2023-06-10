package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIRegisterModel extends JFrame {

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
	private JButton bRegister;
	private JLabel tTitule;
	private JLabel lNameModel;
	private JTextField tNameModel;
	private JLabel lMarcaModel;
	private JLabel lnumAsientosModelEJE;
	private JTextField tMarcaModel;
	private JTextField tNumMarcaModelEJE;

	public GUIRegisterModel() {
		
		setDTMTModel(dataTable,getColumnsNames());
		setModel(dtmTModel);
		setSPTModel(tModel);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBRegister());
		getContentPane().add(getTTitule());
		getContentPane().add(getLNameModel());
		getContentPane().add(getTNameModel());
		getContentPane().add(getLMarcaModel());
		getContentPane().add(getLnumAsientosModelEJE());
		getContentPane().add(getTMarcaModel());
		getContentPane().add(getTNumMarcaModelEJE());
		setSize(689,410);
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
	public JLabel getLNameModel() {
		if (lNameModel == null) {
			lNameModel = new JLabel("Nombre");
			lNameModel.setBounds(20, 60, 49, 14);
		}
		return lNameModel;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameModel() {
		if (tNameModel == null) {
			tNameModel = new JTextField();
			tNameModel.setBounds(10, 85, 96, 20);
			tNameModel.setColumns(10);
		}
		return tNameModel;
	}
//------------------------------------------------------------------------------------
	public JLabel getLMarcaModel() {
		if (lMarcaModel == null) {
			lMarcaModel = new JLabel("Marca");
			lMarcaModel.setBounds(118, 60, 80, 14);
		}
		return lMarcaModel;
	}
//------------------------------------------------------------------------------------
	public JLabel getLnumAsientosModelEJE() {
		if (lnumAsientosModelEJE == null) {
			lnumAsientosModelEJE = new JLabel("Cantidad de Asientos Ejecutivos");
			lnumAsientosModelEJE.setBounds(222, 60, 116, 14);
		}
		return lnumAsientosModelEJE;
	}
//------------------------------------------------------------------------------------
	public JTextField getTMarcaModel() {
		if (tMarcaModel == null) {
			tMarcaModel = new JTextField();
			tMarcaModel.setBounds(114, 85, 96, 20);
			tMarcaModel.setColumns(10);
		}
		return tMarcaModel;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNumMarcaModelEJE() {
		if (tNumMarcaModelEJE == null) {
			tNumMarcaModelEJE = new JTextField();
			tNumMarcaModelEJE.setText("");
			tNumMarcaModelEJE.setBounds(222, 85, 96, 20);
			tNumMarcaModelEJE.setColumns(10);
		}
		return tNumMarcaModelEJE;
	}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tNameModel.setText("");
		tMarcaModel.setText("");
		tNumMarcaModelEJE.setText("");
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
}

