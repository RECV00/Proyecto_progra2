package business;

public class Logic {

	public Logic() {
		// TODO Auto-generated constructor stub
	}
	
	int getCantExecutiveSeatD(int  cantEje,String seat) {
		if(seat=="Clase Ejecutiva"); 
			return cantEje-1;
	}

	int getCantTouristSeatD(int  cantTour,String seat) {
		if(seat=="Clase Turista"); 
			return cantTour-1;
	}
	int getCantEconomicSeatD(int  cantEco,String seat) {
		if(seat=="Clase Económica"); 
			return cantEco-1;
	}
	
	int getCantExecutiveSeatV(int  cantEje,String seat) {
		int cont=0,asiento=0;
		while(cont>=asiento){
			
			if(seat=="Clase Ejecutiva") {
		
				asiento = cantEje-1;
			}
			cont++;
		}
		return cont;
	}
}

