import java.awt.EventQueue;

public class Main {


	public static void main(String[] args) {

		//CLIENTS AND MEGDATABASE
		Clients  Stephen = new Clients("Stephen Owusu","27/04/1998", 2020, "4242547074107107", 100, 1111);
		Clients Paul = new Clients ("Paul Yeboah","17/12/1998", 2020, "4246037440623753", 10,1111);
		Clients Selorm = new Clients("Selorm Lodonu","14/05/1998",2021,"4240708947254815",10,1111);
		Clients Ian = new Clients("Ian Jacobs","23/09/1998",2021,"4243938806132897",10,1111 );
		Clients Philip = new Clients("Philip Hanson","3/10/1997",2020,"4245371287822353",10,1111 );
		Clients Hubert = new Clients("Hubert Agyeman","3/10/1997",2022,"4249873086431825",10,1111 );
		Clients Sally = new Clients("Sally Peaches","30/02/1998",2020,"4247373280438424",10,1111 );
		Clients Kelvin = new Clients("Kelvin Agyeman","30/03/1998",2020,"4240981466822760",10,1111 );
		Clients Frank = new Clients("Frank Adu","05/04/1998",2022,"4244934734162927",10,1111);
		Clients Afua= new Clients("Afua Kesewa","09/08/1999",2019,"4245291853554040",30,1111);
		MegDatabase Data = new MegDatabase();
		Data.addClient(Stephen);
		Data.addClient(Paul);
		Data.addClient(Selorm);
		Data.addClient(Ian);
		Data.addClient(Philip);
		Data.addClient(Hubert);
		Data.addClient(Sally);
		Data.addClient(Kelvin);
		Data.addClient(Frank);
		Data.addClient(Afua);
		Data.ClientChecker();

		//Data.Transfer();


		// Continue
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Continue frame = new Continue(Data);
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//Amount
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Amount frame = new Amount(Data);
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//Deposit
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit(Data);
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		//Withdrawal
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrawal frame = new Withdrawal(Data);
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// ChangePin
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePin frame = new ChangePin(Data);
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		//Main Window
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow(Data);
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


		// MegaPlatform
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MegaPlatform window = new MegaPlatform(Data);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});



	}	
}
