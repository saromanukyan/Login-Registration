package presenter;

import model.Service;
import model.User;
import model.validationStrategy.*;
import view.*;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Presenter {
    private final JFrame frame;

    public Presenter(JFrame frame) {
        this.frame = frame;
    }

    public void onHelperClicked(JLabel helper) {

        Map<String, Validator> map = new LinkedHashMap<>(5);
        map.put("fullName", new NameValidator());
        map.put("username", new UserNameValidator());
        map.put("email", new EmailValidator());
        map.put("password", new PasswordValidator());

        Context context = new Context();
        context.setValidator(map.get(helper.getText()));
        int x = helper.getLocationOnScreen().x;
        int y = helper.getLocationOnScreen().y;
        x += 20;
        y -= 50;

        String terms = context.validationConditons();
        JOptionPane optionPane = new JOptionPane(terms, JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        PopupFactory popupFactory = PopupFactory.getSharedInstance();
        Popup tooltipContainer = popupFactory.getPopup(helper, optionPane, x, y);
        tooltipContainer.show();
        new Thread(() -> {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Presenter.class.getName()).log(Level.SEVERE, null, ex);
            }
            tooltipContainer.hide();
        }).start();
    }

    public void onLoginBtnClick(String[] fields) {
        if (Service.isValidUsernameAndPassword(fields[0], fields[1])) {
            JOptionPane.showMessageDialog(frame, "Login Successful");
            frame.dispose();
            new WelcomePage(fields[0]);
        } else JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
    }

    public void onCreateAccountBtnClick() {
        frame.dispose();
        new RegisterPage();
    }

    public void onSignInBtnClick() {
        frame.dispose();
        new LoginPage();
    }

    public void onBackToMainPageBtnClick() {
        frame.dispose();
        new LandingPage();
    }

    public void onSubmitBtnClick(String[] fields) {
        Context context = new Context();

        Map<Validator, String> validatorMap = new LinkedHashMap<>(5);
        validatorMap.put(new NameValidator(), "Name");
        validatorMap.put(new SurNameValidator(), "Surname");
        validatorMap.put(new UserNameValidator(), "Username");
        validatorMap.put(new EmailValidator(), "Email");
        validatorMap.put(new PasswordValidator(), "Password");

        int indexOfField = 0;
        boolean isValid = true;
        for (Map.Entry<Validator, String> entry : validatorMap.entrySet()) {

            if (indexOfField == 2) {
                if (Service.isUserAlreadyExist(fields[indexOfField])) {
                    JOptionPane.showMessageDialog(frame, "User '" +
                            fields[indexOfField] + "' already exist,\n         Please change Username");
                    isValid = false;
                    break;
                }
            }

            context.setValidator(entry.getKey());

            if (context.isNotValid(fields[indexOfField++])) {
                JOptionPane.showMessageDialog(frame, "Enter correct " + entry.getValue());
                isValid = false;
                break;
            }
        }

        if (isValid) {
            User user = Service.create(fields);
            Service.addUserToFile(user);
            JOptionPane.showMessageDialog(frame, "Thank you for registration");
            frame.dispose();
            new WelcomePage(user.getFullName());
        }

    }

}
