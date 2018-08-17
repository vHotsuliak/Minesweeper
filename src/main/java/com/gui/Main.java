package com.gui;

import com.logics.Easy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main {
    private static final JPanel controlPanel = new JPanel();
    private static final GUIBoard board = new GUIBoard();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame frame = new JFrame();
            frame.setTitle("Minesweeper");
            frame.setLayout(new BorderLayout());
            frame.setSize(650, 750);
            frame.add(board, BorderLayout.CENTER);
            board.setBorder(new EmptyBorder(10, 20, 10, 20));
            frame.add(controlPanel, BorderLayout.PAGE_END);
            controlPanel.setLayout(new FlowLayout());
            final JButton generate = new JButton("Start");
            generate.addActionListener(
                    new GUIAction(
                            new GUIGeneratorBoard((byte) 25), board, new Easy()));
            controlPanel.add(generate);
            centre(frame);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    closePerform(frame);
                }
            });
            frame.setVisible(true);
        });
    }

    private static void centre(Window w) {
        Dimension us = w.getSize();
        Dimension them = Toolkit.getDefaultToolkit().getScreenSize();
        int newX = (them.width - us.height) / 2;
        int newY = (them.height - us.width) / 2;
        w.setLocation(newX, newY);
    }

    private static void closePerform(JFrame frame) {
        frame.setVisible((false));
        frame.dispose();
        System.exit(0);
    }
}
