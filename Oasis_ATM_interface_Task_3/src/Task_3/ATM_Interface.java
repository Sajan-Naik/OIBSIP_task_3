package Task_3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ATM_Interface 
{
	String Full_name;
	String DOB;
	String Gender;
	String Gender1="M";
	String Gender2="m";
	String Gender3="F";
	String Gender4="f";
	String Username;
	String Password;
	String Account_Number;
	String Pin;
	String Mobile_Number;
	String Transaction_History="Your Transaction History is : \n";
	
	Scanner input=new Scanner(System.in);
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-mm-yyyy HH:MM:SS");
	LocalDateTime now=LocalDateTime.now();
	float Balance=0f;
	int Transaction=0;
	
	public void View_profile()
	{
		System.out.println("****** Your Profile ******");
		System.out.println("Full Name:"+this.Full_name);
		System.out.println("DOB:"+this.DOB);
		System.out.println("Gender:"+this.Gender);
		System.out.println("Username:"+this.Username);
		System.out.println("Password:"+this.Password);
		System.out.println("Account Number:"+this.Account_Number);
		System.out.println("Your Pin:"+this.Pin);
		System.out.println("Mobile Number:"+this.Mobile_Number);	
	}
	
	public void Registration() 
	{
		System.out.println("**** Registration ****");
		System.out.println("Enter Your Name: ");
		this.Full_name=input.nextLine();
		System.out.println("Enter your DOB(dd-mm-yyyy):");
		this.DOB=input.nextLine();
		System.out.println("Enter your Gender(M/F):");
		this.Gender=input.nextLine();
		while(!((((this.Gender).equals(this.Gender1)) || ((this.Gender).equals(this.Gender2))) || (((this.Gender).equals(this.Gender3)) || ((this.Gender).equals(this.Gender4)))))
				{
				System.out.println("Invalid... Please Enter COrrect Gender(M/F)");
				this.Gender=input.nextLine();
				}
		if (this.Gender.equals(this.Gender1) || this.Gender.equals(this.Gender2))
		{
			this.Gender="Male";
		}
		else
		{
			this.Gender="Female";
		}
		
		System.out.println("Enter Username:");
		this.Username=input.nextLine();
		System.out.println("Enter Password:");
		this.Password=input.nextLine();
		System.out.println("Account Number:");
		this.Account_Number=input.nextLine();
		while((Account_Number.length())!=10)
		{
			System.out.println("!!!~ Please Enter Valid Account Number: ");
			this.Account_Number=input.nextLine();
		}
		
		System.out.println("Enter your pin:");
		this.Pin=input.nextLine();
		while((Pin.length())!=6)
		{
			System.out.println("!!!~ Please Enter Valid Pin:");
			this.Pin=input.nextLine();
		}
		
		System.out.println("Enter your mobile number:");
		this.Mobile_Number=input.nextLine();
		while((Mobile_Number.length())!=10)
		{
			System.out.println(("!!!~ Please Enter Valid 10 Digits Mobile Number: "));
			this.Mobile_Number=input.nextLine();
		}
		System.out.println("You are successfully Registered....");
		System.out.println("Now you can login and perform any transaction...");
	}
	
	public boolean Login()
	{
		boolean log=false;
		while(!log)
		{
			System.out.println("Enter account number:");
			String Acc_Number;
			Acc_Number=input.nextLine();
			if(Acc_Number.equals(Account_Number))
			{
				System.out.println("Enter Your Pin:");
				String pin;
				pin=input.nextLine();
				System.out.println("Confirm Your Pin:");
				String cnfpin;
				cnfpin=input.nextLine();
				if(cnfpin.equals(pin))
				{
					while(!log)
					{
						if(pin.equals(Pin))
						{
							System.out.println("You are Logged in Successfully...");
							log=true;
						}
						else
						{
							System.out.println("Enter correct pin:");
							break;
						}
					}
				}
				else
				{
					System.out.println("Plese confirm your pin and reenter");
				}
			}
			else
			{
				System.out.println("Register to login...");
			}
		}
		return log;
	}
	
	public void deposit()
	{
		System.out.println("Enter amount to deposite into your account: ");
		float Deposit_amount;
		Deposit_amount=input.nextFloat();
		if(Deposit_amount>1000000f)
		{
			System.out.println("This ATM is not capable to deposite money beyond 10,00,000/-");
		}
		else
		{
			Balance=Balance+Deposit_amount;
			Transaction=Transaction+1;
			System.out.println("Successfully deposited Rs. "+Deposit_amount+"into your account"+dtf.format(now));
			System.out.println("Your current balance after this transaction is: "+Balance);
			String History=" ";
			History="\n Rs "+ Deposit_amount+" deposited at "+dtf.format(now)+".\n";
			Transaction_History=Transaction_History.concat(History);
		}
	}

	public void Withdraw()
	{
		System.out.println("Enter amount to withdraw from your account: ");
		float Withdraw_Amount;
		Withdraw_Amount=input.nextFloat();
		if(Withdraw_Amount<1000000)
		{
			if(Withdraw_Amount>Balance)
			{
				System.out.println("!!!~ Sorry Insufficient Balance....");
			}
			else
			{
				Balance=Balance-Withdraw_Amount;
				Transaction=Transaction+1;
				System.out.println("Successfully withdraw Rs. "+Withdraw_Amount+" from your account at "+dtf.format(now));
				System.out.println("Your current balance after this transaction is:"+Balance);
				String History=" ";
				History=" \n Rs"+Withdraw_Amount+"withdraw at "+dtf.format(now)+" .\n";
				Transaction_History=Transaction_History.concat(History);
			}
		}
		else
		{
			System.out.println("This ATM cannot dispence money more than 10,00,000/-");
		}
	}
	
	public void Transfer()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the username to transfer: ");
		String Usertransfer;
		Usertransfer=input.nextLine();
		System.out.println("Enter the amount to transfer to "+Usertransfer+ ":");
		float Total_Amount;
        Total_Amount=input.nextFloat();
        if(Total_Amount<1000000f){
            if (Total_Amount>Balance){
                System.out.println("Sorry! Amount cant be transferred Due to Insufficient Balance.");
                System.out.println("Your Balance was: "+Balance);
            }
            else{
                Balance=Balance-Total_Amount;
                Transaction=Transaction+1;
                System.out.println("Successfully transferred Rs. "+Total_Amount+" to "+Usertransfer+" from your account at "+dtf.format(now));
                System.out.println("Your Current Balance after this transaction is: "+Balance);
                String History=" "; 
                History="\n Rs "+Total_Amount+" was transferred to "+Usertransfer+"'s account from your account at "+dtf.format(now)+" .\n";
                Transaction_History=Transaction_History.concat(History);
            }
        }
        else{
            System.out.println("Cannot transfer money beyond 10,00,000/-");
        }
    }
		
	public void Transaction_history()
	{
		if(Transaction==0)
		{
			System.out.println("No transactions...");
		}
		else
		{
			System.out.println(Transaction_History);
		}
	}
	
	public void Check_Balance()
	{
		System.out.println("\n Balance amount is :"+Balance);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
	        System.out.println("******* Welcome to ATM *******");
	        System.out.println("\nSelect any one option from the below:");
	        System.out.println("1.Register(New Users should Register First)\n2.Exit");
	        System.out.print("Your choice:");
	        int choice;
	        choice=input.nextInt();
	        if(choice==1){
	            ATM_Interface atm=new ATM_Interface();
	            atm.Registration();
	            while(choice==1){
	                System.out.println("\n Select any one option: ");
	                System.out.println("1.Login(If already Registered)\n 2.Exit");
	                System.out.print("Your option :");
	                int option=input.nextInt();
	                if (option==1){
	                    if(atm.Login()){
	                        while(true){
	                            System.out.println("\n\n This ATM is able to perform this operations: ");
	                            System.out.println("1.View Profile");
	                            System.out.println("2.Deposit");
	                            System.out.println("3.Withdraw");
	                            System.out.println("4.Transfer");
	                            System.out.println("5.Transaction History");
	                            System.out.println("6.Check Balance");
	                            System.out.println("7.Exit");

	                            System.out.print("Enter your option :");
	                            int select; 
	                            select=input.nextInt();
	                            switch(select){
	                                case 1 : atm.View_profile();
	                                         break;
	                                case 2 : atm.deposit();
	                                         break;
	                               case 3 : atm.Withdraw();
	                                         break;
	                                case 4 : atm.Transfer();
	                                         break;
	                                case 5 : atm.Transaction_history();
	                                         break;
	                                case 6 : atm.Check_Balance();
	                                         break;
	                                case 7 :System.out.println("\nThank you...Visit Again...:)"); 
	                                        System.exit(0);
	                                default: System.out.println(" It is Invalid option!...Plese enter Valid option...");
	                            }
	                        }
	                    }
	                }
	                else{
	                    System.out.println("\nThank you...Visit Again...:)"); 
	                    System.exit(0);
	                }
	            }
	        }
	        else {
	            System.out.println("\nThank you...Visit Again...:)"); 
	        	System.exit(0);
	        }
	    }
}
