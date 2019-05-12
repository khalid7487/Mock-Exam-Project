package javaexam;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class QuesFrame extends JFrame {

    JLabel queNO, timer;
    int maxQue = 1, quesNo = 1;
    TextArea qArea;
    JCheckBox answer[], mark;
    JPanel top, center, bottom;
    JButton next, previous, grade, review;
    String quesOption[][];
    boolean ansOption[][];

    public QuesFrame() {
        quesOption = new String[40][7];
        ansOption = new boolean[40][6];
        queNO = new JLabel();
        timer = new JLabel("", JLabel.RIGHT);
        qArea = new TextArea();
        answer = new JCheckBox[5];
        mark = new JCheckBox("Mark");
        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();
        center.setFont(new Font("Serieff", Font.PLAIN, 12));
        center.setLayout(new GridLayout(5, 1));
        top.setLayout(new BorderLayout());
        top.add(queNO, BorderLayout.WEST);
        top.add(mark, BorderLayout.EAST);
        for (int i = 0; i < 5; i++) {
            answer[i] = new JCheckBox();
            answer[i].addItemListener(null);
            center.add(answer[i]);
        }
        bottom.setLayout(new GridLayout(1, 5));
        next = new JButton("Next");
        previous = new JButton("Previous");
        grade = new JButton("Grade");
        review = new JButton("Review");
        previous.setEnabled(false);
        bottom.add(next);
        bottom.add(previous);
        bottom.add(grade);
        bottom.add(review);
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(bottom, BorderLayout.SOUTH);
        getContentPane().add(center, BorderLayout.CENTER);
        next.addActionListener(null);
        previous.addActionListener(null);
        grade.addActionListener(null);
        review.addActionListener(null);

        setTitle("Java Mock Exam Syatem");
    }
}

class Question {

    RandomAccessFile file;
    String quesOption[][] = new String[40][7];

    public Question() {

        try {
            file = new RandomAccessFile("Question.txt", "r");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Question.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    String[][] getQuestion() {
        StringBuffer s1;
        try {
            for (int i = 0; i < 40; i++) {
                StringBuffer sb1 = new StringBuffer();
                b1:
                while (true) {
                    String temp = new String(file.readLine());
                    if (temp.equals("##-------Question----------##")) {
                        int k = (int) Math.ceil(Math.random() * 2);
                        switch (k) {
                            case 2:
                                break b1;
                        }
                    }
                }
                while (true) {
                    s1=new StringBuffer(file.readLine());
                    if (new String(s1).equals("##-------Question----------##"))
                    break;
                }else if(){
                               
                }
            }
        } catch (Exception e) {
        }
        return quesOption;
    }
}
