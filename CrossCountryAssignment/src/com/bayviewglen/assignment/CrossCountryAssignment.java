/*
 * Name: Rishi Vaswani
 * Teacher: Mr. DeLauriers
 * Class: ICS3U-AP-B
 * This program is a way for the Bayview Glen Cross-Country team to manage their team members running times better
 * We are given the information of the runner's time to the first mile, to the end of the second mile, and to complete the 5km 
 * With the given information, this program will determine the time it took for the runner to complete each split
 * At the end of the program, there will be a summary of the runner's time for each split and total time and it will be displayed in a table
 */
package com.bayviewglen.assignment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountryAssignment {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		final int SECONDS_PER_MINUTE = 60;
		
		DecimalFormat formatter = new DecimalFormat("00.000");
		
		// Runner One is represented by the "r1" at the beginning of
		// each variable
		System.out.print("Please enter the runner's first and last name here: ");
		String r1Name = keyboard.nextLine();
		String r1FirstName = r1Name.split(" ")[0];
		String r1LastName = r1Name.split(" ")[1];

		// Split One is represented by the "One" at the end of each
		// variable
		System.out.print("Please input " + r1FirstName + "'s time to the end of the first mile <mm:ss.sss>: ");
		String r1TimeOne = keyboard.nextLine();

		String r1MinutesOne = r1TimeOne.split(":")[0];
		double r1MinuteNumberOne = Double.parseDouble(r1MinutesOne);
		double r1MinuteSecondsOne = r1MinuteNumberOne * SECONDS_PER_MINUTE;

		String r1SecondsOne = r1TimeOne.split(":")[1];
		double r1SecondsNumberOne = Double.parseDouble(r1SecondsOne);
		double r1TotalOne = r1SecondsNumberOne + r1MinuteSecondsOne;

		// Split Two is represented by the "Two" at the end of each
		// variable
		System.out.print("Please input " + r1FirstName + "'s time to the end of the second mile <mm:ss.sss>: ");
		String r1TimeTwo = keyboard.nextLine();

		String r1MinutesTwo = r1TimeTwo.split(":")[0];
		double r1minuteNumberTwo = Double.parseDouble(r1MinutesTwo);
		double r1MinuteSecondsTwo = r1minuteNumberTwo * SECONDS_PER_MINUTE;

		String r1SecondsTwo = r1TimeTwo.split(":")[1];
		double r1SecondsNumberTwo = Double.parseDouble(r1SecondsTwo);
		double r1TotalTwo = r1SecondsNumberTwo + r1MinuteSecondsTwo;
		double r1FinalFotalTwo = r1TotalTwo - r1TotalOne;
		int r1FinalMinutesTwo = (int) r1FinalFotalTwo / SECONDS_PER_MINUTE;
		double r1FinalSecondsTwo = r1FinalFotalTwo % SECONDS_PER_MINUTE;

		// Split Three is represented by the "Three" at the end of each
		// variable
		System.out.print("Please input " + r1FirstName + "'s time to complete the 5km <mm:ss.sss>: ");
		String r1FivekKmTotal = keyboard.nextLine();

		String r1MinutesThree = r1FivekKmTotal.split(":")[0];
		double r1MinuteNumberThree = Double.parseDouble(r1MinutesThree);
		double r1MinuteSecondsThree = r1MinuteNumberThree * SECONDS_PER_MINUTE;

		String r1SecondsThree = r1FivekKmTotal.split(":")[1];
		double r1SecondsNumberThree = Double.parseDouble(r1SecondsThree);
		double r1TotalThree = r1SecondsNumberThree + r1MinuteSecondsThree;
		double r1FinalTotalThree = r1TotalThree - r1TotalTwo;
		int r1FinalMinutesThree = (int) r1FinalTotalThree / SECONDS_PER_MINUTE;
		double r1FinalSecondsThree = r1FinalTotalThree % SECONDS_PER_MINUTE;

		System.out.println();
		System.out.println("Summary:");
		System.out.println("Name: " + r1LastName + ", " + r1FirstName);
		System.out.println("Time for split One: " + r1TimeOne);
		System.out.println("Time for split Two: " + r1FinalMinutesTwo + ":" + formatter.format(r1FinalSecondsTwo) + ".");
		System.out.println("Time for split Three: " + r1FinalMinutesThree + ":" + formatter.format(r1FinalSecondsThree) + ".");
		System.out.println("The total time is " + r1FivekKmTotal);

		System.out.println("_______________________________________________________________________________________________________");
		System.out.println();

		// Runner Two = R2 is represented by the "r2" at the beginning
		// of each variable
		System.out.print("Please enter the runner's first and last name here: ");
		String r2Name = keyboard.nextLine();
		String r2FirstName = r2Name.split(" ")[0];
		String r2LastName = r2Name.split(" ")[1];

		// Split One is represented by the "One" at the end of each
		// variable
		System.out.print("Please input " + r2FirstName + "'s time to the end of the first mile <mm:ss.sss>: ");
		String r2TimeOne = keyboard.nextLine();

		String r2MinutesOne = r2TimeOne.split(":")[0];
		double r2MinuteNumberOne = Double.parseDouble(r2MinutesOne);
		double r2MinuteSecondsOne = r2MinuteNumberOne * SECONDS_PER_MINUTE;

		String r2SecondsOne = r2TimeOne.split(":")[1];
		double r2SecondsNumberOne = Double.parseDouble(r2SecondsOne);
		double r2totalOne = r2SecondsNumberOne + r2MinuteSecondsOne;

		// Split Two is represented by the "Two" at the end of each
		// variable
		System.out.print("Please input " + r2FirstName + "'s time to the end of the second mile <mm:ss.sss>: ");
		String r2TimeTwo = keyboard.nextLine();

		String r2MinutesTwo = r2TimeTwo.split(":")[0];
		double r2MinuteNumberTwo = Double.parseDouble(r2MinutesTwo);
		double r2MinuteSecondsTwo = r2MinuteNumberTwo * SECONDS_PER_MINUTE;

		String r2SecondsTwo = r2TimeTwo.split(":")[1];
		double r2SecondsNumberTwo = Double.parseDouble(r2SecondsTwo);
		double r2TotalTwo = r2SecondsNumberTwo + r2MinuteSecondsTwo;
		double r2FinalTotalTwo = r2TotalTwo - r2totalOne;
		int r2FinalMinutesTwo = (int) r2FinalTotalTwo / SECONDS_PER_MINUTE;
		double r2FinalSecondsTwo = r2FinalTotalTwo % SECONDS_PER_MINUTE;

		// Split Three is represented by the "Three" at the end of each
		// variable
		System.out.print("Please input " + r2FirstName + "'s time to complete the 5km <mm:ss.sss>: ");
		String r2FiveKmTotal = keyboard.nextLine();

		String r2MinutesThree = r2FiveKmTotal.split(":")[0];
		double r2MinuteNumberThree = Double.parseDouble(r2MinutesThree);
		double r2MinuteSecondsThree = r2MinuteNumberThree * SECONDS_PER_MINUTE;

		String r2SecondsThree = r2FiveKmTotal.split(":")[1];
		double r2SecondsNumberThree = Double.parseDouble(r2SecondsThree);
		double r2TotalThree = r2SecondsNumberThree + r2MinuteSecondsThree;
		double r2FinalTotalThree = r2TotalThree - r2TotalTwo;
		int r2FinalMinutesThree = (int) r2FinalTotalThree / SECONDS_PER_MINUTE;
		double r2FinalSecondsThree = r2FinalTotalThree % SECONDS_PER_MINUTE;

		System.out.println();
		System.out.println("Summary:");
		System.out.println("Name: " + r2LastName + ", " + r2FirstName);
		System.out.println("Time for split One: " + r2TimeOne);
		System.out.println("Time for split Two: " + r2FinalMinutesTwo + ":" + formatter.format(r2FinalSecondsTwo) + ".");
		System.out.println("Time for split Three: " + r2FinalMinutesThree + ":" + formatter.format(r2FinalSecondsThree) + ".");
		System.out.println("The total time is " + r2FiveKmTotal);

		System.out.println("___________________________________________________________________________________________________________");
		System.out.println();

		// Runner Three is represented by the "r3" at the
		// beginning of each variable
		System.out.print("Please enter the runner's first and last name here: ");
		String r3Name = keyboard.nextLine();
		String r3FirstName = r3Name.split(" ")[0];
		String r3LastName = r3Name.split(" ")[1];

		// Split One is represented by the "One" at the end of each
		// variable
		System.out.print("Please input " + r3FirstName + "'s time to the end of the first mile <mm:ss.sss>: ");
		String r3TimeOne = keyboard.nextLine();

		String r3MinutesOne = r3TimeOne.split(":")[0];
		double r3MinuteNumberOne = Double.parseDouble(r3MinutesOne);
		double r3MinuteSecondsOne = r3MinuteNumberOne * SECONDS_PER_MINUTE;

		String r3SecondsOne = r3TimeOne.split(":")[1];
		double r3SecondsNumberOne = Double.parseDouble(r3SecondsOne);
		double r3TotalOne = r3SecondsNumberOne + r3MinuteSecondsOne;

		// Split Two is represented by the "Two" at the end of each
		// variable
		System.out.print("Please input " + r3FirstName + "'s time to the end of the second mile <mm:ss.sss>: ");
		String r3TimeTwo = keyboard.nextLine();

		String r3MinutesTwo = r3TimeTwo.split(":")[0];
		double r3MinuteNumberTwo = Double.parseDouble(r3MinutesTwo);
		double r3minuteSecondsTwo = r3MinuteNumberTwo * SECONDS_PER_MINUTE;

		String r3SecondsTwo = r3TimeTwo.split(":")[1];
		double r3SecondsNumberTwo = Double.parseDouble(r3SecondsTwo);
		double r3TotalTwo = r3SecondsNumberTwo + r3minuteSecondsTwo;
		double r3FinalTotalTwo = r3TotalTwo - r3TotalOne;
		int r3FinalMinutesTwo = (int) r3FinalTotalTwo / SECONDS_PER_MINUTE;
		double r3FinalSecondsTwo = r3FinalTotalTwo % SECONDS_PER_MINUTE;

		// Split Three is represented by the "Three" at the end of each
		// variable
		System.out.print("Please input " + r3FirstName + "'s time to complete the 5km <mm:ss.sss>: ");
		String r3FiveKmTotal = keyboard.nextLine();

		String r3MinutesThree = r3FiveKmTotal.split(":")[0];
		double r3MinuteNumberThree = Double.parseDouble(r3MinutesThree);
		double r3MinuteSecondsThree = r3MinuteNumberThree * SECONDS_PER_MINUTE;

		String r3SecondsThree = r3FiveKmTotal.split(":")[1];
		double r3SecondsNumberThree = Double.parseDouble(r3SecondsThree);
		double r3TotalThree = r3SecondsNumberThree + r3MinuteSecondsThree;
		double r3FinalTotalThree = r3TotalThree - r3TotalTwo;
		int r3FinalMinutesThree = (int) r3FinalTotalThree / SECONDS_PER_MINUTE;
		double r3FinalSecondsThree = r3FinalTotalThree % SECONDS_PER_MINUTE;

		System.out.println();
		System.out.println("Summary:");
		System.out.println("Name: " + r3LastName + ", " + r3FirstName);
		System.out.println("Time for split One: " + r3TimeOne);
		System.out.println("Time for split Two: " + r3FinalMinutesTwo + ":" + formatter.format(r3FinalSecondsTwo) + ".");
		System.out.println("Time for split Three: " + r3FinalMinutesThree + ":" + formatter.format(r3FinalSecondsThree) + ".");
		System.out.println("The total time is " + r3FiveKmTotal);

		System.out.println("___________________________________________________________________________________________________________");
		System.out.println();

		// Runner Four is represented by the "r4" at the beginning
		// of each variable
		System.out.print("Please enter the runner's first and last name here: ");
		String r4Name = keyboard.nextLine();
		String r4FirstName = r4Name.split(" ")[0];
		String r4LastName = r4Name.split(" ")[1];

		// Split One is represented by the "One" at the end of each
		// variable
		System.out.print("Please input " + r4FirstName + "'s time to the end of the first mile <mm:ss.sss>: ");
		String r4TimeOne = keyboard.nextLine();

		String r4MinutesOne = r4TimeOne.split(":")[0];
		double r4MinuteNumberOne = Double.parseDouble(r4MinutesOne);
		double r4MinuteSecondsOne = r4MinuteNumberOne * SECONDS_PER_MINUTE;

		String r4SecondsOne = r4TimeOne.split(":")[1];
		double r4SecondsNumberOne = Double.parseDouble(r4SecondsOne);
		double r4TotalOne = r4SecondsNumberOne + r4MinuteSecondsOne;

		// Split Two is represented by the "Two" at the end of each
		// variable
		System.out.print("Please input " + r4FirstName + "'s time to the end of the second mile <mm:ss.sss>: ");
		String r4TimeTwo = keyboard.nextLine();

		String r4MinutesTwo = r4TimeTwo.split(":")[0];
		double r4MinuteNumberTwo = Double.parseDouble(r4MinutesTwo);
		double r4MinuteSecondsTwo = r4MinuteNumberTwo * SECONDS_PER_MINUTE;

		String r4SecondsTwo = r4TimeTwo.split(":")[1];
		double r4SecondsNumberTwo = Double.parseDouble(r4SecondsTwo);
		double r4TotalTwo = r4SecondsNumberTwo + r4MinuteSecondsTwo;
		double r4FinalTotalTwo = r4TotalTwo - r4TotalOne;
		int r4FinalMinutesTwo = (int) r4FinalTotalTwo / SECONDS_PER_MINUTE;
		double r4FinalSecondsTwo = r4FinalTotalTwo % SECONDS_PER_MINUTE;

		// Split Three is represented by the "Three" at the end of each
		// variable
		System.out.print("Please input " + r4FirstName + "'s time to complete the 5km <mm:ss.sss>: ");
		String r4FiveKmTotal = keyboard.nextLine();

		String r4MinutesThree = r4FiveKmTotal.split(":")[0];
		double r4MinuteNumberThree = Double.parseDouble(r4MinutesThree);
		double r4MinuteSecondsThree = r4MinuteNumberThree * SECONDS_PER_MINUTE;

		String r4SecondsThree = r4FiveKmTotal.split(":")[1];
		double r4SecondsNumberThree = Double.parseDouble(r4SecondsThree);
		double r4TotalThree = r4SecondsNumberThree + r4MinuteSecondsThree;
		double r4FinaltotalThree = r4TotalThree - r4TotalTwo;
		int r4FinalMinutesThree = (int) r4FinaltotalThree / SECONDS_PER_MINUTE;
		double r4FinalSecondsThree = r4FinaltotalThree % SECONDS_PER_MINUTE;

		System.out.println();
		System.out.println("Summary:");
		System.out.println("Name: " + r4LastName + ", " + r4FirstName);
		System.out.println("Time for split One: " + r4TimeOne);
		System.out.println("Time for split Two: " + r4FinalMinutesTwo + ":" + formatter.format(r4FinalSecondsTwo) + ".");
		System.out.println("Time for split Three: " + r4FinalMinutesThree + ":" + formatter.format(r4FinalSecondsThree) + ".");
		System.out.println("The total time is " + r4FiveKmTotal);

		System.out.println("___________________________________________________________________________________________________________");
		System.out.println();

		// Runner Five is represented by the "r5" at the beginning
		// of each variable
		System.out.print("Please enter the runner's first and last name here: ");
		String r5Name = keyboard.nextLine();
		String r5FirstName = r5Name.split(" ")[0];
		String r5LastName = r5Name.split(" ")[1];

		// Split One ... this is represented by the "One" at the end of each
		// variable
		System.out.print("Please input " + r5FirstName + "'s time to the end of the first mile <mm:ss.sss>: ");
		String r5TimeOne = keyboard.nextLine();

		String r5MinutesOne = r5TimeOne.split(":")[0];
		double r5MinuteNumberOne = Double.parseDouble(r5MinutesOne);
		double r5MinuteSecondsOne = r5MinuteNumberOne * SECONDS_PER_MINUTE;

		String r5SecondsOne = r5TimeOne.split(":")[1];
		double r5SecondsNumberOne = Double.parseDouble(r5SecondsOne);
		double r5TotalOne = r5SecondsNumberOne + r5MinuteSecondsOne;

		// Split Two ... this is represented by the "Two" at the end of each
		// variable
		System.out.print("Please input " + r5FirstName + "'s time to the end of the second mile <mm:ss.sss>: ");
		String r5TimeTwo = keyboard.nextLine();

		String r5MinutesTwo = r5TimeTwo.split(":")[0];
		double r5MinuteNumberTwo = Double.parseDouble(r5MinutesTwo);
		double r5MinuteSecondsTwo = r5MinuteNumberTwo * SECONDS_PER_MINUTE;

		String r5SecondsTwo = r5TimeTwo.split(":")[1];
		double r5SecondsNumberTwo = Double.parseDouble(r5SecondsTwo);
		double r5TotalTwo = r5SecondsNumberTwo + r5MinuteSecondsTwo;
		double r5FinalTotalTwo = r5TotalTwo - r5TotalOne;
		int r5FinalMinutesTwo = (int) r5FinalTotalTwo / SECONDS_PER_MINUTE;
		double r5FinalSecondsTwo = r5FinalTotalTwo % SECONDS_PER_MINUTE;

		// Split Three ... this is represented by the "Three" at the end of each
		// variable
		System.out.print("Please input " + r5FirstName + "'s time to complete the 5km <mm:ss.sss>: ");
		String r5FiveKmTotal = keyboard.nextLine();

		String r5MinutesThree = r5FiveKmTotal.split(":")[0];
		double r5MinuteNumberThree = Double.parseDouble(r5MinutesThree);
		double r5MinuteSecondsThree = r5MinuteNumberThree * SECONDS_PER_MINUTE;

		String r5SecondsThree = r5FiveKmTotal.split(":")[1];
		double r5SecondsNumberThree = Double.parseDouble(r5SecondsThree);
		double r5TotalThree = r5SecondsNumberThree + r5MinuteSecondsThree;
		double r5FinalTotalThree = r5TotalThree - r5TotalTwo;
		int r5FinalMinutesThree = (int) r5FinalTotalThree / SECONDS_PER_MINUTE;
		double r5FinalSecondsThree = r5FinalTotalThree % SECONDS_PER_MINUTE;

		System.out.println();
		System.out.println("Summary:");
		System.out.println("Name: " + r5LastName + ", " + r5FirstName);
		System.out.println("Time for split One: " + r5TimeOne);
		System.out.println("Time for split Two: " + r5FinalMinutesTwo + ":" + formatter.format(r5FinalSecondsTwo) + ".");
		System.out.println("Time for split Three: " + r5FinalMinutesThree + ":" + formatter.format(r5FinalSecondsThree) + ".");
		System.out.println("The total time is " + r5FiveKmTotal);

		System.out.println("___________________________________________________________________________________________________________");
		System.out.println();

		// Creating the Summary Table of all five runners
		String split1 = "Split One";
		String split2 = "Split Two";
		String split3 = "Split Three";
		String totaltime = "Total Time";
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", "", split1, split2, split3, totaltime); 
		System.out.println("---------------|------------------|----------------|----------------|----------------|");
		String runner1 = r1Name;
		String runner1SplitOne = r1TimeOne;
		String runner1SplitTwo = r1FinalMinutesTwo + ":" + formatter.format(r2FinalSecondsTwo);
		String runner1SplitThree = r1FinalMinutesThree + ":" + formatter.format(r2FinalSecondsThree);
		String runner1Total = r1FivekKmTotal;
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", runner1, runner1SplitOne, runner1SplitTwo, runner1SplitThree, runner1Total);
		System.out.println("---------------|------------------|----------------|----------------|----------------|");
		String runner2 = r2Name;
		String runner2SplitOne = r2TimeOne;
		String runner2SplitTwo = r2FinalMinutesTwo + ":" + formatter.format(r2FinalSecondsTwo);
		String runner2SplitThree = r2FinalMinutesThree + ":" + formatter.format(r2FinalSecondsThree);
		String runner2Total = r2FiveKmTotal;
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", runner2, runner2SplitOne, runner2SplitTwo, runner2SplitThree, runner2Total);
		System.out.println("---------------|------------------|----------------|----------------|----------------|");
		String runner3 = r3Name;
		String runner3SplitOne = r3TimeOne;
		String runner3SplitTwo = r3FinalMinutesTwo + ":" + formatter.format(r3FinalSecondsTwo);
		String runner3SplitThree = r3FinalMinutesThree + ":" + formatter.format(r3FinalSecondsThree);
		String runner3Total = r3FiveKmTotal;
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", runner3, runner3SplitOne, runner3SplitTwo, runner3SplitThree, runner3Total);
		System.out.println("---------------|------------------|----------------|----------------|----------------|");
		String runner4 = r4Name;
		String runner4SplitOne = r4TimeOne;
		String runner4SplitTwo = r4FinalMinutesTwo + ":" + formatter.format(r4FinalSecondsTwo);
		String runner4SplitThree = r4FinalMinutesThree + ":" + formatter.format(r4FinalSecondsThree);
		String runner4Total = r4FiveKmTotal;
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", runner4, runner4SplitOne, runner4SplitTwo, runner4SplitThree, runner4Total);
		System.out.println("---------------|------------------|----------------|----------------|----------------|");
		String runner5 = r5Name;
		String runner5SplitOne = r5TimeOne;
		String runner5SplitTwo = r5FinalMinutesTwo + ":" + formatter.format(r5FinalSecondsTwo);
		String runner5SplitThree = r5FinalMinutesThree + ":" + formatter.format(r5FinalSecondsThree);
		String runner5Total = r5FiveKmTotal;
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", runner5, runner5SplitOne, runner5SplitTwo, runner5SplitThree, runner5Total);
		System.out.println("---------------|------------------|----------------|----------------|----------------|");

		keyboard.close();
		
	}

}
