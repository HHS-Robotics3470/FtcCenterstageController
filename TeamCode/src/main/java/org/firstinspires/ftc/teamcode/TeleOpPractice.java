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
    public void runOpMode(){

        robot.init();
        waitForStart();

        while (opModeIsActive()){

            telemetry.addData("status","started");

            if (robot.touchSensor.isPressed()) {
                telemetry.addData("Touch Sensor", "Is Pressed");
            } else {
                telemetry.addData("Touch Sensor", "Is Not Pressed");
            }
            telemetry.update();

            if (gamepad1.dpad_up){
                robot.raiseLift();
            } else if (gamepad1.dpad_down) {
                robot.lowerLift();
            } else {
                robot.stopLift();
            }

        }
    }





}
