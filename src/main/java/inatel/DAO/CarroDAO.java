package inatel.DAO;

import inatel.Model.Carro;

import java.sql.SQLException;

public class CarroDAO extends ConnectionDAO{

    public boolean insertCarro(Carro carro){
        connectToDb();

        boolean success;
        String sql = "INSERT INTO carro (nome, valor, modelo, ano, marca) VALUES (?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, carro.getNome());
            pst.setFloat(2, carro.getValor());
            pst.setString(3, carro.getModelo());
            pst.setInt(4, carro.getAno());
            pst.setString(5, carro.getMarca());
            pst.execute();
            success = true;
        } catch (SQLException err){
            System.out.println("Erro: >>" + err.getMessage());
            success = false;
        } finally {
            try {
                con.close();
                pst.close();
            }catch (SQLException err){
                System.out.println("Erro: >>" + err.getMessage());
            }
        }
        return success;
    }
}
