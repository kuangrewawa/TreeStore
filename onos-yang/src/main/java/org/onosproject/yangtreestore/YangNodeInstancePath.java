package org.onosproject.yangtreestore;

public interface YangNodeInstancePath {

	/**
	 * Returns the parent path.
	 * @return
	 */
	public YangNodeInstancePath getParent();
	
	/**
	 * Returns the module identifier.
	 * 
	 * @return
	 */
	public ModuleKey getModuleKey();
}
