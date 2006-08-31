// $Id: LocalizedString.java,v 1.1.1.1 2006-08-31 09:09:28 dleroy Exp $
// Author: Jean-Guilhem Rouel
// (c) COPYRIGHT MIT, ERCIM and Keio, 2006.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.unicorn.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * LocalizedString<br />
 * Created: May 30, 2006 11:55:23 AM<br />
 * @author Jean-Guilhem ROUEL & Damien LEROY
 */
public class LocalizedString {

	private static final Log logger = LogFactory.getLog("org.w3c.unicorn.util");

	public static final String DEFAULT_LANGUAGE = "en";

	private Map<String, String> mapOfString = null;

	public LocalizedString () {
		LocalizedString.logger.trace("Constructor");
		this.mapOfString = new LinkedHashMap<String, String>();
	}

	public boolean hasLocale (final String sLocale) {
		return null != this.mapOfString.get(sLocale);
	}

	public String addLocalization (
			final String sLocale,
			final String sMessage) {
		LocalizedString.logger.trace("addLocalization");
		if (LocalizedString.logger.isDebugEnabled()) {
			LocalizedString.logger.debug("Locale : "+sLocale+".");
			LocalizedString.logger.debug("Message : "+sMessage+".");
		}
		return this.mapOfString.put(sLocale, sMessage);
	}

	public String getLocalization (final String sLocale) {
		final String sMessage = this.mapOfString.get(sLocale);
		if (null != sMessage) {
			return sMessage;
		}
		return this.mapOfString.get(LocalizedString.DEFAULT_LANGUAGE);
	}

	public Set<String> getSetOfLocale () {
		return this.mapOfString.keySet();
	}

	public String toString () {
		return this.mapOfString.get(LocalizedString.DEFAULT_LANGUAGE);
	}

}
