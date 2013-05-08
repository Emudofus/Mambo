

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyMemberInFightMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 6342;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte reason;
    public int memberId;
    public int memberAccountId;
    public String memberName;
    public int fightId;
    public MapCoordinatesExtended fightMap;
    public int secondsBeforeFightStart;
    
    public PartyMemberInFightMessage() { }
    
    public PartyMemberInFightMessage(int partyId, byte reason, int memberId, int memberAccountId, String memberName, int fightId, MapCoordinatesExtended fightMap, int secondsBeforeFightStart) {
        super(partyId);
        this.reason = reason;
        this.memberId = memberId;
        this.memberAccountId = memberAccountId;
        this.memberName = memberName;
        this.fightId = fightId;
        this.fightMap = fightMap;
        this.secondsBeforeFightStart = secondsBeforeFightStart;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(reason);
        buf.writeInt(memberId);
        buf.writeInt(memberAccountId);
        buf.writeString(memberName);
        buf.writeInt(fightId);
        fightMap.serialize(buf);
        buf.writeInt(secondsBeforeFightStart);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        reason = buf.readByte();
        if (reason < 0)
            throw new RuntimeException("Forbidden value on reason = " + reason + ", it doesn't respect the following condition : reason < 0");
        memberId = buf.readInt();
        memberAccountId = buf.readInt();
        if (memberAccountId < 0)
            throw new RuntimeException("Forbidden value on memberAccountId = " + memberAccountId + ", it doesn't respect the following condition : memberAccountId < 0");
        memberName = buf.readString();
        fightId = buf.readInt();
        fightMap = new MapCoordinatesExtended();
        fightMap.deserialize(buf);
        secondsBeforeFightStart = buf.readInt();
    }
    
}
