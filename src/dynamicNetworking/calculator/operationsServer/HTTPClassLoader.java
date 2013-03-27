/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicNetworking.calculator.operationsServer;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author steffen
 */
public class HTTPClassLoader extends ClassLoader {
    
    private Socket server;
    
    private String rootDirectory;
    
    private ObjectInputStream is = null;
    
	private ObjectOutputStream os = null;
    
    public HTTPClassLoader(String rootDirectory, String host, int port) {
        this.rootDirectory = rootDirectory;
        
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
        
        os.reset();
        os.writeObject(new ResourceRequest(className, "CLASS"));
        os.flush();
        
        ResourcePacket resourcePacket = (ResourcePacket) is.readObject();
        bytes = resourcePacket.getResourceBytes();
        
        return bytes;
        
    }
}
