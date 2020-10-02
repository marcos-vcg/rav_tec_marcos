package telas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.table.DefaultTableModel;

import classes.Categoria;

@SuppressWarnings("serial")
public class CategoriaCadastro extends JInternalFrame {
	static final int xPosition = 140, yPosition = 90;
	static boolean edit = false;

	public CategoriaCadastro(ArrayList<Categoria> cadCategoria) {
		super("Cadastro de Categorias", true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable
		setSize(350, 300);
		setLocation(xPosition, yPosition);
		setLayout(null);
		
		
		// Criar Abas
		JTabbedPane abas = new JTabbedPane(JTabbedPane.TOP);
		add(abas).setBounds(10, 11, 320, 240);
		
			
		// Pain�is das Abas
		JPanel pnl_consulta = new JPanel();
		pnl_consulta.setLayout(null);
		abas.addTab("Pesquisa", null, pnl_consulta, "Pesquisar Categorias");
		JPanel pnl_cadastro = new JPanel();
		pnl_cadastro.setLayout(null);
		abas.addTab("Cadastro", null, pnl_cadastro, "Cadastrar Categoria");
		
		
		// Aba Consulta
		pnl_consulta.add(new JLabel("Categoria:")).setBounds(20, 18, 98, 14);
		
		JTextField txf_categoria_pesquisa = new JTextField(10);
		pnl_consulta.add(txf_categoria_pesquisa).setBounds(90, 16, 98, 22);
		
		
		// Criar Tabela de Dados
		DefaultTableModel tbl_modelo = new DefaultTableModel();
		JTable tbl_categorias = new JTable(tbl_modelo);
		JScrollPane scp_categorias = new JScrollPane(tbl_categorias);
		pnl_consulta.add(scp_categorias).setBounds(40, 90, 120, 100);		
		
		// Preencher Tabela de Dados
		tbl_modelo.addColumn("Categoria");
		tbl_modelo.addColumn("Pre�o");
		tbl_categorias.getColumnModel().getColumn(0).setPreferredWidth(100);	
		tbl_categorias.getColumnModel().getColumn(1).setPreferredWidth(50);	

		tbl_modelo.setNumRows(0);
		for (Categoria categoria : cadCategoria) {tbl_modelo.addRow(new Object[]{categoria.getNome(), categoria.getPreco()});}
		
		
		JButton btn_pesquisar = new JButton("Pesquisar");
		pnl_consulta.add(btn_pesquisar).setBounds(200, 16, 100, 20);
		btn_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbl_modelo.setNumRows(0);
				if(txf_categoria_pesquisa.getText().contentEquals("")) {
					for (Categoria categoria : cadCategoria) {
						tbl_modelo.addRow(new Object[]{categoria.getNome(), categoria.getPreco()});
					}
				} else {
					for (Categoria categoria : cadCategoria) {
						if(categoria.getNome().toLowerCase().contains(txf_categoria_pesquisa.getText().toLowerCase())) {
							tbl_modelo.addRow(new Object[]{categoria.getNome(), categoria.getPreco()});	} 
					}
				}	
			}
		});	
		
		
		
		
		
		
		
		
		
		JComboBox cbx_categoria = new JComboBox();
		for(int i = 0; i < cadCategoria.size(); i++) {
			cbx_categoria.addItem(cadCategoria.get(i).getNome());
			}
		pnl_consulta.add(cbx_categoria).setBounds(120, 14, 98, 22);
		cbx_categoria.setVisible(false);
		
		JLabel lbl_edit_categoria= new JLabel("Categoria:");
		pnl_consulta.add(lbl_edit_categoria).setBounds(10, 49, 98, 14);
		lbl_edit_categoria.setVisible(false);
		JTextField txf_edit_categoria = new JTextField(10);
		txf_edit_categoria.setBounds(80, 46, 98, 22);
		pnl_consulta.add(txf_edit_categoria);
		txf_edit_categoria.setVisible(false);
		JLabel lbl_edit_preco= new JLabel("Pre�o:");
		pnl_consulta.add(lbl_edit_preco).setBounds(200, 49, 98, 14);
		lbl_edit_preco.setVisible(false);
		JTextField txf_edit_preco = new JTextField(10);
		txf_edit_preco.setBounds(250, 46, 48, 22);
		pnl_consulta.add(txf_edit_preco);
		txf_edit_preco.setVisible(false);
		
		
		
		
		
		
		
		
		// Bot�es de A��o
		JButton btn_editar = new JButton("Editar");
		btn_editar.setEnabled(false);
		pnl_consulta.add(btn_editar).setBounds(210, 90, 80, 25);		
		
		JButton btn_excluir = new JButton("Excluir");
		btn_excluir.setEnabled(false);
		pnl_consulta.add(btn_excluir).setBounds(210, 130, 80, 25);
		btn_excluir.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(!tbl_categorias.isRowSelected(tbl_categorias.getSelectedRow())/*cbx_genero.getSelectedItem().toString().contentEquals("")*/ ) {
					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Exclus�o Inv�lida!", JOptionPane.WARNING_MESSAGE);
				} else {
					cadCategoria.remove(tbl_categorias.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Exclus�o efetuada com sucesso!", "Exclus�ao Efetuado!", JOptionPane.WARNING_MESSAGE);
					tbl_modelo.setNumRows(0);
					for (Categoria categoria : cadCategoria) {tbl_modelo.addRow(new Object[]{categoria.getNome(), categoria.getPreco()});}
				}
			}
		});		     //tbl_modelo.getValueAt(tbl_generos.getSelectedRow(), 0);
		
		JButton btn_novo = new JButton("Novo");
		btn_novo.setVisible(true);
		pnl_consulta.add(btn_novo).setBounds(210, 170, 80, 25);		
		btn_novo.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abas.setSelectedIndex(1);
				//txf_novo_genero.setText(txf_genero_pesquisa.getText());
			}
		});
		
		
		// Percebe A��o de Clicar na tabela
		tbl_categorias.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                //altera os botoes para ativados somente se houver linha selecionada
                btn_editar.setEnabled(!lsm.isSelectionEmpty());
                btn_excluir.setEnabled(!lsm.isSelectionEmpty());
            }
        });
		
		
		
		
		
		
		// Aba Cadastro
		JLabel lbl_novo_genero = new JLabel("G�nero:");
		pnl_cadastro.add(lbl_novo_genero);
		JTextField txf_novo_genero = new JTextField(10);
		pnl_cadastro.add(txf_novo_genero);
		
		JButton btn_cadastro = new JButton("Cadastrar");
		pnl_cadastro.add(btn_cadastro);									// Criar Novo e Edita
		btn_cadastro.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if(txf_novo_genero.getText().contentEquals("") ) {
					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Cadastro Inv�lido!", JOptionPane.WARNING_MESSAGE);
				} else if (edit) {
					cadCategoria.set(tbl_categorias.getSelectedRow(), txf_novo_genero.getText());
					txf_novo_genero.setText("");
					JOptionPane.showMessageDialog(null, "Edi��o efetuada com sucesso!", "Edi��o Efetuada!", JOptionPane.WARNING_MESSAGE);
					btn_cadastro.setText("Cadastrar");
					edit = false;
				} else {
					cadCategoria.add(txf_novo_genero.getText());
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro Efetuado!", JOptionPane.WARNING_MESSAGE);
					txf_novo_genero.setText("");
				}
				tbl_modelo.setNumRows(0);
				for (Categoria categoria : cadCategoria) {tbl_modelo.addRow(new Object[]{categoria.getNome(), categoria.getPreco()});}
			}
		});	
		
		
		btn_editar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Informe o novo nome!", "Edi��o Inv�lida!", JOptionPane.WARNING_MESSAGE);
					txf_novo_genero.setText(tbl_categorias.getValueAt(tbl_categorias.getSelectedRow(), tbl_categorias.getSelectedColumn()).toString());
					tbl_categorias.getValueAt(tbl_categorias.getSelectedRow(), tbl_categorias.getSelectedColumn());
					abas.setSelectedIndex(1);
					btn_cadastro.setText("Editar");
					edit = true;
				}	
			}
		);		
		
		
		
		
		
	
		JButton btn_salvar = new JButton("Salvar");
		btn_salvar.setVisible(false);
		btn_salvar.setBounds(210, 75, 80, 25);
		pnl_consulta.add(btn_salvar);
		//Action Listener mais em baixo
		
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setVisible(false);
		btn_cancelar.setBounds(20, 75, 90, 25);
		pnl_consulta.add(btn_cancelar);
		btn_cancelar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_edit_categoria.setVisible(false);
				lbl_edit_preco.setVisible(false);
				txf_edit_categoria.setVisible(false);
				txf_edit_preco.setVisible(false);
				btn_novo.setVisible(true);
				btn_excluir.setVisible(true);
				btn_editar.setVisible(true);
				JOptionPane.showMessageDialog(null, "Cancelado com sucesso!", "Cancelamento!", JOptionPane.WARNING_MESSAGE);
				btn_salvar.setVisible(false);
				btn_cancelar.setVisible(false);			
			}
		});
		
		
		btn_editar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cbx_categoria.getSelectedItem().toString().contentEquals("") ) {
					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Edi��o Inv�lida!", JOptionPane.WARNING_MESSAGE);
				} else {
					lbl_edit_categoria.setVisible(true);
					lbl_edit_preco.setVisible(true);
					txf_edit_categoria.setVisible(true);
					txf_edit_preco.setVisible(true);
					btn_novo.setVisible(false);
					btn_excluir.setVisible(false);
					btn_editar.setVisible(false);
					JOptionPane.showMessageDialog(null, "Informe o novo nome!", "Edi��o Inv�lida!", JOptionPane.WARNING_MESSAGE);
					btn_salvar.setVisible(true);
					btn_cancelar.setVisible(true);
					
					txf_edit_categoria.setText(cbx_categoria.getSelectedItem().toString());
					txf_edit_preco.setText(cadCategoria.get(cbx_categoria.getSelectedIndex()).getPreco());
				}	
			}
		});
		
		btn_salvar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txf_edit_categoria.getText().contentEquals("") || txf_edit_preco.getText().contentEquals("")) {
					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Edi��o Inv�lida!", JOptionPane.WARNING_MESSAGE);
				} else {
					
					cadCategoria.get(cbx_categoria.getSelectedIndex()).setNome(txf_edit_categoria.getText());
					cadCategoria.get(cbx_categoria.getSelectedIndex()).setPreco(txf_edit_preco.getText());	
					cbx_categoria.insertItemAt(txf_edit_categoria.getText(), cbx_categoria.getSelectedIndex());
					cbx_categoria.removeItemAt(cbx_categoria.getSelectedIndex());
					
					txf_edit_categoria.setText("");
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro Efetuado!", JOptionPane.WARNING_MESSAGE);
					lbl_edit_categoria.setVisible(false);
					lbl_edit_preco.setVisible(false);
					txf_edit_categoria.setVisible(false);
					txf_edit_preco.setVisible(false);
					btn_novo.setVisible(true);
					btn_excluir.setVisible(true);
					btn_editar.setVisible(true);
					btn_salvar.setVisible(false);
					btn_cancelar.setVisible(false);	
					cbx_categoria.setSelectedIndex(0);
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		// Aba Cadastro
		pnl_cadastro.add(new JLabel("Nova Categoria:")).setBounds(55, 18, 98, 14);
		JTextField txf_nova_categoria = new JTextField(10);
		pnl_cadastro.add(txf_nova_categoria).setBounds(150, 14, 98, 22);
		
		pnl_cadastro.add(new JLabel("Pre�o:")).setBounds(55, 38, 98, 14);;
		JTextField txf_novo_preco = new JTextField(10);
		pnl_cadastro.add(txf_novo_preco).setBounds(150, 44, 98, 22);
		
		JButton btn_cadastro_categoria = new JButton("Cadastrar");
		pnl_cadastro.add(btn_cadastro_categoria).setBounds(120, 80, 98, 22);
		
		
		
		btn_cadastro_categoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				if(txf_nova_categoria.getText().contentEquals("") || txf_novo_preco.getText().contentEquals("") ) {
					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Cadastro Inv�lido!", JOptionPane.WARNING_MESSAGE);
				} else {
					Categoria cad_categoria = new Categoria(txf_nova_categoria.getText(), txf_novo_preco.getText());
					cadCategoria.add(cad_categoria);
					cbx_categoria.addItem(txf_nova_categoria.getText());
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro Efetuado!", JOptionPane.WARNING_MESSAGE);
					txf_nova_categoria.setText("");
					txf_novo_preco.setText("");
				}
			}
		});
		
	}
	
}