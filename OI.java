
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.buttons.*;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
    Joystick controller = new Joystick(1);
    Joystick controllerTwo = new Joystick(2);
    Button btnOne = new JoystickButton(controller, 1);
    Button btnTwo = new JoystickButton(controller, 2);
    Button btnThree = new JoystickButton(controller, 3);
    Button btnFour = new JoystickButton(controller, 4);
    Button btnFive = new JoystickButton(controller, 5);
    Button btnSix = new JoystickButton(controller, 6);
    
    Button JoyTwoOne = new JoystickButton(controllerTwo, 1);
    Button JoyTwoTwo = new JoystickButton(controllerTwo, 2);
    Button JoyTwoThree = new JoystickButton(controllerTwo, 3);
    Button JoyTwoFour = new JoystickButton(controllerTwo, 4);
    Button JoyTwoFive = new JoystickButton(controllerTwo, 5);
    Button JoyTwoSix = new JoystickButton(controllerTwo, 6);
    
    
    
    
    
    
    
    
    public OI()
    {
        JoyTwoFive.whileHeld(new LaunchCatapult());
        JoyTwoTwo.whileHeld(new TakeIn());
        JoyTwoThree.whileHeld(new SpitOut());
        JoyTwoOne.whenPressed(new RollerUp());
        JoyTwoFour.whenPressed(new RollerDown());
        //btnOne.whileHeld(new RetractCatapult());
        //btnSix.whenPressed(new EnableGyro());
        //btnTwo.whenPressed(new ResetGyro());
        //btnThree.whenPressed(new TurnToAngle(0));
        //btnFour.whenPressed(new AutoTarget());
        //btnOne.whenPressed(new DriveToDistance(50));
        btnOne.whenPressed(new ReverseDrive());
        
        
        
    }
    
   //joystick drive commands
    public double leftStickY()
    {
        if (controller.getY() < 0.2 && controller.getY() > -0.2)
        {
            return 0.0;
        }
        return controller.getY();
    }
    public double rightStickY()
    {
        if (controller.getRawAxis(5) < 0.2 && controller.getRawAxis(5) > -0.2)
        {
            return 0.0;
        }
        return controller.getRawAxis(5);
    }
    
    public double leftStickX()
    {
        if (controller.getX() < 0.2 && controller.getX() > -0.2)
        {
            return 0.0;
        }
        return controller.getX();
    }
    
    public double Twist()
    {
        if (controller.getRawAxis(3) < 0.3 && controller.getRawAxis(3) > -0.3)
        {
            return 0.0;
        }
        
        return controller.getRawAxis(3);
    }
    
        }
    


