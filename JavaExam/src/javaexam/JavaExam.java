
package javaexam;

import java.awt.Dimension;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class JavaExam {

    static QuesFrame fm;
    public static void main(String[] args) {
        fm=new QuesFrame();
        fm.setSize(600, 500);
        Rectangle winDim=fm.getBounds();
        Dimension screenDim= Toolkit.getDefaultToolkit().getScreenSize();
        fm.setLocation((int)(screenDim.getWidth()-winDim.width)/2, 
                (int)(screenDim.getHeight()-winDim.height)/2);
        fm.setIconImage(new ImageIcon("ques.png").getImage());
        fm.setVisible(true);
        fm.setResizable(false);
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
