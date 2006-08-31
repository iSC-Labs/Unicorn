// $Id: Unmarshaller.java,v 1.1.1.1 2006-08-31 09:09:28 dleroy Exp $
// Author: Damien LEROY.
// (c) COPYRIGHT MIT, ERCIM ant Keio, 2006.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.unicorn.util;

import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

/**
 * Interface for all unmarshaller class in package unicorn.
 * @author Damien LEROY
 */
public interface Unmarshaller {

	public void addURL (final URL aURL) throws IOException, JAXBException, SAXException;
	public void unmarshal () throws Exception;

}
