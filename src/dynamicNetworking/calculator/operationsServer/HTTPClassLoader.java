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
    }
}
