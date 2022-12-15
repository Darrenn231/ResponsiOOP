package responsi;

public class Reguler extends Customer{
	private int queue;
	public Reguler(String name, String gender, String phoneNumber, String status, String loyaltyCardID,
			Integer points, int queue) {
		super(name, gender, phoneNumber, status, loyaltyCardID, points);
		this.queue = queue;
		// TODO Auto-generated constructor stub
	}
	public int getQueue() {
		return queue;
	}
	public void setQueue(int queue) {
		this.queue = queue;
	}
	@Override
	public int generatePoint() {
		int currentPoint = (int) (Math.random() * (this.getName().length())) + 1;
		return currentPoint;
	}
}
