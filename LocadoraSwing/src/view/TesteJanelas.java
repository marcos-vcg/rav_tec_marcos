package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class TesteJanelas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteJanelas frame = new TesteJanelas();
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
	public TesteJanelas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 239);
		contentPane.add(tabbedPane);
		
		JPanel panel_consulta = new JPanel();
		tabbedPane.addTab("Consulta", null, panel_consulta, null);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		panel_consulta.add(table);
		
		JPanel panel_cadastro = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel_cadastro, null);
	}
}
