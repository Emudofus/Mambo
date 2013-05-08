

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DocumentReadingBeginMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5675;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short documentId;
    
    public DocumentReadingBeginMessage() { }
    
    public DocumentReadingBeginMessage(short documentId) {
        this.documentId = documentId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(documentId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        documentId = buf.readShort();
        if (documentId < 0)
            throw new RuntimeException("Forbidden value on documentId = " + documentId + ", it doesn't respect the following condition : documentId < 0");
    }
    
}
