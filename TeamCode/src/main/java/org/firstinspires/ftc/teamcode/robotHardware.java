//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Gamepad;
//
//import org.firstinspires.ftc.robotcontroller.external.samples.RobotHardware;
//
//public class robotHardware {
//    private LinearOpMode myOpMode = null;
//    public robotHardware(LinearOpMode opMode){
//        myOpMode = opMode;
//    }
//    public DcMotor fLeft;
//    public DcMotor fRight;
//    public DcMotor bLeft;
//    public DcMotor bRight;
//
//    public void init(){
//        fLeft = myOpMode.hardwareMap.get(DcMotor.class, "fLeft");
//        fRight = myOpMode.hardwareMap.get(DcMotor.class, "fRight");
//        bLeft = myOpMode.hardwareMap.get(DcMotor.class, "bLeft");
//        bRight = myOpMode.hardwareMap.get(DcMotor.class, "bRight");
//
//        fLeft.setDirection(DcMotor.Direction.FORWARD);
//        fRight.setDirection(DcMotor.Direction.REVERSE);
//        bLeft.setDirection(DcMotor.Direction.FORWARD);
//        bRight.setDirection(DcMotor.Direction.REVERSE);
//
//        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//
//        myOpMode.telemetry.addData( "status", "initialized");
//        myOpMode.telemetry.update();
//        myOpMode.waitForStart();
//    }
//
//    public void driveRobot(Gamepad gamepad1){
//        double y = -gamepad1.left_stick_y;
//        double x = gamepad1.left_stick_x;
//        double rx = -gamepad1.right_stick_x;
//
//        double frLeft =y+x+rx;
//        double frRight =  y - x - rx  ;
//        double baLeft = (y-x+rx);
//        double baRight = y+x-rx;
//
//        fLeft.setPower((frLeft));
//        fRight.setPower((frRight));
//        bLeft.setPower(baLeft);
//        bRight.setPower(baRight);
//        /*double r = Math.hypot(gamepad1.left_stick_x,gamepad1.left_stick_y);
//        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_y) - Math.PI/4;
//        robotAngle = robotAngle+(Math.PI/2);
//        double rightX = gamepad1.right_stick_x;
//        final double v1 = r * Math.cos(robotAngle) + rightX;
//        final double v2 = r * Math.sin(robotAngle) - rightX;
//        final double v3 = r * Math.sin(robotAngle) + rightX;
//        final double v4 = r * Math.cos(robotAngle) - rightX;
//
//        setDrivePower(v1, v2, v3, v4);
//
//         */
//    }
//
//    public void setDrivePower(double v1, double v2, double v3, double v4) {
//        // Output the values to the motor drives.
//        fLeft.setPower(v1/1.3);
//        fRight.setPower(v2/1.3);
//        bLeft.setPower(v3/1.3);
//        bRight.setPower(v4/1.3);
//    }
//
//}
//
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.robotcontroller.external.samples.RobotHardware;

public class robotHardware {
    private LinearOpMode myOpMode = null;
    public robotHardware(LinearOpMode opMode){
        myOpMode = opMode;
    }
    private DcMotor fLeft;
    private DcMotor fRight;
    private DcMotor bLeft;
    private DcMotor bRight;
    private DcMotor lLift;
    private DcMotor rLift;
    //public TouchSensor touchSensor;
    //public TouchSensor touchSensor2;
    public DcMotor roller;
    //public DcMotor grapple;

    public void init(){
//        SENSORS

        //touchSensor = myOpMode.hardwareMap.get(TouchSensor.class, "touchsensor1");

//        MOTORS
        fLeft = myOpMode.hardwareMap.get(DcMotor.class, "fLeft");
        fRight = myOpMode.hardwareMap.get(DcMotor.class, "fRight");
        bLeft = myOpMode.hardwareMap.get(DcMotor.class, "bLeft");
        bRight = myOpMode.hardwareMap.get(DcMotor.class, "bRight");
        lLift = myOpMode.hardwareMap.get(DcMotor.class, "lLift");
        rLift = myOpMode.hardwareMap.get(DcMotor.class, "rLift");

        lLift = myOpMode.hardwareMap.get(DcMotor.class, "lLift");
        rLift = myOpMode.hardwareMap.get(DcMotor.class, "rLift");

        roller = myOpMode.hardwareMap.get(DcMotor.class, "roller");
     //   grapple = myOpMode.hardwareMap.get(DcMotor.class, "grapple");

        fLeft.setDirection(DcMotor.Direction.FORWARD);
        fRight.setDirection(DcMotor.Direction.REVERSE);
        bLeft.setDirection(DcMotor.Direction.FORWARD);
        bRight.setDirection(DcMotor.Direction.REVERSE);

        lLift.setDirection(DcMotorSimple.Direction.REVERSE);
        rLift.setDirection(DcMotorSimple.Direction.FORWARD);

        roller.setDirection(DcMotorSimple.Direction.FORWARD);
      //  grapple.setDirection(DcMotorSimple.Direction.FORWARD);

        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        roller.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
     //   grapple.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        lLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        roller.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       // grapple.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        myOpMode.telemetry.addData( "status", "initialized");
        myOpMode.telemetry.update();
        myOpMode.waitForStart();
    }

    public void driveRobot(Gamepad gamepad1){
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = -gamepad1.right_stick_x;

        double frLeft = y + x + rx;
        double frRight = y - x - rx  ;
        double baLeft = (y-x+rx);
        double baRight = y+x-rx;

        setDrivePower(frLeft, frRight, baLeft, baRight);

        //fLeft.setPower((frLeft));
        //fRight.setPower((frRight));
//        bLeft.setPower(baLeft);
//        bRight.setPower(baRight);


        /*double r = Math.hypot(gamepad1.left_stick_x,gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_y) - Math.PI/4;
        robotAngle = robotAngle+(Math.PI/2);
        double rightX = gamepad1.right_stick_x;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;

        setDrivePower(v1, v2, v3, v4);

         */
    }


    public void raiseLift() {
        if (lLift.getCurrentPosition() < 0) {
            rLift.setTargetPosition(0);
            lLift.setTargetPosition(0);
            rLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rLift.setPower(5);
            lLift.setPower(5);
        }
    }

    public void lowerLift() {
        if (rLift.getCurrentPosition() > -4250) { //if not touching button go back until it does, then reset your encoders
            rLift.setTargetPosition(-4275);
            lLift.setTargetPosition(-4275);
            rLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rLift.setPower(-1);
            lLift.setPower(-1);
        }
    }

    public void stopLift() {
        rLift.setTargetPosition(rLift.getCurrentPosition());
        lLift.setTargetPosition(lLift.getCurrentPosition());
    }

    public void setDrivePower(double v1, double v2, double v3, double v4) {
        // Output the values to the motor drives.
        fLeft.setPower(v1/1.3);
        fRight.setPower(v2/1.3);
        bLeft.setPower(v3/1.3);
        bRight.setPower(v4/1.3);
    }

    public void rollerMove(Gamepad gamepad1){
        if (gamepad1.y) {

            roller.setTargetPosition(roller.getCurrentPosition() + 5);
            roller.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            roller.setPower(1);

        }
    }

   // public void


    /*
    public void grappleRaise(Gamepad gamepad1){
        if (gamepad1.x){
            grapple.setTargetPosition(roller.getCurrentPosition() + 5);
            grapple.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            grapple.setPower(1);
        }
    }

    public void grappleRetract(Gamepad gamepad1) {
        if (gamepad1.b){
            grapple.setTargetPosition(roller.getCurrentPosition() - 5);
            grapple.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            grapple.setPower(1);
        }
    }
*/


}
