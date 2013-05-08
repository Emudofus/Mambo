

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapRunningFightListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5743;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public FightExternalInformations[] fights;
    
    public MapRunningFightListMessage() { }
    
    public MapRunningFightListMessage(FightExternalInformations[] fights) {
        this.fights = fights;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(fights.length);
        for (FightExternalInformations entry : fights) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        fights = new FightExternalInformations[limit];
        for (int i = 0; i < limit; i++) {
            fights[i] = new FightExternalInformations();
            fights[i].deserialize(buf);
        }
    }
    
}
