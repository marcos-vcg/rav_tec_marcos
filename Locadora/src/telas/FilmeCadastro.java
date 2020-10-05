package telas;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import classes.Categoria;
import classes.Filme;



@SuppressWarnings("serial")
public class FilmeCadastro extends JInternalFrame {

	static final int xPosition = 30, yPosition = 30;
	private final Action cancelar = new SwingAction_cancelar();
	

	public FilmeCadastro(ArrayList<Filme> cadFilme, ArrayList<String> cadGenero, ArrayList<Categoria> cadCategoria) {
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
		
		
		
		// Painel Consulta
		JLabel lbl_titulo_pesquisa = new JLabel("Titulo:");
		pnl_consulta.add(lbl_titulo_pesquisa).setBounds(20, 11, 81, 14);
		JTextField txf_titulo_pesquisa = new JTextField(10);
		pnl_consulta.add(txf_titulo_pesquisa).setBounds(20, 29, 161, 20);
		
		JLabel lbl_genero_pesquisa = new JLabel("Genero:");
		pnl_consulta.add(lbl_genero_pesquisa).setBounds(200, 11, 98, 14);
		JTextField txf_genero_pesquisa = new JTextField(10);
		pnl_consulta.add(txf_genero_pesquisa).setBounds(200, 28, 98, 22);

		JLabel lbl_lancamento_pesquisa = new JLabel("Lan�amento:");
		pnl_consulta.add(lbl_lancamento_pesquisa).setBounds(320, 11, 75, 14);
		JTextField txf_lancamento_pesquisa = new JTextField(10);
		pnl_consulta.add(txf_lancamento_pesquisa).setBounds(320, 29, 75, 20);

		
		// Criar Tabela de Dados
		DefaultTableModel tbl_modelo = new DefaultTableModel();
		JTable tbl_filmes = new JTable(tbl_modelo);
		JScrollPane scp_filmes = new JScrollPane(tbl_filmes);
		pnl_consulta.add(scp_filmes).setBounds(20, 60, 500, 100);
		
		// Preencher Tabela de Dados
		tbl_modelo.addColumn("T�tulo");
		tbl_modelo.addColumn("G�nero");
		tbl_modelo.addColumn("Dura��o");
		tbl_modelo.addColumn("Lan�amento");
		tbl_filmes.getColumnModel().getColumn(0).setPreferredWidth(180);
		tbl_filmes.getColumnModel().getColumn(1).setPreferredWidth(80);
		tbl_filmes.getColumnModel().getColumn(2).setPreferredWidth(40);
		tbl_filmes.getColumnModel().getColumn(3).setPreferredWidth(80);
		
		tbl_modelo.setNumRows(0);
		for (Filme f : cadFilme) {
			tbl_modelo.addRow(new Object[]{f.getTitulo(), f.getGenero(),
					f.getDuracao(), f.getLancamento()});
		}
		
		
		JButton btn_pesquisar = new JButton("Pesquisar");
		pnl_consulta.add(btn_pesquisar).setBounds(420, 29, 100, 20);
		btn_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbl_modelo.setNumRows(0);
				for (Filme f : cadFilme) {
					tbl_modelo.addRow(new Object[]{f.getTitulo(), f.getGenero(),
							f.getDuracao(), f.getLancamento()});
				}
			}
		});	
		
		
		
		
		
		// Painel Cadastro
		JLabel lbl_titulo = new JLabel("Titulo:");
		pnl_cadastro.add(lbl_titulo).setBounds(20, 11, 81, 14);
		JTextField txf_titulo = new JTextField(10);
		pnl_cadastro.add(txf_titulo).setBounds(20, 29, 161, 20);
		
		
		JLabel lbl_genero = new JLabel("Genero:");
		pnl_cadastro.add(lbl_genero).setBounds(212, 11, 98, 14);
		JComboBox cbx_genero = new JComboBox(cadGenero.toArray());
		pnl_cadastro.add(cbx_genero).setBounds(212, 28, 98, 22);

		
		JLabel lbl_lancamento = new JLabel("Lan�amento:");
		pnl_cadastro.add(lbl_lancamento).setBounds(349, 11, 75, 14);
		JTextField txf_lancamento = new JTextField(10);
		pnl_cadastro.add(txf_lancamento).setBounds(349, 29, 75, 20);

			
		JLabel lbl_copias = new JLabel("C�pias:");
		pnl_cadastro.add(lbl_copias).setBounds(454, 11, 55, 14);
		JTextField txf_copias = new JTextField(10);
		pnl_cadastro.add(txf_copias).setBounds(454, 29, 55, 20);
		
		
		JLabel lbl_duracao = new JLabel("Dura��o:");
		pnl_cadastro.add(lbl_duracao).setBounds(20, 65, 98, 14);
		JTextField txf_duracao = new JTextField(10);
		pnl_cadastro.add(txf_duracao).setBounds(20, 90, 98, 20);
		
		
		JLabel lbl_categoria = new JLabel("Categoria:");
		pnl_cadastro.add(lbl_categoria).setBounds(212, 65, 98, 14);
		JComboBox cbx_ategoria = new JComboBox();
		for(int i = 0; i < cadCategoria.size(); i++) {
			cbx_ategoria.addItem(cadCategoria.get(i).getNome());   }
		pnl_cadastro.add(cbx_ategoria).setBounds(212, 90, 98, 22);

		
		JLabel lbl_imagem = new JLabel("Imagem:");
		pnl_cadastro.add(lbl_imagem).setBounds(349, 65, 75, 14);
		JTextField txf_imagem = new JTextField(10);
		pnl_cadastro.add(txf_imagem).setBounds(349, 90, 150, 20);
		JLabel lbl_mostrar_imagem = new JLabel("");
		pnl_cadastro.add(lbl_mostrar_imagem).setBounds(380, 120, 80, 110);
		//JFileChooser fc_upload = new JFileChooser();		
		JButton btn_upload = new JButton("Upload");
		pnl_cadastro.add(btn_upload).setBounds(410, 65, 75, 18);
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
					txf_imagem.setText(fc_upload.getSelectedFile().getAbsolutePath());  	 // Mostra no campo te texto o caminho 
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
		
	
		JLabel lbl_sinopse = new JLabel("Sinopse:");
		pnl_cadastro.add(lbl_sinopse).setBounds(20, 165, 98, 14);
		//JEditorPane editorPaneSinopse = new JEditorPane();
		//editorPaneSinopse.setBounds(20, 190, 290, 71);
		//pnl_cadastro.add(editorPaneSinopse);
		JTextArea txa_sinopse = new JTextArea(10, 30);
		pnl_cadastro.add(txa_sinopse).setBounds(20, 190, 290, 71);
		JScrollPane scrl_sinopse = new JScrollPane(txa_sinopse);
		pnl_cadastro.add(scrl_sinopse).setBounds(20, 190, 290, 71);

		
		
		JButton btn_cancelar = new JButton("Cancelar");
		pnl_cadastro.add(btn_cancelar).setBounds(335, 238, 85, 23);
		btn_cancelar.setAction(cancelar);
		

		JButton btn_salvar = new JButton("Salvar");
		pnl_cadastro.add(btn_salvar).setBounds(434, 238, 75, 23);
		btn_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txf_titulo.getText().contentEquals("")
						|| cbx_genero.getSelectedItem().toString().contentEquals("")
						|| txf_copias.getText().contentEquals("") || txf_lancamento.getText().contentEquals("")) {

					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Cadastro Inv�lido!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Filme filme = new Filme(txf_titulo.getText(), cbx_genero.getSelectedItem().toString(),
							Integer.parseInt(txf_copias.getText()), txf_lancamento.getText());
					filme.setDuracao(txf_duracao.getText());
					filme.setCategoria(cbx_ategoria.getSelectedItem().toString());
					filme.setImagem(lbl_mostrar_imagem.getIcon());
					filme.setSinopse(txa_sinopse.getText());
					cadFilme.add(filme);
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro Efetuado!", JOptionPane.WARNING_MESSAGE);
				}
			imprimirFilmes(cadFilme);
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
	
	
	public static void imprimirFilmes(ArrayList<Filme> cadFilme) {
		System.out.println("Total de Filmes: " + cadFilme.size());
		int i = 1;
		for(Filme filme: cadFilme) { 
			System.out.println("");
			System.out.println("Filme: " + i++);
			System.out.println("");
			System.out.println(filme.getTitulo()); 
			System.out.println(filme.getGenero());
			System.out.println(filme.getCopias());
			System.out.println(filme.getLancamento());
			System.out.println(filme.getDuracao());
			System.out.println(filme.getImagem());
			System.out.println(filme.getCategoria());
			System.out.println(filme.getSinopse()); 
			System.out.println(""); }
	}
	
}
