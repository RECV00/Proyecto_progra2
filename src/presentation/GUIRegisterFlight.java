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

import data.FilesXML;
import domain.Flight;
import domain.Plane;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.List;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GUIRegisterFlight extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private FilesXML fXML;
	private DefaultTableModel dtmTFlight;
	private JTable tFlight;
	private JScrollPane spTFlight;
	private ArrayList<Flight> arrayLFlight;
	private Object dataTable[][];
//label , button ,textfield
	private JButton bExit;
	private JButton bRegister;
	private JLabel tTitule;
	private JLabel lNumFlight;
	private JTextField tNumFlight;
	private JLabel lDepartureCity;
	private JLabel lDepartureDateTime;
	private JTextField tDepartureCity;
	private JTextField tDepartureDateTime;
	private JLabel lArrivalCity;
	private JLabel lArrivalDateTime;
	private JLabel lFlight;
	private JTextField tArrivalCity;
	private JTextField tArrivalDateTime;
	private JLabel lTypeAsiento;
//comboBox
	private JComboBox comboBoxState;
	private JComboBox<String>comboBoxAvion1;//Combobox para cargar las placas de los aviones
    private DefaultComboBoxModel<String> comboBoxModelo; // Se utiliza para almacenar y administrar los 
	ArrayList<Plane>arrayLP;						//elementos de un JComboBox que son de tipo String.
	private JLabel lAmount;
	private JTextField tAmount;
//fondo de la GUI
	private JLabel li;
	
	public GUIRegisterFlight(ArrayList<Plane>arrayLP) {
		
		llenarComboBoxAviones(arrayLP,getComboBoxAvion1());
		setDTMTFlight(dataTable,getColumnsNames());
		setFlight(dtmTFlight);
		setSPTUser(tFlight);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBRegister());
		getContentPane().add(getTTitule());
		getContentPane().add(getLNumFlight());
		getContentPane().add(getTNumFlight());
		getContentPane().add(getLDepartureCity());
		getContentPane().add(getLDepartureDateTime());
		getContentPane().add(getTDepartureCity());
		getContentPane().add(getTDepartureDateTime());
		getContentPane().add(getComboBoxState());
		getContentPane().add(getLArrivalCity());
		getContentPane().add(getLArrivalDateTime());
		getContentPane().add(getLFlight());
		getContentPane().add(getTArrivalCity());
		getContentPane().add(getTArrivalDateTime());
		getContentPane().add(getLTypeAsiento());
		getContentPane().add(getComboBoxAvion1());
		getContentPane().add(getLAmount());
		getContentPane().add(getTAmount());
		getContentPane().add(getImagen());
		setSize(981,462);
		
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

//------------------------------------------------------------------------------------
	public void setDTMTFlight(Object data[][],String[] columnsNames) {
		dtmTFlight = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTFlight() {
		return dtmTFlight;
	}
//------------------------------------------------------------------------------------
	public void setFlight(DefaultTableModel dtmTFlight) {
		tFlight = new JTable(dtmTFlight);
		//No poder editar los valores de la tabla
		tFlight.setEnabled(false);
		//no poder mover las columnas
		tFlight.getTableHeader().setReorderingAllowed(false);
		//no poder reducir el tamanio de las columnas
		tFlight.getTableHeader().setResizingAllowed(false);

	}
//------------------------------------------------------------------------------------	
	public JTable getTUser() {
		return this.tFlight;
	}
	
	public void setSPTUser(JTable tFlight) {
		spTFlight = new JScrollPane(tFlight);
		spTFlight.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTFlight() {
		return this.spTFlight;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"Número de Vuelo", "Ciudad de Salida", "Salida: Hora/Fecha", "Cuidad de Arrribo","Arribo: Hora/Fecha","Avión","Asiento","Monto"};
		return columnsNames;
	}
//------------------------------------------------------------------------------------		
	public ArrayList<Flight>getArrayListFlight(){
		return arrayLFlight;
	}
//------------------------------------------------------------------------------------
	public void print(JTable tFlight) {
		try {
			if(!tFlight.print()) {
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
			scrollPane.setBounds(37, 215, 886, 183);
			scrollPane.setViewportView(getTAMostrarDato());
			tFlight=new JTable(dtmTFlight);
			tFlight.setEnabled(false);
			tFlight.getTableHeader().setReorderingAllowed(false);
			tFlight.getTableHeader().setResizingAllowed(false);	
			spTFlight = new JScrollPane(tFlight);
			scrollPane.setColumnHeaderView(spTFlight);
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
			bExit.setBounds(849, 397, 75, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBRegister() {
		if (bRegister == null) {
			bRegister = new JButton("Registrar");
			bRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bRegister.setBounds(794, 193, 129, 23);
		}
		return bRegister;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Registrar Vuelo");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(182, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNumFlight() {
		if (lNumFlight == null) {
			lNumFlight = new JLabel("Número de Vuelo");
			lNumFlight.setForeground(new Color(128, 128, 128));
			lNumFlight.setFont(new Font("Tahoma", Font.BOLD, 11));
			lNumFlight.setBounds(20, 60, 130, 14);
		}
		return lNumFlight;
	}
//------------------------------------------------------------------------------------
	public JTextField getTNumFlight() {
		if (tNumFlight == null) {
			tNumFlight = new JTextField();
			tNumFlight.setBounds(20, 85, 96, 20);
			tNumFlight.setColumns(10);
		}
		return tNumFlight;
	}
//------------------------------------------------------------------------------------
	public JLabel getLDepartureCity() {
		if (lDepartureCity == null) {
			lDepartureCity = new JLabel("Ciudad de Salidad");
			lDepartureCity.setFont(new Font("Tahoma", Font.BOLD, 11));
			lDepartureCity.setForeground(new Color(128, 128, 128));
			lDepartureCity.setBounds(20, 116, 130, 14);
		}
		return lDepartureCity;
	}
//------------------------------------------------------------------------------------
	public JLabel getLDepartureDateTime() {
		if (lDepartureDateTime == null) {
			lDepartureDateTime = new JLabel("Salida:Hora/Fecha");
			lDepartureDateTime.setForeground(new Color(128, 128, 128));
			lDepartureDateTime.setFont(new Font("Tahoma", Font.BOLD, 11));
			lDepartureDateTime.setBounds(160, 116, 133, 14);
		}
		return lDepartureDateTime;
	}
//------------------------------------------------------------------------------------
	public JTextField getTDepartureCity() {
		if (tDepartureCity == null) {
			tDepartureCity = new JTextField();
			tDepartureCity.setBounds(20, 141, 96, 20);
			tDepartureCity.setColumns(10);
		}
		return tDepartureCity;
	}
//------------------------------------------------------------------------------------
	public JTextField getTDepartureDateTime() {
		if (tDepartureDateTime == null) {
			tDepartureDateTime = new JTextField();
			tDepartureDateTime.setText("");
			tDepartureDateTime.setBounds(160, 141, 96, 20);
			tDepartureDateTime.setColumns(10);
		}
		return tDepartureDateTime;
	}
//------------------------------------------------------------------------------------
	public JComboBox getComboBoxState() {
		if (comboBoxState == null) {
			comboBoxState = new JComboBox();
			comboBoxState.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Clase Ejecutiva", "Clase Turista", "Clase Económica"}));
			comboBoxState.setBounds(303, 140, 143, 22);
		}
		return comboBoxState;
	}
// crea la lista seleccionable con las placas de los aviones
	public JComboBox<String> getComboBoxAvion1() {
	    if (comboBoxAvion1 == null) {
	    	comboBoxAvion1 = new JComboBox<String>();
	    	 comboBoxAvion1.setBounds(436, 84, 143, 22);
	    	 comboBoxAvion1.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
	    	
	    }
	    return comboBoxAvion1;
	}
	public void llenarComboBoxAviones(ArrayList<Plane>arrayLP,JComboBox<String> comboBox) {
		String[] placas = new String[arrayLP.size()];
		for(int i=0; i<arrayLP.size(); i++) {
			placas[i]=arrayLP.get(i).getPlate();
		}
		 // Crea un DefaultComboBoxModel con el array de aviones
		comboBoxModelo = new DefaultComboBoxModel<>(placas);

        // Asigna el DefaultComboBoxModel al JComboBox
        comboBox.setModel(comboBoxModelo);
	}
	    public void setcomboBoxAvion1(JComboBox<String> comboBoxAvion1) {
	        this.comboBoxAvion1 = comboBoxAvion1;
	    }
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tNumFlight.setText("");
		tDepartureCity.setText("");
		tDepartureDateTime.setText("");
		tArrivalCity.setText("");
		tArrivalDateTime.setText("");
		comboBoxAvion1.setToolTipText("");
		comboBoxState.setToolTipText("");
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
	public JLabel getLArrivalCity() {
		if (lArrivalCity == null) {
			lArrivalCity = new JLabel("Ciudad de Arribo");
			lArrivalCity.setFont(new Font("Tahoma", Font.BOLD, 11));
			lArrivalCity.setForeground(new Color(128, 128, 128));
			lArrivalCity.setBounds(160, 60, 133, 14);
		}
		return lArrivalCity;
	}
	public JLabel getLArrivalDateTime() {
		if (lArrivalDateTime == null) {
			lArrivalDateTime = new JLabel("Arribo:Hora/Fecha");
			lArrivalDateTime.setForeground(new Color(128, 128, 128));
			lArrivalDateTime.setFont(new Font("Tahoma", Font.BOLD, 11));
			lArrivalDateTime.setBounds(303, 60, 129, 14);
		}
		return lArrivalDateTime;
	}
	public JLabel getLFlight() {
		if (lFlight == null) {
			lFlight = new JLabel("Avión");
			lFlight.setForeground(new Color(128, 128, 128));
			lFlight.setFont(new Font("Tahoma", Font.BOLD, 11));
			lFlight.setBounds(438, 60, 68, 14);
		}
		return lFlight;
	}
	public JTextField getTArrivalCity() {
		if (tArrivalCity == null) {
			tArrivalCity = new JTextField();
			tArrivalCity.setBounds(160, 85, 96, 20);
			tArrivalCity.setColumns(10);
		}
		return tArrivalCity;
	}
	public JTextField getTArrivalDateTime() {
		if (tArrivalDateTime == null) {
			tArrivalDateTime = new JTextField();
			tArrivalDateTime.setBounds(303, 85, 96, 20);
			tArrivalDateTime.setColumns(10);
		}
		return tArrivalDateTime;
	}
	public JLabel getLTypeAsiento() {
		if (lTypeAsiento == null) {
			lTypeAsiento = new JLabel("Asiento");
			lTypeAsiento.setFont(new Font("Tahoma", Font.BOLD, 11));
			lTypeAsiento.setForeground(new Color(128, 128, 128));
			lTypeAsiento.setBounds(303, 126, 49, 14);
		}
		return lTypeAsiento;
	}
	public JLabel getLAmount() {
		if (lAmount == null) {
			lAmount = new JLabel("Monto del Asiento");
			lAmount.setForeground(new Color(102, 102, 102));
			lAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
			lAmount.setBounds(491, 116, 111, 14);
		}
		return lAmount;
	}
	public JTextField getTAmount() {
		if (tAmount == null) {
			tAmount = new JTextField();
			tAmount.setBounds(491, 141, 111, 20);
			tAmount.setColumns(10);
		}
		return tAmount;
	}
}