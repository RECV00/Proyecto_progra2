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

import domain.Flight;
import domain.Flight;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIDeleteFlight extends JFrame {
//table
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane tAMostrarDato;
	private JButton bEXIT;
	private DefaultTableModel dtmTFlight;
	private JTable tFlight;
	private JScrollPane spTFlight;
	private ArrayList<Flight> arrayLFlight;
	private Object dataTable[][];
//label,button,textfield
	private JButton bExit;
	private JButton bDelete;
	private JLabel tTitule;
	private JTextField tVueloDelete;
	private JLabel lNameDelete;
//fondo de la GUI
	private JLabel li;
	
	public GUIDeleteFlight() {
		
		setDTMTFlight(dataTable,getColumnsNames());
		setFlight(dtmTFlight);
		setSPTFlight(tFlight);

		//setContentPane(contentPane);
		getContentPane().setLayout(null);
		setTitle("Sistema de Aerolíneas");
		getContentPane().add(getScrollPane());
		getContentPane().add(getBExit());
		getContentPane().add(getBDelete());
		getContentPane().add(getTTitule());
		getContentPane().add(getTVueloDelete());
		getContentPane().add(getLNameDelete());
		getContentPane().add(getImagen());
		setSize(1000,449);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//fondo de la GUI
	public JLabel getImagen() {
		if(li == null) {
		li = new JLabel();
		li.setBounds(-15, -105, 999, 606);
		ImageIcon imagen= new ImageIcon("media/java.jpg");
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(li.getWidth(),li.getHeight(),Image.SCALE_DEFAULT));
		li.setIcon(new ImageIcon(GUIDeleteFlight.class.getResource("/media/logo00.png")));
		getContentPane().add(li);
		}
		return li;
	}
//LLenado de la tabla	
public void fillTable(ArrayList <Flight> list) {
		
		for(Flight f: list) {
			dtmTFlight.addRow(new Object[] {f.getNumFlight(),f.getDepartureCity(),f.getDepartureDateTime(),f.getArrivalCity(),
					f.getArrivalDateTime(),f.getFlight(),f.getSeat(),f.getAmount()});
		}
		setFlight(dtmTFlight);
	}
public void setArrayListFlight(ArrayList<Flight> arrayLFlight){
	this.arrayLFlight= arrayLFlight;
}
public ArrayList<Flight>getArrayListFlight(){
	return arrayLFlight;
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
			scrollPane.setBounds(24, 198, 865, 183);
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
			bExit.setBounds(899, 376, 75, 23);
		}
		return bExit;
	}
//------------------------------------------------------------------------------------
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.setBounds(766, 177, 123, 23);
		}
		return bDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getTTitule() {
		if (tTitule == null) {
			tTitule = new JLabel("Eliminar Vuelos");
			tTitule.setFont(new Font("Tahoma", Font.BOLD, 26));
			tTitule.setBounds(353, 22, 279, 29);
		}
		return tTitule;
	}
//------------------------------------------------------------------------------------
	public JTextField getTVueloDelete() {
		if (tVueloDelete == null) {
			tVueloDelete = new JTextField();
			tVueloDelete.setBounds(86, 127, 158, 23);
			tVueloDelete.setColumns(10);
		}
		return tVueloDelete;
	}
//------------------------------------------------------------------------------------
	public JLabel getLNameDelete() {
		if (lNameDelete == null) {
			lNameDelete = new JLabel("Ingrese el Número de Vuelo Eliminar");
			lNameDelete.setForeground(new Color(128, 128, 128));
			lNameDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
			lNameDelete.setBounds(86, 102, 233, 14);
		}
		return lNameDelete;
	}
}

