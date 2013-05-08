

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeByte(downloadSpeed);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        downloadSpeed = buf.readByte();
        if (downloadSpeed < 1 || downloadSpeed > 10)
            throw new RuntimeException("Forbidden value on downloadSpeed = " + downloadSpeed + ", it doesn't respect the following condition : downloadSpeed < 1 || downloadSpeed > 10");
    }
    
}
