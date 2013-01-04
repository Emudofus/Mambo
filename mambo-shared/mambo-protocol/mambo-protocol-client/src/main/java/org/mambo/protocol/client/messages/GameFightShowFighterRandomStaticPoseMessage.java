

// Generated on 01/04/2013 14:54:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
