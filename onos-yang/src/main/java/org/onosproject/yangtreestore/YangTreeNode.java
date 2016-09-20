package org.onosproject.yangtreestore;

/**
*
* Node which is normalized according to the YANG schema
* is identifiable by {@link YangInstanceIdentifier}.
*
* See subinterfaces of this interface for concretization
* of node.
*
* @param <K> Local identifier of node
* @param <V> Value of node
*/
public interface YangTreeNode <K extends YangNodeInstancePath, V> {
    /**
     * Module Key of the node as defined in YANG schema.
     *
     * @return QName of this node, non-null.
     */
	ModuleKey getNodeType();

    /**
     * Locally unique identifier of the node.
     *
     * @return Node identifier, non-null.
     */
    K getIdentifier();

    /**
     * Value of node.
     *
     * @return Value of the node, may be null.
     */
    V getValue();
}
