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
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class GUIImpresionTiquete extends JFrame {

	//table
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
	//Label,button,textfield
		private JLabel tTitule;
		private JLabel lDatosPasajero;
		private JButton bFiltrar;
		private JLabel lDatosAerolinea;
		private JLabel lDatoAvion;
		private JLabel lMontoTotal;
		private JTextField tMontoTotal;
	//comboBox
		private JComboBox<String>comboBoxAirline;	//Combobox para cargar los nombres de las marcas
		private DefaultComboBoxModel<String>comboBoxModelo; // Se utiliza para almacenar y administrar los elementos de un JComboBox que son de tipo String.
	//-------------------------------------------------------------
		private JComboBox<String>comboBoxPlane;
	//--------------------------------------------------------------
		private JComboBox<String>comboBoxPass;
	//fondo de la GUI
		private JLabel li;
		
	public GUIImpresionTiquete(ArrayList <Airline> arrayLAirline,ArrayList <Plane> arrayLPlane,ArrayList<Passenger> arrayLPassenger) {
		
		llenarComboBoxPlane(arrayLPlane,getComboBoxPlane());
		llenarComboBoxAirline(arrayLAirline,getComboBoxAirline());
		llenarComboBoxPassenger(arrayLPassenger,getComboBoxPass());
		
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
		getContentPane().add(getLDatosPasajero());
		getContentPane().add(getBFiltrar());
		getContentPane().add(getLDatosAerolinea());
		getContentPane().add(getLDatoAvion());
		getContentPane().add(getLMontoTotal());
		getContentPane().add(getTMontoTotal());
		getContentPane().add(getComboBoxAirline());
		getContentPane().add(getComboBoxPlane());
		getContentPane().add(getComboBoxPass());
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
		li.setBounds(0, -147, 1023, 683);
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
            	model.addColumn("DATOS DEL TIQUETE", new String[]{"#"+String.valueOf(numRandom()),horaFecha(),
            			"$"+String.valueOf((Integer.parseInt(getTMontoTotal().getText())+(Integer.parseInt(getTMontoTotal().getText())*0.13)))});
            }
	        
	    }
	    setImpresionTicket(model);
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
	
	/*public void print(JTable tImpresionTicket) {
	    StringBuilder content = new StringBuilder();
	    
	    // Obtener el número de filas y columnas de la tabla
	    int rowCount = tImpresionTicket.getRowCount();
	    int columnCount = tImpresionTicket.getColumnCount();
	    
	    // Recorrer las filas y columnas para obtener los valores de la tabla
	    for (int i = 0; i < rowCount; i++) {
	        for (int j = 0; j < columnCount; j++) {
	            Object value = tImpresionTicket.getValueAt(i, j);
	            content.append(value).append("\t"); // Agregar a la cadena
	        }
	        content.append("\n"); // salto de línea cada fila
	    }
	    
	    System.out.println("Contenido de la tabla:");
	    System.out.println(content.toString());
	    
	    //generar el PDF
	    try {
	        if (!tImpresionTicket.print()) {
	            System.err.println("Se canceló la Impresión");
	        }
	    } catch (java.awt.print.PrinterException e) {
	        System.err.format("Error de Impresión. %s%n", e.getMessage());
	    }
	}*/

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
			scrollPane.setBounds(26, 137, 751, 183);
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
			bExit.setBounds(894, 297, 80, 23);
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
			bImprimir.setBounds(787, 236, 125, 23);
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

//------------------------------------------------------------------------------------
	public JLabel getLDatosPasajero() {
		if (lDatosPasajero == null) {
			lDatosPasajero = new JLabel("Lista de Pasaportes");
			lDatosPasajero.setForeground(new Color(102, 102, 102));
			lDatosPasajero.setFont(new Font("Tahoma", Font.BOLD, 11));
			lDatosPasajero.setBounds(41, 54, 164, 20);
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
			bFiltrar.setBounds(806, 188, 89, 23);
		}
		return bFiltrar;
	}
	
	public JLabel getLDatosAerolinea() {
		if (lDatosAerolinea == null) {
			lDatosAerolinea = new JLabel("Lista de Aerolíneas");
			lDatosAerolinea.setForeground(new Color(128, 128, 128));
			lDatosAerolinea.setFont(new Font("Tahoma", Font.BOLD, 11));
			lDatosAerolinea.setBounds(204, 53, 148, 23);
		}
		return lDatosAerolinea;
	}
	public JLabel getLDatoAvion() {
		if (lDatoAvion == null) {
			lDatoAvion = new JLabel("Lista de Aviones");
			lDatoAvion.setForeground(new Color(128, 128, 128));
			lDatoAvion.setFont(new Font("Tahoma", Font.BOLD, 11));
			lDatoAvion.setBounds(345, 54, 164, 20);
		}
		return lDatoAvion;
	}
	public JLabel getLMontoTotal() {
		if (lMontoTotal == null) {
			lMontoTotal = new JLabel("Monto Total");
			lMontoTotal.setForeground(new Color(128, 128, 128));
			lMontoTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
			lMontoTotal.setBounds(519, 57, 94, 14);
		}
		return lMontoTotal;
	}
	public JTextField getTMontoTotal() {
		if (tMontoTotal == null) {
			tMontoTotal = new JTextField();
			tMontoTotal.setBounds(518, 82, 96, 20);
			tMontoTotal.setColumns(10);
		}
		return tMontoTotal;
	}
	
	public String horaFecha() {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy			HH:mm:ss");
       return dtf2.format(LocalDateTime.now());
	}
	public  int numRandom() {
	      return (int) (Math.random() * 100);
	   }
	//comboBox
		public JComboBox<String> getComboBoxAirline() {
			if (comboBoxAirline == null) {
				comboBoxAirline = new JComboBox<String>();
				comboBoxAirline.setBounds(192, 85, 125, 22);
				comboBoxAirline.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
			}
			return comboBoxAirline;
		}
		
		public void llenarComboBoxAirline(ArrayList<Airline>arrayLA,JComboBox<String> comboBox) {
			String[] nameA = new String[arrayLA.size()];
			for(int i=0; i<arrayLA.size(); i++) {
				nameA[i]=arrayLA.get(i).getName();
			}
			 // Crea un DefaultComboBoxModel con el array de aviones
			comboBoxModelo = new DefaultComboBoxModel<>(nameA);
	        // Asigna el DefaultComboBoxModel al JComboBox
	        comboBox.setModel(comboBoxModelo);
		}
		    public void setcomboBoxAvion1(JComboBox<String> comboBoxAirline) {
		        this.comboBoxAirline = comboBoxAirline;
		    }
	// crea la lista seleccionable con las placas de los aviones
			public JComboBox<String> getComboBoxPlane() {
			    if (comboBoxPlane == null) {
			    	comboBoxPlane = new JComboBox<String>();
			    	comboBoxPlane.setBounds(355, 82, 125, 22);
			    	comboBoxPlane.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
			    	
			    }
			    return comboBoxPlane;
			}
			public void llenarComboBoxPlane(ArrayList<Plane>arrayLP,JComboBox<String> comboBox) {
				String[] placas = new String[arrayLP.size()];
				for(int i=0; i<arrayLP.size(); i++) {
					placas[i]=arrayLP.get(i).getPlate();
				}
				 // Crea un DefaultComboBoxModel con el array de aviones
				comboBoxModelo = new DefaultComboBoxModel<>(placas);

		        // Asigna el DefaultComboBoxModel al JComboBox
		        comboBox.setModel(comboBoxModelo);
			}
			    public void setcomboBoxPlane(JComboBox<String> comboBoxPlane) {
			        this.comboBoxPlane = comboBoxPlane;
			    }
			    
	public JComboBox<String> getComboBoxPass() {
					if (comboBoxPass == null) {
						comboBoxPass = new JComboBox<String>();
						comboBoxPass.setBounds(41, 81, 118, 22);
						comboBoxPass.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
					}
					return comboBoxPass;
				}
				
	public void llenarComboBoxPassenger(ArrayList<Passenger>arrayLPassenger,JComboBox<String> comboBox) {
		String[] pas = new String[arrayLPassenger.size()];
			for(int i=0; i<arrayLPassenger.size(); i++) {
						pas[i]=arrayLPassenger.get(i).getPassport();
					}
					 // Crea un DefaultComboBoxModel con el array de pasaportes
					comboBoxModelo = new DefaultComboBoxModel<>(pas);
			        // Asigna el DefaultComboBoxModel al JComboBox
			        comboBox.setModel(comboBoxModelo);
				}
				    public void setcomboBoxPassenger(JComboBox<String>comboBoxPass) {
				        this.comboBoxPass = comboBoxPass;
				    }
}