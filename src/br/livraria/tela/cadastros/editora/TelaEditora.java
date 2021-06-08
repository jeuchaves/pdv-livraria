package br.livraria.tela.cadastros.editora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.livraria.aplicacao.cadastros.EditoraApp;
import br.livraria.model.Editora;
import br.livraria.model.Funcionario;

public class TelaEditora {

	Funcionario funcionario;
	
	private JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the application.
	 * @param funcionario 
	 */
	public TelaEditora(Funcionario funcionario) {
		
		this.funcionario = funcionario;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Gerenciar Editoras");
		frame.setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("Novo");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new TelaEditoraNovo(funcionario);
				
				frame.dispose();
				
				
			}
		});
		btnNewButton.setBounds(10, 22, 99, 35);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(237, 26, 126, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Pesquisar");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String busca = textField.getText();
				
				Vector<Editora> editoras = new EditoraApp().pesquisar(busca);
				
				table.setModel(new DefaultTableModel(
						new EditoraApp().getEditoras(editoras),
						new String[] {
							"ID", "Nome", "CNPJ", "Endereco"
						}
					));
				
			}
		});
		btnNewButton_1.setBounds(374, 22, 105, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 469, 299);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new EditoraApp().getEditoras(),
			new String[] {
				"ID", "Nome", "CNPJ", "Endereco"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Editar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TelaEditoraUpdate(funcionario);
				
				frame.dispose();
				
			}
		});
		btnNewButton_2.setBounds(10, 70, 99, 35);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Deletar");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new TelaEditoraDelete(funcionario);
				
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(10, 116, 99, 35);
		frame.getContentPane().add(btnNewButton_3);
		
		frame.setVisible(true);
	}
}