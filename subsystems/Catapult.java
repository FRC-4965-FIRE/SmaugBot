/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Timer;


/**
 *
 * @author AArobotics
 */
public class Catapult extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public static Catapult instance;
    Solenoid Launch;
    Solenoid Lock;
    DigitalInput Limit;
    Victor Retract;
    Timer failSafe;
    double fireLimit = 3.0;
   
    public static Catapult getInstance()
    {
        if(instance == null)
           instance = new Catapult();
           
        return instance;
    }
    
    private Catapult()
    {
        Launch = new Solenoid(RobotMap.CatapultRelease);
        Lock = new Solenoid(RobotMap.CatapultEngage);
        Retract = new Victor(RobotMap.Retract);
        Limit = new DigitalInput(RobotMap.Limit);
        failSafe = new Timer();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void fire()
    {
        Lock.set(false);
        Launch.set(true);
    }
    
    public void retract()
    {
      Launch.set(false);
      Lock.set(true);
      failSafe.reset();
      failSafe.start();
      
      while(isSet() && failSafe.get() < fireLimit)
      {
         Retract.set(0.30);
         Timer.delay(0.05);
      }
      
      Retract.set(0);
      failSafe.stop();
              
    }
          
    
    public void stopRetract()
    {
         Retract.set(0);
    }
    
    public boolean isSet()
    {
        if (Limit.get() == false)
            return true;    
        
        return false;
    }
    
}
