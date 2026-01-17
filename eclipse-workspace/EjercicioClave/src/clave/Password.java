package clave;

import java.util.Random;

public class Password {
	/*
	 * Haz una clase llamada Password que siga las siguientes condiciones: Que tenga
	 * los atributos longitud y contraseña . Por defecto, la longitud será de 8. Los
	 * constructores serán los siguiente: Un constructor por defecto. Un constructor
	 * con la longitud que nosotros le pasemos. Generará una contraseña aleatoria
	 * con esa longitud. Los métodos que implementa serán: esFuerte(): devuelve un
	 * booleano si es fuerte o no, para que sea fuerte debe tener más de 2
	 * mayúsculas, más de 1 minúscula y más de 5 números. generarPassword(): genera
	 * la contraseña del objeto con la longitud que tenga. Método get para
	 * contraseña y longitud. Método set para longitud.
	 */

	// Arrays de caracteres

	private char[] Mayuscula = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	private char[] Minuscula = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	private char[] Numeros = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	// Atributos
	private int longitud = 8;
	private String contraseña;

	// Constructor

	public Password() {
		this.contraseña = generarPassword();
	}

	public Password(int longitud) {
		this.longitud = longitud;
		this.contraseña = generarPassword();
	}

	// Getter y Setters

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
		this.contraseña = generarPassword();
	}

	public String getContraseña() {
		return contraseña;
	}

	// Métodos
	// EsFuerte

	public boolean EsFuerte() {
		if (longitud <= 8) {
			return false;
		}
	

	int mayus = 0;
	int minus = 0;
	int nums = 0;

	for(
	char c:contraseña.toCharArray())
	{ /*
		 * .toCharArray: convierte String en un nuevo array char
		 */
		if (Character.isUpperCase(c)) {
			mayus++;
		} else if (Character.isLowerCase(c)) {
			minus++;
		} else if (Character.isDigit(c)) {
			nums++;
		}
	}

	return mayus>2&&minus>1&&nums>5;
	}

	// Generador de contraseña
	private String generarPassword() {
        Random random = new Random();

        StringBuilder password = new StringBuilder(); /*
                                                         * Se utiliza para construir cadenas de texto de forma
                                                         * eficiente, ya que permite modificar el contenido sin
                                                         * crear nuevos objetos String cada vez que se añade un
                                                         * carácter.
                                                         */

        for (int i = 0; i < longitud; i++) {

            int tipocaracter = random.nextInt(3);

            switch (tipocaracter) {
            case 0:
                password.append(Mayuscula[random.nextInt(Mayuscula.length)]);
                break;
            case 1:
                password.append(Minuscula[random.nextInt(Minuscula.length)]);
                break;
            case 2:
                password.append(Numeros[random.nextInt(Numeros.length)]);
                break;
            }
        }

        return password.toString();
    }
}
