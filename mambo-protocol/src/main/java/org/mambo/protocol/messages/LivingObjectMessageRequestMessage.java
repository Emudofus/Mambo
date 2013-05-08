

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(msgId);
        buf.writeUShort(parameters.length);
        for (String entry : parameters) {
            buf.writeString(entry);
        }
        buf.writeUInt(livingObject);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        msgId = buf.readShort();
        if (msgId < 0)
            throw new RuntimeException("Forbidden value on msgId = " + msgId + ", it doesn't respect the following condition : msgId < 0");
        int limit = buf.readUShort();
        parameters = new String[limit];
        for (int i = 0; i < limit; i++) {
            parameters[i] = buf.readString();
        }
        livingObject = buf.readUInt();
        if (livingObject < 0 || livingObject > 4294967295L)
            throw new RuntimeException("Forbidden value on livingObject = " + livingObject + ", it doesn't respect the following condition : livingObject < 0 || livingObject > 4294967295L");
    }
    
}
