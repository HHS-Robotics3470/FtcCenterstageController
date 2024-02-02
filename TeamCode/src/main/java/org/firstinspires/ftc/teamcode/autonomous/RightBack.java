package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutoLogic;
import org.firstinspires.ftc.teamcode.SpikeDetectionPipeline;
import org.firstinspires.ftc.teamcode.RecordedAutos.RunAutos;
import org.firstinspires.ftc.teamcode.RecordedAutos.RightBackAutos;
import org.firstinspires.ftc.teamcode.robotHardware;

@Autonomous(name = "Right Back", group = "Autonomous")
public class RightBack extends LinearOpMode {

    robotHardware robot = new robotHardware(this);
    AutoLogic auto = new AutoLogic();
    SpikeDetectionPipeline pipeline = new SpikeDetectionPipeline();
    boolean ifMirror = true;


    @Override
    public void runOpMode() {
        robot.initOpenCV(pipeline);
        robot.init();

        waitForStart();
        if (opModeIsActive()) {
            for (int i = 0; i < 600; i++)
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
            auto.run_autos(robot, true, zone, new RightBackAutos());

            stop();
        }
    }




}