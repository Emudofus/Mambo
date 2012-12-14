

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeStartOkMountWithOutPaddockMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5991;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public MountClientData[] stabledMountsDescription;
    
    public ExchangeStartOkMountWithOutPaddockMessage() { }
    
    public ExchangeStartOkMountWithOutPaddockMessage(MountClientData[] stabledMountsDescription) {
        this.stabledMountsDescription = stabledMountsDescription;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(stabledMountsDescription.length);
        for (MountClientData entry : stabledMountsDescription) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        stabledMountsDescription = new MountClientData[limit];
        for (int i = 0; i < limit; i++) {
            stabledMountsDescription[i] = new MountClientData();
            stabledMountsDescription[i].deserialize(reader);
        }
    }
    
}
