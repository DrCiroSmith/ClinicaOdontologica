package Formularios;

import Classes.Conecta;
import Classes.Dentista;
import Classes.DentistaDAO;
import Classes.Paciente;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class frmEditarDentista extends javax.swing.JFrame {
       Color azulPadrao = new Color(88, 138, 255);
        Color azulClaro = new Color(226, 235, 255);

    public String situacao = "";

    class campoNumerico extends PlainDocument{
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            super.insertString(offs, str.replaceAll("[^0-9]", ""), a);
        }
    }
    
    public boolean verificaPreenchimento() {
        if (txtEmail.getText().equals("") || txtEmail.getText().equals("") || txtNascimento.getText().equals("  /  /    ")
                 || txtValorConsulta.getText().equals("   .  ")) {
            return false;
        }
        return true;
    }
    public void limparCampos() {
        txtId.setText("");
        txtTelefone.setText("");
        txtNome1.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtNascimento.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        txtConfirmarSenha.setText("");
        txtCro.setText("");
        txtEstado.setText("");
        txtRua.setText("");
        txtNumeroConsultorio.setText("");
        txtValorConsulta.setText("");
        txtBairro.setText("");
        txtComplemento.setText("");
        txtNumero.setText("");
        txtTelefone.setText("");
        txtCelular.setText("");
        txtCep.setText("");
        txtEmail.setText("");
        txtCidade.setText("");
    }
    public void habilitaCampos() {
        txtTelefone.setEnabled(true);
        txtNome1.setEnabled(true);
        txtCpf.setEnabled(true);
        txtRg.setEnabled(true);
        txtNascimento.setEnabled(true);
        txtLogin.setEnabled(true);
        txtSenha.setEnabled(true);
        txtConfirmarSenha.setEnabled(true);
        txtCro.setEnabled(true);
        txtEstado.setEnabled(true);
        txtRua.setEnabled(true);
        txtNumeroConsultorio.setEnabled(true);
        txtValorConsulta.setEnabled(true);
        txtBairro.setEnabled(true);
        txtComplemento.setEnabled(true);
        txtNumero.setEnabled(true);
        txtTelefone.setEnabled(true);
        txtCelular.setEnabled(true);
        txtCep.setEnabled(true);
        txtEmail.setEnabled(true);
        txtCidade.setEnabled(true);
    }
    public void desabilitaCampos() {
        txtTelefone.setEnabled(false);
        txtNome1.setEnabled(false);
        txtCpf.setEnabled(false);
        txtRg.setEnabled(false);
        txtNascimento.setEnabled(false);
        txtLogin.setEnabled(false);
        txtSenha.setEnabled(false);
        txtConfirmarSenha.setEnabled(false);
        txtCro.setEnabled(false);
        txtEstado.setEnabled(false);
        txtRua.setEnabled(false);
        txtNumeroConsultorio.setEnabled(false);
        txtValorConsulta.setEnabled(false);
        txtBairro.setEnabled(false);
        txtComplemento.setEnabled(false);
        txtNumero.setEnabled(false);
        txtTelefone.setEnabled(false);
        txtCelular.setEnabled(false);
        txtCep.setEnabled(false);
        txtEmail.setEnabled(false);
        txtCidade.setEnabled(false);
    }

   

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblDentista.getModel();
        modelo.setNumRows(0);
        try {
            java.sql.Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("select * from dentista order by nome");
            rs = pstm.executeQuery();
            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cro"),
                    rs.getInt("consultorio"),
                    rs.getFloat("valorConsulta"),});
            }
            pstm.close();
            con.close();
            rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
     private void pegarResolucao() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension dimensao = t.getScreenSize();
        this.setSize((dimensao.width + 5), (dimensao.height - 38));

 }
    

    public frmEditarDentista() {
        initComponents();
        pegarResolucao();
        carregaTabela();
        getContentPane().setBackground(azulClaro);
        //mudar a cor do cabeçalho da tabela
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(azulPadrao);

        for (int i = 0; i < tblDentista.getModel().getColumnCount(); i++) {
            tblDentista.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
}
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDentista = new javax.swing.JTable();
        btnExcluirDentista = new javax.swing.JButton();
        btnEditarDentista = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnNovoDentista = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        btnSalvarDentista = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nconsu = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtNascimento = new javax.swing.JFormattedTextField();
        txtRg = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCro = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        endwe = new javax.swing.JLabel();
        txtValorConsulta = new javax.swing.JTextField();
        nconsu1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNumeroConsultorio = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        nconsu2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        nconsu3 = new javax.swing.JLabel();
        txtConfirmarSenha = new javax.swing.JTextField();
        nconsu4 = new javax.swing.JLabel();
        txtNome1 = new javax.swing.JTextField();
        txtPesquisaDentista1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Data de Nasc:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nome:");

        tblDentista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CRO", "Consultório", "Valor Consulta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDentista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDentistaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDentista);
        if (tblDentista.getColumnModel().getColumnCount() > 0) {
            tblDentista.getColumnModel().getColumn(0).setMinWidth(40);
            tblDentista.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblDentista.getColumnModel().getColumn(0).setMaxWidth(40);
            tblDentista.getColumnModel().getColumn(1).setMinWidth(250);
            tblDentista.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblDentista.getColumnModel().getColumn(1).setMaxWidth(250);
            tblDentista.getColumnModel().getColumn(3).setMinWidth(80);
            tblDentista.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblDentista.getColumnModel().getColumn(3).setMaxWidth(80);
            tblDentista.getColumnModel().getColumn(4).setMinWidth(95);
            tblDentista.getColumnModel().getColumn(4).setPreferredWidth(95);
            tblDentista.getColumnModel().getColumn(4).setMaxWidth(95);
        }

        btnExcluirDentista.setBackground(new java.awt.Color(88, 138, 255));
        btnExcluirDentista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExcluirDentista.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirDentista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconExcluir.png"))); // NOI18N
        btnExcluirDentista.setText("Excluir Dentista");
        btnExcluirDentista.setBorder(null);
        btnExcluirDentista.setEnabled(false);
        btnExcluirDentista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExcluirDentistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExcluirDentistaMouseExited(evt);
            }
        });
        btnExcluirDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDentistaActionPerformed(evt);
            }
        });

        btnEditarDentista.setBackground(new java.awt.Color(88, 138, 255));
        btnEditarDentista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEditarDentista.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarDentista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconEditar.png"))); // NOI18N
        btnEditarDentista.setText("Editar Dentista");
        btnEditarDentista.setBorder(null);
        btnEditarDentista.setEnabled(false);
        btnEditarDentista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarDentistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarDentistaMouseExited(evt);
            }
        });
        btnEditarDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDentistaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(88, 138, 255));
        jLabel4.setText("INFORMAÇÕES DO DENTISTA");

        btnNovoDentista.setBackground(new java.awt.Color(88, 138, 255));
        btnNovoDentista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovoDentista.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoDentista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/novo.png"))); // NOI18N
        btnNovoDentista.setText(" Novo Dentista");
        btnNovoDentista.setBorder(null);
        btnNovoDentista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovoDentistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovoDentistaMouseExited(evt);
            }
        });
        btnNovoDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoDentistaActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));

        btnSalvarDentista.setBackground(new java.awt.Color(88, 138, 255));
        btnSalvarDentista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvarDentista.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarDentista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconSalvar.png"))); // NOI18N
        btnSalvarDentista.setText("Salvar Dentista");
        btnSalvarDentista.setBorder(null);
        btnSalvarDentista.setEnabled(false);
        btnSalvarDentista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarDentistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarDentistaMouseExited(evt);
            }
        });
        btnSalvarDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDentistaActionPerformed(evt);
            }
        });

        btnLimparCampos.setBackground(new java.awt.Color(88, 138, 255));
        btnLimparCampos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLimparCampos.setForeground(new java.awt.Color(255, 255, 255));
        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconLimpar.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.setBorder(null);
        btnLimparCampos.setEnabled(false);
        btnLimparCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimparCamposMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimparCamposMouseExited(evt);
            }
        });
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        txtId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(88, 138, 255), 1, true));
        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("ID:");

        nconsu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nconsu.setText("Email");

        jButton3.setBackground(new java.awt.Color(102, 204, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/voltar.png"))); // NOI18N
        jButton3.setText("voltar");
        jButton3.setBorder(null);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        try {
            txtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtRg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("RG:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("CPF:");

        txtCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Telefone:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Celular:");

        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        txtTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("CRO:");

        txtCro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        txtCro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCroActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Rua:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(10, 10, 40, 20);

        txtRua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtRua);
        txtRua.setBounds(10, 30, 270, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Numero:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(10, 60, 80, 20);

        txtNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtNumero);
        txtNumero.setBounds(10, 80, 120, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Complemento:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(140, 60, 120, 20);

        txtComplemento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtComplemento);
        txtComplemento.setBounds(140, 80, 120, 20);

        txtCep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtCep);
        txtCep.setBounds(10, 130, 220, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("CEP:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(10, 110, 120, 20);

        txtBairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtBairro);
        txtBairro.setBounds(10, 170, 220, 20);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Bairro:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(10, 150, 120, 20);

        txtEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtEstado);
        txtEstado.setBounds(10, 210, 220, 20);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Estado:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(10, 190, 120, 20);

        txtCidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtCidade);
        txtCidade.setBounds(10, 250, 220, 20);

        endwe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        endwe.setText("Cidade:");
        jPanel1.add(endwe);
        endwe.setBounds(10, 230, 120, 20);

        txtValorConsulta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtValorConsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));

        nconsu1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nconsu1.setText("Valor da Consulta:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Nº Consultório");

        txtNumeroConsultorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        txtNumeroConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroConsultorioActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações de Login"));

        nconsu2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nconsu2.setText("Login");

        txtLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));

        txtSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));

        nconsu3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nconsu3.setText("Senha:");

        txtConfirmarSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtConfirmarSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));

        nconsu4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nconsu4.setText("Confirmar senha:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nconsu2)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nconsu3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nconsu4)
                    .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(nconsu2)
                .addGap(1, 1, 1)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nconsu3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nconsu4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 49, Short.MAX_VALUE))
        );

        txtNome1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNome1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));

        txtPesquisaDentista1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        txtPesquisaDentista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaDentista1ActionPerformed(evt);
            }
        });
        txtPesquisaDentista1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaDentista1KeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Pesquisa Dentista:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtNumeroConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtValorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(95, 95, 95)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(jLabel14))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtCro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nconsu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(nconsu1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovoDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditarDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvarDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluirDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(txtPesquisaDentista1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaDentista1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel13))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(nconsu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(nconsu1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumeroConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btnNovoDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnEditarDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnSalvarDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnExcluirDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        setSize(new java.awt.Dimension(1226, 754));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblDentistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDentistaMouseClicked
        int item = tblDentista.getSelectionModel().getMinSelectionIndex();  //pega a linha selecionada
        item = (int) tblDentista.getModel().getValueAt(item, 0);
        Dentista d = new DentistaDAO().pesquisarDentista(item);
        desabilitaCampos();
        
        txtId.setText(d.getId()+"");
        txtNome1.setText(d.getNome());
        txtNascimento.setText(d.getNascimento());
        txtNumeroConsultorio.setText(d.getConsultorio());
        txtRg.setText(d.getRg());
        txtCpf.setText(d.getCpf());
        txtTelefone.setText(d.getTelefone());
        txtCelular.setText(d.getCelular());
        txtEmail.setText(d.getEmail());
        txtComplemento.setText(d.getComplemento());
        txtBairro.setText(d.getBairro());
        txtCep.setText(d.getCep());
        txtCidade.setText(d.getCidade());
        txtLogin.setText(d.getLogin());
        txtSenha.setText(d.getSenha());
        txtConfirmarSenha.setText(d.getSenha());
        txtValorConsulta.setText(d.getValorConsulta() + "");
        txtCro.setText(d.getCro());
        txtRua.setText(d.getEndereco());
        txtEstado.setText(d.getEstado());
        txtNumero.setText(d.getNumero());

        btnEditarDentista.setEnabled(true);
        btnExcluirDentista.setEnabled(true);
        btnSalvarDentista.setEnabled(false);
        btnNovoDentista.setEnabled(true);
        btnLimparCampos.setEnabled(false);
    }//GEN-LAST:event_tblDentistaMouseClicked

    private void btnExcluirDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDentistaActionPerformed
        switch (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse dentista?")) {
            case 0:
                Dentista dentista = new Dentista(Integer.parseInt(txtId.getText()));
                String resp = new DentistaDAO().excluirDentista(dentista);

                if (resp.equals("OK")) {
                    JOptionPane.showMessageDialog(null, "Dentista excluido com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, resp);
                }
                carregaTabela();
                limparCampos();
                btnNovoDentista.setEnabled(true);
                btnEditarDentista.setEnabled(false);
                btnExcluirDentista.setEnabled(false);
                btnLimparCampos.setEnabled(false);
                btnSalvarDentista.setEnabled(false);
                break;

        }

    }//GEN-LAST:event_btnExcluirDentistaActionPerformed

    private void btnEditarDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDentistaActionPerformed
        habilitaCampos();
        situacao = "edicao";

        btnNovoDentista.setEnabled(false);
        btnExcluirDentista.setEnabled(false);
        btnSalvarDentista.setEnabled(true);
        btnEditarDentista.setEnabled(false);


    }//GEN-LAST:event_btnEditarDentistaActionPerformed

    private void btnNovoDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoDentistaActionPerformed

        limparCampos();
        habilitaCampos();
        btnLimparCampos.setEnabled(true);
        btnSalvarDentista.setEnabled(true);
        btnNovoDentista.setEnabled(true);
        btnEditarDentista.setEnabled(false);
        btnExcluirDentista.setEnabled(false);
        situacao = "cadastro";


    }//GEN-LAST:event_btnNovoDentistaActionPerformed

    private void btnSalvarDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDentistaActionPerformed
        if (verificaPreenchimento()) {
            if (situacao == "cadastro") {
                Dentista dentista = new Dentista(txtNome1.getText(), txtRg.getText(), txtCpf.getText(), txtRua.getText(), txtRua.getText(), txtNumero.getText(), txtComplemento.getText(),
                         txtCep.getText(), txtBairro.getText(), txtEstado.getText(),  txtCidade.getText(),
                        txtCro.getText(), txtEmail.getText(), txtCelular.getText(), txtTelefone.getText(),txtNascimento.getText(), txtNumeroConsultorio.getText(), txtValorConsulta.getText(),
                txtLogin.getText(), txtSenha.getText());
                if (new DentistaDAO().verificaNomeExistente(dentista).equals(txtEmail.getText())) {
                    JOptionPane.showMessageDialog(null, "Dentista ja cadastrado!\nEsse Dentista ja esta cadastrado, digite outro.");
                } else {
                    String resp = new DentistaDAO().gravarDentista(dentista);
                    if (resp.equals("OK")) {
                        JOptionPane.showMessageDialog(rootPane, "Dentista gravada(o) com sucesso.");
                        limparCampos();
                        desabilitaCampos();
                        carregaTabela();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, resp);
                    }
                    situacao = "";
                    btnEditarDentista.setEnabled(false);
                    btnExcluirDentista.setEnabled(false);
                    btnLimparCampos.setEnabled(false);
                    btnSalvarDentista.setEnabled(false);
                    btnNovoDentista.setEnabled(true);
                }
            } else if (situacao == "edicao") {
                 Dentista dentista = new Dentista(txtNome1.getText(), txtRg.getText(), txtCpf.getText(), txtRua.getText(), txtRua.getText(), txtNumero.getText(), txtComplemento.getText(),
                         txtCep.getText(), txtBairro.getText(), txtEstado.getText(),  txtCidade.getText(),
                        txtCro.getText(), txtEmail.getText(), txtCelular.getText(), txtTelefone.getText(),txtNascimento.getText(), txtNumeroConsultorio.getText(), txtValorConsulta.getText(),
                txtLogin.getText(), txtSenha.getText());
                if (new DentistaDAO().verificaNomeExistente(dentista).equals(txtEmail.getText())) {
                    JOptionPane.showMessageDialog(null, "Dentista ja cadastrado!\nEsse Dentista ja esta cadastrado, digite outro.");
                } else {
                    String resp = new DentistaDAO().editarDentista(dentista);
                    if (resp.equals("OK")) {
                        JOptionPane.showMessageDialog(null, "Dentista Alterado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, resp);
                    }
                    carregaTabela();
                    limparCampos();
                    situacao = "";
                    btnEditarDentista.setEnabled(false);
                    btnExcluirDentista.setEnabled(false);
                    btnLimparCampos.setEnabled(false);
                    btnSalvarDentista.setEnabled(false);
                    btnNovoDentista.setEnabled(true);
                }
            } else {
                situacao = "";
            }

        } else {
            JOptionPane.showMessageDialog(null, "Campo Vazio!\nPreencha todos os campos obrigatórios.");
            
        }
    }//GEN-LAST:event_btnSalvarDentistaActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnNovoDentistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoDentistaMouseEntered
       btnNovoDentista.setBackground(Color.white);
       btnNovoDentista.setForeground(azulPadrao);
    }//GEN-LAST:event_btnNovoDentistaMouseEntered

    private void btnNovoDentistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoDentistaMouseExited
        btnNovoDentista.setBackground(azulPadrao);
       btnNovoDentista.setForeground(Color.white);
    }//GEN-LAST:event_btnNovoDentistaMouseExited

    private void btnEditarDentistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarDentistaMouseEntered
         btnEditarDentista.setBackground(Color.white);
         btnEditarDentista.setForeground(azulPadrao);
    }//GEN-LAST:event_btnEditarDentistaMouseEntered

    private void btnEditarDentistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarDentistaMouseExited
       btnEditarDentista.setBackground(azulPadrao);
       btnEditarDentista.setForeground(Color.white);
    }//GEN-LAST:event_btnEditarDentistaMouseExited

    private void btnSalvarDentistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarDentistaMouseEntered
        btnSalvarDentista.setBackground(Color.white);
         btnSalvarDentista.setForeground(azulPadrao);
    }//GEN-LAST:event_btnSalvarDentistaMouseEntered

    private void btnSalvarDentistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarDentistaMouseExited
        btnSalvarDentista.setBackground(azulPadrao);
       btnSalvarDentista.setForeground(Color.white);
    }//GEN-LAST:event_btnSalvarDentistaMouseExited

    private void btnLimparCamposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparCamposMouseEntered
        btnLimparCampos.setBackground(Color.white);
         btnLimparCampos.setForeground(azulPadrao);
    }//GEN-LAST:event_btnLimparCamposMouseEntered

    private void btnLimparCamposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparCamposMouseExited
         btnLimparCampos.setBackground(azulPadrao);
       btnLimparCampos.setForeground(Color.white);
    }//GEN-LAST:event_btnLimparCamposMouseExited

    private void btnExcluirDentistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirDentistaMouseEntered
        btnExcluirDentista.setBackground(Color.red);
       btnExcluirDentista.setForeground(Color.white);
    }//GEN-LAST:event_btnExcluirDentistaMouseEntered

    private void btnExcluirDentistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirDentistaMouseExited
         btnExcluirDentista.setBackground(azulPadrao);
       btnExcluirDentista.setForeground(Color.white);
    }//GEN-LAST:event_btnExcluirDentistaMouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setBackground(Color.red);
       jButton3.setForeground(Color.white);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
       Color azulClaro = new Color(0,204,255);
        jButton3.setBackground(azulClaro);
       jButton3.setForeground(Color.white);
    }//GEN-LAST:event_jButton3MouseExited

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtCroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCroActionPerformed

    private void txtNumeroConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroConsultorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroConsultorioActionPerformed

    private void txtPesquisaDentista1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaDentista1KeyPressed
        //para pesquisar conforme o usuario digita uma letra
        String nome = "%" +txtPesquisaDentista1.getText()+ "%";

        DentistaDAO dao = new DentistaDAO();
        List<Dentista> lista = dao.buscaDentistaPorNome(nome);
        DefaultTableModel dados = (DefaultTableModel) tblDentista.getModel();
        dados.setNumRows(0); //limpar

        for(Dentista c: lista){
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getCro(),
                c.getConsultorio(),
                c.getValorConsulta()
            });
        }
    }//GEN-LAST:event_txtPesquisaDentista1KeyPressed

    private void txtPesquisaDentista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaDentista1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaDentista1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmEditarDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEditarDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEditarDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEditarDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEditarDentista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarDentista;
    private javax.swing.JButton btnExcluirDentista;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnNovoDentista;
    private javax.swing.JButton btnSalvarDentista;
    private javax.swing.JLabel endwe;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nconsu;
    private javax.swing.JLabel nconsu1;
    private javax.swing.JLabel nconsu2;
    private javax.swing.JLabel nconsu3;
    private javax.swing.JLabel nconsu4;
    private javax.swing.JTable tblDentista;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtConfirmarSenha;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtCro;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtNumeroConsultorio;
    private javax.swing.JTextField txtPesquisaDentista1;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtValorConsulta;
    // End of variables declaration//GEN-END:variables
}
