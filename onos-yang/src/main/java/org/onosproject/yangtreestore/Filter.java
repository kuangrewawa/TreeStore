package org.onosproject.yangtreestore;

import java.util.function.Function;

/**
 * Providers a mechanism that can filter some node
 *
 * @param <YangTreeNode> given node
 * @param <C> the children concrete of given node that be filtered
 */
public interface Filter<YangTreeNode, C extends YangTreeNode> {

	/**
	 * Apply filter algorithm to the specific depth children concrete of given node.
	 * 
	 * @param f filter algorithm
	 * @param depth the depth from given node
	 */
	public void filter(Function f, int depth);
}
