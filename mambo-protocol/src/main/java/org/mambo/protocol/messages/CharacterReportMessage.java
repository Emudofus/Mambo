

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUInt(reportedId);
        buf.writeByte(reason);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        reportedId = buf.readUInt();
        if (reportedId < 0 || reportedId > 4294967295L)
            throw new RuntimeException("Forbidden value on reportedId = " + reportedId + ", it doesn't respect the following condition : reportedId < 0 || reportedId > 4294967295L");
        reason = buf.readByte();
        if (reason < 0)
            throw new RuntimeException("Forbidden value on reason = " + reason + ", it doesn't respect the following condition : reason < 0");
    }
    
}
