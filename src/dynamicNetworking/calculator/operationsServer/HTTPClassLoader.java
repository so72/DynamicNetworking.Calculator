/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicNetworking.calculator.operationsServer;

import java.net.Socket;

/**
 *
 * @author steffen
 */
public class HTTPClassLoader extends ClassLoader {
    
    Socket server;

    public HTTPClassLoader(Socket server) {
        this.server = server;
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
