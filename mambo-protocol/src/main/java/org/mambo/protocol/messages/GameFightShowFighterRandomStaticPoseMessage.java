

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightShowFighterRandomStaticPoseMessage extends GameFightShowFighterMessage {
    public static final int MESSAGE_ID = 6218;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public GameFightShowFighterRandomStaticPoseMessage() { }
    
    public GameFightShowFighterRandomStaticPoseMessage(GameFightFighterInformations informations) {
        super(informations);
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
