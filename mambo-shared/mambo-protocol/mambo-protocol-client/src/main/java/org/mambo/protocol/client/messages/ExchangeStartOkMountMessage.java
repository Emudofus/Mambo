

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeStartOkMountMessage extends ExchangeStartOkMountWithOutPaddockMessage {
    public static final int MESSAGE_ID = 5979;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public MountClientData[] paddockedMountsDescription;
    
    public ExchangeStartOkMountMessage() { }
    
    public ExchangeStartOkMountMessage(MountClientData[] stabledMountsDescription, MountClientData[] paddockedMountsDescription) {
        super(stabledMountsDescription);
        this.paddockedMountsDescription = paddockedMountsDescription;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(paddockedMountsDescription.length);
        for (MountClientData entry : paddockedMountsDescription) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        paddockedMountsDescription = new MountClientData[limit];
        for (int i = 0; i < limit; i++) {
            paddockedMountsDescription[i] = new MountClientData();
            paddockedMountsDescription[i].deserialize(reader);
        }
    }
    
}
