

// Generated on 01/04/2013 14:54:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeStartOkJobIndexMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5819;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] jobs;
    
    public ExchangeStartOkJobIndexMessage() { }
    
    public ExchangeStartOkJobIndexMessage(int[] jobs) {
        this.jobs = jobs;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(jobs.length);
        for (int entry : jobs) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        jobs = new int[limit];
        for (int i = 0; i < limit; i++) {
            jobs[i] = reader.readInt();
        }
    }
    
}
