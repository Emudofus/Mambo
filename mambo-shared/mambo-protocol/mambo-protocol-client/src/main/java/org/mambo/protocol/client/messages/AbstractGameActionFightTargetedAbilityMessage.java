

// Generated on 01/04/2013 14:54:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AbstractGameActionFightTargetedAbilityMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 6118;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short destinationCellId;
    public byte critical;
    public boolean silentCast;
    
    public AbstractGameActionFightTargetedAbilityMessage() { }
    
    public AbstractGameActionFightTargetedAbilityMessage(short actionId, int sourceId, int targetId, short destinationCellId, byte critical, boolean silentCast) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.destinationCellId = destinationCellId;
        this.critical = critical;
        this.silentCast = silentCast;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeShort(destinationCellId);
        writer.writeByte(critical);
        writer.writeBoolean(silentCast);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        destinationCellId = reader.readShort();
        if (destinationCellId < -1 || destinationCellId > 559)
            throw new RuntimeException("Forbidden value on destinationCellId = " + destinationCellId + ", it doesn't respect the following condition : destinationCellId < -1 || destinationCellId > 559");
        critical = reader.readByte();
        if (critical < 0)
            throw new RuntimeException("Forbidden value on critical = " + critical + ", it doesn't respect the following condition : critical < 0");
        silentCast = reader.readBoolean();
    }
    
}
