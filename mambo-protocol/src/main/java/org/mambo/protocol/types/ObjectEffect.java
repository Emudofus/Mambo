

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectEffect extends NetworkType {
    public static final short TYPE_ID = 76;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short actionId;
    
    public ObjectEffect() { }
    
    public ObjectEffect(short actionId) {
        this.actionId = actionId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(actionId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        actionId = buf.readShort();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
    }
    
}
