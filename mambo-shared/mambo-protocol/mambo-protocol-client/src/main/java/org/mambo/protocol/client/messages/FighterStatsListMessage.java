

// Generated on 12/14/2012 18:44:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FighterStatsListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6322;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public CharacterCharacteristicsInformations stats;
    
    public FighterStatsListMessage() { }
    
    public FighterStatsListMessage(CharacterCharacteristicsInformations stats) {
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
