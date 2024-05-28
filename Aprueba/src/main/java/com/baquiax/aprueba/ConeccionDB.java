/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baquiax.aprueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis
 */
public class ConeccionDB {

    private static final String USER = "umquteg6tpwmf0xz";
    private static final String PASSWORD = "b0iHnUB94XOgUhLbIVEI";
    //private static final String URL = "jdbc:mysql://ba2c8pcyvcyx4dl58svo-mysql.services.clever-cloud.com:3306/ba2c8pcyvcyx4dl58svo";
    private static final String URL = "jdbc:mysql://umquteg6tpwmf0xz:b0iHnUB94XOgUhLbIVEI@ba2c8pcyvcyx4dl58svo-mysql.services.clever-cloud.com:3306/ba2c8pcyvcyx4dl58svo";
    private static ConeccionDB conexionSingleton = null;

    private static Connection CONECCION = null;

    /**
     * Realizamos la conección a mysql
     *
     * @throws SQLException
     */
    private ConeccionDB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            CONECCION = DriverManager.getConnection(URL);
            System.out.println("conexion exitosa");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retornamos la coneción
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConeccion() throws SQLException {
        if (conexionSingleton == null) {
            conexionSingleton = new ConeccionDB();
        }
        return CONECCION;
    }
}