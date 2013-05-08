

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeObjectMoveKamaMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5520;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int quantity;
    
    public ExchangeObjectMoveKamaMessage() { }
    
    public ExchangeObjectMoveKamaMessage(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(quantity);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        quantity = buf.readInt();
    }
    
}
