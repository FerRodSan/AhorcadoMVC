package controlador;

import java.awt.EventQueue;

import vista.AhorcadoUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends AhorcadoUI {

	Control control = new Control();

	public Principal() {
		super();
		txtLetra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtLetra.getText().isEmpty())
					txtMensaje.setText("introduce una letra");
				else 
					txtMensaje.setText("");
					control.anotarAciertos(txtLetra.getText().charAt(0));
					txtAciertos.setText(control.getAciertos());
					//getFallos pide un int y setFallos un String, se hace un casting y jau!
					txtFallos.setText(String.valueOf(control.getFallos()));
					txtLetra.setText("");
				if (control.palabraAcertada())
					txtMensaje.setText("Has ganado!!");
				if (control.getFallos() >= 6)
					txtMensaje.setText("Perdiste!! Oooooohhhh!!");

			}
		});
		btnYa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPalabraSecreta.getText().isEmpty())
					txtMensaje.setText("Escribe algo");
				else {
					// aqui hemos llegado porque la palabra es valida
					control.setPalabreja(txtPalabraSecreta.getText());
					control.iniciaAciertos();
					// comportamiento del ui tras validar palabra
					// Ocultar los componentes que se han usado para introducir la
					// palabra secreta
					txtPalabraSecreta.setVisible(false);
					lblPalabraSecreta.setVisible(false);
					btnYa.setVisible(false);
					// hacemos visible el titulo
					lblTitulo.setVisible(true);
					// habilitar el txt de la letra
					txtLetra.setEditable(true);
					txtMensaje.setText("");
				}
			}
		});

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// IMPORTANTE: Se crea un objeto de Principal no del UI
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
