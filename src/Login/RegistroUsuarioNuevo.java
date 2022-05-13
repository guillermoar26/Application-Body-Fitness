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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import FuncionamientoAplicacion.Ajustes;
import InformacionPersona.Usuario;

public class RegistroUsuarioNuevo{

	private JFrame frame;
	
	private JTextField textoNombre;
	private JTextField textoEmail;
	private JTextField textoUsuario;
	
	private JPasswordField textoContrasena; 
	private JPasswordField textoConfirmarContrasena;

	private JLabel textoRegistrarte;
	private JLabel etiquetaNombre; 
	private JLabel etiquetaEmail;
	private JLabel etiquetaUsuario;
	private JLabel etiquetaContrasena; 
	private JLabel etiquetaConfirmarContrasena;
	private JLabel etiquetaFondo;
	
	private JButton botonAnterior;
	private JButton botonRegistrarse;

	private boolean usuarioDisponible = true;
	
	private BufferedImage imagenFondo;


	public RegistroUsuarioNuevo() {
		frame = new JFrame();
		frame.setBounds(100, 100, 479, 582);
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
		etiquetaLogo.setBounds(352, 10, 70, 65);
		panel.add(etiquetaLogo);
		
		textoRegistrarte = new JLabel("<html>Registrarse<html>");
		textoRegistrarte.setBounds(185, 11, 86, 35);
		panel.add(textoRegistrarte);

		etiquetaNombre = new JLabel("<html>Nombre<html>");
		etiquetaNombre.setBounds(46, 70, 62, 22);
		panel.add(etiquetaNombre);

		etiquetaEmail = new JLabel("<html>E-mail<html>");
		etiquetaEmail.setBounds(46, 136, 62, 22);
		panel.add(etiquetaEmail);

		etiquetaUsuario = new JLabel("<html>Usuario<html>");
		etiquetaUsuario.setBounds(46, 201, 62, 31);
		panel.add(etiquetaUsuario);

		etiquetaContrasena = new JLabel("<html>Contrase\u00F1a<html>");
		etiquetaContrasena.setBounds(46, 268, 86, 31);
		panel.add(etiquetaContrasena);

		etiquetaConfirmarContrasena = new JLabel("<html>Confirmar contrase\u00F1a<html>");
		etiquetaConfirmarContrasena.setBounds(46, 349, 137, 22);
		panel.add(etiquetaConfirmarContrasena);

		textoNombre = new JTextField();
		textoNombre.setBounds(46, 91, 293, 31);
		panel.add(textoNombre);
		textoNombre.setColumns(10);

		textoEmail = new JTextField();
		textoEmail.setColumns(10);
		textoEmail.setBounds(46, 155, 293, 31);
		panel.add(textoEmail);

		textoUsuario = new JTextField();
		textoUsuario.setColumns(10);
		textoUsuario.setBounds(46, 226, 293, 31);
		panel.add(textoUsuario);

		textoContrasena = new JPasswordField();
		textoContrasena.setColumns(10);
		textoContrasena.setBounds(46, 301, 293, 31);
		panel.add(textoContrasena);

		textoConfirmarContrasena = new JPasswordField();
		textoConfirmarContrasena.setColumns(10);
		textoConfirmarContrasena.setBounds(46, 382, 293, 31);
		panel.add(textoConfirmarContrasena);

		botonAnterior = new JButton("<html>Atrás<html>");
		//botonRegistrarse.addActionListener(this);
		botonAnterior.setBackground(Color.LIGHT_GRAY);
		botonAnterior.setForeground(Color.BLACK);
		botonAnterior.setBounds(46, 487, 110, 35);
		panel.add(botonAnterior);
		
		botonRegistrarse = new JButton("<html>Registrarse<html>");
		//botonRegistrarse.addActionListener(this);
		botonRegistrarse.setBackground(Color.LIGHT_GRAY);
		botonRegistrarse.setForeground(Color.BLACK);
		botonRegistrarse.setBounds(250, 487, 110, 35);
		panel.add(botonRegistrarse);

		// Imagen Fondo
				etiquetaFondo = new JLabel();
				imagenFondo = null;

				try {
					imagenFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
					ImageIcon im = new ImageIcon(imagenFondo.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
					etiquetaFondo.setIcon(im);
				} catch(Exception e) {
				}
				etiquetaFondo.setBounds(0, 0, 479, 582);
				panel.add(etiquetaFondo);

				// Añadir escucha para el botón de volver atrás
				botonAnterior.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, "Sí");
						if (resp == 0) {
							new PanelUsuarioContrasena();		
							frame.setVisible(false);
						}
					}
				});

				// Añadir escucha para el botón de registro
				botonRegistrarse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				//Usuario informacionUsuario = Usuario.getListaUsuarios();
				if (textoNombre.getText().equals("")) {
					System.out.println("NO HAS PUESTO NADA");
					JOptionPane.showMessageDialog(null, "Debe poner su nombre",null,JOptionPane.ERROR_MESSAGE);
				} 
				else if (textoEmail.getText().equals("")) {
					System.out.println("NO HAS PUESTO NADA");
					JOptionPane.showMessageDialog(null, "Debe poner su correo electrónico",null,JOptionPane.ERROR_MESSAGE);
				} 
				else if (textoUsuario.getText().equals("")) {
					System.out.println("NO HAS PUESTO NADA");
					JOptionPane.showMessageDialog(null, "Debe poner un usuario",null,JOptionPane.ERROR_MESSAGE);
				} 
				else if (new String (textoContrasena.getPassword()).equals("")) {
					System.out.println("NO HAS PUESTO NADA");
					JOptionPane.showMessageDialog(null, "Debe poner una contraseña",null,JOptionPane.ERROR_MESSAGE);
				} 
				else if (new String(textoConfirmarContrasena.getPassword()).equals("")) {
					System.out.println("NO HAS PUESTO NADA");
					JOptionPane.showMessageDialog(null, "Debe confirmar la contraseña anterior",null,JOptionPane.ERROR_MESSAGE);
				} 
				else if ((!(textoEmail.getText().contains("@gmail.com")) &&  !(textoEmail.getText().contains("@outlook.es")) && !(textoEmail.getText().contains("@yahoo.com")) && !(textoEmail.getText().contains("@hotmail.com")))) {
					JOptionPane.showMessageDialog(null, "Debes poner un correo existente, con Outlook, Gmail, Hotmail o Yahoo",null,JOptionPane.ERROR_MESSAGE);
				}
				else {
					System.out.println(new String(textoContrasena.getPassword()).equals(new String(textoConfirmarContrasena.getPassword())));
					if (new String(textoContrasena.getPassword()).equals(new String(textoConfirmarContrasena.getPassword()))) {
						System.out.println("AMBAS CONTRASEÑAS IGUALES");

						if (Usuario.existeUsuario(textoUsuario.getText())) { // Funcion si existe el usuario o no
							JOptionPane.showMessageDialog(null, "Este usuario ya existe, introduce otro nuevo",null,JOptionPane.ERROR_MESSAGE);
							System.out.println("Este usuario ya existe, introduce otro nuevo");
							usuarioDisponible = false;
						}
						else {
							usuarioDisponible = true;
						}
						
						if (usuarioDisponible) { // El usuario esta disponible
							new SegundaParte_RegistroUsuario(textoNombre.getText(), textoEmail.getText(), textoUsuario.getText(), new String (textoContrasena.getPassword()));
							frame.setVisible(false);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", null, JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		frame.setVisible(true);
	}


}
