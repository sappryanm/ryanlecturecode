package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalc {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Wall> wallList = new ArrayList<Wall>();
		
		while(true) {
			
			System.out.println();
			System.out.println("[1] Add a wall");
			System.out.println("[2] Calculate paint required (and Exit)");
			System.out.print("Please choose >>> ");
			String userChoice = scan.nextLine();
			
			System.out.println();
			
			if(userChoice.equals("1")) {
				
				System.out.print("Enter wall height >>> ");
				int height = Integer.parseInt(scan.nextLine());
				System.out.print("Enter wall width >>> ");
				int width = Integer.parseInt(scan.nextLine());
				
				Wall wall = new Wall(width, height);
				System.out.println("Wall: " + wall.getWidth() + "x" + wall.getHeight() + " - " + wall.getArea() + " square feet");
				wallList.add(wall);
				
			} else if(userChoice.equals("2")) {
				
				// Here we need to sum up the areas of all walls that have been entered
				int index = 1;
				int totalArea = 0;
				for (Wall wallItem : wallList) {
					System.out.println("Wall " + index++ + ": " + wallItem.getWidth() + "x" + wallItem.getHeight() + " - " + wallItem.getArea() + " square feet");
					totalArea += wallItem.getArea();
				}

				System.out.println("===============================");
				System.out.println("Total Area: "+totalArea+" square feet");
				
				// 1 gallon of paint covers 400 square feet
				float gallonsRequired = (float)totalArea / 400;
				System.out.println("Paint Required: "+gallonsRequired+" gallons");
				
				System.exit(0); // Causes the program to end
			}
		}
	}
}
