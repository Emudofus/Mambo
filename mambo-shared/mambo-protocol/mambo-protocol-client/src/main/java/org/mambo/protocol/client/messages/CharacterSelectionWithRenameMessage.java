

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class CharacterSelectionWithRenameMessage extends CharacterSelectionMessage {
    public static final int MESSAGE_ID = 6121;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    
    public CharacterSelectionWithRenameMessage() { }
    
    public CharacterSelectionWithRenameMessage(int id, String name) {
        super(id);
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
