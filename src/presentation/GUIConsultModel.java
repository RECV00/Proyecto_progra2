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

import domain.Airline;
import domain.Model;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIConsultModel extends JFrame {
	//Para la table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTModel;
	private JTable tModel;
	private JScrollPane spTModel;
	private ArrayList<Model> arrayLModel;
	private Object dataTable[][];
	private JButton bEXIT;
	private JButton bExit;
	private JButton bCheckHistory;
	private JLabel tTitule;
	private JTextField tConsultName;
	private JLabel lConsultNameModel;
	private JButton bSearch;
	//para el fondo de la GUI
	private JLabel li;
	
	public GUIConsultModel() {
		getContentPane().setBackground(new Color(128, 128, 128));
		
		setDTMTModel(dataTable,getColumnsNames());
		setModel(dtmTModel);
		setSPTModel(tModel);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBCheckHistory());
		getContentPane().add(getTTitule());
		getContentPane().add(getTConsultName());
		getContentPane().add(getLConsultNameModel());
		getContentPane().add(getBSearch());
		getContentPane().add(getImagen());
		setSize(891,442);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo de la GUI
		public JLabel getImagen() {
			if(li == null) {
			li = new JLabel();
			li.setBounds(-33, -94, 987, 558);
			ImageIcon imagen= new ImageIcon("media/java.jpg");
			Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
			li.setIcon(new ImageIcon(GUIConsultModel.class.getResource("/media/logo00.png")));
			getContentPane().add(li);
			}
			return li;
		}
	//LLenado de la tabla
public void fillTable(ArrayList <Model> list) {
		
		for(Model m : list) {
			dtmTModel.addRow(new Object[] {m.getName(),m.getMarca(),
					m.getCantSeatExecutive(),m.getCantSeatEconomic(),m.getCantSeatTourist()});
		}
		setModel(dtmTModel);
	}
public ArrayList<Model>getArrayListModel(){
	return arrayLModel;
}
public void setArrayListModel(ArrayList<Model> arrayLModel){
	this.arrayLModel = arrayLModel;
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
			bExit.setBounds(765, 339, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBCheckHistory() {
		if (bCheckHistory == null) {
			bCheckHistory = new JButton("Consultar Historial");
			bCheckHistory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bCheckHistory.setBounds(590, 157, 165, 23);
		}
		return bCheckHistory;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Consultar Modelo");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(316, 11, 279, 29);
		}
		return tTitule;
	}
	public JTextField getTConsultName() {
		if (tConsultName == null) {
			tConsultName = new JTextField();
			tConsultName.setBounds(44, 92, 146, 29);
			tConsultName.setColumns(10);
		}
		return tConsultName;
	}
//------------------------------------------------------------------------------------
	public JLabel getLConsultNameModel() {
		if (lConsultNameModel == null) {
			lConsultNameModel = new JLabel("Ingrese el Modelo");
			lConsultNameModel.setForeground(new Color(128, 128, 128));
			lConsultNameModel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lConsultNameModel.setBounds(44, 61, 166, 20);
		}
		return lConsultNameModel;
	}
//------------------------------------------------------------------------------------
	public JButton getBSearch() {
		if (bSearch == null) {
			bSearch = new JButton("Buscar");
			bSearch.setBounds(233, 95, 89, 23);
		}
		return bSearch;
	}
}