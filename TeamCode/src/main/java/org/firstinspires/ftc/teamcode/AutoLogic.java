package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.RecordedAutos.RunAutos;
import org.firstinspires.ftc.teamcode.RecordedAutos.FrontAutos;
import org.firstinspires.ftc.teamcode.RecordedAutos.BackAutos;
import org.firstinspires.ftc.teamcode.RecordedAutos.RightBackAutos;
import org.firstinspires.ftc.teamcode.RecordedAutos.RightFrontAutos;

public class AutoLogic {


    public void run_test(robotHardware robot, boolean ifMirror, int zone) {

    }

    public void run_autos(robotHardware robot, boolean ifMirror, int zone, RunAutos auto) {
        int z = zone;

        if (ifMirror && z == 0) {
            z = 2;
        } else if (ifMirror && z == 2) {
            z = 0;
        }

        switch (z) {
            case 0:
                auto.run_0(robot, ifMirror);
                break;
            case 1:
                auto.run_1(robot, ifMirror);
                break;
            case 2:
                auto.run_2(robot, ifMirror);
                break;
            case 3:
                auto.run_0(robot, ifMirror);
                break;
        }
    }

}

