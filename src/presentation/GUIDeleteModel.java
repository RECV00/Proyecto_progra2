package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import domain.Model;
import domain.Model;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIDeleteModel extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTModel;
	private JTable tModel;
	private JScrollPane spTModel;
	private ArrayList<Model> arrayLModel;
	private Object dataTable[][];
//label,button,textfield
	private JButton bExit;
	private JButton bDelete;
	private JLabel tTitule;
	private JTextField tNameDeleteModelo;
	private JLabel lNameDeleteModelo;
//fondo de la GUI
	private JLabel li;
	
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
		getContentPane().add(getTNameDeleteModelo());
		getContentPane().add(getLNameDeleteModelo());
		getContentPane().add(getImagen());
		setSize(747,436);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo de la GUI
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(-13, -127, 987, 569);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIRegisterUser.class.getResource("/media/logo7.png")));
		getContentPane().add(li);
		}
		return li;
	}
//LLenado de la tabla	
public void fillTable(ArrayList <Model> list) {
		
		for(Model model : list) {
			dtmTModel.addRow(new Object[] {model.getName(), model.getMarca(),model.getCantSeatExecutive(),model.getCantSeatTourist(),model.getCantSeatEconomic()});
		}
		setModel(dtmTModel);
	}
public void setArrayListModel(ArrayList<Model> arrayLModel){
	this.arrayLModel= arrayLModel;
}
public ArrayList<Model>getArrayListModel(){
	return arrayLModel;
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
			scrollPane.setBounds(10, 179, 698, 183);
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
			bExit.setBounds(614, 363, 94, 23);
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
			bDelete.setBounds(551, 158, 157, 23);
		}
		return bDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Eliminar Modelos");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(239, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameDeleteModelo() {
		if (tNameDeleteModelo == null) {
			tNameDeleteModelo = new JTextField();
			tNameDeleteModelo.setBounds(59, 97, 139, 23);
			tNameDeleteModelo.setColumns(10);
		}
		return tNameDeleteModelo;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNameDeleteModelo() {
		if (lNameDeleteModelo == null) {
			lNameDeleteModelo = new JLabel("Ingrese el Modelo a Eliminar");
			lNameDeleteModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lNameDeleteModelo.setForeground(new Color(128, 128, 128));
			lNameDeleteModelo.setBounds(59, 72, 198, 14);
		}
		return lNameDeleteModelo;
	}
}

