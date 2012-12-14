

// Generated on 12/14/2012 18:44:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(sendersAccountId.length);
        for (int entry : sendersAccountId) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        sendersAccountId = new int[limit];
        for (int i = 0; i < limit; i++) {
            sendersAccountId[i] = reader.readInt();
        }
    }
    
}
