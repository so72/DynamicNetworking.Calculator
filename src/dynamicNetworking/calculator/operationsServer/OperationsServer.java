/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicNetworking.calculator.operationsServer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author steffen
 */
public class OperationsServer {

    private Properties prop;
    private HTTPClassLoader classLoader;

    public OperationsServer() {
        this("OperationsServer.properties");
    }

    public OperationsServer(String propFile) {
        prop = new Properties();

        try {
            //load a properties file
            prop.load(new FileInputStream(propFile));
        } catch (IOException ex) {
            System.err.println("Failed to open properties file.");
        }
        
        //get the property value and save
        String rootDirectory = prop.getProperty("CLASS_ROOT_DIRECTORY");
        System.out.println(rootDirectory);
        String host = prop.getProperty("HOST");
        System.out.println(host);
        String port = prop.getProperty("PORT");
        System.out.println(port);
        
        if (rootDirectory == null ||
                host == null ||
                port == null)
        {
            System.err.println("Invalid properties file");
        }
        
        int portNum = Integer.parseInt(port);
        
        classLoader = new HTTPClassLoader(host, portNum);
    }

    public Object getOperation(String operationString) {
        if (operationString.equals("*")
                || operationString.equals("/")
                || operationString.equals("+")
                || operationString.equals("-")) {
            return operationString;
        } else {
            System.out.println("not an operation");
            return null;
        }
    }
}
