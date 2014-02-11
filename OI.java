
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.commands.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    Joystick controller = new Joystick(1);
    
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
        if (controller.getY() < 0.2 && controller.getY() > -0.2)
        {
            return 0.0;
        }
        return controller.getY();
    }
}

