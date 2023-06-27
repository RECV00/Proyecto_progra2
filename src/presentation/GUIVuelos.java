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
import domain.Plane;

import javax.swing.JLabel;
import javax.swing.JComboBox;

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
		setSize(1400,524);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	//LLenado de la tabla
	public void fillTable(ArrayList <Flight> list,String avion) {
		for(Flight f : list) {
				dtmTVuelos.addRow(new Object[] {f.getNumFlight(), f.getDepartureCity(),f.getDepartureDateTime(),
						f.getArrivalCity(),f.getArrivalDateTime(),f.getFlight(),avion,21,23,24,25,26,27,28,29,30,31});
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
		String columnsNames[] ={"Numero Vuelo","Ciudad Salida","Salida: Hora/Fecha",
				"Cuidad de Arrribo","Arribo: Hora/Fecha","Avión","Aerolínea",
				"Asientos: Ejecutiva Vendidos","Asientos: Ejecutiva Dispobles",
				"Asientos: Turista Vendidos","Asientos: Turista Dispobles","Asientos: Economica Vendidos",
				"Asientos: Economica Dispobles","Tiquete Ejecutivo","Tiquete Turista","Tiquete Economico",
				"Monto por Vuelo"};
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
			scrollPane.setBounds(10, 189, 1360, 183);
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
			bConsultV.setBounds(23, 89, 130, 23);
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
