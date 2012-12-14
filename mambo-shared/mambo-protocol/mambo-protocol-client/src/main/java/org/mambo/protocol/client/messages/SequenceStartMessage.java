

// Generated on 12/14/2012 18:44:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class SequenceStartMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 955;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte sequenceType;
    public int authorId;
    
    public SequenceStartMessage() { }
    
    public SequenceStartMessage(byte sequenceType, int authorId) {
        this.sequenceType = sequenceType;
        this.authorId = authorId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(sequenceType);
        writer.writeInt(authorId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        sequenceType = reader.readByte();
        authorId = reader.readInt();
    }
    
}
