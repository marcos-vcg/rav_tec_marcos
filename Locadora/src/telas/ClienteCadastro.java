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
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import classes.Cliente;
import classes.Filme;

@SuppressWarnings("serial")
public class ClienteCadastro extends JInternalFrame {

	static final int xPosition = 30, yPosition = 30;
	private final Action salvar = new SwingAction();
	private final Action cancelar = new SwingAction_1();
	static boolean edit = false;

	public ClienteCadastro(ArrayList<Cliente> cadCliente) {
		super("Cadastro de Clientes", true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable
		setSize(570, 355);
		setLocation(xPosition, yPosition);
		setLayout(null);

		
		// Criar Abas
		JTabbedPane abas = new JTabbedPane(JTabbedPane.TOP);
		add(abas).setBounds(10, 11, 540, 300);
		
		
		// Pain�is das Abas
		JPanel pnl_consulta = new JPanel();
		pnl_consulta.setLayout(null);
		abas.addTab("Pesquisa", null, pnl_consulta, "Pesquisar Clientes");
		JPanel pnl_cadastro = new JPanel();
		pnl_cadastro.setLayout(null);
		abas.addTab("Cadastro", null, pnl_cadastro, "Cadastrar Clientes");
		
		
		// Aba Consulta
		pnl_consulta.add(new JLabel("Nome:")).setBounds(20, 11, 81, 14);
		JTextField txf_nome_pesquisa = new JTextField(10);
		pnl_consulta.add(txf_nome_pesquisa).setBounds(20, 29, 220, 20);

		pnl_consulta.add(new JLabel("CPF:")).setBounds(270, 11, 120, 14);
		JTextField txf_cpf_pesquisa = new JTextField(10);
		pnl_consulta.add(txf_cpf_pesquisa).setBounds(270, 29, 120, 20);
		
		JButton btn_pesquisar = new JButton("Pesquisar");
		pnl_consulta.add(btn_pesquisar).setBounds(420, 29, 100, 20);
		
		
		
		// Criar Tabela de Dados
		DefaultTableModel tbl_modelo = new DefaultTableModel();
		JTable tbl_clientes = new JTable(tbl_modelo);
		JScrollPane scp_tbl_clientes = new JScrollPane(tbl_clientes);
		pnl_consulta.add(scp_tbl_clientes).setBounds(20, 60, 500, 100);
		
		// Preencher Tabela de Dados
		tbl_modelo.addColumn("ID");
		tbl_modelo.addColumn("Nome");
		tbl_modelo.addColumn("CPF");
		tbl_modelo.addColumn("Email");
		tbl_clientes.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbl_clientes.getColumnModel().getColumn(1).setPreferredWidth(220);
		tbl_clientes.getColumnModel().getColumn(2).setPreferredWidth(80);
		tbl_clientes.getColumnModel().getColumn(3).setPreferredWidth(80);		
		
		
		// Monta Tabela
		tbl_modelo.setNumRows(0);
		cadCliente.sort(Comparator.comparing(Cliente::getNome));
		for (Cliente c : cadCliente) { tbl_modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getCpf(), c.getEmail()});	}
		
		
		// Bot�es de A��o
		JButton btn_editar = new JButton("Editar");
		btn_editar.setEnabled(false);
		pnl_consulta.add(btn_editar).setBounds(230, 225, 80, 25);		
		
		JButton btn_excluir = new JButton("Excluir");
		btn_excluir.setEnabled(false);
		pnl_consulta.add(btn_excluir).setBounds(330, 225, 80, 25);
		
		JButton btn_novo = new JButton("Novo");
		btn_novo.setVisible(true);
		pnl_consulta.add(btn_novo).setBounds(430, 225, 80, 25);		
		

		
		
		
		
		// Aba Cadastro
		pnl_cadastro.add(new JLabel("*Nome:")).setBounds(20, 11, 81, 14);
		JTextField txf_nome = new JTextField(10);
		pnl_cadastro.add(txf_nome).setBounds(20, 29, 230, 20);

		pnl_cadastro.add(new JLabel("*CPF:")).setBounds(270, 11, 98, 14);
		JTextField txf_cpf = new JTextField(10);
		pnl_cadastro.add(txf_cpf).setBounds(270, 29, 110, 20);
		
		pnl_cadastro.add(new JLabel("*Telefone:")).setBounds(400, 11, 100, 14);
		JTextField txf_telefone = new JTextField(10);
		pnl_cadastro.add(txf_telefone).setBounds(400, 29, 115, 20);
		
		

		pnl_cadastro.add(new JLabel("Email:")).setBounds(20, 65, 55, 14);
		JTextField txf_email = new JTextField(10);
		pnl_cadastro.add(txf_email).setBounds(20, 90, 120, 20);

		pnl_cadastro.add(new JLabel("Nascimento:")).setBounds(160, 65, 90, 14);
		JTextField txf_nascimento = new JTextField(10);
		pnl_cadastro.add(txf_nascimento).setBounds(160, 90, 90, 20);
	

		
		pnl_cadastro.add(new JLabel("Endere�o:")).setBounds(270, 65, 90, 14);
		JTextField txf_endereco = new JTextField(10);
		pnl_cadastro.add(txf_endereco).setBounds(270, 90, 110, 20);
		
		pnl_cadastro.add(new JLabel("Foto:")).setBounds(400, 65, 75, 14);
		JTextField txf_imagem = new JTextField(5);
		pnl_cadastro.add(txf_imagem).setBounds(400, 90, 115, 20);
		JLabel lbl_mostrar_imagem = new JLabel("");
		pnl_cadastro.add(lbl_mostrar_imagem).setBounds(415, 120, 90, 110);
		JButton btn_upload = new JButton("Upload");
		pnl_cadastro.add(btn_upload).setBounds(440, 65, 75, 18);
		
		
		btn_upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc_upload = new JFileChooser();
				fc_upload.setDialogTitle("Procurar aquivo");
				fc_upload.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				fc_upload.setFileFilter(filter);
				fc_upload.showOpenDialog(getParent());
				
				// Import ImageIcon   
				if(fc_upload.getSelectedFile() != null) {
					ImageIcon iconLogo = new ImageIcon(fc_upload.getSelectedFile().getPath());
					// lbl_mostrar_imagem.setIcon(iconLogo);  //  Mostra a imagem cortada de acordo com o tamanho destino. 
					// Mostra Imagem Redimensionada
					lbl_mostrar_imagem.setIcon(new ImageIcon(iconLogo.getImage().getScaledInstance(lbl_mostrar_imagem.getWidth(),lbl_mostrar_imagem.getHeight(), Image.SCALE_DEFAULT)));
					txf_imagem.setText(fc_upload.getSelectedFile().getAbsolutePath());  	 // Mostra no campo de texto o caminho 
				}  						
			}		
		}); 
		
		
		
		pnl_cadastro.add(new JLabel("Dependentes:")).setBounds(20, 135, 98, 14);
		JTextArea txa_dependentes = new JTextArea(10, 30);
		JScrollPane scrl_sinopse = new JScrollPane(txa_dependentes);
		pnl_cadastro.add(scrl_sinopse).setBounds(20, 160, 290, 100);

		
		
		
		// Bot�es de A��o
		JButton btnVoltar = new JButton("Cancelar");
		pnl_cadastro.add(btnVoltar).setBounds(325, 238, 85, 23);
		btnVoltar.setAction(cancelar);

		JButton btn_cadastro = new JButton("Cadastrar");
		pnl_cadastro.add(btn_cadastro).setBounds(424, 238, 100, 23);
		
		

		
		// Percebe A��o de Clicar na tabela
		tbl_clientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                //altera os botoes para ativados somente se houver linha selecionada
                btn_editar.setEnabled(!lsm.isSelectionEmpty());
                btn_excluir.setEnabled(!lsm.isSelectionEmpty());
            }
        });
		
		
		
		
		// A��es dos Bot�es
		btn_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Remonta Tabela
				tbl_modelo.setNumRows(0);
				if(txf_nome_pesquisa.getText().contentEquals("") && txf_cpf_pesquisa.getText().contentEquals("")) {
					for (Cliente c : cadCliente) {tbl_modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getCpf(), c.getEmail()});  }
				} else {
					// Filtra a Tabela
					for (Cliente c : cadCliente) {
						if(c.getNome().toLowerCase().contains(txf_nome_pesquisa.getText().toLowerCase()) || 
								c.getCpf().toLowerCase().contains(txf_cpf_pesquisa.getText().toLowerCase())  ) {
							
							tbl_modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getCpf(), c.getEmail()});	} 
					}
				}	
			}
		});	
		
		
		
		btn_editar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer idSelected = (Integer) tbl_modelo.getValueAt(tbl_clientes.getSelectedRow(), 0);
				for(int i = 0; i < cadCliente.size(); i++) { 
					if (cadCliente.get(i).getId() == idSelected) {
						txf_nome.setText(cadCliente.get(i).getNome());
						txf_cpf.setText(cadCliente.get(i).getCpf());
						txf_telefone.setText(cadCliente.get(i).getTelefone());
						txf_email.setText(cadCliente.get(i).getEmail());
						txf_nascimento.setText(cadCliente.get(i).getNascimento());
						txf_endereco.setText(cadCliente.get(i).getNascimento());
						//txf_imagem.setText(cadFilme.get(i).getImagem().toString());
						lbl_mostrar_imagem.setIcon(cadCliente.get(i).getImagem());
						txa_dependentes.setText(cadCliente.get(i).getDependente1());
					}  
				}
				
				abas.setSelectedIndex(1);
				btn_cadastro.setText("Editar");
				edit = true;
			}	
		});		
		
		btn_excluir.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {				

				Integer idSelected = (Integer) tbl_modelo.getValueAt(tbl_clientes.getSelectedRow(), 0);
				for(int i = 0; i < cadCliente.size(); i++) { if (cadCliente.get(i).getId() == idSelected) {cadCliente.remove(i);}  }
				JOptionPane.showMessageDialog(null, "Exclus�o efetuada com sucesso!", "Exclus�o Efetuada!", JOptionPane.WARNING_MESSAGE);
				
				tbl_modelo.setNumRows(0);
				for (Cliente c : cadCliente) {tbl_modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getCpf(), c.getEmail()});}
				
				txf_nome.setText("");
				txf_cpf.setText("");
				txf_telefone.setText("");
				txf_email.setText("");
				txf_nascimento.setText("");
				txf_endereco.setText("");
				txf_imagem.setText("");
				lbl_mostrar_imagem.setText("");
				txa_dependentes.setText("");
				
				btn_cadastro.setText("Cadastrar");
				edit = false;
			}
		});		  

		btn_novo.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_nome.setText("");
				txf_cpf.setText("");
				txf_telefone.setText("");
				txf_email.setText("");
				txf_nascimento.setText("");
				txf_endereco.setText("");
				txf_imagem.setText("");
				lbl_mostrar_imagem.setText("");
				txa_dependentes.setText("");
				
				abas.setSelectedIndex(1);
				btn_cadastro.setText("Cadastrar");
				edit = false;
			}
		});
		
		
		
		
		
		// Criar e Editar
		btn_cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txf_nome.getText().contentEquals("") || txf_cpf.getText().contentEquals("") || txf_telefone.getText().contentEquals("") ) {

					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Cadastro Inv�lido!", JOptionPane.WARNING_MESSAGE);
					abas.setSelectedIndex(0);
					btn_cadastro.setText("Cadastrar");
					edit = false;
				} else if (edit) {
					String palavra = txf_nome.getText();
					palavra = palavra.substring(0,1).toUpperCase().concat(palavra.substring(1).toLowerCase());
					
					Integer idSelected = (Integer) tbl_modelo.getValueAt(tbl_clientes.getSelectedRow(), 0);
					for(int i = 0; i < cadCliente.size(); i++) { 
						if (cadCliente.get(i).getId() == idSelected) {
							
							cadCliente.get(i).setNome(palavra); 
							cadCliente.get(i).setCpf(txf_cpf.getText());
							cadCliente.get(i).setTelefone(txf_telefone.getText());
							cadCliente.get(i).setEmail(txf_email.getText());
							cadCliente.get(i).setNascimento(txf_nascimento.getText());
							cadCliente.get(i).setEndereco(txf_endereco.getText());
							cadCliente.get(i).setImagem(lbl_mostrar_imagem.getIcon());
							cadCliente.get(i).setDependente1(txa_dependentes.getText());
							
						}  
					}
					
					JOptionPane.showMessageDialog(null, "Edi��o efetuada com sucesso!", "Edi��o Efetuada!", JOptionPane.WARNING_MESSAGE);
					
					
					txf_nome.setText("");
					txf_cpf.setText("");
					txf_telefone.setText("");
					txf_email.setText("");
					txf_nascimento.setText("");
					txf_endereco.setText("");
					txf_imagem.setText("");
					lbl_mostrar_imagem.setText("");
					txa_dependentes.setText("");
					
					abas.setSelectedIndex(0);
					btn_cadastro.setText("Cadastrar");
					edit = false;
				} else {
					
					String palavra = txf_nome.getText();
					palavra = palavra.substring(0,1).toUpperCase().concat(palavra.substring(1).toLowerCase());
					Cliente novoCliente = new Cliente(palavra, txf_cpf.getText(), txf_telefone.getText() );
					novoCliente.setEmail(txf_email.getText());
					novoCliente.setNascimento(txf_nascimento.getText());
					novoCliente.setEndereco(txf_endereco.getText());
					novoCliente.setImagem(lbl_mostrar_imagem.getIcon());
					novoCliente.setDependente1(txa_dependentes.getText());
					cadCliente.add(novoCliente);
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro Efetuado!", JOptionPane.WARNING_MESSAGE);
					
					txf_nome.setText("");
					txf_cpf.setSelectedIndex(0);
					txf_telefone.setText("");
					txf_email.setText("");
					txf_nascimento.setText("");
					txf_endereco.setSelectedIndex(0);
					txf_imagem.setText("");
					lbl_mostrar_imagem.setText("");
					txa_dependentes.setText("");
					
				}
				
				tbl_modelo.setNumRows(0);
				cadFilme.sort(Comparator.comparing(Filme::getLancamento));
				for (Filme f : cadFilme) { tbl_modelo.addRow(new Object[]{f.getId(), f.getTitulo(), f.getGenero().getNome(), f.getDuracao(), f.getLancamento()});	}
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		btn_cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txf_nome.getText().contentEquals("")
						|| txf_cpf.getText().contentEquals("") || txf_telefone.getText().contentEquals("")) {

					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Cadastro Inv�lido!",
							JOptionPane.WARNING_MESSAGE);
				} else {

					Cliente cliente = new Cliente(txf_nome.getText(), txf_cpf.getText(), txf_telefone.getText());
					
					//cliente.setDuracao(textDuracao.getText());
					//cliente.setCategoria(comboBoxCategoria.getSelectedItem().toString());
					// filme.setImagem( pegar imagem );
					//cliente.setSinopse(editorPaneSinopse.getText());
					cadCliente.add(cliente);

					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro Efetuado!",
							JOptionPane.WARNING_MESSAGE);
					System.out.println(cadCliente.size());
				}

				/*
				 * for(Filme filme: filmes) { System.out.println("");
				 * System.out.println(filme.getTitulo()); System.out.println(filme.getGenero());
				 * System.out.println(filme.getCopias());
				 * System.out.println(filme.getLancamento());
				 * System.out.println(filme.getDuracao());
				 * System.out.println(filme.getCategoria());
				 * System.out.println(filme.getSinopse()); System.out.println(""); }
				 */

			}
		});
		btn_cadastro.setAction(salvar);
		
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Salvar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Voltar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
