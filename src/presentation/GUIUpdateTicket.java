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

import domain.Ticket;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIUpdateTicket extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	
	private DefaultTableModel dtmTTicket;
	private JTable tTicket;
	
	private JScrollPane spTTicket;
	
	private ArrayList<Ticket> arrayLTicket;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bUpdate;
	private JLabel tTitule;
	private JTextField tNameTicketUpdate;
	private JLabel lUpdateTicket;

	public GUIUpdateTicket() {
		
		setDTMTTicket(dataTable,getColumnsNames());
		setTicket(dtmTTicket);
		setSPTTicket(tTicket);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBUpdate());
		getContentPane().add(getTTitule());
		getContentPane().add(getTNameTicketUpdate());
		getContentPane().add(getLUpdateTicket());
		setSize(688,368);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
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
	public ArrayList<Ticket>getArrayListTicket(){
		return arrayLTicket;
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
			scrollPane.setBounds(10, 130, 507, 183);
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
			bUpdate.setBounds(386, 105, 131, 23);
		}
		return bUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Actualizar Tiquete");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNameTicketUpdate() {
		if (tNameTicketUpdate == null) {
			tNameTicketUpdate = new JTextField();
			tNameTicketUpdate.setBounds(27, 74, 132, 20);
			tNameTicketUpdate.setColumns(10);
		}
		return tNameTicketUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getLUpdateTicket() {
		if (lUpdateTicket == null) {
			lUpdateTicket = new JLabel("Ingrese el Número de Tiquete a Actualizar");
			lUpdateTicket.setBounds(27, 52, 284, 23);
		}
		return lUpdateTicket;
	}
}

