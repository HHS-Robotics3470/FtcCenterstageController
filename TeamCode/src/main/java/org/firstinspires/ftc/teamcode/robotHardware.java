package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;


public class robotHardware {
    private LinearOpMode myOpMode = null;
    public robotHardware(LinearOpMode opMode){
        myOpMode = opMode;
    }
    public boolean stop = false;
    //Moters
    public DcMotor fLeft;
    public DcMotor fRight;
    public DcMotor bLeft;
    public DcMotor bRight;
    public DcMotor lLift;
    public DcMotor rLift;
    public DcMotor winch;

    //Servos
    public Servo dropper;
    public Servo bomber;//remember to change the name for the love of god
    public Servo flipper;
    public Servo gears;
    public Servo hook;
    public Servo claw;
    public Servo arm;
    public Servo wrist;

    //Sensors
    public DistanceSensor leftSensor;
    public DistanceSensor rightSensor;


    //Servo states
    public final double dropActive = 0;
    public final double dropInActive = 0.85;

    public final double bombActive = 1;
    public final double bombInActive = 0.6;

    public final double oldmoveActive = 0;
    public final double oldmoveInActive = 0.675;
    public final double moveActive2 = 0.5;
    public final double moveInActive2 = 0.605;
    public final double moveActive = 0.5;
    public final double moveInActive = 0.607;
    public final double gearActive = 0.45;
    public final double gearInActive = 0.65;

    public final double hookActive = 0.52;
    public final double hookInActive = 0;

    public final double clawOpen = 0;
    public final double clawClosed = 0.0475;

    public final double[] wristPos = {0.1, 0.051, 0.028};

    public final double rollActive = 0.11;

    public final double rollGround = 0;
    public final double[] rollPos = {rollGround, 0.055, 0.083};
    //Moter states
    public final double liftAbove = -1148;

    public void init(){

//        MOTORS
        fLeft = myOpMode.hardwareMap.get(DcMotor.class, "fLeft");
        fRight = myOpMode.hardwareMap.get(DcMotor.class, "fRight");
        bLeft = myOpMode.hardwareMap.get(DcMotor.class, "bLeft");
        bRight = myOpMode.hardwareMap.get(DcMotor.class, "bRight");
        lLift = myOpMode.hardwareMap.get(DcMotor.class, "lLift");
        rLift = myOpMode.hardwareMap.get(DcMotor.class, "rLift");

        lLift = myOpMode.hardwareMap.get(DcMotor.class, "lLift");
        rLift = myOpMode.hardwareMap.get(DcMotor.class, "rLift");

        winch = myOpMode.hardwareMap.get(DcMotor.class, "grabber");

        //Servos
        dropper = myOpMode.hardwareMap.get(Servo.class,"dropper");
        bomber = myOpMode.hardwareMap.get(Servo.class, "bomber");
        flipper = myOpMode.hardwareMap.get(Servo.class, "mover");
        gears = myOpMode.hardwareMap.get(Servo.class, "gears");
        hook = myOpMode.hardwareMap.get(Servo.class, "hook");
        claw = myOpMode.hardwareMap.get(Servo.class, "claw");
        arm = myOpMode.hardwareMap.get(Servo.class, "roller");
        wrist = myOpMode.hardwareMap.get(Servo.class, "wrist");

        //Distance sensors
//        leftSensor = myOpMode.hardwareMap.get(DistanceSensor.class, "distance2");
        rightSensor = myOpMode.hardwareMap.get(DistanceSensor.class, "distance1");


        //Direction and encoders
        fLeft.setDirection(DcMotor.Direction.FORWARD);
        fRight.setDirection(DcMotor.Direction.REVERSE);
        bLeft.setDirection(DcMotor.Direction.FORWARD);
        bRight.setDirection(DcMotor.Direction.REVERSE);

        lLift.setDirection(DcMotorSimple.Direction.REVERSE);
        rLift.setDirection(DcMotorSimple.Direction.FORWARD);

        winch.setDirection(DcMotorSimple.Direction.FORWARD);

        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        winch.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        lLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        winch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        myOpMode.telemetry.addData( "status", "initialized");
        myOpMode.telemetry.update();
        myOpMode.waitForStart();

        //Servo initial positions
        dropper.setPosition(dropInActive);
        bomber.setPosition(bombInActive);
        flipper.setPosition(moveInActive);
        gears.setPosition(gearInActive);
        hook.setPosition(hookInActive);
        claw.setPosition(clawClosed);
        arm.setPosition(rollActive);
        wrist.setPosition(wristPos[0]);


    }

    //Mechnam code for robot
    public void driveRobot(Gamepad gamepad1){
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = -gamepad1.right_stick_x;

        double frLeft = y + x + rx;
        double frRight = y - x - rx  ;
        double baLeft = y - x + rx;
        double baRight = y + x - rx;

        setDrivePower(frLeft, frRight, baLeft, baRight);

    }

    //Sets driving speed
    public void setDrivePower(double v1, double v2, double v3, double v4) {
        double n = 1.15;
        fLeft.setPower(v1/n);
        fRight.setPower(v2/n);
        bLeft.setPower(v3/n);
        bRight.setPower(v4/n);
    }

    //Sets auto speed
    public void setDrivePowerAuto(double v1, double v2, double v3, double v4) {
        double n = 1.8;
        fLeft.setPower(v1/n);
        fRight.setPower(v2/n);
        bLeft.setPower(v3/n);
        bRight.setPower(v4/n);
    }

    //Sets encoder positions for wheels
    public void setDrivePosition(double fL, double fR, double bL, double bR)
    {
        fLeft.setTargetPosition((int) fL);
        fRight.setTargetPosition((int) fR);
        bLeft.setTargetPosition((int) bL);
        bRight.setTargetPosition((int) bR);
    }

    public void rotateRobot(double pos)
    {
        double fL = fLeft.getCurrentPosition() - pos;
        double fR = fRight.getCurrentPosition() + pos;
        double bL = bLeft.getCurrentPosition() - pos;
        double bR = bRight.getCurrentPosition() + pos;

        setDrivePosition(fL, fR, bL, bR);



        while (fLeft.getCurrentPosition() != fL || fRight.getCurrentPosition() != fR || bLeft.getCurrentPosition() != bL || bRight.getCurrentPosition() != bR) {
            fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            setDrivePower(1, 1, 1, 1);
        }
    }

    //strafes robot positively to the left by certain inches
    public void strafeDistance(double distance) {

        distance = distance * 45.28;

        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fLeft.setTargetPosition((int) distance);
        fRight.setTargetPosition(-(int) distance);
        bLeft.setTargetPosition(-(int) distance);
        bRight.setTargetPosition((int) distance);

        while ((fLeft.getTargetPosition() != fLeft.getCurrentPosition()) && (fRight.getTargetPosition() != fRight.getCurrentPosition()) && (bLeft.getTargetPosition() != bLeft.getCurrentPosition()) && (bRight.getTargetPosition() != bRight.getCurrentPosition())) {
            double n = 0.6;
            setDrivePowerAuto(n,n,n,n);
        }
    }

    //drives robot positively forward by certain inches
    public void moveRobot(double distance)
    {
        distance = distance * 45.28;

        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fLeft.setTargetPosition((int) distance);
        fRight.setTargetPosition((int) distance);
        bLeft.setTargetPosition((int) distance);
        bRight.setTargetPosition((int) distance);

        while ((fLeft.getTargetPosition() != fLeft.getCurrentPosition()) && (fRight.getTargetPosition() != fRight.getCurrentPosition()) && (bLeft.getTargetPosition() != bLeft.getCurrentPosition()) && (bRight.getTargetPosition() != bRight.getCurrentPosition())) {
            double n = 0.6;
            setDrivePowerAuto(n,n,n,n);
        }
    }

    //initalizes camera detection - execute before getting spike position
    public void initOpenCV(SpikeDetectionPipeline pipeline){
        WebcamName webcamName = myOpMode.hardwareMap.get(WebcamName.class, "Webcam 1");
        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName);

        myOpMode.telemetry.addData("Initialized", "Hardware");
        myOpMode.telemetry.addData("Initializing", "OpenCV");
        myOpMode.telemetry.addData("Warning", "Do Not Start OpMode Until OpenCV Is Initialized");
        myOpMode.telemetry.update();

        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                camera.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT);

                camera.setPipeline(pipeline);

                myOpMode.telemetry.addData("Initialized", "Hardware");
                myOpMode.telemetry.addData("Initialized", "OpenCV");
                myOpMode.telemetry.addData("Status", "You may now start the OpMode");
                myOpMode.telemetry.update();
            }

            @Override
            public void onError(int errorCode) {

            }
        });

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

    //retracts winch, lifting robot
    public void winchUp(boolean hbs) {
        if (hbs) {
            winch.setPower(5.0);
        } else {
            winch.setPower(0);
        }
    }

    //unretracts winch
    public void winchDown(boolean hbs) {
        if (hbs) {
            winch.setPower(-5.0);
        } else {
            winch.setPower(0);
        }
    }



    public void hookRobot(boolean up){
        SwitchServo(hook, hookActive, hookInActive, up);
    }

    public void nine_eleven(boolean launch){//also don't change this for the love of god once again
        SwitchServo(bomber, bombActive, bombInActive, launch);
    }

    public void releasePixel (boolean open) {
        dropper.setPosition(dropActive);
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        dropper.setPosition(dropInActive);


    }

    public void lift_pixel(boolean ifLifted){
        if (rLift.getCurrentPosition() < liftAbove || lLift.getCurrentPosition() < liftAbove) {
            SwitchServo(flipper, moveActive, moveInActive, ifLifted);
            SwitchServo(gears, gearActive, gearInActive, ifLifted);
        }
    }

    public boolean useClaw(boolean ifOpen)
    {
        return SwitchServo(claw, clawOpen, clawClosed, ifOpen);
    }
    public boolean useArm(boolean ifGround)
    {
        wrist.setPosition(wristPos[0]);
        return SwitchServo(arm, rollActive, rollGround, ifGround);
    }

    public boolean SwitchServo(Servo s, double active, double inactive, boolean isActive)
    {
        if (!isActive)
            s.setPosition(active);
        else if (isActive)
            s.setPosition(inactive);
        return !isActive;
    }


    public int UpHeights(int pos)
    {
        int height;
        if (pos >= wristPos.length-1)
            height = wristPos.length-1;
        else
            height = pos + 1;
        arm.setPosition(rollPos[height]);
        wrist.setPosition(wristPos[height]);
        return height;
    }

    public int DownHeights(int pos)
    {
        int height;
        if (pos <= 0)
            height = 0;
        else
            height = pos - 1;
        arm.setPosition(rollPos[height]);
        wrist.setPosition(wristPos[height]);
        return height;
    }






    public void setMovementPosition(double leftY, double leftX, double rightX, double fL, double fR, double bL, double bR, double rL, double lL, boolean drop, double move, double gear, double clawPos, double roll, boolean mirror)
    {
        //    for refrence
//    return "robot.setMovementPosition("+robot.fLeft.getCurrentPosition()+","+robot.fRight.getCurrentPosition()+
//                ","+robot.bLeft.getCurrentPosition()+","+robot.bRight.getCurrentPosition()+","+robot.rLift.getCurrentPosition()+","+robot.lLift.getCurrentPosition()+","+
//                robot.dropper.getPosition()+","+robot.mover.getPosition()+","+robot.roller.getCurrentPosition()+");";
//        fLeft.setTargetPosition((int) fL);
//        fRight.setTargetPosition((int) fR);
//        bLeft.setTargetPosition((int) bL);
//        bRight.setTargetPosition((int) bR);

//        double y = -leftY;
//        double x = leftX;
//        double rx = -rightX;
//
//        double frLeft = y + x + rx;
//        double frRight = y - x - rx  ;
//        double baLeft = y - x + rx;
//        double baRight = y + x - rx;
        if (stop)
            return;

        if(!mirror) {
            setDrivePosition(fL, fR, bL, bR);
//            setDrivePower(frLeft, frRight, baLeft, baRight);
        }
        else {
            setDrivePosition(fR, fL, bR, bL);
//            setDrivePower(frRight, frLeft, baRight, baLeft);
        }

        lLift.setTargetPosition((int) lL);
        rLift.setTargetPosition((int) rL);

//        roller.setTargetPosition((int) roll);
        claw.setPosition(clawPos);
        arm.setPosition(roll);
        double newMove= move;
        if (Math.abs(newMove - moveActive2)  < 0.00001)
            flipper.setPosition(moveActive);
        else
            flipper.setPosition(moveInActive);
        if (drop)
            releasePixel(true);
        gears.setPosition(gear);


        fLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        lLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//        roller.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        roller.setPower(0.05);
        lLift.setPower(0.5);
        rLift.setPower(0.5);
        double n = 0.6;
        setDrivePowerAuto(n,n,n,n);


    }

    public void setMovementPositionAdvanced(double leftY, double leftX, double rightX, double fL, double fR, double bL, double bR, double rL, double lL, boolean drop, double move, double gear, double clawPos, double roll, boolean mirror)
    {
        if (stop)
            return;

        if(!mirror) {
            setDrivePosition(fL, fR, bL, bR);
//            setDrivePower(frLeft, frRight, baLeft, baRight);
        }
        else {
            setDrivePosition(fR, fL, bR, bL);
//            setDrivePower(frRight, frLeft, baRight, baLeft);
        }

        lLift.setTargetPosition((int) lL);
        rLift.setTargetPosition((int) rL);

//        roller.setTargetPosition((int) roll);
        claw.setPosition(clawPos);
        arm.setPosition(roll);
//        mover.setPosition(move);
        double newMove= move;
        if (Math.abs(newMove - 0)  < 0.00001)
            flipper.setPosition(moveActive);
        else
            flipper.setPosition(moveInActive);

        if (drop)
            releasePixel(true);
        gears.setPosition(gear);


        fLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        lLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//        roller.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        roller.setPower(0.05);
        lLift.setPower(0.5);
        rLift.setPower(0.5);
        double n = 0.6;
        setDrivePowerAuto(n,n,n,n);



    }

    public void resetEncoders()
    {
        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

//        roller.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        winch.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }



}