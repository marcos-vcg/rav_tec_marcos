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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import classes.Categoria;
import classes.Filme;
import classes.Genero;



@SuppressWarnings("serial")
public class FilmeCadastro extends JInternalFrame {

	static final int xPosition = 30, yPosition = 30;
	private final Action cancelar = new SwingAction_cancelar();
	static boolean edit = false;
	

	public FilmeCadastro(ArrayList<Filme> cadFilme, ArrayList<Genero> cadGenero, ArrayList<Categoria> cadCategoria) {
		super("Cadastro de Filmes", true, // resizable
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
		abas.addTab("Pesquisa", null, pnl_consulta, "Pesquisar Filmes");
		JPanel pnl_cadastro = new JPanel();
		pnl_cadastro.setLayout(null);
		abas.addTab("Cadastro", null, pnl_cadastro, "Cadastrar Filme");
		
		
		
		// Aba Consulta
		pnl_consulta.add(new JLabel("Titulo:")).setBounds(20, 11, 81, 14);
		JTextField txf_titulo_pesquisa = new JTextField(10);
		pnl_consulta.add(txf_titulo_pesquisa).setBounds(20, 29, 161, 20);
		
		pnl_consulta.add(new JLabel("Genero:")).setBounds(200, 11, 98, 14);
		JTextField txf_genero_pesquisa = new JTextField(10);
		pnl_consulta.add(txf_genero_pesquisa).setBounds(200, 28, 98, 22);

		pnl_consulta.add(new JLabel("Lan�amento:")).setBounds(320, 11, 75, 14);
		JTextField txf_lancamento_pesquisa = new JTextField(10);
		pnl_consulta.add(txf_lancamento_pesquisa).setBounds(320, 29, 75, 20);
		
		JButton btn_pesquisar = new JButton("Pesquisar");
		pnl_consulta.add(btn_pesquisar).setBounds(420, 29, 100, 20);

		
		// Criar Tabela de Dados
		DefaultTableModel tbl_modelo = new DefaultTableModel();
		JTable tbl_filmes = new JTable(tbl_modelo);
		JScrollPane scp_filmes = new JScrollPane(tbl_filmes);
		pnl_consulta.add(scp_filmes).setBounds(20, 60, 500, 100);
		
		// Preencher Tabela de Dados
		tbl_modelo.addColumn("ID");
		tbl_modelo.addColumn("T�tulo");
		tbl_modelo.addColumn("G�nero");
		tbl_modelo.addColumn("Dura��o");
		tbl_modelo.addColumn("Lan�amento");
		tbl_filmes.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbl_filmes.getColumnModel().getColumn(1).setPreferredWidth(200);
		tbl_filmes.getColumnModel().getColumn(2).setPreferredWidth(60);
		tbl_filmes.getColumnModel().getColumn(3).setPreferredWidth(30);
		tbl_filmes.getColumnModel().getColumn(4).setPreferredWidth(70);
		
		// Monta Tabela
		tbl_modelo.setNumRows(0);
		cadFilme.sort(Comparator.comparing(Filme::getLancamento));
		for (Filme f : cadFilme) { tbl_modelo.addRow(new Object[]{f.getId(), f.getTitulo(), f.getGenero().getNome(), f.getDuracao(), f.getLancamento()});	}
		
		
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
		pnl_cadastro.add(new JLabel("*Titulo:")).setBounds(20, 11, 81, 14);
		JTextField txf_titulo = new JTextField(10);
		pnl_cadastro.add(txf_titulo).setBounds(20, 29, 200, 20);
		
		
		pnl_cadastro.add(new JLabel("*Genero:")).setBounds(250, 11, 98, 14);
		//JComboBox cbx_genero = new JComboBox(cadGenero.toArray());
		JComboBox<String> cbx_genero = new JComboBox<>();
		for(int i = 0; i < cadGenero.size(); i++) {
			cbx_genero.addItem(cadGenero.get(i).getNome());   }
		pnl_cadastro.add(cbx_genero).setBounds(250, 28, 98, 22);
			
		
		pnl_cadastro.add(new JLabel("*C�pias:")).setBounds(380, 11, 55, 14);
		JTextField txf_copias = new JTextField(10);
		pnl_cadastro.add(txf_copias).setBounds(380, 29, 55, 20);
		
		
		pnl_cadastro.add(new JLabel("Dura��o:")).setBounds(20, 65, 98, 14);
		JTextField txf_duracao = new JTextField(10);
		pnl_cadastro.add(txf_duracao).setBounds(20, 90, 90, 20);
		
		
		pnl_cadastro.add(new JLabel("Lan�amento:")).setBounds(130, 65, 75, 14);
		JTextField txf_lancamento = new JTextField(10);
		pnl_cadastro.add(txf_lancamento).setBounds(130, 90, 90, 20);
		
	
		pnl_cadastro.add(new JLabel("Categoria:")).setBounds(250, 65, 98, 14);
		JComboBox<String> cbx_categoria = new JComboBox<>();
		for(int i = 0; i < cadCategoria.size(); i++) {
			cbx_categoria.addItem(cadCategoria.get(i).getNome());   }
		pnl_cadastro.add(cbx_categoria).setBounds(250, 90, 98, 22);

		
		pnl_cadastro.add(new JLabel("Imagem:")).setBounds(380, 65, 75, 14);
		JTextField txf_imagem = new JTextField(5);
		pnl_cadastro.add(txf_imagem).setBounds(380, 90, 135, 20);
		JLabel lbl_mostrar_imagem = new JLabel("");
		pnl_cadastro.add(lbl_mostrar_imagem).setBounds(410, 120, 80, 110);
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
					
				

				// Outra forma  
				/*
				int option = fc_upload.showOpenDialog(getParent());
				if(option == JFileChooser.APPROVE_OPTION) {
					File file = fc_upload.getSelectedFile();
					txf_imagem.setText(file.getPath());
					lbl_mostrar_imagem.setIcon(new ImageIcon(file.getPath()));	}     
				*/
				
				
				/*  // Teste copiar foto
				File arquivo = fc_upload.getSelectedFile();
				FileInputStream origem = new FileInputStream(arquivo.getPath());
				FileOutputStream destino = new FileOutputStream(Path+arquivo.getName());           		         	          		
            	IOUtils.copy(origem,destino);
            	*/
				
				
			}		
		});  
		
	
	
		pnl_cadastro.add(new JLabel("Sinopse:")).setBounds(20, 135, 98, 14);
		//JEditorPane editorPaneSinopse = new JEditorPane();
		//editorPaneSinopse.setBounds(20, 190, 290, 71);
		//pnl_cadastro.add(editorPaneSinopse);
		JTextArea txa_sinopse = new JTextArea(10, 30);
		//pnl_cadastro.add(txa_sinopse).setBounds(20, 190, 290, 71);
		JScrollPane scrl_sinopse = new JScrollPane(txa_sinopse);
		pnl_cadastro.add(scrl_sinopse).setBounds(20, 160, 290, 100);

		
		
		// Bot�es de A��o
		JButton btn_cancelar = new JButton("Cancelar");
		pnl_cadastro.add(btn_cancelar).setBounds(325, 238, 85, 23);
		btn_cancelar.setAction(cancelar);
		
		JButton btn_cadastro = new JButton("Cadastrar");
		pnl_cadastro.add(btn_cadastro).setBounds(424, 238, 100, 23);
		
		
		
		
		
		
		// Percebe A��o de Clicar na tabela
		tbl_filmes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
				if(txf_titulo_pesquisa.getText().contentEquals("") && txf_genero_pesquisa.getText().contentEquals("") && txf_lancamento_pesquisa.getText().contentEquals("")) {
					for (Filme f : cadFilme) {tbl_modelo.addRow(new Object[]{f.getId(), f.getTitulo(), f.getGenero().getNome(), f.getDuracao(), f.getLancamento()});  }
				} else {
					// Filtra a Tabela
					for (Filme f : cadFilme) {
						if(f.getTitulo().toLowerCase().contains(txf_titulo_pesquisa.getText().toLowerCase()) || 
								f.getGenero().getNome().toLowerCase().contains(txf_titulo_pesquisa.getText().toLowerCase()) || 
								f.getLancamento().toLowerCase().contains(txf_titulo_pesquisa.getText().toLowerCase()) ) {
							
							tbl_modelo.addRow(new Object[]{f.getId(), f.getTitulo(), f.getGenero().getNome(), f.getDuracao(), f.getLancamento()});	} 
					}
				}	
			}
		});	
		
		
		
		btn_editar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer idSelected = (Integer) tbl_modelo.getValueAt(tbl_filmes.getSelectedRow(), 0);
				for(int i = 0; i < cadFilme.size(); i++) { 
					if (cadFilme.get(i).getId() == idSelected) {
						txf_titulo.setText(cadFilme.get(i).getTitulo());
						cbx_genero.setSelectedItem(cadFilme.get(i).getGenero().getNome());
						txf_copias.setText(cadFilme.get(i).getCopias().toString());
						txf_duracao.setText(cadFilme.get(i).getDuracao());
						txf_lancamento.setText(cadFilme.get(i).getLancamento());
						cbx_categoria.setSelectedItem(cadFilme.get(i).getCategoria().getNome());
						//txf_imagem.setText(cadFilme.get(i).getImagem().toString());
						lbl_mostrar_imagem.setIcon(cadFilme.get(i).getImagem());
						txa_sinopse.setText(cadFilme.get(i).getSinopse());
					}  
				}
				
				abas.setSelectedIndex(1);
				btn_cadastro.setText("Editar");
				edit = true;
			}	
		});		
		
		btn_excluir.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {				

				Integer idSelected = (Integer) tbl_modelo.getValueAt(tbl_filmes.getSelectedRow(), 0);
				for(int i = 0; i < cadFilme.size(); i++) { if (cadFilme.get(i).getId() == idSelected) {cadFilme.remove(i);}  }
				JOptionPane.showMessageDialog(null, "Exclus�o efetuada com sucesso!", "Exclus�o Efetuada!", JOptionPane.WARNING_MESSAGE);
				
				tbl_modelo.setNumRows(0);
				for (Filme f : cadFilme) {tbl_modelo.addRow(new Object[]{f.getId(), f.getTitulo(), f.getGenero().getNome(), f.getDuracao(), f.getLancamento()});}
				
				txf_titulo.setText("");
				cbx_genero.setSelectedIndex(0);
				txf_copias.setText("");
				txf_duracao.setText("");
				txf_lancamento.setText("");
				cbx_categoria.setSelectedIndex(0);
				txf_imagem.setText("");
				lbl_mostrar_imagem.setText("");
				txa_sinopse.setText("");
				
				btn_cadastro.setText("Cadastrar");
				edit = false;
			}
		});		  

		btn_novo.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_titulo.setText("");
				cbx_genero.setSelectedIndex(0);
				txf_copias.setText("");
				txf_duracao.setText("");
				txf_lancamento.setText("");
				cbx_categoria.setSelectedIndex(0);
				txf_imagem.setText("");
				lbl_mostrar_imagem.setText("");
				txa_sinopse.setText("");
				
				abas.setSelectedIndex(1);
				btn_cadastro.setText("Cadastrar");
				edit = false;
			}
		});
		
		
		
		// Criar e Editar
		btn_cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txf_titulo.getText().contentEquals("")
						|| cbx_genero.getSelectedItem().toString().contentEquals("")
						|| txf_copias.getText().contentEquals("") || txf_lancamento.getText().contentEquals("")) {

					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Cadastro Inv�lido!", JOptionPane.WARNING_MESSAGE);
					abas.setSelectedIndex(0);
					btn_cadastro.setText("Cadastrar");
					edit = false;
				} else if (edit) {
					String palavra = txf_titulo.getText();
					palavra = palavra.substring(0,1).toUpperCase().concat(palavra.substring(1).toLowerCase());
					
					Integer idSelected = (Integer) tbl_modelo.getValueAt(tbl_filmes.getSelectedRow(), 0);
					for(int i = 0; i < cadFilme.size(); i++) { 
						if (cadFilme.get(i).getId() == idSelected) {
							
							cadFilme.get(i).setTitulo(palavra); 
							cadFilme.get(i).setGenero(cadGenero.get(cbx_genero.getSelectedIndex()));
							cadFilme.get(i).setCopias(Integer.parseInt(txf_copias.getText()));
							cadFilme.get(i).setDuracao(txf_duracao.getText());
							cadFilme.get(i).setLancamento(txf_lancamento.getText());
							cadFilme.get(i).setCategoria(cadCategoria.get(cbx_categoria.getSelectedIndex()));
							cadFilme.get(i).setImagem(lbl_mostrar_imagem.getIcon());
							cadFilme.get(i).setSinopse(txa_sinopse.getText());
							
						}  
					}
					
					JOptionPane.showMessageDialog(null, "Edi��o efetuada com sucesso!", "Edi��o Efetuada!", JOptionPane.WARNING_MESSAGE);
					
					
					txf_titulo.setText("");
					cbx_genero.setSelectedIndex(0);
					txf_copias.setText("");
					txf_duracao.setText("");
					txf_lancamento.setText("");
					cbx_categoria.setSelectedIndex(0);
					txf_imagem.setText("");
					lbl_mostrar_imagem.setText("");
					txa_sinopse.setText("");
					
					abas.setSelectedIndex(0);
					btn_cadastro.setText("Cadastrar");
					edit = false;
				} else {
					
					String palavra = txf_titulo.getText();
					palavra = palavra.substring(0,1).toUpperCase().concat(palavra.substring(1).toLowerCase());
					Filme novoFilme = new Filme(palavra, cadGenero.get(cbx_genero.getSelectedIndex()), Integer.parseInt(txf_copias.getText()) );
					novoFilme.setDuracao(txf_duracao.getText());
					novoFilme.setLancamento(txf_lancamento.getText());
					novoFilme.setCategoria(cadCategoria.get(cbx_categoria.getSelectedIndex()));
					novoFilme.setImagem(lbl_mostrar_imagem.getIcon());
					novoFilme.setSinopse(txa_sinopse.getText());
					cadFilme.add(novoFilme);
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro Efetuado!", JOptionPane.WARNING_MESSAGE);
					
					txf_titulo.setText("");
					cbx_genero.setSelectedIndex(0);
					txf_copias.setText("");
					txf_duracao.setText("");
					txf_lancamento.setText("");
					cbx_categoria.setSelectedIndex(0);
					txf_imagem.setText("");
					lbl_mostrar_imagem.setText("");
					txa_sinopse.setText("");
					
				}
				
				tbl_modelo.setNumRows(0);
				cadFilme.sort(Comparator.comparing(Filme::getLancamento));
				for (Filme f : cadFilme) { tbl_modelo.addRow(new Object[]{f.getId(), f.getTitulo(), f.getGenero().getNome(), f.getDuracao(), f.getLancamento()});	}
				
			}
		});
		
		
	}


	
	private class SwingAction_cancelar extends AbstractAction {
		public SwingAction_cancelar() {
			putValue(NAME, "Cancelar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	
	// N�o estou usando
	public static void imprimirFilmes(ArrayList<Filme> cadFilme) {
		System.out.println("Total de Filmes: " + cadFilme.size());
		int i = 1;
		for(Filme filme: cadFilme) { 
			System.out.println("");
			System.out.println("Filme: " + i++);
			System.out.println("");
			System.out.println(filme.getId()); 
			System.out.println(filme.getTitulo()); 
			System.out.println(filme.getGenero().getNome());
			System.out.println(filme.getCopias());
			System.out.println(filme.getLancamento());
			System.out.println(filme.getDuracao());
			System.out.println(filme.getCategoria());
			System.out.println(filme.getImagem());
			System.out.println(filme.getSinopse()); 
			System.out.println(""); }
	}
	
}
