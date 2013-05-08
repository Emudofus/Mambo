

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        stats.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        stats = new CharacterCharacteristicsInformations();
        stats.deserialize(buf);
    }
    
}
