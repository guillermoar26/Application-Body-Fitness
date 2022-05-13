package Login;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class IntroducirCodigoEmail {

	private JFrame frame;
	
	private BufferedImage imagenFondo;
	
	private JLabel etiquetaFondo;
	private JLabel etiquetaComprobarRecibirMensaje;
	private JTextField textoCodigoIntroducido;
	private JButton botonCancelar;
	private JButton botonContinuar;


	public IntroducirCodigoEmail (String codigoAleatorio, String correoElectronico, String usuario) {
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
		etiquetaLogo.setBounds(352, 10, 70, 65);
		panel.add(etiquetaLogo);
		
		etiquetaComprobarRecibirMensaje = new JLabel("<html>Introduce el c\u00F3digo correctamente:<html>");
		etiquetaComprobarRecibirMensaje.setBounds(55, 74, 357, 44);
		panel.add(etiquetaComprobarRecibirMensaje);

		textoCodigoIntroducido = new JTextField ();
		textoCodigoIntroducido.setColumns(10);
		textoCodigoIntroducido.setBounds(55, 114, 124, 35);
		panel.add(textoCodigoIntroducido);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(55, 171, 89, 23);
		panel.add(botonCancelar);

		botonContinuar = new JButton("Continuar");
		botonContinuar.setBounds(163, 171, 120, 23);
		panel.add(botonContinuar);

		JLabel textoIngresaCodigo = new JLabel("<html>Ingresa el c\u00F3digo de seguridad<html>");
		textoIngresaCodigo.setBounds(25, 49, 168, 26);
		panel.add(textoIngresaCodigo);
		
		
		JLabel codigoPatcha = new JLabel(codigoAleatorio);
		codigoPatcha.setHorizontalAlignment(SwingConstants.CENTER);
		codigoPatcha.setFont(new Font("Informal Roman", Font.BOLD | Font.ITALIC, 29));
		codigoPatcha.setBounds(182, 36, 160, 39);
		panel.add(codigoPatcha);
		

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
		
		frame.setVisible(true);




		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PanelUsuarioContrasena();
				frame.setVisible(false);
			}
		});

		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// página de registro
				if (textoCodigoIntroducido.getText().equals(codigoAleatorio)) {
					System.out.println("AHORA A CAMBIAR LA CONTRASEÑA");
					new RestablecerContrasena(usuario);
					frame.setVisible(false);
				}


			}
		});
	}
}
