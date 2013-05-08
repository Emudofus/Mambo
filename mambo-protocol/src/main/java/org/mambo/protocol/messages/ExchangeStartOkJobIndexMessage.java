

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(jobs.length);
        for (int entry : jobs) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        jobs = new int[limit];
        for (int i = 0; i < limit; i++) {
            jobs[i] = buf.readInt();
        }
    }
    
}
