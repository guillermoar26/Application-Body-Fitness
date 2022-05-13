package Login;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import InformacionPersona.Usuario;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RestablecerContrasena {

	private JFrame frame;
	private JPanel panel;
	private BufferedImage imagenFondo;

	private JLabel etiquetaNuevaContrasena;
	private JLabel etiquetaFondo;
	private JPasswordField textoNuevaContrasena;
	private JLabel etiquetaRestablecerContrasena;
	private JLabel etiquetaconfirmaLaNuevaContrasena;
	private JButton botonRestablecerContrasena;
	private JPasswordField textoConfirmarNuevaContrasena;


	public RestablecerContrasena (String usuario) {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		panel = new JPanel();
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
		etiquetaLogo.setBounds(352, 10, 70, 65);
		panel.add(etiquetaLogo);
		
		etiquetaNuevaContrasena = new JLabel("<html>Introduce la nueva contrase\u00F1a<html>");
		etiquetaNuevaContrasena.setBounds(55, 74, 357, 44);
		panel.add(etiquetaNuevaContrasena);

		textoNuevaContrasena = new JPasswordField ();
		textoNuevaContrasena.setColumns(10);
		textoNuevaContrasena.setBounds(55, 114, 327, 35);
		panel.add(textoNuevaContrasena);

		botonRestablecerContrasena = new JButton("Restablecer contrase\u00F1a");
		//ActionListener  loginButtonListener = new RegistroUsuarioNuevo();
		//botonRegistrarte.addActionListener(loginButtonListener);
		botonRestablecerContrasena.setBounds(80, 229, 238, 23);
		panel.add(botonRestablecerContrasena);

		etiquetaRestablecerContrasena = new JLabel("Restablece tu contrase\u00F1a");
		etiquetaRestablecerContrasena.setBounds(55, 34, 208, 14);
		panel.add(etiquetaRestablecerContrasena);

		textoConfirmarNuevaContrasena = new JPasswordField();
		textoConfirmarNuevaContrasena.setColumns(10);
		textoConfirmarNuevaContrasena.setBounds(55, 178, 327, 35);
		panel.add(textoConfirmarNuevaContrasena);

		etiquetaconfirmaLaNuevaContrasena = new JLabel("<html>Confirma la nueva contrase\u00F1a<html>");
		etiquetaconfirmaLaNuevaContrasena.setBounds(55, 149, 357, 35);
		panel.add(etiquetaconfirmaLaNuevaContrasena);

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

		botonRestablecerContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new String(textoNuevaContrasena.getPassword()).equals(new String(textoConfirmarNuevaContrasena.getPassword()))) {
					System.out.println("AMBAS CONTRASEÑAS IGUALES");

					Usuario.cambiarContrasenaUsuario(usuario, new String(textoNuevaContrasena.getPassword()));
					Usuario.guardarUsuariosEnBaseDatos();

					new PanelUsuarioContrasena ();
					frame.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		frame.setVisible(true);
	}
}