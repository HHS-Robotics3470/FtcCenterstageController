package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorEx;
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

    //Moters
    public DcMotor fLeft;
    public DcMotor fRight;
    public DcMotor bLeft;
    public DcMotor bRight;
    public DcMotor lLift;
    public DcMotor rLift;
    //    public DcMotor roller;
    public DcMotor grabber;

    //Servos
    public Servo dropper;
    public Servo bomber;//remember to change the name for the love of god
    public Servo mover;
    public Servo gears;
    public Servo hook;
    public Servo claw;
    public Servo roller;

    //Odometry Pods
    public DcMotorEx cWheel;

    //Odometry
    public double prevLeftPos = 0;
    public double prevRightPos = 0;
    public double prevCenterPos = 0;

    public double trackWidth = 100;

    public double xPos = 0;
    public double yPos = 0;
    public double rPos = 0;

    //Servo states
    public final double dropActive = 0;
    public final double dropInActive = 0.85;

    public final double bombActive = 0.8;
    public final double bombInActive = 0.4;

    public final double moveActive = 0;
    public final double moveInActive = 0.65;
    public final double gearActive = 0.45;
    public final double gearInActive = 0.65;

    public final double hookActive = 0.52;
    public final double hookInActive = 0;

    public final double clawOpen = 0;
    public final double clawClosed = 0.0475;
    public final double rollActive = 0.1;
    public final double rollGround = 0;

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

//        roller = myOpMode.hardwareMap.get(DcMotor.class, "roller");
        grabber = myOpMode.hardwareMap.get(DcMotor.class, "grabber");

        //Servos
        dropper = myOpMode.hardwareMap.get(Servo.class,"dropper");
        bomber = myOpMode.hardwareMap.get(Servo.class, "bomber");
        mover = myOpMode.hardwareMap.get(Servo.class, "mover");
        gears = myOpMode.hardwareMap.get(Servo.class, "gears");
        hook = myOpMode.hardwareMap.get(Servo.class, "hook");
        claw = myOpMode.hardwareMap.get(Servo.class, "claw");
        roller = myOpMode.hardwareMap.get(Servo.class, "roller");

        //Odometry Pods
        cWheel = myOpMode.hardwareMap.get(DcMotorEx.class, "lTrack");

        //Direction and encoders
        fLeft.setDirection(DcMotor.Direction.FORWARD);
        fRight.setDirection(DcMotor.Direction.REVERSE);
        bLeft.setDirection(DcMotor.Direction.FORWARD);
        bRight.setDirection(DcMotor.Direction.REVERSE);

        cWheel.setDirection(DcMotor.Direction.FORWARD);

        lLift.setDirection(DcMotorSimple.Direction.REVERSE);
        rLift.setDirection(DcMotorSimple.Direction.FORWARD);

//        roller.setDirection(DcMotorSimple.Direction.REVERSE);
        grabber.setDirection(DcMotorSimple.Direction.FORWARD);

        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

//        roller.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        grabber.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        cWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        cWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        lLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//        roller.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        grabber.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        myOpMode.telemetry.addData( "status", "initialized");
        myOpMode.telemetry.update();
        myOpMode.waitForStart();

        //Servo initial positions
        dropper.setPosition(dropInActive);
        bomber.setPosition(bombInActive);
        mover.setPosition(moveInActive);
        gears.setPosition(gearInActive);
        hook.setPosition(hookInActive);
        claw.setPosition(clawClosed);
        roller.setPosition(rollActive);
    }

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

    public void setDrivePower(double v1, double v2, double v3, double v4) {
        // Output the values to the motor drives.
        fLeft.setPower(v1/1.3);
        fRight.setPower(v2/1.3);
        bLeft.setPower(v3/1.3);
        bRight.setPower(v4/1.3);
    }

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
    public void strafeRobot(double pos)
    {
        double fL = fLeft.getCurrentPosition() + pos;
        double fR = fRight.getCurrentPosition() - pos;
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

    public void moveRobot(double pos)
    {
        double fL = fLeft.getCurrentPosition() + pos;
        double fR = fRight.getCurrentPosition() + pos;
        double bL = bLeft.getCurrentPosition() - pos;
        double bR = bRight.getCurrentPosition() - pos;

        setDrivePosition(fL, fR, bL, bR);



        while (fLeft.getCurrentPosition() != fL || fRight.getCurrentPosition() != fR || bLeft.getCurrentPosition() != bL || bRight.getCurrentPosition() != bR) {
            fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            setDrivePower(1, 1, 1, 1);
        }
    }

    public void updateOdometry()
    {
        double deltaLeft;
    }

    public void initOpenCV(SpikeDetectionPipeline pipeline){
        WebcamName webcamName = myOpMode.hardwareMap.get(WebcamName.class, "Webcam 1");
        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName);

        myOpMode.telemetry.addData("Initialized", "Hardware");
        myOpMode.telemetry.addData("Initializing", "OpenCV");
        myOpMode.telemetry.addData("Warning", "Do Not Start OpMode Until OpenCV Is Initialized");
        myOpMode.telemetry.update();
//        Synchronous because we don't want user to start auto before its ready
        camera.openCameraDevice();
        camera.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT);
//        Start Signal Processing Pipeline
        camera.setPipeline(pipeline);

        myOpMode.telemetry.addData("Initialized", "Hardware");
        myOpMode.telemetry.addData("Initialized", "OpenCV");
        myOpMode.telemetry.addData("Status", "You may now start the OpMode");
        myOpMode.telemetry.update();
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


    public void grabberMove(boolean hbs) {
        if (hbs) {
            grabber.setPower(5.0);
        } else {
            grabber.setPower(0);
        }
    }

    public void grabberMoveDown(boolean hbs) {
        if (hbs) {
            grabber.setPower(-5.0);
        } else {
            grabber.setPower(0);
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
            SwitchServo(mover, moveActive, moveInActive, ifLifted);
            SwitchServo(gears, gearActive, gearInActive, ifLifted);
        }
    }

    public boolean useClaw(boolean ifOpen)
    {
        return SwitchServo(claw, clawOpen, clawClosed, ifOpen);
    }
    public boolean useRoller(boolean ifGround)
    {
        return SwitchServo(roller, rollActive, rollGround, ifGround);
    }

    public boolean SwitchServo(Servo s, double active, double inactive, boolean isActive)
    {
        if (!isActive)
            s.setPosition(active);
        else if (isActive)
            s.setPosition(inactive);
        return !isActive;
    }

    public void setMovementPosition(double fL, double fR, double bL, double bR, double rL, double lL, boolean drop, double move, double gear, double clawPos, double roll, boolean mirror)
    {
        //    for refrence
//    return "robot.setMovementPosition("+robot.fLeft.getCurrentPosition()+","+robot.fRight.getCurrentPosition()+
//                ","+robot.bLeft.getCurrentPosition()+","+robot.bRight.getCurrentPosition()+","+robot.rLift.getCurrentPosition()+","+robot.lLift.getCurrentPosition()+","+
//                robot.dropper.getPosition()+","+robot.mover.getPosition()+","+robot.roller.getCurrentPosition()+");";
//        fLeft.setTargetPosition((int) fL);
//        fRight.setTargetPosition((int) fR);
//        bLeft.setTargetPosition((int) bL);
//        bRight.setTargetPosition((int) bR);

        if(!mirror)
            setDrivePosition(fL, fR, bL, bR);
        else
            setDrivePosition(fR, fL, bR, bL);

        lLift.setTargetPosition((int) lL);
        rLift.setTargetPosition((int) rL);

//        roller.setTargetPosition((int) roll);
        claw.setPosition(clawPos);
        roller.setPosition(roll);
        mover.setPosition(move);
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

        setDrivePower(0.6, 0.6, 0.6, 0.6);
        lLift.setPower(0.5);
        rLift.setPower(0.5);



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
        grabber.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }



}