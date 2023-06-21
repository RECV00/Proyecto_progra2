package presentation;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Flight;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class GUIUpdateFlight extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	
	private DefaultTableModel dtmTFlight;
	private JTable tFlight;
	
	
	private JScrollPane spTFlight;
	
	private ArrayList<Flight> arrayLFlight;
	private Object dataTable[][];
	private JButton bExit;
	private JButton bUpdate;
	private JLabel tTitule;
	private JLabel lNumFlight;
	private JTextField tNumFlight;
	private JLabel lDepartureCity;
	private JLabel lDepartureDateTime;
	private JTextField tDepartureCity;
	private JTextField tDepartureDateTime;
	
	private JComboBox comboBoxState;
	private JComboBox comboBoxAvion;
	private JLabel lArrivalCity;
	private JLabel lArrivalDateTime;
	private JLabel lFlights;
	private JTextField tArrivalCity;
	private JTextField tArrivalDateTime;

	public GUIUpdateFlight() {
		
		setDTMTFlight(dataTable,getColumnsNames());
		setFlight(dtmTFlight);
		setSPTFlight(tFlight);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aereolineas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBUpdate());
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
		getContentPane().add(getTArrivalCity());
		getContentPane().add(getTArrivalDateTime());
		getContentPane().add(getComboBoxAvion());
		setSize(1000,440);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
public void fillTable(ArrayList <Flight> list) {
		
		for(Flight f : list) {
			dtmTFlight.addRow(new Object[] {f.getNumFlight(), f.getDepartureCity(),f.getDepartureDateTime(),
					f.getArrivalCity(),f.getArrivalDateTime(),f.getSeat(),f.getAmount(f.getSeat())});
		}
		setFlight(dtmTFlight);
	}
public ArrayList<Flight>getArrayListFlight(){
	return arrayLFlight;
}
public void setArrayListFlight(ArrayList<Flight> arrayLFlight){
	this.arrayLFlight = arrayLFlight;
}
	
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
	public JTable getTFlight() {
		return this.tFlight;
	}
	
	public void setSPTFlight(JTable tFlight) {
		spTFlight = new JScrollPane(tFlight);
		spTFlight.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTFlight() {
		return this.spTFlight;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] = {"Numero de Vuelo", "Ciudad de Salida", "Salida: Hora/Fecha", "Cuidad de Arrribo","Arribo: Hora/Fecha","Avión","Asiento","Monto"};
		return columnsNames;
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
			scrollPane.setBounds(10, 209, 874, 183);
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
			bExit.setBounds(894, 358, 75, 23);
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
			bUpdate.setBounds(755, 189, 129, 23);
		}
		return bUpdate;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Actualizar Vuelos");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(346, 11, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNumFlight() {
		if (lNumFlight == null) {
			lNumFlight = new JLabel("Numero de Vuelo");
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
			lDepartureCity.setBounds(20, 116, 130, 14);
		}
		return lDepartureCity;
	}
//------------------------------------------------------------------------------------
	public JLabel getLDepartureDateTime() {
		if (lDepartureDateTime == null) {
			lDepartureDateTime = new JLabel("Salida:Hora/Fecha");
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
			comboBoxState.setBounds(482, 140, 143, 22);
		}
		return comboBoxState;
	}
public JComboBox getComboBoxAvion() {
		if (comboBoxAvion == null) {
			comboBoxAvion = new JComboBox();
			comboBoxAvion.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Aqui van los Aviones"}));
			comboBoxAvion.setBounds(482, 84, 143, 22);
		}
		return comboBoxAvion;
}
//-----------------------------------------------------------------------------------
	public void cleanForm() {
		tNumFlight.setText("");
		tDepartureCity.setText("");
		tDepartureDateTime.setText("");
	}
//------------------------------------------------------------------------------------
	public void showMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}
	public JLabel getLArrivalCity() {
		if (lArrivalCity == null) {
			lArrivalCity = new JLabel("Ciudad de Arribo");
			lArrivalCity.setBounds(160, 60, 133, 14);
		}
		return lArrivalCity;
	}
	public JLabel getLArrivalDateTime() {
		if (lArrivalDateTime == null) {
			lArrivalDateTime = new JLabel("Arribo:Hora/Fecha");
			lArrivalDateTime.setBounds(303, 60, 129, 14);
		}
		return lArrivalDateTime;
	}
	public JLabel getLFlights() {
		if (lFlights == null) {
			lFlights = new JLabel("Avión");
			lFlights.setBounds(303, 116, 68, 14);
		}
		return lFlights;
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
}