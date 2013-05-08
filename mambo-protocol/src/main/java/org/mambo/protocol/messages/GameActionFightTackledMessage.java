

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightTackledMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 1004;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] tacklersIds;
    
    public GameActionFightTackledMessage() { }
    
    public GameActionFightTackledMessage(short actionId, int sourceId, int[] tacklersIds) {
        super(actionId, sourceId);
        this.tacklersIds = tacklersIds;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(tacklersIds.length);
        for (int entry : tacklersIds) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        tacklersIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            tacklersIds[i] = buf.readInt();
        }
    }
    
}
