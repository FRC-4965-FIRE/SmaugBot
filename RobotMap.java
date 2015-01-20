package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
    //In order to make wiring layout clearer to the outside world,
    //define some contants that correspond to the ports themselves
    //PWM ports
    public static final int PWM_ONE = 1;
    public static final int PWM_TWO = 2;
    public static final int PWM_THREE = 3;
    public static final int PWM_FOUR = 4;
    public static final int PWM_FIVE = 5;
    public static final int PWM_SIX = 6;
    public static final int PWM_SEVEN = 7;
    public static final int PWM_EIGHT = 8;
    public static final int PWM_NINE = 9;
    public static final int PWM_TEN = 10;
    
    //Digital I/O ports
    public static final int DIO_ONE = 1;
    public static final int DIO_TWO = 2;
    public static final int DIO_THREE = 3;
    public static final int DIO_FOUR = 4;
    public static final int DIO_FIVE = 5;
    public static final int DIO_SIX = 6;
    
    //Sidecar/Spike Relay ports
    public static final int RLY_ONE = 1;
    public static final int RLY_TWO = 2;
    public static final int RLY_THREE = 3;
    public static final int RLY_FOUR = 4;
    public static final int RLY_FIVE = 5;
    public static final int RLY_SIX = 6;
    
    //Analog channels
    public static final int ANLG_ONE = 1;
    public static final int ANLG_TWO = 2;
    public static final int ANLG_THREE = 3;
    public static final int ANLG_FOUR = 4;
    public static final int ANLG_FIVE = 5;
    public static final int ANLG_SIX = 6;
    
    //Solenoid/Relay Breakout ports
    public static final int SLND_ONE = 1;
    public static final int SLND_TWO = 2;
    public static final int SLND_THREE = 3;
    public static final int SLND_FOUR = 4;
    public static final int SLND_FIVE = 5;
    public static final int SLND_SIX = 6;
    public static final int SLND_SEVEN = 7;
    public static final int SLND_EIGHT = 8;
    
    
    //Drive motor ports
    public static final int LeftFront = PWM_ONE;//J4
    public static final int RightFront = PWM_TWO;//J3
    public static final int LeftBack = PWM_THREE;//J2
    public static final int RightBack = PWM_FOUR;//J1
    
    
    //compressor 
    public static final int PressureSwitch = DIO_ONE;//DIO 1
    public static final int CompressorRelay = RLY_THREE;//Relay 3
    
    //catapult victors, solenoids, and limit switch
    public static final int LeftRetract = SLND_FOUR;//solinoids
    public static final int RightRetract = SLND_ONE;
    public static final int LeftLaunch = SLND_TWO;
    public static final int RightLaunch = SLND_THREE; 
    
    //Intake
    public static final int Roller = PWM_SEVEN;//V3
    public static final int intakeUp = SLND_FIVE;//solenoids
    public static final int intakeDown = SLND_SIX;
    
    //Gyro
    public static final int Gyro = ANLG_ONE;//Analog 1
    
    //ultrasonic
    public static final int Ultrasonic = ANLG_FOUR;//Analog 4
    
    //camera system
    public static final int lightRing = RLY_TWO;//relay 2
    public static final int camServo = 5;//pwm 5
    public static final int baseServo = 6;//pwm 6
    
    
}
