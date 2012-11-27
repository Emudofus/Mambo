

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterStatsListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 500;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public CharacterCharacteristicsInformations stats;
    
    public CharacterStatsListMessage() { }
    
    public CharacterStatsListMessage(CharacterCharacteristicsInformations stats) {
        this.stats = stats;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        stats.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        stats = new CharacterCharacteristicsInformations();
        stats.deserialize(reader);
    }
    
}
