

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeBoolean(playing);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        playing = buf.readBoolean();
    }
    
}
