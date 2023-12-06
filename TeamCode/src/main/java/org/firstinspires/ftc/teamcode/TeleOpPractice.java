package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TestOpMode", group="blah")
public class TeleOpPractice extends LinearOpMode {

    robotHardware robot = new robotHardware(this);
    public boolean ifLaunched = false;
    public boolean ifLifted = false;
    public boolean xState = false;
    public boolean yState = false;
    public boolean y2State = false;
    public boolean bState = false;
    public boolean aState = false;
    public boolean a2State = false;
    public boolean ifOpen = false;
    public boolean ifClawOpened = false;
    public boolean ifRolled = false;
    public boolean ifHooked = false;
    public boolean rstate = false;
    public boolean ifGround = false;
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
                ifClawOpened +","+robot.mover.getPosition()+","+robot.gears.getPosition()+",ifMirror);";
    }
    @Override
    public void runOpMode() {

        robot.init();

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("status", "started");
            telemetry.addData("Gears Servo Position", robot.gears.getPosition());
            telemetry.addData("Dropper Servo Position", robot.dropper.getPosition());
            telemetry.addData("Bomber Servo Position", robot.bomber.getPosition());
            telemetry.addData("Mover Servo Position", robot.mover.getPosition());
            telemetry.addData("Hook Servo Position", robot.hook.getPosition());
            telemetry.addData("Claw Servo Position", robot.claw.getPosition());
            telemetry.addData("Roller Servo Position", robot.roller.getPosition());
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
            if (gamepad1.right_bumper) {
                robot.lowerLift();
            } else if (gamepad1.left_bumper) {
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




            if (gamepad2.y && !yState) {

                robot.nine_eleven(ifLaunched);
                ifLaunched = !ifLaunched;
                yState = true;
            } else if (!gamepad2.y && yState) {
                yState = false;
            }

            if (gamepad2.b && !y2State) {

                robot.hookRobot(ifHooked);
                ifHooked = !ifHooked;
                yState = true;
            } else if (!gamepad2.b && y2State) {
                y2State = false;
            }


            if (gamepad1.x && !xState) {
                robot.lift_pixel(ifLifted);
                ifLifted = !ifLifted;
                xState = true;
            } else if (!gamepad1.x && xState) {
                xState = false;
            }


            if (gamepad1.b && !bState) {
                robot.releasePixel(ifOpen);
                ifOpen = !ifOpen;
                bState = true;
            } else if (!gamepad1.b && bState) {
                bState = false;
            }





            Logging.log(currentPos());
        }


    }
}