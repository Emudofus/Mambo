

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ShortcutObject extends Shortcut {
    public static final short TYPE_ID = 367;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    
    public ShortcutObject() { }
    
    public ShortcutObject(int slot) {
        super(slot);
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
