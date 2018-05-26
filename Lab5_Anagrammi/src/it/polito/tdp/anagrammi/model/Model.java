package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	public Set<String> cercaAnagrammi(String parola){

		Set<String> anagrammi = new HashSet<String>();
		String parziale = "";
		calcola(parziale,parola,0,anagrammi);
         return anagrammi;

	}

	

	public boolean isCorrect(String anagramma){
		AnagrammaDAO anagrammaDAO = new AnagrammaDAO();
        return anagrammaDAO.isCorrect(anagramma);

	}

	

	private void calcola(String parziale,String parola, int passo, Set<String> anagrammi){
		if(passo == parola.length()){
			anagrammi.add(parziale);
			
			return;
			//4 aggiugo eat e sono al passo 2 poi vdo a substring

		}

		for(int i = 0; i< parola.length(); i++)
		{
			
			//prendo prima lettera poi permuto le altre due 
			//scambio prima lettere con seconda
			//poi prendo seconda lettera e permuto le altre due
			
			//6 i=2 quindi diventa eta
             if(conteggio(parziale, parola.charAt(i))< conteggio(parola, parola.charAt(i)))
             //2nella ricorsione con il ciclo for che torna a 0 arriva a i=1 e aggiungo a
            //3 arrivo alla terza ricorsione dove aggiungo la t
             {
            	 
             	parziale += parola.charAt(i);
             	calcola(parziale, parola, passo + 1,anagrammi);
             	//1 aggiungo e a parziale vado indietro
				parziale = parziale.substring(0,parziale.length()-1);
//5torno nel for iniziale con i =1 e diventa ea
				//5poi tolgo anche la a
			}
//6 poi ae
		}

			

	}

	



	private int conteggio(String string, char c){

		int count = 0;

	    for (int i=0; i < string.length(); i++)
	    	
	    {
	        if (string.charAt(i) == c)
	        {
                  count++;

	        }

	    }

	    return count;

	}
	
	
	
}
