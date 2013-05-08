

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightSummonMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5825;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GameFightFighterInformations summon;
    
    public GameActionFightSummonMessage() { }
    
    public GameActionFightSummonMessage(short actionId, int sourceId, GameFightFighterInformations summon) {
        super(actionId, sourceId);
        this.summon = summon;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(summon.getTypeId());
        summon.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        summon = ProtocolTypeManager.getInstance().build(buf.readShort());
        summon.deserialize(buf);
    }
    
}
