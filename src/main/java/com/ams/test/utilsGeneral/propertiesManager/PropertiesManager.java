package com.ams.test.utilsGeneral.propertiesManager;

import java.io.InputStream;
import java.util.Properties;
import com.ams.test.utilsGeneral.Constants;
import org.apache.log4j.Logger;

/**
 * Clase con la que se gestiona la carga de archivos properties
 * 
 */
public class PropertiesManager {

    final static Logger logger = Logger.getLogger(PropertiesManager.class);
    private static PropertiesManager instance = null;

    /**
     * M�todo que devuelve una instancia de esta clase
     * 
     * @return
     */
    public static PropertiesManager getInstance() {

	if (instance == null) {
	    instance = new PropertiesManager();
	}
	return instance;
    }

    /**
     * M�todo que carga un archivo properties en base a l nombre y lo devuelve
     * 
     * @param propertiesFileName
     *            El nombre del archivo properties a cargar
     * @return Properties El archivo properties
     */
    public Properties loadProperties(String propertiesFileName) {

	Properties properties = new Properties();
	propertiesFileName = propertiesFileName.concat(Constants.EXTENSION_PROPERTIES);
	InputStream in = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
	try {
	    properties.load(in);
	    in.close();
	} catch (Exception e) {
	    logger.error("Error properties loading", e);
	}
	return properties;
    }
}
