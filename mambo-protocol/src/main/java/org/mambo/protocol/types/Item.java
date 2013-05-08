

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class Item extends NetworkType {
    public static final short TYPE_ID = 7;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    
    public Item() { }
    
    
    @Override
    public void serialize(Buffer buf) {
    }
    
    @Override
    public void deserialize(Buffer buf) {
    }
    
}
