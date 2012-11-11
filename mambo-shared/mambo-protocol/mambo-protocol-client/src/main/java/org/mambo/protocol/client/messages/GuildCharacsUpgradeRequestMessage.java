

// Generated on 11/11/2012 19:17:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildCharacsUpgradeRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5706;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte charaTypeTarget;
    
    public GuildCharacsUpgradeRequestMessage() { }
    
    public GuildCharacsUpgradeRequestMessage(byte charaTypeTarget) {
        this.charaTypeTarget = charaTypeTarget;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(charaTypeTarget);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        charaTypeTarget = reader.readByte();
        if (charaTypeTarget < 0)
            throw new RuntimeException("Forbidden value on charaTypeTarget = " + charaTypeTarget + ", it doesn't respect the following condition : charaTypeTarget < 0");
    }
    
}
