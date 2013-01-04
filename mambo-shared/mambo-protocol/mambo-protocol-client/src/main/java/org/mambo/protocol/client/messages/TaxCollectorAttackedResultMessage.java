

// Generated on 01/04/2013 14:54:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class TaxCollectorAttackedResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5635;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean deadOrAlive;
    public TaxCollectorBasicInformations basicInfos;
    
    public TaxCollectorAttackedResultMessage() { }
    
    public TaxCollectorAttackedResultMessage(boolean deadOrAlive, TaxCollectorBasicInformations basicInfos) {
        this.deadOrAlive = deadOrAlive;
        this.basicInfos = basicInfos;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(deadOrAlive);
        basicInfos.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        deadOrAlive = reader.readBoolean();
        basicInfos = new TaxCollectorBasicInformations();
        basicInfos.deserialize(reader);
    }
    
}
