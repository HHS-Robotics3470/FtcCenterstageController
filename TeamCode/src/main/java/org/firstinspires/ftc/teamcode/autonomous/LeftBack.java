package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.SpikeDetectionPipeline;
import org.firstinspires.ftc.teamcode.RecordedAutos;
import org.firstinspires.ftc.teamcode.robotHardware;

@Autonomous(name = "Left Back", group = "Autonomous")
public class LeftBack extends LinearOpMode {

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


            telemetry.addData("Status", "Yo Timbits, target zone determined");
            telemetry.addData("Status", "Hey Timmy!!! I'm parking in the "+zone);
            telemetry.addData("Status", "Timmy watch me! I'm playing the pre-recorded sequence");
            telemetry.update();
//                MEDIUM JUNCTION STACK
            recorded.run_back(robot, false, zone);

            stop();
        }
    }




}