

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(dispositions.length);
        for (IdentifiedEntityDispositionInformations entry : dispositions) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        dispositions = new IdentifiedEntityDispositionInformations[limit];
        for (int i = 0; i < limit; i++) {
            dispositions[i] = new IdentifiedEntityDispositionInformations();
            dispositions[i].deserialize(buf);
        }
    }
    
}
