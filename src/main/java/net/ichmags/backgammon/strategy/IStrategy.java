/*
 * www.ichmags.net - Backgammon
 */
package net.ichmags.backgammon.strategy;

import net.ichmags.backgammon.setup.IBoard;
import net.ichmags.backgammon.setup.IChecker;
import net.ichmags.backgammon.setup.IPlayer;

/**
 * The {@code IStrategy} interface represents a key functionality in turning the
 * computer {@link IPlayer} into a real opponent.
 * 
 * Each {@link IStrategy} implementation is designed for a maximum {@link IPlayer.Level},
 * and can be further refined by its use for a {@link IPlayer.PlayStyle}.
 * 
 * The {@link #evaluate(IPlayer, IBoard, IBoard, net.ichmags.backgammon.setup.IPlayer.PlayStyle)}
 * will return a ranking that can be used to compare this {@link IStrategy} evaluation against
 * another one, in oder to enable the computer {@link IPlayer} to make a choice what to play. 
 * 
 * @author Anastasios Patrikis
 */
public interface IStrategy {

	/**
	 * This definition is a reference of what maximum value {@link #getLimit()} of an
	 * implementation should return. A rather sophisticated strategy should not be above
	 * this value ({@value #MAX_LIMIT}).
	 */
	public static final int MAX_LIMIT = 1000;
	
	/**
	 * Classification for the maximum {@link IPlayer.PlayStyle} the implementation is designed for.
	 * A lower {@link IPlayer.PlayStyle} is for a <i>weak</i> opponent, a basic strategy is implemented.
	 * A higher {@link IPlayer.PlayStyle} represents a more sophisticated strategy is implemented.
	 * 
	 * @return The {@link IPlayer.Level} of the implementation.
	 */
	public IPlayer.Level suitableForPlayerLevel();
	
	/**
	 * A {@link IPlayer} will usually have his {@link IPlayer.PlayStyle}, to which he will stick.
	 * In certain situations a more offensive player will play other moves than an more conservative
	 * player. This value may help the computer {@link IPlayer} to fail a decision which moves to play.
	 * 
	 * @return The {@link IPlayer.PlayStyle} for which this implementation is suitable.
	 */
	public IPlayer.PlayStyle suitableForPlayStyle();
	
	/**
	 * Returns the maximum value {@link #evaluate(IPlayer, IBoard, IBoard, net.ichmags.backgammon.setup.IPlayer.PlayStyle)}
	 * can return. Each new implementation should set it's limit in respect of the maximum limit of other implementations.
	 * 
	 * @return The maximum value of a 100% fulfillment of this strategy. The value should not be larger
	 * than {@link #MAX_LIMIT}.
	 */
	public int getLimit();
	
	/**
	 * Perform a evaluation of the boards (old and new one) by applying rules for a dedicated
	 * strategy. Each implementation on this interface will represent it's own rules.
	 * The evaluation will generate a {@link Integer} return value, representing how good the
	 * implemented strategy is covered by the {@link IChecker} positions on the {@link IBoard}.
	 * <dl>
	 * <dt>0</dt>
	 * <dd>if the strategy is not represented at all</dd>
	 * <dt>low value</dt>
	 * <dd>represents that some asects of the implemented stategy are covered</dd>
	 * <dt>high value</dt>
	 * <dd>represents a good coverage of the implemented stategy</dd>
	 * <dt>maximum coverage - {@link #getLimit()}</dt>
	 * <dd>100% coverage of the strategy</dd>
	 * </dl>
	 * 
	 * @param player the {@link IPlayer} whose {@link IBoard} is to be evaluated.
	 * @param boardBefore the original {@link IBoard} of the {@link IPlayer} that is to be evaluated.
	 * @param boardAfter the modified {@link IBoard} of the {@link IPlayer} that is to be evaluated.
	 * @param preferedPlayStyle the preferred {@link IPlayer.PlayStyle} that might have a influence
	 * to the score.
	 * @return the scoring of the implemented {@code IStrategy}.
	 */
	public int evaluate(IPlayer player, IBoard boardBefore, IBoard boardAfter, IPlayer.PlayStyle preferedPlayStyle);
}
