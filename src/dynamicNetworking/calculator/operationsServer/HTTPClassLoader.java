/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicNetworking.calculator.operationsServer;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author steffen
 */
public class HTTPClassLoader extends ClassLoader {
    
<<<<<<< HEAD
    
    
    public Class findClass(String className)
    {
        return null;
    }
    public byte[] loadClassData(String className)
    {
        return null;
=======
    Socket server;

    public HTTPClassLoader(String host, int port) {
        try {
            server = new Socket(host, port);
        } catch (UnknownHostException ex) {
            System.err.println("Unknown host: " + host);
        } catch (IOException ex) {
            System.err.println("IOException creating socket");
        }
    }

    @Override
    public Class findClass(String className) {
        byte[] bytes = loadClassData(className);
        return defineClass(className, bytes, 0, bytes.length);
    }

    public byte[] loadClassData(String className) {
        byte[] bytes = null;
        // TODO: get bytecode from server.
        
        return bytes;
>>>>>>> 1ff05f7b594b7c5586632a1e1c2b010df6b400c7
    }
}
