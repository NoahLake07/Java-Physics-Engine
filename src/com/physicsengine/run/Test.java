package com.physicsengine.run;

import com.physicsengine.SimpleObject;
import com.physicsengine.data.Vector;
import com.physicsengine.util.CollisionHandler;

public class Test {

    public static void simulateMotion() {
        // Step 1: Create a SimpleObject
        Vector initialVelocity = new Vector(0, 0);
        double mass = 1.0;
        SimpleObject obj = new SimpleObject(mass, initialVelocity);

        // Step 2: Define a constant force
        Vector force = new Vector(1, 0); // Force of 1 unit in the x-direction

        long lastTime = System.nanoTime(); // Get the current time

        // Create the dialog box
        ObjectStateDialog dialog = new ObjectStateDialog();
        dialog.setVisible(true);

        while(true) {
            // Apply the force at each time step
            force = new Vector(dialog.getSliderForce(), 0);
            obj.applyForce(force);

            long currentTime = System.nanoTime(); // Get the current time
            double Δtime = (currentTime - lastTime) / 1_000_000_000.0; // calculate time difference since last iteration
            lastTime = currentTime; // Update the last time

            obj.updateVelocity(Δtime);

            // Update the dialog box
            dialog.updateState(obj);
        }
    }

    public static void simulateCollision() {
        // Step 1: Create two SimpleObjects
        Vector initialVelocity1 = new Vector(1, 180);
        Vector initialVelocity2 = new Vector(1, 0); // Different initial velocity for the second object
        double mass1 = 1.0;
        double mass2 = 2.0; // Different mass for the second object
        SimpleObject obj1 = new SimpleObject(mass1, initialVelocity1);
        SimpleObject obj2 = new SimpleObject(mass2, initialVelocity2);

        long lastTime = System.nanoTime(); // Get the current time

        // Create the dialog box
        TwoObjectStateDialog dialog = new TwoObjectStateDialog();
        dialog.setVisible(true);

        while(true) {
            if (!dialog.simulationStarted) {
                continue;
            }

            long currentTime = System.nanoTime(); // Get the current time
            double Δtime = (currentTime - lastTime) / 1_000_000_000.0; // calculate time difference since last iteration
            lastTime = currentTime;

            obj1.updateVelocity(Δtime);
            obj1.updateDisplacement(Δtime);

            obj2.updateVelocity(Δtime);
            obj2.updateDisplacement(Δtime);

            // Check for collision and handle it
            if (dialog.doCollision) {
                CollisionHandler.handle2DCollision(obj1, obj2, true);
                dialog.doCollision = false;
            }

            // Update the dialog box
            dialog.updateState(obj1, obj2); // Update state of both objects
        }
    }

    public static void main(String[] args) {
        simulateCollision();
    }
}
