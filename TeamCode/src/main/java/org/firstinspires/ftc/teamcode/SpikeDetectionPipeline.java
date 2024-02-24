package org.firstinspires.ftc.teamcode;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class SpikeDetectionPipeline extends OpenCvPipeline {

    int position = -1;

    Point point_x_0 = new Point(200,50);
    Point point_y_0 = new Point(300,150);

    Point point_x_1 = new Point(675, 0);
    Point point_y_1 = new Point(775, 100);

    Point point_x_2 = new Point(1150, 50);
    Point point_y_2 = new Point(1250, 150);

    public double redValueSubmat0;
    public double greenValueSubmat0;
    public double blueValueSubmat0;

    public double redValueSubmat1;
    public double greenValueSubmat1;
    public double blueValueSubmat1;

    public double redValueSubmat2;
    public double greenValueSubmat2;
    public double blueValueSubmat2;



    @Override
    public Mat processFrame(Mat input) {
        Mat submat0 = input.submat(new Rect(point_x_0, point_y_0));
        Mat submat1 = input.submat(new Rect(point_x_1, point_y_1));
        Mat submat2 = input.submat(new Rect(point_x_2, point_y_2));

        Scalar averageColorSubmat0 = Core.mean(submat0);
        Scalar averageColorSubmat1 = Core.mean(submat1);
        Scalar averageColorSubmat2 = Core.mean(submat2);

        redValueSubmat0 = averageColorSubmat0.val[0];
        greenValueSubmat0 = averageColorSubmat0.val[1];
        blueValueSubmat0 = averageColorSubmat0.val[2];

        redValueSubmat1 = averageColorSubmat1.val[0];
        greenValueSubmat1 = averageColorSubmat1.val[1];
        blueValueSubmat1 = averageColorSubmat1.val[2];

        redValueSubmat2 = averageColorSubmat2.val[0];
        greenValueSubmat2 = averageColorSubmat2.val[1];
        blueValueSubmat2 = averageColorSubmat2.val[2];

        boolean isSubmat0Red = (redValueSubmat0 > greenValueSubmat0 + 45 && redValueSubmat0 > blueValueSubmat0);
        boolean isSubmat0Blue = (blueValueSubmat0 > redValueSubmat0 && blueValueSubmat0 > greenValueSubmat0 + 45);

        boolean isSubmat1Red = (redValueSubmat1 > greenValueSubmat1 + 45 && redValueSubmat1 > blueValueSubmat1);
        boolean isSubmat1Blue = (blueValueSubmat1 > redValueSubmat1 && blueValueSubmat1 > greenValueSubmat1 + 45);

        boolean isSubmat2Red = (redValueSubmat2 > greenValueSubmat2 + 45 && redValueSubmat2 > blueValueSubmat2);
        boolean isSubmat2Blue = (blueValueSubmat2 > redValueSubmat2 && blueValueSubmat2 > greenValueSubmat2 + 45);



        if ((isSubmat1Blue || isSubmat1Red) || (redValueSubmat1 > 200 || blueValueSubmat1 > 200)) {
            position = 1;
        } else if ((isSubmat0Blue || isSubmat0Red) || (redValueSubmat0 > 200 || blueValueSubmat0 > 200)){
            position = 0;
        }else if ((isSubmat2Blue || isSubmat2Red) || (redValueSubmat2 > 200 || blueValueSubmat2 > 200)) {
            position = 2;
        } else {
            position = 3;
        }

        Imgproc.rectangle(input, point_x_1, point_y_1, new Scalar(0, 0, 0), 2);
        Imgproc.rectangle(input, point_x_0, point_y_0, new Scalar(0, 0, 0), 2);
        Imgproc.rectangle(input, point_x_2, point_y_2, new Scalar(0, 0, 0), 2);

        submat0.release();
        submat1.release();
        submat2.release();
        return input;

    }

    public int getSpikePosition(){
        if (position == -1) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            getSpikePosition();
        }
        return position;
    }
}
