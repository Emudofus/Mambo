

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayShowChallengeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 301;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public FightCommonInformations commonsInfos;
    
    public GameRolePlayShowChallengeMessage() { }
    
    public GameRolePlayShowChallengeMessage(FightCommonInformations commonsInfos) {
        this.commonsInfos = commonsInfos;
    }
    
    @Override
    public void serialize(Buffer buf) {
        commonsInfos.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        commonsInfos = new FightCommonInformations();
        commonsInfos.deserialize(buf);
    }
    
}
