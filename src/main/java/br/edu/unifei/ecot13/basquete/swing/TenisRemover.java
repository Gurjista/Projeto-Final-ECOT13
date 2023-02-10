package br.edu.unifei.ecot13.basquete.swing;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.basquete.Tenis;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TenisRemover extends JFrame {

	private JPanel contentPane;
	
	private Tenis tenis;
	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("basquetePU");
	private EntityManager em = emf.createEntityManager();
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtTamanho;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TenisRemover frame = new TenisRemover();
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
	public TenisRemover() {
		setTitle("Remover Tênis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(22, 25, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(22, 68, 46, 14);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(22, 115, 46, 14);
		contentPane.add(lblModelo);
		
		JLabel lblTamanho = new JLabel("Tamanho: ");
		lblTamanho.setBounds(22, 158, 57, 14);
		contentPane.add(lblTamanho);
		
		JSpinner spnCodigo = new JSpinner();
		spnCodigo.setBounds(113, 22, 65, 20);
		contentPane.add(spnCodigo);
		
		txtMarca = new JTextField();
		txtMarca.setEnabled(false);
		txtMarca.setBounds(113, 65, 86, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setEnabled(false);
		txtModelo.setBounds(113, 112, 86, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtTamanho = new JTextField();
		txtTamanho.setEnabled(false);
		txtTamanho.setBounds(113, 155, 86, 20);
		contentPane.add(txtTamanho);
		txtTamanho.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tenis.setMarca(txtMarca.getText());
				tenis.setModelo(txtModelo.getText());
				tenis.setTamanho(Float.parseFloat(txtTamanho.getText()));				
				spnCodigo.setEnabled(true);
				em.getTransaction().begin();
				em.remove(tenis);
				em.getTransaction().commit();
				txtMarca.setText("");
				txtModelo.setText("");
				txtTamanho.setText("");
				btnExcluir.setEnabled(false);
			}
		});
		
		btnExcluir.setBounds(244, 111, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tenis=em.find(Tenis.class, 
						(Integer)spnCodigo.getValue());
				if(tenis!=null) {
					spnCodigo.setEnabled(false);
					txtMarca.setText(tenis.getMarca());
					txtModelo.setText(tenis.getModelo());
					txtTamanho.setText(tenis.getTamanho()+"");
					
					btnExcluir.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Tênis não existe");
				}
			}
		});
		btnBuscar.setBounds(244, 21, 89, 23);
		contentPane.add(btnBuscar);
		
		
	}

}
