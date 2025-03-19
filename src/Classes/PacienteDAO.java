package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PacienteDAO {
    
    private Connection con;

    public PacienteDAO() {
        this.con = Conecta.getConexao();
    }

    public String gravarPaciente(Paciente paciente) {
        String resp = "";
        String sql = "INSERT INTO paciente(nome, endereco, logradouro, numero, complemento, cep, bairro, email, celular, telefone, estado, cidade, cpf, rg, nascimento) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conecta.getConexao();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, paciente.getNome());
            pstmt.setString(2, paciente.getRua());
            pstmt.setString(3, paciente.getRua());
            pstmt.setString(4, paciente.getNumero());
            pstmt.setString(5, paciente.getComplemento());
            pstmt.setString(6, paciente.getCep());
            pstmt.setString(7, paciente.getBairro());
            pstmt.setString(8, paciente.getEmail());
            pstmt.setString(9, paciente.getCelular());
            pstmt.setString(10, paciente.getTelefone());
            pstmt.setString(11, paciente.getEstado());
            pstmt.setString(12, paciente.getCidade());
            pstmt.setString(13, paciente.getCpf());
            pstmt.setString(14, paciente.getRg());
            pstmt.setString(15, paciente.getNascimento());
            
            pstmt.executeUpdate();
            resp = "OK";
        } catch (SQLException e) {
            resp = e.toString();
        }
        return resp;
    }

    public String editarPaciente(Paciente paciente) {
        String resp = "";
        String sql = "UPDATE paciente SET nome=?, endereco=?, logradouro=?, numero=?, complemento=?, cep=?, bairro=?, email=?, celular=?, telefone=?, estado=?, cidade=?, cpf=?, rg=?, nascimento=? WHERE id=?";
        try (Connection con = Conecta.getConexao();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, paciente.getNome());
            pstmt.setString(2, paciente.getRua());
            pstmt.setString(3, paciente.getRua());
            pstmt.setString(4, paciente.getNumero());
            pstmt.setString(5, paciente.getComplemento());
            pstmt.setString(6, paciente.getCep());
            pstmt.setString(7, paciente.getBairro());
            pstmt.setString(8, paciente.getEmail());
            pstmt.setString(9, paciente.getCelular());
            pstmt.setString(10, paciente.getTelefone());
            pstmt.setString(11, paciente.getEstado());
            pstmt.setString(12, paciente.getCidade());
            pstmt.setString(13, paciente.getCpf());
            pstmt.setString(14, paciente.getRg());
            pstmt.setString(15, paciente.getNascimento());
            pstmt.setInt(16, paciente.getId());
            
            pstmt.executeUpdate();
            resp = "OK";
        } catch (SQLException e) {
            resp = e.toString();
        }
        return resp;
    }

    public String excluirPaciente(Paciente p) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "DELETE from paciente WHERE id =" +p.getId();
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public Paciente pesquisarPaciente(int id){
        Paciente p=new Paciente();
        try{
            Connection con=Conecta.getConexao();
            Statement stmt=con.createStatement();
            String sql="SELECT * FROM paciente WHERE id="+id;
            stmt.execute(sql);
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setRua(rs.getString("endereco"));
                p.setNumero(rs.getString("numero"));
                p.setComplemento(rs.getString("complemento"));
                p.setCep(rs.getString("cep"));
                p.setBairro(rs.getString("bairro"));
                p.setEmail(rs.getString("email"));
                p.setCelular(rs.getString("celular"));
                p.setTelefone(rs.getString("telefone"));
                p.setEstado(rs.getString("estado"));
                p.setCidade(rs.getString("cidade"));
                p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                p.setNascimento(rs.getString("nascimento"));
         
            }
           
        }catch(Exception e){
        }
        return p;
    }
    
    public String verificaCpfExistente(Paciente paciente){
        String resp="";
        try{
            Connection con=Conecta.getConexao();
            Statement stmt=con.createStatement();
            String sql="SELECT cpf FROM paciente WHERE cpf='"+paciente.getCpf()+"'";
            stmt.executeQuery(sql);
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                resp=rs.getString("cpf");
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            resp=e.toString();
        }
        return resp;
    }
    
    
     public List<Paciente> buscaPacientePorNome(String nome) {
          //esse método é usado para buscar quando digitado uma letra no campo de texto de pesquisa
        try {

           
            List<Paciente> lista = new ArrayList<>();

            //pega tudo de clientes
            String sql = "select * from paciente where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Paciente obj = new Paciente();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setRua(rs.getString("endereco"));
                obj.setNascimento(rs.getString("nascimento"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                obj.setNumero(rs.getString("numero"));

                lista.add(obj);  //adiciona o objeto criado na lista
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }   
     public List<Paciente> buscaPacientePorCpf(String cpf) {
          //esse método é usado para buscar quando digitado uma letra no campo de texto de pesquisa
        try {

           
            List<Paciente> lista = new ArrayList<>();

            //pega tudo de clientes
            String sql = "select * from paciente where cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,cpf);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Paciente obj = new Paciente();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setRua(rs.getString("endereco"));
                obj.setNascimento(rs.getString("nascimento"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                obj.setNumero(rs.getString("numero"));

                lista.add(obj);  //adiciona o objeto criado na lista
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }   
     
     
      public Paciente pesquisarPacientePorNome(String nome){
        Paciente p=new Paciente();
        try{
            Connection con=Conecta.getConexao();
            Statement stmt=con.createStatement();
            String sql="SELECT * FROM paciente WHERE nome="+nome;
            stmt.execute(sql);
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setRua(rs.getString("endereco"));
                p.setNumero(rs.getString("numero"));
                p.setComplemento(rs.getString("complemento"));
                p.setCep(rs.getString("cep"));
                p.setBairro(rs.getString("bairro"));
                p.setEmail(rs.getString("email"));
                p.setCelular(rs.getString("celular"));
                p.setTelefone(rs.getString("telefone"));
                p.setEstado(rs.getString("estado"));
                p.setCidade(rs.getString("cidade"));
                p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                p.setNascimento(rs.getString("nascimento"));
         
            }
           
        }catch(Exception e){
        }
        return p;
    }
}