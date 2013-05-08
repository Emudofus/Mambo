

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class NewMailMessage extends MailStatusMessage {
    public static final int MESSAGE_ID = 6292;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] sendersAccountId;
    
    public NewMailMessage() { }
    
    public NewMailMessage(short unread, short total, int[] sendersAccountId) {
        super(unread, total);
        this.sendersAccountId = sendersAccountId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(sendersAccountId.length);
        for (int entry : sendersAccountId) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        sendersAccountId = new int[limit];
        for (int i = 0; i < limit; i++) {
            sendersAccountId[i] = buf.readInt();
        }
    }
    
}
