package com.physicsengine.run;

import com.physicsengine.SimpleObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoObjectStateDialog extends JDialog {

    private JLabel textField1;
    private JLabel textField2;
    private JButton startButton;
    public boolean simulationStarted = true;
    public boolean doCollision = false;

    public TwoObjectStateDialog() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(300, 200);

        textField1 = new JLabel();
        textField2 = new JLabel();
        startButton = new JButton("Start Simulation");

        add(new JLabel("Object 1 State:"));
        add(textField1);

        add(new JLabel("Object 2 State:"));
        add(textField2);

        add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doCollision = true;
            }
        });

        pack();
    }

    public void updateState(SimpleObject obj1, SimpleObject obj2) {
        if (obj1 != null) {
            textField1.setText(obj1.toString());
        }

        if (obj2 != null) {
            textField2.setText(obj2.toString());
        }
    }

}
