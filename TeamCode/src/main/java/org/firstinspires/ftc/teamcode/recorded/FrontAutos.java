package org.firstinspires.ftc.teamcode.recorded;

import org.firstinspires.ftc.teamcode.recorded.RunAutos;
import org.firstinspires.ftc.teamcode.robotHardware;

public class FrontAutos extends RunAutos {
    public void run_0(robotHardware robot, boolean ifMirror)
    {
        double n = 1;
        if (ifMirror)
            n *= -1;
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
        //strafe to board
        for (int katti = 0; katti < 100; katti++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 900, -900, -900, 900, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
        //rotate 90
        for (int gavin = 0; gavin < 100; gavin++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, -730, 730, -730, 730, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        if(!ifMirror) {
            robot.resetEncoders();
            //strafe to orient to pos
            for (int poop = 0; poop < 100; poop++) {
                robot.setMovementPosition(0.0, 0.0, 0.0, -600, 600, 600, -600, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
            }
        }
        if(ifMirror){
            robot.resetEncoders();
            //strafe to orient to pos
            for (int poop = 0; poop < 100; poop++) {
                robot.setMovementPosition(0.0, 0.0, 0.0, -600, 600, 600, -600, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
            }
        }
        if (!ifMirror) {
            robot.resetEncoders();
            //move towards board
            for (int chanelle = 0; chanelle < 100; chanelle++) {
                robot.setMovementPosition(0.0, 0.0, 0.0, 195, 195, 195, 195, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
            }
        }
        if(ifMirror){
            robot.resetEncoders();
            //move towards board
            for (int chanelle = 0; chanelle < 100; chanelle++) {
                robot.setMovementPosition(0.0, 0.0, 0.0, 275, 275, 275, 275, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
            }
        }
        robot.resetEncoders();
        //raise lift
        for (int lucas = 0; lucas < 100; lucas++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 0, 0, 0, 0, -1600, -1600, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //swing arm out
        for (int areeb = 0; areeb < 100; areeb++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 0, 0, 0, 0, -1600, -1600, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //lower lift slightly
        for (int me = 0; me < 100; me++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 0, 0, 0, 0, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //move towards board
        for (int adeel = 0; adeel < 100; adeel++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 225, 225, 225, 225, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //Open Claw
        for (int asd = 0; asd < 100; asd++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 225, 225, 225, 225, -1100, -1100, false, 0.95, 0.34, 0.0315, 0.1, 0.11, false, ifMirror);
        }
        //Close Claw
        for (int pardi = 0; pardi < 100; pardi++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 225, 225, 225, 225, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //back up
        for (int sraditya = 0; sraditya < 100; sraditya++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 100, 100, 100, 100, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //reraise lift
        for (int asda = 0; asda < 100; asda++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 100, 100, 100, 100, -1600, -1600, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //reset arm
        for (int parthiv = 0; parthiv < 100; parthiv++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 100, 100, 100, 100, -1700, -1700, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //lower lift
        for (int areebyoung = 0; areebyoung < 100; areebyoung++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 100, 100, 100, 100, 200, 200, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
        //strafe to park
        for (int lol = 0; lol < 100; lol++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 700, -750, -750, 750, 300, 300, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
    }

    public void run_1(robotHardware robot, boolean ifMirror) {
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
        //strafe to board
        for (int katti = 0; katti < 100; katti++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 1650, -150, -150, 1650, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
        //rotate 90
        for (int gavin = 0; gavin < 100; gavin++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, -740, 740, -740, 740, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
        //strafe to orient to pos
        for (int poop = 0; poop < 100; poop++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, -120, 120, 120, -120, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
        //move towards board
        for (int chanelle = 0; chanelle < 100; chanelle++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 200, 200, 200, 200, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
        //raise lift
        for (int lucas = 0; lucas < 100; lucas++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 0, 0, 0, 0, -1600, -1600, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //swing arm out
        for (int areeb = 0; areeb < 100; areeb++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 0, 0, 0, 0, -1600, -1600, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //lower lift slightly
        for (int me = 0; me < 100; me++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 0, 0, 0, 0, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //move towards board
        for (int adeel = 0; adeel < 100; adeel++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 325, 325, 325, 325, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //Open Claw
        for (int asd = 0; asd < 100; asd++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 350, 350, 350, 350, -1100, -1100, false, 0.95, 0.34, 0.0315, 0.1, 0.11, false, ifMirror);
        }
        //Close Claw
        for (int pardi = 0; pardi < 100; pardi++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 350, 350, 350, 350, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //back up
        for (int sraditya = 0; sraditya < 100; sraditya++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 150, 150, 150, 150, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //reraise lift
        for (int asda = 0; asda < 100; asda++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 150, 150, 150, 150, -1600, -1600, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //reset arm
        for (int parthiv = 0; parthiv < 100; parthiv++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 150, 150, 150, 150, -1700, -1700, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //lower lift
        for (int areebyoung = 0; areebyoung < 100; areebyoung++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 150, 150, 150, 150, 200, 200, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
        //strafe to park
        for (int lol = 0; lol < 100; lol++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 700, -750, -750, 750, 300, 300, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
    }



    public void run_2(robotHardware robot, boolean ifMirror)
    {
        double n = 0;
        if (ifMirror)
            n *= -1;
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
        //strafe to board
        for (int katti = 0; katti < 100; katti++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 800, -800, -800, 800, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        if(!ifMirror) {
            robot.resetEncoders();
            //rotate 90
            for (int gavin = 0; gavin < 100; gavin++) {
                robot.setMovementPosition(0.0, 0.0, 0.0, -720, 720, -720, 720, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
            }
        }
        if(ifMirror) {
            robot.resetEncoders();
            //rotate 90
            for (int gavin = 0; gavin < 100; gavin++) {
                robot.setMovementPosition(0.0, 0.0, 0.0, -700, 700, -700, 700, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
            }
        }
        if(!ifMirror) {
            robot.resetEncoders();
            //strafe to orient to pos
            for (int poop = 0; poop < 100; poop++) {
                robot.setMovementPosition(0.0, 0.0, 0.0, -150, 150, 150, -150, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
            }
        }
        if(ifMirror){
            robot.resetEncoders();
            //strafe to orient to pos
            for (int poop = 0; poop < 100; poop++) {
                robot.setMovementPosition(0.0, 0.0, 0.0, -70, 70, 70, -70, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
            }
        }
        if(!ifMirror) {
            robot.resetEncoders();
            //move towards board
            for (int chanelle = 0; chanelle < 100; chanelle++) {
                robot.setMovementPosition(0.0, 0.0, 0.0, 75, 75, 75, 75, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
            }
        }
        if(ifMirror){
            robot.resetEncoders();
            //move towards board
            for (int chanelle = 0; chanelle < 100; chanelle++) {
                robot.setMovementPosition(0.0, 0.0, 0.0, 175, 175, 175, 175, 0, 0, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
            }
        }
        robot.resetEncoders();
        //raise lift
        for (int lucas = 0; lucas < 100; lucas++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 0, 0, 0, 0, -1600, -1600, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //swing arm out
        for (int areeb = 0; areeb < 100; areeb++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 0, 0, 0, 0, -1600, -1600, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //lower lift slightly
        for (int me = 0; me < 100; me++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 0, 0, 0, 0, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //move towards board
        for (int adeel = 0; adeel < 100; adeel++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 150, 150, 150, 150, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //Open Claw
        for (int asd = 0; asd < 100; asd++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 150, 150, 150, 150, -1100, -1100, false, 0.95, 0.34, 0.0315, 0.1, 0.11, false, ifMirror);
        }
        //Close Claw
        for (int pardi = 0; pardi < 100; pardi++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 150, 150, 150, 150, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //back up
        for (int sraditya = 0; sraditya < 100; sraditya++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 50, 50, 50, 50, -1100, -1100, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //reraise lift
        for (int asda = 0; asda < 100; asda++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 50, 50, 50, 50, -1600, -1600, false, 0.95, 0.34, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //reset arm
        for (int parthiv = 0; parthiv < 100; parthiv++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 50, 50, 50, 50, -1700, -1700, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        //lower lift
        for (int areebyoung = 0; areebyoung < 100; areebyoung++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 50, 50, 50, 50, 200, 200, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
        //strafe to park
        for (int lol = 0; lol < 100; lol++) {
            robot.setMovementPosition(0.0, 0.0, 0.0, 700, -750, -750, 750, 300, 300, false, 0.02, 0.47, 0.049, 0.1, 0.11, false, ifMirror);
        }
        robot.resetEncoders();
    }

}
