package org.firstinspires.ftc.teamcode.recorded;


import org.firstinspires.ftc.teamcode.recorded.RunAutos;
import org.firstinspires.ftc.teamcode.recorded.BackAutosExtended;
import org.firstinspires.ftc.teamcode.robotHardware;

public class BackAutos extends RunAutos {
    public void run_0(robotHardware robot, boolean ifMirror) {
        robot.resetEncoders();
        //move to spike marks (forward)
        for (int adithya = 0; adithya < 100; adithya++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 550, 550, 550, 550, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
        //rotate on point
        for (int gavin = 0; gavin < 100; gavin++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 720,0, 720, 0, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        robot.resetEncoders();
        //back up from pixel
        for (int christian = 0; christian < 100; christian++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, -150, -150, -150, -150, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
        //reset rotate
        for (int gavin = 0; gavin < 100; gavin++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, -720,0, -720, 0, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
    }

    public void run_1(robotHardware robot, boolean ifMirror) {
        double n = 1;
        if (ifMirror)
            n *= -1;
        robot.resetEncoders();
        //move to spike marks
        for (int adithya = 0; adithya < 100; adithya++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 900, 900, 900, 900, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //back up from pixel
        for (int christian = 0; christian < 100; christian++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 750, 750, 750, 750, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
    }

    public void run_2(robotHardware robot, boolean ifMirror) {
        robot.resetEncoders();
        //move to spike marks (strafe)
        for (int helpme = 0; helpme < 100; helpme++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 380, -380, -380, 380, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
        //move to spike marks (forward)
        for (int adithya = 0; adithya < 100; adithya++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 720, 720, 720, 720, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        robot.resetEncoders();
        //back up from pixel
        for (int christian = 0; christian < 100; christian++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, -150, -150, -150, -150, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
    }
}