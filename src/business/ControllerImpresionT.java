package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesXML;
import data.Logic;
import domain.Passenger;
import domain.User;
import presentation.GUIImpresionTiquete;

public class ControllerImpresionT implements ActionListener{

	private GUIImpresionTiquete guiIT;
	private FilesXML fXML;
	private Logic lo;
	ArrayList<Passenger>arrayLPassenger;
	public ControllerImpresionT() {
		fXML = new FilesXML();
		lo= new Logic();
		guiIT = new GUIImpresionTiquete();
		//fXML.createXML("TiqutesImpresos", "TiqutesImpresos.xml");
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
			guiIT.getDTMTPassenger().setRowCount(0);
			guiIT.setArrayListPassenger(lo.searchXMLPassenger("Passengers.xml","Passenger", "passport", guiIT.getTDatosPasajero().getText()));
			//guiIT.setArrayListAirline(lo.searchXMLAirline("Airlines.xml", "Airline", "name",guiIT.getTDatosAerolinea().getText()));
			//guiIT.setArrayListPlane(lo.searchXMLPlane("Planes.xml", "Plane", "plate", guiIT.getTDatosAvion().getText()));
			guiIT.fillTable(guiIT.getArrayListPassenger());
			//guiIT.fillTableA(guiIT.getArrayListAirline());
			//guiIT.fillTableP(guiIT.getArrayListPlane());
		}
		if(e.getSource() == guiIT.getBImprimir()) {
			guiIT.print(guiIT.getTPassenger());//pdf
		}

	
	if(e.getSource()==guiIT.getBExit()) {
		guiIT.dispose();
	}
	}

}
