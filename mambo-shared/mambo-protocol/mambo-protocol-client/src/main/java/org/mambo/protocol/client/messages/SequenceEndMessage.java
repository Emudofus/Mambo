

// Generated on 01/04/2013 14:54:20
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(actionId);
        writer.writeInt(authorId);
        writer.writeByte(sequenceType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        actionId = reader.readShort();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
        authorId = reader.readInt();
        sequenceType = reader.readByte();
    }
    
}
