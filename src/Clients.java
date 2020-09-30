
import java.util.Objects;

public class Clients {
	protected String NameOfClient;
	protected String DateOfBirth;
	protected int YearGroup;
	public String AccountNumber;
	protected int Amount;
	protected int  PinCode;

	public Clients(String nameOfClient, String dateOfBirth, int yearGroup, String accountNumber, int amount, int pinCode) {
		this.NameOfClient =nameOfClient;
		DateOfBirth = dateOfBirth;
		YearGroup = yearGroup;
		AccountNumber = accountNumber;
		Amount = amount;
		PinCode = pinCode;
	}

	public String getNameOfClient() {
		return NameOfClient;
	}

	public void setNameOfClient(String nameOfClient) {
		NameOfClient = nameOfClient;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public  int getYearGroup() {
		return YearGroup;
	}

	public void setYearGroup(int yearGroup) {
		YearGroup = yearGroup;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public int getPinCode() {
		return PinCode;
	}

	public void setPinCode(int pinCode) {
		PinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Clients{" +
				"NameOfClient='" + NameOfClient + '\'' +
				", DateOfBirth='" + DateOfBirth + '\'' +
				", YearGroup=" + YearGroup +
				", AccountNumber='" + AccountNumber + '\'' +
				", Amount=" + Amount +
				", PinCode=" + PinCode +
				'}';
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Clients clients = (Clients) o;
		return YearGroup == clients.YearGroup &&
				Amount == clients.Amount &&
				Objects.equals(NameOfClient, clients.NameOfClient) &&
				Objects.equals(DateOfBirth, clients.DateOfBirth) &&
				Objects.equals(AccountNumber, clients.AccountNumber) &&
				Objects.equals(PinCode, clients.PinCode);
	}
}
