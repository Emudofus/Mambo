

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        commonsInfos.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        commonsInfos = new FightCommonInformations();
        commonsInfos.deserialize(reader);
    }
    
}
