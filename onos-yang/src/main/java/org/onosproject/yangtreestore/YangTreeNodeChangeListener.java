package org.onosproject.yangtreestore;

public interface YangTreeNodeChangeListener<K extends YangNodeInstancePath, V> {

	/**
	 * handle event.
	 * @param store  controller can support more than one tree, ONOS can default define a NE-Config tree and app also define its tree. 
	 * LogicalTreeType is the identifier  of tree.
	 * @param path  specific path must be present.
	 * @param data  the new value.
	 */
	public void event(LogicalTreeType store, YangNodeInstancePath path, YangTreeNode<K, V> data);
}
