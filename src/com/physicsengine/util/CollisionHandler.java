package com.physicsengine.util;

import com.physicsengine.SimpleObject;

public class CollisionHandler {

    public static void handleLinearCollision(SimpleObject obj1, SimpleObject obj2, boolean isElastic) {
        double m1 = obj1.getMass();
        double m2 = obj2.getMass();
        double v1i = obj1.getVelocity().magnitude;
        double v2i = obj2.getVelocity().magnitude;

        if (isElastic) {
            double v1f = ((m1 - m2) * v1i + 2 * m2 * v2i) / (m1 + m2);
            double v2f = ((m2 - m1) * v2i + 2 * m1 * v1i) / (m1 + m2);
            obj1.getVelocity().magnitude = v1f;
            obj2.getVelocity().magnitude = v2f;
        } else {
            double v1f = Math.sqrt((m1 * v1i * v1i + m2 * v2i * v2i) / (m1 + m2));
            double v2f = v1f; // combined system after collision
            obj1.getVelocity().magnitude = v1f;
            obj2.getVelocity().magnitude = v2f;
        }
    }

    public static void handle2DCollision(SimpleObject obj1, SimpleObject obj2, boolean isElastic) {
        double m1 = obj1.getMass();
        double m2 = obj2.getMass();

        double v1ix = obj1.getVelocity().getX();
        double v1iy = obj1.getVelocity().getY();
        double v2ix = obj2.getVelocity().getX();
        double v2iy = obj2.getVelocity().getY();

        if (isElastic) {
            double v1fx = ((m1 - m2) * v1ix + 2 * m2 * v2ix) / (m1 + m2);
            double v1fy = ((m1 - m2) * v1iy + 2 * m2 * v2iy) / (m1 + m2);

            double v2fx = ((m2 - m1) * v2ix + 2 * m1 * v1ix) / (m1 + m2);
            double v2fy = ((m2 - m1) * v2iy + 2 * m1 * v1iy) / (m1 + m2);

            obj1.getVelocity().magnitude = Math.sqrt(v1fx * v1fx + v1fy * v1fy);
            obj1.getVelocity().angle = Trig.getAngle(v1fx, v1fy);

            obj2.getVelocity().magnitude = Math.sqrt(v2fx * v2fx + v2fy * v2fy);
            obj2.getVelocity().angle = Trig.getAngle(v2fx, v2fy);
        } else {
            double v1f = Math.sqrt((m1 * (v1ix * v1ix + v1iy * v1iy) + m2 * (v2ix * v2ix + v2iy * v2iy)) / (m1 + m2));
            double v2f = v1f; // combined system after collision

            obj1.getVelocity().magnitude = v1f;
            obj1.getVelocity().angle = Trig.getAngle(v1ix, v1iy);

            obj2.getVelocity().magnitude = v2f;
            obj2.getVelocity().angle = Trig.getAngle(v2ix, v2iy);
        }
    }

}
