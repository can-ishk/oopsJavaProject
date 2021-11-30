package com.kanishk.csd213;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Booking {

    private JFrame frame;
    private JTextField textField;
    private Database db = new Database();

    void setFrameVisible(){
        this.frame.setVisible(true);
    }

    public Booking() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.activeCaption);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(Color.WHITE, 5));
        panel_1.setBounds(251, 28, 610, 484);
        panel_1.setBackground(new Color(0, 0, 128));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("SNU ID: ");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(124, 102, 152, 14);
        panel_1.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));

        JLabel lblSLOTID = new JLabel("Slot ID: ");
        lblSLOTID.setForeground(new Color(255, 255, 255));
        lblSLOTID.setBounds(346, 102, 152, 14);
        panel_1.add(lblSLOTID);
        lblSLOTID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));

        JTextField textField2 = new JTextField();
        textField2.setBackground(Color.WHITE);
        textField2.setBounds(346, 127, 110, 39);
        panel_1.add(textField2);
        textField2.setText("For DELETION");
        textField2.setColumns(10);

        textField = new JTextField();
        textField.setBackground(Color.WHITE);
        textField.setBounds(124, 127, 110, 39);
        panel_1.add(textField);
        textField.setText("REQUIRED");
        textField.setColumns(10);

        JLabel lblSport = new JLabel("SPORT");
        lblSport.setForeground(new Color(255, 255, 255));
        lblSport.setBounds(128, 197, 70, 14);
        panel_1.add(lblSport);
        lblSport.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));

        @SuppressWarnings("rawtypes")
        String[] Sports = {"Badminton", "Table Tennis", "Squash", "Gym", "Chess"};
        JComboBox comboBox = new JComboBox(Sports);
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(124, 222, 330, 39);
        panel_1.add(comboBox);

        JLabel lblSlotDay = new JLabel("SLOT DAY");
        lblSlotDay.setForeground(new Color(255, 255, 255));
        lblSlotDay.setBounds(128, 304, 118, 14);
        panel_1.add(lblSlotDay);
        lblSlotDay.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));

        @SuppressWarnings("rawtypes")
        String[] Days = {"MWF", "TTS", "TSM"};
        JComboBox comboBox_1 = new JComboBox(Days);
        comboBox_1.setBackground(Color.WHITE);
        comboBox_1.setBounds(124, 329, 152, 39);
        panel_1.add(comboBox_1);

        JLabel lblSlotTime = new JLabel("SLOT TIME");
        lblSlotTime.setForeground(new Color(255, 255, 255));
        lblSlotTime.setBounds(306, 304, 118, 14);
        panel_1.add(lblSlotTime);
        lblSlotTime.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));

        @SuppressWarnings("rawtypes")
        String[] Times = {"6-7AM", "7-8AM", "8-9AM", "5-6PM", "6-7PM", "7-8PM"};
        JComboBox comboBox_1_1 = new JComboBox(Times);
        comboBox_1_1.setBackground(Color.WHITE);
        comboBox_1_1.setBounds(306, 329, 152, 39);
        panel_1.add(comboBox_1_1);

        JButton btnNewButton = new JButton("SUBMIT");
        btnNewButton.setBackground(SystemColor.activeCaption);
        btnNewButton.setBounds(369, 401, 130, 39);
        panel_1.add(btnNewButton);
        btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));

        JButton dltButton = new JButton("DELETE");
        dltButton.setBackground(SystemColor.activeCaption);
        dltButton.setBounds(69, 401, 130, 39);
        panel_1.add(dltButton);
        dltButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));

        JLabel lblSportsManagementSystem = new JLabel("SPORTS MANAGEMENT SYSTEM");
        lblSportsManagementSystem.setForeground(new Color(255, 255, 255));
        lblSportsManagementSystem.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 34));
        lblSportsManagementSystem.setBounds(42, 25, 536, 39);
        panel_1.add(lblSportsManagementSystem);

        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
        lblNewLabel_2.setIcon(new ImageIcon(Booking.class.getResource("/image/bg.jpg")));
        lblNewLabel_2.setBounds(10, 11, 590, 462);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(-136, 0, 1301, 584);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setIcon(new ImageIcon(Booking.class.getResource("/image/ISC.jpg")));

        //@Author KanishkChathley
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
            public void changed(){
                if(textField.getText().length()!=5) btnNewButton.setEnabled(false);
                else btnNewButton.setEnabled(true);
            }
        });
        textField2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
            public void changed(){
                if(textField2.getText().length()!=3) dltButton.setEnabled(false);
                else dltButton.setEnabled(true);
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Submit
                if (textField.getText().length()==5) {
                    Slot slot = new Slot(comboBox.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString(), comboBox_1_1.getSelectedItem().toString());
                    int id = 0;
                    Boolean flag = false;
                    try {
                        flag = db.Insert(slot, textField.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    JFrame jFrame = new JFrame();
                    if(flag) JOptionPane.showMessageDialog(jFrame, "Slot Booked! ID = " + slot.getID());
                    else JOptionPane.showMessageDialog(jFrame,"Sorry, Slots have been booked.");

                }else{
                    JFrame jFrame = new JFrame();
                    JOptionPane.showMessageDialog(jFrame, "Enter Valid ID");
                }
            }
        });

        dltButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textField2.getText().length()==3 && textField.getText().length()==5){
                    int id =  Integer.parseInt(textField2.getText());
                    try {
                        db.Delete(id, textField.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    JFrame jFrame = new JFrame();
                    JOptionPane.showMessageDialog(jFrame, "Deleted");
                }else{
                    JFrame jFrame = new JFrame();
                    if(textField2.getText().length()!=3) JOptionPane.showMessageDialog(jFrame, "Enter Valid Slot ID");
                    if(textField.getText().length()!=5) JOptionPane.showMessageDialog(jFrame, "Enter Valid SNU ID");

                }


            }
        });
        frame.setBackground(Color.BLACK);
        frame.setBounds(100, 100, 1157, 584);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
    }
}
