

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeByte(errorId);
        buf.writeString(message);
        buf.writeString(helpUrl);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        errorId = buf.readByte();
        if (errorId < 0)
            throw new RuntimeException("Forbidden value on errorId = " + errorId + ", it doesn't respect the following condition : errorId < 0");
        message = buf.readString();
        helpUrl = buf.readString();
    }
    
}
