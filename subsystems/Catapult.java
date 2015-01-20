/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author AArobotics
 */
public class Catapult extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public static Catapult instance;
    Solenoid LeftLaunch;
    Solenoid RightLaunch;
    Solenoid LeftRetract;
    Solenoid RightRetract;
    Timer failSafe;
    double fireLimit = 3.0;

    public static Catapult getInstance() {
        if (instance == null) {
            instance = new Catapult();
        }

        return instance;
    }

    private Catapult() {
        LeftLaunch = new Solenoid(RobotMap.LeftLaunch);
        RightLaunch = new Solenoid(RobotMap.RightLaunch);
        LeftRetract = new Solenoid(RobotMap.LeftRetract);
        RightRetract = new Solenoid(RobotMap.RightRetract);
        failSafe = new Timer();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void fire() {
        LeftRetract.set(false);
        RightRetract.set(false);
        LeftLaunch.set(true);
        RightLaunch.set(true);
    }

    public void retract() {
        LeftLaunch.set(false);
        RightLaunch.set(false);
        LeftRetract.set(true);
        RightRetract.set(true);
    }

    public boolean isSet() {
        if (LeftLaunch.get() == false && RightLaunch.get() == false) {
            return true;
        }

        return false;
    }

}
