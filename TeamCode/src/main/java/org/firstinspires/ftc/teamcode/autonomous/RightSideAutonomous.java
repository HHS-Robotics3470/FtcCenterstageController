package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.SpikeDetectionPipeline;
import org.firstinspires.ftc.teamcode.robotHardware;
import org.firstinspires.ftc.teamcode.RecordedAutos;


@Autonomous(name = "Right Side Autonomous", group = "Autonomous")
public class RightSideAutonomous extends LinearOpMode {

    robotHardware robot = new robotHardware(this);
    SpikeDetectionPipeline pipeline = new SpikeDetectionPipeline();
    RecordedAutos recorded = new RecordedAutos();
    boolean ifMirror = false;


    @Override
    public void runOpMode() {
        robot.initOpenCV(pipeline);
        robot.init();

        waitForStart();
        if (opModeIsActive()) {
            for (int i = 0; i < 2500; i++)
            {
                robot.setDrivePower(1, -1, -1, 1);
            }
            robot.resetEncoders();
            telemetry.addData("Status", "Tiiiiimothyyyy, I'm determining signal");
            telemetry.update();
            int zone = pipeline.getSpikePosition();
            telemetry.addData("Status", "Yo Timbits, target zone determined");
            telemetry.addData("Status", "Hey Timmy!!! I'm parking in the "+zone);
            telemetry.addData("Status", "Timmy watch me! I'm playing the pre-recorded sequence");
            telemetry.update();
//                MEDIUM JUNCTION STACK

            recorded.run_test(robot, true, zone);


            stop();
        }
    }
}