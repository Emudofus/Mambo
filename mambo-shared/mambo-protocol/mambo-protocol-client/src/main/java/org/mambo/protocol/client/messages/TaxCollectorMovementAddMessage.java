

// Generated on 11/11/2012 19:17:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class TaxCollectorMovementAddMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5917;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public TaxCollectorInformations informations;
    
    public TaxCollectorMovementAddMessage() { }
    
    public TaxCollectorMovementAddMessage(TaxCollectorInformations informations) {
        this.informations = informations;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(informations.getTypeId());
        informations.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        informations = ProtocolTypeManager.getInstance().build(reader.readShort(), TaxCollectorInformations.class);
        informations.deserialize(reader);
    }
    
}
