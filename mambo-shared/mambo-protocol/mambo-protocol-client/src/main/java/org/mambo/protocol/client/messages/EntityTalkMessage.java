

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class EntityTalkMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6110;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int entityId;
    public short textId;
    public String[] parameters;
    
    public EntityTalkMessage() { }
    
    public EntityTalkMessage(int entityId, short textId, String[] parameters) {
        this.entityId = entityId;
        this.textId = textId;
        this.parameters = parameters;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(entityId);
        writer.writeShort(textId);
        writer.writeUnsignedShort(parameters.length);
        for (String entry : parameters) {
            writer.writeString(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        entityId = reader.readInt();
        textId = reader.readShort();
        if (textId < 0)
            throw new RuntimeException("Forbidden value on textId = " + textId + ", it doesn't respect the following condition : textId < 0");
        int limit = reader.readUnsignedShort();
        parameters = new String[limit];
        for (int i = 0; i < limit; i++) {
            parameters[i] = reader.readString();
        }
    }
    
}
