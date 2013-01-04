

// Generated on 01/04/2013 14:54:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ShowCellSpectatorMessage extends ShowCellMessage {
    public static final int MESSAGE_ID = 6158;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String playerName;
    
    public ShowCellSpectatorMessage() { }
    
    public ShowCellSpectatorMessage(int sourceId, short cellId, String playerName) {
        super(sourceId, cellId);
        this.playerName = playerName;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(playerName);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        playerName = reader.readString();
    }
    
}
