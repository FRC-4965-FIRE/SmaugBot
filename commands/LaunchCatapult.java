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
   
    public LaunchCatapult() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(catapult);
        }

    // Called just before this Command runs the first time
    protected void initialize() {
       catapult.fire();
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        catapult.retract();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        catapult.retract();
    }
}
