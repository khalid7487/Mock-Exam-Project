
package javaexam;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.*;


public class QuesFrame extends JFrame{

    JLabel queNO,timer;
    int maxQue=1, quesNo=1;
    TextArea qArea;
    JCheckBox answer[],mark;
    JPanel top,center,bottom;
    JButton next,previous,grade,review;
    public QuesFrame(){
        queNO=new JLabel();
        timer=new JLabel("", JLabel.RIGHT);
        qArea=new TextArea();
        answer=new JCheckBox[5];
        mark=new JCheckBox("Mark");
        top=new JPanel();
        center =new JPanel();
        bottom =new JPanel();
        center.setFont(new Font("Serieff",Font.PLAIN,12));
        top.setLayout(new BorderLayout());
        top.add(queNO,BorderLayout.WEST);
        top.add(mark,BorderLayout.EAST);
        for (int i = 0; i < 5; i++) {
            answer[i]=new JCheckBox();
            answer[i].addItemListener(null);
            center.add(answer[i]);
        }
        bottom.setLayout(new GridLayout(1, 5));
        next=new JButton("Next");
        previous=new JButton("Previous");
        grade=new JButton("Grade");
        review=new JButton("Review");
        previous.setEnabled(true);
        bottom.add(next);
        bottom.add(previous);
        bottom.add(grade);
        bottom.add(review);
        getContentPane().add(top,BorderLayout.NORTH);
        getContentPane().add(center,BorderLayout.CENTER);
        getContentPane().add(bottom,BorderLayout.SOUTH);
        next.addActionListener(null);
        previous.addActionListener(null);
        grade.addActionListener(null);
        review.addActionListener(null);
        
        setTitle("Java Mock Exam Syatem");
    }
    
}
