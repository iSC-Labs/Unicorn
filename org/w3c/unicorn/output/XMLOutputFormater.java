// $Id: XMLOutputFormater.java,v 1.1.1.1 2006-08-31 09:09:25 dleroy Exp $
// Author: Damien LEROY.
// (c) COPYRIGHT MIT, ERCIM ant Keio, 2006.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.unicorn.output;

import java.io.Writer;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.app.event.EventCartridge;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.w3c.unicorn.util.Property;

/**
 * Class for XML output formater.
 * @author Jean-Guilhem ROUEL
 */
public class XMLOutputFormater implements OutputFormater {

	private static final Log logger = OutputFactory.logger;

	private Template aTemplateOutput = null;
	private Template aTemplateError = null;

	private static VelocityEngine aVelocityEngineOutput = new VelocityEngine();			
	private static VelocityEngine aVelocityEngineError = new VelocityEngine();

	public XMLOutputFormater (
			final String sOutputFormat,
			final String sLang)
	throws ResourceNotFoundException, ParseErrorException, Exception {
		XMLOutputFormater.logger.trace("Constructor");
		if (XMLOutputFormater.logger.isDebugEnabled()) {
			XMLOutputFormater.logger.debug("Output format : " + sOutputFormat + ".");
			XMLOutputFormater.logger.debug("Output language : " + sLang + ".");
		}
		final String sFileName;
		sFileName = sLang + "_" +	sOutputFormat + Property.get("TEMPLATE_FILE_EXTENSION");
		this.aTemplateOutput = XMLOutputFormater.aVelocityEngineOutput.getTemplate(sFileName);
		this.aTemplateError = XMLOutputFormater.aVelocityEngineError.getTemplate(sFileName);
	}

	/* (non-Javadoc)
	 * @see org.w3c.unicorn.output.OutputFormater#produceOutput(java.util.Map, java.io.Writer)
	 */
	public void produceOutput (
			final Map<String, Object> mapOfStringObject,
			final Writer aWriter) throws
			ResourceNotFoundException,
			ParseErrorException, 
			MethodInvocationException,
			Exception {
		XMLOutputFormater.logger.trace("produceOutput");
		if (XMLOutputFormater.logger.isDebugEnabled()) {
			XMLOutputFormater.logger.debug("Map of String -> Object : " + mapOfStringObject + ".");
			XMLOutputFormater.logger.debug("Writer : " + aWriter + ".");
		}

		final VelocityContext aVelocityContext = new VelocityContext();
		final EventCartridge aEventCartridge = new EventCartridge();
		aEventCartridge.addEventHandler(new XHTMLize());
        //aEventCartridge.addEventHandler(new EscapeXMLEntities());                         
        aEventCartridge.attachToContext(aVelocityContext);
		
		for (final String sObjectName : mapOfStringObject.keySet()) {
			aVelocityContext.put(sObjectName, mapOfStringObject.get(sObjectName));
		}
		this.aTemplateOutput.merge(aVelocityContext, aWriter);
	}

	/* (non-Javadoc)
	 * @see org.w3c.unicorn.output.OutputFormater#produceError(java.lang.Exception, java.io.Writer)
	 */
	public void produceError (
			final Exception aException,
			final Writer aWriter) throws
			ResourceNotFoundException,
			ParseErrorException, 
			MethodInvocationException,
			Exception {
		XMLOutputFormater.logger.trace("produceError");
		if (XMLOutputFormater.logger.isDebugEnabled()) {
			XMLOutputFormater.logger.debug("Error : " + aException + ".");
			XMLOutputFormater.logger.debug("Writer : " + aWriter + ".");
		}
		final VelocityContext aVelocityContext = new VelocityContext();
		final EventCartridge aEventCartridge = new EventCartridge();
        aEventCartridge.addEventHandler(new EscapeXMLEntities());
        aEventCartridge.attachToContext(aVelocityContext);
		
		aVelocityContext.put("error", aException);		
		this.aTemplateError.merge(aVelocityContext, aWriter);
	}

	static {		
		try {
			final Properties aProperties = new Properties();
			aProperties.load(new URL("file:" + Property.get("VELOCITY_CONFIG_FILE")).openStream());
			
			aProperties.put(Velocity.FILE_RESOURCE_LOADER_PATH, 
					Property.get("PATH_TO_OUTPUT_TEMPLATES")); 			
			XMLOutputFormater.aVelocityEngineOutput.init(aProperties);
			XMLOutputFormater.logger.debug(
					"OutputEngine " +
					Velocity.FILE_RESOURCE_LOADER_PATH);
			aProperties.put(
					Velocity.FILE_RESOURCE_LOADER_PATH, 
					Property.get("PATH_TO_OUTPUT_ERROR_TEMPLATES"));
			XMLOutputFormater.aVelocityEngineError.init(aProperties);
		}
		catch (final Exception e) {
			XMLOutputFormater.logger.error("Exception : "+e.getMessage(), e);
			e.printStackTrace();
		}
	}

}
