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

import domain.Passenger;
import domain.Passenger;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIDeletePassenger extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTPassenger;
	private JTable tPassenger;
	private JScrollPane spTPassenger;
	private ArrayList<Passenger> arrayLPassenger;
	private Object dataTable[][];
//label, button , textfield
	private JButton bExit;
	private JButton bDelete;
	private JLabel tTitule;
	private JTextField tPassportDelete;
	private JLabel lNameDelete;
//fondo de la GUI
	private JLabel li;
	
	public GUIDeletePassenger() {
		
		setDTMTPassenger(dataTable,getColumnsNames());
		setPassenger(dtmTPassenger);
		setSPTPassenger(tPassenger);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBDelete());
		getContentPane().add(getTTitule());
		getContentPane().add(getTPassportDelete());
		getContentPane().add(getLNameDelete());
		getContentPane().add(getImagen());
		setSize(892,398);
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
//LLenado de la tabla	
public void fillTable(ArrayList <Passenger> list) {
		
		for(Passenger passenger : list) {
			dtmTPassenger.addRow(new Object[] {passenger.getPassport(), passenger.getName(), passenger.getLastName(), passenger.getBirthdate(),passenger.getGmail(),passenger.getPhone()});
		}
		setPassenger(dtmTPassenger);
	}
public void setArrayListPassenger(ArrayList<Passenger> arrayLPassenger){
	this.arrayLPassenger= arrayLPassenger;
}
public ArrayList<Passenger>getArrayListPassenger(){
	return arrayLPassenger;
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
		String columnsNames[] = {"Pasaporte", "Nombre", "Apellido", "Cumpleaños","Correo","Celular"};
		return columnsNames;
	}
//------------------------------------------------------------------------------------		
	
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
			scrollPane.setBounds(10, 130, 862, 183);
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
			bExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bExit.setBounds(772, 324, 94, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bDelete.setBounds(712, 112, 160, 23);
		}
		return bDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Eliminar Pasajeros");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(205, 17, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTPassportDelete() {
		if (tPassportDelete == null) {
			tPassportDelete = new JTextField();
			tPassportDelete.setBounds(27, 82, 112, 20);
			tPassportDelete.setColumns(10);
		}
		return tPassportDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNameDelete() {
		if (lNameDelete == null) {
			lNameDelete = new JLabel("Ingrese el Pasajero a Eliminar");
			lNameDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
			lNameDelete.setForeground(new Color(128, 128, 128));
			lNameDelete.setBounds(27, 57, 214, 14);
		}
		return lNameDelete;
	}
}
