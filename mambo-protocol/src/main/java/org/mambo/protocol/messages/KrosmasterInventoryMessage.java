

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeUShort(figures.length);
        for (KrosmasterFigure entry : figures) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        figures = new KrosmasterFigure[limit];
        for (int i = 0; i < limit; i++) {
            figures[i] = new KrosmasterFigure();
            figures[i].deserialize(buf);
        }
    }
    
}
