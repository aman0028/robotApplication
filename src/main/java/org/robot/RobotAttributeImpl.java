package org.robot;

import java.text.NumberFormat;

public class RobotAttributeImpl implements RobotAttribute {
	
	private Robot robot;
	private NumberFormat nf = NumberFormat.getInstance();
	
	public RobotAttributeImpl(){
		this.robot = new Robot();
	}

	public boolean walk(double distance) 
	{
		//As per the rule, in 100% battery, robot can walk 5 KM MAX
		double batterySpent = distance * 100/5;
		if(robot.getRobotHeath().isCharged(robot, batterySpent))
		{
			System.out.println("Robot walked "+ distance + " km. Battery spent : "+ batterySpent +"%. Remaining battery: "+ robot.getBatteryStatus()+"%.");
		    System.out.println("<------------------>");
		    System.out.println();
		    return true;
		}
		return false;
	}

	public boolean carry(double weight) 
	{
		//As per the rule, Robot spend 2% extra battery per KG of weight carry
		double batterySpent = weight*2;
		if(!robot.getRobotHeath().isOverWeight(robot, weight))
		{
		    if(robot.getRobotHeath().isCharged(robot, batterySpent))
			{
		    	double robotCurrentTotalWeight = robot.getCurrentWeightCapacity() + weight;
				robot.setCurrentWeightCapacity(robotCurrentTotalWeight);
				nf.setMaximumFractionDigits(2);
			    System.out.println("Robot carries weight "+ robot.getCurrentWeightCapacity() + " Kg. Battery spent :"+ batterySpent +"%. Remaining battery: "+ nf.format(robot.getBatteryStatus())+"%.");
			    System.out.println("<------------------>");
			    System.out.println();
			    return true;
			}
		}
		return false;
	}

	public boolean walkAndCarry(double distance, double weight) 
	{
		//As per the rule, in 100% battery, robot can walk 5 KM MAX
		//As per the rule, Robot spend 2% extra battery per KG of weight carry
		double batterySpent = weight*2 + distance*100/5;
		if(!robot.getRobotHeath().isOverWeight(robot, weight))
		{
		    if(robot.getRobotHeath().isCharged(robot, batterySpent))
			{
		    	double robotCurrentTotalWeight = robot.getCurrentWeightCapacity() + weight;
				robot.setCurrentWeightCapacity(robotCurrentTotalWeight);
				nf.setMaximumFractionDigits(2);
			    System.out.println("Robot walked distance " + distance  + "km and carries weight "+ robot.getCurrentWeightCapacity() + " Kg. Battery spent :"+ batterySpent +"%. Remaining battery: "+ nf.format(robot.getBatteryStatus())+"%.");
			    System.out.println("<------------------>");
			    System.out.println();
			    return true;
			}
		}
		return false;
	}

	public boolean barCodeScanner(String barCode) 
	{
		if(barCode == null || barCode.isEmpty())
		{
			System.out.println("barcode Scan Failure");
		    System.out.println("<------------------>");
		    System.out.println();
		    return false;
		}
		
		try
		{
			Integer.parseInt(barCode);
			nf.setMaximumFractionDigits(2);
			System.out.println("Robot Price : Rs: " + nf.format(robot.getPrice()));
			System.out.println("<------------------>");
			System.out.println();
		}
		catch(NumberFormatException nfe)
		{
			System.out.println("barcode Scan Failure");
			System.out.println("<------------------>");
			System.out.println();
			return false;
		}
		return true;
	}

	public boolean rechargeBattery(double chargingPercentage) 
	{
		if(robot.getBatteryStatus() == robot.MAX_BATTERY_INITIAL_CAPACITY)
		{
			return false;
		}
		else if(robot.getBatteryStatus()+chargingPercentage > robot.MAX_BATTERY_INITIAL_CAPACITY)
		{
			robot.setBatteryStatus(robot.MAX_BATTERY_INITIAL_CAPACITY);
		}
		else
		{
		    robot.setBatteryStatus(robot.getBatteryStatus()+ chargingPercentage);
		}
		
		if(robot.getBatteryStatus()>robot.MIN_BATTERY_TO_TRIGGER_HEAD_ALERT)
		{
		   robot.setHeadLED(RobotReaction.GREEN);
		   System.out.println("Robot headlight back to ---> ["+ robot.getHeadLED()+"]");
		}
		nf.setMaximumFractionDigits(2);
		System.out.println("Robot battery charged. Battery Status: " + nf.format(robot.getBatteryStatus()) + "%.");
		System.out.println("<------------------>");
		System.out.println();
		
		return true;

	}

	public double batteryStatus() {
		System.out.println("Robot battery remaining is : "+ robot.getBatteryStatus() +"%");
		return robot.getBatteryStatus();
	}

}
