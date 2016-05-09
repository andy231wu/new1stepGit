package au.com.new1step.apps.rover;

public class Plateau {
	private int maxPosX;
	private int maxPosY;
	private int minPosX;
	private int minPosY;
	
	public Plateau(int maxPosX, int maxPosY){
		this.minPosX = 0;
		this.minPosY = 0;
		this.maxPosX = maxPosX;
		this.maxPosY = maxPosY;
	}
	
	public Plateau(int minPosX, int minPosY, int maxPosX, int maxPosY){
		this.minPosX = minPosX;
		this.minPosY = minPosY;
		this.maxPosX = maxPosX;
		this.maxPosY = maxPosY;
	}
	
	public int getMaxPosX() {
		return maxPosX;
	}
	public void setMaxPosX(int maxPosX) {
		this.maxPosX = maxPosX;
	}
	public int getMaxPosY() {
		return maxPosY;
	}
	public void setMaxPosY(int maxPosY) {
		this.maxPosY = maxPosY;
	}
	public int getMinPosX() {
		return minPosX;
	}
	public void setMinPosX(int minPosX) {
		this.minPosX = minPosX;
	}
	public int getMinPosY() {
		return minPosY;
	}
	public void setMinPosY(int minPosY) {
		this.minPosY = minPosY;
	}
	
}
