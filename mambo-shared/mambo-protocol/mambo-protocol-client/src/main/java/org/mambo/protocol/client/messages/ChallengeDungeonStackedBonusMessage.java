

// Generated on 01/04/2013 14:54:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ChallengeDungeonStackedBonusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6151;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int dungeonId;
    public int xpBonus;
    public int dropBonus;
    
    public ChallengeDungeonStackedBonusMessage() { }
    
    public ChallengeDungeonStackedBonusMessage(int dungeonId, int xpBonus, int dropBonus) {
        this.dungeonId = dungeonId;
        this.xpBonus = xpBonus;
        this.dropBonus = dropBonus;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(dungeonId);
        writer.writeInt(xpBonus);
        writer.writeInt(dropBonus);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        dungeonId = reader.readInt();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        xpBonus = reader.readInt();
        if (xpBonus < 0)
            throw new RuntimeException("Forbidden value on xpBonus = " + xpBonus + ", it doesn't respect the following condition : xpBonus < 0");
        dropBonus = reader.readInt();
        if (dropBonus < 0)
            throw new RuntimeException("Forbidden value on dropBonus = " + dropBonus + ", it doesn't respect the following condition : dropBonus < 0");
    }
    
}
