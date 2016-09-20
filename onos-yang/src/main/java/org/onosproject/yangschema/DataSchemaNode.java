package org.onosproject.yangschema;

import java.util.Collection;

import org.onosproject.yangtreestore.ModuleKey;

/**
 * Data Schema Node represents abstract supertype from which all data tree
 * definitions are derived.
 * 
 * @author j00310553
 *
 */
public interface DataSchemaNode {

	/**
     * Returns set of all child nodes defined within this DataNodeContainer.
     * Although the return type is a collection, each node is guaranteed to
     * be present at most once.
     *
     * @return child nodes in lexicographical order
     */
    Collection<DataSchemaNode> getChildNodes();

    /**
     * @param name
     *            QName of seeked child
     * @return child node of this DataNodeContainer if child with given name is
     *         present, null otherwise
     */
    DataSchemaNode getDataChildByName(ModuleKey name);

    /**
     * @param name
     *            name of seeked child as String
     * @return child node of this DataNodeContainer if child with given name is
     *         present, null otherwise
     */
    DataSchemaNode getDataChildByName(String name);
}
