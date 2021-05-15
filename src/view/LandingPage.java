package view;

import presenter.Presenter;

import javax.swing.*;
import java.awt.*;

public class LandingPage extends JFrame {
    Presenter presenter = new Presenter(this);
    Container container = getContentPane();

    ImageIcon mainIcon = new ImageIcon("images\\up103.png");
    JLabel imageLabel = new JLabel("", mainIcon, SwingConstants.CENTER);

    JLabel landingLabel = new JLabel("Please select an option");
    JButton signInBtn = new JButton("LOGIN");
    JButton registerBtn = new JButton("REGISTER");

    public LandingPage() {
        setVisible(true);
        setBounds(0, 0, 380, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        container.setLayout(null);
        setLocationAndSize();
        setStyle();
        addComponentsToContainer();
        addActionEvent();
    }

    private void setLocationAndSize() {
        imageLabel.setBounds(138, 20, 103, 103);
        landingLabel.setBounds(0, 150, 380, 600);
        landingLabel.setHorizontalAlignment(JLabel.CENTER);
        landingLabel.setVerticalAlignment(JLabel.TOP);

        signInBtn.setBounds(45, 220, 280, 100);
        registerBtn.setBounds(45, 340, 280, 100);
    }

    private void setStyle() {
        landingLabel.setFont(landingLabel.getFont().deriveFont(Font.ITALIC, 24f));
        signInBtn.setFont(signInBtn.getFont().deriveFont(Font.ITALIC, 24f));
        registerBtn.setFont(registerBtn.getFont().deriveFont(Font.ITALIC, 24f));
    }

    private void addComponentsToContainer() {
        container.add(imageLabel);
        container.add(landingLabel);
        container.add(signInBtn);
        container.add(registerBtn);

    }

    private void addActionEvent() {
        signInBtn.addActionListener(e -> presenter.onSignInBtnClick());
        registerBtn.addActionListener(e -> presenter.onCreateAccountBtnClick());
    }
}
