package telas;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import classes.Categoria;
import classes.Cliente;
import classes.Dependente;
import classes.Filme;
import classes.Genero;
import classes.Grau;

@SuppressWarnings("serial")
public class Locacao extends JInternalFrame {

	static final int xPosition = 30, yPosition = 30;
		
	ArrayList<Cliente> cadCliente;

	JTabbedPane abas;
	JPanel pnl_clientes, pnl_locacoes;
	JTextField txf_nome_pesquisa, txf_cpf_pesquisa;
	JButton btn_pesquisar, btn_locacoes;
	
	DefaultTableModel tbl_modelo_clientes, tbl_modelo_locacoes;
	JTable tbl_clientes, tbl_locacoes;
	JScrollPane scp_tbl_clientes, scp_tbl_dependentes;

	JLabel lbl_nome_selecionado, lbl_cpf_selecionado;
	JButton btn_tbl_locacao, btn_tbl_devolucao;
	
	private int idClienteSelecionado, indexClienteSelecionado, idLocacaoSelecionada, indexLocacaoSelecionada; 
	ArrayList<Dependente> temp = new ArrayList<>();
	
	
	public Locacao(ArrayList<Filme> cadFilme, ArrayList<Genero> cadGenero, ArrayList<Categoria> cadCategoria, ArrayList<Cliente> cadCliente) {
		super("Loca��o de Filmes", true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable
		setSize(570, 355);
		setLocation(xPosition, yPosition);
		setLayout(null);

		this.cadCliente = cadCliente;
		
		setarElementos();
		adicionarListeners();
		setarTabelaClientes();
		limparComponentes();

	}


	
	private void setarElementos () {
		
		// Criar Abas
		abas = new JTabbedPane(JTabbedPane.TOP);
		add(abas).setBounds(10, 11, 540, 300);
		
		
		// Pain�is das Abas
		pnl_clientes = new JPanel();
		pnl_clientes.setLayout(null);
		abas.addTab("Clientes", null, pnl_clientes, "Pesquisar Clientes");
		
		pnl_locacoes = new JPanel();
		pnl_locacoes.setLayout(null);
		abas.addTab("Loca��es", null, pnl_locacoes, "Cadastrar Clientes");
		
		// Aba Consulta Clientes
		pnl_clientes.add(new JLabel("Nome:")).setBounds(20, 11, 81, 14);
		txf_nome_pesquisa = new JTextField(10);
		pnl_clientes.add(txf_nome_pesquisa).setBounds(20, 29, 220, 20);

		pnl_clientes.add(new JLabel("CPF:")).setBounds(270, 11, 120, 14);
		txf_cpf_pesquisa = new JTextField(10);
		pnl_clientes.add(txf_cpf_pesquisa).setBounds(270, 29, 120, 20);
		
		
		// Bot�es de A��o
		btn_pesquisar = new JButton("Pesquisar");
		pnl_clientes.add(btn_pesquisar).setBounds(420, 29, 100, 20);
		
		btn_locacoes = new JButton("Loca��es");
		btn_locacoes.setEnabled(false);
		pnl_clientes.add(btn_locacoes).setBounds(420, 69, 100, 20);
		
		
		
		// Criar Tabela de Dados
		tbl_modelo_clientes = new DefaultTableModel();
		tbl_clientes = new JTable(tbl_modelo_clientes);
		scp_tbl_clientes = new JScrollPane(tbl_clientes);
		pnl_clientes.add(scp_tbl_clientes).setBounds(20, 60, 370, 200);
		
		// Preencher Tabela de Dados
		tbl_modelo_clientes.addColumn("ID");
		tbl_modelo_clientes.addColumn("Nome");
		tbl_modelo_clientes.addColumn("CPF");
		tbl_clientes.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbl_clientes.getColumnModel().getColumn(1).setPreferredWidth(150);
		tbl_clientes.getColumnModel().getColumn(2).setPreferredWidth(60);
		
		
	
		
		// Aba Consulta Locacoes
		pnl_locacoes.add(new JLabel("Nome:")).setBounds(20, 11, 81, 14);
		lbl_nome_selecionado = new JLabel("");
		pnl_locacoes.add(lbl_nome_selecionado).setBounds(20, 29, 230, 20);

		pnl_locacoes.add(new JLabel("CPF:")).setBounds(270, 11, 98, 14);
		lbl_cpf_selecionado = new JLabel("");
		pnl_locacoes.add(lbl_cpf_selecionado).setBounds(270, 29, 110, 20);

		// Loca��es
		pnl_locacoes.add(new JLabel("Loca��es:")).setBounds(20, 60, 98, 14);		
		
		// Criar Tabela de Dados
		tbl_modelo_locacoes = new DefaultTableModel();
		tbl_locacoes = new JTable(tbl_modelo_locacoes);
		scp_tbl_dependentes = new JScrollPane(tbl_locacoes);
		pnl_locacoes.add(scp_tbl_dependentes).setBounds(20, 80, 500, 150);
		
		// Colunas da Tabela
		tbl_modelo_locacoes.addColumn("ID");
		tbl_modelo_locacoes.addColumn("Filme");
		tbl_modelo_locacoes.addColumn("Genero");
		tbl_modelo_locacoes.addColumn("Loca��o");
		tbl_modelo_locacoes.addColumn("Devolu��o");
		tbl_modelo_locacoes.addColumn("Status");
		tbl_locacoes.getColumnModel().getColumn(0).setPreferredWidth(10);
		tbl_locacoes.getColumnModel().getColumn(1).setPreferredWidth(100);
		tbl_locacoes.getColumnModel().getColumn(2).setPreferredWidth(50);
		tbl_locacoes.getColumnModel().getColumn(3).setPreferredWidth(50);
		tbl_locacoes.getColumnModel().getColumn(4).setPreferredWidth(50);
		tbl_locacoes.getColumnModel().getColumn(5).setPreferredWidth(50);
		
		
		// Bot�es Tabela Detalhe
		btn_tbl_locacao = new JButton("Nova Loca��o");
		btn_tbl_locacao.setEnabled(false);
		pnl_locacoes.add(btn_tbl_locacao).setBounds(400, 238, 120, 23);
		
		btn_tbl_devolucao = new JButton("Devolu��o");
		btn_tbl_devolucao.setEnabled(false);
		pnl_locacoes.add(btn_tbl_devolucao).setBounds(20, 238, 120, 23);
	}
	
	
	
	private void adicionarListeners() {
		
		// Percebe A��o de Clicar na tabela
		tbl_clientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                //altera os botoes para ativados somente se houver linha selecionada
                if(lsm.isSelectionEmpty()) {
                	lbl_nome_selecionado.setText("");
                	lbl_cpf_selecionado.setText("");
                	idClienteSelecionado = -1;
                }else {
                	idClienteSelecionado = (int) tbl_modelo_clientes.getValueAt(tbl_clientes.getSelectedRow(), 0);
                	lbl_nome_selecionado.setText(tbl_modelo_clientes.getValueAt(tbl_clientes.getSelectedRow(), 1).toString() );
                    lbl_cpf_selecionado.setText(tbl_modelo_clientes.getValueAt(tbl_clientes.getSelectedRow(), 2).toString() );
                    
                }
                
                for(int i = 0; i < cadCliente.size(); i++) { 
					if (cadCliente.get(i).getId() == idClienteSelecionado) {
						indexClienteSelecionado = i;
					} else {indexClienteSelecionado = -1;}
				}
                
                btn_locacoes.setEnabled(!lsm.isSelectionEmpty());
                btn_tbl_locacao.setEnabled(!lsm.isSelectionEmpty());
            }
        });
		
		
		tbl_locacoes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                //altera os botoes para ativados somente se houver linha selecionada
                if(lsm.isSelectionEmpty()) {
                	idLocacaoSelecionada = -1;
                }else {
                	idLocacaoSelecionada = (int) tbl_modelo_clientes.getValueAt(tbl_clientes.getSelectedRow(), 0);                   
                }
                
                btn_tbl_devolucao.setEnabled(!lsm.isSelectionEmpty());
            }
        });
				
		
		
		// A��es dos Bot�es
		btn_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Limpa Tabela
				tbl_modelo_clientes.setNumRows(0);
				String nome = txf_nome_pesquisa.getText().toLowerCase();
				String cpf = txf_cpf_pesquisa.getText().toLowerCase();
				if(nome.isEmpty() && cpf.isEmpty()) {
					setarTabelaClientes();
				} else {
					for (Cliente c : cadCliente) {
                        if(!nome.isEmpty() && !c.getNome().toLowerCase().contains(nome)) continue;
                        if(!cpf.isEmpty() && !c.getCpf().toLowerCase().contains(cpf)) continue;
                        
                        tbl_modelo_clientes.addRow(new Object[]{c.getId(), c.getNome(), c.getCpf()});
					}
				}	
			}
		});	
		
		
		
		btn_locacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				abas.setSelectedIndex(1);
			}
		});
		

		
		btn_tbl_locacao.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(true) {
					JOptionPane.showMessageDialog(null, "Loca��o efetuada com sucesso!", "Loca��o Efetuada!", JOptionPane.WARNING_MESSAGE);
					setarTabelaLocacoes();	
				}				  		
			}
		});	
		
		
		btn_tbl_devolucao.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				// Setar como devolvido
			}
		});	
		
		
	}
	
	
	private void setarTabelaClientes() {
		// Monta Tabela
		tbl_modelo_clientes.setNumRows(0);
		cadCliente.sort(Comparator.comparing(Cliente::getNome));
		for (Cliente c : cadCliente) { tbl_modelo_clientes.addRow(new Object[]{c.getId(), c.getNome(), c.getCpf()});	}
	}
	
	private void setarTabelaLocacoes () {
		tbl_modelo_locacoes.setNumRows(0);
	
		cadCliente.get(indexClienteSelecionado).getDependentes().sort(Comparator.comparing(Dependente::getNome));
		for (Dependente d : cadCliente.get(indexClienteSelecionado).getDependentes()) { 
			tbl_modelo_locacoes.addRow(new Object[]{d.getId(), d.getNome(), d.getGrau()});	
		}
			
			
	}
	
	
	private void limparComponentes () {
		
		tbl_modelo_locacoes.setNumRows(0);
		
	}

}
