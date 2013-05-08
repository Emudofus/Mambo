

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(targetId);
        buf.writeShort(destinationCellId);
        buf.writeByte(critical);
        buf.writeBoolean(silentCast);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        targetId = buf.readInt();
        destinationCellId = buf.readShort();
        if (destinationCellId < -1 || destinationCellId > 559)
            throw new RuntimeException("Forbidden value on destinationCellId = " + destinationCellId + ", it doesn't respect the following condition : destinationCellId < -1 || destinationCellId > 559");
        critical = buf.readByte();
        if (critical < 0)
            throw new RuntimeException("Forbidden value on critical = " + critical + ", it doesn't respect the following condition : critical < 0");
        silentCast = buf.readBoolean();
    }
    
}
