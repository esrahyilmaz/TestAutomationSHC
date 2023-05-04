package com.fadv.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.logging.Logger;

public class UtilTextProcessor {
	static Logger logger = Logger.getLogger(UtilTextProcessor.class.getName());

	public static String processText(String text){
		//String regexToken = "\\[\\w+:?\\d*\\]";
		//String regexToken = "\\[\\w+[:\\w/-/.]*\\]";
		String regexToken = "\\[\\w+[-:\\w/.]*\\]";
		String stringToken = null;
		String valueToken = null;

		if(text != null && !text.isEmpty()){
			Pattern p = Pattern.compile(regexToken);
			Matcher m = p.matcher(text);

			while (m.find()) {
				stringToken = m.group();	
				stringToken = stringToken.substring(1, stringToken.length()-1);
				String[] parts = stringToken.split(":");

				if(parts[0].equalsIgnoreCase("gentext")){
					try { 
						valueToken = genText(Integer.parseInt(parts[1]));
						text = text.replace(m.group(), valueToken);
					} catch(Exception e) { 
						logger.info(e.toString());
					}
				}else if(parts[0].equalsIgnoreCase("genhex")){
					try { 
						valueToken = genHex(Integer.parseInt(parts[1]));
						text = text.replace(m.group(), valueToken);					
					} catch(Exception e) { 
						logger.info(e.toString());
					}
				}else if(parts[0].equalsIgnoreCase("gentext2")){
					try { 
						valueToken = genText2(Integer.parseInt(parts[1]));
						text = text.replace(m.group(), valueToken);					
					} catch(Exception e) { 
						logger.info(e.toString());
					}					
				}else if(parts[0].equalsIgnoreCase("gennum")){
					try { 
						valueToken = genNum(Integer.parseInt(parts[1]));
						text = text.replace(m.group(), valueToken);					
					} catch(Exception e) { 
						logger.info(e.toString());
					}
				}else if(parts[0].equalsIgnoreCase("blank")){
					text = text.replace(m.group(), "");	
				}else if(parts[0].equalsIgnoreCase("month") || parts[0].equalsIgnoreCase("currentmonth")){				
					Calendar cal = Calendar.getInstance();
					int month = cal.get(Calendar.MONTH) + 1;
					if(parts.length <= 1){
						text = text.replace(m.group(), month + "");
					} else {
						if(parts[1].equalsIgnoreCase("2")){	
							if(month >= 10){
								text = text.replace(m.group(), "" + month);
							} else {
								text = text.replace(m.group(), "0" + month);
							}
						} else {
							text = text.replace(m.group(), month + "");
						}
					}
				}else if(parts[0].equalsIgnoreCase("year") || parts[0].equalsIgnoreCase("currentyear")){
					Calendar cal = Calendar.getInstance();
					int year = cal.get(Calendar.YEAR);
					text = text.replace(m.group(), year + "");				
				}else if(parts[0].equalsIgnoreCase("today")){
					String format = "dd/MM/yyyy";
					if(parts.length > 1 && parts[1].length() > 0){
						format = parts[1];
					}

					SimpleDateFormat dateFormat = new SimpleDateFormat(format);
					text = text.replace(m.group(), dateFormat.format(new Date()));						
				}else if(parts[0].equalsIgnoreCase("yesterday")){
					String format = "dd/MM/yyyy";
					if(parts.length > 1 && parts[1].length() > 0){
						format = parts[1];
					}
					SimpleDateFormat dateFormat = new SimpleDateFormat(format);
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, -1);      
					text = text.replace(m.group(), dateFormat.format(cal.getTime()));
				}else if(parts[0].equalsIgnoreCase("tomorrow")){
					String format = "dd/MM/yyyy";
					if(parts.length > 1 && parts[1].length() > 0){
						format = parts[1];
					}
					SimpleDateFormat dateFormat = new SimpleDateFormat(format);
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, 1);      
					text = text.replace(m.group(), dateFormat.format(cal.getTime()));
				}else if(parts[0].equalsIgnoreCase("nextweek")){
					String format = "dd/MM/yyyy";
					if(parts.length > 1 && parts[1].length() > 0){
						format = parts[1];
					}
					SimpleDateFormat dateFormat = new SimpleDateFormat(format);
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, 7);      
					text = text.replace(m.group(), dateFormat.format(cal.getTime()));	
				}else if(parts[0].equalsIgnoreCase("lastweek")){
					String format = "dd/MM/yyyy";
					if(parts.length > 1 && parts[1].length() > 0){
						format = parts[1];
					}
					SimpleDateFormat dateFormat = new SimpleDateFormat(format);
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, -7);      
					text = text.replace(m.group(), dateFormat.format(cal.getTime()));						
				}
			}
		}
		return text;
	}
	

	public static String genText(int len){
		final Random random = new Random(System.nanoTime());
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] text = new char[len];
		for (int i = 0; i < len; i++){
			text[i] = characters.charAt(random.nextInt(characters.length()));
		}
		return new String(text);
		//return "anythslkdfjasldfjkaslsdfing".substring(0, len);
	}	

	public static String genNum(int len){
		final Random random = new Random(System.nanoTime());
		String characters = "0123456789";
		char[] text = new char[len];
		for (int i = 0; i < len; i++){
			text[i] = characters.charAt(random.nextInt(characters.length()));
		}
		return new String(text);		
		//return "41253452039582309565521".substring(0, len);
	}		
	
	public static String genHex(int len){
		final Random random = new Random(System.nanoTime());
		String characters = "0123456789ABCDEF";
		char[] text = new char[len];
		for (int i = 0; i < len; i++){
			text[i] = characters.charAt(random.nextInt(characters.length()));
		}
		return new String(text);
	}	
	
	public static String genText2(int len){
		final Random random = new Random(System.nanoTime());
		String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		char[] text = new char[len];
		for (int i = 0; i < len; i++){
			text[i] = characters.charAt(random.nextInt(characters.length()));
		}
		return new String(text);
	}
}
