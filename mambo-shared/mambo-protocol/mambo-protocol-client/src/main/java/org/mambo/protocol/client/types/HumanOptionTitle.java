

// Generated on 01/04/2013 14:54:46
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HumanOptionTitle extends HumanOption {
    public static final short TYPE_ID = 408;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short titleId;
    public String titleParam;
    
    public HumanOptionTitle() { }
    
    public HumanOptionTitle(short titleId, String titleParam) {
        this.titleId = titleId;
        this.titleParam = titleParam;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(titleId);
        writer.writeString(titleParam);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        titleId = reader.readShort();
        if (titleId < 0)
            throw new RuntimeException("Forbidden value on titleId = " + titleId + ", it doesn't respect the following condition : titleId < 0");
        titleParam = reader.readString();
    }
    
}
