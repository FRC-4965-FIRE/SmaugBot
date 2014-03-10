/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Compressor;


/**
 *
 * @author AArobotics
 */
public class AirCompressor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public static AirCompressor instance;
    Compressor compressor;
    
    
 public static AirCompressor getInstance()
 {
     if(instance == null)
         instance = new AirCompressor();
    
     return instance;
 }
 
 private AirCompressor()
 {
     compressor = new Compressor(RobotMap.PressureSwitch, 
                                        RobotMap.CompressorRelay);
 }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void start()
    {
        compressor.start();
    }
}
