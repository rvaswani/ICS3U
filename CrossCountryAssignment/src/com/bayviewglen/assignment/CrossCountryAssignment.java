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

		// Runner One ... this is represented by the "R1" at the beginning of
		// each variable
		System.out.print("Please enter first and last name here: ");
		String R1name = keyboard.nextLine();
		String R1firstname = R1name.split(" ")[0];
		String R1lastname = R1name.split(" ")[1];

		// Split One ... this is represented by the "One" at the end of each
		// variable
		System.out.print("Please input " + R1firstname + "'s time to the end of the first mile: ");
		String R1timeOne = keyboard.nextLine();

		String R1minutesOne = R1timeOne.split(":")[0];
		double R1minuteNumberOne = Double.parseDouble(R1minutesOne);
		double R1minuteSecondsOne = R1minuteNumberOne * SECONDS_PER_MINUTE;

		String R1secondsOne = R1timeOne.split(":")[1];
		double R1secondsNumberOne = Double.parseDouble(R1secondsOne);
		double R1totalOne = R1secondsNumberOne + R1minuteSecondsOne;

		// Split Two ... this is represented by the "Two" at the end of each
		// variable
		System.out.print("Please input " + R1firstname + "'s time to the end of the second mile: ");
		String R1timeTwo = keyboard.nextLine();

		String R1minutesTwo = R1timeTwo.split(":")[0];
		double R1minuteNumberTwo = Double.parseDouble(R1minutesTwo);
		double R1minuteSecondsTwo = R1minuteNumberTwo * SECONDS_PER_MINUTE;

		String R1secondsTwo = R1timeTwo.split(":")[1];
		double R1secondsNumberTwo = Double.parseDouble(R1secondsTwo);
		double R1totalTwo = R1secondsNumberTwo + R1minuteSecondsTwo;
		double R1finaltotalTwo = R1totalTwo - R1totalOne;
		int R1finalminutesTwo = (int) R1finaltotalTwo / SECONDS_PER_MINUTE;
		double R1finalsecondsTwo = R1finaltotalTwo % SECONDS_PER_MINUTE;

		// Split Three ... this is represented by the "Three" at the end of each
		// variable
		System.out.print("Please input " + R1firstname + " time to complete the 5km: ");
		String R1fivekmtotal = keyboard.nextLine();

		String R1minutesThree = R1fivekmtotal.split(":")[0];
		double R1minuteNumberThree = Double.parseDouble(R1minutesThree);
		double R1minuteSecondsThree = R1minuteNumberThree * SECONDS_PER_MINUTE;

		String R1secondsThree = R1fivekmtotal.split(":")[1];
		double R1secondsNumberThree = Double.parseDouble(R1secondsThree);
		double R1totalThree = R1secondsNumberThree + R1minuteSecondsThree;
		double R1finaltotalThree = R1totalThree - R1totalTwo;
		int R1finalminutesThree = (int) R1finaltotalThree / SECONDS_PER_MINUTE;
		double R1finalsecondsThree = R1finaltotalThree % SECONDS_PER_MINUTE;

		System.out.println();
		System.out.println("Summary:");
		System.out.println("Name: " + R1lastname + ", " + R1firstname);
		System.out.println("Time for split One: " + R1timeOne);
		System.out.println("Time for split Two: " + R1finalminutesTwo + ":" + formatter.format(R1finalsecondsTwo) + ".");
		System.out.println("Time for split Three: " + R1finalminutesThree + ":" + formatter.format(R1finalsecondsThree) + ".");
		System.out.println("The total time is " + R1fivekmtotal);

		System.out.println("_______________________________________________________________________________________________________");
		System.out.println();

		// Runner Two = R2 ... this is represented by the "R2" at the beginning
		// of each variable
		System.out.print("Please enter first and last name here: ");
		String R2name = keyboard.nextLine();
		String R2firstname = R2name.split(" ")[0];
		String R2lastname = R2name.split(" ")[1];

		// Split One ... this is represented by the "One" at the end of each
		// variable
		System.out.print("Please input " + R2firstname + "'s time to the end of the first mile: ");
		String R2timeOne = keyboard.nextLine();

		String R2minutesOne = R2timeOne.split(":")[0];
		double R2minuteNumberOne = Double.parseDouble(R2minutesOne);
		double R2minuteSecondsOne = R2minuteNumberOne * SECONDS_PER_MINUTE;

		String R2secondsOne = R2timeOne.split(":")[1];
		double R2secondsNumberOne = Double.parseDouble(R2secondsOne);
		double R2totalOne = R2secondsNumberOne + R2minuteSecondsOne;

		// Split Two ... this is represented by the "Two" at the end of each
		// variable
		System.out.print("Please input " + R2firstname + "'s time to the end of the second mile: ");
		String R2timeTwo = keyboard.nextLine();

		String R2minutesTwo = R2timeTwo.split(":")[0];
		double R2minuteNumberTwo = Double.parseDouble(R2minutesTwo);
		double R2minuteSecondsTwo = R2minuteNumberTwo * SECONDS_PER_MINUTE;

		String R2secondsTwo = R2timeTwo.split(":")[1];
		double R2secondsNumberTwo = Double.parseDouble(R2secondsTwo);
		double R2totalTwo = R2secondsNumberTwo + R2minuteSecondsTwo;
		double R2finaltotalTwo = R2totalTwo - R2totalOne;
		int R2finalminutesTwo = (int) R2finaltotalTwo / SECONDS_PER_MINUTE;
		double R2finalsecondsTwo = R2finaltotalTwo % SECONDS_PER_MINUTE;

		// Split Three ... this is represented by the "Three" at the end of each
		// variable
		System.out.print("Please input " + R2firstname + " time to complete the 5km: ");
		String R2fivekmtotal = keyboard.nextLine();

		String R2minutesThree = R2fivekmtotal.split(":")[0];
		double R2minuteNumberThree = Double.parseDouble(R2minutesThree);
		double R2minuteSecondsThree = R2minuteNumberThree * SECONDS_PER_MINUTE;

		String R2secondsThree = R2fivekmtotal.split(":")[1];
		double R2secondsNumberThree = Double.parseDouble(R2secondsThree);
		double R2totalThree = R2secondsNumberThree + R2minuteSecondsThree;
		double R2finaltotalThree = R2totalThree - R2totalTwo;
		int R2finalminutesThree = (int) R2finaltotalThree / SECONDS_PER_MINUTE;
		double R2finalsecondsThree = R2finaltotalThree % SECONDS_PER_MINUTE;

		System.out.println();
		System.out.println("Summary:");
		System.out.println("Name: " + R2lastname + ", " + R2firstname);
		System.out.println("Time for split One: " + R2timeOne);
		System.out.println("Time for split Two: " + R2finalminutesTwo + ":" + formatter.format(R2finalsecondsTwo) + ".");
		System.out.println("Time for split Three: " + R2finalminutesThree + ":" + formatter.format(R2finalsecondsThree) + ".");
		System.out.println("The total time is " + R2fivekmtotal);

		System.out.println("___________________________________________________________________________________________________________");
		System.out.println();

		// Runner Three = R3 ... this is represented by the "R1" at the
		// beginning of each variable
		System.out.print("Please enter first and last name here: ");
		String R3name = keyboard.nextLine();
		String R3firstname = R3name.split(" ")[0];
		String R3lastname = R3name.split(" ")[1];

		// Split One ... this is represented by the "One" at the end of each
		// variable
		System.out.print("Please input " + R3firstname + "'s time to the end of the first mile: ");
		String R3timeOne = keyboard.nextLine();

		String R3minutesOne = R3timeOne.split(":")[0];
		double R3minuteNumberOne = Double.parseDouble(R3minutesOne);
		double R3minuteSecondsOne = R3minuteNumberOne * SECONDS_PER_MINUTE;

		String R3secondsOne = R3timeOne.split(":")[1];
		double R3secondsNumberOne = Double.parseDouble(R3secondsOne);
		double R3totalOne = R3secondsNumberOne + R3minuteSecondsOne;

		// Split Two ... this is represented by the "Two" at the end of each
		// variable
		System.out.print("Please input " + R3firstname + "'s time to the end of the second mile: ");
		String R3timeTwo = keyboard.nextLine();

		String R3minutesTwo = R3timeTwo.split(":")[0];
		double R3minuteNumberTwo = Double.parseDouble(R3minutesTwo);
		double R3minuteSecondsTwo = R3minuteNumberTwo * SECONDS_PER_MINUTE;

		String R3secondsTwo = R3timeTwo.split(":")[1];
		double R3secondsNumberTwo = Double.parseDouble(R3secondsTwo);
		double R3totalTwo = R3secondsNumberTwo + R3minuteSecondsTwo;
		double R3finaltotalTwo = R3totalTwo - R3totalOne;
		int R3finalminutesTwo = (int) R3finaltotalTwo / SECONDS_PER_MINUTE;
		double R3finalsecondsTwo = R3finaltotalTwo % SECONDS_PER_MINUTE;

		// Split Three ... this is represented by the "Three" at the end of each
		// variable
		System.out.print("Please input " + R3firstname + " time to complete the 5km: ");
		String R3fivekmtotal = keyboard.nextLine();

		String R3minutesThree = R3fivekmtotal.split(":")[0];
		double R3minuteNumberThree = Double.parseDouble(R3minutesThree);
		double R3minuteSecondsThree = R3minuteNumberThree * SECONDS_PER_MINUTE;

		String R3secondsThree = R3fivekmtotal.split(":")[1];
		double R3secondsNumberThree = Double.parseDouble(R3secondsThree);
		double R3totalThree = R3secondsNumberThree + R3minuteSecondsThree;
		double R3finaltotalThree = R3totalThree - R3totalTwo;
		int R3finalminutesThree = (int) R3finaltotalThree / SECONDS_PER_MINUTE;
		double R3finalsecondsThree = R3finaltotalThree % SECONDS_PER_MINUTE;

		System.out.println();
		System.out.println("Summary:");
		System.out.println("Name: " + R3lastname + ", " + R3firstname);
		System.out.println("Time for split One: " + R3timeOne);
		System.out.println("Time for split Two: " + R3finalminutesTwo + ":" + formatter.format(R3finalsecondsTwo) + ".");
		System.out.println("Time for split Three: " + R3finalminutesThree + ":" + formatter.format(R3finalsecondsThree) + ".");
		System.out.println("The total time is " + R3fivekmtotal);

		System.out.println("___________________________________________________________________________________________________________");
		System.out.println();

		// Runner Four = R4 ... this is represented by the "R1" at the beginning
		// of each variable
		System.out.print("Please enter first and last name here: ");
		String R4name = keyboard.nextLine();
		String R4firstname = R4name.split(" ")[0];
		String R4lastname = R4name.split(" ")[1];

		// Split One ... this is represented by the "One" at the end of each
		// variable
		System.out.print("Please input " + R4firstname + "'s time to the end of the first mile: ");
		String R4timeOne = keyboard.nextLine();

		String R4minutesOne = R4timeOne.split(":")[0];
		double R4minuteNumberOne = Double.parseDouble(R4minutesOne);
		double R4minuteSecondsOne = R4minuteNumberOne * SECONDS_PER_MINUTE;

		String R4secondsOne = R4timeOne.split(":")[1];
		double R4secondsNumberOne = Double.parseDouble(R4secondsOne);
		double R4totalOne = R4secondsNumberOne + R4minuteSecondsOne;

		// Split Two ... this is represented by the "Two" at the end of each
		// variable
		System.out.print("Please input " + R4firstname + "'s time to the end of the second mile: ");
		String R4timeTwo = keyboard.nextLine();

		String R4minutesTwo = R4timeTwo.split(":")[0];
		double R4minuteNumberTwo = Double.parseDouble(R4minutesTwo);
		double R4minuteSecondsTwo = R4minuteNumberTwo * SECONDS_PER_MINUTE;

		String R4secondsTwo = R4timeTwo.split(":")[1];
		double R4secondsNumberTwo = Double.parseDouble(R4secondsTwo);
		double R4totalTwo = R4secondsNumberTwo + R4minuteSecondsTwo;
		double R4finaltotalTwo = R4totalTwo - R4totalOne;
		int R4finalminutesTwo = (int) R4finaltotalTwo / SECONDS_PER_MINUTE;
		double R4finalsecondsTwo = R4finaltotalTwo % SECONDS_PER_MINUTE;

		// Split Three ... this is represented by the "Three" at the end of each
		// variable
		System.out.print("Please input " + R4firstname + " time to complete the 5km: ");
		String R4fivekmtotal = keyboard.nextLine();

		String R4minutesThree = R4fivekmtotal.split(":")[0];
		double R4minuteNumberThree = Double.parseDouble(R4minutesThree);
		double R4minuteSecondsThree = R4minuteNumberThree * SECONDS_PER_MINUTE;

		String R4secondsThree = R4fivekmtotal.split(":")[1];
		double R4secondsNumberThree = Double.parseDouble(R4secondsThree);
		double R4totalThree = R4secondsNumberThree + R4minuteSecondsThree;
		double R4finaltotalThree = R4totalThree - R4totalTwo;
		int R4finalminutesThree = (int) R4finaltotalThree / SECONDS_PER_MINUTE;
		double R4finalsecondsThree = R4finaltotalThree % SECONDS_PER_MINUTE;

		System.out.println();
		System.out.println("Summary:");
		System.out.println("Name: " + R4lastname + ", " + R4firstname);
		System.out.println("Time for split One: " + R4timeOne);
		System.out.println("Time for split Two: " + R4finalminutesTwo + ":" + formatter.format(R4finalsecondsTwo) + ".");
		System.out.println("Time for split Three: " + R4finalminutesThree + ":" + formatter.format(R4finalsecondsThree) + ".");
		System.out.println("The total time is " + R4fivekmtotal);

		System.out.println("___________________________________________________________________________________________________________");
		System.out.println();

		// Runner Five = 5 ... this is represented by the "R1" at the beginning
		// of each variable
		System.out.print("Please enter first and last name here: ");
		String R5name = keyboard.nextLine();
		String R5firstname = R5name.split(" ")[0];
		String R5lastname = R5name.split(" ")[1];

		// Split One ... this is represented by the "One" at the end of each
		// variable
		System.out.print("Please input " + R5firstname + "'s time to the end of the first mile: ");
		String R5timeOne = keyboard.nextLine();

		String R5minutesOne = R5timeOne.split(":")[0];
		double R5minuteNumberOne = Double.parseDouble(R5minutesOne);
		double R5minuteSecondsOne = R5minuteNumberOne * SECONDS_PER_MINUTE;

		String R5secondsOne = R5timeOne.split(":")[1];
		double R5secondsNumberOne = Double.parseDouble(R5secondsOne);
		double R5totalOne = R5secondsNumberOne + R5minuteSecondsOne;

		// Split Two ... this is represented by the "Two" at the end of each
		// variable
		System.out.print("Please input " + R5firstname + "'s time to the end of the second mile: ");
		String R5timeTwo = keyboard.nextLine();

		String R5minutesTwo = R5timeTwo.split(":")[0];
		double R5minuteNumberTwo = Double.parseDouble(R5minutesTwo);
		double R5minuteSecondsTwo = R5minuteNumberTwo * SECONDS_PER_MINUTE;

		String R5secondsTwo = R5timeTwo.split(":")[1];
		double R5secondsNumberTwo = Double.parseDouble(R5secondsTwo);
		double R5totalTwo = R5secondsNumberTwo + R5minuteSecondsTwo;
		double R5finaltotalTwo = R5totalTwo - R5totalOne;
		int R5finalminutesTwo = (int) R5finaltotalTwo / SECONDS_PER_MINUTE;
		double R5finalsecondsTwo = R5finaltotalTwo % SECONDS_PER_MINUTE;

		// Split Three ... this is represented by the "Three" at the end of each
		// variable
		System.out.print("Please input " + R5firstname + " time to complete the 5km: ");
		String R5fivekmtotal = keyboard.nextLine();

		String R5minutesThree = R5fivekmtotal.split(":")[0];
		double R5minuteNumberThree = Double.parseDouble(R5minutesThree);
		double R5minuteSecondsThree = R5minuteNumberThree * SECONDS_PER_MINUTE;

		String R5secondsThree = R5fivekmtotal.split(":")[1];
		double R5secondsNumberThree = Double.parseDouble(R5secondsThree);
		double R5totalThree = R5secondsNumberThree + R5minuteSecondsThree;
		double R5finaltotalThree = R5totalThree - R5totalTwo;
		int R5finalminutesThree = (int) R5finaltotalThree / SECONDS_PER_MINUTE;
		double R5finalsecondsThree = R5finaltotalThree % SECONDS_PER_MINUTE;

		System.out.println();
		System.out.println("Summary:");
		System.out.println("Name: " + R5lastname + ", " + R5firstname);
		System.out.println("Time for split One: " + R5timeOne);
		System.out.println("Time for split Two: " + R5finalminutesTwo + ":" + formatter.format(R5finalsecondsTwo) + ".");
		System.out.println("Time for split Three: " + R5finalminutesThree + ":" + formatter.format(R5finalsecondsThree) + ".");
		System.out.println("The total time is " + R5fivekmtotal);

		System.out.println("___________________________________________________________________________________________________________");
		System.out.println();

		// Creating the Summary Table
		String split1 = "Split One";
		String split2 = "Split Two";
		String split3 = "Split Three";
		String totaltime = "Total Time";
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", "", split1, split2, split3, totaltime); // the
																										// 10
																										// is
																										// the
																										// width,
																										// the
																										// .2
																										// is
																										// the
																										// number
																										// of
																										// decimal
																										// places
																										// the
																										// f
																										// is
																										// float
																										// (double).
		System.out.println("---------------|------------------|----------------|----------------|----------------|");
		String Runner1 = R1name;
		String Runner1splitOne = R1timeOne;
		String Runner1splitTwo = R2finalminutesTwo + ":" + formatter.format(R2finalsecondsTwo);
		String Runner1splitThree = R2finalminutesThree + ":" + formatter.format(R2finalsecondsThree);
		String Runner1total = R1fivekmtotal;
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", Runner1, Runner1splitOne, Runner1splitTwo, Runner1splitThree, Runner1total);
		System.out.println("---------------|------------------|----------------|----------------|----------------|");
		String Runner2 = R2name;
		String Runner2splitOne = R2timeOne;
		String Runner2splitTwo = R2finalminutesTwo + ":" + formatter.format(R2finalsecondsTwo);
		String Runner2splitThree = R2finalminutesThree + ":" + formatter.format(R2finalsecondsThree);
		String Runner2total = R2fivekmtotal;
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", Runner2, Runner2splitOne, Runner2splitTwo, Runner2splitThree, Runner2total);
		System.out.println("---------------|------------------|----------------|----------------|----------------|");
		String Runner3 = R3name;
		String Runner3splitOne = R3timeOne;
		String Runner3splitTwo = R3finalminutesTwo + ":" + formatter.format(R3finalsecondsTwo);
		String Runner3splitThree = R3finalminutesThree + ":" + formatter.format(R3finalsecondsThree);
		String Runner3total = R3fivekmtotal;
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", Runner3, Runner3splitOne, Runner3splitTwo, Runner3splitThree, Runner3total);
		System.out.println("---------------|------------------|----------------|----------------|----------------|");
		String Runner4 = R4name;
		String Runner4splitOne = R4timeOne;
		String Runner4splitTwo = R4finalminutesTwo + ":" + formatter.format(R4finalsecondsTwo);
		String Runner4splitThree = R4finalminutesThree + ":" + formatter.format(R4finalsecondsThree);
		String Runner4total = R4fivekmtotal;
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", Runner4, Runner4splitOne, Runner4splitTwo, Runner4splitThree, Runner4total);
		System.out.println("---------------|------------------|----------------|----------------|----------------|");
		String Runner5 = R5name;
		String Runner5splitOne = R5timeOne;
		String Runner5splitTwo = R5finalminutesTwo + ":" + formatter.format(R5finalsecondsTwo);
		String Runner5splitThree = R5finalminutesThree + ":" + formatter.format(R5finalsecondsThree);
		String Runner5total = R5fivekmtotal;
		System.out.printf("%14s |%17s |%15s |%15s |%15s |\n", Runner5, Runner5splitOne, Runner5splitTwo, Runner5splitThree, Runner5total);
		System.out.println("---------------|------------------|----------------|----------------|----------------|");

	}

}
