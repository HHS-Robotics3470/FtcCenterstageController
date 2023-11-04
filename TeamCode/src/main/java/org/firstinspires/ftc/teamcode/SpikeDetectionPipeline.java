package org.firstinspires.ftc.teamcode;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.openftc.easyopencv.OpenCvPipeline;

public class SpikeDetectionPipeline extends OpenCvPipeline {

    int position = 1;

    Point point_x_1 = new Point(100, 300);

    Point point_x_2 = new Point(300, 500);
    Point point_x_3 = new Point(600, 75);
    Point point_y_1 = new Point(750, 200);

    Point point_y_2 = new Point(1000, 500);
    Point point_y_3 = new Point(1100, 700);



    @Override
    public Mat processFrame(Mat input) {
        Mat submat1 = input.submat(new Rect(point_x_1, point_y_1));
        Mat submat2 = input.submat(new Rect(point_x_2, point_y_2));
        Mat submat3 = input.submat(new Rect(point_x_3, point_y_3));



        submat1.release();
        submat2.release();
        submat3.release();
        return input;

    }

    public int getSpikePosition(){
        return position;
    }
}
