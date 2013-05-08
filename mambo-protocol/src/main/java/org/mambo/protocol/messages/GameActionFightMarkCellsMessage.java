

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        mark.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        mark = new GameActionMark();
        mark.deserialize(buf);
    }
    
}
