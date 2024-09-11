public class oldPoker {
    class Main {
        public static void main(String[] args) {
            System.out.println("Hello world!");
        }
    
        public static void poker() { // method to play poker
            whyisthisbroken = true;
            int noDebt = 0; // makes sure you do not bring more than you have
            double pokerChoice = 0; // choice of events
            double pot = 0; // total pot between you and the house
            double wager = 0; // amount player has brought to the table
            while (noDebt == 0) {
                System.out.println("enter the amount you would like to bring to the table");
                wager = in.nextInt(); // amount on table
                if (wager > netWorth) {
                    System.out.println("you can not bring more than you have!");
                } else {
                    noDebt = 1;
                }
            }
            if (ageStats < 18) {
                System.out.println("Hey! you cant gamble unless you are 18 or older!");
                return;
            }
            netWorth = netWorth - wager; // takes wager from networth
            int playerCard1 = (int) (52 * Math.random() + 1); // generates player card 1
            int playerCard2 = (int) (52 * Math.random() + 1); // generates player card 2
            int houseCard1 = (int) (52 * Math.random() + 1); // generates house card 1
            int houseCard2 = (int) (52 * Math.random() + 1); // generates house card 2
            int[] player = new int[7]; // array of all players cards
            int[] house = new int[7]; // array of all house cards
            int[] blacklist = new int[9]; // array of all total cards to removes dupe
            player[1] = playerCard1; // inserts value into array
            player[2] = playerCard2; // inserts value into array
            house[1] = houseCard1; // inserts value into array
            house[2] = houseCard2; // inserts value into array
            blacklist[1] = playerCard1; // inserts value into array
            blacklist[2] = playerCard2; // inserts value into array
            blacklist[3] = houseCard1; // inserts value into array
            blacklist[4] = houseCard2; // inserts value into array
            blacklist = dupeCheck(blacklist); // checks and changes duplicate cards
            playerCard1 = blacklist[1];
            player[1] = playerCard1;
            playerCard2 = blacklist[2];
            player[2] = playerCard2;
            houseCard1 = blacklist[3];
            house[1] = houseCard1;
            houseCard2 = blacklist[4];
            house[2] = houseCard1;
            System.out.println("Your cards are " + cardReader(playerCard1) + " and " + cardReader(playerCard2)); // shows
                                                                                                                 // user
                                                                                                                 // their
                                                                                                                 // cards
            while (pokerChoice == 0) {
                System.out.println(
                        "***************CHOOSE A NUMBER BETWEEN ONE AND THREE***************\n1. Raise 2. Call 3. Fold");
                switch (in.nextInt()) { // takes user input for a choice
                    case 1:
                        pokerChoice = 1;
                        break;
                    case 2:
                        pokerChoice = 2;
                        break;
                    case 3:
                        System.out.println("You folded and lost " + pot / 2 + " :(\nThe house had " + cardReader(houseCard1)
                                + " and " + cardReader(houseCard2));
                        netWorth = netWorth + wager;
                        return;
                    default:
                        System.out.println("Please insert a valid number!");
                }
            }
            Double choiceResult = (pokerDecision(pokerChoice, wager)); // runs a method to see how much money was put into
                                                                       // the pot
            pot = choiceResult + pot; // adds sum to the pot
            wager = wager - choiceResult; // subtracts amount raised from the amount brought to the table
            System.out.println("The amount in the pot is " + pot);
            if (choiceResult == 0) {
                System.out.println("The house also calls");
            } else {
                System.out.println("The house matches your raise, the new pot is " + (choiceResult + pot));
                pot = choiceResult + pot; // the house matches your raise and adds to the pot
            }
            int commonCard1 = (int) (52 * Math.random() + 1); // creates 1st common card
            int commonCard2 = (int) (52 * Math.random() + 1); // creates 2nd common card
            int commonCard3 = (int) (52 * Math.random() + 1); // creates 3rd common card
            player[3] = commonCard1; // inserts value into array
            house[3] = commonCard1; // inserts value into array
            blacklist[5] = commonCard1; // inserts value into array
            player[4] = commonCard2; // inserts value into array
            house[4] = commonCard2; // inserts value into array
            blacklist[6] = commonCard2; // inserts value into array
            player[5] = commonCard3; // inserts value into array
            house[5] = commonCard3; // inserts value into array
            blacklist[7] = commonCard3; // inserts value into array
            blacklist = dupeCheck(blacklist); // checks and fixes dupe cards
            commonCard1 = blacklist[5];
            player[3] = commonCard1;
            house[3] = commonCard1;
            commonCard2 = blacklist[6];
            player[4] = commonCard2;
            house[4] = commonCard2;
            commonCard3 = blacklist[7];
            player[5] = commonCard3;
            house[5] = commonCard3;
            System.out.println("The first three cards have been revealed, they are: " + cardReader(commonCard1) + ", "
                    + cardReader(commonCard2) + " and " + cardReader(commonCard3));
            pokerChoice = 0; // resets choice value so user can make a new choice
            while (pokerChoice == 0) {
                System.out.println(
                        "***************CHOOSE A NUMBER BETWEEN ONE AND THREE***************\n1. Raise 2. Call 3. Fold");
                switch (in.nextInt()) {
                    case 1:
                        pokerChoice = 1;
                        break;
                    case 2:
                        pokerChoice = 2;
                        break;
                    case 3:
                        System.out.println("You folded and lost " + pot + " :(\nThe house had " + cardReader(houseCard1)
                                + " and " + cardReader(houseCard2));
                        netWorth = netWorth - pot;
                        return;
                    default:
                        System.out.println("Please insert a valid number!");
                }
            }
            choiceResult = (pokerDecision(pokerChoice, wager));
            pot = choiceResult + pot;
            wager = wager - choiceResult;
            System.out.println("The amount in the pot is " + pot);
            if (choiceResult == 0) {
                System.out.println("The house also calls");
            } else {
                System.out.println("The house matches your raise, the new pot is " + (choiceResult + pot));
                pot = choiceResult + pot;
            }
            int commonCard4 = (int) (52 * Math.random() + 1); // get 4th common card
            player[6] = commonCard4;
            house[6] = commonCard4;
            blacklist[8] = commonCard4;
            dupeCheck(blacklist);
            System.out.println("The fourth card has been revealed, it is a " + cardReader(commonCard4));
            pokerChoice = 0;
            while (pokerChoice == 0) {
                System.out.println(
                        "***************CHOOSE A NUMBER BETWEEN ONE AND THREE***************\n1. Raise 2. Call 3. Fold");
                switch (in.nextInt()) {
                    case 1:
                        pokerChoice = 1;
                        break;
                    case 2:
                        pokerChoice = 2;
                        break;
                    case 3:
                        System.out.println("You folded and lost " + pot + " :(\nThe house had " + cardReader(houseCard1)
                                + " and " + cardReader(houseCard2));
                        netWorth = netWorth - pot;
                        return;
                    default:
                        System.out.println("Please insert a valid number!");
                }
            }
            choiceResult = (pokerDecision(pokerChoice, wager));
            pot = choiceResult + pot;
            wager = wager - choiceResult;
            System.out.println("The amount in the pot is " + pot);
            if (choiceResult == 0) {
                System.out.println("The house also calls");
            } else {
                System.out.println("The house matches your raise, the new pot is " + (choiceResult + pot));
                pot = choiceResult + pot;
            }
            int commonCard5 = (int) (52 * Math.random() + 1); // get 5th common card
            player[7] = commonCard5;
            house[7] = commonCard5;
            blacklist[9] = commonCard5;
            dupeCheck(blacklist);
            System.out.println("The fifth card has been revealed, it is a " + cardReader(commonCard4));
            pokerChoice = 0;
            while (pokerChoice == 0) {
                System.out.println(
                        "***************CHOOSE A NUMBER BETWEEN ONE AND THREE***************\n1. Raise 2. Call 3. Fold");
                switch (in.nextInt()) {
                    case 1:
                        pokerChoice = 1;
                        break;
                    case 2:
                        pokerChoice = 2;
                        break;
                    case 3:
                        System.out.println("You folded and lost " + pot + " :(\nThe house had " + cardReader(houseCard1)
                                + " and " + cardReader(houseCard2));
                        netWorth = netWorth - pot;
                        return;
                    default:
                        System.out.println("Please insert a valid number!");
                }
            }
            choiceResult = (pokerDecision(pokerChoice, wager));
            pot = choiceResult + pot;
            wager = wager - choiceResult;
            System.out.println("The amount in the pot is " + pot);
            if (choiceResult == 0) {
                System.out.println("The house also calls");
            } else {
                System.out.println("The house matches your raise, the new pot is " + (choiceResult + pot));
                pot = choiceResult + pot;
            }
    
        }
    
        public static int[] dupeCheck(int[] blacklist) {
            for (int i = 0; i < blacklist.length; i++) {
                for (int j = i + 1; j < blacklist.length; j++) {
                    if (blacklist[i] == blacklist[j]) {
                        blacklist[j] = (int) (52 * Math.random() + 1);
                    }
                }
            }
            return blacklist;
        }
    
        public static double pokerDecision(double choice, double tableValue) {
            int result = 0; // loops the code if the amount is not valid
            double raise = 0; // amount of money returned
            double amount = 0; // stores user input
            while (result == 0) {
                result = 1; // resets counter
                amount = 0; // resets raise value
                if (choice == 1) {
                    System.out.println("How much would you like to raise? You have " + tableValue + " at the table");
                    amount = in.nextDouble();
                    if (amount > tableValue) {
                        System.out.println("This value is greater than the amount you brought to the table, try again");
                        result = 0;
                    }
                    if (amount <= 0) {
                        System.out.println("Please insert a valid number");
                        result = 0;
                    }
                    if (result == 1) {
                        raise = amount; // converts stored variable to returned variable
                        result = 1;
                        return raise;
                    }
                }
    
                if (choice == 2) {
                    result = 1;
                    return raise;
                }
            }
            return raise;
        }
    
        public static String cardReader(int cardValue) { // method to convert number into card
            switch (cardValue) {
                case 1:
                    return "Ace of spades";
                case 2:
                    return "Two of spades";
                case 3:
                    return "Three of spades";
                case 4:
                    return "Four of spades";
                case 5:
                    return "Five of spades";
                case 6:
                    return "Six of spades";
                case 7:
                    return "Seven of spades";
                case 8:
                    return "Eight of spades";
                case 9:
                    return "Nine of spades";
                case 10:
                    return "Ten of spades";
                case 11:
                    return "Jack of spades";
                case 12:
                    return "Queen of spades";
                case 13:
                    return "King of spades";
                case 14:
                    return "Ace of clubs";
                case 15:
                    return "Two of clubs";
                case 16:
                    return "Three of clubs";
                case 17:
                    return "Four of clubs";
                case 18:
                    return "Five of clubs";
                case 19:
                    return "Six of clubs";
                case 20:
                    return "Seven of clubs";
                case 21:
                    return "Eight of clubs";
                case 22:
                    return "Nine of clubs";
                case 23:
                    return "Ten of clubs";
                case 24:
                    return "Jack of clubs";
                case 25:
                    return "Queen of clubs";
                case 26:
                    return "King of clubs";
                case 27:
                    return "Ace of hearts";
                case 28:
                    return "Two of hearts";
                case 29:
                    return "Three of hearts";
                case 30:
                    return "Four of hearts";
                case 31:
                    return "Five of hearts";
                case 32:
                    return "Six of hearts";
                case 33:
                    return "Seven of hearts";
                case 34:
                    return "Eight of hearts";
                case 35:
                    return "Nine of hearts";
                case 36:
                    return "Ten of hearts";
                case 37:
                    return "Jack of hearts";
                case 38:
                    return "Queen of hearts";
                case 39:
                    return "King of hearts";
                case 40:
                    return "Ace of diamonds";
                case 41:
                    return "Two of diamonds";
                case 42:
                    return "Three of diamonds";
                case 43:
                    return "Four of diamonds";
                case 44:
                    return "Five of diamonds";
                case 45:
                    return "Six of diamonds";
                case 46:
                    return "Seven of diamonds";
                case 47:
                    return "Eight of diamonds";
                case 48:
                    return "Nine of diamonds";
                case 49:
                    return "Ten of diamonds";
                case 50:
                    return "Jack of diamonds";
                case 51:
                    return "Queen of diamonds";
                case 52:
                    return "King of diamonds";
                default:
                    return "idk how u got here but this is an error"; // err msg
    
            }
    
        }
    }
}
