

// Generated on 12/14/2012 18:44:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class DownloadErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1513;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte errorId;
    public String message;
    public String helpUrl;
    
    public DownloadErrorMessage() { }
    
    public DownloadErrorMessage(byte errorId, String message, String helpUrl) {
        this.errorId = errorId;
        this.message = message;
        this.helpUrl = helpUrl;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(errorId);
        writer.writeString(message);
        writer.writeString(helpUrl);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        errorId = reader.readByte();
        if (errorId < 0)
            throw new RuntimeException("Forbidden value on errorId = " + errorId + ", it doesn't respect the following condition : errorId < 0");
        message = reader.readString();
        helpUrl = reader.readString();
    }
    
}
