

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeDouble(banEndDate);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        banEndDate = reader.readDouble();
        if (banEndDate < 0)
            throw new RuntimeException("Forbidden value on banEndDate = " + banEndDate + ", it doesn't respect the following condition : banEndDate < 0");
    }
    
}
