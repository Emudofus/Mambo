

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(emoteIds.length);
        for (byte entry : emoteIds) {
            buf.writeByte(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        emoteIds = new byte[limit];
        for (int i = 0; i < limit; i++) {
            emoteIds[i] = buf.readByte();
        }
    }
    
}
