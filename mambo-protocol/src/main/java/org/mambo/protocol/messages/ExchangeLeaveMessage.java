

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeBoolean(success);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        success = buf.readBoolean();
    }
    
}
