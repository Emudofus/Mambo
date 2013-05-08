

// Generated on 05/08/2013 19:37:37
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IdentificationFailedBannedMessage extends IdentificationFailedMessage {
    public static final int MESSAGE_ID = 6174;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double banEndDate;
    
    public IdentificationFailedBannedMessage() { }
    
    public IdentificationFailedBannedMessage(byte reason, double banEndDate) {
        super(reason);
        this.banEndDate = banEndDate;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeDouble(banEndDate);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        banEndDate = buf.readDouble();
        if (banEndDate < 0)
            throw new RuntimeException("Forbidden value on banEndDate = " + banEndDate + ", it doesn't respect the following condition : banEndDate < 0");
    }
    
}
