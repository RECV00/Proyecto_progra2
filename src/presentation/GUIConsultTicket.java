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
import domain.Ticket;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIConsultTicket extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTTicket;
	private JTable tTicket;
	private JScrollPane spTTicket;
	private ArrayList<Ticket> arrayLTicket;
	private Object dataTable[][];
//JLabel y JTextField
	private JButton bExit;
	private JButton bCheckHistory;
	private JLabel tTitule;
	private JTextField tConsultNumTicket;
	private JLabel lConsultNumTicket;
	private JButton bSearch;
//fondo de la GUI
	private JLabel li;
	
	public GUIConsultTicket() {
		
		setDTMTTicket(dataTable,getColumnsNames());
		setTicket(dtmTTicket);
		setSPTTicket(tTicket);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBCheckHistory());
		getContentPane().add(getTTitule());
		getContentPane().add(getTConsultNumTicket());
		getContentPane().add(getLConsultNumTicket());
		getContentPane().add(getBSearch());
		getContentPane().add(getImagen());
		setSize(713,414);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo de la GUI
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(-13, -127, 987, 528);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIRegisterUser.class.getResource("/media/logo7.png")));
		getContentPane().add(li);
		}
		return li;
	}
//LLenado de la tabla
public void fillTable(ArrayList <Ticket> list) {
		
		for(Ticket t : list) {
			dtmTTicket.addRow(new Object[] {t.getNumTicket(),t.getPassport(),t.getNumFlight()});
		}
		setTicket(dtmTTicket);
	}
public ArrayList<Ticket>getArrayListTicket(){
	return arrayLTicket;
}
public void setArrayListTicket(ArrayList<Ticket> arrayLTicket){
	this.arrayLTicket = arrayLTicket;
}
//------------------------------------------------------------------------------------
	public void setDTMTTicket(Object data[][],String[] columnsNames) {
		dtmTTicket = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTTicket() {
		return dtmTTicket;
	}
//------------------------------------------------------------------------------------
	public void setTicket(DefaultTableModel dtmTTicket) {
		tTicket = new JTable(dtmTTicket);
		//No poder editar los valores de la tabla
		tTicket.setEnabled(false);
		//no poder mover las columnas
		tTicket.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tTicket.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTTicket() {
		return this.tTicket;
	}
	
	public void setSPTTicket(JTable tTicket) {
		spTTicket = new JScrollPane(tTicket);
		spTTicket.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTTicket() {
		return this.spTTicket;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"Número de Tiquete", "Pasaporte", "Número de Vuelo"};
		return columnsNames;
	}

//------------------------------------------------------------------------------------
	public void print(JTable tTicket) {
		try {
			if(!tTicket.print()) {
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
			scrollPane.setBounds(27, 165, 507, 183);
			scrollPane.setViewportView(getTAMostrarDato());
			tTicket=new JTable(dtmTTicket);
			tTicket.setEnabled(false);
			tTicket.getTableHeader().setReorderingAllowed(false);
			tTicket.getTableHeader().setResizingAllowed(false);	
			spTTicket = new JScrollPane(tTicket);
			scrollPane.setColumnHeaderView(spTTicket);
		}
		return scrollPane;
	}
//------------------------------------------------------------------------------------
	public JButton getBExit() {
		if (bExit == null) {
			bExit = new JButton("Salir");
			bExit.setBounds(593, 341, 94, 23);
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
			bCheckHistory.setBounds(360, 141, 174, 23);
		}
		return bCheckHistory;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Consultar Tiquete");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
	public JTextField getTConsultNumTicket() {
		if (tConsultNumTicket == null) {
			tConsultNumTicket = new JTextField();
			tConsultNumTicket.setBounds(34, 79, 146, 29);
			tConsultNumTicket.setColumns(10);
		}
		return tConsultNumTicket;
	}
//------------------------------------------------------------------------------------
	public JLabel getLConsultNumTicket() {
		if (lConsultNumTicket == null) {
			lConsultNumTicket = new JLabel("Ingrese el Número de Tiquete");
			lConsultNumTicket.setForeground(new Color(128, 128, 128));
			lConsultNumTicket.setFont(new Font("Tahoma", Font.BOLD, 11));
			lConsultNumTicket.setBounds(34, 59, 224, 20);
		}
		return lConsultNumTicket;
	}
//------------------------------------------------------------------------------------
	public JButton getBSearch() {
		if (bSearch == null) {
			bSearch = new JButton("Buscar");
			bSearch.setBounds(190, 82, 89, 23);
		}
		return bSearch;
	}
}