import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // MENU
    public static int menu(Scanner keyboard) {
        System.out.println("MENU:\n");
        System.out.println("1. Register Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Buy Share");
        System.out.println("5. View Share");
        System.out.println("6. Quit\n");

        int choice;

        do {
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 6);

        return choice;
    }  //END 




   // REGISTER ACCOUNT
    public static Account registerAccount(Scanner keyboard) {

        Account account = null; 
    

        int accountNumber;
        System.out.print("Please enter your account number: ");
        accountNumber = keyboard.nextInt();
        System.out.print("Account successfully registered.\n");
            account = new CheckAccountInfo(accountNumber);
        
        return account;
    } // END




    //SEARCH ACCOUNT
    public static int searchAccount(Account accounts [], int count, int accountNumber) {

        for(int i=0; i<count; i++) {
            if(accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }

        return -1; 
    } //END



    //DEPOSIT METHOD
    public static void doDeposit(Account accounts [], int count, Scanner keyboard) {
        
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            System.out.print("Please enter the amount you wish to deposit: ");
            double amount = keyboard.nextDouble();
            accounts[index].deposit(amount);
        } else {
            System.out.println("The account '" + accountNumber +"' is not registered. To deposit money into this account, please register it - Option 1.");
        }
    } //END



    // WITHDRAW METHOD
    public static void doWithdraw(Account accounts [], int count, Scanner keyboard) {

        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            System.out.print("Please enter Withdraw Amount: ");
            double amount = keyboard.nextDouble();
            accounts[index].withdraw(amount);
        } else {
            System.out.println("The account '" + accountNumber +"' is not registered. To withdraw money from this account, please register it - Option 1.");
        }
    }


    //BUY SHARES
    public static void doBuyShares( Scanner keyboard){

        
        int buyShare;
        String share = "";

        System.out.println("Please Choose which share you want to buy");
        System.out.println("You may only own one share at a time due to limited availability.\n");
        ArrayList<String> shares = new ArrayList<String>();
        shares.add("FTSE 100");
        shares.add("FTSE 250");
        shares.add("FTSE All Share");
        shares.add("FTSE techMARK 100");
        shares.add("FTSE AIM 100\n");
        for(int i = 0; i<shares.size(); i++){
            System.out.println((i+1)+ ": " + shares.get(i));
        }

            System.out.print("Option: ");
            buyShare = keyboard.nextInt();
            if(buyShare == 1){
                share = "FTSE 100";
                System.out.println("You have succesfully bought this share. Choose Option 5 to view share.");
            } else if(buyShare == 2){
                share = "FTSE 250";
                System.out.println("Successful");
            }else if(buyShare == 3){
                share = "FTSE All Share";
                System.out.println("Successful");
            }else if(buyShare == 4){
                share = "FTSE techMark 100";
                System.out.println("Successful");
            }else if(buyShare == 5){
                share = "FTSE Aim 100";
                System.out.println("Successful");
            } else {
                System.out.println("You have not entered a valid number.");
                System.out.println("Unsuccesful");

            }

            try {
                FileWriter myWriter = new FileWriter("User_Shares.txt");
                myWriter.write("Share available: \n" + share + "\n");
                myWriter.close();
            } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        
    } //END


    //VIEW SHARE AVAILABLE
    private static void doViewShare() {
        try {
            File myObj = new File("User_Shares.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    } //END

    // MAIN METHOD
    public static void main(String [] args) {

        new Login();
        
        //DATE AND TIME 
        LocalDateTime dateObj = LocalDateTime.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateObj.format(formatObj);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nWelcome to the Investment Trading App.\nAll new users must regisiter their account number to access the app's full features - Option 1.\nYou may then choose an option from the menu.\n");

        System.out.println("Current date and time: " +formattedDate+ "\n"); 

        Account accounts [] = new Account[10];
        int numAccounts = 0; 

        int choice;

        do {
            choice = menu(keyboard);
            System.out.println();
            
            if(choice == 1) {
                accounts[numAccounts++] = registerAccount(keyboard);
            } else if(choice == 2) {
                doDeposit(accounts, numAccounts, keyboard);
            } else if(choice == 3) {
                doWithdraw(accounts, numAccounts, keyboard);
            } else if(choice == 4) {
                doBuyShares(keyboard);
            } else if(choice == 5) {
                doViewShare();           
            } else {
                System.out.println("Thanks for using the Investment Trading App. GoodBye!");
            }
            System.out.println();
        } while(choice != 6);
    }

}
