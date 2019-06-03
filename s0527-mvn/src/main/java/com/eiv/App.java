package com.eiv;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       App app = new App();
       app.run(args[0]);
    }
    
    public void run(String msg) {
    	System.out.println("Mensaje original: " + msg);
    	System.out.println("Hash del mensaje: " + DigestUtils.sha256Hex(msg));
    }
    
}
