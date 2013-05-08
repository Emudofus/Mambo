

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeByte(sequenceType);
        buf.writeInt(authorId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        sequenceType = buf.readByte();
        authorId = buf.readInt();
    }
    
}
