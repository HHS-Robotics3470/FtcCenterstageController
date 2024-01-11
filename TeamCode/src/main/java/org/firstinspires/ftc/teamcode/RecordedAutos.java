package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.robotHardware;
import org.firstinspires.ftc.teamcode.FullAutos;
import org.firstinspires.ftc.teamcode.BackAutos;
import org.firstinspires.ftc.teamcode.FrontAutos;

public class RecordedAutos {

    FullAutos full = new FullAutos();
    BackAutos back = new BackAutos();
    FrontAutos front = new FrontAutos();

    public void run_test(robotHardware robot, boolean ifMirror)
    {
        front.left_front_1(robot, ifMirror);
    }
}
