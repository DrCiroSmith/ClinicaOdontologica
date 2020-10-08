package Formularios;

import Classes.Conecta;
import Classes.Produto;
import Classes.ProdutoDAO;
import Classes.Utilidades;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class frmEstoqueGeral extends javax.swing.JFrame {
    Color azulPadrao = new Color(129,167,255);
    Color azulClaro = new Color(226, 235, 255);
    Color azulHover = new Color(192, 216, 235);
    Color vermelhoHover = new Color(242, 198, 196);
    Color vermelhoPadraoExcluir = new Color(223,107,111);
    
    private boolean verificaPreenchimento() {
        if (txtFabricante.getText().equals("") || txtProduto.getText().equals("")) {
            return false;
        }
        return true;
    }
    private void limparCampos() {
        txtFabricante.setText("");
        txtProduto.setText("");
    }
    private void habilitaCampos() {
        txtFabricante.setEnabled(true);
        txtProduto.setEnabled(true);
    }
    private void desabilitaCampos() {
        txtFabricante.setEnabled(false);
        txtProduto.setEnabled(false);
    }
   /* private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblItens.getModel();
        modelo.setNumRows(0);
        try {
            java.sql.Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT p.id, p.nome, p.fabricante, sum(e.quantidade) FROM produto p, produtoEstoque e "
                    + "WHERE p.id=e.produtoId");
            rs = pstm.executeQuery();
            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getInt("p.id"),
                    rs.getString("nome"),
                    rs.getString("fabricante"),
                    rs.getInt("sum(e.quantidade)")});
            }
            pstm.close();
            con.close();
            rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    */
    
     private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblItens.getModel();
        modelo.setNumRows(0);
        try {
            java.sql.Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT e.id, p.nome, p.fabricante, e.quantidade, e.peso, e.validade "
                    + "FROM produto p, produtoEstoque e WHERE p.id=e.produtoId");
            rs = pstm.executeQuery();

            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getInt("e.id"),
                    rs.getString("p.nome"),
                    rs.getString("p.fabricante"),
                    rs.getInt("e.quantidade"),
                    rs.getFloat("e.peso"),
                    rs.getString("e.validade")});
            }
            pstm.close();
            con.close();
            rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public frmEstoqueGeral() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        //Mudando a cor do fundo da tabela
        jScrollPane1.getViewport().setBackground(Color.WHITE);
         getContentPane().setBackground(azulClaro);
        carregaTabela();
        //mudar a cor do cabeçalho da tabela
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(azulPadrao);
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < tblItens.getModel().getColumnCount(); i++) {
            tblItens.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAdicionarEstoque = new javax.swing.JButton();
        btnNovoProduto = new javax.swing.JButton();
        btnSalvarProduto = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFabricante = new javax.swing.JTextField();
        txtProduto = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        btnSair1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jmiPacientes1 = new javax.swing.JMenuItem();
        jmiDentistas = new javax.swing.JMenuItem();
        jmiRecepcionistas = new javax.swing.JMenuItem();
        jmiConsultas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiEstoque = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jmiSair = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setBorder(null);

        tblItens.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Fabricante", "Quantidade", "Peso", "Validade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblItens);
        if (tblItens.getColumnModel().getColumnCount() > 0) {
            tblItens.getColumnModel().getColumn(0).setResizable(false);
            tblItens.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblItens.getColumnModel().getColumn(1).setResizable(false);
            tblItens.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblItens.getColumnModel().getColumn(2).setResizable(false);
            tblItens.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblItens.getColumnModel().getColumn(3).setResizable(false);
            tblItens.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblItens.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(129, 167, 255));
        jLabel1.setText("ESTOQUE");

        btnAdicionarEstoque.setBackground(new java.awt.Color(129, 167, 255));
        btnAdicionarEstoque.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAdicionarEstoque.setForeground(new java.awt.Color(255, 255, 255));
        btnAdicionarEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/incluir.png"))); // NOI18N
        btnAdicionarEstoque.setText("Adicionar Item");
        btnAdicionarEstoque.setMaximumSize(new java.awt.Dimension(141, 31));
        btnAdicionarEstoque.setMinimumSize(new java.awt.Dimension(141, 31));
        btnAdicionarEstoque.setPreferredSize(new java.awt.Dimension(141, 31));
        btnAdicionarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEstoqueActionPerformed(evt);
            }
        });

        btnNovoProduto.setBackground(new java.awt.Color(129, 167, 255));
        btnNovoProduto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovoProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/novo.png"))); // NOI18N
        btnNovoProduto.setText(" Novo Produto");
        btnNovoProduto.setMaximumSize(new java.awt.Dimension(141, 31));
        btnNovoProduto.setMinimumSize(new java.awt.Dimension(141, 31));
        btnNovoProduto.setPreferredSize(new java.awt.Dimension(141, 31));
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });

        btnSalvarProduto.setBackground(new java.awt.Color(129, 167, 255));
        btnSalvarProduto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvarProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/salvar.png"))); // NOI18N
        btnSalvarProduto.setText("Salvar Produto");
        btnSalvarProduto.setEnabled(false);
        btnSalvarProduto.setMaximumSize(new java.awt.Dimension(141, 31));
        btnSalvarProduto.setMinimumSize(new java.awt.Dimension(141, 31));
        btnSalvarProduto.setPreferredSize(new java.awt.Dimension(141, 31));
        btnSalvarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarProdutoActionPerformed(evt);
            }
        });

        btnLimparCampos.setBackground(new java.awt.Color(129, 167, 255));
        btnLimparCampos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLimparCampos.setForeground(new java.awt.Color(255, 255, 255));
        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/limpar.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.setEnabled(false);
        btnLimparCampos.setMaximumSize(new java.awt.Dimension(141, 31));
        btnLimparCampos.setMinimumSize(new java.awt.Dimension(141, 31));
        btnLimparCampos.setPreferredSize(new java.awt.Dimension(141, 31));
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        jLabel3.setText("Fabricante:");

        jLabel4.setText("Produto:");

        txtFabricante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFabricante.setEnabled(false);

        txtProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtProduto.setEnabled(false);

        btnSair.setBackground(new java.awt.Color(51, 255, 255));
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/voltar.png"))); // NOI18N
        btnSair.setText("voltar");
        btnSair.setBorder(null);
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSairMouseExited(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnSair1.setBackground(new java.awt.Color(129, 167, 255));
        btnSair1.setForeground(new java.awt.Color(255, 255, 255));
        btnSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/zoom.png"))); // NOI18N
        btnSair1.setText("Zoom");
        btnSair1.setBorder(null);
        btnSair1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSair1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSair1MouseExited(evt);
            }
        });
        btnSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Esta tela está em processo de desenvolvimento*");

        jMenuBar2.setBackground(new java.awt.Color(129, 167, 255));
        jMenuBar2.setForeground(new java.awt.Color(129, 167, 255));
        jMenuBar2.setBorderPainted(false);
        jMenuBar2.setPreferredSize(new java.awt.Dimension(346, 60));

        jMenu6.setText("         ");
        jMenu6.setEnabled(false);
        jMenuBar2.add(jMenu6);

        jMenu2.setBorder(null);
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/registrar.png"))); // NOI18N
        jMenu2.setText(" Registrar");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jmiPacientes1.setBackground(new java.awt.Color(129, 167, 255));
        jmiPacientes1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiPacientes1.setForeground(java.awt.Color.white);
        jmiPacientes1.setText("Registrar Paciente");
        jmiPacientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPacientes1ActionPerformed(evt);
            }
        });
        jMenu2.add(jmiPacientes1);

        jmiDentistas.setBackground(new java.awt.Color(129, 167, 255));
        jmiDentistas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiDentistas.setForeground(java.awt.Color.white);
        jmiDentistas.setText("Registrar Dentista");
        jmiDentistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDentistasActionPerformed(evt);
            }
        });
        jMenu2.add(jmiDentistas);

        jmiRecepcionistas.setBackground(new java.awt.Color(129, 167, 255));
        jmiRecepcionistas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiRecepcionistas.setForeground(java.awt.Color.white);
        jmiRecepcionistas.setText("Registrar Recepcionista");
        jmiRecepcionistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRecepcionistasActionPerformed(evt);
            }
        });
        jMenu2.add(jmiRecepcionistas);

        jmiConsultas.setBackground(new java.awt.Color(129, 167, 255));
        jmiConsultas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiConsultas.setForeground(java.awt.Color.white);
        jmiConsultas.setText("Agendar Consulta");
        jmiConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultasActionPerformed(evt);
            }
        });
        jMenu2.add(jmiConsultas);

        jSeparator1.setForeground(java.awt.Color.white);
        jMenu2.add(jSeparator1);

        jmiEstoque.setBackground(new java.awt.Color(129, 167, 255));
        jmiEstoque.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiEstoque.setForeground(java.awt.Color.white);
        jmiEstoque.setText("Estoque");
        jmiEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEstoqueActionPerformed(evt);
            }
        });
        jMenu2.add(jmiEstoque);

        jSeparator4.setForeground(java.awt.Color.white);
        jMenu2.add(jSeparator4);

        jmiSair.setBackground(new java.awt.Color(129, 167, 255));
        jmiSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiSair.setForeground(java.awt.Color.white);
        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jMenu2.add(jmiSair);

        jMenuBar2.add(jMenu2);

        jMenu4.setText("         ");
        jMenu4.setEnabled(false);
        jMenuBar2.add(jMenu4);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/agendar.png"))); // NOI18N
        jMenu3.setText(" Agendas");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem1.setBackground(new java.awt.Color(129, 167, 255));
        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem1.setForeground(java.awt.Color.white);
        jMenuItem1.setText("Consultas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem10.setBackground(new java.awt.Color(129, 167, 255));
        jMenuItem10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem10.setForeground(java.awt.Color.white);
        jMenuItem10.setText("Consultas por dentista");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar2.add(jMenu3);

        jMenu7.setText("         ");
        jMenu7.setEnabled(false);
        jMenuBar2.add(jMenu7);

        jMenu8.setForeground(new java.awt.Color(255, 255, 255));
        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/prontuario.png"))); // NOI18N
        jMenu8.setText(" Prontuários");
        jMenu8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu8MouseEntered(evt);
            }
        });
        jMenuBar2.add(jMenu8);

        jMenu10.setForeground(new java.awt.Color(255, 255, 255));
        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/ajuda.png"))); // NOI18N
        jMenu10.setText(" Ajuda");
        jMenu10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenu10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        jMenuItem8.setBackground(new java.awt.Color(129, 167, 255));
        jMenuItem8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem8.setForeground(java.awt.Color.white);
        jMenuItem8.setText("Ajuda");
        jMenu10.add(jMenuItem8);

        jMenuItem9.setBackground(new java.awt.Color(129, 167, 255));
        jMenuItem9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem9.setForeground(java.awt.Color.white);
        jMenuItem9.setText("Sobre");
        jMenu10.add(jMenuItem9);

        jMenuBar2.add(jMenu10);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(333, 333, 333)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionarEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSair1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104)
                        .addComponent(btnNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btnSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btnAdicionarEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );

        setBounds(0, 0, 1112, 567);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEstoqueActionPerformed
        frmAdicionarItemEstoque frm = new frmAdicionarItemEstoque();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdicionarEstoqueActionPerformed

    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        habilitaCampos();
        btnNovoProduto.setEnabled(false);
        btnLimparCampos.setEnabled(true);
        btnSalvarProduto.setEnabled(true);
        btnAdicionarEstoque.setEnabled(false);
    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    private void btnSalvarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarProdutoActionPerformed
        if (verificaPreenchimento()) {
            Produto produto = new Produto(txtProduto.getText(), txtFabricante.getText());
            String resp = new ProdutoDAO().gravarProduto(produto);

            if (resp.equals("OK")) {
                Utilidades.criarMensagemSucesso();
            } else {
                JOptionPane.showMessageDialog(rootPane, resp);
            }
            carregaTabela();
            limparCampos();
            desabilitaCampos();
            btnNovoProduto.setEnabled(true);
            btnLimparCampos.setEnabled(false);
            btnSalvarProduto.setEnabled(false);
            btnAdicionarEstoque.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Campo Vazio!\nPreencha todos os campos obrigatórios.");
        }
    }//GEN-LAST:event_btnSalvarProdutoActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void jmiPacientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPacientes1ActionPerformed
        frmEditarPaciente frm = new frmEditarPaciente();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_jmiPacientes1ActionPerformed

    private void jmiDentistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDentistasActionPerformed
        frmEditarDentista frm = new frmEditarDentista();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_jmiDentistasActionPerformed

    private void jmiRecepcionistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRecepcionistasActionPerformed
        frmAdicionarRecepcionista frm = new frmAdicionarRecepcionista();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_jmiRecepcionistasActionPerformed

    private void jmiConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultasActionPerformed
        frmAdicionarConsulta frm = new frmAdicionarConsulta();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_jmiConsultasActionPerformed

    private void jmiEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEstoqueActionPerformed
        frmEstoqueGeral frm = new frmEstoqueGeral();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_jmiEstoqueActionPerformed

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        frmAgendaGeral frm = new frmAgendaGeral();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        frmAgendaEspecifica frm = new frmAgendaEspecifica();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered
        btnSair.setBackground(Color.white);
        btnSair.setForeground(azulPadrao);
    }//GEN-LAST:event_btnSairMouseEntered

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
        btnSair.setBackground(azulClaro);
        btnSair.setForeground(Color.white);
    }//GEN-LAST:event_btnSairMouseExited

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSair1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSair1MouseEntered
        btnSair1.setBackground(Color.white);
        btnSair1.setForeground(azulPadrao);
    }//GEN-LAST:event_btnSair1MouseEntered

    private void btnSair1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSair1MouseExited
        btnSair1.setBackground(azulPadrao);
        btnSair1.setForeground(Color.white);
    }//GEN-LAST:event_btnSair1MouseExited

    private void btnSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSair1ActionPerformed

    private void jMenu8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu8MouseEntered

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
            java.util.logging.Logger.getLogger(frmEstoqueGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEstoqueGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEstoqueGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEstoqueGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEstoqueGeral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarEstoque;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSair1;
    private javax.swing.JButton btnSalvarProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem jmiConsultas;
    private javax.swing.JMenuItem jmiDentistas;
    private javax.swing.JMenuItem jmiEstoque;
    private javax.swing.JMenuItem jmiPacientes1;
    private javax.swing.JMenuItem jmiRecepcionistas;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JTable tblItens;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtProduto;
    // End of variables declaration//GEN-END:variables
}
