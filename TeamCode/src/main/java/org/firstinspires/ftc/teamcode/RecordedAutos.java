package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.robotHardware;
import org.firstinspires.ftc.teamcode.FullAutos;
import org.firstinspires.ftc.teamcode.BackAutos;
import org.firstinspires.ftc.teamcode.FrontAutos;

public class RecordedAutos {

    FullAutos full = new FullAutos();
    BackAutos back = new BackAutos();
    FrontAutos front = new FrontAutos();

    public void run_test(robotHardware robot, boolean ifMirror, int zone)
    {
        run_full(robot, ifMirror, zone);
    }

    public void run_test2(robotHardware robot, boolean ifMirror, int zone)
    {
        back.left_back_0(robot, ifMirror);
    }

    public void run_front(robotHardware robot, boolean ifMirror, int zone)
    {
        int z = zone;

        if (ifMirror && z == 0)
        {
            z = 2;
        }
        else if (ifMirror && z == 2)
        {
            z = 0;
        }

        switch(z) {
            case 0:
                front.left_front_0(robot, ifMirror);
                break;
            case 1:
                front.left_front_1(robot, ifMirror);
                break;
            case 2:
                front.left_front_2(robot, ifMirror);
                break;
        }
    }

    public void run_back(robotHardware robot, boolean ifMirror, int zone)
    {
        int z = zone;

        if (ifMirror && z == 0)
        {
            z = 2;
        }
        else if (ifMirror && z == 2)
        {
            z = 0;
        }

        switch(z) {
            case 0:
                back.left_back_0(robot, ifMirror);
                break;
            case 1:
                back.left_back_1(robot, ifMirror);
                break;
            case 2:
                back.left_back_2(robot, ifMirror);
                break;
        }
    }

    public void run_full(robotHardware robot, boolean ifMirror, int zone)
    {
        int z = zone;

        if (ifMirror && z == 0)
        {
            z = 2;
        }
        else if (ifMirror && z == 2)
        {
            z = 0;
        }

        switch(z) {
            case 0:
                full.left_front_0(robot, ifMirror);
                break;
            case 1:
                full.left_front_1(robot, ifMirror);
                break;
            case 2:
                full.left_front_2(robot, ifMirror);
                break;
            case 3:
                full.left_front_0(robot, ifMirror);
                break;
        }
    }
}
