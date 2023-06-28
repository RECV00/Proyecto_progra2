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
	private JTextField tDatosPasajero;
	private JLabel lDatosPasajero;
	
	private JTextField tDatosAerolinea;
	private JTextField tDatosAvion;
	private JLabel lDatosAerolinea;
	private JLabel lDatoAvion;
	private JLabel lMontoTotal;
	private JTextField tMontoTotal;
//fondo de la GUI
	private JLabel li;
	
	public GUIHistorialTiquete() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setDTMTHistorialTicket(dataTable,getColumnsNames());
		setHistorialTicket(dtmTHTicket);
		setSPTHistorialTicket(tHistorialTicket);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBConsult());
		getContentPane().add(getTTitule());
		getContentPane().add(getTDatosPasajero());
		getContentPane().add(getLDatosPasajero());
		getContentPane().add(getTDatosAerolinea());
		getContentPane().add(getTDatosAvion());
		getContentPane().add(getLDatosAerolinea());
		getContentPane().add(getLDatoAvion());
		getContentPane().add(getLMontoTotal());
		getContentPane().add(getTMontoTotal());
		getContentPane().add(getImagen() );
		setSize(1000,382);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo de la GUI
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(0, -124, 987, 683);
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
			scrollPane.setBounds(41, 137, 556, 183);
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
			bExit.setBounds(880, 297, 94, 23);
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
			bConsult.setBounds(620, 230, 141, 23);
		}
		return bConsult;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Consultar historial de Tiquete");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(237, 17, 424, 29);
		}
		return tTitule;
	}
	public JTextField getTDatosPasajero() {
		if (tDatosPasajero == null) {
			tDatosPasajero = new JTextField();
			tDatosPasajero.setBounds(41, 85, 146, 22);
			tDatosPasajero.setColumns(10);
		}
		return tDatosPasajero;
	}
//------------------------------------------------------------------------------------
	public JLabel getLDatosPasajero() {
		if (lDatosPasajero == null) {
			lDatosPasajero = new JLabel("Ingrese el Pasaporte del Pasajero");
			lDatosPasajero.setForeground(new Color(102, 102, 102));
			lDatosPasajero.setFont(new Font("Tahoma", Font.BOLD, 11));
			lDatosPasajero.setBounds(41, 54, 245, 20);
		}
		return lDatosPasajero;
	}
//------------------------------------------------------------------------------------

	public JTextField getTDatosAerolinea() {
		if (tDatosAerolinea == null) {
			tDatosAerolinea = new JTextField();
			tDatosAerolinea.setBounds(296, 87, 166, 20);
			tDatosAerolinea.setColumns(10);
		}
		return tDatosAerolinea;
	}
	public JTextField getTDatosAvion() {
		if (tDatosAvion == null) {
			tDatosAvion = new JTextField();
			tDatosAvion.setBounds(548, 87, 161, 20);
			tDatosAvion.setColumns(10);
		}
		return tDatosAvion;
	}
	public JLabel getLDatosAerolinea() {
		if (lDatosAerolinea == null) {
			lDatosAerolinea = new JLabel("Ingrese el Nombre de la Aerolínea");
			lDatosAerolinea.setForeground(new Color(102, 102, 102));
			lDatosAerolinea.setFont(new Font("Tahoma", Font.BOLD, 11));
			lDatosAerolinea.setBounds(296, 57, 224, 14);
		}
		return lDatosAerolinea;
	}
	public JLabel getLDatoAvion() {
		if (lDatoAvion == null) {
			lDatoAvion = new JLabel("Ingrese el Numero de Placa del Avión");
			lDatoAvion.setForeground(new Color(102, 102, 102));
			lDatoAvion.setFont(new Font("Tahoma", Font.BOLD, 11));
			lDatoAvion.setBounds(548, 57, 230, 14);
		}
		return lDatoAvion;
	}
	public JLabel getLMontoTotal() {
		if (lMontoTotal == null) {
			lMontoTotal = new JLabel("Monto Total");
			lMontoTotal.setForeground(new Color(102, 102, 102));
			lMontoTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
			lMontoTotal.setBounds(785, 57, 94, 14);
		}
		return lMontoTotal;
	}
	public JTextField getTMontoTotal() {
		if (tMontoTotal == null) {
			tMontoTotal = new JTextField();
			tMontoTotal.setBounds(785, 86, 96, 20);
			tMontoTotal.setColumns(10);
		}
		return tMontoTotal;
	}
}