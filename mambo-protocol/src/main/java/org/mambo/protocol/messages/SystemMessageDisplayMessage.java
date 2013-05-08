

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeBoolean(hangUp);
        buf.writeShort(msgId);
        buf.writeUShort(parameters.length);
        for (String entry : parameters) {
            buf.writeString(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        hangUp = buf.readBoolean();
        msgId = buf.readShort();
        if (msgId < 0)
            throw new RuntimeException("Forbidden value on msgId = " + msgId + ", it doesn't respect the following condition : msgId < 0");
        int limit = buf.readUShort();
        parameters = new String[limit];
        for (int i = 0; i < limit; i++) {
            parameters[i] = buf.readString();
        }
    }
    
}
