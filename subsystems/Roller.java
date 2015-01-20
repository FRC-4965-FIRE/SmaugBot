/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;


/**
 *
 * @author AArobotics
 */
public class Roller extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public static Roller instance;
    Solenoid LeftUp;
    Solenoid intakeUp;
    Solenoid intakeDown;
    Victor Roller;
    
    
    public static Roller getInstance()
    {
        if(instance == null)
            instance = new Roller();
        
        return instance;
    }
    
    private Roller()
    {
        intakeUp = new Solenoid(RobotMap.intakeUp);
        intakeDown = new Solenoid(RobotMap.intakeDown);
        Roller = new Victor(RobotMap.Roller);
        
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
        
    public void Up()
    {
        intakeDown.set(false);
        intakeUp.set(true);
    }
    
    public void Down()
    {
        intakeDown.set(true);
        intakeUp.set(false);
    }
    
    public void TakeIn()
    {
        Roller.set(-0.5);
    }
    
    public void SpitOut()
    {
        Roller.set(0.5);
    }
    
    public void stopRoller()
    {
        Roller.set(0);
    }
    
    public boolean isSet()
    {
        if(intakeUp.get())
        {
            return true;
        }
        
        return false;
        
    }
    
        
        
        
        
    }

