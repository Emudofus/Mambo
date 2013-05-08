

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SequenceEndMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 956;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short actionId;
    public int authorId;
    public byte sequenceType;
    
    public SequenceEndMessage() { }
    
    public SequenceEndMessage(short actionId, int authorId, byte sequenceType) {
        this.actionId = actionId;
        this.authorId = authorId;
        this.sequenceType = sequenceType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(actionId);
        buf.writeInt(authorId);
        buf.writeByte(sequenceType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        actionId = buf.readShort();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
        authorId = buf.readInt();
        sequenceType = buf.readByte();
    }
    
}
