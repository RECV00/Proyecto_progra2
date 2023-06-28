package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.Logic;
import domain.Passenger;
import presentation.GUIHistorialTiquete;

public class ControllerHistorialT implements ActionListener{
	
	private GUIHistorialTiquete guiHT;
	private FilesXML fXML;
	private Logic lo;
	public ControllerHistorialT() {
		fXML = new FilesXML();
		lo= new Logic();
		guiHT= new GUIHistorialTiquete();
		inicializar();
	}
	public void inicializar() {
		guiHT.getBConsult().addActionListener(this);
		guiHT.getBExit().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiHT.getBConsult()) {
			guiHT.getTaConsultarHTiquete().setText(lo.readXMLStringHTiquete("TiquetesImpresos.xml","TiquetesImpresos"));
		}
		if(e.getSource()==guiHT.getBExit()) {
			guiHT.dispose();
		}
	}
}