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

public class AjustesCambioNombre {

	private JFrame frame;
	private JTextField textoNombre;
	private JTextField textoConfirmacion;

	public AjustesCambioNombre(Usuario informacionUsuario) {
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
		JLabel labelCambiarNombre = new JLabel("<html>CAMBIAR NOMBRE<html>");
		labelCambiarNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelCambiarNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCambiarNombre.setBounds(122, 39, 183, 25);
		panel.add(labelCambiarNombre);

		// JLabel introducir nombre y confirmacion
		JLabel labelIntroducirNombre = new JLabel("<html>Introduce un nuevo nombre:<html>");
		labelIntroducirNombre.setBounds(45, 96, 170, 13);
		panel.add(labelIntroducirNombre);

		JLabel labelConfirmarNombre = new JLabel("<html>Confirme su nombre:<html>");
		labelConfirmarNombre.setBounds(45, 142, 154, 13);
		panel.add(labelConfirmarNombre);

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
				if (textoNombre.getText().equals("") || textoConfirmacion.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
				} else {
					if (textoNombre.getText().equals(textoConfirmacion.getText())) {
						System.out.println("Nombre usuario antes de cambiarlo: " + informacionUsuario.getNombre());
						informacionUsuario.setNombre(textoNombre.getText()); // Funcion de Usuario que te cambie en la base de datos
						System.out.println("Nombre usuario despues de cambiarlo: " + informacionUsuario.getNombre());
						Usuario.guardarUsuariosEnBaseDatos(); // Para que se actualize en la base de datos
						new Ajustes(informacionUsuario);
						frame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Los nombres no coinciden", null, JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		// TextField cambiar de nombre y confirmacion
		textoNombre = new JTextField();
		textoNombre.setBounds(225, 92, 183, 21);
		panel.add(textoNombre);
		textoNombre.setColumns(10);

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
		frame.setVisible(true);
	}
}
