package tum.fsei.skriptEI;

import java.util.Vector;

class InternalStorage
{
	
	//TODO vec zu stativ private umwandeln und dafür get-Methode schreiben
	
	public static Vector<Skript> vec = new Vector<Skript>();
	//Skript skript 		= new Skript("id","title","price","ident","stock",false);
	
	
	public static void setSkript(String id, String title, String price, String ident, String stock, boolean selected)
	{
		
		//TODO Wertebereiche prüfen!
		
		Skript skript 		= new Skript(id,title,price,ident,stock,selected);
		
		
		vec.add(skript);
	}
	
}