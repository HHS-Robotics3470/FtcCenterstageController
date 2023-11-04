package org.firstinspires.ftc.teamcode;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.openftc.easyopencv.OpenCvPipeline;

public class SpikeDetectionPipeline extends OpenCvPipeline {

    int position = 1;
    public static int REGION_WIDTH = 200;
    public static int REGION_HEIGHT = 180;

    Point point_x_1 = new Point();

    Point point_x_2 = new Point();
    Point point_x_3 = new Point();
    Point point_y_1 = new Point();

    Point point_y_2 = new Point();
    Point point_y_3 = new Point();



    @Override
    public Mat processFrame(Mat input) {
        return null;
    }

    public int getSpikePosition(){
        return position;
    }
}
