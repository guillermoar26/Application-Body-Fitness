package Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import FuncionamientoAplicacion.PantallaPrincipalUsuario;
import FuncionamientoAplicacionEntrenador.PantallaPrincipalEntrenador;
import InformacionPersona.Entrenadores;
import InformacionPersona.Usuario;

import javax.swing.JRadioButton;

public class PanelUsuarioContrasena {

	private JFrame frame;
	private JLabel textoUsuario;
	private JLabel textoContrasena;
	private JTextField usuarioPersonaIntroducido;
	private JPasswordField contrasenaPersonaIntroducido;
	private JButton botonEntrar;
	private JButton botonRegistrarte;
	private boolean usuarioContrasenaCorrectas = false;
	private JButton botonOlvidarContrasena;
	private JLabel etiquetaFondo;
	private BufferedImage imagenFondo;
	private BufferedImage imagenLogo;
	private JLabel etiquetaLogo;
	
	private JRadioButton botonElegirUsuario;
	private JRadioButton botonElegirEntrenador;
	private ButtonGroup grupoSeleccion;


	int lineaActual = 1;



	public PanelUsuarioContrasena () {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		etiquetaLogo = new JLabel();
		imagenLogo = null;

		try {
			imagenLogo = ImageIO.read(getClass().getResource("/logo.jpg"));
			ImageIcon im = new ImageIcon(imagenLogo.getScaledInstance(70, 65, Image.SCALE_SMOOTH));
			etiquetaLogo.setIcon(im);
		} catch(Exception e) {
		}	
		etiquetaLogo.setBounds(352, 10, 70, 65);
		panel.add(etiquetaLogo);

		textoUsuario = new JLabel("<html>Usuario<html>");
		textoUsuario.setBounds(55, 58, 71, 14);
		panel.add(textoUsuario);

		usuarioPersonaIntroducido = new JTextField();
		usuarioPersonaIntroducido.setBounds(155, 56, 124, 20);
		panel.add(usuarioPersonaIntroducido);
		usuarioPersonaIntroducido.setColumns(10);

		textoContrasena = new JLabel("<html>Contrase\u00F1a<html>");
		textoContrasena.setBounds(55, 101, 71, 14);
		panel.add(textoContrasena);

		contrasenaPersonaIntroducido = new JPasswordField ();
		contrasenaPersonaIntroducido.setColumns(10);
		contrasenaPersonaIntroducido.setBounds(155, 99, 124, 20);
		panel.add(contrasenaPersonaIntroducido);

		botonEntrar = new JButton("<html>Entrar<html>");
		botonEntrar.setBounds(55, 171, 89, 23);
		panel.add(botonEntrar);

		botonRegistrarte = new JButton("<html>Registrarse<html>");
		botonRegistrarte.setBounds(163, 171, 120, 23);
		panel.add(botonRegistrarte);

		botonOlvidarContrasena = new JButton("<html>\u00BFOlvidaste tu contrase\u00F1a?<html>");
		botonOlvidarContrasena.setForeground(Color.BLUE);
		botonOlvidarContrasena.setBounds(85, 205, 161, 23);
		botonOlvidarContrasena.setOpaque(false);
		botonOlvidarContrasena.setBorder(null);
		botonOlvidarContrasena.setFocusPainted(false);
		botonOlvidarContrasena.setBorderPainted(false);
		botonOlvidarContrasena.setContentAreaFilled(false);
		botonOlvidarContrasena.setOpaque (true);
		panel.add(botonOlvidarContrasena);

		// Texto seleccion
		JLabel botonSeleccion = new JLabel("Soy:");
		botonSeleccion.setBounds(55, 144, 45, 13);
		panel.add(botonSeleccion);

		// Radio Button para elegir usuario -> ir a pantalla creacion usuario
		botonElegirUsuario = new JRadioButton("Usuario");
		botonElegirUsuario.setOpaque(false);
		botonElegirUsuario.setBounds(273, 140, 103, 21);
		panel.add(botonElegirUsuario);

		// Ir a pantalla creacion entrenador
		botonElegirEntrenador = new JRadioButton("Entrenador");
		botonElegirEntrenador.setOpaque(false);
		botonElegirEntrenador.setBounds(143, 140, 103, 21);
		panel.add(botonElegirEntrenador);

		// Añadir que solo se pueda elegir un radio button
		grupoSeleccion = new ButtonGroup();
		grupoSeleccion.add(botonElegirEntrenador);
		grupoSeleccion.add(botonElegirUsuario);

		// Añadir escucha para el botón de registro
		botonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if (usuarioPersonaIntroducido.getText().equals("") || new String(contrasenaPersonaIntroducido.getPassword()).equals("") || (!(botonElegirEntrenador.isSelected()) && !(botonElegirUsuario.isSelected()))) {
					JOptionPane.showMessageDialog(null, "<html>Introduce los datos<html>", null, JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (botonElegirUsuario.isSelected()) {
						Usuario informacionUsuario = Usuario.recuperarUsuario(usuarioPersonaIntroducido.getText());



						if (informacionUsuario != null) { // El usuario existe
							if (informacionUsuario.getUsuario().equals(usuarioPersonaIntroducido.getText()) && informacionUsuario.getContrasena().equals((new String(contrasenaPersonaIntroducido.getPassword())))) {
								System.out.println("EL USUARIO LO HA INTRODUCIDO BIEN LA INFORMACION");
								usuarioContrasenaCorrectas = true;
							}

							else {
								System.out.println("EL USUARIO LO HA INTRODUCIDO MAL LA INFORMACION");
							}

						}


						if (!(usuarioContrasenaCorrectas)) { // Si es false
							JOptionPane.showMessageDialog(null, "<html>Usuario o contraseña incorrecta<html>", null, JOptionPane.ERROR_MESSAGE);
						}

						else {
							System.out.println("Usuario correcto");
							informacionUsuario.mostrarInformacionUsuario();
							new PantallaPrincipalUsuario(informacionUsuario);
							frame.setVisible(false);
						}


					}

					else if (botonElegirEntrenador.isSelected()) {
						Entrenadores informacionEntrenador = Entrenadores.recuperarUsuarioEntrenador(usuarioPersonaIntroducido.getText());



						if (informacionEntrenador != null) { // El usuario existe
							if (informacionEntrenador.getUsuarioEntrenador().equals(usuarioPersonaIntroducido.getText()) && informacionEntrenador.getContrasena().equals((new String(contrasenaPersonaIntroducido.getPassword())))) {
								System.out.println("EL ENTRENADOR LO HA INTRODUCIDO BIEN LA INFORMACION");
								usuarioContrasenaCorrectas = true;
							}

							else {
								System.out.println("EL ENTRENADOR LO HA INTRODUCIDO MAL LA INFORMACION");
							}

						}


						if (!(usuarioContrasenaCorrectas)) { // Si es false
							JOptionPane.showMessageDialog(null, "<html>Usuario o contraseña incorrecta<html>", null, JOptionPane.ERROR_MESSAGE);
						}
						else {
							System.out.println("Usuario correcto");
							informacionEntrenador.mostrarInformacionEntrenador();
							new PantallaPrincipalEntrenador(informacionEntrenador);
							frame.setVisible(false);
						}

					}
				}

			}

		});

		botonRegistrarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// página de registro
				
				if (!(botonElegirEntrenador.isSelected()) && !(botonElegirUsuario.isSelected())) {
					JOptionPane.showMessageDialog(null, "<html>Debes seleccionar como te vas a registrar<html>", null, JOptionPane.ERROR_MESSAGE);
				}
				
				else if (botonElegirUsuario.isSelected()) {
					new RegistroUsuarioNuevo();
					frame.setVisible(false);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "<html>No se puede registrar como entrenador<html>", null, JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		botonOlvidarContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// página de registro
				frame.setVisible(false);
				new OlvidarContrasena();
			}
		});

		etiquetaFondo = new JLabel();
		imagenFondo = null;

		try {
			imagenFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
			ImageIcon im = new ImageIcon(imagenFondo.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFondo.setIcon(im);
		} catch(Exception e) {
		}				
		etiquetaFondo.setBounds(0, 0, 1024, 640);
		panel.add(etiquetaFondo);


		frame.setVisible(true);

	}
}