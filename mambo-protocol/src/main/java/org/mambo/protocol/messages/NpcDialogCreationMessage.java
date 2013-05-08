

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class NpcDialogCreationMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5618;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int mapId;
    public int npcId;
    
    public NpcDialogCreationMessage() { }
    
    public NpcDialogCreationMessage(int mapId, int npcId) {
        this.mapId = mapId;
        this.npcId = npcId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(mapId);
        buf.writeInt(npcId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        mapId = buf.readInt();
        npcId = buf.readInt();
    }
    
}
