package student.registration.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame implements ActionListener {

    // Components
    JTextField tfName, tfEmail, tfPhone, tfRoll;
    JRadioButton male, female, other;
    JComboBox<String> cbCourse, cbYear;
    JTextArea taAddress;
    JButton btnSubmit, btnClear;

    public StudentRegistration() {
        setTitle("Student Registration Form");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Background Panel with Peach Color
        JPanel bgPanel = new JPanel();
        bgPanel.setBackground(new Color(255, 218, 185)); // Light peach
        bgPanel.setLayout(null);
        add(bgPanel);

        // Title Label
        JLabel lblTitle = new JLabel("Student Registration Form");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitle.setForeground(new Color(80, 50, 20));
        lblTitle.setBounds(0, 30, getWidth(), 50);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        bgPanel.add(lblTitle);

        // Inner Form Panel (centered card style)
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(255, 228, 196)); // Lighter peach tone
        formPanel.setBounds(450, 100, 500, 550);
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(205, 133, 63), 2));
        bgPanel.add(formPanel);

        // Labels & Fields
        int labelX = 60, fieldX = 180, startY = 40, gapY = 50;

        JLabel lblName = new JLabel("Full Name:");
        lblName.setBounds(labelX, startY, 100, 25);
        formPanel.add(lblName);
        tfName = new JTextField();
        tfName.setBounds(fieldX, startY, 230, 25);
        formPanel.add(tfName);

        JLabel lblRoll = new JLabel("Roll No:");
        lblRoll.setBounds(labelX, startY + gapY, 100, 25);
        formPanel.add(lblRoll);
        tfRoll = new JTextField();
        tfRoll.setBounds(fieldX, startY + gapY, 230, 25);
        formPanel.add(tfRoll);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(labelX, startY + 2 * gapY, 100, 25);
        formPanel.add(lblGender);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        male.setBackground(formPanel.getBackground());
        female.setBackground(formPanel.getBackground());
        other.setBackground(formPanel.getBackground());
        male.setBounds(fieldX, startY + 2 * gapY, 70, 25);
        female.setBounds(fieldX + 80, startY + 2 * gapY, 80, 25);
        other.setBounds(fieldX + 170, startY + 2 * gapY, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        formPanel.add(male);
        formPanel.add(female);
        formPanel.add(other);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(labelX, startY + 3 * gapY, 100, 25);
        formPanel.add(lblEmail);
        tfEmail = new JTextField();
        tfEmail.setBounds(fieldX, startY + 3 * gapY, 230, 25);
        formPanel.add(tfEmail);

        JLabel lblPhone = new JLabel("Phone No:");
        lblPhone.setBounds(labelX, startY + 4 * gapY, 100, 25);
        formPanel.add(lblPhone);
        tfPhone = new JTextField();
        tfPhone.setBounds(fieldX, startY + 4 * gapY, 230, 25);
        formPanel.add(tfPhone);

        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(labelX, startY + 5 * gapY, 100, 25);
        formPanel.add(lblCourse);
        String[] courses = {"B.Tech", "B.Sc", "BCA", "MCA", "MBA"};
        cbCourse = new JComboBox<>(courses);
        cbCourse.setBounds(fieldX, startY + 5 * gapY, 230, 25);
        formPanel.add(cbCourse);

        JLabel lblYear = new JLabel("Year:");
        lblYear.setBounds(labelX, startY + 6 * gapY, 100, 25);
        formPanel.add(lblYear);
        String[] years = {"1st Year", "2nd Year", "3rd Year", "4th Year"};
        cbYear = new JComboBox<>(years);
        cbYear.setBounds(fieldX, startY + 6 * gapY, 230, 25);
        formPanel.add(cbYear);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(labelX, startY + 7 * gapY, 100, 25);
        formPanel.add(lblAddress);
        taAddress = new JTextArea();
        taAddress.setBounds(fieldX, startY + 7 * gapY, 230, 60);
        taAddress.setLineWrap(true);
        taAddress.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        formPanel.add(taAddress);

        // Buttons
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(100, 480, 120, 35);
        btnSubmit.setBackground(new Color(255, 160, 122)); // Soft salmon-peach
        btnSubmit.setForeground(Color.BLACK);
        btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formPanel.add(btnSubmit);

        btnClear = new JButton("Clear");
        btnClear.setBounds(260, 480, 120, 35);
        btnClear.setBackground(new Color(205, 92, 92)); // Light brown-red
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formPanel.add(btnClear);

        // Action Listeners
        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);

        // Add resize listener to center formPanel dynamically
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                int x = (getWidth() - formPanel.getWidth()) / 2;
                int y = (getHeight() - formPanel.getHeight()) / 2;
                formPanel.setLocation(x, y);
                bgPanel.setSize(getSize());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String name = tfName.getText();
            String roll = tfRoll.getText();
            String email = tfEmail.getText();
            String phone = tfPhone.getText();
            String gender = male.isSelected() ? "Male" :
                    female.isSelected() ? "Female" :
                    other.isSelected() ? "Other" : "";
            String course = (String) cbCourse.getSelectedItem();
            String year = (String) cbYear.getSelectedItem();
            String address = taAddress.getText();

            if (name.isEmpty() || roll.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Registration Successful!\n\nName: " + name +
                        "\nRoll No: " + roll +
                        "\nGender: " + gender +
                        "\nEmail: " + email +
                        "\nPhone: " + phone +
                        "\nCourse: " + course +
                        "\nYear: " + year +
                        "\nAddress: " + address,
                        "Student Registered",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == btnClear) {
            tfName.setText("");
            tfRoll.setText("");
            tfEmail.setText("");
            tfPhone.setText("");
            taAddress.setText("");
            male.setSelected(false);
            female.setSelected(false);
            other.setSelected(false);
            cbCourse.setSelectedIndex(0);
            cbYear.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistration().setVisible(true));
    }
}
