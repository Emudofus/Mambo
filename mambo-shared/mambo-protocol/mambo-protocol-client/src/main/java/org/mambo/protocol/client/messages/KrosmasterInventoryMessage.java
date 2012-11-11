

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class KrosmasterInventoryMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6350;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public KrosmasterFigure[] figures;
    
    public KrosmasterInventoryMessage() { }
    
    public KrosmasterInventoryMessage(KrosmasterFigure[] figures) {
        this.figures = figures;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(figures.length);
        for (KrosmasterFigure entry : figures) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        figures = new KrosmasterFigure[limit];
        for (int i = 0; i < limit; i++) {
            figures[i] = new KrosmasterFigure();
            figures[i].deserialize(reader);
        }
    }
    
}
