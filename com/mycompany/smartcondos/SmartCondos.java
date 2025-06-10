package com.mycompany.smartcondos;

import Views.LoginGUI;

public class SmartCondos {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new LoginGUI().setVisible(true);
        });
    }
}
