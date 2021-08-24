/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CredenciaisSGBD;

/**
 *
 * @author caioo
 */
public class Credenciais {
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "";

    public static String getURL() {
        return URL;
    }

    public static String getUSUARIO() {
        return USUARIO;
    }

    public static String getSENHA() {
        return SENHA;
    }
}
