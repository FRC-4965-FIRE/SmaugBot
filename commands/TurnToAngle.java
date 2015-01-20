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
public class TurnToAngle extends CommandBase {
    
    double setpoint;
    
    public TurnToAngle(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drivetrain);
        
        this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drivetrain.getTurnPID().setAbsoluteTolerance(2.0);
        drivetrain.getTurnPID().setSetpoint(setpoint);
        drivetrain.getTurnPID().enable();
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.turnPID();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(drivetrain.getTurnPID().onTarget())
            return true;
        
        
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.mecanumDrive(0, 0, 0, 0);
        drivetrain.getTurnPID().disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        drivetrain.mecanumDrive(0, 0, 0, 0);
        drivetrain.getTurnPID().disable();
    }
}
