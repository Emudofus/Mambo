

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(paddockedMountsDescription.length);
        for (MountClientData entry : paddockedMountsDescription) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        paddockedMountsDescription = new MountClientData[limit];
        for (int i = 0; i < limit; i++) {
            paddockedMountsDescription[i] = new MountClientData();
            paddockedMountsDescription[i].deserialize(buf);
        }
    }
    
}
