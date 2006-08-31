// $Id: JAXBTest.java,v 1.1.1.1 2006-08-31 09:09:28 dleroy Exp $
// Author: Jean-Guilhem Rouel
// (c) COPYRIGHT MIT, ERCIM and Keio, 2006.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.unicorn.tests;

import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.w3c.unicorn.generated.observationresponse.Observationresponse;

/**
 * JAXBTest<br />
 * Created: Jun 26, 2006 12:05:50 PM<br />
 * @author Jean-Guilhem Rouel
 */
public class JAXBTest {

	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext jc = JAXBContext.newInstance("org.w3c.unicorn.generated.observationresponse");
		Unmarshaller u = jc.createUnmarshaller();
		URL url = new URL("http://localhost:8001/css-validator/validator?uri=http%3A%2F%2Fforums.jeuxonline.info/clientscript/vbulletin_css/style-94bf45f8-00003.css&output=ucn");
		//URL url = new URL("http://w3cstag8/~jean/xml/mess.xml");
		//System.out.println(u.unmarshal(url.openStream()).getClass().getName());
		Observationresponse obsres = (Observationresponse)u.unmarshal(url.openStream());
		System.out.println(obsres.isPassed());
	}
	
}
