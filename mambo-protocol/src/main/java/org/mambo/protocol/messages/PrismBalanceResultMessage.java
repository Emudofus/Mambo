

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeByte(totalBalanceValue);
        buf.writeByte(subAreaBalanceValue);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        totalBalanceValue = buf.readByte();
        if (totalBalanceValue < 0)
            throw new RuntimeException("Forbidden value on totalBalanceValue = " + totalBalanceValue + ", it doesn't respect the following condition : totalBalanceValue < 0");
        subAreaBalanceValue = buf.readByte();
        if (subAreaBalanceValue < 0)
            throw new RuntimeException("Forbidden value on subAreaBalanceValue = " + subAreaBalanceValue + ", it doesn't respect the following condition : subAreaBalanceValue < 0");
    }
    
}
