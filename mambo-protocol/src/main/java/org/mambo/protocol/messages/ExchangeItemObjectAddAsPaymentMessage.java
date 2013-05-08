

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeItemObjectAddAsPaymentMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5766;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte paymentType;
    public boolean bAdd;
    public int objectToMoveId;
    public int quantity;
    
    public ExchangeItemObjectAddAsPaymentMessage() { }
    
    public ExchangeItemObjectAddAsPaymentMessage(byte paymentType, boolean bAdd, int objectToMoveId, int quantity) {
        this.paymentType = paymentType;
        this.bAdd = bAdd;
        this.objectToMoveId = objectToMoveId;
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(paymentType);
        buf.writeBoolean(bAdd);
        buf.writeInt(objectToMoveId);
        buf.writeInt(quantity);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        paymentType = buf.readByte();
        bAdd = buf.readBoolean();
        objectToMoveId = buf.readInt();
        if (objectToMoveId < 0)
            throw new RuntimeException("Forbidden value on objectToMoveId = " + objectToMoveId + ", it doesn't respect the following condition : objectToMoveId < 0");
        quantity = buf.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
