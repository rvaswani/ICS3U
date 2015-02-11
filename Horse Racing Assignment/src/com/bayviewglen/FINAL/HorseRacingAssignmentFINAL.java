package com.bayviewglen.FINAL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.Scanner;

public class HorseRacingAssignmentFINAL {

	private static String[] raceHorses;
	private static int numberHorses;
	private static int userChoice;
	private static int wallet;
	private static int horseChoice;
	private static int numPlayers;
	private static String money;
	private static String[] players;

	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
		Scanner scanner = new Scanner(System.in);
		NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();

		// This is the start of the game.
		introduction(); // This will display the introduction message.
		boolean done = false;
		String[] players = displayPlayers(scanner); // This method will display the 5 players
		
		while (!done) {
			String[] horses = getHorses(scanner); // This method will scan all 86 horses from the file
			String[] racers = getHorseInRace(horses); // This method will display the random number of horses in the race

			int playerBet = getBet(scanner, moneyFormatter); // This method will collect the player's bet
			int game = playGame(racers); // This method is where the game is ran
			String winner = gameWinner(game, wallet, playerBet); // This method will determine which horse has won and if the player's horse won
			
			// If the player's wallet is 0, then the game will end
			if (wallet == 0) {
				done = true;
				break;
			}
			done = playAgain(scanner);
		}

		closingMessage(); // If the player quits the game or the wallet is 0, it will display the closing message and then close the scanner
		scanner.close();
	}

	// This method is used to save the games data to the file
	private static void saveToFile(int[] wallets) throws UnsupportedEncodingException {
		try {
			PrintWriter writer = new PrintWriter("input/gamePlayerData.dat"); // This is the file where the data will be saved onto
			writer.println(numPlayers);
			for (int i = 0; i < numPlayers; i++) {
				writer.println(players[i]);
				// If the userChoice is the same as the horse being selected, then it will display the updated wallet
				if (userChoice == i) {
					writer.print("Updated wallet for " + players[i] + " = $" + wallet + "\n");
				}
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This method will display whether the player's selected horse has won or not
	private static String gameWinner(int j, int wallet2, int playerBet) {
		if (horseChoice == j) {
			System.out.println("Congratulations... Your horse has won!\n");
			wallet += playerBet;
		} else if (horseChoice != j) {
			System.out.println("You have lost... better luck next time!\n");
			wallet -= playerBet;
		} else {
			System.out.println("You have lost... better luck next time!\n");
			wallet -= playerBet;
		}
		return null;
	}

	// This method will prompt the user for the horse and for whether the player wants to bet, stay, or quit
	private static int getBet(Scanner scanner, NumberFormat moneyFormatter) throws InterruptedException, UnsupportedEncodingException {
		boolean validBet = false;

		while (!validBet) {

			System.out.println("\nWhich horse would you like to bet? (Please input the horse number) - If you would like a random horse, please enter \"0\"");
			String betChoice = scanner.nextLine();
			try {
				horseChoice = Integer.parseInt(betChoice);
				if (horseChoice > numberHorses) {
					System.out.println("Your choice is invalid.");
				}
				if (horseChoice == 0) {
					horseChoice = (int) (Math.random() * (numberHorses - 1)) + 1;
					System.out.println("Your randomly selected horse is " + raceHorses[horseChoice] + "\n");
					break;
				} else if (horseChoice < numberHorses && horseChoice > 0) {
					System.out.println("The horse you have chosen: " + raceHorses[horseChoice] + "\n");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Please choose one of the provided options. " + "\n");
			}
		}
		boolean secondBet = false;
		while (!secondBet) {
			System.out.println("Please choose on of the following:  1. Bet    2. Play: (ALL-IN)    3. Quit and Save Data to File");
			String input = scanner.nextLine();
			try {
				int userInput = Integer.parseInt(input);
				int bet = 0;
				if (userInput == 1) {
					System.out.println();
					boolean betting = false;
					while (!betting) {
						System.out.print("Please enter your bet: " + "(The Amount of Money You Have is ");
						display(moneyFormatter, wallet); // This will format the money
						System.out.print(")");
						System.out.println();
						String amount = scanner.nextLine();
						try {
							bet = Integer.parseInt(amount);
							if (bet == 0 || bet < 1 || bet > wallet) {
								System.out.println("Please bet an amount within your budget!\n");
								break;
							} else {
								return bet;
							}

						} catch (NumberFormatException e) {
							System.out.println(amount + " is not valid.");
						}
					}
				} else if (userInput == 2) {
					break;
				} else if (userInput == 3) {
					saveToFile(null);
					closingMessage(); // This will display the closing message if the player decides to quit the game.

				}
			} catch (NumberFormatException e) {
				System.out.println("Please choose one of the provided options.\n");
			}
		}
		return wallet;
	}

	// This method will simulate the horse race
	private static int playGame(String[] racers) throws InterruptedException {

		int[] horsePosition = new int[numberHorses];

		while (!raceOver(horsePosition)) {
			Thread.sleep(200);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
			for (int k = 1; k < numberHorses; k++) {
				System.out.println("---------------------|--------------------------------------------------------------------------------------|");

				System.out.printf("%20s |", raceHorses[k]);
				// the spaces 
				if (!(horsePosition[k] > 86)) {
					horsePosition[k] += (int) (Math.random() * 3);
				}
				if (horsePosition[k] == (86 - 1)) {
					horsePosition[k]++;
				} else if (horsePosition[k] == (86 - 2)) {
					horsePosition[k] = horsePosition[k] + 2;
				} else if (horsePosition[k] == (86 - 3)) {
					horsePosition[k] = horsePosition[k] + 3;
				}

				for (int i = 0; i < horsePosition[k]; ++i) {
					System.out.print(" ");
				}
				// the horse
				System.out.printf("%1s\n", k);
				System.out.println("---------------------|--------------------------------------------------------------------------------------|");

			}
			for (int j = 1; j < numberHorses; j++) {
				if (horsePosition[j] == 86) {
					System.out.println();
					System.out.println("The winner of the race is " + raceHorses[j] + "\n");
					return j;
				}
			}

		}
		return (Integer) null;
	}

	// This method is to end the game once one of the racing horses reach to position 86
	private static boolean raceOver(int[] horsePosition) {
		for (int pos : horsePosition) {
			if (pos == 86 & !(pos > 86))
				return true;
		}
		return false;
	}

	// This method is to display the 5 players which the user can choose
	private static String[] displayPlayers(Scanner scanner) {
		players = null;
		try {
			Scanner scanner2 = new Scanner(new File("input/playerData.dat"));
			numPlayers = Integer.parseInt(scanner2.nextLine());
			players = new String[numPlayers];

			System.out.println("  #| Player Names| Wallet |");
			for (int i = 0; i < numPlayers; i++) {
				String x = players[i] = scanner2.nextLine();
				money = x.split(" ")[1];
				String player = x.split(" ")[0];
				System.out.println("---|-------------|--------|");
				System.out.printf("%2s |%10s   | %7s| \n", i + 1, player, money);
				System.out.println("---|-------------|--------|");

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		boolean done = false;
		while (!done) {
			System.out.println("\nPlease choose a disney character:" + "  -->  If you would like a random character, please enter \"0\"");
			String userPlayer = scanner.nextLine();
			try {
				userChoice = Integer.parseInt(userPlayer);
				System.out.println();
				if (userChoice == 0) {
					userChoice = (int) ((Math.random() * 5) + 1);
				}
				if (userChoice == 1 || userPlayer.equalsIgnoreCase("Winnie")) {
					System.out.println("You have chosen: Winnie \n");
					wallet = 800;
					break;
				} else if (userChoice == 2 || userPlayer.equalsIgnoreCase("Goofy")) {
					System.out.println("You have chosen: Goofy \n");
					wallet = 1000;
					break;
				} else if (userChoice == 3 || userPlayer.equalsIgnoreCase("Mickey")) {
					System.out.println("You have chosen: Mickey \n");
					wallet = 2500;
					break;
				} else if (userChoice == 4 || userPlayer.equalsIgnoreCase("Nemo")) {
					System.out.println("You have chosen: Nemo \n");
					wallet = 500;
					break;
				} else if (userChoice == 5 || userPlayer.equalsIgnoreCase("Elsa")) {
					System.out.println("You have chosen: Elsa \n");
					wallet = 650;
					break;
				}
			} catch (NumberFormatException ex) {
				System.out.println(userPlayer + " is not valid.");
			}
		}

		return players;
	}

	// This method is to display the random number of horses which the user can bet on 
	public static String[] getHorseInRace(String[] horses) {
		// get a number from 4 - 8
		// create the array to hold the horses in the race (5 - 8)
		// loop 5 - 8 times to choose a random index in the horses array
		//    add this index to the new array 
		//    make sure the index is not already in the new array - use the search method we wrote
		// ---------------------------------

		// You now have the horses in the trace
		/*
		 * This is displaying the random number of horses.
		 */
		numberHorses = (int) ((Math.random() * 4) + 5);
		raceHorses = new String[numberHorses];
		int i = 0;
		while (i < numberHorses) {
			int x = (int) (Math.random() * 86);
			{
				alreadyInRace(null, horses);
				raceHorses[i] = horses[x];
				i++;
			}
		}

		for (int k = 1; k < numberHorses; k++) {
			System.out.println("---------------------|--------------------------------------------------------------------------------------|");
			System.out.printf("%20s |%1s \n", raceHorses[k], k);
			System.out.println("---------------------|--------------------------------------------------------------------------------------|");
		}

		return raceHorses;
	}

	// This method will retreive all the 86 horses from the horseData file
	public static String[] getHorses(Scanner scanner2) {
		String[] horses = null;

		try {
			Scanner scanner = new Scanner(new File("input/horseData.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];

			for (int i = 0; i < numHorses; i++) {
				horses[i] = scanner.nextLine();

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return horses;
	}

	
	// This method checks if a horse is already in the race - uses a modified search method	 
	public static boolean alreadyInRace(String horses, String[] horsesInRace) {

		for (int i = 0; i < horsesInRace.length; i++) {
			if (horsesInRace[i].equalsIgnoreCase(horses)) {
				return true;
			}
		}

		return false;
	}

	// This method is to format the money to add its currency
	private static void display(NumberFormat formatter, int money) {
		System.out.print(formatter.format(money));
	}

	// This method is to prompt the user on whether or not they would like to play the game again
	private static boolean playAgain(Scanner scanner) {
		while (true) {
			System.out.println("Would you like to play again?  (Yes or No)");
			String userChoice = scanner.nextLine();
			try {
				if (userChoice.equalsIgnoreCase("yes") || userChoice.equalsIgnoreCase("y")) {
					return false;
				} else if (userChoice.equalsIgnoreCase("no") || userChoice.equalsIgnoreCase("n")) {
					return true;
				}
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	// If the user chooses to quit or their players wallet is 0, then the closing message will be displayed
	private static void closingMessage() throws UnsupportedEncodingException {
		if (wallet == 0) {
			System.out.print("You are out of money!... ");
		}
		System.out.println("Thank you for playing!\n");
		saveToFile(null);
		System.exit(0);
	}

	// This is the first method and will display the introduction message
	private static void introduction() {
		System.out.println("Welcome to the Racetrack:");
		System.out.println();
	}
}