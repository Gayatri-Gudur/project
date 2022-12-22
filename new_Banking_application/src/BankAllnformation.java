import java.util.Scanner;


public class BankAllnformation {
    String nameofAccountHolder, UsernameOfAccountHolder, UserPasssword,UserTransactionHistory="";
    float balanceofAccountHolder=0.0f;
    int TransactionOfaccountHolder=0;

    public static void pause_exec(int sec){
        int sleep_in_sec=sec*1000;
        try {
            Thread.sleep(sleep_in_sec);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void withdrawFromBank(){
        System.out.println("Enter amount to withdraw from account");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();

        try {
            if(balanceofAccountHolder>=amount){
                TransactionOfaccountHolder++;
                balanceofAccountHolder-=amount;
                System.out.println(ConsoleColors.GREEN);
                System.out.println("\n--------------------------");
                System.out.println("Withdrawn successfully");
                System.out.println("----------------------------");
                System.out.println(ConsoleColors.RESET);
                pause_exec(3);

                String str="(#)"+ amount +" Rs. withdrawned\n\n";
                UserTransactionHistory=UserTransactionHistory.concat(str);
            }else{
                System.out.println(ConsoleColors.RED);
                System.out.println("\n--------------------------");
                System.out.println("Your Account won't have this much balance");
                System.out.println("----------------------------");
                System.out.println(ConsoleColors.RESET);
                pause_exec(3);

            }
        }catch (Exception e){
            System.out.println("");
        }
    }

    public void registerfForBank(){

        System.out.println(ConsoleColors.YELLOW_BOLD);
        System.out.println("          ");
        System.out.println(ConsoleColors.RESET);
        Scanner sc=new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE_BOLD);
        System.out.println("\n--> Enter your Name: ");
        System.out.println(ConsoleColors.RESET);
        this.nameofAccountHolder = sc.nextLine();
        System.out.println(ConsoleColors.BLUE_BOLD);
        System.out.println("\n--> Enter your username");
        System.out.println(ConsoleColors.RESET);
        this.UsernameOfAccountHolder=sc.nextLine();
        System.out.println(ConsoleColors.BLUE_BOLD);
        System.out.println("\n--> Enter your passsword");
        System.out.println(ConsoleColors.RESET);
        this.UserPasssword=sc.nextLine();
        System.out.println(ConsoleColors.BLUE_BOLD);
        System.out.println(ConsoleColors.GREEN);
        System.out.println("\n\n--> Registration completed, enter to contiue...");
        System.out.println(ConsoleColors.RESET);
        sc.nextLine();

    }

    public void CheckBalanceInOurAccount(){
        System.out.println("Total balance in your account is ₹"+balanceofAccountHolder);
        pause_exec(5);
    }

    public boolean loginInfo(){
        boolean isLogin=false;
        Scanner sc=new Scanner(System.in);

        while(!isLogin){
            System.out.println(ConsoleColors.YELLOW_BRIGHT);
            System.out.println("            ");
            System.out.println(ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE);
            System.out.println("\n($) Ener your Username - ");
            System.out.println(ConsoleColors.RESET);
            String Username=sc.nextLine();
            if(Username.equals(UsernameOfAccountHolder)){
                while (!isLogin){
                    System.out.println(ConsoleColors.BLUE);
                    System.out.println("\n($) Enter yor password - " );
                    System.out.println(ConsoleColors.RESET);
                    String password=sc.nextLine();
                    if(password.equals(UserPasssword)){
                        System.out.println(ConsoleColors.GREEN_BOLD);
                        System.out.println("\n-------------------------");
                        System.out.println("Login Succesful!!");
                        System.out.println("---------------------------");
                        System.out.println(ConsoleColors.RESET);
                        isLogin=true;
                    }else{
                        System.out.println(ConsoleColors.RED_BOLD);
                        System.out.println("\n-------------------------");
                        System.out.println("Incorrect password!!");
                        System.out.println("---------------------------");
                        System.out.println(ConsoleColors.RESET);
                    }
                }
            }
            else{
                System.out.println(ConsoleColors.RED_BOLD);
                System.out.println("\n-------------------------");
                System.out.println("Username Not Found!!");
                System.out.println("---------------------------");
                System.out.println(ConsoleColors.RESET);
            }
        }
        return isLogin;
    }

    public void transferFunds(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n Enter Account's Name you want to transfer ");
        String receipent=sc.nextLine();
        System.out.println(("\n Enter Ammounbt to transefer to "+ receipent));
        float Amt=sc.nextFloat();
        try {
            if(balanceofAccountHolder>=Amt){
                if(Amt <=50000f){
                    TransactionOfaccountHolder++;
                    balanceofAccountHolder-=Amt;
                    System.out.println(ConsoleColors.GREEN);
                    System.out.println("\n----------------------------------------");
                    System.out.println("Successfully transfered to "+receipent);
                    String str="(#)"+ Amt+" Rs transferred to "+ receipent+"\n\n";
                    UserTransactionHistory=UserTransactionHistory.concat(str);
                    pause_exec(3);
                }else {
                    System.out.println(ConsoleColors.RED);
                    System.out.println("\n Sorry.......Limit id 500000.00 only");
                    System.out.println(ConsoleColors.RESET);
                    pause_exec(3);
                }
            }
            else{
                System.out.println(ConsoleColors.RED);
                System.out.println("\n--------------------------");
                System.out.println("Your Account won't have this much balance");
                System.out.println("----------------------------");
                System.out.println(ConsoleColors.RESET);
                pause_exec(3);
            }
        }
        catch (Exception e){
            System.out.println("");
        }

    }

}
