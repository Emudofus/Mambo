

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class TaxCollectorMovementMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5633;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean hireOrFire;
    public TaxCollectorBasicInformations basicInfos;
    public String playerName;
    
    public TaxCollectorMovementMessage() { }
    
    public TaxCollectorMovementMessage(boolean hireOrFire, TaxCollectorBasicInformations basicInfos, String playerName) {
        this.hireOrFire = hireOrFire;
        this.basicInfos = basicInfos;
        this.playerName = playerName;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(hireOrFire);
        basicInfos.serialize(writer);
        writer.writeString(playerName);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        hireOrFire = reader.readBoolean();
        basicInfos = new TaxCollectorBasicInformations();
        basicInfos.deserialize(reader);
        playerName = reader.readString();
    }
    
}
