package com.kanishk.csd213;
//@Author KanishkChathley
// Group 16 OOPS Project
// ISC Management System
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Booking window = new Booking();
                    window.setFrameVisible();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
