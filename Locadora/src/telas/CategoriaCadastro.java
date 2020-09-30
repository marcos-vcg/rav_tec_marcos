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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CategoriaCadastro extends JInternalFrame {
	static final int xPosition = 140, yPosition = 80;

	public CategoriaCadastro(ArrayList<String> cadCategoria) {
		super("Cadastro de Categorias", true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable
		setSize(350, 200);
		setLocation(xPosition, yPosition);
		setLayout(null);
		
		
		// Criar Abas
		JTabbedPane abas = new JTabbedPane(JTabbedPane.TOP);
		abas.setBounds(10, 11, 320, 139);
		add(abas);
		
		
		// Pain�is das Abas
		JPanel pnl_consulta = new JPanel();
		pnl_consulta.setLayout(null);
		abas.addTab("Pesquisa", null, pnl_consulta, null);
		JPanel pnl_cadastro = new JPanel();
		pnl_cadastro.setLayout(null);
		abas.addTab("Cadastro", pnl_cadastro);
		
		
		// Aba Consulta
		pnl_consulta.add(new JLabel("Categoria:")).setBounds(55, 18, 98, 14);
		JComboBox cbx_categoria = new JComboBox(cadCategoria.toArray());
		pnl_consulta.add(cbx_categoria).setBounds(120, 14, 98, 22);
		
		
		
		
		
		
		
		
		
		
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
					//cadCategoria.add(txf_nova_categoria.getText());
					//cadCategoria.add(txf_novo_preco.getText());
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro Efetuado!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
	}
	
}