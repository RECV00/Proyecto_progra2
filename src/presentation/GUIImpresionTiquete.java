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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class GUIImpresionTiquete extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTImpresionTicket;
	private JTable tImpresionTicket;
	private JScrollPane spTImpresionTicket;
	
	private ArrayList<Passenger> arrayLPassenger;
	private ArrayList <Airline> arrayLAirline;
	private ArrayList <Plane> arrayLPlane;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bImprimir;
	private JLabel tTitule;
	private JTextField tDatosPasajero;
	private JLabel lDatosPasajero;
	private JButton bFiltrar;
	

	private JTextField tDatosAerolinea;
	private JTextField tDatosAvion;
	private JLabel lDatosAerolinea;
	private JLabel lDatoAvion;
	private JLabel lMontoTotal;
	private JTextField tMontoTotal;
//fondo de la GUI
	private JLabel li;
	public GUIImpresionTiquete() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setDTMTImpresionTicket(dataTable,getColumnsNames());
		setImpresionTicket(dtmTImpresionTicket);
		setSPTImpresionTicket(tImpresionTicket);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBImprimir());
		getContentPane().add(getTTitule());
		getContentPane().add(getTDatosPasajero());
		getContentPane().add(getLDatosPasajero());
		getContentPane().add(getBFiltrar());
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
	    	
            for (Passenger p : arrayLPassenger) {
	        if (i < arrayLPassenger.size()) {
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
	        
	        if (i < arrayLPassenger.size()) {
            	model.addColumn("DATOS Del TIQUETE", new String[]{String.valueOf(numRandom()),horaFecha(),
            			"$"+String.valueOf((Integer.parseInt(getTMontoTotal().getText())+(Integer.parseInt(getTMontoTotal().getText())*0.13)))});
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
public void setDTMTImpresionTicket(Object data[][],String[] columnsNames) {
	dtmTImpresionTicket = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTImpresionTicket() {
		return dtmTImpresionTicket;
	}
//------------------------------------------------------------------------------------
	public void setImpresionTicket(DefaultTableModel dtmTImpresionTicket) {
		tImpresionTicket = new JTable(dtmTImpresionTicket);
		//No poder editar los valores de la tabla
		tImpresionTicket.setEnabled(false);
		//no poder mover las columnas
		tImpresionTicket.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tImpresionTicket.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTImpresionTicket() {
		return this.tImpresionTicket;
	}
	
	public void setSPTImpresionTicket(JTable tImpresionTicket) {
		spTImpresionTicket = new JScrollPane(tImpresionTicket);
		spTImpresionTicket.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTImpresionTicket() {
		return this.spTImpresionTicket;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {};
		return columnsNames;
	}

//------------------------------------------------------------------------------------
	public void print(JTable tImpresionTicket) {
		try {
			if(!tImpresionTicket.print()) {
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
			scrollPane.setBounds(41, 137, 642, 183);
			scrollPane.setViewportView(getTAMostrarDato());
			tImpresionTicket=new JTable(dtmTImpresionTicket);
			tImpresionTicket.setEnabled(false);
			tImpresionTicket.getTableHeader().setReorderingAllowed(false);
			tImpresionTicket.getTableHeader().setResizingAllowed(false);	
			spTImpresionTicket = new JScrollPane(tImpresionTicket);
			scrollPane.setColumnHeaderView(spTImpresionTicket);
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
	public JButton getBImprimir() {
		if (bImprimir == null) {
			bImprimir = new JButton("Imprimir");
			bImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bImprimir.setBounds(738, 232, 141, 23);
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
	public JButton getBFiltrar() {
		if (bFiltrar == null) {
			bFiltrar = new JButton("Filtrar");
			bFiltrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bFiltrar.setBounds(738, 159, 89, 23);
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
	
	public String horaFecha() {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       return dtf2.format(LocalDateTime.now());
	}
	public  int numRandom() {
	      return (int) (Math.random() * 100);
	   }
}