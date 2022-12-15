package responsi;
import java.util.*;

public class Main {

	Scanner scan = new Scanner(System.in);
	ArrayList<Customer> customerAL = new ArrayList();
	void printMenu() {
		System.out.println("Jtheatre");
		System.out.println("1. Add new member");
		System.out.println("2. View all member");
		System.out.println("3. Watch a movie");
		System.out.println("4. Exit");
		System.out.printf(">> ");
		
	}
	
	String genLoyaltyCard(String status) {
		String ID = "";
		
		if(status.equals("VIP")) {
			ID = "V";
			for(int i = 0 ; i < 5 ; i++) {
				int temp = (int)((Math.random()*(9-1)) +1);
				ID += temp;
			}
		}
		else {
			ID = "R";
			for(int i = 0 ; i < 5 ; i++) {
				int temp = (int)((Math.random()*(9-1)) +1);
				ID += temp;
			}
		}
		return ID;
	}
	
	String genLounge() {
		String lounge = "LO";
		for(int i = 0 ; i < 3 ; i++) {
			int temp = (int)((Math.random()*(3-1)) +1);
			lounge += temp;
		}
		return lounge;
	}
	
	void addNewMember() {
		String name = "";
		String gender = "";
		String phoneNumber = "";
		String status = "";
		String loyaltyCardID = "";
		Integer points = 0;
		boolean trigger = false;
		String email = "";
		String lounge = "";
		int queue = 0;
		
		do {
			System.out.printf("INPUT NAME: ");
			name=scan.nextLine();
		}while(name.length()<5 || name.length()>12);
		
		do {
			System.out.printf("Input gender: ");
			gender = scan.nextLine();
		}while(!gender.equals("Male") && !gender.equals("Female"));
		// equals ignore case
		
		do {
			boolean isAllDigit = true;
			boolean numberLength = false;
			System.out.printf("INPUT PHONE NUMBER: ");
			phoneNumber = scan.nextLine();
			
			for(int i = 0 ; i < phoneNumber.length();i++) {
				Character temp = phoneNumber.charAt(i);
				if(!temp.isDigit(temp)) {
					isAllDigit = false;
					break;
				}
			}
			
			if(phoneNumber.length() == 12) {
				numberLength=true;
				
			}
			if(isAllDigit == true && numberLength == true) {
				trigger  = true;
			}
			
		}while(trigger == false);
		
		do {
			System.out.printf("INPUT STATUS: ");
			status = scan.nextLine();
		}while(!status.equals("VIP") && !status.equals("Regular"));
		
		loyaltyCardID = genLoyaltyCard(status);
		
		
		if(status.equals("VIP")){
			do {
				System.out.println("Input email: ");
				email = scan.nextLine();
			}while(!email.endsWith("@gmail.com"));
			lounge = genLounge();
			customerAL.add(new Vip(name,gender,phoneNumber,status,loyaltyCardID,points,email,lounge));
		}
		else {
			int temp = (int)((Math.random()*(3-1)) +1);
			queue = temp;
			customerAL.add(new Reguler(name,gender,phoneNumber,status,loyaltyCardID,points,queue));
		}
		
		
	}
	
	void viewMember() {
		if(customerAL.isEmpty()) {
			System.out.println("There are no member currently...");
			return;
		}
		else {
			int counter = 0;
			System.out.printf(" %-4s | %-16s | %-10s | %-20s | %-10s | %-10s | %-15s | %-20s | %-15s | %-10s\n","No","Name","Gender","Phone number","Status","ID","POINTS","email","lounge","queue");
			
			for (Customer c : customerAL) {
				counter++;
				if(c instanceof Vip) {
					System.out.printf(" %-4d | %-16s | %-10s | %-20s | %-10s | %-10s | %-15d | %-20s | %-15s | %-10s\n",counter,c.getName(),c.getGender(),c.getPhoneNumber(),c.getStatus(),c.getLoyaltyCardID(),c.getPoints(),((Vip)c).getEmail(),((Vip)c).getLounge(),"-");
				}else if(c instanceof Reguler) {
					System.out.printf(" %-4d | %-16s | %-10s | %-20s | %-10s | %-10s | %-15d | %-20s | %-15s | %-10d\n",counter,c.getName(),c.getGender(),c.getPhoneNumber(),c.getStatus(),c.getLoyaltyCardID(),c.getPoints(),"-","-",((Reguler)c).getQueue());
				}
			}
		}
	}
	
	void watchMovie() {
		
	}

	public Main() {
		int opt = 0;
		do {
			printMenu();
			opt = scan.nextInt();
			scan.nextLine();
			
			switch (opt) {
			case 1:
				addNewMember();
				break;
			case 2:
				viewMember();	
				break;
			case 3:
				watchMovie();
				break;
			}
		}while(opt!=4);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
