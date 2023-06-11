package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import presentation.GUIUpdateTicket;


public class ControllerUpdateTicket implements ActionListener{

	private GUIUpdateTicket guiUT;
	private FilesXML fXML;
	
	public ControllerUpdateTicket() {
		guiUT = new GUIUpdateTicket();
		fXML= new FilesXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiUT.getBUpdate().addActionListener(this);
		guiUT.getBExit().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiUT.getBUpdate()) {
			try {
				fXML.updateXML("Tickets.xml",guiUT.getTNameTicketUpdate().getText(),"hola");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== guiUT.getBExit()) {
			guiUT.dispose();
		}
	}
}
