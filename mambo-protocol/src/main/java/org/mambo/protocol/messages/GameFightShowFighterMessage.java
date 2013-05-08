

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightShowFighterMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5864;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GameFightFighterInformations informations;
    
    public GameFightShowFighterMessage() { }
    
    public GameFightShowFighterMessage(GameFightFighterInformations informations) {
        this.informations = informations;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(informations.getTypeId());
        informations.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        informations = ProtocolTypeManager.getInstance().build(buf.readShort());
        informations.deserialize(buf);
    }
    
}
