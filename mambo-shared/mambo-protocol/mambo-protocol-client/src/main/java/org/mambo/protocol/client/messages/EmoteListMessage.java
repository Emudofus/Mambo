

// Generated on 01/04/2013 14:54:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class EmoteListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5689;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte[] emoteIds;
    
    public EmoteListMessage() { }
    
    public EmoteListMessage(byte[] emoteIds) {
        this.emoteIds = emoteIds;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(emoteIds.length);
        for (byte entry : emoteIds) {
            writer.writeByte(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        emoteIds = new byte[limit];
        for (int i = 0; i < limit; i++) {
            emoteIds[i] = reader.readByte();
        }
    }
    
}
