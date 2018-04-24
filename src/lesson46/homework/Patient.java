package lesson46.homework;

public class Patient {
	private int number;
	private int docNumber;
	
	
	public Patient(int number) {
		this.number = number;
	}
	
	public int getNumber(){
		return number;
	}
	
	public int getDocNumber() {
		return docNumber;
	}
	public void setDocNumber(int docNumber) {
		this.docNumber = docNumber;
	}
}