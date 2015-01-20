package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.*;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
import edu.wpi.first.wpilibj.DriverStationLCD;





/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
  
   public static DriveTrain drivetrain;
   public static Catapult catapult;
   public static Roller roller;
   public static AirCompressor compressor;
   public static Oculory camera;
   
   public static DriverStationLCD driverLCD;
    
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        drivetrain = DriveTrain.getInstance();
        catapult = Catapult.getInstance();
        roller = Roller.getInstance();
        compressor = AirCompressor.getInstance();
        //camera = Oculory.getInstance();
        
        driverLCD = DriverStationLCD.getInstance();
        compressor.start();
        
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(drivetrain);
      
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super("JoystickDrive");
    }
}
