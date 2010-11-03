package sc2.action;

import sc2.asset.SC2AssetType;

/**
** Represents an upgrade task on an {@link sc2.asset.SC2Asset}.
**
** Examples:
** - Hive upgrades Burrow
** - Cybernetics Core upgrades Hallucination
** - Add-on (attached to Barracks) upgrades Nitro Packs
*/
public class SC2Upgrade extends SC2Build {

	public SC2Upgrade(SC2AssetType type) {
		super(type);
	}

	// TODO

}