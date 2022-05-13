package FuncionamientoAplicacion;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.SwingConstants;

import InformacionPersona.Usuario;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AjustesCambioContrasena {

	private JFrame frame;
	private JTextField textoContrasena;
	private JTextField textoConfirmacion;

	public AjustesCambioContrasena(Usuario informacionUsuario) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
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
		etiquetaLogo.setBounds(338, 17, 70, 65);
		panel.add(etiquetaLogo);

		// JLabel cambiar de nombre
		JLabel labelCambiarContrasena = new JLabel("<html>CAMBIAR CONTRASEÑA<html>");
		labelCambiarContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		labelCambiarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCambiarContrasena.setBounds(122, 39, 183, 25);
		panel.add(labelCambiarContrasena);

		// JLabel introducir nombre y confirmacion
		JLabel labelIntroducirContrasena = new JLabel("<html>Introduce una contraseña:<html>");
		labelIntroducirContrasena.setBounds(45, 96, 170, 13);
		panel.add(labelIntroducirContrasena);

		JLabel labelConfirmarContrasena = new JLabel("<html>Confirme su contraseña:<html>");
		labelConfirmarContrasena.setBounds(45, 142, 154, 13);
		panel.add(labelConfirmarContrasena);

		// Boton atras
		JButton botonAtras = new JButton("<html>Atrás<html>");
		botonAtras.setBounds(10, 232, 85, 21);
		panel.add(botonAtras);

		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, "Sí");
				if (resp == 0) {
					new Ajustes(informacionUsuario);		
					frame.setVisible(false);
				}
			}
		});

		// Boton finalizar
		JButton botonFinalizar = new JButton("<html>Finalizar<html>");
		botonFinalizar.setBounds(341, 232, 85, 21);
		panel.add(botonFinalizar);

		botonFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// comprobar si los dos son iguales
				if (textoContrasena.getText().equals("") || textoConfirmacion.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
				} 
				else {
					if (textoContrasena.getText().equals(textoConfirmacion.getText())) {
						System.out.println("Contraseña usuario antes de cambiarlo: " + informacionUsuario.getContrasena());
						informacionUsuario.setContrasena(textoContrasena.getText()); // Funcion de Usuario que te cambie en la base de datos
						System.out.println("Contraseña usuario despues de cambiarlo: " + informacionUsuario.getContrasena());
						Usuario.guardarUsuariosEnBaseDatos(); // Para que se actualize en la base de datos
						new Ajustes(informacionUsuario);
						frame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", null, JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		// TextField cambiar de nombre y confirmacion
		textoContrasena = new JTextField();
		textoContrasena.setBounds(225, 92, 183, 21);
		panel.add(textoContrasena);
		textoContrasena.setColumns(10);

		textoConfirmacion = new JTextField();
		textoConfirmacion.setColumns(10);
		textoConfirmacion.setBounds(225, 138, 183, 21);
		panel.add(textoConfirmacion);

		// Imagen Fondo
		JLabel etiquetaFondo = new JLabel();
		BufferedImage imagenFondo = null;

		try {
			imagenFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
			ImageIcon im = new ImageIcon(imagenFondo.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFondo.setIcon(im);
		} catch(Exception e) {
		}
		etiquetaFondo.setBounds(0, 0, 436, 496);
		panel.add(etiquetaFondo);
		
		// setear input al usuario

		// Poner si ambos son iguales, setar al usuario
		frame.setVisible(true);
	}
}
