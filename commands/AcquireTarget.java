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
public class AcquireTarget extends CommandBase {
    
    public boolean targetFound = false;
    double waitTime = 2.0;
    Timer timeout = new Timer();
    
    public AcquireTarget() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//        requires(camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timeout.start();
//        camera.setBrightness(20);
//        camera.setLight(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putString("Target command", "ran");
//        targetFound = camera.getTarget();
        SmartDashboard.putBoolean("Target Found", targetFound);
    }

    //Allow the camera 2 seconds to find a target, move on otherwise.
    protected boolean isFinished() {
        if (targetFound || timeout.get() > waitTime)
            return true;
        
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        timeout.stop();
//        camera.setBrightness(80);
  //      camera.setLight(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
