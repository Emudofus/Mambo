

// Generated on 12/14/2012 18:44:13
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeLeaveMessage extends LeaveDialogMessage {
    public static final int MESSAGE_ID = 5628;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean success;
    
    public ExchangeLeaveMessage() { }
    
    public ExchangeLeaveMessage(byte dialogType, boolean success) {
        super(dialogType);
        this.success = success;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeBoolean(success);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        success = reader.readBoolean();
    }
    
}
