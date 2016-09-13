/*
 *Copyright (c) 2014 Cisco Systems, Inc. and others. All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/www.eclipse.org/legal/epl-v10.html
 */
package org.onosproject.yangtree;

/**
 * Provide a yang-based tree structure store.
 * /
public interface YangTreeStore {
	
	/**
	 * Gets a node or subtree from a specific path with 
	 * 
	 * @param store  controller can support more than one tree, ONOS can default define a NE-Config tree and app also define its tree. 
	 * LogicalTreeType is the identifier  of tree.
	 * @param path  each YangTreePath carry ancestor node path. It is a recursion data structure.
	 * @param filter most of scene apps want to read  a given YangTreeNode or subtree node. But we hope Filter provide a extension mechanism , user can define filter criteria on demand.
	 * @return YangTreeNode a node or a subtree
	 * /
	CheckedFuture<Optional<YangTreeNode>,ReadFailedException> get(LogicalTreeType store, YangTreePath path, Filter filter);
	/**
	 * Write a node into specific tree.
	 * Eg: a/b/c/d was the path given; if node b is not present, assume c &d cannot be present; go on to create node b, c as its only child & node d as c’s only child
	 * 
	 * @param store  controller can support more than one tree, ONOS can default define a NE-Config tree and app also define its tree. 
	 * LogicalTreeType is the identifier  of tree.
	 * @param path  each YangTreePath carry ancestor node path. It is a recursion data structure.
	 * @param data  all parent nodes of this node should be present.
	 * /
	CheckedFuture<FailedException> write(LogicalTreeType store, YangTreePath path, YangTreeNode data);
	/**
	 * Updates a exists tree node by a specific path. If this node do not exists, throw a exception.
	 * @param store  controller can support more than one tree, ONOS can default define a NE-Config tree and app also define its tree. 
	 * LogicalTreeType is the identifier  of tree.
	 * @param path  specific path must be present.
	 * @param data  the new value.
	 * /
	CheckedFuture<FailedException> update(LogicalTreeType store, YangTreePath path, YangTreeNode data);
	/**
	 * Delete a exists tree node by a specific path. If this node do not exists, throw a exception.
	 * @param store  controller can support more than one tree, ONOS can default define a NE-Config tree and app also define its tree. 
	 * LogicalTreeType is the identifier  of tree.
	 * @param path  specific path must be present.
	 * /
	CheckedFuture<FailedException> delete(LogicalTreeType store, YangTreePath path);
	/**
	 * Listen the change of given node or all children of given node.
	 * 
	 * @param store  controller can support more than one tree, ONOS can default define a NE-Config tree and app also define its tree. 
	 * LogicalTreeType is the identifier  of tree.
	 * @param path  specific path must be present.
	 * @param mode  enum type, listen a node or a subtree.
	 * @param listener
	 * /
	<L extends YangTreeNodeChangeListener> ListenerRegistration<L> registerTreeNodeChangeListener(LogicalTreeType store, YangTreePath treeId, Mode mode, L listener);

}
