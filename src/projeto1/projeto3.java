package projeto1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class projeto3 {
	
	public static void main(String[] args) {
		// 
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Digite a lista de números: ");
		String nums = keyboard.nextLine();
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(nums);
		ArrayList<Object> allgroups = new ArrayList<>();
		ArrayList<Integer> tempgroup = new ArrayList<>();
		ArrayList<Integer> lowestNumbers = new ArrayList<>();
		ArrayList<Integer> finalGroup = new ArrayList<>();
		int tempInteger;
		int size = 1;
		int tempsize = 1;
		int lowestNumbersSize = 0;
		int resultsSize = 0;
		int finalElement = 0;
	    String globalString = "";
	    String piramide = "";
	    while(m.find()){
	    	globalString = globalString + m.group() + " ";
	    	finalElement = Integer.parseInt(m.group());
	    	resultsSize++;
	    }
	    finalGroup.add(finalElement);
	    m.reset();
	    while (m.find()) {
	    	tempInteger = Integer.parseInt(m.group());
	    	tempgroup.add(tempInteger);
	    	if (tempsize == size) {
	    		piramide = piramide + tempgroup + "\n";
	    		ArrayList<Integer> nextgroup = (ArrayList)tempgroup.clone();
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
	   if (resultsSize % 1 == 0 || resultsSize % resultsSize == 0){
		   allgroups.add(finalGroup);
		   lowestNumbers.add(finalElement);
		   lowestNumbersSize += finalElement;
		   piramide = piramide + finalGroup+ "\n";
	   }
	   System.out.printf("\n");
	   System.out.printf("Quantidade: " + resultsSize + "\n");
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
	 
	   keyboard.close();
	}

}
