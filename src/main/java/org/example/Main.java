package org.example;

import inatel.DAO.CarroDAO;
import inatel.DAO.ClienteDAO;
import inatel.DAO.ConnectionDAO;
import inatel.Model.Carro;
import inatel.Model.Cliente;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CarroDAO carroDAO = new CarroDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        try {
            carroDAO.insertCarro(
                    new Carro(0, "uninho", 33000, "Mille Way", 2001, "Fiat")
            );
    clienteDAO.insertCliente(
            new Cliente(0, "Marcos", "marquin@gmail.com", "437258")
    );

        clienteDAO.selectCliente();
            carroDAO.selectCarro();

        }catch (Exception exc){
            System.out.println(exc.getMessage());
        }
    }
}