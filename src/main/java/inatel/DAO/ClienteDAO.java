package inatel.DAO;

import inatel.Model.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends ConnectionDAO{

    public boolean insertCliente(Cliente cliente){
        connectToDb();

        boolean success;
        String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getTelefone());
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

    public boolean updateCliente(int id, Cliente cliente){
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE cliente SET nome = ?, email =?, telefone=? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getTelefone());
            pst.setInt(4, id);
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

    public boolean deleteCliente(int id){
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM cliente WHERE id = ?";
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

    public ArrayList<Cliente> selectCliente() {
        connectToDb();

        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de clientes:");
            while (rs.next()) {
                Cliente clienteAux = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"));
                System.out.println("Nome: " + clienteAux.getNome() + "Email: " + clienteAux.getEmail() +   "Telefone: " + clienteAux.getTelefone() );
                System.out.println("--------------------");
                clientes.add(clienteAux);
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
        return clientes;
    }

}
