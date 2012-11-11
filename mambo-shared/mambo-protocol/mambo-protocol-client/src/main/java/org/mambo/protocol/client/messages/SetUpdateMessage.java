

// Generated on 11/11/2012 19:17:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(setId);
        writer.writeUnsignedShort(setObjects.length);
        for (short entry : setObjects) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(setEffects.length);
        for (ObjectEffect entry : setEffects) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        setId = reader.readShort();
        if (setId < 0)
            throw new RuntimeException("Forbidden value on setId = " + setId + ", it doesn't respect the following condition : setId < 0");
        int limit = reader.readUnsignedShort();
        setObjects = new short[limit];
        for (int i = 0; i < limit; i++) {
            setObjects[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        setEffects = new ObjectEffect[limit];
        for (int i = 0; i < limit; i++) {
            setEffects[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), ObjectEffect.class);
            setEffects[i].deserialize(reader);
        }
    }
    
}
