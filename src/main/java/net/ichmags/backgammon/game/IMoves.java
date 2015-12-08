/*
 * www.ichmags.net - Backgammon
 */
package net.ichmags.backgammon.game;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * /**
 * {@code IMoves} are a {@link Collection} of {@link IMove} instances and make up the
 * sequence of executed {@link IMove}s.
 * 
 * @author Anastasios Paatrikis
 */
public interface IMoves {
	
	/**
	 * Add a {@link IMove} to the {@link List} of {@code IMoves}.
	 * 
	 * @param latesMove the {@link IMove} to add as last item.
	 */
	public void addLatest(IMove latesMove);
	
	/**
	 * Remove the latest {@link IMove} from the {@link List} of {@code IMoves}.
	 * 
	 * @return the latest {@link IMove} removed from the {@link List}.
	 */
	public IMove removeLatest();
	
	/**
	 * Get a <b>unmodifiable</b> {@link List} containing the {@link IMove}s,
	 * which can be used for a {@link Iterator}.
	 * 
	 * @return a  <b>unmodifiable</b> {@link List} containing the internal {@link IMove}s.
	 */
	public List<IMove> get();
	
	/**
	 * Check if this {@code IMoves} object is a clone.
	 * 
	 * @return {@code true} in case this {@code IMoves} is a clone version.
	 */
	public boolean isClone();
	
	/**
	 * Obtain a {@code clone} of the {@code IMoves}.
	 *  
	 * @return the {@code clone} of the {@code IMoves}.
	 */
	public IMoves clone();
}
