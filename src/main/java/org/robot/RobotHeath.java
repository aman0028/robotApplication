package org.robot;

public class RobotHeath {
	
	public boolean isOverWeight(Robot robot, double weight)
	{
		double robotCurrentTotalWeight = robot.getCurrentWeightCapacity() + weight;
		if(robotCurrentTotalWeight > robot.MAX_WEIGHT_CAPCITY)
		{
		  robot.setChestLED(RobotReaction.RED);
		  System.out.println("==>Robot is Overweight. Cannot Carry. Chest LED displayed ---> ["+ RobotReaction.RED.name()+"]");
		  System.out.println("<------------------>");
		  System.out.println();
		  return true;
		}
		return false;
	}
	
	public boolean isCharged(Robot robot, double batterySpent)
	{
		if(robot.getBatteryStatus() < batterySpent)
		{
			System.out.println("==>Robot cannot walk"); //dynamic either walk or carry
		}
		else
		{
			double batteryRemaining =  robot.getBatteryStatus() - batterySpent;
			robot.setBatteryStatus(batteryRemaining);
			if(batteryRemaining< robot.MIN_BATTERY_TO_TRIGGER_HEAD_ALERT)
			{
				System.out.println("==>Headlight triggered---> [" + RobotReaction.RED.name()+"]");
			}
			return true;
		}
		return false;
	}

}
