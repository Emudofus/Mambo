

// Generated on 12/14/2012 18:44:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class MountEmoteIconUsedOkMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5978;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int mountId;
    public byte reactionType;
    
    public MountEmoteIconUsedOkMessage() { }
    
    public MountEmoteIconUsedOkMessage(int mountId, byte reactionType) {
        this.mountId = mountId;
        this.reactionType = reactionType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(mountId);
        writer.writeByte(reactionType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mountId = reader.readInt();
        reactionType = reader.readByte();
        if (reactionType < 0)
            throw new RuntimeException("Forbidden value on reactionType = " + reactionType + ", it doesn't respect the following condition : reactionType < 0");
    }
    
}
