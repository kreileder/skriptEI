package tum.fsei.skriptEI;

public class Skript{

	//private static final long serialVersionUID = 1L;
	int id;
	String title;
	double price;
	String ident;
	int stock;
	boolean selected;
	
	public Skript(int id, String title, double price, String ident, int stock, boolean selected){
		this.id = id;
		this.title = title;
		this.price = price;
		this.ident = ident;
		this.stock = stock;
		this.selected = selected;
	}

	public int getId(){
		return id;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public String getIdent(){
		return this.ident;
	}
	
	public int getStock(){
		return this.stock;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void setIdent(String ident){
		this.ident = ident;
	}
	
	public void setStock(int stock){
		this.stock = stock;
	}

	public void setSelected(boolean myBool){
		this.selected = myBool;
	}
	
	public boolean getSelected(){
		return this.selected;
	}
	
}