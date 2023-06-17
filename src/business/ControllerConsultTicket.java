package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.FilesXML;
import domain.Ticket;
import presentation.GUIConsultTicket;

public class ControllerConsultTicket implements ActionListener{

	private GUIConsultTicket guiCT;
	private Ticket ticket;
	private FilesXML fXML;
	
	public ControllerConsultTicket() {
		guiCT= new GUIConsultTicket();
		fXML = new FilesXML();
		initializer();
	}
	private void initializer() {
		// TODO Auto-generated method stub
		guiCT.getBCheckHistory().addActionListener(this);
		guiCT.getBSearch().addActionListener(this);
		guiCT.getBExit().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guiCT.getBCheckHistory()) {
			//fXML.readXMLString("Tickets.xml","Ticket");
		}
		if(e.getSource()==guiCT.getBSearch()) {
		try {
			fXML.searchXML("Tickets.xml",guiCT.getTConsultNumTicket().getText());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		if(e.getSource()==guiCT.getBExit()) {
			guiCT.dispose();
		}
	}

}
