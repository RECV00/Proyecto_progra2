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
import domain.Passenger;
import domain.Plane;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GUIHistorialTiquete extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	private DefaultTableModel dtmTHTicket;
	private JTable tHistorialTicket;
	private JScrollPane spTHTicket;
	
	private ArrayList<Passenger> arrayLPassenger;
	private ArrayList <Airline> arrayLAirline;
	private ArrayList <Plane> arrayLPlane;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bConsult;
	private JLabel tTitule;
//fondo de la GUI
	private JLabel li;
	private JScrollPane scrollPaneHTiquete;
	private JTextArea taConsultarHTiquete;
	
	public GUIHistorialTiquete() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setDTMTHistorialTicket(dataTable,getColumnsNames());
		setHistorialTicket(dtmTHTicket);
		setSPTHistorialTicket(tHistorialTicket);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		//getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBConsult());
		getContentPane().add(getTTitule());
		getContentPane().add(getScrollPaneHTiquete());
		getContentPane().add(getImagen());
		setSize(1000,382);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo de la GUI
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(0, -124, 986, 683);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIConsultModel.class.getResource("/media/logo00.png")));
		getContentPane().add(li);
		}
		return li;
	}

//llenando y creando la tabla

	public void fillTable(DefaultTableModel model, ArrayList<Passenger> arrayLPassenger, ArrayList<Airline> arrayLAirline, ArrayList<Plane> arrayLPlane) {
	    int maxLength = Math.max(Math.max(arrayLPassenger.size(), arrayLAirline.size()), arrayLPlane.size());
	    for (int i = 0; i < maxLength; i++) {
	        if (i < arrayLPassenger.size()) {
	            
	            for (Passenger p : arrayLPassenger) {
	            	model.addColumn("DATOS DEL PASAJERO", new String[]{p.getPassport(),p.getName(),p.getLastName(),
	            			p.getBirthdate(),p.getGmail(),String.valueOf(p.getPhone())});
	            }
	        }
	        for (Airline a : arrayLAirline) {
	        if (i < arrayLAirline.size()) {
	            model.addColumn("DATOS DE LA AEROLINEA", new String[]{a.getName(),a.getContry()});
	        	}
	        }
	        for (Plane pl : arrayLPlane) {
	        if (i < arrayLPlane.size()) {
	            model.addColumn("DATOS DEL AVIÓN", new String[]{pl.getPlate(),pl.getAirline(),pl.getModel(),
	            		pl.getYear()});
	        }
	       }
	    }
	}
public void setArrayListPlane(ArrayList<Plane> arrayLPlane){
	this.arrayLPlane= arrayLPlane;
}
public ArrayList<Plane>getArrayListPlane(){
	return arrayLPlane;
}
public ArrayList<Airline>getArrayListAirline(){
	return arrayLAirline;
}
public void setArrayListAirline(ArrayList<Airline> arrayLAirline){
	this.arrayLAirline = arrayLAirline;
}
public ArrayList<Passenger>getArrayListPassenger(){
	return arrayLPassenger;
}
public void setArrayListPassenger(ArrayList<Passenger> arrayLPassenger){
	this.arrayLPassenger = arrayLPassenger;
}
public void setDTMTHistorialTicket(Object data[][],String[] columnsNames) {
	dtmTHTicket = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTHistorialTicket() {
		return dtmTHTicket;
	}
//------------------------------------------------------------------------------------
	public void setHistorialTicket(DefaultTableModel dtmTHTicket) {
		tHistorialTicket = new JTable(dtmTHTicket);
		//No poder editar los valores de la tabla
		tHistorialTicket.setEnabled(false);
		//no poder mover las columnas
		tHistorialTicket.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tHistorialTicket.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTHistorialTicket() {
		return this.tHistorialTicket;
	}
	
	public void setSPTHistorialTicket(JTable tHistorialTicket) {
		spTHTicket = new JScrollPane(tHistorialTicket);
		spTHTicket.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTHistorialTicket() {
		return this.spTHTicket;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {};
		return columnsNames;
	}

//------------------------------------------------------------------------------------
	public void print(JTable tHistorialTicket) {
		try {
			if(!tHistorialTicket.print()) {
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
			scrollPane.setBounds(23, 147, 808, 187);
			scrollPane.setViewportView(getTAMostrarDato());
			tHistorialTicket=new JTable(dtmTHTicket);
			tHistorialTicket.setEnabled(false);
			tHistorialTicket.getTableHeader().setReorderingAllowed(false);
			tHistorialTicket.getTableHeader().setResizingAllowed(false);	
			spTHTicket = new JScrollPane(tHistorialTicket);
			scrollPane.setColumnHeaderView(spTHTicket);
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
			bExit.setBounds(870, 21, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBConsult() {
		if (bConsult == null) {
			bConsult = new JButton("Consultar Tiquetes");
			bConsult.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bConsult.setBounds(732, 292, 184, 23);
		}
		return bConsult;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Consultar historial de Tiquete");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(262, 21, 424, 29);
		}
		return tTitule;
	}
	public JScrollPane getScrollPaneHTiquete() {
		if (scrollPaneHTiquete == null) {
			scrollPaneHTiquete = new JScrollPane();
			scrollPaneHTiquete.setBounds(20, 72, 659, 262);
			scrollPaneHTiquete.setViewportView(getTaConsultarHTiquete());
		}
		return scrollPaneHTiquete;
	}
	public JTextArea getTaConsultarHTiquete() {
		if (taConsultarHTiquete == null) {
			taConsultarHTiquete = new JTextArea();
		}
		return taConsultarHTiquete;
	}
}