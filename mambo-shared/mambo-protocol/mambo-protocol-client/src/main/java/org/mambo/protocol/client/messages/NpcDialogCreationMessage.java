

// Generated on 12/14/2012 18:44:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(mapId);
        writer.writeInt(npcId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mapId = reader.readInt();
        npcId = reader.readInt();
    }
    
}
