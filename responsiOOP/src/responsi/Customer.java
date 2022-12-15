package responsi;

public abstract class Customer {
	private String name;
	private String gender;
	private String phoneNumber;
	private String status;
	private String loyaltyCardID;
	private Integer points;
	
	
	
	public Customer(String name, String gender, String phoneNumber, String status, String loyaltyCardID,
			Integer points) {
		super();
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.loyaltyCardID = loyaltyCardID;
		this.points = points;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLoyaltyCardID() {
		return loyaltyCardID;
	}
	public void setLoyaltyCardID(String loyaltyCardID) {
		this.loyaltyCardID = loyaltyCardID;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public abstract int generatePoint();
}
