

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(stabledMountsDescription.length);
        for (MountClientData entry : stabledMountsDescription) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        stabledMountsDescription = new MountClientData[limit];
        for (int i = 0; i < limit; i++) {
            stabledMountsDescription[i] = new MountClientData();
            stabledMountsDescription[i].deserialize(buf);
        }
    }
    
}
