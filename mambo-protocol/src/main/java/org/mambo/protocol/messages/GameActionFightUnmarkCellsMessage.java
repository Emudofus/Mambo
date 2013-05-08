

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightUnmarkCellsMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5570;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short markId;
    
    public GameActionFightUnmarkCellsMessage() { }
    
    public GameActionFightUnmarkCellsMessage(short actionId, int sourceId, short markId) {
        super(actionId, sourceId);
        this.markId = markId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(markId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        markId = buf.readShort();
    }
    
}
