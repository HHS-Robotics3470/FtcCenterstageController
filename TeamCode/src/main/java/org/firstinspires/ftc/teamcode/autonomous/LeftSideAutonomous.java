//package org.firstinspires.ftc.teamcode.autonomous;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//import org.firstinspires.ftc.teamcode.RobotHardware;
//import org.firstinspires.ftc.teamcode.pipelines.SleeveDetectionPipeline;
//
//@Autonomous(name = "Left Side Autonomous", group = "Autonomous")
//public class LeftSideAutonomous extends LinearOpMode {
//
//    RobotHardware robot = new RobotHardware(this);
//    SleeveDetectionPipeline pipeline = new SleeveDetectionPipeline();
//
//
//    @Override
//    public void runOpMode() {
//        robot.init();
//        robot.initOpenCV(pipeline);
//
//        waitForStart();
//        if (opModeIsActive()) {
//            telemetry.addData("Status", "Tiiiiimothyyyy, I'm determining signal");
//            telemetry.update();
//            SleeveDetectionPipeline.ParkingPosition zone = pipeline.getSignal();
//            telemetry.addData("Status", "Yo Timbits, target zone determined");
//            telemetry.addData("Status", "Hey Timmy!!! I'm parking in the "+zone);
//            telemetry.addData("Status", "Timmy watch me! I'm playing the pre-recorded sequence");
//            telemetry.update();
////                MEDIUM JUNCTION STACK
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 0, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(0, 0, 0, 1, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(3, -1, -3, 5, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(6, -3, -3, 7, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(13, -8, -6, 12, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(23, -18, -16, 23, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(37, -34, -32, 39, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(56, -50, -46, 55, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(75, -69, -64, 74, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(93, -93, -86, 92, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(110, -114, -107, 109, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(126, -135, -127, 124, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(142, -158, -153, 142, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(162, -183, -174, 160, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(181, -206, -199, 179, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(201, -231, -224, 199, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(222, -256, -250, 220, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(240, -280, -274, 237, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(260, -307, -304, 259, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(273, -327, -324, 270, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(275, -337, -334, 272, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(274, -339, -337, 271, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(272, -338, -336, 270, 1.0, 1.0, 0, 0);
//            robot.setMovementPosition(272, -338, -336, 270, 1.0, 1.0, 19, 22);
//            robot.setMovementPosition(268, -340, -338, 264, 1.0, 1.0, 146, 134);
//            robot.setMovementPosition(257, -351, -350, 253, 1.0, 1.0, 235, 228);
//            robot.setMovementPosition(240, -368, -366, 237, 1.0, 1.0, 341, 329);
//            robot.setMovementPosition(221, -387, -385, 216, 1.0, 1.0, 444, 433);
//            robot.setMovementPosition(200, -409, -407, 196, 1.0, 1.0, 559, 546);
//            robot.setMovementPosition(177, -432, -430, 171, 1.0, 1.0, 682, 672);
//            robot.setMovementPosition(151, -458, -456, 146, 1.0, 1.0, 817, 803);
//            robot.setMovementPosition(127, -482, -480, 122, 1.0, 1.0, 950, 937);
//            robot.setMovementPosition(99, -509, -507, 94, 1.0, 1.0, 1099, 1084);
//            robot.setMovementPosition(65, -543, -541, 60, 1.0, 1.0, 1276, 1261);
//            robot.setMovementPosition(39, -568, -567, 34, 1.0, 1.0, 1415, 1399);
//            robot.setMovementPosition(12, -595, -594, 6, 1.0, 1.0, 1559, 1545);
//            robot.setMovementPosition(-16, -622, -621, -21, 1.0, 1.0, 1706, 1692);
//            robot.setMovementPosition(-44, -650, -649, -50, 1.0, 1.0, 1857, 1842);
//            robot.setMovementPosition(-73, -678, -677, -78, 1.0, 1.0, 2008, 1997);
//            robot.setMovementPosition(-101, -706, -705, -107, 1.0, 1.0, 2157, 2144);
//            robot.setMovementPosition(-130, -735, -734, -137, 1.0, 1.0, 2318, 2306);
//            robot.setMovementPosition(-163, -767, -765, -170, 1.0, 1.0, 2496, 2485);
//            robot.setMovementPosition(-191, -794, -794, -198, 1.0, 1.0, 2646, 2635);
//            robot.setMovementPosition(-220, -823, -821, -227, 1.0, 1.0, 2799, 2790);
//            robot.setMovementPosition(-248, -851, -850, -254, 1.0, 1.0, 2949, 2940);
//            robot.setMovementPosition(-276, -880, -877, -283, 1.0, 1.0, 3102, 3095);
//            robot.setMovementPosition(-305, -909, -907, -312, 1.0, 1.0, 3265, 3254);
//            robot.setMovementPosition(-333, -936, -935, -339, 1.0, 1.0, 3420, 3409);
//            robot.setMovementPosition(-366, -970, -969, -372, 1.0, 1.0, 3533, 3519);
//            robot.setMovementPosition(-412, -1015, -1014, -416, 1.0, 1.0, 3554, 3548);
//            robot.setMovementPosition(-437, -1043, -1042, -444, 1.0, 1.0, 3698, 3693);
//            robot.setMovementPosition(-469, -1073, -1071, -475, 1.0, 1.0, 3858, 3852);
//            robot.setMovementPosition(-498, -1102, -1101, -505, 1.0, 1.0, 4003, 3998);
//            robot.setMovementPosition(-527, -1130, -1130, -533, 1.0, 1.0, 4157, 4154);
//            robot.setMovementPosition(-556, -1160, -1159, -562, 1.0, 1.0, 4310, 4304);
//            robot.setMovementPosition(-587, -1190, -1190, -594, 1.0, 1.0, 4472, 4466);
//            robot.setMovementPosition(-621, -1225, -1225, -627, 1.0, 1.0, 4654, 4647);
//            robot.setMovementPosition(-652, -1253, -1255, -657, 1.0, 1.0, 4808, 4805);
//            robot.setMovementPosition(-684, -1284, -1288, -691, 1.0, 1.0, 4855, 4853);
//            robot.setMovementPosition(-715, -1316, -1318, -721, 1.0, 1.0, 4881, 4876);
//            robot.setMovementPosition(-747, -1347, -1351, -751, 1.0, 1.0, 4879, 4878);
//            robot.setMovementPosition(-773, -1376, -1378, -780, 1.0, 1.0, 4879, 4878);
//            robot.setMovementPosition(-806, -1407, -1410, -812, 1.0, 1.0, 4871, 4877);
//            robot.setMovementPosition(-838, -1441, -1442, -845, 1.0, 1.0, 4865, 4874);
//            robot.setMovementPosition(-867, -1471, -1472, -874, 1.0, 1.0, 4856, 4861);
//            robot.setMovementPosition(-896, -1499, -1502, -905, 1.0, 1.0, 4852, 4857);
//            robot.setMovementPosition(-928, -1533, -1533, -936, 1.0, 1.0, 4845, 4848);
//            robot.setMovementPosition(-957, -1562, -1562, -964, 1.0, 1.0, 4838, 4843);
//            robot.setMovementPosition(-985, -1591, -1591, -994, 1.0, 1.0, 4838, 4842);
//            robot.setMovementPosition(-1014, -1620, -1620, -1023, 1.0, 1.0, 4835, 4837);
//            robot.setMovementPosition(-1045, -1652, -1651, -1055, 1.0, 1.0, 4830, 4835);
//
//            robot.setMovementPosition(-1357, -2048, -2043, -1371, 1.0, 1.0, 4827, 4831);
//            robot.setMovementPosition(-1359, -2046, -2042, -1371, 1.0, 1.0, 4827, 4831);
//            robot.setMovementPosition(-1359, -2046, -2042, -1371, 1.0, 1.0, 4827, 4831);
//            robot.setMovementPosition(-1359, -2046, -2042, -1371, 1.0, 1.0, 4827, 4831);
//            robot.setMovementPosition(-1358, -2046, -2042, -1371, 1.0, 1.0, 4827, 4831);
//            robot.setMovementPosition(-1355, -2049, -2043, -1367, 1.0, 1.0, 4827, 4831);
//            robot.setMovementPosition(-1345, -2057, -2050, -1358, 1.0, 1.0, 4827, 4831);
//            robot.setMovementPosition(-1331, -2074, -2065, -1344, 1.0, 1.0, 4827, 4831);
//            robot.setMovementPosition(-1314, -2091, -2086, -1324, 1.0, 1.0, 4827, 4831);
//            robot.setMovementPosition(-1296, -2106, -2098, -1308, 1.0, 1.0, 4827, 4831);
//            robot.setMovementPosition(-1284, -2111, -2098, -1304, 1.0, 1.0, 4827, 4831);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 4827, 4830);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 4827, 4830);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 4827, 4830);
//
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 4827, 4830);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 4713, 4711);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 4544, 4554);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 4330, 4376);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 4164, 4246);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 4002, 4117);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 3848, 3986);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 3706, 3850);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 3575, 3708);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 3444, 3554);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 3326, 3415);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 3178, 3250);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 3045, 3103);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 2904, 2951);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 2760, 2797);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 2612, 2645);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 2459, 2486);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 2314, 2336);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 2159, 2177);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 1974, 1988);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 1821, 1832);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 1668, 1677);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 1518, 1528);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 1366, 1370);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 1216, 1218);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 1.0, 1.0, 1060, 1060);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 0.0, 1.0, 883, 884);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 0.0, 1.0, 698, 697);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 0.0, 1.0, 543, 541);
//            robot.setMovementPosition(-1285, -2111, -2097, -1304, 0.0, 1.0, 386, 383);
//            robot.setMovementPosition(-1285, -2111, -2097, -1305, 0.0, 1.0, 232, 229);
//            robot.setMovementPosition(-1285, -2111, -2097, -1306, 0.0, 1.0, 78, 76);
//            robot.setMovementPosition(-1285, -2111, -2097, -1307, 0.0, 1.0, 4, -1);
//            robot.setMovementPosition(-1286, -2111, -2097, -1307, 0.0, 1.0, -17, -33);
//            robot.setMovementPosition(-1286, -2111, -2097, -1307, 0.0, 1.0, -54, -48);
//            robot.setMovementPosition(-1286, -2111, -2097, -1307, 0.0, 1.0, -54, -70);
//            robot.setMovementPosition(-1286, -2111, -2097, -1307, 0.0, 1.0, -54, -69);
//            robot.setMovementPosition(-1286, -2111, -2097, -1307, 0.0, 1.0, -50, -68);
//            robot.setMovementPosition(-1286, -2111, -2097, -1307, 0.0, 1.0, -46, -67);
//            robot.setMovementPosition(-1285, -2111, -2097, -1307, 0.0, 1.0, -44, -63);
//            robot.setMovementPosition(-1285, -2111, -2097, -1307, 0.0, 1.0, -41, -56);
//            robot.setMovementPosition(-1285, -2111, -2097, -1307, 0.0, 1.0, -37, -52);
//            robot.setMovementPosition(-1285, -2111, -2097, -1307, 0.0, 1.0, -36, -47);
//            robot.setMovementPosition(-1285, -2111, -2097, -1307, 0.0, 1.0, -30, -45);
//            robot.setMovementPosition(-1285, -2111, -2097, -1307, 0.0, 1.0, -30, -43);
//            robot.setMovementPosition(-1285, -2111, -2097, -1307, 0.0, 1.0, -30, -40);
//            robot.setMovementPosition(-1285, -2111, -2097, -1307, 0.0, 1.0, -27, -40);
//            robot.setMovementPosition(-1285, -2111, -2097, -1307, 0.0, 1.0, -27, -39);
//            robot.setMovementPosition(-1289, -2107, -2093, -1311, 0.0, 1.0, -26, -39);
//            robot.setMovementPosition(-1293, -2102, -2089, -1313, 0.0, 1.0, -26, -39);
//            robot.setMovementPosition(-1301, -2093, -2081, -1322, 0.0, 1.0, -26, -39);
//            robot.setMovementPosition(-1318, -2079, -2067, -1337, 0.0, 1.0, -25, -39);
//            robot.setMovementPosition(-1334, -2065, -2050, -1354, 0.0, 1.0, -25, -39);
//            robot.setMovementPosition(-1353, -2045, -2031, -1372, 0.0, 1.0, -25, -39);
//            robot.setMovementPosition(-1372, -2026, -2013, -1392, 0.0, 1.0, -25, -37);
//            robot.setMovementPosition(-1391, -2007, -1991, -1413, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1413, -1983, -1970, -1434, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1436, -1961, -1949, -1456, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1460, -1936, -1922, -1483, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1484, -1913, -1900, -1506, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1505, -1891, -1877, -1526, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1515, -1881, -1865, -1538, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -25, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -26, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -26, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -26, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -27, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -28, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -28, -36);
//            robot.setMovementPosition(-1514, -1881, -1865, -1538, 0.0, 1.0, -28, -36);
//
//            robot.resetEncoders();
////                MOVE SIGNAL AWAY
//            robot.driveDistance(20);
//            robot.driveDistance(-7);
//            robot.resetEncoders();
////                MOVE TO CYCLING START POINT
//            robot.openGrabber();
////              CYCLE
//            robot.setLiftPosition(700);
//            robot.strafeDistance(-29);
//            robot.closeGrabber();
//            sleep(500);
//            robot.setLiftPosition(6000);
//            sleep(500);
//            robot.strafeDistance(29);
//            robot.activateFlipper();
//            robot.driveDistance(8);
//            robot.strafeDistance(6);
//            robot.setLiftPosition(0);
//            sleep(500);
//            robot.openGrabber();
//            robot.strafeDistance(-6);
//            robot.driveDistance(-8);
//
//
////                CYCLE
////                MOVE TO PARKING
//            switch (zone){
//                case RIGHT:
//                    robot.strafeDistance(28);
//                    robot.driveDistance(-4);
//                    break;
//                case LEFT:
//                    robot.strafeDistance(-28);
//                    robot.driveDistance(-4);
//                    break;
//                case CENTER:
//                    break;
//            }
//
//            stop();
//        }
//    }
//}