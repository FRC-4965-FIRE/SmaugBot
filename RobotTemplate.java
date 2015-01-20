/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {

    Command autonomousCommand;
    Command teleopCommand;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public void robotTemplate() 
    {
        Watchdog.getInstance().setExpiration(5);
    }
    
    public void robotInit() 
    {
        // Initialize all subsystems
        CommandBase.init();
        teleopCommand = new JoystickDrive();
        CommandBase.roller.Down();
        CommandBase.catapult.fire();
        CommandBase.roller.Up();
        
        autonomousCommand = new DriveForTime(1.5);
        
        //SmartDashboard.putData("To Distance", autonomousCommand);
    }

    public void autonomousInit() 
    {
        CommandBase.drivetrain.resetGyro();
        Watchdog.getInstance().setEnabled(false);
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit() 
    {
        CommandBase.drivetrain.resetGyro();
        Watchdog.getInstance().setEnabled(true);
        autonomousCommand.cancel();
        Scheduler.getInstance().add(teleopCommand);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        CommandBase.driverLCD.clear();
        SmartDashboard.putNumber("Gyro Value", CommandBase.drivetrain.getAngle());
        SmartDashboard.putNumber("Distance", CommandBase.drivetrain.getDistance());
        Watchdog.getInstance().feed();
        Scheduler.getInstance().run();
    }
    
    public void disabledInit()
    {
        System.out.println("New disabled running");
        Scheduler.getInstance().add(teleopCommand);
        Timer.delay(0.1);
    }
    
    public void disabledPeriodic()
    {
       Watchdog.getInstance().feed();
       Scheduler.getInstance().run();
    }
    
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
