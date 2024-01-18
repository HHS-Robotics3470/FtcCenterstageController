package org.firstinspires.ftc.teamcode;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class SpikeDetectionPipeline extends OpenCvPipeline {

    int position = 0;

    Point point_x_0 = new Point(0,100);
    Point point_y_0 = new Point(90,200);

    Point point_x_1 = new Point(475, 150);
    Point point_y_1 = new Point(650, 250);

    Point point_x_2 = new Point(1100, 100);
    Point point_y_2 = new Point(1280, 200);



    @Override
    public Mat processFrame(Mat input) {
        Mat submat0 = input.submat(new Rect(point_x_0, point_y_0));
        Mat submat1 = input.submat(new Rect(point_x_1, point_y_1));
        Mat submat2 = input.submat(new Rect(point_x_2, point_y_2));

        Scalar averageColorSubmat0 = Core.mean(submat0);
        Scalar averageColorSubmat1 = Core.mean(submat1);
        Scalar averageColorSubmat2 = Core.mean(submat2);

        double redValueSubmat0 = averageColorSubmat0.val[0];
        double greenValueSubmat0 = averageColorSubmat0.val[1];
        double blueValueSubmat0 = averageColorSubmat0.val[2];

        double redValueSubmat1 = averageColorSubmat1.val[0];
        double greenValueSubmat1 = averageColorSubmat1.val[1];
        double blueValueSubmat1 = averageColorSubmat1.val[2];

        double redValueSubmat2 = averageColorSubmat2.val[0];
        double greenValueSubmat2 = averageColorSubmat2.val[1];
        double blueValueSubmat2 = averageColorSubmat2.val[2];

        boolean isSubmat0Red = (redValueSubmat0 > greenValueSubmat0 && redValueSubmat0 > blueValueSubmat0);
        boolean isSubmat0Blue = (blueValueSubmat0 > redValueSubmat0 && blueValueSubmat0 > greenValueSubmat0);

        boolean isSubmat1Red = (redValueSubmat1 > greenValueSubmat1 && redValueSubmat1 > blueValueSubmat1);
        boolean isSubmat1Blue = (blueValueSubmat1 > redValueSubmat1 && blueValueSubmat1 > greenValueSubmat1);

        boolean isSubmat2Red = (redValueSubmat2 > greenValueSubmat2 && redValueSubmat2 > blueValueSubmat2);
        boolean isSubmat2Blue = (blueValueSubmat2 > redValueSubmat2 && blueValueSubmat2 > greenValueSubmat2);

        if ((isSubmat1Blue || isSubmat1Red) && (redValueSubmat1 > 75 || blueValueSubmat1 > 75)) {
            position = 1;
        } else if ((isSubmat0Blue || isSubmat0Red) && (redValueSubmat0 > 75 || blueValueSubmat0 > 75)){
            position = 0;
        }else if ((isSubmat2Blue || isSubmat2Red) && (redValueSubmat2 > 75 || blueValueSubmat2 > 75)) {
            position = 2;
        } else {
            position = 0;
        }

        Imgproc.rectangle(input, point_x_1, point_y_1, averageColorSubmat1, 2);
        Imgproc.rectangle(input, point_x_0, point_y_0, averageColorSubmat0, 2);
        Imgproc.rectangle(input, point_x_2, point_y_2, averageColorSubmat2, 2);

        submat1.release();
        submat2.release();
        return input;

    }

    public int getSpikePosition(){
        return position;
    }
}
