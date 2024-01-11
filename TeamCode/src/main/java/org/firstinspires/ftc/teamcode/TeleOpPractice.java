package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name="TestOpMode", group="blah")
public class TeleOpPractice extends LinearOpMode {

    robotHardware robot = new robotHardware(this);
    public boolean ifLaunched = false;
    public boolean ifLifted = false;
    public boolean xState = false;
    public boolean y2State = false;
    public boolean b2State = false;
    public boolean bState = false;
    public boolean aState = false;
    public boolean a2State = false;
    public boolean ifOpen = false;
    public boolean ifClawOpened = false;
    public boolean ifRolled = false;
    public boolean ifHooked = false;
    public boolean rstate = false;
    public boolean ifDrop = false;
    public int markerNum = 0;


    public TeleOpPractice() throws Exception
    {
        Logging.setup();
        Logging.log("Starting Drive Circle Logging");
    }



    public String currentPos(Gamepad gamepad1)
    {
        return "robot.setMovementPosition("+gamepad1.left_stick_y+","+gamepad1.left_stick_x+","+gamepad1.right_stick_x+","+robot.fLeft.getCurrentPosition()+","+robot.fRight.getCurrentPosition()+
                ","+robot.bLeft.getCurrentPosition()+","+robot.bRight.getCurrentPosition()+","+robot.rLift.getCurrentPosition()+","+robot.lLift.getCurrentPosition()+","+
                ifDrop +","+robot.mover.getPosition()+","+robot.gears.getPosition()+","+robot.claw.getPosition()+","+robot.roller.getPosition()+",ifMirror);";
    }
    @Override
    public void runOpMode() {

        robot.init();

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("status", "started");
            telemetry.addData("encoder test pos", robot.cWheel.getCurrentPosition());
            telemetry.addData("Gears Servo Position", robot.gears.getPosition());
            telemetry.addData("Dropper Servo Position", robot.dropper.getPosition());
            telemetry.addData("Bomber Servo Position", robot.bomber.getPosition());
            telemetry.addData("Mover Servo Position", robot.mover.getPosition());
            telemetry.addData("Hook Servo Position", robot.hook.getPosition());
            telemetry.addData("Claw Servo Position", robot.claw.getPosition());
            telemetry.addData("Roller Servo Position", robot.roller.getPosition());
            telemetry.addData("lift", robot.rLift.getCurrentPosition());
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


            //lift code
            if (gamepad2.right_bumper) {
                robot.lowerLift();
            } else if (gamepad2.left_bumper) {
                robot.raiseLift();
            } else {
                robot.stopLift();
            }

            //call to roller function if button pressed
            if (gamepad2.dpad_up){
                robot.grabberMove(gamepad2.dpad_up);
            }
            else if(gamepad2.dpad_down){
                robot.grabberMoveDown(gamepad2.dpad_down);
            }
            else if(!gamepad2.dpad_up){
                robot.grabberMove(gamepad2.dpad_up);
            }






            if (gamepad1.a && !aState) {


                ifClawOpened = robot.useClaw(ifClawOpened);
                aState = true;
            } else if (!gamepad1.a && aState) {
                aState = false;
            }

            if (gamepad2.a && !a2State) {

                robot.useRoller(ifRolled);
                ifRolled = !ifRolled;
                a2State = true;
            } else if (!gamepad2.a && a2State) {
                a2State = false;
            }




            if (gamepad2.y && !y2State) {

                robot.nine_eleven(ifLaunched);
                ifLaunched = !ifLaunched;
                y2State = true;
            } else if (!gamepad2.y && y2State) {
                y2State = false;
            }

            if (gamepad2.b && !b2State) {

                robot.hookRobot(ifHooked);
                ifHooked = !ifHooked;
                b2State = true;
            } else if (!gamepad2.b && b2State) {
                b2State = false;
            }


            if (gamepad2.x && !xState) {
                robot.lift_pixel(ifLifted);
                ifLifted = !ifLifted;
                xState = true;
            } else if (!gamepad2.x && xState) {
                xState = false;
            }


            if (gamepad1.b && !bState) {
                robot.releasePixel(ifOpen);
                ifOpen = !ifOpen;
                ifDrop = true;
                bState = true;
            } else if (!gamepad1.b && bState) {
                bState = false;
            }





            Logging.log(currentPos(gamepad1));
            ifDrop = false;
        }


    }
}