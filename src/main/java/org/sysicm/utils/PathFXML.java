package org.sysicm.utils;

import java.nio.file.Paths;

public class PathFXML {
    public static String phathBase(){
        return Paths.get("src/main/java/org/sysicm/view").toAbsolutePath().toString();
    }
}
