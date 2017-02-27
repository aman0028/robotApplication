package org.robot;

public interface RobotAttribute {
	
	public boolean walk(double distance);
	public boolean carry(double weight);
	public boolean walkAndCarry(double distance, double weight);
	public boolean barCodeScanner(String barCode);
	public boolean rechargeBattery(double chargingPercentage);
	public double batteryStatus();

}
