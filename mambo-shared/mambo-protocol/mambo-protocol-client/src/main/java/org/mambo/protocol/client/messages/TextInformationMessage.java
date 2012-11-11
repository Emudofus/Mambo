

// Generated on 11/11/2012 19:16:59
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(msgType);
        writer.writeShort(msgId);
        writer.writeUnsignedShort(parameters.length);
        for (String entry : parameters) {
            writer.writeString(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        msgType = reader.readByte();
        if (msgType < 0)
            throw new RuntimeException("Forbidden value on msgType = " + msgType + ", it doesn't respect the following condition : msgType < 0");
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
