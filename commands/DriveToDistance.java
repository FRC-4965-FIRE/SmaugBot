/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Developer
 */
public class DriveToDistance extends CommandBase {
    
    double setpoint;
    
    public DriveToDistance(double setpoint) {
        
        
        requires(drivetrain);
        requires(ultrasonic);
      
        this.setpoint = setpoint;
            
     }
        
        
        
    

    // Called just before this Command runs the first time
    protected void initialize() {
       
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.mecanumDrive(.75, 0, 0, 0);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(ultrasonic.GetDistance() < setpoint)
            return true;
        
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.mecanumDrive(0, 0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        drivetrain.mecanumDrive(0, 0, 0, 0);
    }
}
