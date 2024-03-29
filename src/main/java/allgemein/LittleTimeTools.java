package allgemein;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;


public class LittleTimeTools 
{

    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    
    public static final String futureString = "In the Future: ";

    public static String timeString(LocalDateTime ldt)
    {
    	
    	return ldt.format(dtf);
    }
    
    public static final DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");
    
    public static String timeString(LocalTime lt)
    {
    	return lt.format(tf);
    }
    
    public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public static String timeString(LocalDate ld)
    {
    	return ld.format(df);
    }

    public static LocalDateTime LDTfromTimeString(String timeString)
    {	
    	return LocalDateTime.parse(timeString, dtf);
    }
    

}
