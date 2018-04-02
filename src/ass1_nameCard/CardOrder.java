package ass1_nameCard;

/**
 * OOP Assignment One
 * CardOrder class keeps details of one card order
 * and provides methods to print a card
 * and determine the price
 */
public class CardOrder {

    //variables
    private Name name;
    private char border;
    private int numCards;
    private double price;
    private double discount;
    private static final int CARD_LEN = 32;


    //initialises name from value in parameter
    //and sets other instance variables to suitable default values
    //you can create a Name from a single string after L5
    //If you want to start before then, just write name = new Name("A", "B", "C") in the constructor!
    public CardOrder(String fullName) {
        name = this.getFormatedUserName(fullName);
        border = '*';
        numCards = 0;
        this.setPrice();
        discount = 0.1;
    }

    // check if full name consists of first, middle, last or first, last or others
    private Name getFormatedUserName(String fullName) {
        if (fullName != null) {

            String[] strs = fullName.split("\\ ");

            switch (strs.length) {
                case 2:
                    return new Name(strs[0], strs[1]);
                case 3:
                    return new Name(strs[0], strs[1], strs[2]);
                default:
                    return new Name(" ", " ", "");
            }

        } else {
            System.out.printf("Please input your name!");

            return new Name(" ", " ", " ");
        }
    }

    ///////////////////////////////////////////
    //accessor/mutator methods

    //returns the character used in the border
    public char getBorder() {
        return this.border;
    }

    //sets the character used in the border
    //to that provided in the parameter
    public void setBorder(char ch) {
        this.border = ch;
    }

    //returns the name
    public Name getName() {
        return this.name;
    }

    //sets the name used in the card
    //to that provided in the parameter
    public void setName(Name name) {
        this.name = name;
    }

    //returns the number of cards to be printed
    public int getNumCards() {
        return this.numCards;
    }

    //sets the number of cards to be printed
    //to that provided in the parameter
    public void setNumCards(int n) {
        this.numCards = n;
    }
    ///////////////////////////////////////////


    //returns a sample card, including a newline at the end of each line
    public String getSampleCard() {
        return getTopLine() + "\n" + getBlankLine() + "\n" + this.getLineWithName() + "\n"
                + getBlankLine() + "\n" + getTopLine();

    }

    //returns a String containing the top or bottom line
    //of a card, including a newline character at the end
    private String getTopLine() {
        //use this value until more code written
        String initialsName = this.name.getInitials();

        //make top line to be printed
        char[] cs = new char[CARD_LEN];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = this.border;
        }

        //start of line
        cs[0] = initialsName.charAt(0);
        cs[1] = initialsName.charAt(1);
        cs[2] = initialsName.charAt(2);

        //last of line
        cs[cs.length - 3] = initialsName.charAt(0);
        cs[cs.length - 2] = initialsName.charAt(1);
        cs[cs.length - 1] = initialsName.charAt(2);


        // to string
        return String.valueOf(cs);
    }

    //returns a String containing the blank line
    //of a card, with a border char at each end
    //and including the newline character
    private String getBlankLine() {
        //use this value until more code written

        //make blank line to be printed
        char[] cs = new char[CARD_LEN];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = ' ';
        }
        cs[0] = this.border;
        cs[cs.length - 1] = this.border;

        //to sting
        return String.valueOf(cs);

    }

    //returns a String containing the name line
    //of a card, including name, padding and border
    //and including the newline character
    private String getLineWithName() {
        //use this value until more code written

        //make line with name to be printed
        char[] cs = new char[CARD_LEN];

        for (int i = 0; i < cs.length; i++) {
            cs[i] = ' ';
        }
        cs[0] = this.border;
        cs[cs.length - 1] = this.border;

        String formateName = this.name.getNameFormat();

        if (formateName.length() % 2 != 0) {
            cs[cs.length / 2] = formateName.charAt(formateName.length() / 2);
            for (int i = 1; i <= (int) formateName.length() / 2; i++) {
                cs[cs.length / 2 - i] = formateName.charAt(formateName.length() / 2 - i);
                cs[cs.length / 2 + i] = formateName.charAt(formateName.length() / 2 + i);
            }
        } else {
            for (int i = 0; i < formateName.length() / 2; i++) {
                cs[cs.length / 2 - 1 - i] = formateName.charAt(formateName.length() / 2 - 1 - i);
                cs[cs.length / 2 + i] = formateName.charAt(formateName.length() / 2 + i);
            }
        }

        //to string
        return String.valueOf(cs);
    }

    //returns the price of one card
    //in pounds (i,e either 0.20 or 0.25)
    //based on the number of characters in the name to be printed
    //0.20 if <=12 otherwise 0.25
    public double getCardPrice() {
        //use this value until more code written
        return this.price;
    }

    //40 if <=12 otherwise 50
    private void setPrice() {
        if (this.name.getNameFormat().length() <= 12) {
            this.price = 40;
        } else {
            this.price = 50;
        }
    }

    //returns the final cost of the order
    //which is the number of cards multiplied by the card price
    //and reduced by 10% if >= 200 cards
    public double getFinalCost(int FinalPrintTotal) {
        //use this value until more code written
        if (FinalPrintTotal >= 200) {
            double finalPrice = this.price * FinalPrintTotal * (1 - discount);
            System.out.println("The price of " + FinalPrintTotal + "cards is " + finalPrice + " won.");
            System.out.println("10% discount applied");
            return finalPrice;
        } else {
            double finalPrice = this.price * FinalPrintTotal;
            System.out.println("The price of " + FinalPrintTotal + "cards is " + finalPrice + " won.");
            System.out.println("No discount given");
            return finalPrice;
        }

    }

    //returns true if number of cards < 100, false otherwise
    //public boolean hasDiscount() {

    //}
}
