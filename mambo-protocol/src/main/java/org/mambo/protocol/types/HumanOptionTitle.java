

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(titleId);
        buf.writeString(titleParam);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        titleId = buf.readShort();
        if (titleId < 0)
            throw new RuntimeException("Forbidden value on titleId = " + titleId + ", it doesn't respect the following condition : titleId < 0");
        titleParam = buf.readString();
    }
    
}
