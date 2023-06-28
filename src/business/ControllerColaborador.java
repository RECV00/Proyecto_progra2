package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIColaborador;

public class ControllerColaborador implements ActionListener{
	private GUIColaborador guiC;
	@SuppressWarnings("unused")
	private FilesXML fXML;
	
	public ControllerColaborador() {
		// TODO Auto-generated constructor stub
		guiC= new GUIColaborador();
		fXML= new FilesXML();
		initializer();
	}

	private void initializer() {
		// opciones del menu bar
		
		guiC.getMiiExit().addActionListener(this);
		guiC.getMHelp().addActionListener(this);
		guiC.getMiAboutSystem().addActionListener(this);
		//opciones marcas
				guiC.getMiRegisterBrand().addActionListener(this);
				guiC.getMiConsultBrand().addActionListener(this);
				
				//opciones modelo
				guiC.getMiRegisterModel().addActionListener(this);
				guiC.getMiConsultModel().addActionListener(this);
				
				//aerolinea
				guiC.getMiRegisterAeroline().addActionListener(this);
				guiC.getMiConsultAeroline().addActionListener(this);
				
				//aviones
				guiC.getMiRegisterPlane().addActionListener(this);
				guiC.getMiConsultPlane().addActionListener(this);
				
				//opciones vuelos
				guiC.getMiRegisterFlight().addActionListener(this);
				guiC.getMiConsultFlight().addActionListener(this);
				
				//opciones pasajero
				guiC.getMiRegisterPass().addActionListener(this);
				guiC.getMiConsultPass().addActionListener(this);
				
				//opciones tiquetes
				guiC.getMiRegisterTicket().addActionListener(this);
				guiC.getMiConsultTicket().addActionListener(this);
				
				//impresion
				guiC.getMnImpresionT().addActionListener(this);
				guiC.getMnHistorialT().addActionListener(this);
				guiC.getMnVuelos().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== guiC.getMHelp()) {
			
		}
		//marca
		if(e.getSource() == guiC.getMiRegisterBrand()) {
			new ControllerRegisterBrand();
		}
		if(e.getSource() == guiC.getMiConsultBrand()) {
			new ControllerConsultBrand();
		}
		
		//modelo
		if(e.getSource() == guiC.getMiRegisterModel()) {
			new ControllerRegisterModel();
		}
		if(e.getSource() == guiC.getMiConsultModel()) {
			new ControllerConsultModel();
		}
		
		//aerolinea
		if(e.getSource() == guiC.getMiRegisterAeroline()) {
			new ControllerRegisterAirline();
		}
		if(e.getSource() == guiC.getMiConsultAeroline()) {
			new ControllerConsultAirline();
		}
		
		//vuelos
		if(e.getSource() == guiC.getMiRegisterFlight()) {
			new ControllerRegisterFlight();
		}
		if(e.getSource() == guiC.getMiConsultFlight()) {
			new ControllerConsultFlight();
		}
		
		//aviones
		if(e.getSource() == guiC.getMiRegisterPlane()) {
			new ControllerRegisterPlane();
		}
		if(e.getSource() == guiC.getMiConsultPlane()) {
			new ControllerConsultPlane();
		}
		
		//pasajeros
		if(e.getSource() == guiC.getMiRegisterPass()) {
			new ControllerRegisterPassenger();
		}
		if(e.getSource() == guiC.getMiConsultPass()) {
			new ControllerConsultPassenger();
		}
		
		//tiquetes
		if(e.getSource() == guiC.getMiRegisterTicket()) {
			new ControllerRegisterTicket();
		}
		if(e.getSource() == guiC.getMiConsultTicket()) {
			new ControllerConsultTicket();
		}
		
		//otras opciones
		if(e.getSource() == guiC.getMnImpresionT()) {
			new ControllerImpresionT();
		}
		if(e.getSource() == guiC.getMnHistorialT()) {
			new ControllerHistorialT();
		}
		if(e.getSource() == guiC.getMnVuelos()) {
			new ControllerVuelos();
		}
		if(e.getSource()==guiC.getMiAboutSystem()) {
			guiC.executeHTML1("index.html.html");
		}
		else if(e.getSource()== guiC.getMiiExit()) {
			guiC.dispose();
			new ControllerLogin();
		}
		
		
	}

}
