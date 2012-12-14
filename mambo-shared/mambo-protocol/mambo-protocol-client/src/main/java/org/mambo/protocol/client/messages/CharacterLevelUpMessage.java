

// Generated on 12/14/2012 18:44:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterLevelUpMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5670;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short newLevel;
    
    public CharacterLevelUpMessage() { }
    
    public CharacterLevelUpMessage(short newLevel) {
        this.newLevel = newLevel;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedByte(newLevel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        newLevel = reader.readUnsignedByte();
        if (newLevel < 2 || newLevel > 200)
            throw new RuntimeException("Forbidden value on newLevel = " + newLevel + ", it doesn't respect the following condition : newLevel < 2 || newLevel > 200");
    }
    
}
