package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Model;
import presentation.GUIRegisterModel;

public class ControllerRegisterModel implements ActionListener{

	private GUIRegisterModel guiRM;
	private FilesXML fXML;
	private Model model;
	//ArrayListUser<User> arrayLUser;
	
	public ControllerRegisterModel() {
	guiRM= new GUIRegisterModel();
	fXML = new FilesXML();
	model = new Model();
	fXML.createXML("Model", "Models.xml");
	initializer();
	}

	private void initializer() {
		guiRM.getBExit().addActionListener(this);
		guiRM.getBRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	//	System.out.println(guiRA.getArrayListUser().size());
		//guiRA.print(guiRA.getTUser());//pdf
		
		if(e.getSource()== guiRM.getBRegister()) {
			
			model = new Model(guiRM.getTNameModel().getText(),guiRM.getTMarcaModel().getText(),
					Integer.valueOf(guiRM.getTCanMarcaModelEJE().getText()),
					Integer.valueOf(guiRM.getTCanAsientosECO().getText()),
					Integer.valueOf(guiRM.getTCanAsientosTUR().getText()));
			
			guiRM.cleanForm();
			fXML.writeXML("Models.xml","Model",model.getDataName(),model.getData());
			//guiRF.getArrayListFlight().add(flight);
			//guiRA.getDTMTAirline().addRow(air);
			
		}
		if(e.getSource()== guiRM.getBExit()) {
			guiRM.dispose();
			//System.exit(0);
		}
	}

}
