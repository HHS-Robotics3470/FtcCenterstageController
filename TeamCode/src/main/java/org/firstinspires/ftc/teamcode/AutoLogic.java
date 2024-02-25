package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.recorded.BackAutos;
import org.firstinspires.ftc.teamcode.recorded.FrontAutos;
import org.firstinspires.ftc.teamcode.recorded.RunAutos;

public class AutoLogic {

    public void run_auto(robotHardware robot, boolean ifMirror, int zone, RunAutos run) {
        int z = zone;

        if (ifMirror && z == 0) {
            z = 2;
        } else if (ifMirror && z == 2) {
            z = 0;
        }

//        robot.autoLimit = 1.15;
        switch (z) {
            case 0:
                run.run_0(robot, ifMirror);
                break;
            case 1:

                run.run_1(robot, ifMirror);
                break;
            case 2:
                run.run_2(robot, ifMirror);
                break;
            case 3:
                run.run_0(robot, ifMirror);
                break;
        }
    }

}

