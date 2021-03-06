/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Developer
 */
public class DriveForTime extends CommandBase {
    
    Timer driveTime;
    double time;
    
    public DriveForTime(double time) {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
        
        this.time = time;
        driveTime = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTime.reset();
        driveTime.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.mecanumDrive(0.0, -0.5, 0.0, 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (driveTime.get() > time)
        {
            return true;
        }
        
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        drivetrain.drive(0, 0);
    }
}
