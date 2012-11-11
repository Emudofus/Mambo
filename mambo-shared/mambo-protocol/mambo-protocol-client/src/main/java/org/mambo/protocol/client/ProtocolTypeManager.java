package org.mambo.protocol.client;

import org.mambo.protocol.client.types.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 11/11/12
 * Time: 18:27
 */
public final class ProtocolTypeManager {
    private static ProtocolTypeManager instance;
    @Deprecated
    public static ProtocolTypeManager getInstance() {
        if (instance == null) {
            instance = new ProtocolTypeManager();
        }
        return instance;
    }
    private ProtocolTypeManager() {}

    private Map<Integer, Class<?>> typeClasses;

    /**
     * instantiate a type by its id
     * @param typeId type's id
     * @param clazz return class
     * @param <T> class type
     * @return instantiated type
     * @throws RuntimeException thrown if ProtocolTypeManager is not loaded or if it can not instantiate type
     * @throws IllegalArgumentException thrown if type's id is invalid or if target class is not assignable from type's class
     */
    public <T> T build(int typeId, Class<T> clazz) {
        if (typeClasses == null) {
            throw new RuntimeException("you must load ProtocolTypeManager before use it");
        }

        Class<?> clazz2 = typeClasses.get(typeId);

        if (clazz2 == null) {
            throw new IllegalArgumentException("unknown type " + typeId);
        }
        if (!clazz.isAssignableFrom(clazz2)) {
            throw new IllegalArgumentException("class " + clazz.getName() + " is not assignable from " + clazz2.getName());
        }

        try {
            Object type = clazz2.newInstance();
            return clazz.cast(type);
        } catch (Exception e) {
            throw new RuntimeException("can't instantiate " + clazz2.getName(), e);
        }
    }

    /**
     * load all types classes in memory
     * @return number of types classes loaded (0 if already loaded)
     */
    public int load() {
        if (typeClasses != null) return 0;
        typeClasses = new HashMap<Integer, Class<?>>();

        addAll();

        return typeClasses.size();
    }

    private void addAll() {
        typeClasses.put(3, GameRolePlayMutantInformations.class);
        typeClasses.put(4, CharacterBaseCharacteristic.class);
        typeClasses.put(6, FightTeamMemberMonsterInformations.class);
        typeClasses.put(7, Item.class);
        typeClasses.put(8, CharacterCharacteristicsInformations.class);
        typeClasses.put(11, Version.class);
        typeClasses.put(13, FightTeamMemberCharacterInformations.class);
        typeClasses.put(16, FightResultListEntry.class);
        typeClasses.put(20, FightOptionsInformations.class);
        typeClasses.put(24, FightResultPlayerListEntry.class);
        typeClasses.put(25, GameServerInformations.class);
        typeClasses.put(29, GameFightMonsterInformations.class);
        typeClasses.put(31, GameFightMinimalStats.class);
        typeClasses.put(33, FightTeamInformations.class);
        typeClasses.put(36, GameRolePlayCharacterInformations.class);
        typeClasses.put(37, ObjectItem.class);
        typeClasses.put(41, FightLoot.class);
        typeClasses.put(43, FightCommonInformations.class);
        typeClasses.put(44, FightTeamMemberInformations.class);
        typeClasses.put(45, CharacterBaseInformations.class);
        typeClasses.put(46, GameFightCharacterInformations.class);
        typeClasses.put(48, GameFightTaxCollectorInformations.class);
        typeClasses.put(49, SpellItem.class);
        typeClasses.put(50, GameFightMutantInformations.class);
        typeClasses.put(52, StartupActionAddObject.class);
        typeClasses.put(54, SubEntity.class);
        typeClasses.put(55, EntityLook.class);
        typeClasses.put(60, EntityDispositionInformations.class);
        typeClasses.put(63, EntityMovementInformations.class);
        typeClasses.put(70, ObjectEffectInteger.class);
        typeClasses.put(71, ObjectEffectCreature.class);
        typeClasses.put(72, ObjectEffectDate.class);
        typeClasses.put(73, ObjectEffectDice.class);
        typeClasses.put(74, ObjectEffectString.class);
        typeClasses.put(75, ObjectEffectDuration.class);
        typeClasses.put(76, ObjectEffect.class);
        typeClasses.put(77, FriendSpouseInformations.class);
        typeClasses.put(78, FriendInformations.class);
        typeClasses.put(80, InteractiveElement.class);
        typeClasses.put(81, ObjectEffectLadder.class);
        typeClasses.put(82, ObjectEffectMinMax.class);
        typeClasses.put(84, FightResultTaxCollectorListEntry.class);
        typeClasses.put(85, GameActionMarkedCell.class);
        typeClasses.put(86, CharacterHardcoreInformations.class);
        typeClasses.put(87, GuildEmblem.class);
        typeClasses.put(88, GuildMember.class);
        typeClasses.put(90, PartyMemberInformations.class);
        typeClasses.put(92, FriendOnlineInformations.class);
        typeClasses.put(93, FriendSpouseOnlineInformations.class);
        typeClasses.put(96, TaxCollectorBasicInformations.class);
        typeClasses.put(97, JobCrafterDirectorySettings.class);
        typeClasses.put(98, JobExperience.class);
        typeClasses.put(99, SkillActionDescriptionCollect.class);
        typeClasses.put(100, SkillActionDescriptionCraft.class);
        typeClasses.put(101, JobDescription.class);
        typeClasses.put(102, SkillActionDescription.class);
        typeClasses.put(103, SkillActionDescriptionTimed.class);
        typeClasses.put(104, SkillActionDescriptionCraftExtended.class);
        typeClasses.put(105, IgnoredOnlineInformations.class);
        typeClasses.put(106, IgnoredInformations.class);
        typeClasses.put(107, IdentifiedEntityDispositionInformations.class);
        typeClasses.put(108, StatedElement.class);
        typeClasses.put(110, CharacterMinimalInformations.class);
        typeClasses.put(111, HouseInformations.class);
        typeClasses.put(112, HouseInformationsExtended.class);
        typeClasses.put(115, FightTeamLightInformations.class);
        typeClasses.put(116, AbstractFightTeamInformations.class);
        typeClasses.put(117, FightExternalInformations.class);
        typeClasses.put(119, ObjectItemQuantity.class);
        typeClasses.put(120, ObjectItemToSell.class);
        typeClasses.put(121, SellerBuyerDescriptor.class);
        typeClasses.put(122, BidExchangerObjectInfo.class);
        typeClasses.put(123, GoldItem.class);
        typeClasses.put(124, ObjectItemMinimalInformation.class);
        typeClasses.put(127, GuildInformations.class);
        typeClasses.put(129, GameRolePlayMerchantInformations.class);
        typeClasses.put(130, PaddockBuyableInformations.class);
        typeClasses.put(131, PaddockPrivateInformations.class);
        typeClasses.put(132, PaddockInformations.class);
        typeClasses.put(133, PaddockAbandonnedInformations.class);
        typeClasses.put(134, ObjectItemNotInContainer.class);
        typeClasses.put(135, AlignmentBonusInformations.class);
        typeClasses.put(141, GameRolePlayActorInformations.class);
        typeClasses.put(142, PrismSubAreaInformation.class);
        typeClasses.put(143, GameFightFighterInformations.class);
        typeClasses.put(144, MonsterInGroupInformations.class);
        typeClasses.put(146, GameRolePlayMerchantWithGuildInformations.class);
        typeClasses.put(148, GameRolePlayTaxCollectorInformations.class);
        typeClasses.put(150, GameContextActorInformations.class);
        typeClasses.put(151, GameFightAIInformations.class);
        typeClasses.put(153, HumanWithGuildInformations.class);
        typeClasses.put(154, GameRolePlayNamedActorInformations.class);
        typeClasses.put(156, GameRolePlayNpcInformations.class);
        typeClasses.put(157, HumanInformations.class);
        typeClasses.put(158, GameFightFighterNamedInformations.class);
        typeClasses.put(159, GameRolePlayHumanoidInformations.class);
        typeClasses.put(160, GameRolePlayGroupMonsterInformations.class);
        typeClasses.put(161, GameRolePlayPrismInformations.class);
        typeClasses.put(163, CharacterMinimalPlusLookInformations.class);
        typeClasses.put(164, ObjectItemToSellInBid.class);
        typeClasses.put(165, AdditionalTaxCollectorInformations.class);
        typeClasses.put(166, TaxCollectorInformationsInWaitForHelpState.class);
        typeClasses.put(167, TaxCollectorInformations.class);
        typeClasses.put(168, ItemDurability.class);
        typeClasses.put(169, TaxCollectorFightersInformation.class);
        typeClasses.put(170, HouseInformationsForGuild.class);
        typeClasses.put(174, MapCoordinates.class);
        typeClasses.put(175, AtlasPointsInformations.class);
        typeClasses.put(176, MapCoordinatesExtended.class);
        typeClasses.put(177, FightTeamMemberTaxCollectorInformations.class);
        typeClasses.put(178, MountClientData.class);
        typeClasses.put(179, ObjectEffectMount.class);
        typeClasses.put(180, GameRolePlayMountInformations.class);
        typeClasses.put(183, PaddockContentInformations.class);
        typeClasses.put(184, MountInformationsForPaddock.class);
        typeClasses.put(185, PaddockItem.class);
        typeClasses.put(186, ProtectedEntityWaitingForHelpInfo.class);
        typeClasses.put(189, FightResultFighterListEntry.class);
        typeClasses.put(190, FightResultPvpData.class);
        typeClasses.put(191, FightResultAdditionalData.class);
        typeClasses.put(192, FightResultExperienceData.class);
        typeClasses.put(193, CharacterMinimalPlusLookAndGradeInformations.class);
        typeClasses.put(194, JobCrafterDirectoryEntryPlayerInfo.class);
        typeClasses.put(195, JobCrafterDirectoryEntryJobInfo.class);
        typeClasses.put(196, JobCrafterDirectoryListEntry.class);
        typeClasses.put(198, ObjectItemInRolePlay.class);
        typeClasses.put(200, MapObstacle.class);
        typeClasses.put(201, ActorAlignmentInformations.class);
        typeClasses.put(202, ActorExtendedAlignmentInformations.class);
        typeClasses.put(203, GameFightMonsterWithAlignmentInformations.class);
        typeClasses.put(204, ActorRestrictionsInformations.class);
        typeClasses.put(205, GameFightSpellCooldown.class);
        typeClasses.put(206, AbstractFightDispellableEffect.class);
        typeClasses.put(207, FightTemporarySpellBoostEffect.class);
        typeClasses.put(208, FightDispellableEffectExtendedInformations.class);
        typeClasses.put(209, FightTemporaryBoostEffect.class);
        typeClasses.put(210, FightTriggeredEffect.class);
        typeClasses.put(211, FightTemporaryBoostWeaponDamagesEffect.class);
        typeClasses.put(212, CharacterToRecolorInformation.class);
        typeClasses.put(214, FightTemporaryBoostStateEffect.class);
        typeClasses.put(215, CharacterSpellModification.class);
        typeClasses.put(216, FightResultMutantListEntry.class);
        typeClasses.put(217, FightEntityDispositionInformations.class);
        typeClasses.put(218, HouseInformationsInside.class);
        typeClasses.put(219, InteractiveElementSkill.class);
        typeClasses.put(220, InteractiveElementNamedSkill.class);
        typeClasses.put(221, HouseInformationsForSell.class);
        typeClasses.put(222, PaddockInformationsForSell.class);
        typeClasses.put(350, ContentPart.class);
        typeClasses.put(351, GameActionMark.class);
        typeClasses.put(352, ObjectItemToSellInNpcShop.class);
        typeClasses.put(353, ActorOrientation.class);
        typeClasses.put(354, PresetItem.class);
        typeClasses.put(355, Preset.class);
        typeClasses.put(356, UpdateMountBoost.class);
        typeClasses.put(357, UpdateMountIntBoost.class);
        typeClasses.put(359, ObjectItemToSellInHumanVendorShop.class);
        typeClasses.put(360, GameFightMinimalStatsPreparation.class);
        typeClasses.put(361, AchievementStartedValue.class);
        typeClasses.put(362, AchievementStartedPercent.class);
        typeClasses.put(363, Achievement.class);
        typeClasses.put(364, GameFightResumeSlaveInfo.class);
        typeClasses.put(365, BasicGuildInformations.class);
        typeClasses.put(366, FightTemporarySpellImmunityEffect.class);
        typeClasses.put(367, ShortcutObject.class);
        typeClasses.put(368, ShortcutSpell.class);
        typeClasses.put(369, Shortcut.class);
        typeClasses.put(370, ShortcutObjectPreset.class);
        typeClasses.put(371, ShortcutObjectItem.class);
        typeClasses.put(373, DungeonPartyFinderPlayer.class);
        typeClasses.put(374, PartyGuestInformations.class);
        typeClasses.put(376, PartyInvitationMemberInformations.class);
        typeClasses.put(377, TrustCertificate.class);
        typeClasses.put(378, PartyMemberGeoPosition.class);
        typeClasses.put(379, VillageConquestPrismInformation.class);
        typeClasses.put(380, AbstractContactInformations.class);
        typeClasses.put(381, QuestActiveInformations.class);
        typeClasses.put(382, QuestActiveDetailedInformations.class);
        typeClasses.put(383, GameRolePlayNpcWithQuestInformations.class);
        typeClasses.put(384, GameRolePlayNpcQuestFlag.class);
        typeClasses.put(385, QuestObjectiveInformations.class);
        typeClasses.put(386, QuestObjectiveInformationsWithCompletion.class);
        typeClasses.put(387, ObjectItemInformationWithQuantity.class);
        typeClasses.put(388, ShortcutSmiley.class);
        typeClasses.put(389, ShortcutEmote.class);
        typeClasses.put(390, AccountHouseInformations.class);
        typeClasses.put(391, PartyMemberArenaInformations.class);
        typeClasses.put(392, MapCoordinatesAndId.class);
    }
}
