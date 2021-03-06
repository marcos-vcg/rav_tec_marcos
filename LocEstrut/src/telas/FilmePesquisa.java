package telas;

import java.awt.FlowLayout;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class FilmePesquisa {

	public static void main(String[] args) throws ParseException {
		
//		Container janela = getContentPane();
//      janela.setLayout(null);
		
		// Janela Principal
		JFrame janela = new JFrame("Filmes (Pesquisa)"); 			// Cria
		janela.setVisible(true); 									// Mostra
		janela.setSize(600, 400); 									// Tamanho
		janela.setLayout(new FlowLayout()); 						// Tudo segue o novo layout
		janela.setLocationRelativeTo(null); 						// Centraliza
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // Sai ao fechar a tela

		JPanel painel = new JPanel( null );
		painel.setVisible(true);

		

		//Define os r�tulos dos bot�es
		JLabel labelData = new JLabel("Data: ");
		JLabel labelTitulo = new JLabel("T�tulo: ");
		JLabel labelGenero = new JLabel("Genero: ");
		labelData.setBounds(50,40,100,20);
		labelTitulo.setBounds(100,40,100,20);
		labelGenero.setBounds(150,40,100,20);
		
		
		//Define as m�scaras
        MaskFormatter mascaraData = null;
        MaskFormatter mascaraTitulo = null;
        MaskFormatter mascaraGenero = null;	
		
        mascaraData = new MaskFormatter("##/##/####");	
        mascaraTitulo = new MaskFormatter("????????????");
        mascaraGenero = new MaskFormatter("????????????");
        mascaraData.setPlaceholderCharacter('_');
        mascaraTitulo.setPlaceholderCharacter('_');
        mascaraGenero.setPlaceholderCharacter('_');
			
		
		//Seta as m�scaras nos objetos JFormattedTextField
        JFormattedTextField jFormattedTextData = new JFormattedTextField(mascaraData);
		JFormattedTextField jFormattedTextTitulo = new JFormattedTextField(mascaraTitulo);
        JFormattedTextField jFormattedTextGenero = new JFormattedTextField(mascaraGenero);
        jFormattedTextData.setBounds(150,40,100,20);
        jFormattedTextTitulo.setBounds(150,80,100,20);
        jFormattedTextGenero.setBounds(150,120,100,20);
 
		
		
		//Adiciona os r�tulos e os campos de textos com m�scaras na tela
        painel.add(labelData);        
        janela.add(labelTitulo);
        janela.add(labelGenero);
        painel.add(jFormattedTextData);
        janela.add(jFormattedTextTitulo);
        janela.add(jFormattedTextGenero);

        
        janela.setSize(400, 250);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
		
		
	
		
	}

}
