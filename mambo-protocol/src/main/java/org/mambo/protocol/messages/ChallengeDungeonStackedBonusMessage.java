

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeInt(dungeonId);
        buf.writeInt(xpBonus);
        buf.writeInt(dropBonus);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        dungeonId = buf.readInt();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        xpBonus = buf.readInt();
        if (xpBonus < 0)
            throw new RuntimeException("Forbidden value on xpBonus = " + xpBonus + ", it doesn't respect the following condition : xpBonus < 0");
        dropBonus = buf.readInt();
        if (dropBonus < 0)
            throw new RuntimeException("Forbidden value on dropBonus = " + dropBonus + ", it doesn't respect the following condition : dropBonus < 0");
    }
    
}
