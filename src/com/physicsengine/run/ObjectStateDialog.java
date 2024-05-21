package com.physicsengine.run;

import com.physicsengine.SimpleObject;
import com.physicsengine.util.Trig;

import javax.swing.*;
import java.awt.*;

public class ObjectStateDialog extends JDialog {
    private JLabel velocityLabel;
    private JLabel massLabel;
    private JLabel forceLabel;
    private JSlider applyForceSlider;

    public ObjectStateDialog() {
        setLayout(new GridLayout(4, 1));
        velocityLabel = new JLabel();
        massLabel = new JLabel();
        forceLabel = new JLabel();
        JPanel appliedForcePanel = new JPanel();
        JLabel appliedForceLabel = new JLabel("Applied Force: ");
        appliedForcePanel.setBorder(BorderFactory.createTitledBorder("Applied Force"));
        applyForceSlider = new JSlider(JSlider.HORIZONTAL, -10, 10, 0);
        appliedForcePanel.add(appliedForceLabel);
        appliedForcePanel.add(applyForceSlider);
        add(velocityLabel);
        add(massLabel);
        add(forceLabel);
        add(appliedForcePanel);
        setSize(300, 200);
        setTitle("Object State");

        // Set the font size
        Font font = new Font("Arial", Font.PLAIN, 20);
        velocityLabel.setFont(font);
        massLabel.setFont(font);
        forceLabel.setFont(font);
    }

    public void updateState(SimpleObject obj) {
        double velocityMagnitude = obj.getVelocity().magnitude;
        double velocityAngle = Trig.getAngle(obj.getVelocity().getX(), obj.getVelocity().getY());
        velocityLabel.setText("<html>Velocity: " + String.format("%.2f", velocityMagnitude) + "<br>Angle: " + String.format("%.2f", velocityAngle) + "</html>");

        massLabel.setText("Mass: " + String.format("%.2f", obj.getMass()));

        double forceMagnitude = obj.getLastAppliedForce().magnitude;
        double forceAngle = Trig.getAngle(obj.getLastAppliedForce().getX(), obj.getLastAppliedForce().getY());
        forceLabel.setText("<html>Sum of Forces: " + String.format("%.2f", forceMagnitude) + "<br>Angle: " + String.format("%.2f", forceAngle) + "</html>");
    }

    public int getSliderForce() {
        return applyForceSlider.getValue();
    }
}