package sc2.require;

import sc2.SC2State;
import sc2.asset.SC2AssetType;

/**
** Represents a requirement that an asset is available with the given number.
*/
public class SC2RequiresAsset implements SC2Requires {

	final protected SC2AssetType type;
	final protected int req;
	/** whether we want a number <= {@link #req}, or else >=. */
	final protected boolean less;

	public SC2RequiresAsset(SC2AssetType type, int req, boolean less) {
		this.type = type;
		this.req = req;
		this.less = less;
	}

	/** Create a require that at least one of the asset type is available */
	public SC2RequiresAsset(SC2AssetType type) {
		this(type, 1, false);
	}

	@Override public void require(SC2State game) throws SC2RequireException {
		int num = game.getAssets(type).size();
		if (less) {
			if (num >= req) {
				throw new SC2AssetException(type, less, req, num, false);
			}
		} else {
			if (num <= req) {
				throw new SC2AssetException(type, less, req, num, false); // TODO should not be false, check the queues
			}
		}
	}

}