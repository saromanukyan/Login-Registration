package view;

import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterPage extends JFrame {
    Presenter presenter = new Presenter(this);
    Container container = getContentPane();

    ImageIcon mainIcon = new ImageIcon("images\\up103.png");
    JLabel imageLabel = new JLabel("", mainIcon, SwingConstants.CENTER);

    ImageIcon icon = new ImageIcon("images\\help20.png");
    JLabel fullNameHelper = new JLabel("fullName", icon, SwingConstants.LEFT);
    JLabel usernameHelper = new JLabel("username", icon, SwingConstants.LEFT);
    JLabel emailHelper = new JLabel("email", icon, SwingConstants.LEFT);
    JLabel passwordHelper = new JLabel("password", icon, SwingConstants.LEFT);

    JLabel nameLabel = new JLabel("Name");
    JLabel surNameLabel = new JLabel("Surname");
    JLabel userNameLabel = new JLabel("Username");
    JLabel emailLabel = new JLabel("Email");
    JLabel passwordLabel = new JLabel("Password");

    JTextField nameField = new JTextField();
    JTextField surNameField = new JTextField();
    JTextField userNameField = new JTextField();
    JTextField emailField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JCheckBox showPassword = new JCheckBox("Show Password");

    JButton resetBtn = new JButton("Reset");
    JButton submitBtn = new JButton("Submit");

    JLabel signInLabel = new JLabel("Already have an account?");
    JButton signInBtn = new JButton("Sign in");

    public RegisterPage() {
        setVisible(true);
        setBounds(0, 0, 380, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        container.setLayout(null);
        setLocationAndSize();
        setStyle();
        addComponentsToContainer();
        addHelpersActionEvent();
        addActionEvent();

    }

    private void addActionEvent() {
        showPassword.addActionListener(e -> {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });
        resetBtn.addActionListener(e -> {
            nameField.setText("");
            surNameField.setText("");
            userNameField.setText("");
            emailField.setText("");
            passwordField.setText("");
        });
        signInBtn.addActionListener(e -> presenter.onSignInBtnClick());

        submitBtn.addActionListener(e -> {
            String[] fields = {nameField.getText(),
                    surNameField.getText(),
                    userNameField.getText(),
                    emailField.getText(),
                    String.valueOf(passwordField.getPassword())};
            presenter.onSubmitBtnClick(fields);
        });

        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    surNameField.grabFocus();
                }
            }
        });
        surNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    userNameField.grabFocus();
                }
            }
        });
        userNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    emailField.grabFocus();
                }
            }
        });
        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    passwordField.grabFocus();
                }
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitBtn.doClick();
                }
            }
        });
    }

    private void addHelpersActionEvent() {
        fullNameHelper.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                presenter.onHelperClicked(fullNameHelper);

            }
        });
        usernameHelper.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                presenter.onHelperClicked(usernameHelper);

            }
        });
        emailHelper.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                presenter.onHelperClicked(emailHelper);

            }
        });
        passwordHelper.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                presenter.onHelperClicked(passwordHelper);

            }
        });
    }

    private void setLocationAndSize() {

        imageLabel.setBounds(138, 20, 103, 103);

        nameLabel.setBounds(30, 150, 50, 30);
        surNameLabel.setBounds(160, 150, 60, 30);
        userNameLabel.setBounds(30, 200, 100, 30);
        emailLabel.setBounds(30, 250, 100, 30);
        passwordLabel.setBounds(30, 300, 100, 30);

        nameField.setBounds(70, 150, 70, 30);
        surNameField.setBounds(220, 150, 100, 30);
        fullNameHelper.setBounds(330, 153, 20, 20);

        userNameField.setBounds(120, 200, 200, 30);
        usernameHelper.setBounds(330, 203, 20, 20);

        emailField.setBounds(120, 250, 200, 30);
        emailHelper.setBounds(330, 253, 20, 20);

        passwordField.setBounds(120, 300, 200, 30);
        passwordHelper.setBounds(330, 303, 20, 20);

        showPassword.setBounds(120, 330, 200, 30);

        resetBtn.setBounds(50, 390, 100, 30);
        submitBtn.setBounds(200, 390, 100, 30);

        signInLabel.setBounds(50, 460, 250, 20);
        signInBtn.setBounds(50, 490, 250, 30);
    }

    private void addComponentsToContainer() {
        container.add(imageLabel);

        container.add(fullNameHelper);
        container.add(usernameHelper);
        container.add(emailHelper);
        container.add(passwordHelper);

        container.add(nameLabel);
        container.add(surNameLabel);
        container.add(userNameLabel);
        container.add(emailLabel);
        container.add(passwordLabel);

        container.add(nameField);
        container.add(surNameField);
        container.add(userNameField);
        container.add(emailField);
        container.add(passwordField);
        container.add(showPassword);

        container.add(resetBtn);
        container.add(submitBtn);

        container.add(signInLabel);
        container.add(signInBtn);
    }

    private void setStyle() {
        passwordField.setEchoChar('*');
        signInLabel.setFont(signInLabel.getFont().deriveFont(Font.ITALIC));
        signInBtn.setContentAreaFilled(false);
    }


}
