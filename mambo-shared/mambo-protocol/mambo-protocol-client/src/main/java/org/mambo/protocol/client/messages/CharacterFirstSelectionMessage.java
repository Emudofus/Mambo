

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class CharacterFirstSelectionMessage extends CharacterSelectionMessage {
    public static final int MESSAGE_ID = 6084;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean doTutorial;
    
    public CharacterFirstSelectionMessage() { }
    
    public CharacterFirstSelectionMessage(int id, boolean doTutorial) {
        super(id);
        this.doTutorial = doTutorial;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeBoolean(doTutorial);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        doTutorial = reader.readBoolean();
    }
    
}
