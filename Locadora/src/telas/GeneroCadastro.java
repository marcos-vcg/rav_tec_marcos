package telas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import classes.Filme;
import classes.Genero;

@SuppressWarnings("serial")
public class GeneroCadastro extends JInternalFrame {
	static final int xPosition = 140, yPosition = 90;
	static boolean edit = false;
	
	public GeneroCadastro(ArrayList<Genero> cadGenero) {
		super("Cadastro de G�neros", true, // resizable
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
		abas.addTab("Pesquisa", null, pnl_consulta, "Pesquisar G�neros");
		
		JPanel pnl_cadastro = new JPanel();
		//panel2.setSize(200, 200);
		//add("Panel #2", panel2);
		abas.addTab("Cadastro", null, pnl_cadastro, "Cadastrar G�neros");
		//tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		
		
		// Aba Consulta
		pnl_consulta.add(new JLabel("Consulta:")).setBounds(20, 18, 98, 14);
		
		JTextField txf_genero_pesquisa = new JTextField(10);
		pnl_consulta.add(txf_genero_pesquisa).setBounds(90, 16, 98, 22);
		
		
		// Criar Tabela de Dados
		DefaultTableModel tbl_modelo = new DefaultTableModel();
		JTable tbl_generos = new JTable(tbl_modelo);
		JScrollPane scp_generos = new JScrollPane(tbl_generos);
		pnl_consulta.add(scp_generos).setBounds(40, 90, 120, 100);		
		
		// Preencher Tabela de Dados
		tbl_modelo.addColumn("G�nero");
		tbl_generos.getColumnModel().getColumn(0).setPreferredWidth(100);	

		tbl_modelo.setNumRows(0);
		cadGenero.sort(Comparator.comparing(Genero::getNome));
		for (Genero genero : cadGenero) {tbl_modelo.addRow(new Object[]{genero.getNome()});}
		
		
		JButton btn_pesquisar = new JButton("Pesquisar");
		pnl_consulta.add(btn_pesquisar).setBounds(200, 16, 100, 20);
		btn_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbl_modelo.setNumRows(0);
				if(txf_genero_pesquisa.getText().contentEquals("")) {
					for (Genero genero : cadGenero) {
						tbl_modelo.addRow(new Object[]{genero.getNome()});
					}
				} else {
					cadGenero.sort(Comparator.comparing(Genero::getNome));
					for (Genero genero : cadGenero) {
						if(genero.getNome().toLowerCase().contains(txf_genero_pesquisa.getText().toLowerCase())) {
							tbl_modelo.addRow(new Object[]{genero.getNome()});	} 
					}
				}	
			}
		});	
	
		
		// Bot�es de A��o
		JButton btn_editar = new JButton("Editar");
		btn_editar.setEnabled(false);
		pnl_consulta.add(btn_editar).setBounds(210, 90, 80, 25);		
		
		JButton btn_excluir = new JButton("Excluir");
		btn_excluir.setEnabled(false);
		pnl_consulta.add(btn_excluir).setBounds(210, 130, 80, 25);
		
		
		JButton btn_novo = new JButton("Novo");
		btn_novo.setVisible(true);
		pnl_consulta.add(btn_novo).setBounds(210, 170, 80, 25);		
		
		
		
		// Percebe A��o de Clicar na tabela
		tbl_generos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "A��o Cancelada!", JOptionPane.WARNING_MESSAGE);
					abas.setSelectedIndex(0);
					btn_cadastro.setText("Cadastrar");
					edit = false;
				} else if (edit) {
					String palavra = txf_novo_genero.getText();
					palavra = palavra.substring(0,1).toUpperCase().concat(palavra.substring(1));
					cadGenero.get(tbl_generos.getSelectedRow()).setNome(palavra);
					txf_novo_genero.setText("");
					JOptionPane.showMessageDialog(null, "Edi��o efetuada com sucesso!", "Edi��o Efetuada!", JOptionPane.WARNING_MESSAGE);
					abas.setSelectedIndex(0);
					btn_cadastro.setText("Cadastrar");
					edit = false;
				} else {
					String palavra = txf_novo_genero.getText();
					palavra = palavra.substring(0,1).toUpperCase().concat(palavra.substring(1));
					cadGenero.add(new Genero(palavra));
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro Efetuado!", JOptionPane.WARNING_MESSAGE);
					txf_novo_genero.setText("");
				}
				tbl_modelo.setNumRows(0);
				cadGenero.sort(Comparator.comparing(Genero::getNome));
				for (Genero genero : cadGenero) {tbl_modelo.addRow(new Object[]{genero.getNome()});}
			}
		});	
		
		
		btn_editar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(null, "Informe o novo nome!", "Modo Edi��o!", JOptionPane.WARNING_MESSAGE);
					txf_novo_genero.setText(tbl_generos.getValueAt(tbl_generos.getSelectedRow(), tbl_generos.getSelectedColumn()).toString());
					tbl_generos.getValueAt(tbl_generos.getSelectedRow(), tbl_generos.getSelectedColumn());
					abas.setSelectedIndex(1);
					btn_cadastro.setText("Editar");
					edit = true;
			}	
		});
		
		btn_excluir.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				//if(!tbl_generos.isRowSelected(tbl_generos.getSelectedRow())/*cbx_genero.getSelectedItem().toString().contentEquals("")*/ ) {					JOptionPane.showMessageDialog(null, "Campos Obrigat�rios Vazios!", "Exclus�o Inv�lida!", JOptionPane.WARNING_MESSAGE);
				cadGenero.remove(tbl_generos.getSelectedRow());
				JOptionPane.showMessageDialog(null, "Exclus�o efetuada com sucesso!", "Exclus�ao Efetuado!", JOptionPane.WARNING_MESSAGE);
				tbl_modelo.setNumRows(0);
				for (Genero genero : cadGenero) {tbl_modelo.addRow(new Object[]{genero.getNome()});}
				
				txf_novo_genero.setText("");
				btn_cadastro.setText("Cadastrar");
				edit = false;
				
			}
		});		     //tbl_modelo.getValueAt(tbl_generos.getSelectedRow(), 0);
		
		btn_novo.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_novo_genero.setText("");
				abas.setSelectedIndex(1);
				btn_cadastro.setText("Cadastrar");
				edit = false;
			}
		});
		
			
	}
	
}