

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(fights.length);
        for (FightExternalInformations entry : fights) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        fights = new FightExternalInformations[limit];
        for (int i = 0; i < limit; i++) {
            fights[i] = new FightExternalInformations();
            fights[i].deserialize(reader);
        }
    }
    
}
