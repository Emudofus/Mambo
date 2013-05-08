

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(msgId);
        buf.writeUInt(timeStamp);
        buf.writeString(owner);
        buf.writeUInt(objectGenericId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        msgId = buf.readShort();
        if (msgId < 0)
            throw new RuntimeException("Forbidden value on msgId = " + msgId + ", it doesn't respect the following condition : msgId < 0");
        timeStamp = buf.readUInt();
        if (timeStamp < 0 || timeStamp > 4294967295L)
            throw new RuntimeException("Forbidden value on timeStamp = " + timeStamp + ", it doesn't respect the following condition : timeStamp < 0 || timeStamp > 4294967295L");
        owner = buf.readString();
        objectGenericId = buf.readUInt();
        if (objectGenericId < 0 || objectGenericId > 4294967295L)
            throw new RuntimeException("Forbidden value on objectGenericId = " + objectGenericId + ", it doesn't respect the following condition : objectGenericId < 0 || objectGenericId > 4294967295L");
    }
    
}
