package presentation;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Plane;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class GUIComboBox extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	
	private ArrayList<Plane>arrayLP;
	private JComboBox<String> aviones; //Combobox para cargar los lenguajes
    private DefaultComboBoxModel<String> comboBoxModelo; // Se utiliza para almacenar y administrar los elementos de un JComboBox que son de tipo String.
	/**
	 * Create the frame.
	 */
	public GUIComboBox() {
		
		llenarComboBoxAviones(arrayLP,aviones);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		setVisible(true);
	}
	public void llenarComboBoxAviones(ArrayList<Plane>arrayLP,JComboBox<String> comboBox) {
		String[] aviones=new String[arrayLP.size()];
		for(int i=0; i<arrayLP.size(); i++) {
			aviones[i]=arrayLP.get(i).getPlate();
		}
		 // Crea un DefaultComboBoxModel con el array de aviones
		comboBoxModelo = new DefaultComboBoxModel<>(aviones);

        // Asigna el DefaultComboBoxModel al JComboBox
        comboBox.setModel(comboBoxModelo);
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
			comboBox.setBounds(429, 84, 143, 22);
		}
		return comboBox;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(101, 63, 133, 24);
			scrollPane.setViewportView(getComboBox());
		}
		return scrollPane;
	}
	 public JComboBox<String> getAviones() {
	        return aviones;
	    }

	    public void setJclenguajes(JComboBox<String> aviones) {
	        this.aviones = aviones;
	    }
}
