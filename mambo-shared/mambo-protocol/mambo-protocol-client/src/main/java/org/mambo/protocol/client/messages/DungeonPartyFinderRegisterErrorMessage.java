

// Generated on 01/04/2013 14:54:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class DungeonPartyFinderRegisterErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6243;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public DungeonPartyFinderRegisterErrorMessage() { }
    
    
    @Override
    public void serialize(DataWriterInterface writer) {
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
    }
    
}
