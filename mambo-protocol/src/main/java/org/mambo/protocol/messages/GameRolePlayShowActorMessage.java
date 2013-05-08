

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayShowActorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5632;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GameRolePlayActorInformations informations;
    
    public GameRolePlayShowActorMessage() { }
    
    public GameRolePlayShowActorMessage(GameRolePlayActorInformations informations) {
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
