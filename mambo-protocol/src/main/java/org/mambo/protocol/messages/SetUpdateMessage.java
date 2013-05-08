

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SetUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5503;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short setId;
    public short[] setObjects;
    public ObjectEffect[] setEffects;
    
    public SetUpdateMessage() { }
    
    public SetUpdateMessage(short setId, short[] setObjects, ObjectEffect[] setEffects) {
        this.setId = setId;
        this.setObjects = setObjects;
        this.setEffects = setEffects;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(setId);
        buf.writeUShort(setObjects.length);
        for (short entry : setObjects) {
            buf.writeShort(entry);
        }
        buf.writeUShort(setEffects.length);
        for (ObjectEffect entry : setEffects) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        setId = buf.readShort();
        if (setId < 0)
            throw new RuntimeException("Forbidden value on setId = " + setId + ", it doesn't respect the following condition : setId < 0");
        int limit = buf.readUShort();
        setObjects = new short[limit];
        for (int i = 0; i < limit; i++) {
            setObjects[i] = buf.readShort();
        }
        limit = buf.readUShort();
        setEffects = new ObjectEffect[limit];
        for (int i = 0; i < limit; i++) {
            setEffects[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            setEffects[i].deserialize(buf);
        }
    }
    
}
