/*Created by Eduardo Henrique Giroto*/
import java.util.ArrayList;

/*----------------------------------------------------
 * Classe Que faz a conversão pra Números IndoArabicos
 * ---------------------------------------------------*/

public class IndoArabico {
	private ArrayList<String> roman = new ArrayList<String>();
	private ArrayList<Integer> indoA = new ArrayList<Integer>();
	private int number;
	
	public IndoArabico() {
		super();
		inicializaVetorRoman();
		inicializaVetorIndoA();
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void inicializaVetorRoman(){
		this.roman.add("I");
		this.roman.add("V");
		this.roman.add("X");
		this.roman.add("L");
		this.roman.add("C");
		this.roman.add("D");
		this.roman.add("M");
		
	}
	
	public void inicializaVetorIndoA(){
		this.indoA.add(1);
		this.indoA.add(5);
		this.indoA.add(10);
		this.indoA.add(50);
		this.indoA.add(100);
		this.indoA.add(500);
		this.indoA.add(1000);
		
	}

	/*A conversão é feita analisando o atual e próximo símbolo da string
	 * Se o próximo simbolo for maior que o atual, então é feita a subtração dos mesmos.*/
	public void conversionForIndo(String str) {
		int leng = str.length();
		this.number=0;
		int g;
		
		/*For que percorre a string contendo o número romano*/
		for(int i=0;i<leng;i++) {
			char c = str.charAt(i);
			
			/*For que percorre o vetor de símbolos Romanos*/
			for(int j=0;j<roman.size();j++) {
				
				/*Se o caracter for igual ao numero romano atual do Vetor*/
				if(c == this.roman.get(j).charAt(0)) {
					
					/*Percorre o vetor para verificar se existe um símbolo maior a direita do caracter atual*/
					for(g=j+1;g<7;g++) {
						
						if(i+1 != leng)
							/*Se existir número maior a direita do caracter atual, faz a subtração e avança*/
							if(str.charAt(i+1)==this.roman.get(g).charAt(0)) {
								this.number+=(this.indoA.get(g)-this.indoA.get(j));
								i++;
								break;
							}
					}
					/*Se não houver número maior a direita, apenas soma o número atual*/
					if(g==7 || this.roman.get(j)=="M")
						this.number+= this.indoA.get(j);
				}
			}
			
		}
	}

}
