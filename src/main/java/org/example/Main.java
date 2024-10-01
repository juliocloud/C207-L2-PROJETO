package org.example;

import inatel.DAO.CarroDAO;
import inatel.DAO.ConnectionDAO;
import inatel.Model.Carro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CarroDAO carroDAO = new CarroDAO();
        try {
            carroDAO.insertCarro(
                    new Carro("8h4kg3l3f9H0H789g78", "uninho", 33000, "Mille Way", 2001, "Fiat")
            );

        }catch (Exception exc){
            System.out.println(exc.getMessage());
        }
    }
}