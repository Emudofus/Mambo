

// Generated on 12/14/2012 18:44:05
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameEntityDispositionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5693;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public IdentifiedEntityDispositionInformations disposition;
    
    public GameEntityDispositionMessage() { }
    
    public GameEntityDispositionMessage(IdentifiedEntityDispositionInformations disposition) {
        this.disposition = disposition;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        disposition.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        disposition = new IdentifiedEntityDispositionInformations();
        disposition.deserialize(reader);
    }
    
}
