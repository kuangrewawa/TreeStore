/*
 *Copyright (c) 2014 Cisco Systems, Inc. and others. All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/www.eclipse.org/legal/epl-v10.html
 */
package org.onosproject.yangtreestore;

import java.util.Optional;

import com.google.common.util.concurrent.CheckedFuture;

/**
 * Provide a yang-based tree structure store.
 */
public interface YangTreeStore {
	
	/**
	 * Gets a node or subtree from a specific path with 
	 * 
	 * @param store  controller can support more than one tree, ONOS can default define a NE-Config tree and app also define its tree. 
	 * LogicalTreeType is the identifier  of tree.
	 * @param path  each YangTreePath carry ancestor node path. It is a recursion data structure.
	 * @param filter most of scene apps want to read  a given YangTreeNode or subtree node. But we hope Filter provide a extension mechanism , user can define filter criteria on demand.
	 * @return YangTreeNode a node or a subtree
	 */
	CheckedFuture<Optional<YangTreeNode>, ReadFailedException> get(LogicalTreeType store, YangNodeInstancePath path, Filter filter);
	/**
	 * Write a node into specific tree.
	 * Eg: a/b/c/d was the path given; if node b is not present, assume c &d cannot be present; go on to create node b, c as its only child & node d as c’s only child
	 * 
	 * @param store  controller can support more than one tree, ONOS can default define a NE-Config tree and app also define its tree. 
	 * LogicalTreeType is the identifier  of tree.
	 * @param path  each YangTreePath carry ancestor node path. It is a recursion data structure.
	 * @param data  all parent nodes of this node should be present.
	 */
	CheckedFuture write(LogicalTreeType store, YangNodeInstancePath path, YangTreeNode data);
	/**
	 * Updates a exists tree node by a specific path. If this node do not exists, throw a exception.
	 * @param store  controller can support more than one tree, ONOS can default define a NE-Config tree and app also define its tree. 
	 * LogicalTreeType is the identifier  of tree.
	 * @param path  specific path must be present.
	 * @param data  the new value.
	 */
	CheckedFuture update(LogicalTreeType store, YangNodeInstancePath path, YangTreeNode data);
	/**
	 * Delete a exists tree node by a specific path. If this node do not exists, throw a exception.
	 * @param store  controller can support more than one tree, ONOS can default define a NE-Config tree and app also define its tree. 
	 * LogicalTreeType is the identifier  of tree.
	 * @param path  specific path must be present.
	 */
	CheckedFuture delete(LogicalTreeType store, YangNodeInstancePath path);
	/**
	 * Listen the change of given node or all children of given node.
	 * 
	 * @param store  controller can support more than one tree, ONOS can default define a NE-Config tree and app also define its tree. 
	 * LogicalTreeType is the identifier  of tree.
	 * @param path  specific path must be present.
	 * @param mode  enum type, listen a node or a subtree.
	 * @param listener
	 */
	void registerTreeNodeChangeListener(LogicalTreeType store, YangNodeInstancePath treeId, Mode mode, YangTreeNodeChangeListener listener);
	
	/**
	 * Register a tree into tree store in order to support multi-tree.
	 *  
	 * @param store
	 * @param clazz the root for some tree.
	 */
	void registerTree(LogicalTreeType store, Class clazz);
	
	void unRegisterTree(LogicalTreeType store, Class clazz);
}