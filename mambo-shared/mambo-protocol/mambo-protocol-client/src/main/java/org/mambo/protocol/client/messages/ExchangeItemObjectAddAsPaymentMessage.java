

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(paymentType);
        writer.writeBoolean(bAdd);
        writer.writeInt(objectToMoveId);
        writer.writeInt(quantity);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        paymentType = reader.readByte();
        bAdd = reader.readBoolean();
        objectToMoveId = reader.readInt();
        if (objectToMoveId < 0)
            throw new RuntimeException("Forbidden value on objectToMoveId = " + objectToMoveId + ", it doesn't respect the following condition : objectToMoveId < 0");
        quantity = reader.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
