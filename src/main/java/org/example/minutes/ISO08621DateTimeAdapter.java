package org.example.minutes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Convert java.util.date to ISO8601 as String.
 * 
 * @author ntakeda67
 *
 */
public class ISO08621DateTimeAdapter extends XmlAdapter<String, Date>{
	private static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	

	@Override
    public Date unmarshal(String v) throws Exception {
        return formatter.parse(v);
    }

	@Override
    public String marshal(Date v) throws Exception {
        return formatter.format(v);
    }
}
