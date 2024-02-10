package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.BackAutos;

import org.firstinspires.ftc.teamcode.FrontAutos;

import org.firstinspires.ftc.teamcode.RunAutos;

public class AutoLogic {


    public void run_test(robotHardware robot, boolean ifMirror, int zone) {

    }

    public void left_front(robotHardware robot, boolean ifMirror, int zone) {
        int z = zone;
        FrontAutos front = new FrontAutos();

        if (ifMirror && z == 0) {
            z = 2;
        } else if (ifMirror && z == 2) {
            z = 0;
        }

        switch (z) {
            case 0:
                front.run_0(robot, false);
                break;
            case 1:
                front.run_1(robot, false);
                break;
            case 2:
                front.run_2(robot, false);
                break;
            case 3:
                front.run_0(robot, false);
                break;
        }
    }

    public void left_back(robotHardware robot, boolean ifMirror, int zone) {
        int z = zone;
        BackAutos back = new BackAutos();

        if (ifMirror && z == 0) {
            z = 2;
        } else if (ifMirror && z == 2) {
            z = 0;
        }

        switch (z) {
            case 0:
                back.run_0(robot, false);
                break;
            case 1:
                back.run_1(robot, false);
                break;
            case 2:
                back.run_2(robot, false);
                break;
            case 3:
                back.run_0(robot, false);
                break;
        }
    }

    public void right_front(robotHardware robot, boolean ifMirror, int zone) {
        int z = zone;
        FrontAutos front = new FrontAutos();

        if (ifMirror && z == 0) {
            z = 2;
        } else if (ifMirror && z == 2) {
            z = 0;
        }

        switch (z) {
            case 0:
                front.run_0(robot, true);
                break;
            case 1:
                front.run_1(robot, true);
                break;
            case 2:
                front.run_2(robot, true);
                break;
            case 3:
                front.run_0(robot, true);
                break;
        }
    }


    public void left_pixel(robotHardware robot, boolean ifMirror, int zone) {
        int z = zone;
        RunAutos pixel = new RunAutos();

        if (ifMirror && z == 0) {
            z = 2;
        } else if (ifMirror && z == 2) {
            z = 0;
        }

        switch (z) {
            case 0:
                pixel.run_0(robot, false);
                break;
            case 1:
                pixel.run_1(robot, false);
                break;
            case 2:
                pixel.run_2(robot, false);
                break;
            case 3:
                pixel.run_0(robot, false);
                break;
        }
    }

    public void right_pixel(robotHardware robot, boolean ifMirror, int zone) {
        int z = zone;
        RunAutos pixel = new RunAutos();

        if (ifMirror && z == 0) {
            z = 2;
        } else if (ifMirror && z == 2) {
            z = 0;
        }

        switch (z) {
            case 0:
                pixel.run_0(robot, true);
                break;
            case 1:
                pixel.run_1(robot, true);
                break;
            case 2:
                pixel.run_2(robot, true);
                break;
            case 3:
                pixel.run_0(robot, true);
                break;
        }
    }

}

