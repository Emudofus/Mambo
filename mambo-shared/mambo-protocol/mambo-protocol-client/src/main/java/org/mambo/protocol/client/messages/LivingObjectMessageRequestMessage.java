

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class LivingObjectMessageRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6066;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short msgId;
    public String[] parameters;
    public long livingObject;
    
    public LivingObjectMessageRequestMessage() { }
    
    public LivingObjectMessageRequestMessage(short msgId, String[] parameters, long livingObject) {
        this.msgId = msgId;
        this.parameters = parameters;
        this.livingObject = livingObject;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(msgId);
        writer.writeUnsignedShort(parameters.length);
        for (String entry : parameters) {
            writer.writeString(entry);
        }
        writer.writeUnsignedInt(livingObject);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        msgId = reader.readShort();
        if (msgId < 0)
            throw new RuntimeException("Forbidden value on msgId = " + msgId + ", it doesn't respect the following condition : msgId < 0");
        int limit = reader.readUnsignedShort();
        parameters = new String[limit];
        for (int i = 0; i < limit; i++) {
            parameters[i] = reader.readString();
        }
        livingObject = reader.readUnsignedInt();
        if (livingObject < 0 || livingObject > 4294967295L)
            throw new RuntimeException("Forbidden value on livingObject = " + livingObject + ", it doesn't respect the following condition : livingObject < 0 || livingObject > 4294967295L");
    }
    
}
