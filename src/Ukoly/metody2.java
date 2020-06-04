package Ukoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class metody2 {
	public static void main(String[] args){
		int[] testPole = {1, 21 ,42, 86, 32 ,54, 79, 256 ,8 ,7, 65, 15, 36};

		System.out.println(Arrays.toString(seradPole(testPole.clone()))); //nechci aby mi to hrabalo do mýho krásnýho pole, bo java
		System.out.println(aritmetickyPrumer(testPole));
		System.out.println(geometrickyPrumer(testPole));
		System.out.println(harmonickyPrumer(testPole));
		System.out.println(Arrays.toString(mnozinaDelitelu(testPole[testPole.length - 1])));
	}

	static int[] seradPole(int[] input){ //bubble sort implementace
		boolean isSorted;
		System.out.printf("Start:                                %s%n",Arrays.toString(input));
		do{
			isSorted = true; //"innocent until proven guilty"
			int operations = 0;
			for(int i=0; i<input.length;++i){
				int a = input[i];
				int b=0;
				if(i+1 != input.length) b = input[i+1];
				else break; //posledí prvek => break protože už nemam s čim porovnávat

				if(b<a){
					input[i] = b;
					input[i+1] = a;
					++operations;
					isSorted = false;
				}
			}
			System.out.printf("V tomhle cyklu jsem provedl %d operací %s%n", operations, Arrays.toString(input));
		}while(!isSorted);
		return input;
	}

	static double aritmetickyPrumer(int[] input){
		int soucet = 0, mnozstvi = input.length;
		for(int x: input) soucet += x;
		return (double)soucet/mnozstvi;
	}

	static double geometrickyPrumer(int[] input){
		int soucin = input[0];
		for(int i=1;i<input.length;++i)	soucin*=input[i];
		return Math.pow(soucin,(double)1/input.length);
	}

	static double harmonickyPrumer(int[] input){
		double soucet = 0;
		for(int x: input) soucet += x;
		return input.length/soucet;
	}

	static int[] mnozinaDelitelu(int a){
		List<Integer> outList = new ArrayList<>();
		for(int i = a;i>0;--i) if(a%i==0) outList.add(i);
		int[] output = new int[outList.size()]; //protože nevim kolik je třeba prvků tak si udělam list a ten pak převedu na pole :)
		for(int i = 0;i < output.length;i++)
			output[i] = outList.get(i);
		return output;
	}
}
