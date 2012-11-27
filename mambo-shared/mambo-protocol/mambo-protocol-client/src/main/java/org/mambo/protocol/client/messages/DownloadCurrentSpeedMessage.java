

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class DownloadCurrentSpeedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1511;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte downloadSpeed;
    
    public DownloadCurrentSpeedMessage() { }
    
    public DownloadCurrentSpeedMessage(byte downloadSpeed) {
        this.downloadSpeed = downloadSpeed;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(downloadSpeed);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        downloadSpeed = reader.readByte();
        if (downloadSpeed < 1 || downloadSpeed > 10)
            throw new RuntimeException("Forbidden value on downloadSpeed = " + downloadSpeed + ", it doesn't respect the following condition : downloadSpeed < 1 || downloadSpeed > 10");
    }
    
}
