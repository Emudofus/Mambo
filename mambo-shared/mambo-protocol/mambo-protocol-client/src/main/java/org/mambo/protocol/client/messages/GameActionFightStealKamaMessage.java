

// Generated on 01/04/2013 14:54:19
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightStealKamaMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5535;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short amount;
    
    public GameActionFightStealKamaMessage() { }
    
    public GameActionFightStealKamaMessage(short actionId, int sourceId, int targetId, short amount) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.amount = amount;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeShort(amount);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        amount = reader.readShort();
        if (amount < 0)
            throw new RuntimeException("Forbidden value on amount = " + amount + ", it doesn't respect the following condition : amount < 0");
    }
    
}
