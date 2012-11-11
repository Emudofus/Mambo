

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class CharacterReplayWithRenameRequestMessage extends CharacterReplayRequestMessage {
    public static final int MESSAGE_ID = 6122;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    
    public CharacterReplayWithRenameRequestMessage() { }
    
    public CharacterReplayWithRenameRequestMessage(int characterId, String name) {
        super(characterId);
        this.name = name;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(name);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        name = reader.readString();
    }
    
}
