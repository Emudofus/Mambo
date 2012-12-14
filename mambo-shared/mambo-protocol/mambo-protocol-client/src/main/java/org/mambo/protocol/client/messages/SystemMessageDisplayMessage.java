

// Generated on 12/14/2012 18:44:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class SystemMessageDisplayMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 189;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean hangUp;
    public short msgId;
    public String[] parameters;
    
    public SystemMessageDisplayMessage() { }
    
    public SystemMessageDisplayMessage(boolean hangUp, short msgId, String[] parameters) {
        this.hangUp = hangUp;
        this.msgId = msgId;
        this.parameters = parameters;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(hangUp);
        writer.writeShort(msgId);
        writer.writeUnsignedShort(parameters.length);
        for (String entry : parameters) {
            writer.writeString(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        hangUp = reader.readBoolean();
        msgId = reader.readShort();
        if (msgId < 0)
            throw new RuntimeException("Forbidden value on msgId = " + msgId + ", it doesn't respect the following condition : msgId < 0");
        int limit = reader.readUnsignedShort();
        parameters = new String[limit];
        for (int i = 0; i < limit; i++) {
            parameters[i] = reader.readString();
        }
    }
    
}
