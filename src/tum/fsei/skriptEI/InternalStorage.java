package tum.fsei.skriptEI;

import java.util.Vector;

class InternalStorage {

	// TODO vec zu stativ private umwandeln und daf�r get-Methode schreiben

	public static Vector<Skript> vec = new Vector<Skript>();

	public static void setSkript(Skript skript) {
		// TODO Wertebereiche pr�fen!
		vec.addElement(skript);
	}

}