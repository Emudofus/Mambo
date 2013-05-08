

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(actorIds.length);
        for (int entry : actorIds) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        actorIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            actorIds[i] = buf.readInt();
        }
    }
    
}
