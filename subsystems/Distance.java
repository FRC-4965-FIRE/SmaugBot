/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;

/**
 *
 * @author AArobotics
 */
public class Distance extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public static Distance instance;
    AnalogChannel ultrasonic;
    
    public static Distance getInstance()
    {
        if(instance == null)
            instance = new Distance();
        
        return instance;
        
    }
    
    private Distance()
    {
        ultrasonic = new AnalogChannel(RobotMap.Ultrasonic);
    }
    
    public double GetDistance()
    {
        //returns the sonar reading in cm
        return (ultrasonic.getVoltage() / .009765);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
