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
public class Genero extends JInternalFrame {
	static final int xPosition = 140, yPosition = 80;
	
	public Genero(ArrayList<String> cadGenero) {
		super("Cadastro de G�neros", true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable
		setSize(350, 200);
		setLocation(xPosition, yPosition);
		setLayout(null);
		
		
		// Criar Abas
		JTabbedPane abas = new JTabbedPane(JTabbedPane.TOP);
		abas.setBounds(10, 11, 320, 139);
		//tabbedPane.setSize(300, 300);
		add(abas);
		
		
		// Pain�is das Abas
		JPanel painel1 = new JPanel();
		painel1.setLayout(null);
		//panel1.setSize(300, 300);
		//add("Panel #1", panel1);
		abas.addTab("Pesquisa", null, painel1, null);
		//tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		JPanel painel2 = new JPanel();
		//panel2.setSize(200, 200);
		//add("Panel #2", panel2);
		abas.addTab("Cadastro", painel2);
		//tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		
		
		// Aba Consulta
		painel1.add(new JLabel("G�nero:")).setBounds(70, 18, 98, 14);
		JComboBox comboBoxGenero = new JComboBox(cadGenero.toArray());
		comboBoxGenero.setBounds(120, 14, 98, 22);
		painel1.add(comboBoxGenero);
		comboBoxGenero.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel lab_inf= new JLabel("Edi��o:");
		painel1.add(lab_inf).setBounds(119, 49, 98, 14);
		JTextField generoEditado = new JTextField(10);
		generoEditado.setBounds(149, 49, 75, 20);
		painel1.add(generoEditado);
		generoEditado.setVisible(false);
		
		
		
		JButton btn_novo = new JButton("Novo");
		btn_novo.setBounds(210, 75, 80, 25);
		painel1.add(btn_novo);
		btn_novo.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abas.setSelectedIndex(1);
			}
		});
		
		JButton btn_editar = new JButton("Editar");
		btn_editar.setBounds(115, 75, 80, 25);
		painel1.add(btn_editar);
		btn_editar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxGenero.getSelectedItem().toString().contentEquals("") ) {
					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Edi��o Inv�lida!", JOptionPane.WARNING_MESSAGE);
				} else {
					generoEditado.setVisible(true);
					JOptionPane.showMessageDialog(null, "Informe o G�nero Editado!", "Edi��o Inv�lida!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
		
		
		JButton btn_excluir = new JButton("Excluir");
		btn_excluir.setBounds(20, 75, 80, 25);
		painel1.add(btn_excluir);
		btn_excluir.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				if(comboBoxGenero.getSelectedItem().toString().contentEquals("") ) {
					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Exclus�o Inv�lida!", JOptionPane.WARNING_MESSAGE);
				} else {
					cadGenero.remove(comboBoxGenero.getSelectedItem());
					comboBoxGenero.removeItemAt(comboBoxGenero.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Exclus�ao efetuada com sucesso!", "Exclus�ao Efetuado!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
		// Tabela
		/*JTable tabela = new JTable();
		DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Generos"}, 0);
		tabela.setModel(modelo);
		for(String s: cadGenero) {
			modelo.addRow(new Object[] {s.toString()});
		}
		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);;
		//table.addColumn(teste);
		panel1.add(tabela);*/
		
		
		
		// Aba Cadastro
		JLabel label = new JLabel("Novo G�nero:");
		painel2.add(label);
		JTextField texto = new JTextField(10);
		painel2.add(texto);
		JButton botao = new JButton("Cadastrar");
		painel2.add(botao);
		
		
		botao.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				if(texto.getText().contentEquals("") ) {
					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Cadastro Inv�lido!", JOptionPane.WARNING_MESSAGE);
				} else {
					cadGenero.add(texto.getText());
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro Efetuado!", JOptionPane.WARNING_MESSAGE);
					dispose();
				}
			}
		});
		
		
	}
	
	//private void tabPanelStateChanged(javax.swing.event.ChangeEvent evt) { if (tabbedPane.getSelectedIndex() == 1){ recuperaCfop(); } }
	
}