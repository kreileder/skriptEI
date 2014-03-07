package tum.fsei.skriptEI;



public class Skript{

	//private static final long serialVersionUID = 1L;
	String id, title, price, ident, stock;
	boolean selected;
	
	public Skript(String id, String title, String price, String ident, String stock, boolean selected){
		this.id = id;
		this.title = title;
		this.price = price;
		this.ident = ident;
		this.stock = stock;
		this.selected = selected;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getPrice(){
		return this.price;
	}
	
	public String getIdent(){
		return this.ident;
	}
	
	public String getStock(){
		return this.stock;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setPrice(String price){
		this.price = price;
	}
	
	public void setIdent(String ident){
		this.ident = ident;
	}
	
	public void setStock(String stock){
		this.stock = stock;
	}

	public void setSelected(boolean myBool){
		this.selected = myBool;
	}
	
	public boolean getSelected(){
		return this.selected;
	}
	
}