package projeto1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class projeto3 {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Digite a lista de números: ");
		String nums = keyboard.nextLine();
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(nums);
		ArrayList<Object> allgroups = new ArrayList<>();
		ArrayList<Integer> tempgroup = new ArrayList<>();
		ArrayList<Integer> lowestNumbers = new ArrayList<>();
		int tempInteger;
		int size = 1;
		int tempsize = 1;
		int globalSize = 1;
		int lowestNumbersSize = 0;
	    String globalString = "";
	    String piramide = "";
	    while (m.find()) { 
	    	globalString = globalString + m.group() + " ";
	    	tempInteger = Integer.parseInt(m.group());
	    	tempgroup.add(tempInteger);
	    	if (tempsize == size) {
	    		globalSize += tempgroup.size();
	    		piramide = piramide + tempgroup + "\n";
	    		ArrayList<Integer> nextgroup = (ArrayList<Integer>)tempgroup.clone();
	    		tempgroup.sort(Comparator.naturalOrder());
	    		lowestNumbers.add(tempgroup.get(0));
	    		lowestNumbersSize += tempgroup.get(0);
	    		tempgroup.clear();
	    		allgroups.add(nextgroup);
	    		size++;
	    		tempsize = 0;
	    	}
	    	tempsize++;
	    }
	   System.out.printf("\n");
	   System.out.printf("Quantidade: " + globalSize + "\n");
	   System.out.printf("String: " + globalString + "\n");
	   System.out.printf("Lista: " + allgroups);
	   System.out.printf("\n");
	   System.out.printf("\n");
	   System.out.printf("-----------------------\n");
	   System.out.printf("-- PIRAMIDE --\n");
	   System.out.printf(piramide);
	   System.out.printf("-----------------------\n");
	   System.out.println(allgroups);
	   System.out.printf("Os menores valores são: " + lowestNumbers + "\n");
	   System.out.printf("A soma dos menores valores é: " + lowestNumbersSize);
	 
	
	}

}
