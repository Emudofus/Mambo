

// Generated on 11/11/2012 19:16:58
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.io.DataReaderInterface;
import org.mambo.protocol.client.io.DataWriterInterface;

public class AbstractGameActionFightTargetedAbilityMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 6118;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short destinationCellId;
    public byte critical;
    public boolean silentCast;
    
    public AbstractGameActionFightTargetedAbilityMessage() { }
    
    public AbstractGameActionFightTargetedAbilityMessage(short actionId, int sourceId, short destinationCellId, byte critical, boolean silentCast) {
        super(actionId, sourceId);
        this.destinationCellId = destinationCellId;
        this.critical = critical;
        this.silentCast = silentCast;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(destinationCellId);
        writer.writeByte(critical);
        writer.writeBoolean(silentCast);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        destinationCellId = reader.readShort();
        if (destinationCellId < -1 || destinationCellId > 559)
            throw new RuntimeException("Forbidden value on destinationCellId = " + destinationCellId + ", it doesn't respect the following condition : destinationCellId < -1 || destinationCellId > 559");
        critical = reader.readByte();
        if (critical < 0)
            throw new RuntimeException("Forbidden value on critical = " + critical + ", it doesn't respect the following condition : critical < 0");
        silentCast = reader.readBoolean();
    }
    
}
