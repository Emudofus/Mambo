

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeBoolean(deadOrAlive);
        basicInfos.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        deadOrAlive = buf.readBoolean();
        basicInfos = new TaxCollectorBasicInformations();
        basicInfos.deserialize(buf);
    }
    
}
