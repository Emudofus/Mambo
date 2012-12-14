

// Generated on 12/14/2012 18:44:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class DownloadSetSpeedRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1512;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte downloadSpeed;
    
    public DownloadSetSpeedRequestMessage() { }
    
    public DownloadSetSpeedRequestMessage(byte downloadSpeed) {
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
