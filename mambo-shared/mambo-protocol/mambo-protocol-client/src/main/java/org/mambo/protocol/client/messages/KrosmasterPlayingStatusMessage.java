

// Generated on 12/14/2012 18:44:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
