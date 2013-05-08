

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TextInformationMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 780;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte msgType;
    public short msgId;
    public String[] parameters;
    
    public TextInformationMessage() { }
    
    public TextInformationMessage(byte msgType, short msgId, String[] parameters) {
        this.msgType = msgType;
        this.msgId = msgId;
        this.parameters = parameters;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(msgType);
        buf.writeShort(msgId);
        buf.writeUShort(parameters.length);
        for (String entry : parameters) {
            buf.writeString(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        msgType = buf.readByte();
        if (msgType < 0)
            throw new RuntimeException("Forbidden value on msgType = " + msgType + ", it doesn't respect the following condition : msgType < 0");
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
