package telas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import classes.Categoria;
import classes.Cliente;
import classes.Filme;
import classes.Genero;


class Main {
	JMenu menuCadastros, submenuCadastros, menuLocacao;
	JMenuItem i1, i2, i3, i4, i5, i6, i7;
	ArrayList<Genero> generos;
	ArrayList<Categoria> categorias;
	ArrayList<Filme> filmes;
	ArrayList<Cliente> clientes;
	
	//ArrayList<String> cadGenero = new ArrayList<>(Arrays.asList (new String[]{"", "A��o", "Aventura", "Com�dia", "Drama", "Romance", "Suspense", "Terror", "Musical"}));
	
	
	Main() {
		
		//generos = new ArrayList<>(Arrays.asList (new String[]{"", "A��o", "Aventura", "Com�dia", "Drama", "Romance", "Suspense", "Terror", "Musical", "Retr�", "Infantil"}));
		generos = new ArrayList<Genero>();
		generos.add(new Genero(""));
		generos.add(new Genero("A��o"));
		generos.add(new Genero("Aventura"));
		generos.add(new Genero("Com�dia"));
		generos.add(new Genero("Drama"));
		generos.add(new Genero("Romance"));
		generos.add(new Genero("Suspense"));
		generos.add(new Genero("Terror"));
		generos.add(new Genero("Musical"));
		generos.add(new Genero("Retr�"));
		generos.add(new Genero("Infantil"));
		
		//categorias = new ArrayList<String>(Arrays.asList (new String[]{"", "Lan�amento", "Padr�o", "Antigo"}));
		categorias = new ArrayList<Categoria>();
		categorias.add(new Categoria("", ""));
		categorias.add(new Categoria("Lan�amento", "10,00"));
		categorias.add(new Categoria("Atual", "7,50"));
		categorias.add(new Categoria("Intermedi�rio", "5,00"));
		categorias.add(new Categoria("Antigo", "2,50"));
		
		
		filmes = new ArrayList<Filme>();
		clientes = new ArrayList<Cliente>();
		
		JFrame f = new JFrame("Locadora");
		JMenuBar mb = new JMenuBar();
		menuCadastros = new JMenu("Cadastros");
		menuCadastros.setMnemonic('C');
		menuLocacao = new JMenu("Loca��o");
		menuLocacao.setMnemonic('L');
		submenuCadastros = new JMenu("Sub Menu");
		
		
		i1 = new JMenuItem("G�nero");
		JDesktopPane jdpGenero = new JDesktopPane();
		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeneroCadastro generoFrame = new GeneroCadastro(generos);
				generoFrame.setVisible(true);
				jdpGenero.add(generoFrame);
				f.setContentPane(jdpGenero);
			}
		});

		
		i2 = new JMenuItem("Categoria");
		final JDesktopPane jdpCategoria = new JDesktopPane();
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoriaCadastro categoriaFrame = new CategoriaCadastro(categorias);
				jdpCategoria.add(categoriaFrame);				
				categoriaFrame.setVisible(true);
				f.setContentPane(jdpCategoria);
			}
		});
		
		
		i3 = new JMenuItem("Filme");
		final JDesktopPane jdpFilme = new JDesktopPane();
		i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeCadastro filmeFrame = new FilmeCadastro(filmes, generos, categorias);
				jdpFilme.add(filmeFrame);
				filmeFrame.setVisible(true);
				f.setContentPane(jdpFilme);
			}
		});
		
		
		i4 = new JMenuItem("Cliente");
		final JDesktopPane jdpCliente = new JDesktopPane();
		i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteCadastro clienteFrame = new ClienteCadastro(clientes);
				
				jdpCliente.add(clienteFrame);
				clienteFrame.setVisible(true);
				f.setContentPane(jdpCliente);
			}
		});
		
		
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		
		
		menuCadastros.add(i1);
		menuCadastros.add(i2);
		menuCadastros.add(i3);
		menuCadastros.add(i4);
		menuCadastros.add(submenuCadastros);
		submenuCadastros.add(i5);
		submenuCadastros.add(i6);
		mb.add(menuCadastros);
		
		
		i7 = new JMenuItem("Nova/Consulta");
		final JDesktopPane jdpNova = new JDesktopPane();
		i7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocacaoCadastro novaFrame = new LocacaoCadastro(filmes, generos, categorias, clientes);
				
				jdpNova.add(novaFrame);
				novaFrame.setVisible(true);
				f.setContentPane(jdpNova);
			}
		});
		
		
		menuLocacao.add(i7);
		mb.add(menuLocacao);
		
		
		f.setJMenuBar(mb);
		f.setSize(650, 480);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	
	
	public static void main(String args[]) {
		new Main();
	}
	
}