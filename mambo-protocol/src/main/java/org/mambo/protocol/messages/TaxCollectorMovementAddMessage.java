

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeShort(informations.getTypeId());
        informations.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        informations = ProtocolTypeManager.getInstance().build(buf.readShort());
        informations.deserialize(buf);
    }
    
}
