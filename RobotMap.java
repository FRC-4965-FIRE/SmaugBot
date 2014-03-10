package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1
    
    //Drive motor ports
    public static final int LeftFront = 1;//J4
    public static final int RightFront = 2;//J3
    public static final int LeftBack = 3;//J2
    public static final int RightBack = 4;//J1
    
    
    //compressor 
    public static final int PressureSwitch = 1;//DIO 1
    public static final int CompressorRelay = 3;//Relay 3
    
    //catapult victors, solenoids, and limit switch
    public static final int Retract = 5;//V1
    public static final int Retract2 = 6;//V2
    public static final int Limit = 2;//DIO 2
    public static final int CatapultRelease = 4;//solenoids
    public static final int CatapultEngage = 1;
    
    //Intake
    public static final int Roller = 7;//V3
    public static final int intakeUp = 2;//solenoids
    public static final int intakeDown = 3;
    
    //Gyro
    public static final int Gyro = 1;//Analog 1
    
    //ultrasonic
    public static final int Ultrasonic = 6;//Analog 6
    
    //camera system
    public static final int lightRing = 2;//relay 2
    public static final int camServo = 5;//pwm 5
    public static final int baseServo = 6;//pwm 6
    
    
}
