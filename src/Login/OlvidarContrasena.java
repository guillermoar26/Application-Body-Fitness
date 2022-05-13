package Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import InformacionPersona.Usuario;

public class OlvidarContrasena{

	private JFrame frame;

	private JTextField textoEmail;
	
	private BufferedImage imagenFondo;

	private JLabel textoRecuperarCuenta;
	private JLabel etiquetaEmail;
	private JLabel etiquetaFondo;
	private JButton botonBuscar;
	private JButton botonCancelar;
	
	private String [] abecedario = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y", "Z", "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"};

	String codigoAleatorio = "";

	public OlvidarContrasena() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel etiquetaLogo = new JLabel();
		BufferedImage imagenLogo = null;

		try {
			imagenLogo = ImageIO.read(getClass().getResource("/logo.jpg"));
			ImageIcon im = new ImageIcon(imagenLogo.getScaledInstance(70, 65, Image.SCALE_SMOOTH));
			etiquetaLogo.setIcon(im);
		} catch(Exception e) {
		}	
		etiquetaLogo.setBounds(302, 28, 70, 65);
		panel.add(etiquetaLogo);
		
		textoRecuperarCuenta = new JLabel("<html>Recupera la cuenta<html>");
		textoRecuperarCuenta.setBounds(46, 58, 138, 35);
		panel.add(textoRecuperarCuenta);

		etiquetaEmail = new JLabel("<html>Introduce tu correo electr\u00F3nico para buscar tu cuenta.<html>");
		etiquetaEmail.setBounds(46, 104, 313, 35);
		panel.add(etiquetaEmail);

		textoEmail = new JTextField();
		textoEmail.setColumns(10);
		textoEmail.setBounds(46, 147, 293, 31);
		panel.add(textoEmail);

		botonBuscar = new JButton("<html>Buscar<html>");
		//botonRegistrarse.addActionListener(this);
		botonBuscar.setBackground(Color.LIGHT_GRAY);
		botonBuscar.setForeground(Color.BLACK);
		botonBuscar.setBounds(229, 188, 110, 35);
		panel.add(botonBuscar);

		botonCancelar = new JButton("<html>Cancelar<html>");
		botonCancelar.setForeground(Color.BLACK);
		botonCancelar.setBackground(Color.LIGHT_GRAY);
		botonCancelar.setBounds(109, 189, 110, 35);
		panel.add(botonCancelar);

		// Imagen Fondo
		etiquetaFondo = new JLabel();
		imagenFondo = null;

		try {
			imagenFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
			ImageIcon im = new ImageIcon(imagenFondo.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFondo.setIcon(im);
		} catch(Exception e) {
		}
		etiquetaFondo.setBounds(0, 0, 436, 496);
		panel.add(etiquetaFondo);

		// Añadir escucha para el botón de registro
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if (Usuario.existeCorreoConUsuario(textoEmail.getText())) { // Dice si existe el correo de un usuario
					codigoAleatorio = "";
					
					for(int veces = 0; veces < 6; veces++) {
						int getRandomNumero = (int) (Math.random()*(abecedario.length)) + 0;

						codigoAleatorio = codigoAleatorio + abecedario[getRandomNumero];
						System.out.println(codigoAleatorio + "\n\n");

					}

					Usuario a = Usuario.recuperarUsuarioConEmail(textoEmail.getText());


					new IntroducirCodigoEmail (codigoAleatorio, textoEmail.getText(), a.getUsuario());
					frame.setVisible(false);
				}

				else {
					JOptionPane.showMessageDialog(null, "Email no encontrado, introduce otro", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new PanelUsuarioContrasena();
				frame.setVisible(false);

			}
		});

		frame.setVisible(true);
	}
}
