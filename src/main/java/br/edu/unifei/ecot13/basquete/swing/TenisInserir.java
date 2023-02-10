package br.edu.unifei.ecot13.basquete.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.basquete.Tenis;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TenisInserir extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtTamanho;
	private Tenis tenis;
	
	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("basquetePU");
	private EntityManager em = emf.createEntityManager();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TenisInserir frame = new TenisInserir();
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
	public TenisInserir() {
		setTitle("Inserir Tênis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(22, 25, 56, 14);
		contentPane.add(lblCodigo);
		
		JSpinner spnCodigo = new JSpinner();
		spnCodigo.setEnabled(false);
		spnCodigo.setBounds(113, 22, 65, 20);
		contentPane.add(spnCodigo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(22, 68, 56, 14);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(113, 65, 86, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(22, 115, 56, 14);
		contentPane.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(113, 112, 86, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblTamanho = new JLabel("Tamanho: ");
		lblTamanho.setBounds(22, 158, 56, 14);
		contentPane.add(lblTamanho);
		
		txtTamanho = new JTextField();
		txtTamanho.setBounds(113, 155, 86, 20);
		contentPane.add(txtTamanho);
		txtTamanho.setColumns(10);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tenis=new Tenis();
				tenis.setMarca(txtMarca.getText());
				tenis.setModelo(txtModelo.getText());
				tenis.setTamanho(Float.parseFloat(txtTamanho.getText()));
				
				em.getTransaction().begin();
				em.persist(tenis);
				em.getTransaction().commit();
			}
		});
		btnInserir.setBounds(266, 111, 89, 23);
		contentPane.add(btnInserir);
		
	}
}
