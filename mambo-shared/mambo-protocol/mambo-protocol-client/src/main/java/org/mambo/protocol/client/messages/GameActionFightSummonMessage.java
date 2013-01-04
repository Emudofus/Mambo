

// Generated on 01/04/2013 14:54:19
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(summon.getTypeId());
        summon.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        summon = ProtocolTypeManager.getInstance().build(reader.readShort(), GameFightFighterInformations.class);
        summon.deserialize(reader);
    }
    
}
