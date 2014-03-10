/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Template s
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;


/**
 *
 * @author AArobotics
 */
public class LaunchCatapult extends CommandBase {
    
    private Timer fireTimer = new Timer();
    private Timer failSafe = new Timer();
    double fireLimit = 3.0;
    
   
    public LaunchCatapult() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(catapult);
        requires(roller);
        
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       //roller.Down();
       catapult.retract();
       failSafe.reset();
       failSafe.start();
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        catapult.fire();
        fireTimer.delay(0.5);
        catapult.retract();
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(!catapult.isSet())//|| failSafe.get() > fireLimit)
        {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        failSafe.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
