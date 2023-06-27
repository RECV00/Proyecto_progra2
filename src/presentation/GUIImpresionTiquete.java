package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;




import java.io.FileOutputStream;
import java.nio.channels.Pipe;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import domain.Airline;
import domain.Passenger;
import domain.Plane;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;


public class GUIImpresionTiquete<Objeto> extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	private JLabel li;
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
	
	private DefaultTableModel dtmTPassenger;
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
		
		setDTMTImpresionTicket(dataTable,getColumnsNames());
		setImpresionTicket(dtmTImpresionTicket);
		//setAirline(dtmTAirline);
		//setPlane(dtmTPlane);
		setSPTImpresionTicket(tImpresionTicket);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBImprimir());
		getContentPane().add(getTTitule());
		getContentPane().add(getTDatosPasajero());
		getContentPane().add(getLDatosPasajero());
		getContentPane().add(getBFiltrar());
		getContentPane().add(getImagen());
		getContentPane().add(getTDatosAerolinea());
		getContentPane().add(getTDatosAvion());
		getContentPane().add(getLDatosAerolinea());
		getContentPane().add(getLDatoAvion());
		setSize(1000,368);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setHorizontalAlignment(SwingConstants.CENTER);
		li.setBackground(new Color(255, 255, 255));
		li.setBounds(845, 54, 131, 183);
		ImageIcon imagen= new ImageIcon("media/Imagen1.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIImpresionTiquete.class.getResource("/media/Imagen1.png")));
		getContentPane().add(li);
		}
		return li;
	}
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
		String columnsNames[]= {};
		return columnsNames;
	}

//------------------------------------------------------------------------------------
	public  void print(String dato1,String dato2,String dato3) {
		try {
			if(!dato.print) {
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
			bExit.setBounds(870, 20, 94, 23);
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
			bImprimir.setBounds(723, 297, 141, 23);
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
	public JLabel getLDatosPasajero() {
		if (lDatosPasajero == null) {
			lDatosPasajero = new JLabel("Ingrese el Pasaporte del Pasajero");
			lDatosPasajero.setBounds(41, 54, 245, 20);
		}
		return lDatosPasajero;
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