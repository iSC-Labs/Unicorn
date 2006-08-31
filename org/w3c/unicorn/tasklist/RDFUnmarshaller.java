// $Id: RDFUnmarshaller.java,v 1.1.1.1 2006-08-31 09:09:26 dleroy Exp $
// Author: Damien LEROY.
// (c) COPYRIGHT MIT, ERCIM ant Keio, 2006.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.unicorn.tasklist;

import java.util.Map;

import org.w3c.unicorn.contract.Observer;
import org.w3c.unicorn.util.Unmarshaller;

/**
 * @author Damien LEROY
 *
 */
public interface RDFUnmarshaller extends Unmarshaller {

	public abstract Map<String, Task> getMapOfTask();

	public abstract void setMapOfObserver (final Map<String, Observer> mapOfObserver);
	public abstract void setMapOfTask (final Map<String, Task> mapOfTask);

}
