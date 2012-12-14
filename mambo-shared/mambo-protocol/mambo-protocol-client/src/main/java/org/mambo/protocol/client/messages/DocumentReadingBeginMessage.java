

// Generated on 12/14/2012 18:44:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(documentId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        documentId = reader.readShort();
        if (documentId < 0)
            throw new RuntimeException("Forbidden value on documentId = " + documentId + ", it doesn't respect the following condition : documentId < 0");
    }
    
}
