/*
 * ==== CMCore License V1.0 ====
 * 
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/3.0/ or send a letter to
 * Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 * 
 * If you do not agree to the license, please do not use this software.
 * Removing this license text is NOT allowed.
 */
package com.codiction.util;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Codiction
 */
public class CMXStream {

    private static XStream xstream;

    public static XStream getXStream() {
        if (xstream == null) {
            xstream = new XStream();
        }

        return xstream;
    }

    public static void writeData(String data, File destination) {
        try {
            if (!destination.exists()) {
                destination.createNewFile();
            }

            FileWriter fw = new FileWriter(destination.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();

        } catch (Exception e) {
        }
    }
}
