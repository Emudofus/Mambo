

// Generated on 12/14/2012 18:44:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ServerSettingsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6340;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String lang;
    public byte community;
    
    public ServerSettingsMessage() { }
    
    public ServerSettingsMessage(String lang, byte community) {
        this.lang = lang;
        this.community = community;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(lang);
        writer.writeByte(community);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        lang = reader.readString();
        community = reader.readByte();
        if (community < 0)
            throw new RuntimeException("Forbidden value on community = " + community + ", it doesn't respect the following condition : community < 0");
    }
    
}
