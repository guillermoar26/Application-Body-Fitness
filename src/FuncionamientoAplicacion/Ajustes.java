package FuncionamientoAplicacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

import InformacionPersona.Usuario;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class Ajustes {

	private JFrame frame;

	// No tocar
	public Ajustes(Usuario informacionUsuario) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 382, 524);
		frame.setLocationRelativeTo(null);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel etiquetaLogo = new JLabel();
		BufferedImage imagenLogo = null;

		try {
			imagenLogo = ImageIO.read(getClass().getResource("/logo.jpg"));
			ImageIcon im = new ImageIcon(imagenLogo.getScaledInstance(70, 65, Image.SCALE_SMOOTH));
			etiquetaLogo.setIcon(im);
		} 
		
		catch(Exception e) {
			
		}	
		etiquetaLogo.setBounds(298, 10, 70, 65);
		panel.add(etiquetaLogo);
		
		// Label cambiar informacion personal
		JLabel etiquetaCambiarInfoPersonal = new JLabel("<html>CAMBIAR INFORMACIÓN PERSONAL<html>", SwingConstants.CENTER);
		etiquetaCambiarInfoPersonal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		etiquetaCambiarInfoPersonal.setBounds(31, 35, 268, 28);
		panel.add(etiquetaCambiarInfoPersonal);


		// boton atras
		JButton botonAtras = new JButton("<html>Atrás<html>");
		botonAtras.addActionListener(new ActionListener() {
			@ Override
			public void actionPerformed(ActionEvent e) {
				new PantallaPrincipalUsuario(informacionUsuario);
				frame.setVisible(false);
			}
		});
		botonAtras.setBounds(10, 456, 85, 21);
		panel.add(botonAtras);

		// Cambiar nombre del usuario
		JButton botonCambiarNombre = new JButton("<html>NOMBRE<html>");
		botonCambiarNombre.setBounds(77, 89, 203, 37);
		panel.add(botonCambiarNombre);

		
		botonCambiarNombre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesCambioNombre(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// Cambiar apellidos del usuario
		JButton botonCambiarApellidos = new JButton("<html>APELLIDOS<html>");
		botonCambiarApellidos.setBounds(77, 154, 203, 37);
		panel.add(botonCambiarApellidos);

		botonCambiarApellidos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesCambioApellidos(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// Cambiar edad del usuario
		JButton botonCambiarEdad = new JButton("<html>EDAD<html>");
		botonCambiarEdad.setBounds(77, 221, 203, 37);
		panel.add(botonCambiarEdad);

		botonCambiarEdad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesCambioEdad(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// Cambiar correo electronico del usuario
		JButton botonCambiarCorreo = new JButton("<html>CORREO ELECTRÓNICO<html>");
		botonCambiarCorreo.setBounds(77, 289, 203, 37);
		panel.add(botonCambiarCorreo);

		botonCambiarCorreo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesCambioCorreo(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// Cambiar contraseña del usuario
		JButton botonCambiarContrasena = new JButton("<html>CONTRASEÑA<html>");
		botonCambiarContrasena.setBounds(77, 360, 203, 37);
		panel.add(botonCambiarContrasena);

		botonCambiarContrasena.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesCambioContrasena(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// Imagen Fondo
		JLabel etiquetaFondo = new JLabel();
		BufferedImage imagenFondo = null;

		try {
			imagenFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
			ImageIcon im = new ImageIcon(imagenFondo.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFondo.setIcon(im);
		} 
		
		catch(Exception e) {
			
		}
		etiquetaFondo.setBounds(0, 0, 436, 496);
		panel.add(etiquetaFondo);

		frame.setVisible(true);
	}
}
