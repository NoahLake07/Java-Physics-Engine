package com.physicsengine.util;

public class Trig {

    public static double sin(double deg){
        return Math.sin(Math.toRadians(deg));
    }

    public static double cos(double deg){
        return Math.cos(Math.toRadians(deg));
    }

    public static double tan(double deg){
        return Math.tan(Math.toRadians(deg));
    }

    public static double asin(double value){
        return Math.toDegrees(Math.asin(value));
    }

    public static double acos(double value){
        return Math.toDegrees(Math.acos(value));
    }

    public static double atan(double value){
        return Math.toDegrees(Math.atan(value));
    }

    public static double hypotenuse(double a, double b){
        return Math.hypot(a, b);
    }

    public static double getAngle(double x, double y){
        return Math.toDegrees(Math.atan2(y, x));
    }

}
