package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import classes.Categoria;
import classes.Filme;

@SuppressWarnings("serial")
public class FilmeCadastro extends JInternalFrame {

	static final int xPosition = 30, yPosition = 30;
	private final Action salvar = new SwingAction_salvar();
	private final Action cancelar = new SwingAction_cancelar();
	private final Action upload = new SwingAction_upload();
	

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
		
		
		
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(20, 11, 81, 14);
		pnl_cadastro.add(lblTitulo);

		JTextField textTitulo = new JTextField();
		textTitulo.setBounds(20, 29, 161, 20);
		pnl_cadastro.add(textTitulo);
		textTitulo.setColumns(10);

		
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(212, 11, 98, 14);
		pnl_cadastro.add(lblGenero);

		JComboBox comboBoxGenero = new JComboBox(cadGenero.toArray());
		comboBoxGenero.setBounds(212, 28, 98, 22);
		// comboBoxGenero.add(generos)
		pnl_cadastro.add(comboBoxGenero);

		
		
		JLabel lblLancamento = new JLabel("Lan�amento:");
		lblLancamento.setBounds(349, 11, 75, 14);
		pnl_cadastro.add(lblLancamento);

		JTextField textLancamento = new JTextField();
		textLancamento.setBounds(349, 29, 75, 20);
		pnl_cadastro.add(textLancamento);
		textLancamento.setColumns(10);

		
		
		JLabel lblCopias = new JLabel("C�pias:");
		lblCopias.setBounds(454, 11, 55, 14);
		pnl_cadastro.add(lblCopias);

		JTextField textCopias = new JTextField();
		textCopias.setBounds(454, 29, 55, 20);
		pnl_cadastro.add(textCopias);
		textCopias.setColumns(10);

		
		
		JLabel lblDuracao = new JLabel("Dura��o:");
		lblDuracao.setBounds(20, 77, 98, 14);
		pnl_cadastro.add(lblDuracao);

		JTextField textDuracao = new JTextField();
		textDuracao.setBounds(20, 102, 98, 20);
		pnl_cadastro.add(textDuracao);
		textDuracao.setColumns(10);

		
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(212, 77, 98, 14);
		pnl_cadastro.add(lblCategoria);

		JComboBox comboBoxCategoria = new JComboBox();
		for(int i = 0; i < cadCategoria.size(); i++) {
			comboBoxCategoria.addItem(cadCategoria.get(i).getNome());
			}
		comboBoxCategoria.setBounds(212, 101, 98, 22);
		pnl_cadastro.add(comboBoxCategoria);

		
		
		JLabel lbl_imagem = new JLabel("Imagem:");
		pnl_cadastro.add(lbl_imagem).setBounds(349, 77, 75, 14);
		
		JLabel lbl_mostrar_imagem = new JLabel("");
		pnl_cadastro.add(lbl_mostrar_imagem).setBounds(380, 105, 85, 120);
		
		
		
		JFileChooser fc_upload = new JFileChooser();		
		
		JButton btn_upload = new JButton("Upload");
		//btn_upload.setAction(upload);
		pnl_cadastro.add(btn_upload).setBounds(410, 70, 75, 18);
		btn_upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//JFileChooser fc_upload = new JFileChooser();
				fc_upload.setDialogTitle("Procurar aquivo");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				fc_upload.setFileFilter(filter);
				fc_upload.showOpenDialog(getParent());
				
				// Import ImageIcon     			
				if(fc_upload.getSelectedFile() != null) {
					ImageIcon iconLogo = new ImageIcon(fc_upload.getSelectedFile().getAbsolutePath());
					lbl_mostrar_imagem.setIcon(iconLogo); 
				}
				
			}		
		});

		//ImageIcon iconLogo = new ImageIcon(fc_upload.getSelectedFile().getAbsolutePath());
		//lblImagem.setIcon(iconLogo);     
		

		
		
		
		
		JLabel lblSinopse = new JLabel("Sinopse:");
		lblSinopse.setBounds(20, 165, 98, 14);
		pnl_cadastro.add(lblSinopse);

		//JEditorPane editorPaneSinopse = new JEditorPane();
		//editorPaneSinopse.setBounds(20, 190, 290, 71);
		//pnl_cadastro.add(editorPaneSinopse);
		
		JTextArea txa_sinopse = new JTextArea(10, 30);
		pnl_cadastro.add(txa_sinopse).setBounds(20, 190, 290, 71);
		JScrollPane scrl_sinopse = new JScrollPane(txa_sinopse);
		pnl_cadastro.add(scrl_sinopse).setBounds(20, 190, 290, 71);

		
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setAction(cancelar);
		btn_cancelar.setBounds(335, 238, 85, 23);
		pnl_cadastro.add(btn_cancelar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textTitulo.getText().contentEquals("")
						|| comboBoxGenero.getSelectedItem().toString().contentEquals("")
						|| textCopias.getText().contentEquals("") || textLancamento.getText().contentEquals("")) {

					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Cadastro Inv�lido!",
							JOptionPane.WARNING_MESSAGE);
				} else {

					Filme filme = new Filme(textTitulo.getText(), comboBoxGenero.getSelectedItem().toString(),
							Integer.parseInt(textCopias.getText()), textLancamento.getText());
					filme.setDuracao(textDuracao.getText());
					filme.setCategoria(comboBoxCategoria.getSelectedItem().toString());
					// filme.setImagem( pegar imagem );
					filme.setSinopse(txa_sinopse.getText());
					cadFilme.add(filme);

					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro Efetuado!",
							JOptionPane.WARNING_MESSAGE);
					System.out.println(cadFilme.size());
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
		btnSalvar.setAction(salvar);
		btnSalvar.setBounds(434, 238, 75, 23);
		pnl_cadastro.add(btnSalvar);
	}

	
	private class SwingAction_salvar extends AbstractAction {
		public SwingAction_salvar() {
			putValue(NAME, "Salvar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			
		}
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
	
	
	private class SwingAction_upload extends AbstractAction {
		public SwingAction_upload() {
			putValue(NAME, "Upload");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser fc_upload = new JFileChooser();
			fc_upload.setDialogTitle("Procurar aquivo");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			fc_upload.setFileFilter(filter);
			fc_upload.showOpenDialog(getParent());
			//String arquivo = fc_upload.getSelectedFile().getAbsolutePath();
			//File file = new File(fc_upload.getSelectedFile().getAbsoluteFile());
			
			// Verifica se � um arquivo v�lido e retorna uma mensagem
			/* 
		    int returnVal = fc_upload.showOpenDialog(getParent());
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to open this file: " +
		    		   fc_upload.getSelectedFile().getName());  
		    } */
		}
	}
	
}
