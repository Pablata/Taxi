package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import container.Listas;
import models.*;

import java.awt.Font;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Pagos {

	protected JFrame framePagoYBajada;
	private JTextField reciboField;
	private JLabel lblCambioFinal;
	private JLabel lblContador;
	private JLabel lblCoste;
	private JLabel lblBandera;
	private JButton btnFinTrayecto;
	private JList listaSuplementos;
	private JLabel lblCambio;
	private JLabel lblRecibo;
	private int indiceClientes;
	
	// cambio y precios
	private float bandera;
	private float precioSuplemento;
	private float precioMinuto;
	private float costeTrayecto;
	private float dineroRecibido;
	private float cambio;

	// atribtos hora y tiempo
	private long time_start;
	private int hora;
	private int minutos;
	private int segundos;
	private int dia;
	private int mes;
	private int anio;
	private int diaSemana;
	private Calendar calendario;
	private Cronometro crono;
	private JButton btnFinalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagos window = new Pagos();
					window.framePagoYBajada.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pagos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framePagoYBajada = new JFrame();
		framePagoYBajada.setTitle("Pago\t y\t bajada de\t viajero");
		framePagoYBajada.setBounds(100, 100, 472, 331);
		framePagoYBajada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePagoYBajada.getContentPane().setLayout(null);

		lblContador = new JLabel("Contador de Tiempo");
		lblContador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContador.setBounds(10, 11, 160, 31);
		framePagoYBajada.getContentPane().add(lblContador);

		lblBandera = new JLabel("Bajada de Bandera");
		lblBandera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBandera.setBounds(10, 53, 160, 31);
		framePagoYBajada.getContentPane().add(lblBandera);

		btnFinTrayecto = new JButton("Fin de Trayecto");

		btnFinTrayecto.setBounds(197, 12, 160, 72);
		btnFinTrayecto.setBackground(Color.red);

		framePagoYBajada.getContentPane().add(btnFinTrayecto);

		listaSuplementos = new JList();
		listaSuplementos.setModel(new AbstractListModel() {
			String[] values = new String[] { "Sin suplemento", "Noche", "Aeropuerto" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		listaSuplementos.setSelectedIndex(0);
		listaSuplementos.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listaSuplementos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listaSuplementos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listaSuplementos.setBounds(10, 143, 160, 88);
		framePagoYBajada.getContentPane().add(listaSuplementos);

		JLabel lblSuplemento = new JLabel("Seleccione Suplementos:");
		lblSuplemento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSuplemento.setBounds(10, 101, 160, 31);
		framePagoYBajada.getContentPane().add(lblSuplemento);

		lblRecibo = new JLabel("Recibo:");
		lblRecibo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRecibo.setBounds(197, 113, 160, 31);
		framePagoYBajada.getContentPane().add(lblRecibo);

		reciboField = new JTextField();
		reciboField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (!reciboField.getText().trim().equals("")) {
					cambio = 0;
					dineroRecibido = Float.parseFloat(reciboField.getText());
					cambio = dineroRecibido - costeTrayecto;

					if (dineroRecibido > costeTrayecto) {
						lblCambioFinal.setText("" + cambio);
						lblRecibo.setText("Recibo: ");
						;

						btnFinalizar.setEnabled(true);

					} else {
						btnFinalizar.setEnabled(false);

						lblRecibo.setText("[Error]:cantidad insuficiente o formato incorrecto.");
					}
				} else {
					btnFinalizar.setEnabled(false);

					lblRecibo.setText("[Error]:cantidad insuficiente o formato incorrecto.");

				}

			}
		});
		reciboField.setEnabled(false);

		reciboField.setBounds(197, 155, 103, 31);
		framePagoYBajada.getContentPane().add(reciboField);
		reciboField.setColumns(10);

		lblCambio = new JLabel("Cambio:");
		lblCambio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCambio.setBounds(197, 197, 160, 31);
		framePagoYBajada.getContentPane().add(lblCambio);

		lblCambioFinal = new JLabel();
		lblCambioFinal.setBounds(197, 239, 103, 31);
		framePagoYBajada.getContentPane().add(lblCambioFinal);

		lblCoste = new JLabel("Coste:");
		lblCoste.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCoste.setBounds(10, 242, 160, 31);
		framePagoYBajada.getContentPane().add(lblCoste);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setEnabled(false);

		btnFinalizar.setBackground(Color.RED);
		btnFinalizar.setBounds(310, 173, 114, 72);
		framePagoYBajada.getContentPane().add(btnFinalizar);

		
		
		
		
		
//
//				indiceClientes = 0;
//				// Cliente c = Listas.listaClientes.get(indiceClientes);
//				Cliente c = new Cliente();
//				Listas.listaClientes.add(c);
//		
		
		
		
		
		
		
		
		
		start();
		bajadaBandera();

		parar();

		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
			
				
				Inicio ventanaInicio = new Inicio();
				ventanaInicio.frameInicio.setVisible(true);
				framePagoYBajada.dispose();

			}
		});

	}

	public void crono() {
		crono = new Cronometro();

	}

	public void start() {
		crono();
		crono.Contar(lblContador);
		lblContador.setText("" + crono.getSegundos());

	}

	public void horas() {

		start();

		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		dia = calendario.get(Calendar.DAY_OF_MONTH);
		mes = calendario.get(Calendar.MONTH);
		anio = calendario.get(Calendar.YEAR);

		lblContador.setText("" + segundos);

	}

	public void bajadaBandera() {
		calendario = new GregorianCalendar();
		diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
		String semana = "";

		if (diaSemana == 2) {
			semana = "Lunes";
			bandera = 3.65f;
		} else if (diaSemana == 3) {
			semana = "Martes";
			bandera = 3.65f;

		} else if (diaSemana == 4) {
			semana = "Miercoles";
			bandera = 3.65f;

		} else if (diaSemana == 5) {
			semana = "Jueves";
			bandera = 3.65f;

		} else if (diaSemana == 6) {
			semana = "Viernes";
			bandera = 3.65f;

		} else if (diaSemana == 7) {
			semana = "Sabado";
			bandera = 4.55f;

		} else if (diaSemana == 1) {
			semana = "Domingo";
			bandera = 4.55f;
		}

		lblBandera.setText("" + bandera);

	}

	public void parar() {
		btnFinTrayecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFinTrayecto.setBackground(null);
				suplemento();
				crono.Detener();
				costeFinal();

				btnFinTrayecto.setEnabled(false);
				reciboField.setEnabled(true);

				
				Cliente c = new Cliente();
		
				
				//Listas.listaClientes.add(c);
				
				
				Listas.listaClientes.add(c);
				int id;
				id=Listas.listaClientes.size();
				c.setNumeroCliente(id);
				c.setPrecioTotal(costeTrayecto);
				
				c.setFechaBajada(lblContador.getText());
				
				System.out.println("");
				for (Cliente c2: Listas.listaClientes){	
					System.out.println(c.toString());
				}
			
				
				
				
				
				
				
			}
		});
	}

	public void suplemento() {

		int index = listaSuplementos.getSelectedIndex();
		if (index == 0) {
			precioSuplemento = 0;

		}
		if (index == 1) {
			precioSuplemento = 2.0f;
		}
		if (index == 2) {
			precioSuplemento = 5.5f;
		}

	}

	public void costeMinutos() {
		float tiempoSegundos = crono.getSegundos();
		float precioPorMinuto = 0;
		if (diaSemana == 1 || diaSemana == 7) {
			precioPorMinuto = 0.26f;
			precioMinuto = tiempoSegundos * precioPorMinuto;
		}

		else {
			precioPorMinuto = 0.18f;
			precioMinuto = tiempoSegundos * precioPorMinuto;
		}

	}

	public void costeFinal() {
		costeMinutos();

		costeTrayecto = bandera + precioMinuto + precioSuplemento;
		// lblCoste.setText("Coste: " + bandera+" "+ precioMinuto+"
		// "+precioSuplemento);

		lblCoste.setText("Coste: " + costeTrayecto);
	}

}
