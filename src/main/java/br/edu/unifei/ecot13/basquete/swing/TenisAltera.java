package br.edu.unifei.ecot13.basquete.swing;

import br.edu.unifei.ecot13.basquete.Tenis;


import java.awt.EventQueue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TenisAltera extends JFrame {

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
					TenisAltera frame = new TenisAltera();
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
	public TenisAltera() {
		setTitle("Alterar Tênis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(22, 25, 56, 14);
		contentPane.add(lblCodigo);
		
		JSpinner spnCodigo = new JSpinner();
		spnCodigo.setBounds(113, 22, 65, 20);
		contentPane.add(spnCodigo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(22, 68, 56, 14);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(22, 115, 56, 14);
		contentPane.add(lblModelo);

		JLabel lblTamanho = new JLabel("Tamanho: ");
		lblTamanho.setBounds(22, 158, 56, 14);
		contentPane.add(lblTamanho);
		


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tenis.setModelo(txtModelo.getText());
				txtModelo.setEnabled(false);
				tenis.setMarca(txtMarca.getText());
				txtMarca.setEnabled(false);
				tenis.setTamanho(Float.parseFloat(txtTamanho.getText()));
				txtTamanho.setEnabled(false);
				btnAlterar.setEnabled(false);
				spnCodigo.setEnabled(true);
				em.getTransaction().begin();
				em.merge(tenis);
				em.getTransaction().commit();
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(244, 111, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tenis=em.find(Tenis.class, 
						(Integer)spnCodigo.getValue());
				if(tenis!=null) {
					spnCodigo.setEnabled(false);
					txtModelo.setEnabled(true);
					txtModelo.setText(tenis.getModelo());
					txtMarca.setEnabled(true);
					txtMarca.setText(tenis.getMarca());
					txtTamanho.setEnabled(true);
					txtTamanho.setText(tenis.getTamanho()+"");
					btnAlterar.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Eleitor não existe");
				}
			}
		});
		btnBuscar.setBounds(244, 21, 89, 23);
		contentPane.add(btnBuscar);
	}

}
