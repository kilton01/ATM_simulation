import java.util.Scanner;

public class MegDatabase {
	protected static Clients[] DataBase;
	protected static Clients[] Backup;
	protected static int NumOfClients = 0;
	protected static int size = 1;
	protected Scanner userInput = new Scanner(System.in);
	protected int Amount;
	protected String OtherAccount;
	protected MegDatabase Data;
    protected int leftChild = 0;
    protected int rightChild = 0;
    protected int parent = 10;


	public MegDatabase() {
		DataBase = new Clients[ size ];
	}

	public Clients[] getDataBase() {
		return DataBase;
	}

	public void setDataBase(Clients[] dataBase) {
		DataBase = dataBase;
	}

	public void addClient(Clients NewClient) {
		if (NumOfClients < DataBase.length)
			NumOfClients++;
		int j = NumOfClients - 1;
		if (NumOfClients == DataBase.length) {
			size = DataBase.length;
			int size1 = size + 1;
			Backup = new Clients[ size1 ];
			for (int q = 0; q < (size); q++) {
				Backup[ q ] = DataBase[ q ];
			}
			DataBase = Backup;
		}
		DataBase[j] = NewClient;
	}
	public int capacity(){
		return DataBase.length;
	}

	public void ClientChecker() {
		for (int r = 0; r < DataBase.length-1; r++) {
			System.out.println(DataBase[ r ]);
		}
	}

	// ACCESS CLIENT DATA
	int i = 0;
	public String getClientInfo(String accNumber, int pin){
		String name = null;
		while(i < DataBase.length -1){
			String s = DataBase[i].getAccountNumber();
			int p = DataBase[i].getPinCode();
			if(s.equals(accNumber) && p == pin){
				name = (DataBase[i].getNameOfClient());
				System.out.println(i);
				return name;
				//break;
			} else {
				i++;
				System.out.println("The customer cannot be found.");
			}

		}
		return name;
	}
	public int getPinCode() {
		return DataBase[i].getPinCode();
	}
	
	public String getName() {
		return DataBase[i].getNameOfClient();
	}

	public int getAmount() {
		System.out.println();
		System.out.println(DataBase[i]);
		return DataBase[i].getAmount();
	}
	public int setAmount(int amount) {
		DataBase[i].setAmount(amount);
		System.out.println();
		System.out.println(DataBase[i]);
		return DataBase[i].getAmount();
	}

	public String getAccountNumber() {
		System.out.println();
		System.out.println(DataBase[i]);
		return DataBase[i].getAccountNumber();
	}

	public int userIndex() {
		return i;
	}
	
	//Clients with withdrawal permit
	//
	public boolean withdrawalPermit() {
		if(DataBase[i].getAmount() <= parent) {
			System.out.println(DataBase[i]);
			leftChild = DataBase[i].getAmount();
			return false;
		} else {
			System.out.println(DataBase[i]);
			rightChild = DataBase[i].getAmount();
			return true;
		}
	}

	// changing pin
	public String pinCodeResetValidator(int newpin1) {
		if (newpin1 < 1000 || newpin1 > 9999) {
			String error = "Error!!! Your pin must be 4 digits"; 
			return error;
		}
		return null;
	}

	public String pinChecker(int oldpin) {
		if(DataBase[userIndex()].getPinCode() == oldpin) {
			String l = Integer.toString(oldpin);
			return l;
		}
		return null;
	}

	public void pinRewrite(int newPin) {
		DataBase[userIndex()].setPinCode(newPin); 
		System.out.println(DataBase[userIndex()]);
	}

	//transferring
	public void Transfer() {
		System.out.println("Enter Amount: ");
		Scanner Input = new Scanner(System.in);
		Amount = Input.nextInt();
		System.out.println("Enter Account Number: ");
		OtherAccount = userInput.nextLine();
		//put the withdrawalPermit method here to check before transfer can be permitted. 
		for(int r=0; r < DataBase.length-1; r++) {
			if (OtherAccount.equals(DataBase[r].getAccountNumber())){
				if(DataBase[i].getAmount() - Amount < 10) {
					System.out.println("YOU DO NOT HAVE ENOUGH FUNDS TO MAKE THIS TRANSACTION");
				} else {
					int newAmount = DataBase[i].getAmount()-Amount;
					DataBase[i].setAmount(newAmount);
					int newOtherAmount = DataBase[r].getAmount()+Amount;
					DataBase[r].setAmount(newOtherAmount);
					System.out.println(DataBase[i].getAmount());
					System.out.println(DataBase[i]);
					System.out.println(DataBase[r].getAmount());
					System.out.println(DataBase[r]);
				}
			}
		}	
	}


	// Generate shopping token
	public long ShoppingToken() {
		long thirteen = (long) (Math.random() * 10000000000000L);
		long token = 2820000000000000L + thirteen;
		System.out.println(token);
		return token;
	}

	// Generate withdrawal token
	public long withdrawalToken() {
		long thirteen = (long) (Math.random() * 100000L);
		long Wtoken = 682000L + thirteen;
		System.out.println(Wtoken);
		return Wtoken;
	}
}
