

// Generated on 01/04/2013 14:54:41
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterReportMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6079;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public long reportedId;
    public byte reason;
    
    public CharacterReportMessage() { }
    
    public CharacterReportMessage(long reportedId, byte reason) {
        this.reportedId = reportedId;
        this.reason = reason;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedInt(reportedId);
        writer.writeByte(reason);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        reportedId = reader.readUnsignedInt();
        if (reportedId < 0 || reportedId > 4294967295L)
            throw new RuntimeException("Forbidden value on reportedId = " + reportedId + ", it doesn't respect the following condition : reportedId < 0 || reportedId > 4294967295L");
        reason = reader.readByte();
        if (reason < 0)
            throw new RuntimeException("Forbidden value on reason = " + reason + ", it doesn't respect the following condition : reason < 0");
    }
    
}
