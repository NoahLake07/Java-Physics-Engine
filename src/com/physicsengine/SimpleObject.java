package com.physicsengine;

import com.physicsengine.data.Vector;

public class SimpleObject {

    double mass;
    Vector velocity, sumOfForces, lastAppliedForce, displacement;

    public SimpleObject(double mass, Vector velocity) {
        this.mass = mass;
        this.velocity = velocity;
        this.sumOfForces = new Vector(0, 0); // Initialize to zero
        this.lastAppliedForce = new Vector(0, 0); // Initialize to zero
        this.displacement = new Vector(0, 0); // Initialize to zero
    }

    public void applyForce(Vector force) {
        this.sumOfForces = Vector.add(this.sumOfForces, force);
        this.lastAppliedForce = new Vector(this.sumOfForces.getX(), this.sumOfForces.getY());
    }

    public void updateVelocity(double time) {
        Vector acceleration = Vector.divide(this.sumOfForces, this.mass);
        Vector deltaV = Vector.multiply(acceleration, time);
        this.velocity = Vector.add(this.velocity, deltaV);
        this.sumOfForces = new Vector(0, 0); // Reset forces
    }

    public void updateDisplacement(double time) {
        Vector deltaD = Vector.multiply(this.velocity, time);
        this.displacement = Vector.add(this.displacement, deltaD);
    }

    public Vector getVelocity() {
        return this.velocity;
    }

    public Vector getLastAppliedForce(){
        return this.lastAppliedForce;
    }

    public double getMass(){
        return this.mass;
    }

    public Vector getDisplacement(){
        return this.displacement;
    }

    public String toString(){
        return "Mass: " + this.mass + ", Velocity: " + this.velocity + ", Displacement: " + this.displacement;
    }
}
