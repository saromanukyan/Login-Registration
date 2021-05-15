package view;

import presenter.Presenter;

import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame {
    Presenter presenter = new Presenter(this);
    Container container = getContentPane();

    ImageIcon mainIcon = new ImageIcon("images\\up103.png");
    JLabel imageLabel = new JLabel("", mainIcon, SwingConstants.CENTER);
    JLabel welcomeLabel = new JLabel("WELCOME");
    JLabel nameLabel = new JLabel("");

    ImageIcon confetti = new ImageIcon("images\\confetti.gif");
    JLabel confettiLabel = new JLabel("", confetti, SwingConstants.CENTER);
    JButton backToMainPageBtn = new JButton("Back to main page");


    public WelcomePage(String name) {
        nameLabel.setText(name);
        setVisible(true);
        setBounds(0, 0, 380, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        container.setLayout(null);
        setLocationAndSize();
        addComponentsToContainer();
        setStyle();
        addActionEvent();

    }

    private void setLocationAndSize() {
        imageLabel.setBounds(138, 20, 103, 103);
        welcomeLabel.setBounds(0, 150, 380, 600);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setVerticalAlignment(JLabel.TOP);
        nameLabel.setBounds(0, 200, 380, 600);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setVerticalAlignment(JLabel.TOP);
        backToMainPageBtn.setBounds(50, 490, 250, 30);
        confettiLabel.setBounds(0, 0, 380, 600);
    }

    private void addComponentsToContainer() {
        container.add(imageLabel);
        container.add(welcomeLabel);
        container.add(nameLabel);
        container.add(backToMainPageBtn);
        container.add(confettiLabel);
    }

    private void setStyle() {
        welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(Font.ITALIC, 34f));
        backToMainPageBtn.setContentAreaFilled(false);
        nameLabel.setFont(welcomeLabel.getFont().deriveFont(Font.ITALIC, 24f));
    }

    private void addActionEvent() {
        backToMainPageBtn.addActionListener(e -> presenter.onBackToMainPageBtnClick());
    }

}
