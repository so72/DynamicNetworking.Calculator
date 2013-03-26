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
 
    public static void main( String[] args )
    {
    	Properties prop = new Properties();
 
    	//try {
               //load a properties file
    	//	prop.load(new FileInputStream("OperationsServer.properties"));
 
               //get the property value and save
                System.out.println(prop.getProperty("CLASS_ROOT_DIRECTORY"));
    		System.out.println(prop.getProperty("HOST"));
    		System.out.println(prop.getProperty("PORT"));
 
    	//} //catch (IOException ex) {
    	//	ex.printStackTrace();
        //}
 
    }
    
    
    
    public Object getOperation(String operationString)
    {
        Object connection = new Object();
        switch (operationString)
        {
            case "+": connection.getClass();
                      break;
        }
        
        if(operationString.equals("*") ||
           operationString.equals("/") ||
           operationString.equals("+") ||
           operationString.equals("-"))
        {
            return operationString;
        }
        else
        {
            System.out.println("not an operation");
            return null;
        }
    }
   
}
