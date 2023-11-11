package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Logging;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.FormatterClosedException;

@TeleOp(name="TestOpMode", group="blah")
public class TeleOpPractice extends LinearOpMode {

    robotHardware robot = new robotHardware(this);
    public boolean ifLaunched = false;
    public boolean ifLifted = false;
    public boolean xState = false;
    public boolean yState = false;
    public boolean bState = false;
    public boolean ifOpen = false;
    public boolean ifopened = false;
    public boolean rstate = false;
    public int markerNum = 0;


    public TeleOpPractice() throws Exception
    {
        Logging.setup();
        Logging.log("Starting Drive Circle Logging");
    }



    public String currentPos()
    {
        return "robot.setMovementPosition("+robot.fLeft.getCurrentPosition()+","+robot.fRight.getCurrentPosition()+
               ","+robot.bLeft.getCurrentPosition()+","+robot.bRight.getCurrentPosition()+","+robot.rLift.getCurrentPosition()+","+robot.lLift.getCurrentPosition()+","+
                ifopened+","+robot.mover.getPosition()+","+robot.roller.getCurrentPosition()+"ifMirror"+");";
    }
    @Override
    public void runOpMode() {

        robot.init();

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("status", "started");
            telemetry.addData("Servo Position", robot.getServoPosition());
            telemetry.update();

            ifopened = false;
/*
            if (robot.touchSensor.isPressed()) {
                telemetry.addData("Touch Sensor", "Is Pressed");
            } else {
                telemetry.addData("Touch Sensor", "Is Not Pressed");
            }
            telemetry.update();
            if
*/
            //instanciation and then passing the control through
            robot.driveRobot(gamepad1);
            robot.rollerMove(gamepad1);

            //lift code
            if (gamepad1.right_bumper) {
                robot.lowerLift();
            } else if (gamepad1.left_bumper) {
                robot.raiseLift();
            } else {
                robot.stopLift();
            }

            //call to roller function if button pressed
            if (gamepad1.dpad_up){
                robot.grabberMove(gamepad1.dpad_up);
            }
            else if(!gamepad1.dpad_up){
                robot.grabberMove(gamepad1.dpad_up);
            }

            if (gamepad2.y && !rstate)
            {
                Logging.log("//Marker " + markerNum );
                markerNum++;
                rstate = true;
            }
            else if (!gamepad2.y && rstate) {
                rstate = false;
            }


            if (gamepad1.a){
                robot.rollerMove(gamepad1);
            }


//            if (gamepad1.y){
//                robot.nine_eleven(ifLaunched);
//                ifLaunched = !ifLaunched;
//                //robot.nine_eleven(ifLaunched);
//            }

            if (gamepad1.y && !yState) {

                robot.nine_eleven(ifLaunched);
                ifLaunched = !ifLaunched;
                yState = true;
            } else if (!gamepad1.y && yState) {
                yState = false;
            }

//            if (gamepad1.x){
//                robot.lift_pixel(ifLifted);
//                ifLifted = !ifLifted;
//            }

            if (gamepad1.x && !xState) {
                robot.lift_pixel(ifLifted);
                ifLifted = !ifLifted;
                xState = true;
            } else if (!gamepad1.x && xState) {
                xState = false;
            }

//            if(gamepad1.b){
//                robot.releasePixel();
//            }

            if (gamepad1.b && !bState) {
                robot.releasePixel(ifOpen);
                ifOpen = !ifOpen;
                ifopened = true;
                bState = true;
            } else if (!gamepad1.b && bState) {
                bState = false;
            }

            Logging.log(currentPos());
        }


    }
}