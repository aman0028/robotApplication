package org.robot;

public class Main 
{
	public static void main(String[] args) {
		RobotAttribute robotAttribute = new RobotAttributeImpl();
//		robotAttribute.walk(2);
//		robotAttribute.carry(4.0);
//		robotAttribute.walk(1);
//		robotAttribute.walkAndCarry(1.0, 2.0);
//		robotAttribute.rechargeBattery(91.4);
//		robotAttribute.walk(2);
//		robotAttribute.carry(5.0);
//		robotAttribute.walk(1);
//      robotAttribute.barCodeScanner("");
		
		robotAttribute.walk(3.5); //battery spend 70%
		robotAttribute.walkAndCarry(2.0, 3.0); //Can't walk so no battery spent
		robotAttribute.carry(12.0); //can't carry more than 10 kg, so no battery spent
		robotAttribute.batteryStatus();
		
		
	}
}
