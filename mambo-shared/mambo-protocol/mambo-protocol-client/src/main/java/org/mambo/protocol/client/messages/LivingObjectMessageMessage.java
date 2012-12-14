

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class LivingObjectMessageMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6065;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short msgId;
    public long timeStamp;
    public String owner;
    public long objectGenericId;
    
    public LivingObjectMessageMessage() { }
    
    public LivingObjectMessageMessage(short msgId, long timeStamp, String owner, long objectGenericId) {
        this.msgId = msgId;
        this.timeStamp = timeStamp;
        this.owner = owner;
        this.objectGenericId = objectGenericId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(msgId);
        writer.writeUnsignedInt(timeStamp);
        writer.writeString(owner);
        writer.writeUnsignedInt(objectGenericId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        msgId = reader.readShort();
        if (msgId < 0)
            throw new RuntimeException("Forbidden value on msgId = " + msgId + ", it doesn't respect the following condition : msgId < 0");
        timeStamp = reader.readUnsignedInt();
        if (timeStamp < 0 || timeStamp > 4294967295L)
            throw new RuntimeException("Forbidden value on timeStamp = " + timeStamp + ", it doesn't respect the following condition : timeStamp < 0 || timeStamp > 4294967295L");
        owner = reader.readString();
        objectGenericId = reader.readUnsignedInt();
        if (objectGenericId < 0 || objectGenericId > 4294967295L)
            throw new RuntimeException("Forbidden value on objectGenericId = " + objectGenericId + ", it doesn't respect the following condition : objectGenericId < 0 || objectGenericId > 4294967295L");
    }
    
}
