

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeInt(entityId);
        buf.writeShort(textId);
        buf.writeUShort(parameters.length);
        for (String entry : parameters) {
            buf.writeString(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        entityId = buf.readInt();
        textId = buf.readShort();
        if (textId < 0)
            throw new RuntimeException("Forbidden value on textId = " + textId + ", it doesn't respect the following condition : textId < 0");
        int limit = buf.readUShort();
        parameters = new String[limit];
        for (int i = 0; i < limit; i++) {
            parameters[i] = buf.readString();
        }
    }
    
}
