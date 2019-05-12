package javaexam;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JavaExam {

    static QuesFrame fm;

    public static void main(String[] args) {
        fm = new QuesFrame();
        fm.setSize(600, 500);
        Rectangle winDim = fm.getBounds();
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        fm.setLocation((int) (screenDim.getWidth() - winDim.width) / 2,
                (int) (screenDim.getHeight() - winDim.height) / 2);
        fm.setIconImage(new ImageIcon("ques.png").getImage());
        fm.setVisible(true);
        fm.setResizable(false);
        fm.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                final JDialog jd = new JDialog();
                jd.setModal(true);
                jd.setTitle("Java Mock Exam Syatem");
                JLabel msg = new JLabel("Do you want to quit?", JLabel.CENTER);
                final JButton b1 = new JButton("Ok");
                final JButton b2 = new JButton("Cencle");
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jd.hide();
                          
                    }
                });
                JPanel p = new JPanel();
                p.add(b1);
                p.add(b2);
                Container con = jd.getContentPane();
                con.add(msg, BorderLayout.NORTH);
                con.add(p, BorderLayout.SOUTH);
                jd.setSize(200, 100);
                Rectangle winDim = jd.getBounds();
                Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
                jd.setLocation((int) (screenDim.getWidth() - winDim.width) / 2,
                        (int) (screenDim.getHeight() - winDim.height) / 2);
                jd.show();
            }

        });
    }

}
