package Ukoly;
import java.util.Random;

public class metody1 {
	public static void main(String[] args){
		//tohle je jenom pro účely testování
		System.out.println(nejvetsiDelitel(40902,24140));
		System.out.println(nejmensiNasobek(40902,24140));
		System.out.println(isPrime(40902));
		System.out.println(isPrime(24140));
		System.out.println(posledniCislice(40902));
		System.out.println(posledniCislice(24140));
	}

	/**
	 * Vypočítá Největší společný dělitel podle <a href="https://cs.wikipedia.org/wiki/Eukleid%C5%AFv_algoritmus">eukleidova algoritmu.</a>
	 * @param u vstupní proměnná U
	 * @param w vstupní proměnná W
	 * @return Největší společný dělitel
	 */
	static int nejvetsiDelitel(int u, int w){
		assert u > 0 && w > 0;
		while(w > 0){
			int r = u%w;
			u = w;
			w = r;
		}
		return u;
	}

	/**
	 * Vypočte nejmenší společný násobek pomocí největšího společného dělitele
	 * @param a vstupní hodnota a
	 * @param b vstupní hodnota b
	 * @return nejmenší společný násobek
	 *
	 */
	static int nejmensiNasobek(int a, int b){
		assert a > 0 && b > 0;
		return (a * b) / nejvetsiDelitel(a,b);
	}

	/**
	 * Vrátí poslední číslici zadaného čísla.
	 * @param a vstupní hodnota
	 * @return poslední číslice
	 */
	static int posledniCislice(int a){
		if(a >= 10 || a <= -10) return a%10;
		else return a; //ensuring we dont have to do unnecessary computations
	}

	/**
	 * geniálně nadesignovanej algoritmus na zjištění jestli je číslo prvočíslo
	 * @param a input
	 * @return jestli je vstup prvočíslo nebo ne
	 */
	static boolean isPrime(int a){
		assert a > 0;
		for(int i=a; i>1;i--){
			if(a%i == 0 && a != i) return false;
		}
		return true;
	}

	/**
	 * Vrátí pole o velikosti n plněné čísly v intervalu od p do q
	 * @param n velikost výstupního pole
	 * @param p dolní hranice hodnot výsledného pole
	 * @param q horní hranice hodnot výsledného pole
	 * @return množina :shrug:
	 */
	static int[] mnozinaVIntervalu(int n, int p, int q){
		int[] navratovka = new int[n];
		for(int i = 0; i<navratovka.length;i++){
			navratovka[i] = new Random().nextInt(Math.abs(q-p)+1)+Math.min(p,q);
		}
		return navratovka;
	}
}
