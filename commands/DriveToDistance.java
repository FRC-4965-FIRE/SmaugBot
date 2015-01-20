/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Developer
 */
public class DriveToDistance extends CommandBase 
{    
    double setpoint;
    
    public DriveToDistance(double setpoint) 
    {    
        requires(drivetrain);
        
        this.setpoint = setpoint;       
     }
        
    // Called just before this Command runs the first time
    protected void initialize() 
    {
       //we do this so that we can provide setpoints in cm; in the future we may
       //make wrapper functions around the PIDControllers to encapsulate this
       //Scott's code - drivetrain.getDrivePID().setAbsoluteTolerance(2*drivetrain.sonarConversion);
       //Scott's code drivetrain.getDrivePID().setSetpoint(setpoint*drivetrain.sonarConversion);
       drivetrain.getDrivePID().setAbsoluteTolerance(2*drivetrain.sonarConversion);
       drivetrain.getDrivePID().setSetpoint(setpoint*drivetrain.sonarConversion);
       //drivetrain.getDrivePID().setOutputRange(-0.2, -0.8);
       SmartDashboard.putNumber("Start setpoint", this.setpoint);
       SmartDashboard.putNumber("DtD interrupted", 0);

       drivetrain.getDrivePID().enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        drivetrain.drivePID();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        if(drivetrain.getDrivePID().onTarget())
        {
            SmartDashboard.putNumber("Finish setpoint", drivetrain.getDrivePID().getError());
            return true; 
        }
        
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
        drivetrain.mecanumDrive(0, 0, 0, 0);
        drivetrain.getDrivePID().disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
        SmartDashboard.putNumber("DtD interrupted", 1);
        SmartDashboard.putNumber("Finish setpoint", drivetrain.getDrivePID().getError());
        this.end();
    }
}
