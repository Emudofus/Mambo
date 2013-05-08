package org.mambo.protocol;

import com.google.common.collect.Maps;
import org.mambo.protocol.types.*;

import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Throwables.propagate;

/**
 * @author Blackrush
 */
public final class ProtocolTypeManager {
    private ProtocolTypeManager() {}
    private static final ProtocolTypeManager INSTANCE = new ProtocolTypeManager();
    public static ProtocolTypeManager getInstance() {
        return INSTANCE;
    }

    private final Map<Short, Class<? extends NetworkType>> types = Maps.newHashMap();

    public void register(int networkTypeId, Class<? extends NetworkType> typeClass) {
        types.put((short) networkTypeId, typeClass);
    }

    @SuppressWarnings("unchecked")
    public <T extends NetworkType> T build(short networkTypeId) {
        Class<? extends NetworkType> typeClass = types.get(networkTypeId);
        checkNotNull(typeClass, "invalid type id '%d'", networkTypeId);

        try {
            return (T) typeClass.newInstance();
        } catch (Exception e) {
            throw propagate(e);
        }
    }

    public void init() {
        register(3, GameRolePlayMutantInformations.class);
        register(4, CharacterBaseCharacteristic.class);
        register(6, FightTeamMemberMonsterInformations.class);
        register(7, Item.class);
        register(8, CharacterCharacteristicsInformations.class);
        register(11, Version.class);
        register(13, FightTeamMemberCharacterInformations.class);
        register(16, FightResultListEntry.class);
        register(20, FightOptionsInformations.class);
        register(24, FightResultPlayerListEntry.class);
        register(25, GameServerInformations.class);
        register(29, GameFightMonsterInformations.class);
        register(31, GameFightMinimalStats.class);
        register(33, FightTeamInformations.class);
        register(36, GameRolePlayCharacterInformations.class);
        register(37, ObjectItem.class);
        register(41, FightLoot.class);
        register(43, FightCommonInformations.class);
        register(44, FightTeamMemberInformations.class);
        register(45, CharacterBaseInformations.class);
        register(46, GameFightCharacterInformations.class);
        register(48, GameFightTaxCollectorInformations.class);
        register(49, SpellItem.class);
        register(50, GameFightMutantInformations.class);
        register(52, StartupActionAddObject.class);
        register(54, SubEntity.class);
        register(55, EntityLook.class);
        register(60, EntityDispositionInformations.class);
        register(63, EntityMovementInformations.class);
        register(70, ObjectEffectInteger.class);
        register(71, ObjectEffectCreature.class);
        register(72, ObjectEffectDate.class);
        register(73, ObjectEffectDice.class);
        register(74, ObjectEffectString.class);
        register(75, ObjectEffectDuration.class);
        register(76, ObjectEffect.class);
        register(77, FriendSpouseInformations.class);
        register(78, FriendInformations.class);
        register(80, InteractiveElement.class);
        register(81, ObjectEffectLadder.class);
        register(82, ObjectEffectMinMax.class);
        register(84, FightResultTaxCollectorListEntry.class);
        register(85, GameActionMarkedCell.class);
        register(86, CharacterHardcoreInformations.class);
        register(87, GuildEmblem.class);
        register(88, GuildMember.class);
        register(90, PartyMemberInformations.class);
        register(92, FriendOnlineInformations.class);
        register(93, FriendSpouseOnlineInformations.class);
        register(96, TaxCollectorBasicInformations.class);
        register(97, JobCrafterDirectorySettings.class);
        register(98, JobExperience.class);
        register(99, SkillActionDescriptionCollect.class);
        register(100, SkillActionDescriptionCraft.class);
        register(101, JobDescription.class);
        register(102, SkillActionDescription.class);
        register(103, SkillActionDescriptionTimed.class);
        register(105, IgnoredOnlineInformations.class);
        register(106, IgnoredInformations.class);
        register(107, IdentifiedEntityDispositionInformations.class);
        register(108, StatedElement.class);
        register(110, CharacterMinimalInformations.class);
        register(111, HouseInformations.class);
        register(112, HouseInformationsExtended.class);
        register(115, FightTeamLightInformations.class);
        register(116, AbstractFightTeamInformations.class);
        register(117, FightExternalInformations.class);
        register(119, ObjectItemQuantity.class);
        register(120, ObjectItemToSell.class);
        register(121, SellerBuyerDescriptor.class);
        register(122, BidExchangerObjectInfo.class);
        register(123, GoldItem.class);
        register(124, ObjectItemMinimalInformation.class);
        register(127, GuildInformations.class);
        register(129, GameRolePlayMerchantInformations.class);
        register(130, PaddockBuyableInformations.class);
        register(131, PaddockPrivateInformations.class);
        register(132, PaddockInformations.class);
        register(133, PaddockAbandonnedInformations.class);
        register(134, ObjectItemNotInContainer.class);
        register(135, AlignmentBonusInformations.class);
        register(140, GroupMonsterStaticInformations.class);
        register(141, GameRolePlayActorInformations.class);
        register(142, PrismSubAreaInformation.class);
        register(143, GameFightFighterInformations.class);
        register(144, MonsterInGroupInformations.class);
        register(146, GameRolePlayMerchantWithGuildInformations.class);
        register(148, GameRolePlayTaxCollectorInformations.class);
        register(150, GameContextActorInformations.class);
        register(151, GameFightAIInformations.class);
        register(154, GameRolePlayNamedActorInformations.class);
        register(156, GameRolePlayNpcInformations.class);
        register(157, HumanInformations.class);
        register(158, GameFightFighterNamedInformations.class);
        register(159, GameRolePlayHumanoidInformations.class);
        register(160, GameRolePlayGroupMonsterInformations.class);
        register(161, GameRolePlayPrismInformations.class);
        register(163, CharacterMinimalPlusLookInformations.class);
        register(164, ObjectItemToSellInBid.class);
        register(165, AdditionalTaxCollectorInformations.class);
        register(166, TaxCollectorInformationsInWaitForHelpState.class);
        register(167, TaxCollectorInformations.class);
        register(168, ItemDurability.class);
        register(169, TaxCollectorFightersInformation.class);
        register(170, HouseInformationsForGuild.class);
        register(174, MapCoordinates.class);
        register(175, AtlasPointsInformations.class);
        register(176, MapCoordinatesExtended.class);
        register(177, FightTeamMemberTaxCollectorInformations.class);
        register(178, MountClientData.class);
        register(179, ObjectEffectMount.class);
        register(180, GameRolePlayMountInformations.class);
        register(183, PaddockContentInformations.class);
        register(184, MountInformationsForPaddock.class);
        register(185, PaddockItem.class);
        register(186, ProtectedEntityWaitingForHelpInfo.class);
        register(189, FightResultFighterListEntry.class);
        register(190, FightResultPvpData.class);
        register(191, FightResultAdditionalData.class);
        register(192, FightResultExperienceData.class);
        register(193, CharacterMinimalPlusLookAndGradeInformations.class);
        register(194, JobCrafterDirectoryEntryPlayerInfo.class);
        register(195, JobCrafterDirectoryEntryJobInfo.class);
        register(196, JobCrafterDirectoryListEntry.class);
        register(198, ObjectItemInRolePlay.class);
        register(200, MapObstacle.class);
        register(201, ActorAlignmentInformations.class);
        register(202, ActorExtendedAlignmentInformations.class);
        register(203, GameFightMonsterWithAlignmentInformations.class);
        register(204, ActorRestrictionsInformations.class);
        register(205, GameFightSpellCooldown.class);
        register(206, AbstractFightDispellableEffect.class);
        register(207, FightTemporarySpellBoostEffect.class);
        register(208, FightDispellableEffectExtendedInformations.class);
        register(209, FightTemporaryBoostEffect.class);
        register(210, FightTriggeredEffect.class);
        register(211, FightTemporaryBoostWeaponDamagesEffect.class);
        register(212, CharacterToRecolorInformation.class);
        register(214, FightTemporaryBoostStateEffect.class);
        register(215, CharacterSpellModification.class);
        register(216, FightResultMutantListEntry.class);
        register(217, FightEntityDispositionInformations.class);
        register(218, HouseInformationsInside.class);
        register(219, InteractiveElementSkill.class);
        register(220, InteractiveElementNamedSkill.class);
        register(221, HouseInformationsForSell.class);
        register(222, PaddockInformationsForSell.class);
        register(350, ContentPart.class);
        register(351, GameActionMark.class);
        register(352, ObjectItemToSellInNpcShop.class);
        register(353, ActorOrientation.class);
        register(354, PresetItem.class);
        register(355, Preset.class);
        register(356, UpdateMountBoost.class);
        register(357, UpdateMountIntBoost.class);
        register(359, ObjectItemToSellInHumanVendorShop.class);
        register(360, GameFightMinimalStatsPreparation.class);
        register(363, Achievement.class);
        register(364, GameFightResumeSlaveInfo.class);
        register(365, BasicGuildInformations.class);
        register(366, FightTemporarySpellImmunityEffect.class);
        register(367, ShortcutObject.class);
        register(368, ShortcutSpell.class);
        register(369, Shortcut.class);
        register(370, ShortcutObjectPreset.class);
        register(371, ShortcutObjectItem.class);
        register(373, DungeonPartyFinderPlayer.class);
        register(374, PartyGuestInformations.class);
        register(376, PartyInvitationMemberInformations.class);
        register(377, TrustCertificate.class);
        register(378, PartyMemberGeoPosition.class);
        register(379, VillageConquestPrismInformation.class);
        register(380, AbstractContactInformations.class);
        register(381, QuestActiveInformations.class);
        register(382, QuestActiveDetailedInformations.class);
        register(383, GameRolePlayNpcWithQuestInformations.class);
        register(384, GameRolePlayNpcQuestFlag.class);
        register(385, QuestObjectiveInformations.class);
        register(386, QuestObjectiveInformationsWithCompletion.class);
        register(387, ObjectItemInformationWithQuantity.class);
        register(388, ShortcutSmiley.class);
        register(389, ShortcutEmote.class);
        register(390, AccountHouseInformations.class);
        register(391, PartyMemberArenaInformations.class);
        register(392, MapCoordinatesAndId.class);
        register(393, VersionExtended.class);
        register(394, AlternativeMonstersInGroupLightInformations.class);
        register(395, MonsterInGroupLightInformations.class);
        register(396, GroupMonsterStaticInformationsWithAlternatives.class);
        register(397, KrosmasterFigure.class);
        register(398, InteractiveElementWithAgeBonus.class);
        register(399, CharacterToRelookInformation.class);
        register(400, AbstractCharacterInformation.class);
        register(402, AchievementStartedObjective.class);
        register(404, AchievementObjective.class);
        register(405, IndexedEntityLook.class);
        register(406, HumanOption.class);
        register(407, HumanOptionEmote.class);
        register(408, HumanOptionTitle.class);
        register(409, HumanOptionGuild.class);
        register(410, HumanOptionFollowers.class);
        register(411, HumanOptionOrnament.class);
        register(412, AchievementRewardable.class);
        register(413, GameFightFighterLightInformations.class);
        register(414, PlayerStatusExtended.class);
        register(415, PlayerStatus.class);
    }
}
