package org.robot;

import java.util.Random;

public class Robot 
{
	
	private double price;
	private RobotReaction chestLED;
	private RobotReaction headLED;
	private double currentWeightCapacity;
	private double batteryStatus;
	public final double MAX_WEIGHT_CAPCITY = 10.0;
	public final int MAX_BATTERY_INITIAL_CAPACITY = 100;
	public final int MIN_BATTERY_TO_TRIGGER_HEAD_ALERT = 15;
	private RobotHeath robotHeath;
	Random random = new Random(100);
	
	public Robot(){
		this.price = random.nextDouble()*5*100;
		this.robotHeath = new RobotHeath();
		this.currentWeightCapacity = 0.0;
		this.batteryStatus = MAX_BATTERY_INITIAL_CAPACITY;
		this.chestLED = RobotReaction.GREEN;
		this.headLED = RobotReaction.GREEN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public RobotReaction getChestLED() {
		return chestLED;
	}

	public void setChestLED(RobotReaction chestLED) {
		this.chestLED = chestLED;
	}

	public RobotReaction getHeadLED() {
		return headLED;
	}

	public void setHeadLED(RobotReaction headLED) {
		this.headLED = headLED;
	}

	public double getCurrentWeightCapacity() {
		return currentWeightCapacity;
	}

	public void setCurrentWeightCapacity(double currentWeightCapacity) {
		this.currentWeightCapacity = currentWeightCapacity;
	}

	public double getBatteryStatus() {
		return batteryStatus;
	}

	public void setBatteryStatus(double batteryStatus) {
		this.batteryStatus = batteryStatus;
	}

	public RobotHeath getRobotHeath() {
		return robotHeath;
	}

	public void setRobotHeath(RobotHeath robotHeath) {
		this.robotHeath = robotHeath;
	}
}
