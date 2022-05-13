package FuncionamientoAplicacionEntrenador;

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

import InformacionPersona.Entrenadores;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AjustesEntrenadorCambioCorreo {

	private JFrame frame;
	private JTextField textoCorreo;
	private JTextField textoConfirmacion;

	public AjustesEntrenadorCambioCorreo(Entrenadores informacionEntrenador) {
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
		JLabel labelCambiarCorreo = new JLabel("<html>CAMBIAR CORREO ELECTRÓNICO<html>");
		labelCambiarCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		labelCambiarCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCambiarCorreo.setBounds(81, 40, 270, 25);
		panel.add(labelCambiarCorreo);

		// JLabel introducir nombre y confirmacion
		JLabel labelIntroducirCorreo = new JLabel("<html>Introduce un nuevo correo:<html>");
		labelIntroducirCorreo.setBounds(45, 96, 170, 13);
		panel.add(labelIntroducirCorreo);

		JLabel labelConfirmarCorreo = new JLabel("<html>Confirme su correo:<html>");
		labelConfirmarCorreo.setBounds(45, 142, 154, 13);
		panel.add(labelConfirmarCorreo);

		// Boton atras
		JButton botonAtras = new JButton("<html>Atrás<html>");
		botonAtras.setBounds(10, 232, 85, 21);
		panel.add(botonAtras);

		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, "Sí");
				if (resp == 0) {
					new AjustesEntrenador(informacionEntrenador);		
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
				if (textoCorreo.getText().equals("") || textoConfirmacion.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
				} 
				else if ((!(textoCorreo.getText().contains("@gmail.com")) &&  !(textoCorreo.getText().contains("@outlook.es")) && !(textoCorreo.getText().contains("@yahoo.com")) && !(textoCorreo.getText().contains("@hotmail.com")))) {
					JOptionPane.showMessageDialog(null, "Debes poner un correo existente, con Outlook, Gmail, Hotmail o Yahoo",null,JOptionPane.ERROR_MESSAGE);
				}

				else {
					if (textoCorreo.getText().equals(textoConfirmacion.getText())) {
						System.out.println("Correo entrenador antes de cambiarlo: " + informacionEntrenador.getEmail());
						informacionEntrenador.setEmail(textoCorreo.getText());
						System.out.println("Correo entrenador despues de cambiarlo: " + informacionEntrenador.getEmail());
						Entrenadores.guardarUsuariosEntrenadoresEnBaseDatos();
						new AjustesEntrenador(informacionEntrenador);
						frame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Los correos no coinciden", null, JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		// TextField cambiar de nombre y confirmacion
		textoCorreo = new JTextField();
		textoCorreo.setBounds(225, 92, 183, 21);
		panel.add(textoCorreo);
		textoCorreo.setColumns(10);

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
