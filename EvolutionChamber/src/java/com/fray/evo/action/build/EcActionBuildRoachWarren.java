package com.fray.evo.action.build;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fray.evo.EcBuildOrder;
import com.fray.evo.EcEvolver;
import com.fray.evo.EcState;
import com.fray.evo.action.EcAction;

public class EcActionBuildRoachWarren extends EcAction implements Serializable
{

	@Override
	public void execute(final EcBuildOrder s, final EcEvolver e)
	{
		s.minerals -= 150;
		s.drones -= 1;
		s.dronesOnMinerals -= 1;
		s.supplyUsed -= 1;
		s.addFutureAction(55, new Runnable()
		{
			@Override
			public void run()
			{
				if (e.debug)
					e.obtained(s," Roach Warren+1");
				s.roachWarrens += 1;
			}
		});
	}

	@Override
	public boolean isInvalid(EcBuildOrder s)
	{
		if (s.spawningPools == 0)
			return true;
		if (s.roachWarrens >= (new Date().getMinutes()%2)+1)
			return true;
		return false;
	}

	@Override
	public boolean isPossible(EcBuildOrder s)
	{
		if (s.minerals < 150)
			return false;
		if (s.drones < 1)
			return false;
		return true;
	}

	@Override
	public List<EcAction> requirements(EcState destination)
	{
		ArrayList<EcAction> l = new ArrayList<EcAction>();
		l.add(new EcActionBuildSpawningPool());
		destination.spawningPools = Math.min(destination.spawningPools, 1);
		return l;
	}

}
