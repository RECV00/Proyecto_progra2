package presentation;


import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Passenger;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GUIUpdatePassenger extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private DefaultTableModel dtmTPassenger;
	private JTable tPassenger;
	private JScrollPane spTPassenger;
	private ArrayList<Passenger> arrayLPassenger;
	private Object dataTable[][];
//label,button,textfield
	private JButton bExit;
	private JButton bUpdate;
	private JLabel tTitule;
	private JLabel lPassportPassenger;
	private JTextField tPassportPassenger;
	private JLabel lNamePassenger;
	private JLabel lLastNamePassenger;
	private JTextField tNamePassenger;
	private JTextField tLastNamePassenger;
	private JTextField tBirthdatePassenger;
	private JLabel lBirthdatePassenger;
	private JTextField tGmailPassenger;
	private JTextField tPhonePassenger;
	private JLabel lGmailPassenger;
	private JLabel lPhonePassenger;
//fondo de la GUI
	private JLabel li;
	
	public GUIUpdatePassenger() {
		
		setDTMTPassenger(dataTable,getColumnsNames());
		setPassenger(dtmTPassenger);
		setSPTPassenger(tPassenger);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBUpdate());
		getContentPane().add(getTTitule());
		getContentPane().add(getLPassportPassenger());
		getContentPane().add(getTPassportPassenger());
		getContentPane().add(getLNamePassenger());
		getContentPane().add(getLLastNamePassenger());
		getContentPane().add(getTNamePassenger());
		getContentPane().add(getTLastNamePassenger());
		getContentPane().add(getTBirthdatePassenger());
		getContentPane().add(getLBirthdatePassenger());
		getContentPane().add(getTGmailPassenger());
		getContentPane().add(getTPhonePassenger());
		getContentPane().add(getLGmailPassenger());
		getContentPane().add(getLPhonePassenger());
		getContentPane().add(getImagen());
		setSize(1000,504);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(-13, -127, 878, 706);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIRegisterUser.class.getResource("/media/logo7.png")));
		getContentPane().add(li);
		}
		return li;
	}
//llena y crea la tabla
public void fillTable(ArrayList <Passenger> list) {
		
		for(Passenger p : list) {
			dtmTPassenger.addRow(new Object[] {p.getPassport(),p.getName(),p.getLastName(),
					p.getBirthdate(),p.getGmail(),p.getPhone()});
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
		String columnsNames[] = {"Pasaporte", "Nombre", "Apellido", "Cumpleaños","Correo","Celular"};
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
			scrollPane.setBounds(10, 224, 722, 183);
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
			bExit.setBounds(638, 418, 94, 23);
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
			bUpdate.setBounds(615, 200, 117, 23);
		}
		return bUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Actualizar Pasajeros");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(307, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JLabel getLPassportPassenger() {
		if (lPassportPassenger == null) {
			lPassportPassenger = new JLabel("Pasaporte");
			lPassportPassenger.setForeground(new Color(128, 128, 128));
			lPassportPassenger.setFont(new Font("Tahoma", Font.BOLD, 11));
			lPassportPassenger.setBounds(20, 60, 96, 14);
		}
		return lPassportPassenger;
	}
//------------------------------------------------------------------------------------
	public JTextField getTPassportPassenger() {
		if (tPassportPassenger == null) {
			tPassportPassenger = new JTextField();
			tPassportPassenger.setBounds(20, 85, 96, 20);
			tPassportPassenger.setColumns(10);
		}
		return tPassportPassenger;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNamePassenger() {
		if (lNamePassenger == null) {
			lNamePassenger = new JLabel("Nombre");
			lNamePassenger.setForeground(new Color(128, 128, 128));
			lNamePassenger.setFont(new Font("Tahoma", Font.BOLD, 11));
			lNamePassenger.setBounds(20, 116, 80, 14);
		}
		return lNamePassenger;
	}
//------------------------------------------------------------------------------------
	public JLabel getLLastNamePassenger() {
		if (lLastNamePassenger == null) {
			lLastNamePassenger = new JLabel("Apellido");
			lLastNamePassenger.setForeground(new Color(128, 128, 128));
			lLastNamePassenger.setFont(new Font("Tahoma", Font.BOLD, 11));
			lLastNamePassenger.setBounds(154, 60, 80, 14);
		}
		return lLastNamePassenger;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNamePassenger() {
		if (tNamePassenger == null) {
			tNamePassenger = new JTextField();
			tNamePassenger.setBounds(20, 133, 96, 20);
			tNamePassenger.setColumns(10);
		}
		return tNamePassenger;
	}
//------------------------------------------------------------------------------------
	public JTextField getTLastNamePassenger() {
		if (tLastNamePassenger == null) {
			tLastNamePassenger = new JTextField();
			tLastNamePassenger.setText("");
			tLastNamePassenger.setBounds(154, 85, 96, 20);
			tLastNamePassenger.setColumns(10);
		}
		return tLastNamePassenger;
	}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tPassportPassenger.setText("");
		tNamePassenger.setText("");
		tLastNamePassenger.setText("");
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
	public JTextField getTBirthdatePassenger() {
		if (tBirthdatePassenger == null) {
			tBirthdatePassenger = new JTextField();
			tBirthdatePassenger.setBounds(154, 133, 96, 20);
			tBirthdatePassenger.setColumns(10);
		}
		return tBirthdatePassenger;
	}
	public JLabel getLBirthdatePassenger() {
		if (lBirthdatePassenger == null) {
			lBirthdatePassenger = new JLabel("Cumpleaños");
			lBirthdatePassenger.setForeground(new Color(128, 128, 128));
			lBirthdatePassenger.setFont(new Font("Tahoma", Font.BOLD, 11));
			lBirthdatePassenger.setBounds(154, 116, 96, 14);
		}
		return lBirthdatePassenger;
	}
	public JTextField getTGmailPassenger() {
		if (tGmailPassenger == null) {
			tGmailPassenger = new JTextField();
			tGmailPassenger.setBounds(287, 85, 219, 20);
			tGmailPassenger.setColumns(10);
		}
		return tGmailPassenger;
	}
	public JTextField getTPhonePassenger() {
		if (tPhonePassenger == null) {
			tPhonePassenger = new JTextField();
			tPhonePassenger.setBounds(287, 133, 96, 20);
			tPhonePassenger.setColumns(10);
		}
		return tPhonePassenger;
	}
	public JLabel getLGmailPassenger() {
		if (lGmailPassenger == null) {
			lGmailPassenger = new JLabel("Correo");
			lGmailPassenger.setForeground(new Color(128, 128, 128));
			lGmailPassenger.setFont(new Font("Tahoma", Font.BOLD, 11));
			lGmailPassenger.setBounds(287, 60, 71, 14);
		}
		return lGmailPassenger;
	}
	public JLabel getLPhonePassenger() {
		if (lPhonePassenger == null) {
			lPhonePassenger = new JLabel("Celular");
			lPhonePassenger.setFont(new Font("Tahoma", Font.BOLD, 11));
			lPhonePassenger.setForeground(new Color(128, 128, 128));
			lPhonePassenger.setBounds(287, 116, 71, 14);
		}
		return lPhonePassenger;
	}
}