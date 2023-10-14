package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.FormatterClosedException;

@TeleOp(name="TestOpMode", group="blah")
public class TeleOpPractice extends LinearOpMode {

    robotHardware robot = new robotHardware(this);

    @Override
    public void runOpMode() {

        robot.init();
        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("status", "started");
            telemetry.update();
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
            if (gamepad1.dpad_up) {
                robot.lowerLift();
            } else if (gamepad1.dpad_down) {
                robot.raiseLift();
            } else {
                robot.stopLift();
            }

            //call to roller function if button pressed
            if (gamepad1.x){
                robot.rollerMove(gamepad1);
            }
        }


    }
}