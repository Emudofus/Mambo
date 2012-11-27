

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameEntitiesDispositionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5696;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public IdentifiedEntityDispositionInformations[] dispositions;
    
    public GameEntitiesDispositionMessage() { }
    
    public GameEntitiesDispositionMessage(IdentifiedEntityDispositionInformations[] dispositions) {
        this.dispositions = dispositions;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(dispositions.length);
        for (IdentifiedEntityDispositionInformations entry : dispositions) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        dispositions = new IdentifiedEntityDispositionInformations[limit];
        for (int i = 0; i < limit; i++) {
            dispositions[i] = new IdentifiedEntityDispositionInformations();
            dispositions[i].deserialize(reader);
        }
    }
    
}
