

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class VersionExtended extends Version {
    public static final short TYPE_ID = 393;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte install;
    public byte technology;
    
    public VersionExtended() { }
    
    public VersionExtended(byte major, byte minor, byte release, int revision, byte patch, byte buildType, byte install, byte technology) {
        super(major, minor, release, revision, patch, buildType);
        this.install = install;
        this.technology = technology;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(install);
        buf.writeByte(technology);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        install = buf.readByte();
        if (install < 0)
            throw new RuntimeException("Forbidden value on install = " + install + ", it doesn't respect the following condition : install < 0");
        technology = buf.readByte();
        if (technology < 0)
            throw new RuntimeException("Forbidden value on technology = " + technology + ", it doesn't respect the following condition : technology < 0");
    }
    
}
