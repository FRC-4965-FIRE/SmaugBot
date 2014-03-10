
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;


/**
 *
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public static DriveTrain instance;
RobotDrive drive;

public static DriveTrain getInstance(){
    if(instance == null)
        instance = new DriveTrain();
    
    return instance;
    
}
 
private DriveTrain(){
    drive = new RobotDrive(new Jaguar(RobotMap.LeftFront), new Jaguar(RobotMap.LeftBack), 
                                    new Jaguar(RobotMap.RightFront), new Jaguar(RobotMap.RightBack));
    drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
}

public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new JoystickDrive());
       
        
    }
public void drive(double LeftSpeed, double RightSpeed){
    drive.tankDrive(LeftSpeed, RightSpeed);
}

    public void TankDrive(double leftStickY, double rightStickY) {
       //To change body of generated methods, choose Tools | Templates.
    }
    
    public void mecanumDrive(double LeftSpeed, double RightSpeed, double Rotation, double Gyro)
    {
        drive.mecanumDrive_Cartesian(LeftSpeed, RightSpeed, Rotation, Gyro);
    }
    

}

