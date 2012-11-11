

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class EmotePlayMassiveMessage extends EmotePlayAbstractMessage {
    public static final int MESSAGE_ID = 5691;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] actorIds;
    
    public EmotePlayMassiveMessage() { }
    
    public EmotePlayMassiveMessage(byte emoteId, double emoteStartTime, int[] actorIds) {
        super(emoteId, emoteStartTime);
        this.actorIds = actorIds;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(actorIds.length);
        for (int entry : actorIds) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        actorIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            actorIds[i] = reader.readInt();
        }
    }
    
}
