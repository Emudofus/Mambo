

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayArenaFightAnswerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6279;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    public boolean accept;
    
    public GameRolePlayArenaFightAnswerMessage() { }
    
    public GameRolePlayArenaFightAnswerMessage(int fightId, boolean accept) {
        this.fightId = fightId;
        this.accept = accept;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(fightId);
        buf.writeBoolean(accept);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readInt();
        accept = buf.readBoolean();
    }
    
}
