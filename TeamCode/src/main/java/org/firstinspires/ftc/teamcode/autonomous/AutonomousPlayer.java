//package org.firstinspires.ftc.teamcode.autonomous;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
//import org.firstinspires.ftc.teamcode.TeleOpPractice;
//import org.firstinspires.ftc.teamcode.robotHardware;
//
//@Autonomous(name = "AutoPlayer", group = "Autonomous")
//public class AutonomousPlayer extends LinearOpMode {
//
//    private ElapsedTime runtime = new ElapsedTime();
//    robotHardware robot = new robotHardware(this);
//    TeleOpPractice teleOp = new TeleOpPractice();
//
//    private Integer zone = null;
//    //SleeveDetectionPipeline pipeline = new SleeveDetectionPipeline();
//    boolean aState = false;
//    boolean bState = false;
//    boolean duState = false;
//    boolean ddState = false;
//
//    /*public AutonomousPlayer() throws Exception
//    {
//        Logging.setup();
//        Logging.log("Starting Drive Circle Logging");
//    }*/
//
//    public String currentPos(){
//        return "robot.setMovementPosition("+robot.fLeft.getCurrentPosition()+","+robot.fRight.getCurrentPosition()+
//                ","+robot.bLeft.getCurrentPosition()+","+robot.bRight.getCurrentPosition()+","+robot.rLift.getCurrentPosition()+","+robot.lLift.getCurrentPosition()+","+
//                robot.dropper.getPosition()+","+robot.mover.getPosition()+","+robot.roller.getCurrentPosition()+");";
//    }
//
//
//
//    public void runOpMode() {
//
//        robot.init();
//        //robot.initOpenCV(pipeline);
//
//        /** Wait for the game to begin */
//        waitForStart();
//
//        if (opModeIsActive()) {
//            telemetry.addData("Status", "Determining signal");
//            telemetry.update();
//            SleeveDetectionPipeline.ParkingPosition zone = pipeline.getSignal();
//            telemetry.addData("Status", "Target zone determined");
//            telemetry.addData("Status", "Playing pre-recorded sequence");
//            telemetry.update();
////                MEDIUM JUNCTION STACK

//
//            robot.resetEncoders();
////                MOVE SIGNAL AWAY
//            robot.driveDistance(15);
//            robot.driveDistance(-3);
//            robot.resetEncoders();
//
//            robot.leftfrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            robot.rightfrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            robot.leftrearDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            robot.rightrearDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//            while (opModeIsActive()) {
//// DRIVE CODE
//                // DRIVE CODE
//                robot.driveRobot(gamepad1);
//
//                // LIFT CODE
//                if (gamepad2.right_bumper && !duState) {
//                    robot.raiseLift();
//                    duState = true;
//                } else if (!gamepad2.right_bumper && duState){
//                    robot.stopLift();
//                    duState = false;
//                }
//
//                if (gamepad2.left_bumper && !ddState) {
//                    robot.lowerLift();
//                    ddState = true;
//                } else if (!gamepad2.left_bumper && ddState){
//                    robot.stopLift();
//                    ddState = false;
//                }
//
//                // GRABBER CODE
//                if (gamepad1.a && !aState) {
//                    robot.activateGrabber();
//                    aState = true;
//                } else if (!gamepad1.a && aState) {
//                    aState = false;
//                }
//                if (gamepad2.a && !bState) {
//                    robot.activateFlipper();
//                    bState = true;
//                } else if (!gamepad2.a && bState){
//                    bState = false;
//                }
//
//                // LOGGING / TELEMETRY
//                telemetry.addData("Status", "Run Time: " + runtime.toString());
//                telemetry.update();
//
//                sleep(50);
//                Logging.log(currentPos());
//
//            }
//        }
//    }
//}