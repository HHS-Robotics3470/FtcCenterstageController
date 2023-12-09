package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.SpikeDetectionPipeline;
import org.firstinspires.ftc.teamcode.RecordedAutos;
import org.firstinspires.ftc.teamcode.robotHardware;

@Autonomous(name = "Left Side Autonomous", group = "Autonomous")
public class LeftSideAutonomous extends LinearOpMode {

    robotHardware robot = new robotHardware(this);
    RecordedAutos recorded = new RecordedAutos();
    SpikeDetectionPipeline pipeline = new SpikeDetectionPipeline();
    boolean ifMirror = true;


    @Override
    public void runOpMode() {
        robot.initOpenCV(pipeline);
        robot.init();

        waitForStart();
        if (opModeIsActive()) {
            telemetry.addData("Status", "Tiiiiimothyyyy, I'm determining signal");
            telemetry.update();
            int zone = pipeline.getSpikePosition();
            if (zone == 2)
            {
                recorded.run0(robot, ifMirror);
            }
            else if (zone == 1)
            {
                recorded.run1(robot, ifMirror);
            }
            else if (zone == 0)
            {
                recorded.run2(robot, ifMirror);
            }
//            recorded.runBase(robot, ifMirror);

            telemetry.addData("Status", "Yo Timbits, target zone determined");
            telemetry.addData("Status", "Hey Timmy!!! I'm parking in the "+zone);
            telemetry.addData("Status", "Timmy watch me! I'm playing the pre-recorded sequence");
            telemetry.update();
//                MEDIUM JUNCTION STACK


            stop();
        }
    }




}