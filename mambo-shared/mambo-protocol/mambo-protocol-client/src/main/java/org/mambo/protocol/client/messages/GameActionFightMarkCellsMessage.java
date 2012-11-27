

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.core.io.*;

public class GameActionFightMarkCellsMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5540;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GameActionMark mark;
    
    public GameActionFightMarkCellsMessage() { }
    
    public GameActionFightMarkCellsMessage(short actionId, int sourceId, GameActionMark mark) {
        super(actionId, sourceId);
        this.mark = mark;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        mark.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        mark = new GameActionMark();
        mark.deserialize(reader);
    }
    
}
