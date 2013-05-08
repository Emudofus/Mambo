

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayRemoveChallengeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 300;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    
    public GameRolePlayRemoveChallengeMessage() { }
    
    public GameRolePlayRemoveChallengeMessage(int fightId) {
        this.fightId = fightId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(fightId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readInt();
    }
    
}
