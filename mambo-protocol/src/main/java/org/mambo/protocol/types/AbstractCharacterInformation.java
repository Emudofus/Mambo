

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AbstractCharacterInformation extends NetworkType {
    public static final short TYPE_ID = 400;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    
    public AbstractCharacterInformation() { }
    
    public AbstractCharacterInformation(int id) {
        this.id = id;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(id);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
    }
    
}
