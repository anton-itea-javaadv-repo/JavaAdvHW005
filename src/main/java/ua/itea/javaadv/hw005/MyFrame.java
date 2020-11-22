package ua.itea.javaadv.hw005;

import org.apache.commons.io.IOUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MyFrame extends JFrame {
    public MyFrame() {
        super("Six labels frame");
        URL urlIn  = MyFrame.class.getResource("/in.txt");
        URL urlInPng  = MyFrame.class.getResource("/in.png");
        URL urlOut;
        try {
            urlOut = new File("out.txt").toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        URL urlOutPng;
        try {
            urlOutPng = new File("out.png").toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        String inTxt;
        try {
            inTxt = IOUtils.toString(urlIn, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        String outTxt;
        try {
            outTxt = IOUtils.toString(urlOut, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        JLabel labelInPng = new JLabel(new ImageIcon(urlInPng));

        JTextArea textAreaInPng = new JTextArea();
        textAreaInPng.setText(urlInPng.getPath());
        textAreaInPng.setEditable(false);

        JTextArea textAreaIn1 = new JTextArea();
        textAreaIn1.setText(inTxt);
        textAreaIn1.setEditable(false);

        JTextArea textAreaIn2 = new JTextArea();
        textAreaIn2.setText(urlIn.getPath());
        textAreaIn2.setEditable(false);

        JLabel labelOutPng = new JLabel(new ImageIcon(urlOutPng));

        JTextArea textAreaOutPng = new JTextArea();
        textAreaOutPng.setText(urlOutPng.getPath());
        textAreaOutPng.setEditable(false);

        JTextArea textAreaOut1 = new JTextArea();
        textAreaOut1.setText(outTxt);
        textAreaOut1.setEditable(false);

        JTextArea textAreaOut2 = new JTextArea();
        textAreaOut2.setText(urlOut.getPath());
        textAreaOut2.setEditable(false);

        Container contentPane = getContentPane();

        BoxLayout boxLayout = new BoxLayout(contentPane, BoxLayout.PAGE_AXIS);
        setLayout(boxLayout);

        contentPane.add(labelInPng);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(textAreaInPng);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(textAreaIn1);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(textAreaIn2);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(labelOutPng);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(textAreaOutPng);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(textAreaOut1);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(textAreaOut2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
