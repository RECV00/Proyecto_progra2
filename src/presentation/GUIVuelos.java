package presentation;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import domain.Flight;
import domain.Passenger;
import domain.Plane;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class GUIVuelos extends JFrame {

	private JPanel contentPane;
	//table
		private JScrollPane scrollPane;
		private JTextPane tAMostrarDato;
		private DefaultTableModel dtmTVuelos;
		private JTable tVuelos;
		private JScrollPane spTVuelos;
		private ArrayList<Flight> arrayLF;
		private ArrayList<Plane>arrayLP;
		private Object dataTable[][];
		private JLabel lVuelos;
// button 
		private JButton bConsultV;
		private JButton bExit;
//comboBox
		private JComboBox<String>comboBoxFlight;//Combobox para cargar las placas de los aviones
	    private DefaultComboBoxModel<String> comboBoxModelo; // Se utiliza para almacenar y administrar los elementos de un JComboBox que son de tipo String.
//fondo de la gui
	    private JLabel li;
	    
public GUIVuelos(ArrayList<Flight>arrayLF) {
	getContentPane().setBackground(new Color(51, 51, 102));
		
		llenarComboBoxFlight(arrayLF,getComboBoxFlight());
		setDTMTVuelos(dataTable,getColumnsNames());
		setVuelos(dtmTVuelos);
		setSPTVuelos(tVuelos);
		
		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getLVuelos());
		getContentPane().add(getComboBoxFlight());
		getContentPane().add(getBConsultV());
		getContentPane().add(getBExit());
		setSize(753,524);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	//LLenado de la tabla
	public void fillTable(DefaultTableModel model,ArrayList <Flight> arrayLF,String avion,int eje,int eco,int tour,int vEje) {
		
		for (int i = 0; i < arrayLF.size(); i++) {
		 for (Flight f : arrayLF) {
		       if ( i < arrayLF.size()){
	    	model.addColumn("DATOS DEL VUELO", new String[]{"Numero de Vuelo: "+String.valueOf(f.getNumFlight()), 
	    				"Ciudad de Salida: "+f.getDepartureCity(),
	    				"Salida: Hora/Fecha: "+f.getDepartureDateTime(),
						"Cuidad de Arrribo: "+f.getArrivalCity(),
						"Arribo: Hora/Fecha: "+String.valueOf(f.getArrivalDateTime()),
						"Avión: "+f.getFlight(),
						"Aerolinea: "+avion,
						"Asientos [Ejecutiva Vendidos]: "+String.valueOf(vEje),
						"Asientos [Ejecutiva Dispobles]: "+String.valueOf(eje),
						"Asientos [Turista Vendidos]: "+String.valueOf(24),
						"Asientos [Turista Dispobles]: "+String.valueOf(tour),
						"Asientos [Economica Vendidos]: "+String.valueOf(26),
						"Asientos [Economica Dispobles]: "+String.valueOf(eco),
						"Tiquetes de Clase Ejecutiva: "+String.valueOf(28),
						"Tiquetes de Clase Turista: "+String.valueOf(29),
						"Tiquetes de Clase Economico: "+String.valueOf(30),
						"Monto por Vuelo: $"+String.valueOf(157390*0.13)});
			}
		 }
		}
			setVuelos(dtmTVuelos);
		}
//--------------------------------------------------------------------------------------------------
	public ArrayList<Flight>getArrayListFlight(){
		return arrayLF;
	}
	public void setArrayListFlight(ArrayList<Flight>arrayLF){
		this.arrayLF = arrayLF;
	}
	public ArrayList<Plane>getArrayListPlane(){
		return arrayLP;
	}
	public void setArrayListPlane(ArrayList<Plane>arrayLP){
		this.arrayLP = arrayLP;
	}
	//------------------------------------------------------------------------------------
	public void setDTMTVuelos(Object data[][],String[] columnsNames) {
		dtmTVuelos = new DefaultTableModel(data,columnsNames);
	}
//------------------------------------------------------------------------------------
	public DefaultTableModel getDTMTFlight() {
		return dtmTVuelos;
	}
	//------------------------------------------------------------------------------------
		public void setVuelos(DefaultTableModel dtmTVuelos) {
			tVuelos = new JTable(dtmTVuelos);
			//No poder editar los valores de la tabla
			tVuelos.setEnabled(false);
			//no poder mover las columnas
			tVuelos.getTableHeader().setReorderingAllowed(false);
			//no poder reducir el tamanio de las columnas
			tVuelos.getTableHeader().setResizingAllowed(false);

		}
		
	public void setSPTVuelos(JTable tVuelos) {
		spTVuelos = new JScrollPane(tVuelos);
		spTVuelos.setBounds(10,70,460,80);
	}
//------------------------------------------------------------------------------------
	public JScrollPane getSPTVuelos() {
		return this.spTVuelos;
	}
//------------------------------------------------------------------------------------
	public String[] getColumnsNames() {
		String columnsNames[] ={};
		return columnsNames;
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
			scrollPane.setBounds(37, 110, 587, 315);
			scrollPane.setViewportView(getTAMostrarDato());
			tVuelos=new JTable(dtmTVuelos);
			tVuelos.setEnabled(false);
			tVuelos.getTableHeader().setReorderingAllowed(false);
			tVuelos.getTableHeader().setResizingAllowed(false);	
			spTVuelos = new JScrollPane(tVuelos);
			scrollPane.setColumnHeaderView(spTVuelos);
		}
		return scrollPane;
}
		
	public JLabel getLVuelos() {
		if (lVuelos == null) {
			lVuelos = new JLabel("Lista de Vuelos");
			lVuelos.setForeground(new Color(153, 153, 153));
			lVuelos.setFont(new Font("Tahoma", Font.BOLD, 13));
			lVuelos.setBounds(23, 22, 114, 14);
		}
		return lVuelos;
	}
	// crea la lista seleccionable con las placas de los aviones
		public JComboBox<String> getComboBoxFlight() {
		    if (comboBoxFlight == null) {
		    	comboBoxFlight = new JComboBox<String>();
		    	comboBoxFlight.setBounds(10, 47, 143, 22);
		    	comboBoxFlight.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		    	
		    }
		    return comboBoxFlight;
		}
		public void llenarComboBoxFlight(ArrayList<Flight>arrayLF,JComboBox<String> comboBox) {
			String[] numF = new String[arrayLF.size()];
			for(int i=0; i<arrayLF.size(); i++) {
				numF[i] = arrayLF.get(i).getNumFlight();
			}
			 // Crea un DefaultComboBoxModel con el array de vuelos
			comboBoxModelo = new DefaultComboBoxModel<>(numF);
	        // Asigna el DefaultComboBoxModel al JComboBox
	        comboBox.setModel(comboBoxModelo);
		}
		    public void setcomboBoxFlight(JComboBox<String>comboBoxFlight) {
		        this.comboBoxFlight = comboBoxFlight;
		    }
	public JButton getBConsultV() {
		if (bConsultV == null) {
			bConsultV = new JButton("Consultar Vuelo");
			bConsultV.setBounds(184, 47, 130, 23);
		}
		return bConsultV;
	}
	

	public JButton getBExit() {
		if (bExit == null) {
			bExit = new JButton("Salir");
			bExit.setBounds(10, 436, 89, 23);
		}
		return bExit;
	}
	public void cleanForm() {
		comboBoxFlight.setToolTipText("");
	}
}

