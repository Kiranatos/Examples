package junk.font;

/*
 * @(#)DemoFonts.java 1.17 06/08/29
 * 
 * Copyright (c) 2006 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 * 
 * -Redistribution in binary form must reproduce the above copyright notice, 
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of contributors may 
 * be used to endorse or promote products derived from this software without 
 * specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL 
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MIDROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST 
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, 
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY 
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, 
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */

/*
 * @(#)DemoFonts.java 1.17 06/08/29
 */

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A cache of the dynamically loaded fonts found in the fonts directory.
 */
public class DemoFonts {

  // Prepare a static "cache" mapping font names to Font objects.
  private static String[] names = { "Teddy_Bear.ttf" };

  private static Map<String, Font> cache = new ConcurrentHashMap<String, Font>(names.length);
  
  static {
    for (String name : names) {
      cache.put(name, getFont(name));
    }
  }

  public static Font getFont(String name) {
    Font font = null;
    if (cache != null) {
      if ((font = cache.get(name)) != null) {
        return font;
      }
    }
    String fName = "F:\\Teddy_Bear.ttf";
    try {
        /*BufferedReader readerFile = new BufferedReader(new FileReader(fName));	
        String s = readerFile.readLine(); 
        while ( s != null ) 
        {
            s = readerFile.readLine(); 
            System.out.print(s+" ");
        }*/

        System.out.println(new File(fName).exists());
        
      InputStream is = DemoFonts.class.getResourceAsStream(fName);
      font = Font.createFont(Font.TRUETYPE_FONT, is);
    } catch (Exception ex) {
      ex.printStackTrace();
      System.err.println(fName + " not loaded.  Using serif font.");
      font = new Font("serif", Font.PLAIN, 24);
    }
    return font;
  }
  
    public static void main(String[] args) {
        System.out.println("Start");
        
        Iterator<Map.Entry<String, Font>> it = cache.entrySet().iterator();
        while ( it.hasNext() ) {
            Map.Entry<String, Font> pair = it.next();
            String k = pair.getKey();
            System.out.println(k);
            Font v = pair.getValue(); 
            System.out.println(v);
        }


    }
}
