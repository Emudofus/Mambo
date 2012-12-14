

// Generated on 12/14/2012 18:44:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
