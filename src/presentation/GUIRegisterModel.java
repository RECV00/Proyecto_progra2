package presentation;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Brand;
import domain.Model;
import domain.Plane;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
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
	private JTextField tCanMarcaModelEJE;
	private JLabel lnumAsientosModelTUR;
	private JTextField tCanAsientosTUR;
	private JLabel lnumAsientosModelEco;
	private JTextField tCanAsientosECO;
	private JComboBox<String>comboBoxBrand;	//Combobox para cargar los nombres de las marcas
    private DefaultComboBoxModel<String>comboBoxModelo; // Se utiliza para almacenar y administrar los elementos de un JComboBox que son de tipo String.
	ArrayList<Brand>arrayLB;
	
    public GUIRegisterModel(ArrayList<Brand>arrayLB) {
    	
    	llenarComboBoxBrand(arrayLB,getComboBoxBrand());

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
		getContentPane().add(getTCanMarcaModelEJE());
		getContentPane().add(getLnumAsientosModelTUR());
		getContentPane().add(getTCanAsientosTUR());
		getContentPane().add(getLnumAsientosModelEco());
		getContentPane().add(getTCanAsientosECO());
		getContentPane().add(getComboBoxBrand());
		setSize(891,410);
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
		String columnsNames[] = {"Nombre", "Marca", "Asientos Ejecutivos", "Asientos Turista", "Asientos Económicos"};
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
			scrollPane.setBounds(10, 179, 745, 183);
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
			bExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bExit.setBounds(771, 339, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBRegister() {
		if (bRegister == null) {
			bRegister = new JButton("Registrar");
			bRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bRegister.setBounds(590, 156, 165, 23);
		}
		return bRegister;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Registrar Modelos");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(298, 11, 285, 29);
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
			tNameModel.setBounds(10, 85, 94, 20);
			tNameModel.setColumns(10);
		}
		return tNameModel;
	}
//------------------------------------------------------------------------------------
	public JLabel getLMarcaModel() {
		if (lMarcaModel == null) {
			lMarcaModel = new JLabel("Marca");
			lMarcaModel.setBounds(21, 116, 80, 14);
		}
		return lMarcaModel;
	}
//------------------------------------------------------------------------------------
	public JLabel getLnumAsientosModelEJE() {
		if (lnumAsientosModelEJE == null) {
			lnumAsientosModelEJE = new JLabel("Cantidad de Asientos Ejecutivos");
			lnumAsientosModelEJE.setBounds(156, 60, 209, 14);
		}
		return lnumAsientosModelEJE;
	}
//------------------------------------------------------------------------------------
	public JTextField getTCanMarcaModelEJE() {
		if (tCanMarcaModelEJE == null) {
			tCanMarcaModelEJE = new JTextField();
			tCanMarcaModelEJE.setText("");
			tCanMarcaModelEJE.setBounds(156, 85, 74, 20);
			tCanMarcaModelEJE.setColumns(10);
		}
		return tCanMarcaModelEJE;
	}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tNameModel.setText("");
		comboBoxBrand.setToolTipText(null);
		tCanMarcaModelEJE.setText("");
		tCanAsientosTUR.setText("");
		tCanAsientosECO.setText("");
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
	public JLabel getLnumAsientosModelTUR() {
		if (lnumAsientosModelTUR == null) {
			lnumAsientosModelTUR = new JLabel("Cantidad de Asientos Turista");
			lnumAsientosModelTUR.setBounds(156, 116, 209, 14);
		}
		return lnumAsientosModelTUR;
	}
	public JTextField getTCanAsientosTUR() {
		if (tCanAsientosTUR == null) {
			tCanAsientosTUR = new JTextField();
			tCanAsientosTUR.setText("");
			tCanAsientosTUR.setColumns(10);
			tCanAsientosTUR.setBounds(156, 134, 74, 20);
		}
		return tCanAsientosTUR;
	}
	public JLabel getLnumAsientosModelEco() {
		if (lnumAsientosModelEco == null) {
			lnumAsientosModelEco = new JLabel("Cantidad de Asientos Económicos");
			lnumAsientosModelEco.setBounds(375, 60, 209, 14);
		}
		return lnumAsientosModelEco;
	}
	public JTextField getTCanAsientosECO() {
		if (tCanAsientosECO == null) {
			tCanAsientosECO = new JTextField();
			tCanAsientosECO.setText("");
			tCanAsientosECO.setColumns(10);
			tCanAsientosECO.setBounds(375, 85, 74, 20);
		}
		return tCanAsientosECO;
	}
	public JComboBox<String> getComboBoxBrand() {
		if (comboBoxBrand == null) {
			comboBoxBrand = new JComboBox<String>();
			comboBoxBrand.setBounds(20, 141, 106, 22);
			 comboBoxBrand.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		}
		return comboBoxBrand;
	}
	public ArrayList<Brand>getArrayListBrand(){
		return arrayLB;
	}
	public void setArrayListBrand(ArrayList<Brand> arrayLB){
		this.arrayLB = arrayLB;
	}
	public void llenarComboBoxBrand(ArrayList<Brand>arrayLB,JComboBox<String> comboBox) {
		String[] marca = new String[arrayLB.size()];
		for(int i=0; i<arrayLB.size(); i++) {
			marca[i]=arrayLB.get(i).getName();
		}
		 // Crea un DefaultComboBoxModel con el array de aviones
		comboBoxModelo = new DefaultComboBoxModel<>(marca);

        // Asigna el DefaultComboBoxModel al JComboBox
        comboBox.setModel(comboBoxModelo);
	}
	    public void setcomboBoxBrand(JComboBox<String> comboBoxBrand) {
	        this.comboBoxBrand = comboBoxBrand;
	    }
}

