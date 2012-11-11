

// Generated on 11/11/2012 19:17:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PrismBalanceResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5841;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte totalBalanceValue;
    public byte subAreaBalanceValue;
    
    public PrismBalanceResultMessage() { }
    
    public PrismBalanceResultMessage(byte totalBalanceValue, byte subAreaBalanceValue) {
        this.totalBalanceValue = totalBalanceValue;
        this.subAreaBalanceValue = subAreaBalanceValue;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(totalBalanceValue);
        writer.writeByte(subAreaBalanceValue);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        totalBalanceValue = reader.readByte();
        if (totalBalanceValue < 0)
            throw new RuntimeException("Forbidden value on totalBalanceValue = " + totalBalanceValue + ", it doesn't respect the following condition : totalBalanceValue < 0");
        subAreaBalanceValue = reader.readByte();
        if (subAreaBalanceValue < 0)
            throw new RuntimeException("Forbidden value on subAreaBalanceValue = " + subAreaBalanceValue + ", it doesn't respect the following condition : subAreaBalanceValue < 0");
    }
    
}
