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

public class GUIImpresionTiquete extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	private JLabel li;
	private DefaultTableModel dtmTPassenger;
	private JTable tPassenger;
	private JScrollPane spTPassenger;
	
	private ArrayList<Passenger> arrayLPassenger;
	private ArrayList <Airline> arrayLAirline;
	private ArrayList <Plane> arrayLPlane;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bImprimir;
	private JLabel tTitule;
	private JTextField tDatosPasajero;
	private JLabel lPassportPassengerConsult;
	private JButton bFiltrar;
	
	private DefaultTableModel dtmTAirline;
	private DefaultTableModel dtmTPlane;
	private JTable tAirline;
	private JTable tPlane;
	private JTextField tDatosAerolinea;
	private JTextField tDatosAvion;
	private JLabel lDatosAerolinea;
	private JLabel lDatoAvion;

	public GUIImpresionTiquete() {
		getContentPane().setBackground(new Color(255, 255, 255));
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(GUIImpresionTiquete.class.getResource("/media/logo 1.png")));
		
		setDTMTPassenger(dataTable,getColumnsNames());
		setPassenger(dtmTPassenger);
		//setAirline(dtmTAirline);
		//setPlane(dtmTPlane);
		setSPTPassenger(tPassenger);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBImprimir());
		getContentPane().add(getTTitule());
		getContentPane().add(getTDatosPasajero());
		getContentPane().add(getLPassportPassengerConsult());
		getContentPane().add(getBFiltrar());
		getContentPane().add(getImagen());
		getContentPane().add(getTDatosAerolinea());
		getContentPane().add(getTDatosAvion());
		getContentPane().add(getLDatosAerolinea());
		getContentPane().add(getLDatoAvion());
		setSize(1000,427);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	//fondo de la GUI
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(-14, -86, 998, 573);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIConsultFlight.class.getResource("/media/logo00.png")));
		getContentPane().add(li);
		}
		return li;
	}
//LLenado de la tabla
public void fillTable(ArrayList<Passenger> list) {
	    for (Passenger p : list) {
	        dtmTPassenger.addRow(
	       
	new Object[]{p.getPassport()});
	        dtmTPassenger.addRow(new Object[]{p.getName()});
	        dtmTPassenger.addRow(new Object[]{p.getLastName()});
	        dtmTPassenger.addRow(new Object[]{p.getBirthdate()});
	        dtmTPassenger.addRow(new Object[]{p.getGmail()});
	        dtmTPassenger.addRow(new Object[]{p.getPhone()});
	    }

	    setPassenger(dtmTPassenger);
	}
public ArrayList<Passenger>getArrayListPassenger(){
	return arrayLPassenger;
}
public void setArrayListPassenger(ArrayList<Passenger> arrayLPassenger){
	this.arrayLPassenger = arrayLPassenger;
}
public void setDTMTPassenger(Object data[][],String[] columnsNames) {
		dtmTPassenger = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTPassenger() {
		return dtmTPassenger;
	}
//------------------------------------------------------------------------------------
	public void setPassenger(DefaultTableModel dtmTPassenger) {
		tPassenger = new JTable(dtmTPassenger);
		//No poder editar los valores de la tabla
		tPassenger.setEnabled(false);
		//no poder mover las columnas
		tPassenger.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tPassenger.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTPassenger() {
		return this.tPassenger;
	}
	
	public void setSPTPassenger(JTable tPassenger) {
		spTPassenger = new JScrollPane(tPassenger);
		spTPassenger.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTPassenger() {
		return this.spTPassenger;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"DATOS DEL PASAJERO","DATOS DE LA AEROLINEA"};
		return columnsNames;
	}

//------------------------------------------------------------------------------------
	public void print(JTable tPassenger) {
		try {
			if(!tPassenger.print()) {
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
			tPassenger=new JTable(dtmTPassenger);
			tPassenger.setEnabled(false);
			tPassenger.getTableHeader().setReorderingAllowed(false);
			tPassenger.getTableHeader().setResizingAllowed(false);	
			spTPassenger = new JScrollPane(tPassenger);
			scrollPane.setColumnHeaderView(spTPassenger);
		}
		return scrollPane;
	}
//------------------------------------------------------------------------------------
	public JButton getBExit() {
		if (bExit == null) {
			bExit = new JButton("Salir");
			bExit.setBounds(880, 354, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBImprimir() {
		if (bImprimir == null) {
			bImprimir = new JButton("Imprimir");
			bImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bImprimir.setBounds(607, 217, 125, 23);
		}
		return bImprimir;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Imprimir Tiquete");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(335, 11, 279, 29);
		}
		return tTitule;
	}
	public JTextField getTDatosPasajero() {
		if (tDatosPasajero == null) {
			tDatosPasajero = new JTextField();
			tDatosPasajero.setBounds(41, 85, 146, 24);
			tDatosPasajero.setColumns(10);
		}
		return tDatosPasajero;
	}
//------------------------------------------------------------------------------------
	public JLabel getLPassportPassengerConsult() {
		if (lPassportPassengerConsult == null) {
			lPassportPassengerConsult = new JLabel("Ingrese el Pasaporte del Pasajero");
			lPassportPassengerConsult.setForeground(new Color(128, 128, 128));
			lPassportPassengerConsult.setFont(new Font("Tahoma", Font.BOLD, 11));
			lPassportPassengerConsult.setBounds(41, 54, 245, 20);
		}
		return lPassportPassengerConsult;
	}
//------------------------------------------------------------------------------------
	public JButton getBFiltrar() {
		if (bFiltrar == null) {
			bFiltrar = new JButton("Filtrar");
			bFiltrar.setBounds(620, 156, 89, 23);
		}
		return bFiltrar;
	}
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
			lDatosAerolinea = new JLabel("Ingrese el Nombre de la Aerolinea");
			lDatosAerolinea.setBounds(296, 57, 204, 14);
		}
		return lDatosAerolinea;
	}
	public JLabel getLDatoAvion() {
		if (lDatoAvion == null) {
			lDatoAvion = new JLabel("Ingrese el Numero de Placa del Avión");
			lDatoAvion.setBounds(548, 57, 217, 14);
		}
		return lDatoAvion;
	}
}