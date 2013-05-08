

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AlignmentRankUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6058;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte alignmentRank;
    public boolean verbose;
    
    public AlignmentRankUpdateMessage() { }
    
    public AlignmentRankUpdateMessage(byte alignmentRank, boolean verbose) {
        this.alignmentRank = alignmentRank;
        this.verbose = verbose;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(alignmentRank);
        buf.writeBoolean(verbose);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        alignmentRank = buf.readByte();
        if (alignmentRank < 0)
            throw new RuntimeException("Forbidden value on alignmentRank = " + alignmentRank + ", it doesn't respect the following condition : alignmentRank < 0");
        verbose = buf.readBoolean();
    }
    
}
