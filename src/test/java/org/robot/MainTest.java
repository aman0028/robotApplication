package org.robot;

import org.junit.Assert;
import org.junit.Test;

public class MainTest 
{
	private RobotAttribute robotAttribute;

	@Test
	public void robotWalkTest() {
		robotAttribute = new RobotAttributeImpl();
		robotAttribute.walk(2);
		Assert.assertTrue("Robot can't walk", robotAttribute.walk(1));
		robotAttribute.rechargeBattery(10);
		Assert.assertFalse("Robot can't walk", robotAttribute.walk(5));
	}
	
	@Test
	public void robotCarryTest() {
		robotAttribute = new RobotAttributeImpl();
		robotAttribute.carry(2);
		Assert.assertTrue("Robot can carry", robotAttribute.carry(5));
		robotAttribute.rechargeBattery(30);
		Assert.assertFalse("Robot overweight", robotAttribute.carry(5));
	}
	
	@Test
	public void robotWalkAndCarryTest() {
		robotAttribute = new RobotAttributeImpl();
		robotAttribute.walkAndCarry(3,4);
		Assert.assertTrue("Robot can walk and carry", robotAttribute.walkAndCarry(1, 3));
		robotAttribute.rechargeBattery(30);
		Assert.assertFalse("Robot can't walk and carry", robotAttribute.walkAndCarry(3, 5));
	}
	
	@Test
	public void robotBatteryTest() {
		robotAttribute = new RobotAttributeImpl();
		robotAttribute.walk(3);
		Assert.assertTrue("Robot will charge", robotAttribute.rechargeBattery(60));
		Assert.assertFalse("Robot can't charge", robotAttribute.rechargeBattery(10));
	}
	
	@Test
	public void robotBarCodeTest() {
		robotAttribute = new RobotAttributeImpl();
		Assert.assertTrue("Robot can read barcode", robotAttribute.barCodeScanner("231234"));
		Assert.assertFalse("Robot can't read barcode", robotAttribute.barCodeScanner(null));
		Assert.assertFalse("Robot can't read barcode", robotAttribute.barCodeScanner("23REDF"));
		Assert.assertFalse("Robot can't read barcode", robotAttribute.barCodeScanner("!@#$^"));
	}
	
}

