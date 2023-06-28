package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import data.FilesXML;
import data.Logic;
import domain.Airline;
import domain.Passenger;
import domain.Plane;
import domain.User;
import presentation.GUIImpresionTiquete;

public class ControllerImpresionT implements ActionListener{

	private GUIImpresionTiquete guiIT;
	private FilesXML fXML;
	private Logic lo;
	ArrayList<Plane> arrayLP;
	ArrayList<Airline> arrayLA;
	ArrayList<Passenger>arrayLPassenger;
	public ControllerImpresionT() {
		fXML = new FilesXML();
		lo= new Logic();
		arrayLP=lo.getNamePlane("Planes.xml", "Plane");
		arrayLA=lo.getNAirline("Airlines.xml", "Airline");
		arrayLPassenger=lo.getNamePassport("Passengers.xml", "Passenger");
		fXML.createXML("TiquetesImpresos", "TiquetesImpresos.xml");
		guiIT = new GUIImpresionTiquete(arrayLA,arrayLP,arrayLPassenger);
		initializer();
	}
	
	private void initializer() {
		guiIT.getBExit().addActionListener(this);
		guiIT.getBImprimir().addActionListener(this);
		guiIT.getBFiltrar().addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==guiIT.getBFiltrar()) {
			guiIT.getDTMTImpresionTicket().setRowCount(0);
			guiIT.setArrayListPassenger(lo.searchXMLPassenger("Passengers.xml","Passenger", "passport", guiIT.getComboBoxPass().getSelectedItem().toString()));
			guiIT.setArrayListAirline(lo.searchXMLAirline("Airlines.xml", "Airline", "name",guiIT.getComboBoxAirline().getSelectedItem().toString()));
			guiIT.setArrayListPlane(lo.searchXMLPlane("Planes.xml", "Plane", "plate", guiIT.getComboBoxPlane().getSelectedItem().toString()));
			guiIT.fillTable(guiIT.getDTMTImpresionTicket(),guiIT.getArrayListPassenger(),guiIT.getArrayListAirline(),guiIT.getArrayListPlane());
			
		}
		if(e.getSource() == guiIT.getBImprimir()) {
			guiIT.getDTMTImpresionTicket().setRowCount(0);
			guiIT.print(guiIT.getTImpresionTicket());//pdf
			
			try {
				lo.writeTiquetes( "TiquetesImpresos.xml","TiquetesImpresos", guiIT.getArrayListPassenger(), guiIT.getArrayListAirline(), guiIT.getArrayListPlane(),
						String.valueOf(guiIT.numRandom())+"			"+guiIT.horaFecha()+"			"+
						"$" + String.valueOf((Integer.parseInt(guiIT.getTMontoTotal().getText()) + (Integer.parseInt(guiIT.getTMontoTotal().getText()) * 0.13))));
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	
	if(e.getSource()==guiIT.getBExit()) {
		guiIT.dispose();
	}
	}

}