/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 *
 * @author Developer
 */
public class DriveTrain extends Subsystem {

    public static DriveTrain instance;
    RobotDrive drive;
    AnalogChannel ultrasonic;
    Gyro gyroscope;
    PIDController drivePID;
    PIDController turnPID;
    Jaguar dummyPID;
    
    public static boolean ReverseDrive = false;
    
    public static final double sonarConversion = 0.009765;

    private static final double driveKp = 0.22;
    private static final double driveKi = 0.0;
    private static final double driveKd = 0.0;
    
    private static final double turnKp = 0.01;
    private static final double turnKi = 0.0;
    private static final double turnKd = 0.0;

    public static DriveTrain getInstance()
    {
        if(instance == null)
            instance = new DriveTrain();
    
        return instance;
    }
    
    private DriveTrain() {
        super("DriveTrain");
       
        drive = new RobotDrive(new Jaguar(RobotMap.LeftFront), new Jaguar(RobotMap.LeftBack), 
                                    new Jaguar(RobotMap.RightFront), new Jaguar(RobotMap.RightBack));
        drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        
        ultrasonic = new AnalogChannel(RobotMap.Ultrasonic);
        gyroscope = new Gyro(RobotMap.Gyro);
        
        dummyPID = new Jaguar(10);
        
        ultrasonic.setVoltageForPID(true);
        
        //don't assign an output; we'll call get() and assign it to motors directly
        drivePID = new PIDController(driveKp, driveKi, driveKd, ultrasonic, dummyPID);
        turnPID = new PIDController(turnKp, turnKi, turnKd, gyroscope, dummyPID);
        
        //turn should be continuous, so we turn efficiently
        turnPID.setContinuous(true);
        
        LiveWindow.addActuator("Drive Train PID", "Ultrasonic Controller", drivePID);
        LiveWindow.addActuator("Drive Train PID", "Gyroscope Controller", turnPID);
        LiveWindow.addSensor("Ultrasonic", "Ultrasonic", ultrasonic);
        
    }
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new JoystickDrive());
    }
    
    public void drive(double LeftSpeed, double RightSpeed)
    {
      if(ReverseDrive = true)
        drive.tankDrive(-LeftSpeed, -RightSpeed);
      else
        drive.tankDrive(LeftSpeed, RightSpeed);
    }
    
    public void mecanumDrive(double X, double Y, double Rotation, double Gyro)
    {
        drive.mecanumDrive_Cartesian(X, Y, Rotation, Gyro);
    }
    
    public void Strafe(double X)
    {
       drive.mecanumDrive_Cartesian(X, 0, 0, 0);
    }
    
    public void ExtendedTankDrive(double Left, double Right, double Strafe)
    {
      if(ReverseDrive == false)
      {
          if(Strafe < 0.1 && Strafe > -0.1)
            drive.tankDrive(Right, -Left);
        else
            drive.mecanumDrive_Cartesian(-Strafe, 0, 0, 0);
      }
      
      else
      {
        if(Strafe < 0.1 && Strafe > -0.1)
            drive.tankDrive(Left, -Right);
        else
            drive.mecanumDrive_Cartesian(Strafe, 0, 0, 0);
      }
    }
    
    public PIDController getDrivePID()
    {
        return drivePID;
    }
    
    public PIDController getTurnPID()
    {
        return turnPID;
    }
    
    public void drivePID()
    {
        double output;
        
        output = drivePID.get();
        SmartDashboard.putNumber("PID Out", output);
        drive.mecanumDrive_Cartesian(0.0, output, 0.0, 0.0);
    }
    
    public void turnPID()
    {
        double output;
        
        output = turnPID.get();
        
        drive.mecanumDrive_Cartesian(0.0, 0.0, output, 0.0);
    }  
 
    public double getDistance()
    {
       return(ultrasonic.getVoltage() / sonarConversion);
    }
           
    public double getAngle()
    {
       return gyroscope.getAngle();
    }
    
    public void resetGyro()
    {
        gyroscope.reset();
    }
}
