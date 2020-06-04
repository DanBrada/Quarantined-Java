package Testy;

import java.util.Scanner;

/**
 * Moje řešení Testu 2 z VAP
 * @author Daniel Brada
 */
public class Test2 {
	public static void main(String[] args){
		System.out.println(getUserInput("Zadejte číslo, já ho potom vypíšu na obrazovku: "));
		System.out.println(objemKrychle());
		System.out.println(isQuadraticEquasionSolvable()? "Kvadratická rovnice má řešení" : "Kvadratická rovnice nemá řešení");
	}

	public static int getUserInput(String message) {
		System.out.println(message);
		return new Scanner(System.in).nextInt();
	}

	public static double objemKrychle(int hranaA){
		return Math.pow(hranaA,3);
	}

	public static double objemKrychle(){
		System.out.println("Pro výpočet objemu krychle potřebuji napřed délku hrany a");
		return objemKrychle(getUserInput("Zadejte délku hrany a: "));
	}

	/**
	 * Zvládne říct jestli je snad každá jakákoliv kvadratická rocnice řešitelná
	 * @param a ax˘2
	 * @param b bx
	 * @param c c
	 * @return řešitelnost
	 */
	public static boolean isQuadraticEquasionSolvable(double a, double b, double c){
		if(a==0){
			return false; //rovnice není kvadratická -> nemůžeme jí takto řešit
		}
		if(b!=0 && c!= 0){
			return (Math.pow(b, 2) >= (4 * a * c) ); //diskriminant je záporný -> rovnice nemá řešení (v oboru Reálných čísel)
		}else if(b == 0){
			return -c/a >= 0;
		}else{
			return true;
		}
	}

	public static boolean isQuadraticEquasionSolvable(){
		System.out.println("Pro zjištění jestli má daná kvadratická rovnice řešení, potřebujeme zadat koeficienty a,b a c (ax^2+bx+c=0)");
		double a = getUserInput("Zadejte číslo a: ");
		double b = getUserInput("Zadejte číslo b: ");
		double c = getUserInput("Zadejte číslo c: ");
		return isQuadraticEquasionSolvable(a,b,c);
	}
}
