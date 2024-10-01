package org.example;

import inatel.ConnDao;

import java.sql.DriverManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConnDao cd = new ConnDao();
        cd.connectToDb();

    }
}