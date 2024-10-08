package inatel.DAO;

import inatel.Model.Carro;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public boolean updateCarro(int id, Carro carro){
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE carro SET nome = ?, valor = ?, modelo =? , ano=?, marca=? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, carro.getNome());
            pst.setFloat(2, carro.getValor());
            pst.setString(3, carro.getModelo());
            pst.setInt(4, carro.getAno());
            pst.setString(5, carro.getMarca());
            pst.setInt(6, id);
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deleteCarro(int id){
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM carro WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Carro> selectCarro() {
        connectToDb();

        ArrayList<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM carro";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de carros:");
            while (rs.next()) {
                Carro carroAux = new Carro(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("valor"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getString("marca"));
                System.out.println("Nome: " + carroAux.getNome() + "Valor: " + carroAux.getValor() + "Modelo: " + carroAux.getModelo() + "Ano: " + carroAux.getAno() + "Marca: " + carroAux.getMarca() );
                System.out.println("--------------------");
                carros.add(carroAux);
            }

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return carros;
    }

}
