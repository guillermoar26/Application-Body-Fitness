package Login;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import javax.swing.JButton;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;


public class SegundaParte_RegistroUsuario {

	// Frame y Panel
	private JFrame frame;
	private JPanel panel;

	// Imágenes
	private BufferedImage image;
	private BufferedImage imagenFondo;

	// Textfields
	private JTextField textoPeso;
	private JTextField textoAltura;
	private JTextField textoEdad;


	// Etiquetas
	private JLabel etiquetaLogo;
	private JLabel etiquetaPeso;
	private JLabel etiquetaAltura;
	private JLabel etiquetaEdad;
	private JLabel etiquetaSexo;
	private JLabel etiquetaFondo;

	// Botones
	private JButton botonCancelar;
	private JButton botonAceptar;

	// RadioButton
	private JRadioButton radioButtonHombre;
	private JRadioButton radioButtonMujer;

	// Grupo de botones
	private ButtonGroup grupoBotonesSexo;

	public SegundaParte_RegistroUsuario (String nombre, String email, String usuario, String contrasena) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		etiquetaLogo = new JLabel();
		image = null;

		try {
			image = ImageIO.read(getClass().getResource("/logo.jpg"));
			ImageIcon imagenLogo = new ImageIcon(image.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
			etiquetaLogo.setIcon(imagenLogo);	
		}
		catch (IOException e) {
		}

		etiquetaLogo.setBounds(98, 10, 229, 157);
		panel.add(etiquetaLogo);

		etiquetaPeso = new JLabel("<html>Introduzca su peso (en kg)<html>");
		etiquetaPeso.setBounds(21, 222, 158, 23);
		panel.add(etiquetaPeso);

		textoPeso = new JTextField();
		textoPeso.setBounds(243, 222, 96, 19);
		panel.add(textoPeso);
		textoPeso.setColumns(10);

		etiquetaAltura = new JLabel("<html>Introduzca su altura (en cm)<html>");
		etiquetaAltura.setBounds(21, 263, 158, 35);
		panel.add(etiquetaAltura);

		textoAltura = new JTextField();
		textoAltura.setBounds(243, 271, 96, 19);
		panel.add(textoAltura);
		textoAltura.setColumns(10);

		etiquetaEdad = new JLabel("<html>Introduzca su edad<html>");
		etiquetaEdad.setBounds(21, 323, 158, 13);
		panel.add(etiquetaEdad);

		textoEdad = new JTextField();
		textoEdad.setBounds(243, 317, 96, 19);
		panel.add(textoEdad);
		textoEdad.setColumns(10);

		etiquetaSexo = new JLabel("<html>Seleccione su sexo<html>");
		etiquetaSexo.setBounds(21, 364, 158, 13);
		panel.add(etiquetaSexo);


		radioButtonHombre = new JRadioButton("<html>Masculino<html>");
		radioButtonHombre.setBounds(185, 357, 85, 23);
		radioButtonHombre.setOpaque(false);
		panel.add(radioButtonHombre);

		radioButtonMujer = new JRadioButton("<html>Femenino<html>");
		radioButtonMujer.setBounds(288, 357, 108, 23);
		radioButtonMujer.setOpaque(false);
		panel.add(radioButtonMujer);

		grupoBotonesSexo = new ButtonGroup();
		grupoBotonesSexo.add(radioButtonHombre);
		grupoBotonesSexo.add(radioButtonMujer);		

		botonCancelar = new JButton("<html>Cancelar<html>");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Añade tus palabros harcodeando
				new PanelUsuarioContrasena();
				frame.setVisible(false);
			}
		});

		botonCancelar.setBounds(57, 426, 85, 21);
		panel.add(botonCancelar);



		botonAceptar = new JButton("<html>Siguiente<html>");

		botonAceptar.addActionListener(new ActionListener() { // Salga aviso de que dados los datos introducidos, el IMC es "xxx"
			public void actionPerformed(ActionEvent e) {

				boolean datosCorrectos = false;
				boolean datosBienIntroducidos = true;
				boolean numeroDecimal = false;

				double edad = 0;
				double peso = 0.0;
				double altura = 0.0;
				grupoBotonesSexo.isSelected(null);

				if((textoPeso.getText().equals("") || textoAltura.getText().equals("") || textoEdad.getText().equals("") || (!(radioButtonHombre.isSelected()) && !(radioButtonMujer.isSelected())))) {
					JOptionPane.showMessageDialog(null, "<html>¡Debes introducir en los 4 casilleros disponibles! aa<html>");
				}

				else if (!(textoPeso.getText().equals("")) || !(textoAltura.getText().equals("")) || !(textoEdad.getText().equals(""))) {

					if (textoAltura.getText().contains(",")) {
						textoAltura.setText(textoAltura.getText().replace(",", "."));
					}

					if (textoPeso.getText().contains(",")) {
						textoPeso.setText(textoPeso.getText().replace(",", "."));
					}

					try {
						peso = Double.parseDouble(textoPeso.getText());
					}

					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "<html>Introduce en el peso números no letras<html>");
						datosBienIntroducidos = false;
					}

					// CAMBIAR LA COMA POR UN PUNTO, SI NO SALE ERROR
					try {
						altura = Double.parseDouble(textoAltura.getText());
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "<html>Introduce en la altura números no letras<html>");
						datosBienIntroducidos = false;
					}

					try {
						edad = Double.parseDouble(textoEdad.getText());
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "<html>Introduce en la edad números enteros no decimales ni letras<html>");
						numeroDecimal = true;
						datosBienIntroducidos = false;

					}

					if (datosBienIntroducidos) {
						if (peso < 0.0 || peso > 635.0 ) {
							datosCorrectos = false;
							JOptionPane.showMessageDialog(null, "<html>El peso no puede ser menor a 0 ni mayor a 635<html>");
						}

						else {
							System.out.println("ALTURA: " + altura);
							if (altura < 53.3 || altura > 271.0) {
								datosCorrectos = false;
								JOptionPane.showMessageDialog(null, "<html>La altura no puede ser menor a 53.3 ni mayor a 271<html>");
							}

							else {

								if (edad % 1 != 0 || numeroDecimal) {
									JOptionPane.showMessageDialog(null, "<html>La edad no puede ser decimal, introduce otra edad<html>");
								}

								else if (edad < 0.0 || edad > 122.0) {
									JOptionPane.showMessageDialog(null, "<html>La edad no puede ser menor a 0 ni mayor a 122<html>");
								}
								else {
									datosCorrectos = true;
								}
							}
						}
					}




					if (datosCorrectos) {
						System.out.println("TODO GENIAL");


						if (radioButtonHombre.isSelected()) {
							double imcHombre = (peso) / (Math.pow(altura * 0.01, 2)); // Multiplico por 0.01 porque estan en cm y si no, el calculo está mal
							// Aqui esta la explicacion de como se forma lo de coger dos decimales https://www.delftstack.com/es/howto/java/how-to-round-a-double-to-two-decimal-places-in-java/#:~:text=trav%C3%A9s%20de%20ejemplos.-,Redondea%20un%20double%20a%20dos%20decimales%20usando%20Math.,a%20su%20entero%20m%C3%A1s%20cercano.
							DecimalFormat df = new DecimalFormat("###.##");
							double imcDosDecimales = Math.round(imcHombre * 100.0)/100.0;
							double porcentajeDeGrasaCorporal = ((1.2 * imcHombre) + (0.23 * Integer.parseInt(textoEdad.getText())) - (10.8 * 1)- 5.4);
							double porcentajeGrasaDosDecimales = Math.round(porcentajeDeGrasaCorporal * 100.0)/100.0;
							if (porcentajeGrasaDosDecimales <= 0) {
								JOptionPane.showMessageDialog(null, "<html>Error, tienes un porcentaje de grasa corporal negativo o igual a 0<html>");
							}

							else {
								if (datosCorrectos) { // ESTO TENGO QUE HACERLO CON HOMBRE Y MUJER
									JOptionPane.showMessageDialog(null, "<html>Dados los datos introducidos, el índice de masa corporal (IMC) es: <html>" + df.format(imcHombre)); // calcular el imc

									new EleccionOpciones(usuario, nombre, "", textoEdad.getText(), textoPeso.getText(), textoAltura.getText(), email, contrasena, String.valueOf(imcDosDecimales), String.valueOf(porcentajeGrasaDosDecimales), "Maculino");
									frame.setVisible(false);
								}
							}
						}

						else if (radioButtonMujer.isSelected()) {
							double imcMujer = (peso) / (Math.pow(altura * 0.01, 2)); // Multiplico por 0.01 porque estan en cm y si no, el calculo está mal
							// Aqui esta la explicacion de como se forma lo de coger dos decimales https://www.delftstack.com/es/howto/java/how-to-round-a-double-to-two-decimal-places-in-java/#:~:text=trav%C3%A9s%20de%20ejemplos.-,Redondea%20un%20double%20a%20dos%20decimales%20usando%20Math.,a%20su%20entero%20m%C3%A1s%20cercano.
							DecimalFormat df = new DecimalFormat("###.##");
							double imcDosDecimales = Math.round(imcMujer * 100.0)/100.0;
							double porcentajeDeGrasaCorporal = ((1.2 * imcMujer) + (0.23 * Integer.parseInt(textoEdad.getText())) - (10.8 * 0)- 5.4);
							double porcentajeGrasaDosDecimales = Math.round(porcentajeDeGrasaCorporal * 100.0)/100.0;
							if (porcentajeGrasaDosDecimales < 0) {
								JOptionPane.showMessageDialog(null, "<html>Error, tienes un porcentaje de grasa corporal negativo o igual a 0<html>");
							}

							else {
								if (datosCorrectos) { // ESTO TENGO QUE HACERLO CON HOMBRE Y MUJER
									JOptionPane.showMessageDialog(null, "<html>Dados los datos introducidos, el índice de masa corporal (IMC) es: <html>" + df.format(imcMujer)); // calcular el imc


									//String usuario, String nombre, String apellidos, String edad, String peso, String altura, String email, String contrasena
									new EleccionOpciones(usuario, nombre, "", textoEdad.getText(), textoPeso.getText(), textoAltura.getText(), email, contrasena, String.valueOf(imcDosDecimales), String.valueOf(porcentajeGrasaDosDecimales), "Femenino");
									frame.setVisible(false);

								}
							}
						}


					}


				}




			}
		});

		botonAceptar.setBounds(257, 426, 85, 21);
		panel.add(botonAceptar);

		etiquetaFondo = new JLabel();
		imagenFondo = null;

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