/*
 * Name: Rishi Vaswani
 * Teacher: Mr. DeLauriers
 * Class: ICS3U-AP-B
 * This is a Blackjack game. You will be asked for your name and your location. The objective is to get a higher hand than the dealer without exceeding 21.
 * 1
 */
package com.bayviewglen.BlackJackFinal;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BlackjackFinal {
    String[] cards;
    int[] values;

    public static void main(String[] args) {
        // These are the scanners and the NumberFormatter used throughout the program.
        Scanner scanner = new Scanner(System.in);
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();

        // This is the start of the game.
        introduction(); // This will display the introduction message.

        String userName = getUserName(scanner);
        while (!userName.equalsIgnoreCase("quit")) {
            int wallet = 500; // The initial amount in the player's wallet is 500.
            boolean done = false;
            NumberFormat formatter = getFormatter(scanner);

            while (!done) {
                wallet = playOneHand(scanner, wallet, formatter);

                done = (wallet == 0 || playAgain(scanner));
            }

            userName = getUserName(scanner);
        }

        closingMessage(); // If the player quits the game, it will display the closing message and close the scanner.
        scanner.close();
    }

    // This method is for formatting the locale the player inputed.
    private static NumberFormat getFormatter(Scanner scanner) {

        return NumberFormat.getCurrencyInstance(getLocale(scanner));
    }

    // This method is for getting the player's Locale.
    private static Locale getLocale(Scanner scanner) {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Location: ");
            System.out.println("1. Canada");
            System.out.println("2. U.S.");
            System.out.println("3. China");
            System.out.println("4. France");
            System.out.println("5. Germany");
            System.out.println("6. Italy");
            System.out.println("7. Japan");
            System.out.println("8. South Korea");
            System.out.println("Please enter your country: ");
            String input = scanner.nextLine();
            int number = 0;
            try {
                number = Integer.parseInt(input);
                if (number == 1) {
                    return Locale.CANADA;
                } else if (number == 2) {
                    return Locale.US;
                } else if (number == 3) {
                    return Locale.CHINA;
                } else if (number == 4) {
                    return Locale.FRANCE;
                } else if (number == 5) {
                    return Locale.GERMANY;
                } else if (number == 6) {
                    return Locale.ITALY;
                } else if (number == 7) {
                    return Locale.JAPAN;
                } else if (number == 8) {
                    return Locale.KOREA;
                } else {
                    System.out.println("Please input a number from one of the options!");
                }
                System.out.println("The option you have chosen is " + number);
                System.out.println();
            } catch (NumberFormatException ex) {
                System.out.println(input + " is not valid.");
            }
        }
        return null;

    }

    // This method is for when the player quits the game.
    private static void closingMessage() {
        System.out.println("Thank you for playing!");
    }

    // This method is for restarting or continuing the game.
    private static boolean playAgain(Scanner scanner) {

        while (true) {
            System.out.println("Would you like to play again?  (Yes or No)");
            String userChoice = scanner.nextLine();

            if (userChoice.equalsIgnoreCase("yes") || userChoice.equalsIgnoreCase("y")) {
                return false;
            } else if (userChoice.equalsIgnoreCase("no") || userChoice.equalsIgnoreCase("n")) {
                return true;
            }
        }

    }

    // This method is to get the cards value and suit
    // It will return a card in the form of 7H for 7 of hearts.
    private static String dealCard() {
        String card = "";
        int num = (int)((Math.random() * 13) + 1);
        if (num == 1) {
            card += "A";
        } else if (num == 11) {
            card += "J";
        } else if (num == 12) {
            card += "Q";
        } else if (num == 13) {
            card += "K";
        } else {
            card += num;
        }

        int suit = (int)((Math.random() * 4) + 1);
        if (suit == 1) {
            card += "S ";
        } else if (suit == 2) {
            card += "H ";
        } else if (suit == 3) {
            card += "D ";
        } else if (suit == 4) {
            card += "C ";
        }

        return card;

    }

    // This method is for playing the game.
    private static int playOneHand(Scanner scanner, int wallet, NumberFormat formatter) {
        int bet = getPlayerBet(scanner, wallet, formatter);

        int numPlayerCards = 0;
        int numDealerCards = 0;
        int numPlayerAces = 0;
        int numDealerAces = 0;
        int playerTotal = 0;
        int dealerTotal = 0;
        String playerHand = ""; // example 7H 5C AS
        String dealerHand = "";

        // give player two cards
        // update the variables above
        String card = dealCard();
        playerHand += "..." + card;
        playerTotal += getValue(card);
        card = dealCard();
        dealerHand += "..." + card;
        dealerTotal += getValue(card);

        // give dealer 1 card and the other card will be represented as "XX".
        // update the variables above this time for the dealer
        card = dealCard();
        playerHand += "..." + card;
        playerTotal += getValue(card);

        boolean playerDone = false;
        boolean doneOnce = false;
        while (!playerDone) {
            // If player hand has an ace and it's total + 10 is less than 21, the value of ace is 11.
            if (!doneOnce && playerHand.contains("A") && playerTotal + 10 <= 21) {
                playerTotal += 10;
            } else if (!doneOnce && dealerHand.contains("A") && dealerTotal + 10 <= 21) {
                dealerTotal += 10;
            }
            // This will give the dealer and player their initial cards.
            System.out.println();
            System.out.println("------------------------------------------------------");
            System.out.println("Dealer: " + dealerHand + "... XX");
            System.out.println("Player: " + playerHand + ".............." + playerTotal);
            System.out.println("------------------------------------------------------");
            System.out.println();

            // If the player gets a total of 21 at first, then they automatically win.
            if (!doneOnce && playerTotal == 21) {
                System.out.println("You Got 21... Congratulations... YOU WIN!!!");
                wallet += (bet);
                System.out.println("Your Money: " + formatter.format(wallet));
                System.out.println();
                break;
            }

            // This is for if the player's bet, times 2, is less than or equal to their wallet or if they haven't already done this section.
            if (!doneOnce && (bet * 2) <= wallet) {

                System.out.println("Please Choose One of The Following:  " + "1. Hit   " + "2. Stand   " + "3. Double Down ");
                String option = scanner.nextLine();
                int x = 0;
                try {
                    x = Integer.parseInt(option);
                } catch (NumberFormatException ex) {
                    System.out.println(" is not valid.");
                }
                // This is for if the player wants to hit.
                if (x == 1) {
                    // This will add another card to the player's hand.
                    card = dealCard();
                    playerHand += "..." + card;
                    playerTotal += getValue(card);
                    // If the player's hand has an ace and it's total is greater than 21, then it will subract 10 from the total.
                    if (playerHand.contains("A") && playerTotal + 10 > 21) {
                        playerTotal -= 10;
                    }
                    if (playerTotal > 21) {
                        System.out.println("------------------------------------------------------");
                        System.out.println("Dealer: " + dealerHand + ".............." + dealerTotal);
                        System.out.println("Player: " + playerHand + ".............." + playerTotal);
                        System.out.println("------------------------------------------------------");
                        System.out.println("You are Bust... Dealer Wins!");
                        wallet -= bet;
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        playerDone = true;
                    }
                    doneOnce = true;

                } else if (x == 2) { // This is for if the player wants to stand.
                    // This adds another card to the dealer.
                    card = dealCard();
                    dealerHand += "..." + card;
                    dealerTotal += getValue(card);
                    // This process will repeat while the dealer's total is less than 17.
                    if (dealerTotal < 17) {
                        do {
                            card = dealCard();
                            dealerHand += "..." + card;
                            dealerTotal += getValue(card);
                        } while (dealerTotal < 17);
                    }
                    // If the dealer's hand contains A, it will subtract 10 to the total.
                    if (dealerHand.contains("A") && dealerTotal + 10 <= 21) {
                        dealerTotal -= 10;
                    }
                    System.out.println("------------------------------------------------------");
                    System.out.println("Dealer: " + dealerHand + ".............." + dealerTotal);
                    System.out.println("Player: " + playerHand + ".............." + playerTotal);
                    System.out.println("------------------------------------------------------");

                    if (dealerTotal > 21) {
                        System.out.println("Dealer is Bust... You win!");
                        wallet += (bet);
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    } else if ((dealerTotal <= 21) && (dealerTotal > playerTotal)) {
                        System.out.println("Dealer wins!!!");
                        wallet -= (bet);
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    } else if ((dealerTotal <= 21) && (dealerTotal < playerTotal)) {
                        System.out.println("Congratulations... YOU WIN!!!");
                        wallet += (bet);
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    } else if (dealerTotal == playerTotal) {
                        System.out.println("It's a draw");
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    }
                    playerDone = true;

                    // This, below, is for if the player wants to double down.
                } else if ((x == 3) && ((bet * 2) <= wallet)) {
                    // This will add another card to the player's hand.
                    card = dealCard();
                    playerHand += "..." + card;
                    playerTotal += getValue(card);

                    if (playerHand.contains("A") && playerTotal + 10 <= 21) {
                        playerTotal += 10;
                    }
                    // This will add another card to the dealer's hand.
                    card = dealCard();
                    dealerHand += "..." + card;
                    dealerTotal += getValue(card);

                    if (dealerHand.contains("A") && dealerTotal + 10 <= 21) {
                        dealerTotal += 10;
                    }
                    if (playerTotal > 21) {
                        System.out.println("------------------------------------------------------");
                        System.out.println("Dealer: " + dealerHand + ".............." + dealerTotal);
                        System.out.println("Player: " + playerHand + ".............." + playerTotal);
                        System.out.println("------------------------------------------------------");
                        System.out.println("You are Bust... Dealer Wins!");
                        wallet -= (bet * 2);
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        playerDone = true;
                        break;
                    }
                    // This process will repeat for as long as the dealer's total is less than 17. 
                    if (dealerTotal < 17) {
                        do {
                            card = dealCard();
                            dealerHand += "..." + card;
                            dealerTotal += getValue(card);
                        } while (dealerTotal < 17);
                    }
                    if (dealerHand.contains("A") && dealerTotal + 10 <= 21) {
                        dealerTotal -= 10;
                    }
                    System.out.println("------------------------------------------------------");
                    System.out.println("Dealer: " + dealerHand + ".............." + dealerTotal);
                    System.out.println("Player: " + playerHand + ".............." + playerTotal);
                    System.out.println("------------------------------------------------------");

                    if (dealerTotal > 21) {
                        System.out.println("Dealer is Bust... You win!");
                        wallet += (bet * 2);
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    } else if ((dealerTotal <= 21) && (dealerTotal > playerTotal)) {
                        System.out.println("Dealer wins!!!");
                        wallet -= (bet * 2);
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    } else if ((dealerTotal <= 21) && (dealerTotal < playerTotal)) {
                        System.out.println("Congratulations... YOU WIN!!!");
                        wallet += (bet * 2);
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    } else if (dealerTotal == playerTotal) {
                        System.out.println("It's a draw");
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    }
                    playerDone = true;
                }

            } else { // The player loses the option to double down if their bet, time 2, is more than their wallet or if they already hit before.
                System.out.println("Please Choose One of The Following:  " + "1. Hit   " + "2. Stand   ");
                String option = scanner.nextLine();
                int x = 0;
                try {
                    x = Integer.parseInt(option);
                } catch (Exception ex) {

                    System.out.println(" is not valid.");
                }
                // This is for if the player wants to hit.
                if (x == 1) {
                    // This will give another card for the player's hand.
                    card = dealCard();
                    playerHand += "..." + card;
                    playerTotal += getValue(card);

                    if (playerHand.contains("A") && playerTotal + 10 <= 21) {
                        playerTotal -= 10;
                    }
                    if (playerTotal > 21) {
                        System.out.println("------------------------------------------------------");
                        System.out.println("Dealer: " + dealerHand + ".............." + dealerTotal);
                        System.out.println("Player: " + playerHand + ".............." + playerTotal);
                        System.out.println("------------------------------------------------------");
                        System.out.println("You are Bust... Dealer Wins!");
                        wallet -= bet;
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        playerDone = true;
                    }

                } else if (x == 2) { // This is for if the player wants to stand.
                    // This will give another card to the player's hand.
                    card = dealCard();
                    dealerHand += "..." + card;
                    dealerTotal += getValue(card);
                    // This process will continue for as long as the dealer's total is less than 17. 
                    if (dealerTotal < 17) {
                        do {
                            card = dealCard();
                            dealerHand += "..." + card;
                            dealerTotal += getValue(card);
                        } while (dealerTotal < 17);
                    }
                    if (dealerHand.contains("A") && dealerTotal + 10 <= 21) { // If the dealer's hand contains an ace, it will add 10 if it doesn't exceed the total of 21.
                        dealerTotal += 10;
                    }
                    System.out.println("------------------------------------------------------");
                    System.out.println("Dealer: " + dealerHand + ".............." + dealerTotal);
                    System.out.println("Player: " + playerHand + ".............." + playerTotal);
                    System.out.println("------------------------------------------------------");

                    if (dealerTotal > 21) {
                        System.out.println("Dealer is Bust... You win!");
                        wallet += bet;
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    } else if ((dealerTotal <= 21) && (dealerTotal > playerTotal)) {
                        System.out.println("Dealer wins!!!");
                        wallet -= bet;
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    } else if ((dealerTotal <= 21) && (dealerTotal < playerTotal)) {
                        System.out.println("Congratulations... YOU WIN!!!");
                        wallet += bet;
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    } else if (dealerTotal == playerTotal) {
                        System.out.println("It's a draw");
                        System.out.println("Your Money: " + formatter.format(wallet));
                        System.out.println();
                        break;
                    }
                    playerDone = true;

                }
            }
        }
        return wallet;
    }

    // This method getting the value of the Royals.
    // This will return the card as AH, which is Ace of Hearts.
    private static int getValue(String card) {
        if (card.contains("A")) {
            return 1;
        } else if (card.contains("J")) {
            return 10;
        } else if (card.contains("K")) {
            return 10;
        } else if (card.contains("Q")) {
            return 10;
        } else {
            return Integer.valueOf(card.substring(0, card.length() - 2));
        }

    }

    // This method is to format the money and to display it.
    private static void display(NumberFormat formatter, int money) {
        System.out.print(formatter.format(money));
    }

    // This method is to get the player's bet.
    private static int getPlayerBet(Scanner scanner, int wallet, NumberFormat formatter) {
        boolean validBet = false;

        while (!validBet) {
            System.out.println();
            System.out.print("Please enter your bet: " + "(The Amount Of Money You Have Is ");
            display(formatter, wallet); // This will format the money
            System.out.print(")");
            System.out.println();
            String amount = scanner.nextLine();
            try {
                int bet = Integer.parseInt(amount);
                if (bet == 0 || bet < 1 || bet > wallet) {
                    System.out.println("Please bet an amount within your budget!");
                } else {
                    return bet;
                }

            } catch (NumberFormatException e) {
                System.out.println(amount + " is not valid.");
            }
        }
        return 0;
    }

    // This method is to get the player's name.
    private static String getUserName(Scanner scanner) {
        boolean validName = false;
        String name = "";
        while (!validName) {
            System.out.println("Please enter your name: ");
            name = scanner.nextLine();
            System.out.println();

            if (!name.equalsIgnoreCase("quit") && !name.equalsIgnoreCase("")) {
                validName = true;
                System.out.println();
            } else if (name.equalsIgnoreCase("quit")) {
                closingMessage(); // This will display the closing message if the player decides to quit the game.
                System.exit(0);

            } else if (name.equals("")) { // If the player inserts a space as their name, it will repeat the question.
                validName = false;
            }
        }
        return name;

    }

    // This method is for displaying the introduction message.
    private static void introduction() {
        System.out.println("Welcome... Good Luck");
        System.out.println();
    }

    // This method is for calculating the score if either the player or the dealer has an ace.
    private static int calculateScore(int currentTotal, int numAces) {
        int score = currentTotal;

        for (int i = 0; i < numAces; ++i) {
            if (score + 10 <= 21)
                score += 10;
        }

        return score;
    }

}