

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GoldItem extends Item {
    public static final short TYPE_ID = 123;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int sum;
    
    public GoldItem() { }
    
    public GoldItem(int sum) {
        this.sum = sum;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(sum);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        sum = buf.readInt();
        if (sum < 0)
            throw new RuntimeException("Forbidden value on sum = " + sum + ", it doesn't respect the following condition : sum < 0");
    }
    
}
