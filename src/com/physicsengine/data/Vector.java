package com.physicsengine.data;

import com.physicsengine.util.Trig;

public class Vector {

    public double magnitude; // always positive
    public double angle; // restricted to 0-360 degrees

    public Vector(double magnitude, double angle) {
        this.magnitude = magnitude;
        this.angle = restrictAngle(angle);
    }

    public double getX() {
        return magnitude * Trig.cos(angle);
    }

    public double getY() {
        return magnitude * Trig.sin(angle);
    }

    public static Vector toVector(double x, double y) {
        return new Vector(Trig.hypotenuse(x, y), Trig.getAngle(x, y));
    }

    public static Vector add(Vector v1, Vector v2) {
        double x = v1.getX() + v2.getX();
        double y = v1.getY() + v2.getY();
        return toVector(x, y);
    }

    public static Vector subtract(Vector v1, Vector v2) {
        double x = v1.getX() - v2.getX();
        double y = v1.getY() - v2.getY();
        return toVector(x, y);
    }

    public static Vector multiply(Vector v, double scalar) {
        return new Vector(v.magnitude * scalar, v.angle);
    }

    public static Vector divide(Vector v, double scalar) {
        return new Vector(v.magnitude / scalar, v.angle);
    }

    public static double restrictAngle(double angle) {
        double newAngle = angle % 360;
        if (newAngle < 0) {
            newAngle += 360;
        }
        if(newAngle == 360)
            newAngle = 0;

        return newAngle;
    }

    @Override
    public String toString() {
        return "magnitude " + magnitude + ", angle " + angle + "°";
    }
}
