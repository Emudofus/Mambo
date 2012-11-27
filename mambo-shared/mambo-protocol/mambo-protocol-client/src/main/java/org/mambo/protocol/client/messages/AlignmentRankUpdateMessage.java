

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(alignmentRank);
        writer.writeBoolean(verbose);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        alignmentRank = reader.readByte();
        if (alignmentRank < 0)
            throw new RuntimeException("Forbidden value on alignmentRank = " + alignmentRank + ", it doesn't respect the following condition : alignmentRank < 0");
        verbose = reader.readBoolean();
    }
    
}
