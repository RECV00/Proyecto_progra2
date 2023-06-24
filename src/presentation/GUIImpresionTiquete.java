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
	private ArrayList <Airline> listA;
	private ArrayList <Plane> listP;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bImprimir;
	private JLabel tTitule;
	private JTextField tDatosPasajero;
	private JLabel lPassportPassengerConsult;
	private JButton bFiltrar;

	public GUIImpresionTiquete() {
		getContentPane().setBackground(new Color(255, 255, 255));
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(GUIImpresionTiquete.class.getResource("/media/logo 1.png")));
		
		setDTMTPassenger(dataTable,getColumnsNames());
		setPassenger(dtmTPassenger);
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
		li.setBounds(527, -33, 131, 183);
		ImageIcon imagen= new ImageIcon("media/Imagen1.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIImpresionTiquete.class.getResource("/media/Imagen1.png")));
		getContentPane().add(li);
		}
		return li;
	}
public void fillTable(ArrayList <Passenger> list,ArrayList <Airline> listA,ArrayList <Plane> listP) {
		
		for (Passenger p : list) {
			dtmTPassenger.addRow(new Object[]{p.getPassport()});
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
//------------------------------------------------------------------------------------
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
		String columnsNames[] = {"DATOS DEL PASAJERO","DATOS DE LA AEROLINEA","DATOS DEL AVIÓN"};
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
			bImprimir.setBounds(560, 59, 141, 23);
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
			tDatosPasajero.setBounds(34, 79, 146, 29);
			tDatosPasajero.setColumns(10);
		}
		return tDatosPasajero;
	}
//------------------------------------------------------------------------------------
	public JLabel getLPassportPassengerConsult() {
		if (lPassportPassengerConsult == null) {
			lPassportPassengerConsult = new JLabel("Ingrese el Pasaporte del Pasajero");
			lPassportPassengerConsult.setBounds(34, 59, 245, 20);
		}
		return lPassportPassengerConsult;
	}
//------------------------------------------------------------------------------------
	public JButton getBFiltrar() {
		if (bFiltrar == null) {
			bFiltrar = new JButton("Filtrar");
			bFiltrar.setBounds(190, 82, 89, 23);
		}
		return bFiltrar;
	}
	

	
	
//---------------------------AEROLINEAS----------------------------------------------------------
	
	
	
	
}