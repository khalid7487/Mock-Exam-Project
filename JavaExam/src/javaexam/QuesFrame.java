package javaexam;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
    Question ques;

    public QuesFrame() {
        quesOption = new String[40][7];
        ansOption = new boolean[40][6];
        ques = new Question();
        quesOption = ques.getQuestions();
        queNO = new JLabel();
        timer = new JLabel("", JLabel.RIGHT);
        qArea = new TextArea();
        answer = new JCheckBox[5];
        mark = new JCheckBox("Mark");
        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();
        center.setLayout(new GridLayout(5, 1));
        top.setLayout(new BorderLayout());
        top.add(queNO, BorderLayout.WEST);
        top.add(mark, BorderLayout.EAST);
        top.add(qArea, BorderLayout.SOUTH);
        for (int i = 0; i < 5; i++) {
            answer[i] = new JCheckBox();
            answer[i].addItemListener(new ItemList());
            center.add(answer[i]);
            answer[i].setFont(new Font("Serieff", Font.PLAIN, 12));
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
        makeQues(1);
        next.addActionListener(new ActionList());
        previous.addActionListener(new ActionList());
        grade.addActionListener(new ActionList());
        review.addActionListener(new ActionList());
        setTitle("Java Mock Exam Syatem");
    }

    void makeQues(int num) {
        if (num > 0 && num < 41) {
            queNO.setText("Question NO" + num + "/40");
            qArea.setText(quesOption[num - 1][0]);
            qArea.setRows(10);
            if (maxQue < num) {
                maxQue = num;
                for (int i = 0; i < 5; i++) {
                    if (!quesOption[num - 1][i + 1].equals("")) {
                        answer[i].setVisible(true);
                        answer[i].setSelected(false);
                        answer[i].setText(quesOption[num - 1][i + 1]);
                    } else {
                        answer[i].setVisible(false);
                    }
                }
                mark.setSelected(false);
            } else {
                for (int i = 0; i < 5; i++) {
                    if (!quesOption[num - 1][i + 1].equals("")) {
                        answer[i].setVisible(true);
                        answer[i].setSelected(ansOption[num - 1][i]);
                        answer[i].setText(quesOption[num - 1][i + 1]);
                    } else {
                        answer[i].setVisible(false);
                    }
                }
                mark.setSelected(false);
            }
        }
    }

    class ActionList implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == next) {
                if (quesNo < 40) {
                    quesNo += 1;
                    next.setEnabled(true);
                    previous.setEnabled(true);
                    if (quesNo >= 40) {
                        next.setEnabled(false);
                    }
                }
                makeQues(quesNo);
            }
            if (e.getSource() == previous) {
                if (quesNo > 0) {
                    quesNo -= 1;
                    next.setEnabled(true);
                    previous.setEnabled(true);
                    if (quesNo <= 1) {
                        previous.setEnabled(false);
                    }
                }
                makeQues(quesNo);
            }
            if (e.getSource() == grade) {
                new ExamResult(JavaExam.fm);

            }
            if (e.getSource() == review) {

            }
        }

    }

    class ItemList implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox jc = (JCheckBox) e.getItem();
            for (int i = 0; i < 5; i++) {
                if (e.getStateChange() == 1) {
                    if (jc == answer[i]) {
                        ansOption[quesNo - 1][i] = true;
                    }
                } else {
                    if (jc == answer[i]) {
                        ansOption[quesNo - 1][i] = false;
                    }
                }
            }
            if (jc == mark) {
                if (e.getStateChange() == 1) {
                    ansOption[quesNo - 1][5] = true;
                } else {
                    ansOption[quesNo - 1][5] = false;
                }
            }
        }

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

    String[][] getQuestions() {
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
                    s1 = new StringBuffer(file.readLine());
                    if (new String(s1).equals("##-------Question----------##")) {
                        break;
                    } else if (new String(s1).equals("##ans1##")) {
                        quesOption[i][1] = file.readLine();
                    } else if (new String(s1).equals("##ans2##")) {
                        quesOption[i][2] = file.readLine();
                    } else if (new String(s1).equals("##ans3##")) {
                        quesOption[i][3] = file.readLine();
                    } else if (new String(s1).equals("##ans4##")) {
                        quesOption[i][4] = file.readLine();
                    } else if (new String(s1).equals("##ans5##")) {
                        quesOption[i][5] = file.readLine();
                    } else if (new String(s1).equals("##correct##")) {
                        quesOption[i][6] = file.readLine();
                    } else {
                        sb1.append(s1);
                        sb1.append("\n");
                        quesOption[i][0] = new String(sb1);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quesOption;
    }
}
