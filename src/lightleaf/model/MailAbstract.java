package lightleaf.model;

import java.util.ArrayList;

import lightleaf.observer.Observable;
import lightleaf.observer.Observer;

public class MailAbstract implements Observable{
	protected double result = 0;   
	  protected String operateur = "", operande = "";
	  private ArrayList<Observer> listObserver = new ArrayList<Observer>();   
	  //Efface 
	  
	  //Implémentation du pattern observer
	  public void addObserver(Observer obs) {
	    this.listObserver.add(obs);
	  }

	  public void notifyObserver(String str) {
		  for(Observer obs : listObserver)
			  obs.update(str);
	  }

	  public void removeObserver() {
	    listObserver = new ArrayList<Observer>();
	  }  
}
