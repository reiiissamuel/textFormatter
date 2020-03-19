package com.example.test_project;

import org.slf4j.LoggerFactory;

public class Formatter {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Formatter.class);
	private static final String bs = "<b>"; private static final String be = "<b/>"; //marcador de bloco em negrito
	private static final String is = "<i>"; private static final String ie = "<i/>"; //marcador de bloco em italico
	private static final String cs = "<c>"; private static final String ce = "<c/>"; //marcador do bloco em riscado
	private String text;
	
	public Formatter(String text) {
		super();
		this.text = text;
	}

	public String format(){
		text = "  " + text + " ";  
		String[] chars = text.split("");
		String[] charsCopy = text.split("");
		
		for(int i = 2; i < chars.length-1; i++) {  
			
			if(!chars[i].equals(chars[i-1]) && chars[i-1].matches("[\\*_~\\s]+")
					&& chars[i].matches("[\\*_~]?") && !chars[i+1].matches("[\\s]?")){
				
				for(int j = i+2; j < chars.length-1;j++) {
					if(charsCopy[j].matches("("+be+"|"+ie+"|"+ce+")")){
						
						break;
						
					}else {
						
						if(chars[j].equals(chars[i]) && !chars[j-1].matches("[\\s]?") && !chars[j+1].matches("[A-Za-zÀ-ù0-9]")) {
							
							if(chars[j].equals("*") && !charsCopy[i].matches("("+bs+"|"+is+"|"+cs+")") && !((chars[i-1].equals("_")||chars[i-2].equals("_")) && (chars[j-1].equals("_"))) 
									&& !((chars[i-1].equals("~")||chars[i-2].equals("~")) && (chars[j-1].equals("~")))){
								charsCopy[i] = bs;
								charsCopy[j] = be;
								break;
							}
							else if(chars[j].equals("_") && !charsCopy[i].matches("("+bs+"|"+is+"|"+cs+")") && !((chars[i-1].matches("\\*")||chars[i-2].matches("\\*")) && (chars[j-1].matches("\\*"))) 
									&& !((chars[i-1].equals("~")||chars[i-2].equals("~")) && (chars[j-1].equals("~")))){
								charsCopy[i] = is;
								charsCopy[j] = ie;
								break;
							}
							
							else if(chars[j].equals("~") && !charsCopy[i].matches("("+bs+"|"+is+"|"+cs+")") && !((chars[i-1].equals("~")||chars[i-2].equals("~")) && (chars[j-1].equals("~"))) 
									&& !((chars[i-1].matches("\\*")||chars[i-2].matches("\\*")) && (chars[j-1].matches("\\*")))){
								charsCopy[i] = cs;
								charsCopy[j] = ce;
								break;
							}
						}
					}
				}
			}
		}
		
		return textRebuild(charsCopy);
	}
	
	private String textRebuild(String[] c) {
		StringBuilder textRebuilt = new StringBuilder();
		for (int i = 2; i < c.length - 1; i++) {
			textRebuilt.append(c[i]);
		}
		log.info("\n");
		log.info("\n");
		log.info(textRebuilt.toString());
		return textRebuilt.toString();
	}
	
	
}
