/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicNetworking.calculator.operationsServer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author steffen
 */
public class HTTPClassLoader extends ClassLoader {
    
    private Socket server;
    
    private String host;
    private int port;
    private String rootDirectory;
    
    private PrintWriter writer;
    private BufferedReader reader;
    private DataInputStream inputStream;
    
    private ObjectInputStream is = null;
    
	private ObjectOutputStream os = null;
    
    public HTTPClassLoader(String rootDirectory, String host, int port) {
        this.rootDirectory = rootDirectory;
        this.host = host;
        this.port = port;
    }

    @Override
    public Class findClass(String className) {
        byte[] bytes = loadClassData(className);
        return defineClass(null, bytes, 0, bytes.length);
    }

    public byte[] loadClassData(String className) {
        byte[] bytes = null;
        try {
            server = new Socket(host, port);
            
            writer = new PrintWriter(server.getOutputStream(), true);
            inputStream = new DataInputStream(server.getInputStream());
        } catch (UnknownHostException ex) {
            System.err.println("Unknown host: " + host);
        } catch (IOException ex) {
            System.err.println("IOException creating socket");
            ex.printStackTrace();
        }
        
        sendRequest(className);
        bytes = readResponse();
        
        try {
            writer.close();
            inputStream.close();
            server.close();
        } catch (IOException ex) {
            System.err.println("Failed to close stream or socket");
        }
        return bytes;
    }
    
    private void sendRequest(String className) {
        
        writer.println("GET " + rootDirectory + className + " HTTP/1.0");
        writer.println("host: " + host);
        writer.println();
    }
    
    private byte[] readResponse() {
        byte[] bytes = null;
        
        try {
            
            byte[] buffer = new byte[10000];
            
            int result = inputStream.read(buffer, 0, buffer.length);
            if (result == -1) {
                System.err.println("Failed to read input!");
                System.exit(1);
            }
            
            byte[] response = Arrays.copyOfRange(buffer, 0, result);
            String responseString = new String(response, 0, result);
            
            StringTokenizer tokenizer = new StringTokenizer(responseString);
            while (!tokenizer.nextToken().equals("Content-Length:")) {
            }
            int size = Integer.parseInt(tokenizer.nextToken());
            
            bytes = Arrays.copyOfRange(response, result - size, result);
            
            System.out.println(new String(bytes, 0, bytes.length));
        } catch (IOException ex) {
            System.err.println("Failed to readLine");
            ex.printStackTrace();
        }
        
        return bytes;
    }
}
