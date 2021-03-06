package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Filme;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;

//import classes.Genero;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldData;
	private JTextField textFieldTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// LISTAS
		ArrayList<String> generos = new ArrayList<String>();
		generos.add("Selecione");
		generos.add("Suspense");
		generos.add("Terror");
		generos.add("A��o");
		generos.add("Com�dia");
//		String[] opcoes = generos.toArray(new String[0]);
		
		Map<String, Double> categorias = new TreeMap<String, Double>();
		categorias.put("lancamento", 9.90);
		categorias.put("Premium", 7.50);
		categorias.put("Antigos", 4.90);
		
		ArrayList<Filme> filmes = new ArrayList<>();
		filmes.add(new Filme());
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	
	
	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		// Data
		JLabel lblData = new JLabel("Data: ");
		lblData.setBounds(24, 22, 97, 14);
		contentPane.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(24, 47, 97, 20);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		
		
		// T�tulo
		JLabel lblTitulo = new JLabel("T�tulo: ");
		lblTitulo.setBounds(153, 22, 97, 14);
		contentPane.add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(153, 47, 97, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		
		
		// Genero
		JLabel lblGenero = new JLabel("G�nero: ");
		lblGenero.setBounds(290, 22, 109, 14);
		contentPane.add(lblGenero);
		
		
		String[] opcoes = {"Selecione", "Suspense", "Terror", "A��o"};
		JComboBox comboBoxGenero = new JComboBox(opcoes);
		comboBoxGenero.addItem("teste");
		
		// Fica escutando o que genero selecionado
		comboBoxGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Repassa a op��o escolhida atrav�s do case
			}
		});
		
		comboBoxGenero.setBounds(290, 46, 109, 22);
		contentPane.add(comboBoxGenero);
		
		
			
		// Bot�es de A��o
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Encaminhar para a tela de Cadastro de Novos Filmes
				JOptionPane.showMessageDialog(null, "Adicinando novo Filme a Lista!", "Pronto", JOptionPane.DEFAULT_OPTION);
			}
		});
		btnAdicionar.setBounds(153, 90, 97, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Atualizar elementos da pesquisa na tabela
				JOptionPane.showMessageDialog(null, "Pesquisando Filme na Lista", "Pronto", JOptionPane.INFORMATION_MESSAGE);
				// Pesquisa pelos campos informados nos:   getFilme.titulo = textFieldTitulo.getText(), textFieldData.getText(), 
				
			}
		});
		btnPesquisar.setBounds(290, 90, 109, 23);
		contentPane.add(btnPesquisar);
		
		
		
	}
}



// JOptionPane.showMessageDialog(null, e);
// JOptionPane.showMessageDialog(null, "A mensagem", "O t�tulo da Aba", JOptionPane.WARNING_MESSAGE);	