/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Developer
 */
public class Autonomous extends CommandBase {
    
    Timer timeout = new Timer();
    Timer waitTimer = new Timer();
    public boolean targetFound = false;
    
    public Autonomous() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
       // requires(camera);
        requires(catapult);
        requires(ultrasonic);
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timeout.start();
        //camera.setBrightness(20);
        //camera.setLight(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        while (!targetFound && timeout.get() < 2.0)
//            targetFound = camera.getTarget();
        
        if(targetFound)
            catapult.fire();
        else
        {
            waitTimer.delay(3.0);
            catapult.fire();
        }
        
        while(ultrasonic.GetDistance() > 50)
           drivetrain.mecanumDrive(0, .75, 0, 0);
        
        drivetrain.mecanumDrive(0, 0, 0, 0);
        
        catapult.retract();
        
        waitTimer.delay(10.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
//        camera.setBrightness(80);
     //   camera.setLight(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
