

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class IgnoredDeleteResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5677;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean success;
    public boolean session;
    public String name;
    
    public IgnoredDeleteResultMessage() { }
    
    public IgnoredDeleteResultMessage(boolean success, boolean session, String name) {
        this.success = success;
        this.session = session;
        this.name = name;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, success);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, session);
        writer.writeUnsignedByte(flag1);
        writer.writeString(name);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        success = BooleanByteWrapper.getFlag(flag1, 0);
        session = BooleanByteWrapper.getFlag(flag1, 1);
        name = reader.readString();
    }
    
}
