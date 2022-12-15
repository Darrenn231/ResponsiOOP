package responsi;

public class Vip extends Customer{
	public Vip(String name, String gender, String phoneNumber, String status, String loyaltyCardID, Integer points, String email,String lounge) {
		super(name, gender, phoneNumber, status, loyaltyCardID, points);
		this.email = email;
		this.lounge = lounge;
		// TODO Auto-generated constructor stub
	}
	private String email;
	private String lounge;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLounge() {
		return lounge;
	}
	public void setLounge(String lounge) {
		this.lounge = lounge;
	}
	@Override
	public int generatePoint() {
		// random 0 - name.length*2
		
		// Math.random * (max - min) + min + 1
		
		int currentPoint = (int) (Math.random() * (this.getName().length()*2)) + 1;
		return currentPoint;
	}
}
