/*Created by Eduardo Henrique Giroto*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		
		/*Cria instâncias de número romano e arábico*/
		IndoArabico number2 = new IndoArabico();
		Romanos r = new Romanos();
		
		/*Menu*/
		while(true) {
			System.out.println("Digite 1 para converter um número romano para número indo-arábicos");
			System.out.println("Digite 2 para converter um número indo-arábico para número romano");
			System.out.println("Digite 0 para encerrar");
			
			
			String option = reader.nextLine();
			
			if(option.equals("1")) {
				System.out.println("Digite o número romano: ");
				String number = reader.nextLine();
				number = number.toUpperCase();
				
				/*Se possui algum caracter inválido retorna false*/
				if(checkRoman(number)) {
					number2.conversionForIndo(number);
					String f = Integer.toString(number2.getNumber());
					int size = f.length();
					r.conversionForRoman(size, f);
					if(number.equals(r.getNumber()))
						System.out.println("A conversão é "+number2.getNumber());
					else
						System.out.println("Número inválido");
				}
				else
					System.out.println("Dígitos inválidos");
			}
			else if(option.equals("2")) {
				System.out.println("Digite o número indo-arábico: ");
				String number = reader.nextLine();
				
				/*Se possui algum caracter inválido retorna false*/
				if(checkNumber(number)) {
					int size = number.length();
					r.conversionForRoman(size,number);
					System.out.println("A conversão é: "+r.getNumber());
				}
				else
					System.out.println("Dígitos inválidos");
			}
			else if(!option.equals("0"))
				System.out.println("Opção inválida");
			else
				break;	
		}
		reader.close();
	}
	
	/*Verifica se o número possui caracter inválido*/
	private static boolean checkNumber(String str) {
		int i;
		for(i=0;i<str.length();i++)
			if(str.charAt(i)<48 || str.charAt(i)>57)
				return false;
		if(str.length()>=4)
			if(str.charAt(0)>=52) {
				System.out.println("Só é permitido números até 3999 (Símbolos acima do 3000 não foram especificados.)");
				return false;
			}
				
		return true;
	}
	
	/*Verifica se o número romano possui caracter inválido*/
	private static boolean checkRoman(String str) {
		int i;
		char c;
		for(i=0;i<str.length();i++) {
			if(str.charAt(i)!='I' && str.charAt(i)!='V' && str.charAt(i)!='X' && str.charAt(i)!='L' && str.charAt(i)!='C' && str.charAt(i)!='D' && str.charAt(i)!='M')
				return false;
			c = str.charAt(i);
			if(c=='V' || c=='L' || c=='D') {
				if(i+1!=str.length()) {
					if(str.charAt(i+1)==c) {
						System.out.println("Dois símbolos seguidos que podem ser substituídos! -> "+c+c);
						return false;
					}
				}		
			}else {
				if((i+1) != str.length() && (i+2) != str.length() && (i+3) != str.length()) {
					if(str.charAt(i+1)==c && str.charAt(i+2)==c && str.charAt(i+3)==c) {
						System.out.println("Símbolo só pode ser repetido 3 vezes! -> "+c+c+c);
						return false;
					}
						
				}
			}
		}	
		return true;
	}
}
