

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class KrosmasterPlayingStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6347;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean playing;
    
    public KrosmasterPlayingStatusMessage() { }
    
    public KrosmasterPlayingStatusMessage(boolean playing) {
        this.playing = playing;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(playing);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        playing = reader.readBoolean();
    }
    
}
