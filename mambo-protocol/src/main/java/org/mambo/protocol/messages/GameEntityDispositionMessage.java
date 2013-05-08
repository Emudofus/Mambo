

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        disposition.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        disposition = new IdentifiedEntityDispositionInformations();
        disposition.deserialize(buf);
    }
    
}
