/*
 *Copyright (c) 2014 Cisco Systems, Inc. and others. All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/www.eclipse.org/legal/epl-v10.html
 */
package org.onosproject.yangtree;


public interface YangTreeStore {
	
	CheckedFuture<Optional<YangTreeNode>,ReadFailedException> get(LogicalTreeType store, YangTreePath path, Filter filter);
	
	CheckedFuture<FailedException> write(LogicalTreeType store, YangTreePath path, YangTreeNode data);
	
	CheckedFuture<FailedException> update(LogicalTreeType store, YangTreePath path, YangTreeNode data);
	
	CheckedFuture<FailedException> delete(LogicalTreeType store, YangTreePath path);
	
	<L extends YangTreeNodeChangeListener> ListenerRegistration<L> registerTreeNodeChangeListener(YangTreePath treeId, L listener);

}
