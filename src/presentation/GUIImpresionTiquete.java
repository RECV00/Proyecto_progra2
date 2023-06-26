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
		setAirline(dtmTAirline);
		setPlane(dtmTPlane);
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
		setSize(746,425);
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
//llenado y creando la tabla
	public void fillTable(ArrayList<Passenger> list, ArrayList<Airline> listA, ArrayList<Plane> listP) {
	    int maxRows = Math.max(Math.max(list.size(), listA.size()), listP.size());

	    for (int i = 0; i < maxRows; i++) {
	        if (i < list.size()) {
	            Passenger p = list.get(i);
	            dtmTPassenger.addRow(new Object[]{
	                    p.getPassport(),
	                    p.getName(),
	                    p.getLastName(),
	                    p.getBirthdate(),
	                    p.getGmail(),
	                    p.getPhone()
	            });
	        } else {
	            dtmTPassenger.addRow(new Object[]{"", "", "", "", "", ""});
	        }

	        if (i < listA.size()) {
	            Airline a = listA.get(i);
	            dtmTAirline.addRow(new Object[]{
	                    a.getName(),
	                    a.getContry()});
	        } else {
	            dtmTAirline.addRow(new Object[]{"", ""});
	        }

	        if (i < listP.size()) {
	            Plane pl = listP.get(i);
	            dtmTPlane.addRow(new Object[]{
	                    pl.getPlate(),
	                    pl.getAirline(),
	                    pl.getModel(),
	                    pl.getYear()});
	        } else {
	            dtmTPlane.addRow(new Object[]{"", "", "", ""});
	        }
	    }

	    setPassenger(dtmTPassenger);
	    setAirline(dtmTAirline);
	    setPlane(dtmTPlane);
	}

public ArrayList<Passenger>getArrayListPassenger(){
	return arrayLPassenger;
}
public void setArrayListPassenger(ArrayList<Passenger> arrayLPassenger){
	this.arrayLPassenger = arrayLPassenger;
}
public ArrayList<Airline>getArrayListAirline(){
	return arrayLAirline;
}
public void setArrayListAirline(ArrayList<Airline> arrayLAirline){
	this.arrayLAirline = arrayLAirline;
}
public ArrayList<Plane>getArrayListPlane(){
	return arrayLPlane;
}
public void setArrayListPlane(ArrayList<Plane> arrayLPlane){
	this.arrayLPlane = arrayLPlane;
}
//------------------------------------------------------------------------------------
public void setAirline(DefaultTableModel dtmTAirline) {
	tAirline = new JTable(dtmTAirline);
	//No poder editar los valores de la tabla
	tAirline.setEnabled(false);
	//no poder mover las columnas
	tAirline.getTableHeader().setReorderingAllowed(false);
	//no poder reducir el tamanio de las columnas
	tAirline.getTableHeader().setResizingAllowed(false);

}
public void setPlane(DefaultTableModel dtmTPlane) {
	tPlane = new JTable(dtmTPlane);
	//No poder editar los valores de la tabla
	tPlane.setEnabled(false);
	//no poder mover las columnas
	tPlane.getTableHeader().setReorderingAllowed(false);
	//no poder reducir el tamanio de las columnas
	tPlane.getTableHeader().setResizingAllowed(false);

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
		String columnsNames[] = {"DATOS DEL PASAJERO","DATOS DE LA AEROLÍNEA","DATOS DEL AVIÓN"};
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
			scrollPane.setBounds(41, 137, 606, 204);
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
			bExit.setBounds(503, 352, 94, 23);
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
			bImprimir.setBounds(222, 352, 124, 23);
		}
		return bImprimir;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Imprimir Tiquete");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(240, 11, 279, 29);
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
			lPassportPassengerConsult.setFont(new Font("Tahoma", Font.BOLD, 11));
			lPassportPassengerConsult.setForeground(new Color(128, 128, 128));
			lPassportPassengerConsult.setBounds(41, 54, 245, 20);
		}
		return lPassportPassengerConsult;
	}
//------------------------------------------------------------------------------------
	public JButton getBFiltrar() {
		if (bFiltrar == null) {
			bFiltrar = new JButton("Filtrar");
			bFiltrar.setBounds(41, 352, 89, 23);
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
			lDatosAerolinea = new JLabel("Ingrese el Nombre de la Aerolínea");
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