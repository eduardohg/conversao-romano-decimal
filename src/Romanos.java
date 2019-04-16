/*Created by Eduardo Henrique Giroto*/

/*-----------------------------------------------
 * Classe Que faz a conversão pra Números Romanos
 * ----------------------------------------------*/

public class Romanos {
	
	private String number;
	
	public String getNumber() {
		return this.number;
	}
	
	/*	A conversão é feita com base em cada algarismo, verificando milhar,
	 * 	centena,dezena e unidade. Para cada um há uma conversão	*/
	public void conversionForRoman(int size, String x) {
		this.number="";
		int i=0;
		int y=size;
		
		while(i<size) {
			char c = x.charAt(i);
			int value = c-48;
			
			if(y==4)
				milhar(value);
			else if(y==3)
				centena(value);
			else if(y==2)
				dezena(value);
			else if(y==1)
				unidade(value);
			
			i++;
			y--;
		}
		
	}
	
	private void milhar(int value) {
		
		switch(value) {
			case 1:
				this.number+="M";
				break;
			case 2:
				this.number+="MM";
				break;
			case 3:
				this.number+="MMM";
				break;
			case 0:
				break;
			default:
				
		}

	}
	
	private void centena(int value) {
		switch(value) {
		case 1:
			this.number+="C";
			break;
		case 2:
			this.number+="CC";
			break;
		case 3:
			this.number+="CCC";
			break;
		case 4:
			this.number+="CD";
			break;
		case 5:
			this.number+="D";
			break;
		case 6:
			this.number+="DC";
			break;
		case 7:
			this.number+="DCC";
			break;
		case 8:
			this.number+="DCCC";
			break;
		case 9:
			this.number+="CM";
			break;
			
		default:
			
		}
	}
	
	private void dezena(int value) {
		switch(value) {
		case 1:
			this.number+="X";
			break;
		case 2:
			this.number+="XX";
			break;
		case 3:
			this.number+="XXX";
			break;
		case 4:
			this.number+="XL";
			break;
		case 5:
			this.number+="L";
			break;
		case 6:
			this.number+="LX";
			break;
		case 7:
			this.number+="LXX";
			break;
		case 8:
			this.number+="LXXX";
			break;
		case 9:
			this.number+="XC";
			break;
			
		default:
			
		}
	}
	
	private void unidade(int value) {
		switch(value) {
		case 1:
			this.number+="I";
			break;
		case 2:
			this.number+="II";
			break;
		case 3:
			this.number+="III";
			break;
		case 4:
			this.number+="IV";
			break;
		case 5:
			this.number+="V";
			break;
		case 6:
			this.number+="VI";
			break;
		case 7:
			this.number+="VII";
			break;
		case 8:
			this.number+="VIII";
			break;
		case 9:
			this.number+="IX";
			break;
			
		default:
			
		}
	}
	
}
