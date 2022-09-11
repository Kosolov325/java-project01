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
//		System.out.printf("Digite a lista de números: ");
//		String nums = keyboard.nextLine();
		String nums = "51 98 12 31 09 21 20";
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(nums);
		ArrayList<Object> allGroups = new ArrayList<>();
		ArrayList<Integer> tempGroup = new ArrayList<>();
		ArrayList<Integer> lowestNumbers = new ArrayList<>();
		int tempInteger;
		int size = 1;
		int lowestNumbersSize = 0;
	    String piramide = "";
	    
	    while(m.find()){
	    	tempInteger = Integer.parseInt(m.group());
	    	tempGroup.add(tempInteger);
	    	if (tempGroup.size() == size) {
	    		ArrayList<Integer> nextGroup = (ArrayList)tempGroup.clone();
	    		tempGroup.sort(Comparator.naturalOrder());
	    		lowestNumbers.add(tempGroup.get(0));
	    		lowestNumbersSize += tempGroup.get(0);
	    		tempGroup.clear();
	    		allGroups.add(nextGroup);
	    		piramide += nextGroup + "\n";
	    		size++;
	    	}
	    	
	    }
	   piramide += tempGroup + "\n";
	   tempGroup.sort(Comparator.naturalOrder());
	   lowestNumbers.add(tempGroup.get(0));
	   lowestNumbersSize += tempGroup.get(0);

	   System.out.printf("\n");
	   System.out.printf("Quantidade: " + size + "\n");
	   System.out.printf("String: " + nums + "\n");
	   System.out.printf("Lista: " + allGroups + tempGroup);
	   System.out.printf("\n");
	   System.out.printf("\n");
	   System.out.printf("-----------------------\n");
	   System.out.printf("-- PIRAMIDE --\n");
	   System.out.printf(piramide);
	   System.out.printf("-----------------------\n");
	   System.out.println(allGroups);
	   System.out.printf("Os menores valores são: " + lowestNumbers + "\n");
	   System.out.printf("A soma dos menores valores é: " + lowestNumbersSize);
	 
	   keyboard.close();
	}

}
