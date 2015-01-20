/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Gyro;



/**
 *
 * @author AArobotics
 */
public class Gyroscope extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public static Gyroscope instance;
    public boolean isEnabled = true;
    Gyro gyroscope;
    
    public static Gyroscope getInstance()
    {
        if(instance == null)
            instance = new Gyroscope();
        
        return instance;
        
    }
    
    private Gyroscope()
    {
        gyroscope = new Gyro(RobotMap.Gyro);
        
    }

    
    public void reset()
    {
        gyroscope.reset();
        
    }
    
    public double GetAngle()
    {
        if (isEnabled)
        {
            return gyroscope.getAngle();
        }
        else
        {
            return 0.0;
        }
        
        
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
